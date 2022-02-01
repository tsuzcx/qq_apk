package com.tencent.avgame.gameroom;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.app.MSFNetInfoMonitor;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistManager;
import com.tencent.avgame.gamelogic.data.AVRes;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.TopicOperGuessVideo;
import com.tencent.avgame.gamelogic.data.TopicSongGuess;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.GameStatusListener;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.gameroom.gamelist.IGameListPresenter;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.pkstage.ISurvivalStagePresenter;
import com.tencent.avgame.gameroom.seat.ISeatPresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.gameroom.video.IAVControlUiPresenter;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.AVGameMediaFileInfo;
import com.tencent.avgame.qav.AVGameMediaPlayerCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.video.VideoRouter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GameRoomPresenterImp
  implements Handler.Callback, GameRoomStatusListener, GameStatusListener, IGameRoomPresenter
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  protected Context a;
  protected DialogInterface.OnClickListener a;
  protected Handler a;
  protected AVGameUIEventCallback a;
  protected GameRoomPresenterImp.MyNetObserver a;
  protected IGameRoomView a;
  protected IGameListPresenter a;
  protected IOverlayPresenter a;
  protected ISurvivalStagePresenter a;
  protected ISeatPresenter a;
  protected IStagePresenter a;
  protected IStageRecordPresenter a;
  protected IAVControlUiPresenter a;
  public Runnable a;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  
  public GameRoomPresenterImp(IGameRoomView paramIGameRoomView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomPresenterImp$MyNetObserver = null;
    this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback = new GameRoomPresenterImp.1(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new GameRoomPresenterImp.2(this);
    this.jdField_a_of_type_JavaLangRunnable = new GameRoomPresenterImp.3(this);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView = paramIGameRoomView;
  }
  
  private void a(int paramInt1, int paramInt2, EngineData paramEngineData)
  {
    String str = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject = paramEngineData.a();
      if ((localObject == null) || (!(localObject instanceof TopicOperGuessVideo))) {}
    }
    for (Object localObject = (TopicOperGuessVideo)localObject;; localObject = null)
    {
      AVGameMediaPlayerCtrl localAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().a();
      boolean bool1;
      if ((!paramEngineData.jdField_a_of_type_Boolean) || ((paramEngineData.jdField_a_of_type_Boolean) && (paramEngineData.h())))
      {
        bool1 = true;
        if ((localAVGameMediaPlayerCtrl != null) || (bool1)) {
          break label438;
        }
        localAVGameMediaPlayerCtrl = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();
      }
      label420:
      label429:
      label438:
      for (;;)
      {
        long l1;
        if ((localObject != null) && (!TextUtils.isEmpty(((TopicOperGuessVideo)localObject).a.jdField_a_of_type_JavaLangString)))
        {
          if (localAVGameMediaPlayerCtrl == null) {
            break label429;
          }
          str = ((TopicOperGuessVideo)localObject).a.jdField_a_of_type_JavaLangString;
          localAVGameMediaPlayerCtrl.a(false);
          if ((paramInt1 == 3) || (paramInt1 == 4) || (paramEngineData.a().d() >= paramEngineData.a().f())) {
            break label420;
          }
          long l2 = paramEngineData.a().d();
          l1 = l2;
          if (l2 > ((TopicOperGuessVideo)localObject).a.jdField_a_of_type_Int * 1000) {
            l1 = 0L;
          }
          if ((!localAVGameMediaPlayerCtrl.a()) || (!TextUtils.equals(str, localAVGameMediaPlayerCtrl.a()))) {
            if (l1 > 500L)
            {
              localAVGameMediaPlayerCtrl.a(str, l1, bool1);
              label247:
              paramEngineData = str;
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("GameRoomPresenterImp", 2, "playStarGuessVideo topic:" + localObject + " url:" + paramEngineData + " stop:" + bool1 + " gameStatus:" + paramInt1);
          }
          return;
          bool1 = false;
          break;
          localAVGameMediaPlayerCtrl.a(str, 0L, bool1);
          break label247;
          if (l1 - localAVGameMediaPlayerCtrl.a() <= 500L) {
            break label247;
          }
          break label247;
          if (localAVGameMediaPlayerCtrl != null)
          {
            localAVGameMediaPlayerCtrl.b();
            if (!bool1) {
              localAVGameMediaPlayerCtrl.d();
            }
          }
          label371:
          for (boolean bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            paramEngineData = str;
            if (paramInt2 != 3) {
              break;
            }
            this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(false);
            bool1 = bool2;
            paramEngineData = str;
            break;
            localAVGameMediaPlayerCtrl.c();
            break label371;
          }
          paramEngineData = str;
          bool1 = false;
          continue;
          bool1 = false;
          paramEngineData = str;
        }
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, EngineData paramEngineData)
  {
    String str = null;
    boolean bool2 = false;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject = paramEngineData.a();
      if ((localObject == null) || (!(localObject instanceof TopicSongGuess))) {}
    }
    for (Object localObject = (TopicSongGuess)localObject;; localObject = null)
    {
      AVGameMediaPlayerCtrl localAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().a();
      int i;
      if ((!paramEngineData.jdField_a_of_type_Boolean) || ((paramEngineData.jdField_a_of_type_Boolean) && (paramEngineData.h())))
      {
        i = 1;
        if ((localAVGameMediaPlayerCtrl != null) || (i != 0)) {
          break label388;
        }
        localAVGameMediaPlayerCtrl = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();
      }
      label388:
      for (;;)
      {
        boolean bool1;
        long l1;
        if ((localObject != null) && (!TextUtils.isEmpty(((TopicSongGuess)localObject).a.jdField_a_of_type_JavaLangString)))
        {
          bool1 = bool2;
          if (localAVGameMediaPlayerCtrl != null)
          {
            str = ((TopicSongGuess)localObject).a.jdField_a_of_type_JavaLangString;
            localAVGameMediaPlayerCtrl.a(false);
            if ((paramInt1 == 3) || (paramInt1 == 4)) {
              break label381;
            }
            long l2 = paramEngineData.a().d();
            l1 = l2;
            if (l2 > ((TopicSongGuess)localObject).a.jdField_a_of_type_Int * 1000) {
              l1 = 0L;
            }
            if ((localAVGameMediaPlayerCtrl.a()) && (TextUtils.equals(str, localAVGameMediaPlayerCtrl.a()))) {
              break label318;
            }
            if (l1 <= 500L) {
              break label307;
            }
            localAVGameMediaPlayerCtrl.a(str, l1);
            label235:
            bool1 = bool2;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("GameRoomPresenterImp", 2, "playStarGuessVideo topic:" + localObject + " url:" + str + " stop:" + bool1 + " gameStatus:" + paramInt1);
          }
          return;
          i = 0;
          break;
          label307:
          localAVGameMediaPlayerCtrl.a(str, 0L);
          break label235;
          label318:
          if (l1 - localAVGameMediaPlayerCtrl.a() <= 500L) {
            break label235;
          }
          break label235;
          if (localAVGameMediaPlayerCtrl != null)
          {
            localAVGameMediaPlayerCtrl.b();
            if (i == 0) {
              localAVGameMediaPlayerCtrl.d();
            }
          }
          label356:
          for (bool1 = true;; bool1 = false)
          {
            if (paramInt2 == 4) {}
            break;
            localAVGameMediaPlayerCtrl.c();
            break label356;
          }
          label381:
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, EngineData paramEngineData)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject3;
    Object localObject2;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = paramEngineData.a();
      if ((localObject1 != null) && ((localObject1 instanceof TopicOperGuessVideo)))
      {
        localObject1 = (TopicOperGuessVideo)localObject1;
        localObject3 = paramEngineData.b();
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localObject3 = AVGameBusinessCtrl.b().a();
      if ((!paramEngineData.jdField_a_of_type_Boolean) || ((paramEngineData.jdField_a_of_type_Boolean) && (paramEngineData.h())))
      {
        paramInt1 = 1;
        if ((localObject3 != null) || (paramInt1 != 0)) {
          break label384;
        }
      }
      label384:
      for (paramEngineData = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();; paramEngineData = (EngineData)localObject3)
      {
        if ((localObject2 != null) && (paramEngineData != null))
        {
          localObject3 = new AVGameMediaFileInfo();
          ((AVGameMediaFileInfo)localObject3).jdField_a_of_type_JavaLangString = localObject2.a.jdField_a_of_type_JavaLangString;
          ((AVGameMediaFileInfo)localObject3).jdField_a_of_type_Long = (localObject2.a.jdField_a_of_type_Int * 1000);
          ((AVGameMediaFileInfo)localObject3).b = localObject2.a.b;
          localArrayList.add(localObject3);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            paramInt1 = i;
            for (;;)
            {
              if (paramInt1 < ((List)localObject1).size())
              {
                Object localObject4 = (ITopic)((List)localObject1).get(paramInt1);
                if ((localObject4 != null) && ((localObject4 instanceof TopicOperGuessVideo)))
                {
                  localObject3 = new AVGameMediaFileInfo();
                  localObject4 = (TopicOperGuessVideo)localObject4;
                  ((AVGameMediaFileInfo)localObject3).jdField_a_of_type_JavaLangString = ((TopicOperGuessVideo)localObject4).a.jdField_a_of_type_JavaLangString;
                  ((AVGameMediaFileInfo)localObject3).b = ((TopicOperGuessVideo)localObject4).a.b;
                  ((AVGameMediaFileInfo)localObject3).jdField_a_of_type_Long = (((TopicOperGuessVideo)localObject4).a.jdField_a_of_type_Int * 1000);
                  localArrayList.add(localObject3);
                }
                paramInt1 += 1;
                continue;
                paramInt1 = 0;
                break;
              }
            }
          }
          paramEngineData.a(localArrayList);
        }
        if (QLog.isColorLevel()) {
          QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo  PreloadVideo videoTopic:" + localObject2 + " files:" + localArrayList);
        }
        return;
      }
      localObject1 = null;
      break;
      localObject2 = null;
    }
  }
  
  private void d(int paramInt1, int paramInt2, EngineData paramEngineData)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject3;
    Object localObject2;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = paramEngineData.a();
      if ((localObject1 != null) && ((localObject1 instanceof TopicSongGuess)))
      {
        localObject1 = (TopicSongGuess)localObject1;
        localObject3 = paramEngineData.b();
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localObject3 = AVGameBusinessCtrl.b().a();
      if ((!paramEngineData.jdField_a_of_type_Boolean) || ((paramEngineData.jdField_a_of_type_Boolean) && (paramEngineData.h())))
      {
        paramInt1 = 1;
        if ((localObject3 != null) || (paramInt1 != 0)) {
          break label359;
        }
      }
      label359:
      for (paramEngineData = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();; paramEngineData = (EngineData)localObject3)
      {
        if ((localObject2 != null) && (paramEngineData != null))
        {
          localObject3 = new AVGameMediaFileInfo();
          ((AVGameMediaFileInfo)localObject3).jdField_a_of_type_JavaLangString = localObject2.a.jdField_a_of_type_JavaLangString;
          ((AVGameMediaFileInfo)localObject3).jdField_a_of_type_Long = (localObject2.a.jdField_a_of_type_Int * 1000);
          localArrayList.add(localObject3);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            paramInt1 = i;
            for (;;)
            {
              if (paramInt1 < ((List)localObject1).size())
              {
                Object localObject4 = (ITopic)((List)localObject1).get(paramInt1);
                if ((localObject4 != null) && ((localObject4 instanceof TopicSongGuess)))
                {
                  localObject3 = new AVGameMediaFileInfo();
                  localObject4 = (TopicSongGuess)localObject4;
                  ((AVGameMediaFileInfo)localObject3).jdField_a_of_type_JavaLangString = ((TopicSongGuess)localObject4).a.jdField_a_of_type_JavaLangString;
                  ((AVGameMediaFileInfo)localObject3).jdField_a_of_type_Long = (((TopicSongGuess)localObject4).a.jdField_a_of_type_Int * 1000);
                  localArrayList.add(localObject3);
                }
                paramInt1 += 1;
                continue;
                paramInt1 = 0;
                break;
              }
            }
          }
          paramEngineData.a(localArrayList);
        }
        if (QLog.isColorLevel()) {
          QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo PreloadAudio videoTopic:" + localObject2 + " files:" + localArrayList);
        }
        return;
      }
      localObject1 = null;
      break;
      localObject2 = null;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1000L);
  }
  
  private void f()
  {
    Object localObject1 = GameEngine.a().a();
    int i = ((EngineData)localObject1).a();
    boolean bool1 = ((EngineData)localObject1).d();
    Player localPlayer = ((EngineData)localObject1).a();
    boolean bool2;
    label66:
    AVGameUserInfo localAVGameUserInfo1;
    label82:
    AVGameUserInfo localAVGameUserInfo2;
    label98:
    label113:
    boolean bool3;
    label129:
    boolean bool4;
    label145:
    boolean bool5;
    label161:
    boolean bool7;
    boolean bool8;
    boolean bool9;
    long l;
    Object localObject2;
    boolean bool6;
    if (bool1)
    {
      localObject1 = ((EngineData)localObject1).b();
      if ((localPlayer == null) || (localObject1 == null) || (!TextUtils.equals(localPlayer.uin, ((Player)localObject1).uin))) {
        break label591;
      }
      bool2 = true;
      if (localPlayer == null) {
        break label596;
      }
      localAVGameUserInfo1 = a(localPlayer.uin);
      if (localObject1 == null) {
        break label602;
      }
      localAVGameUserInfo2 = a(((Player)localObject1).uin);
      if ((localAVGameUserInfo1 == null) || (localAVGameUserInfo1.mMicOn)) {
        break label608;
      }
      bool1 = true;
      if ((localAVGameUserInfo1 == null) || (localAVGameUserInfo1.hasCameraVideo())) {
        break label613;
      }
      bool3 = true;
      if ((localAVGameUserInfo2 == null) || (localAVGameUserInfo2.mMicOn)) {
        break label619;
      }
      bool4 = true;
      if ((localAVGameUserInfo2 == null) || (localAVGameUserInfo2.hasCameraVideo())) {
        break label625;
      }
      bool5 = true;
      bool7 = true;
      bool8 = this.jdField_c_of_type_Boolean;
      bool9 = this.jdField_b_of_type_Boolean;
      l = this.jdField_b_of_type_Long;
      localObject2 = AVGameBusinessCtrl.b().a();
      bool6 = bool1;
      if (localObject2 != null) {
        bool6 = ((AVGameSession)localObject2).e;
      }
      bool1 = bool7;
      if (i != 0)
      {
        bool1 = bool7;
        if (i != 10)
        {
          if (!bool2) {
            break label681;
          }
          if (!bool6) {
            break label631;
          }
          bool1 = false;
          a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690354));
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool6;
      if (bool1) {
        b(1);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("gameStatus:").append(i).append("\n");
        ((StringBuffer)localObject2).append("self:").append(localPlayer).append("\n");
        ((StringBuffer)localObject2).append("player:").append(localObject1).append("\n");
        ((StringBuffer)localObject2).append("isSelfPlaying:").append(bool2).append("\n");
        ((StringBuffer)localObject2).append("selfAV:").append(localAVGameUserInfo1).append("\n");
        ((StringBuffer)localObject2).append("playerAV:").append(localAVGameUserInfo2).append("\n");
        ((StringBuffer)localObject2).append("isSelfNoOpenAudio:").append(bool6).append("\n");
        ((StringBuffer)localObject2).append("isSelfNoOpenCamera:").append(bool3).append("\n");
        ((StringBuffer)localObject2).append("isPlayerNoOpenAudio:").append(bool4).append("\n");
        ((StringBuffer)localObject2).append("isPlayerNoOpenCamera:").append(bool5).append("\n");
        ((StringBuffer)localObject2).append("noPermanentTip:").append(bool1).append("\n");
        ((StringBuffer)localObject2).append("selfAudioTipShowed:").append(bool9).append("\n");
        ((StringBuffer)localObject2).append("lastIsSelfAudioNoOpen:").append(bool8).append("\n");
        ((StringBuffer)localObject2).append("lastOtherAVPlayingTipUin:").append(l).append("\n");
        QLog.d("GameRoomPresenterImp", 2, "checkAndShowAVStatusTips|" + ((StringBuffer)localObject2).toString());
      }
      return;
      localObject1 = null;
      break;
      label591:
      bool2 = false;
      break label66;
      label596:
      localAVGameUserInfo1 = null;
      break label82;
      label602:
      localAVGameUserInfo2 = null;
      break label98;
      label608:
      bool1 = false;
      break label113;
      label613:
      bool3 = false;
      break label129;
      label619:
      bool4 = false;
      break label145;
      label625:
      bool5 = false;
      break label161;
      label631:
      bool1 = bool7;
      if (bool3)
      {
        bool7 = false;
        bool1 = bool7;
        if (!GameEngine.a().a().a().opened_match)
        {
          a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690355));
          bool1 = bool7;
          continue;
          label681:
          if ((bool6) && (!this.jdField_c_of_type_Boolean))
          {
            this.jdField_b_of_type_Boolean = true;
            a(this.jdField_a_of_type_AndroidContentContext.getString(2131690350), 3000);
            bool1 = bool7;
          }
          else if ((bool6) && (!this.jdField_b_of_type_Boolean))
          {
            this.jdField_b_of_type_Boolean = true;
            a(this.jdField_a_of_type_AndroidContentContext.getString(2131690350));
            bool1 = bool7;
          }
          else if ((bool4) && (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin))
          {
            this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
            a(this.jdField_a_of_type_AndroidContentContext.getString(2131690351));
            bool1 = bool7;
          }
          else
          {
            bool1 = bool7;
            if (bool5)
            {
              bool1 = bool7;
              if (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin)
              {
                this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
                a(this.jdField_a_of_type_AndroidContentContext.getString(2131690352));
                bool1 = bool7;
              }
            }
          }
        }
      }
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable()");
    }
    m();
    long l = GameEngine.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() nextRefreshTimeInterval = " + l);
    }
    if (l != 9223372036854775807L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() postRunnable and nextRefreshTimeInterval = " + l);
      }
      com.tencent.qav.thread.ThreadManager.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l * 1000L + 2000L);
    }
  }
  
  private void m()
  {
    com.tencent.qav.thread.ThreadManager.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void n()
  {
    GameEngine.a().f();
  }
  
  private void n(EngineData paramEngineData)
  {
    paramEngineData = paramEngineData.i();
    if (!TextUtils.isEmpty(paramEngineData)) {
      a(paramEngineData, 1000);
    }
  }
  
  private void o(EngineData paramEngineData)
  {
    Object localObject = paramEngineData.a().d;
    if (localObject == null) {}
    while (GameEngine.a().a().getCurrentAccountUin().equals(((Player)localObject).uin)) {
      return;
    }
    boolean bool = AVGamePerfReporter.a();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    String str1 = paramEngineData.a().a().b();
    String str2 = paramEngineData.b();
    String str3 = ((Player)localObject).uin;
    if (bool) {}
    for (localObject = AVGamePerfReporter.a().a();; localObject = "")
    {
      localAVGamePerfReporter.a(bool, "others", str1, 0L, str2, str3, (String)localObject, paramEngineData.a());
      return;
    }
  }
  
  private void p(EngineData paramEngineData)
  {
    Player localPlayer;
    int i;
    if ((paramEngineData.c() == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 3000L))
    {
      localPlayer = paramEngineData.a();
      paramEngineData = paramEngineData.b();
      if ((localPlayer == null) || (paramEngineData == null) || (!TextUtils.equals(localPlayer.uin, paramEngineData.uin))) {
        break label177;
      }
      i = 1;
      if (localPlayer == null) {
        break label182;
      }
    }
    label177:
    label182:
    for (paramEngineData = a(localPlayer.uin);; paramEngineData = null)
    {
      if ((i != 0) && (paramEngineData != null))
      {
        if (!paramEngineData.hasVideo()) {
          ReportController.b(null, "dc00898", "", "", "0X800B03E", "0X800B03E", 0, 0, "", "", "", "");
        }
        paramEngineData = AVGameBusinessCtrl.b().a();
        if ((paramEngineData != null) && (paramEngineData.e)) {
          ReportController.b(null, "dc00898", "", "", "0X800B03F", "0X800B03F", 0, 0, "", "", "", "");
        }
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      i = 0;
      break;
    }
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a();
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a();
  }
  
  public IGameRoomView a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView;
  }
  
  public IOverlayPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomOverlayIOverlayPresenter;
  }
  
  public ISeatPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter;
  }
  
  public IStageRecordPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter;
  }
  
  public AVGameUserInfo a(String paramString)
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    if (localAVGameSession != null) {
      return localAVGameSession.a(Long.valueOf(paramString).longValue());
    }
    return null;
  }
  
  public String a()
  {
    String str = "";
    GameItem localGameItem = GameEngine.a().a().a();
    if (localGameItem != null) {
      str = localGameItem.e;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareTransparentBgURL = " + str);
    }
    return str;
  }
  
  public List<MemberVideoDisplayInfo> a()
  {
    List localList = b();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.b();
    if (localObject1 != null) {
      localArrayList.addAll((Collection)localObject1);
    }
    RectF localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a();
    Object localObject2 = null;
    localObject1 = null;
    if (localRectF != null)
    {
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= localArrayList.size()) {
          break;
        }
        localObject2 = (MemberVideoDisplayInfo)localArrayList.get(i);
        if (((MemberVideoDisplayInfo)localObject2).jdField_b_of_type_Boolean)
        {
          ((MemberVideoDisplayInfo)localObject2).jdField_a_of_type_Int = Math.round(localRectF.left);
          ((MemberVideoDisplayInfo)localObject2).jdField_b_of_type_Int = Math.round(localRectF.top);
          ((MemberVideoDisplayInfo)localObject2).jdField_c_of_type_Int = Math.round(localRectF.width());
          ((MemberVideoDisplayInfo)localObject2).d = Math.round(localRectF.height());
          localObject1 = localObject2;
        }
        if (((MemberVideoDisplayInfo)localObject2).jdField_c_of_type_Boolean)
        {
          ((MemberVideoDisplayInfo)localObject2).f = Math.round(localRectF.left);
          ((MemberVideoDisplayInfo)localObject2).g = Math.round(localRectF.top);
          ((MemberVideoDisplayInfo)localObject2).h = Math.round(localRectF.width());
          ((MemberVideoDisplayInfo)localObject2).i = Math.round(localRectF.height());
        }
        i += 1;
      }
    }
    QLog.i("GameRoomPresenterImp", 1, "getMemberVideoDisplayInfoList bigVideoInfo:" + localObject2 + "  playingRect:" + localRectF + " displayList:" + localArrayList + " aVList:" + localList);
    return localArrayList;
  }
  
  public void a()
  {
    EngineData localEngineData = GameEngine.a().a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 1000L);
    m(localEngineData);
    k(localEngineData);
    l();
    QLog.i("GameRoomPresenterImp", 1, "onFragmentStart");
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 0L);
      return;
    }
    if ((GameEngine.a().f()) && (!GameEngine.a().g()))
    {
      RectF localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a();
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(localRectF);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.b(GameEngine.a().a());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.b(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, EngineData paramEngineData)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomOtherMemberExit exitType:" + paramInt + " kickUin:" + paramString1 + " exitRoomTip:" + paramString2 + " engineData:" + paramEngineData);
    if (3 == paramInt) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString2, null);
    }
    for (;;)
    {
      i(paramEngineData);
      a(-1);
      return;
      a(paramString2);
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramLong, paramInt, paramString1, paramString2);
    }
    EngineData localEngineData = GameEngine.a().a();
    String str3 = "";
    String str2 = "";
    Object localObject1 = str2;
    if (paramString2 != null) {
      localObject1 = str2;
    }
    for (;;)
    {
      try
      {
        int i = paramString2.lastIndexOf("]");
        Object localObject2 = str2;
        str1 = str3;
        if (i >= 0)
        {
          localObject1 = str2;
          str2 = paramString2.substring(i + 2);
          localObject1 = str2;
          str1 = paramString2.substring(0, i + 1);
          localObject1 = str2;
          i = str1.indexOf("[");
          localObject1 = str2;
          int j = str1.indexOf("]");
          localObject2 = str2;
          str1 = str3;
          if (i >= 0)
          {
            localObject2 = str2;
            str1 = str3;
            if (j >= 0)
            {
              localObject2 = str2;
              str1 = str3;
              if (i < j)
              {
                localObject1 = str2;
                paramString2 = paramString2.substring(i + 1, j);
                localObject2 = str2;
                str1 = str3;
                if (paramString2 != null)
                {
                  localObject1 = str2;
                  paramString2 = paramString2.split("\\|");
                  localObject2 = str2;
                  str1 = str3;
                  if (paramString2 != null)
                  {
                    localObject2 = str2;
                    str1 = str3;
                    localObject1 = str2;
                    if (paramString2.length > 0)
                    {
                      str1 = paramString2[0];
                      localObject2 = str2;
                    }
                  }
                }
              }
            }
          }
        }
        paramString2 = (String)localObject2;
        localObject1 = str1;
        localObject2 = AVGamePerfReporter.a();
        if (localEngineData.a().a() == null) {
          break label345;
        }
        str1 = localEngineData.a().a().b();
        ((AVGamePerfReporter)localObject2).a(false, paramString2, str1, paramInt, paramString1, String.valueOf(paramLong), (String)localObject1, localEngineData.a());
        return;
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
      paramString2 = (String)localObject1;
      localObject1 = "";
      continue;
      label345:
      String str1 = "";
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    i(GameEngine.a().a());
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    EngineData localEngineData = GameEngine.a().a();
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(localEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(localEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public void a(Context paramContext, IGameListPresenter paramIGameListPresenter, IStagePresenter paramIStagePresenter, ISeatPresenter paramISeatPresenter, IOverlayPresenter paramIOverlayPresenter, IAVControlUiPresenter paramIAVControlUiPresenter, IStageRecordPresenter paramIStageRecordPresenter, ISurvivalStagePresenter paramISurvivalStagePresenter)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter = paramIGameListPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter = paramISeatPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayIOverlayPresenter = paramIOverlayPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter = paramIAVControlUiPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter = paramIStageRecordPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter = paramISurvivalStagePresenter;
    GameEngine.a().a(this);
    GameEngine.a().a(this);
    AVGameBusinessCtrl.b().a(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomPresenterImp$MyNetObserver == null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomPresenterImp$MyNetObserver = new GameRoomPresenterImp.MyNetObserver(this.jdField_a_of_type_AndroidOsHandler);
      ObserverCenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomPresenterImp$MyNetObserver, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "init");
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramEngineData);
    AVGamePerfReporter.a().a("param_StepGameReady", 0);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a()) {
      AVGamePerfReporter.a().a("param_StepGameCanStart");
    }
    l();
  }
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.d();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(false);
    }
    i(paramEngineData);
    QLog.d("GameRoomPresenterImp", 2, "onChangeUserStatusSuccess");
    com.tencent.mobileqq.app.ThreadManager.excute(new GameRoomPresenterImp.7(this), 16, null, false);
  }
  
  public void a(EngineData paramEngineData, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramString, paramEngineData.c());
  }
  
  public void a(EngineData paramEngineData, boolean paramBoolean)
  {
    AVGamePerfReporter.a().a(false, paramEngineData.a());
    if (paramEngineData.f())
    {
      e(false);
      k(paramEngineData);
      l(paramEngineData);
      return;
    }
    GameRoomPresenterImp.9 local9 = new GameRoomPresenterImp.9(this);
    if (paramBoolean)
    {
      com.tencent.qav.thread.ThreadManager.a().postDelayed(local9, 1560L);
      i(paramEngineData);
    }
    for (;;)
    {
      e();
      k(paramEngineData);
      l(paramEngineData);
      return;
      local9.run();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 3) && ((paramInt1 == 113) || (paramInt1 == 109)))
    {
      paramString = a().getResources().getString(2131690591);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(1, paramString);
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(GameEngine.a().a().getAccount())) && (paramInt == 1))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.d();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(false);
    }
    i(paramEngineData);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onGameStartFail uin:" + paramString1 + " gameType:" + paramInt1 + " roomId:" + paramLong + " errorCode " + paramInt2 + " errMsg:" + paramString2);
    }
    if (paramInt2 == 404)
    {
      paramString1 = a().getResources().getString(2131690397);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString1, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(GameEngine.a().a());
      return;
      if (paramInt2 == 405)
      {
        paramString1 = a().getResources().getString(2131690584);
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(1, paramString1);
        i(GameEngine.a().a());
      }
      else if ((paramInt2 == 406) && (paramString2 != null) && (paramString2.length() > 0))
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString2, null);
      }
      else if (paramInt2 != 408)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(1, "开始游戏失败");
      }
    }
  }
  
  public void a(String paramString, EngineData paramEngineData)
  {
    i(paramEngineData);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
  }
  
  public void a(boolean paramBoolean)
  {
    Player localPlayer = GameEngine.a().a().a();
    ReportController.b(null, "dc00898", "", "", "0X800B035", "0X800B035", FloatWindowController.a().a(localPlayer) + 1, 0, "1", "", "", "");
    FloatWindowController.a().a(a(), paramBoolean, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "exitGameRoom svrAlreadyExit:" + paramBoolean);
    }
    if (paramInt != 3) {
      n();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.f();
    GameEngine.a().a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
    if ((!paramBoolean) && (GameEngine.a().i())) {
      if (GameEngine.a().a().m()) {
        break label55;
      }
    }
    label55:
    for (paramBoolean = true;; paramBoolean = false)
    {
      CJSurvivalFestivalReporter.a(6, true, String.valueOf(paramInt), null, paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      paramString = GameEngine.a().a();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(false);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter.a(paramString);
      }
      if ((paramBoolean2) && (paramString.g()))
      {
        n(paramString);
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString);
      }
      return;
    }
    String str = paramString;
    if (paramInt != 650) {
      if (paramInt != 651) {
        break label132;
      }
    }
    label132:
    for (str = paramString;; str = null)
    {
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131690407);
      }
      GameEngine.a().a(false, 1);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, false);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    paramSurvivalPkResultInfo = GameEngine.a().a();
    paramInt = paramSurvivalPkResultInfo.o();
    if ((paramInt == 6) || (paramInt == 7))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.c();
      com.tencent.qav.thread.ThreadManager.a().postDelayed(new GameRoomPresenterImp.5(this, paramSurvivalPkResultInfo), 2000L);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramSurvivalPkResultInfo);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramSurvivalPkResultInfo);
    } while (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter == null);
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter.a(paramSurvivalPkResultInfo);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramString = GameEngine.a().a();
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramString);
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramString);
      return;
    }
    if (paramInt2 == 601) {}
    for (;;)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131690540);
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(str, null);
      return;
      paramString = null;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    paramString = GameEngine.a().a();
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramString);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramString);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramArrayOfByte = GameEngine.a().a();
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramArrayOfByte);
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.e();
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramArrayOfByte);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(false);
      return;
    }
    if (paramInt2 == 750) {}
    for (;;)
    {
      paramArrayOfByte = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramArrayOfByte = this.jdField_a_of_type_AndroidContentContext.getString(2131690540);
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramArrayOfByte, null);
      return;
      paramString = null;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter.a(GameEngine.a().a());
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString, new GameRoomPresenterImp.4(this), false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " engineData:" + paramEngineData);
    if ((GameEngine.a().i()) && (paramInt != 1)) {
      if (GameEngine.a().a().m()) {
        break label185;
      }
    }
    label185:
    for (boolean bool = true;; bool = false)
    {
      CJSurvivalFestivalReporter.a(12, true, String.valueOf(paramInt), paramString, bool);
      switch (paramInt)
      {
      case 0: 
      case 12: 
      default: 
        a(true, paramInt);
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.e();
      case -2: 
      case -1: 
      case 1: 
      case 2: 
        return true;
      }
    }
    a(true, paramInt);
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    return true;
    a(false, paramInt);
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    return true;
    a(false, paramInt);
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.e();
    return true;
    paramEngineData = paramString;
    if (paramString == null) {
      paramEngineData = this.jdField_a_of_type_AndroidContentContext.getString(2131690497);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramEngineData, new GameRoomPresenterImp.8(this));
    return true;
  }
  
  public String b()
  {
    String str = "";
    GameItem localGameItem = GameEngine.a().a().a();
    if (localGameItem != null) {
      str = localGameItem.d;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareBgURL = " + str);
    }
    return str;
  }
  
  public List<AVGameUserInfo> b()
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    ArrayList localArrayList = new ArrayList();
    if (localAVGameSession != null) {
      localAVGameSession.b(localArrayList);
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    m();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.b(paramInt);
  }
  
  public void b(long paramLong, String paramString1, String paramString2) {}
  
  public void b(EngineData paramEngineData)
  {
    if (!GameEngine.a().a()) {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramEngineData);
    }
  }
  
  public void b(EngineData paramEngineData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "onAnswerRightPush scoreThisTime = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramEngineData);
    o(paramEngineData);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.b(paramString);
  }
  
  public void b(String paramString, EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnRoomEnter roomEnterTip = " + paramString);
    }
    a().h();
    a(paramString);
    i(paramEngineData);
    if ((paramEngineData.e()) && (paramEngineData.a(paramEngineData.e(GameEngine.a().a().getCurrentAccountUin()))))
    {
      if (AVGameUtils.b() == 2) {
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.h();
      }
    }
    else {
      return;
    }
    n();
    a(a().getResources().getString(2131690469));
  }
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
    if ((!paramBoolean) && (GameEngine.a().i())) {
      if (GameEngine.a().a().m()) {
        break label55;
      }
    }
    label55:
    for (paramBoolean = true;; paramBoolean = false)
    {
      CJSurvivalFestivalReporter.a(7, true, String.valueOf(paramInt), null, paramBoolean);
      return;
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    paramString = GameEngine.a().a();
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramString);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.f();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramString);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(false);
  }
  
  public List<Player> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(GameEngine.a().a().a().getPlayers());
    return localArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.b();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.c();
    AVGameBusinessCtrl.b().b(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    GameEngine.a().b(this);
    GameEngine.a().b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomPresenterImp$MyNetObserver != null)
    {
      ObserverCenter.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomPresenterImp$MyNetObserver);
      this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomPresenterImp$MyNetObserver = null;
    }
  }
  
  public void c(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.b();
    i(paramEngineData);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    n();
    e();
    p(paramEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(true);
    AVGamePerfReporter.a().a(true, paramEngineData.a());
  }
  
  public void c(EngineData paramEngineData, int paramInt)
  {
    i(paramEngineData);
  }
  
  public void c(String paramString, EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "onPushMemberEnterForPk  " + paramString);
    }
    String str = GameEngine.a().a().getCurrentAccountUin();
    if ((paramEngineData.e(str)) && (!str.equals(paramString)))
    {
      boolean bool = AVGameBusinessCtrl.b().e();
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      if (!bool) {
        break label119;
      }
    }
    label119:
    for (long l = 1000L;; l = 2000L)
    {
      paramString.sendEmptyMessageDelayed(10, l);
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramEngineData);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter.a(paramEngineData);
      }
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    e();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.g();
  }
  
  public void d(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramEngineData);
  }
  
  public void d(String paramString, EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramString, paramEngineData);
  }
  
  public void d(boolean paramBoolean)
  {
    e();
  }
  
  public void e(EngineData paramEngineData)
  {
    m(paramEngineData);
  }
  
  public void e(String paramString, EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.b(paramString, paramEngineData);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.b(paramBoolean);
  }
  
  public void f(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.b();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    i(paramEngineData);
    e();
    AVGameHandler.a().a().post(new GameRoomPresenterImp.10(this));
    p(paramEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(true);
    n();
    AVGamePerfReporter.a().a(true, paramEngineData.a());
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(GameEngine.a().a());
  }
  
  public void g(EngineData paramEngineData)
  {
    i(paramEngineData);
    e();
    p(paramEngineData);
  }
  
  public void h()
  {
    if (!GameEngine.a().a()) {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(GameEngine.a().a());
    }
  }
  
  public void h(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramEngineData);
    boolean bool = AVGamePerfReporter.a();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    String str2 = paramEngineData.a().a().b();
    String str3 = paramEngineData.b();
    String str4 = GameEngine.a().a().getCurrentAccountUin();
    if (bool) {}
    for (String str1 = AVGamePerfReporter.a().a();; str1 = "")
    {
      localAVGamePerfReporter.a(bool, "timeout", str2, 0L, str3, str4, str1, paramEngineData.a());
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      do
      {
        do
        {
          do
          {
            return true;
            a(-1);
            return true;
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
            return true;
            this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(GameEngine.a().a());
            return true;
            this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(GameEngine.a().a());
            return true;
            this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(GameEngine.a().a());
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
            this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(GameEngine.a().a());
            return true;
            f();
            return true;
            j(GameEngine.a().a());
            a(0);
            f();
            return true;
          } while (MSFNetInfoMonitor.b() == 1);
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690475));
          ReportController.b(null, "dc00898", "", "", "0X800B040", "0X800B040", 0, 0, "", "", "", "");
          return true;
        } while ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVGameActivity)));
        paramMessage = (AVGameActivity)this.jdField_a_of_type_AndroidContentContext;
      } while (paramMessage.d());
    }
    for (;;)
    {
      int j;
      try
      {
        if ((paramMessage.d()) || (AVGameBusinessCtrl.b().a() != 1)) {
          break label353;
        }
        i = 1;
        j = k;
        if (AVGameBusinessCtrl.b().a() != 0) {
          break label369;
        }
        j = k;
        if (AVGameBusinessCtrl.b().d()) {
          break label369;
        }
        j = 1;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return true;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690348));
      return true;
      label353:
      int i = 0;
      continue;
      GameEngine.a().a(0, null);
      return true;
      label369:
      if (i == 0) {
        if (j == 0) {
          break;
        }
      }
    }
  }
  
  public void i()
  {
    if (!GameEngine.a().a()) {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(GameEngine.a().a());
    }
  }
  
  public void i(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "refreshAll engineData:" + paramEngineData);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramEngineData);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramEngineData);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter.a(paramEngineData);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(paramEngineData);
    }
    j(paramEngineData);
    a(50);
  }
  
  public void j()
  {
    QLog.d("GameRoomPresenterImp", 2, "onPkMatchTimeout");
    if (GameEngine.a().f()) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690498), null);
    }
  }
  
  public void j(EngineData paramEngineData)
  {
    Object localObject2 = null;
    int i = paramEngineData.a();
    Player localPlayer1;
    Object localObject1;
    if ((i != 0) && (i != 10))
    {
      Player localPlayer2 = paramEngineData.b();
      localPlayer1 = localPlayer2;
      localObject1 = localObject2;
      if (localPlayer2 != null)
      {
        localPlayer1 = localPlayer2;
        localObject1 = localObject2;
        if (paramEngineData.b(localPlayer2.uin))
        {
          localObject1 = localPlayer2.uin;
          localPlayer1 = localPlayer2;
        }
      }
    }
    for (;;)
    {
      QLog.i("GameRoomPresenterImp", 1, "playerBigVideoChanged player:" + localPlayer1 + "  gameStatus:" + i + "  gameType:" + paramEngineData.c());
      if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a((String)localObject1);
      }
      return;
      localPlayer1 = null;
      localObject1 = localObject2;
    }
  }
  
  public void k()
  {
    if (GameEngine.a().i()) {
      if (GameEngine.a().a().m()) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      CJSurvivalFestivalReporter.a(5, true, "-1", null, bool);
      QLog.d("GameRoomPresenterImp", 1, "onTopicTimeout");
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690536), this.jdField_a_of_type_AndroidContentContext.getString(2131690537), this.jdField_a_of_type_AndroidContentContext.getString(2131690538), null, new GameRoomPresenterImp.6(this), true);
      return;
    }
  }
  
  public void k(EngineData paramEngineData)
  {
    int i = paramEngineData.a();
    int j = paramEngineData.c();
    if (j == 3) {
      a(i, j, paramEngineData);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPlayAudioVideo gameStatus:" + i + " gameType:" + j);
      }
      return;
      if (j == 4) {
        b(i, j, paramEngineData);
      }
    }
  }
  
  public void l(EngineData paramEngineData)
  {
    AVGameMediaPlayerCtrl localAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().a();
    if ((!paramEngineData.jdField_a_of_type_Boolean) || ((paramEngineData.jdField_a_of_type_Boolean) && (paramEngineData.h()))) {}
    for (int i = 1;; i = 0)
    {
      paramEngineData = localAVGameMediaPlayerCtrl;
      if (localAVGameMediaPlayerCtrl == null)
      {
        paramEngineData = localAVGameMediaPlayerCtrl;
        if (i == 0) {
          paramEngineData = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();
        }
      }
      if (paramEngineData != null) {
        paramEngineData.a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndReleaseAudioVideo");
      }
      return;
    }
  }
  
  public void m(EngineData paramEngineData)
  {
    int i = paramEngineData.a();
    int j = paramEngineData.c();
    if ((i != 0) && (i != 10)) {
      if (j == 3) {
        c(i, j, paramEngineData);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (j != 4);
      d(i, j, paramEngineData);
      return;
    }
    QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo gameStatus:" + i + " gameType:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp
 * JD-Core Version:    0.7.0.1
 */