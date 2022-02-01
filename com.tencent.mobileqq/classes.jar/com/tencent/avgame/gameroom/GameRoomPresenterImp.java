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
import com.tencent.avgame.gameroom.gamelist.IGameListPresenter;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.pkstage.ISurvivalStagePresenter;
import com.tencent.avgame.gameroom.seat.ISeatPresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.gameroom.video.IAVControlUiPresenter;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.AVGameMediaFileInfo;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.video.api.IVideoRouter;
import com.tencent.common.app.business.BaseAVGameAppInterface;
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
    Object localObject3 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = paramEngineData.a();
      if ((localObject1 != null) && ((localObject1 instanceof TopicOperGuessVideo)))
      {
        localObject1 = (TopicOperGuessVideo)localObject1;
        break label50;
      }
    }
    Object localObject1 = null;
    label50:
    Object localObject4 = AVGameBusinessCtrl.b().a();
    boolean bool1 = paramEngineData.jdField_a_of_type_Boolean;
    boolean bool2 = true;
    boolean bool3 = false;
    if ((bool1) && ((!paramEngineData.jdField_a_of_type_Boolean) || (!paramEngineData.h()))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Object localObject2 = localObject4;
    if (localObject4 == null)
    {
      localObject2 = localObject4;
      if (!bool1) {
        localObject2 = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((TopicOperGuessVideo)localObject1).a.jdField_a_of_type_JavaLangString)))
    {
      bool2 = bool3;
      if (localObject2 != null)
      {
        localObject4 = ((TopicOperGuessVideo)localObject1).a.jdField_a_of_type_JavaLangString;
        ((IAVGameMediaPlayerCtrl)localObject2).a(false);
        localObject3 = localObject4;
        bool2 = bool3;
        if (paramInt1 != 3)
        {
          localObject3 = localObject4;
          bool2 = bool3;
          if (paramInt1 != 4)
          {
            localObject3 = localObject4;
            bool2 = bool3;
            if (paramEngineData.a().d() < paramEngineData.a().f())
            {
              long l2 = paramEngineData.a().d();
              long l1 = l2;
              if (l2 > ((TopicOperGuessVideo)localObject1).a.jdField_a_of_type_Int * 1000) {
                l1 = 0L;
              }
              if ((((IAVGameMediaPlayerCtrl)localObject2).a()) && (TextUtils.equals((CharSequence)localObject4, ((IAVGameMediaPlayerCtrl)localObject2).a())))
              {
                ((IAVGameMediaPlayerCtrl)localObject2).a();
                localObject3 = localObject4;
                bool2 = bool3;
              }
              else if (l1 > 500L)
              {
                ((IAVGameMediaPlayerCtrl)localObject2).a((String)localObject4, l1, bool1);
                localObject3 = localObject4;
                bool2 = bool3;
              }
              else
              {
                ((IAVGameMediaPlayerCtrl)localObject2).a((String)localObject4, 0L, bool1);
                localObject3 = localObject4;
                bool2 = bool3;
              }
            }
          }
        }
      }
    }
    else
    {
      if (localObject2 != null)
      {
        ((IAVGameMediaPlayerCtrl)localObject2).b();
        if (!bool1)
        {
          ((IAVGameMediaPlayerCtrl)localObject2).d();
          bool1 = bool2;
        }
        else
        {
          ((IAVGameMediaPlayerCtrl)localObject2).c();
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
      if (paramInt2 == 3) {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(false);
      }
      bool2 = bool1;
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("playStarGuessVideo topic:");
      paramEngineData.append(localObject1);
      paramEngineData.append(" url:");
      paramEngineData.append(localObject3);
      paramEngineData.append(" stop:");
      paramEngineData.append(bool2);
      paramEngineData.append(" gameStatus:");
      paramEngineData.append(paramInt1);
      QLog.i("GameRoomPresenterImp", 2, paramEngineData.toString());
    }
  }
  
  private void b(int paramInt1, int paramInt2, EngineData paramEngineData)
  {
    String str = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = paramEngineData.a();
      if ((localObject1 != null) && ((localObject1 instanceof TopicSongGuess)))
      {
        localObject1 = (TopicSongGuess)localObject1;
        break label50;
      }
    }
    Object localObject1 = null;
    label50:
    Object localObject3 = AVGameBusinessCtrl.b().a();
    boolean bool1 = paramEngineData.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    if ((bool1) && ((!paramEngineData.jdField_a_of_type_Boolean) || (!paramEngineData.h()))) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = localObject3;
      if (paramInt2 == 0) {
        localObject2 = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((TopicSongGuess)localObject1).a.jdField_a_of_type_JavaLangString)))
    {
      localObject3 = str;
      bool1 = bool2;
      if (localObject2 != null)
      {
        str = ((TopicSongGuess)localObject1).a.jdField_a_of_type_JavaLangString;
        ((IAVGameMediaPlayerCtrl)localObject2).a(false);
        localObject3 = str;
        bool1 = bool2;
        if (paramInt1 != 3)
        {
          localObject3 = str;
          bool1 = bool2;
          if (paramInt1 != 4)
          {
            long l2 = paramEngineData.a().d();
            long l1 = l2;
            if (l2 > ((TopicSongGuess)localObject1).a.jdField_a_of_type_Int * 1000) {
              l1 = 0L;
            }
            if ((((IAVGameMediaPlayerCtrl)localObject2).a()) && (TextUtils.equals(str, ((IAVGameMediaPlayerCtrl)localObject2).a())))
            {
              ((IAVGameMediaPlayerCtrl)localObject2).a();
              localObject3 = str;
              bool1 = bool2;
            }
            else if (l1 > 500L)
            {
              ((IAVGameMediaPlayerCtrl)localObject2).a(str, l1);
              localObject3 = str;
              bool1 = bool2;
            }
            else
            {
              ((IAVGameMediaPlayerCtrl)localObject2).a(str, 0L);
              localObject3 = str;
              bool1 = bool2;
            }
          }
        }
      }
    }
    else
    {
      localObject3 = str;
      bool1 = bool2;
      if (localObject2 != null)
      {
        ((IAVGameMediaPlayerCtrl)localObject2).b();
        if (paramInt2 == 0) {
          ((IAVGameMediaPlayerCtrl)localObject2).d();
        } else {
          ((IAVGameMediaPlayerCtrl)localObject2).c();
        }
        bool1 = true;
        localObject3 = str;
      }
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("playStarGuessVideo topic:");
      paramEngineData.append(localObject1);
      paramEngineData.append(" url:");
      paramEngineData.append((String)localObject3);
      paramEngineData.append(" stop:");
      paramEngineData.append(bool1);
      paramEngineData.append(" gameStatus:");
      paramEngineData.append(paramInt1);
      QLog.i("GameRoomPresenterImp", 2, paramEngineData.toString());
    }
  }
  
  private void c(int paramInt1, int paramInt2, EngineData paramEngineData)
  {
    Object localObject1 = null;
    List localList = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject2 = paramEngineData.a();
      localObject1 = localList;
      if (localObject2 != null)
      {
        localObject1 = localList;
        if ((localObject2 instanceof TopicOperGuessVideo)) {
          localObject1 = (TopicOperGuessVideo)localObject2;
        }
      }
      localList = paramEngineData.b();
    }
    else
    {
      localList = null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = AVGameBusinessCtrl.b().a();
    boolean bool = paramEngineData.jdField_a_of_type_Boolean;
    paramInt2 = 0;
    if ((bool) && ((!paramEngineData.jdField_a_of_type_Boolean) || (!paramEngineData.h()))) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramEngineData = (EngineData)localObject2;
    if (localObject2 == null)
    {
      paramEngineData = (EngineData)localObject2;
      if (paramInt1 == 0) {
        paramEngineData = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
      }
    }
    if ((localObject1 != null) && (paramEngineData != null))
    {
      localObject2 = new AVGameMediaFileInfo();
      ((AVGameMediaFileInfo)localObject2).jdField_a_of_type_JavaLangString = ((TopicOperGuessVideo)localObject1).a.jdField_a_of_type_JavaLangString;
      ((AVGameMediaFileInfo)localObject2).jdField_a_of_type_Long = (((TopicOperGuessVideo)localObject1).a.jdField_a_of_type_Int * 1000);
      ((AVGameMediaFileInfo)localObject2).b = ((TopicOperGuessVideo)localObject1).a.b;
      localArrayList.add(localObject2);
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramInt1 = paramInt2;
        while (paramInt1 < localList.size())
        {
          Object localObject3 = (ITopic)localList.get(paramInt1);
          if ((localObject3 != null) && ((localObject3 instanceof TopicOperGuessVideo)))
          {
            localObject2 = new AVGameMediaFileInfo();
            localObject3 = (TopicOperGuessVideo)localObject3;
            ((AVGameMediaFileInfo)localObject2).jdField_a_of_type_JavaLangString = ((TopicOperGuessVideo)localObject3).a.jdField_a_of_type_JavaLangString;
            ((AVGameMediaFileInfo)localObject2).b = ((TopicOperGuessVideo)localObject3).a.b;
            ((AVGameMediaFileInfo)localObject2).jdField_a_of_type_Long = (((TopicOperGuessVideo)localObject3).a.jdField_a_of_type_Int * 1000);
            localArrayList.add(localObject2);
          }
          paramInt1 += 1;
        }
      }
      paramEngineData.a(localArrayList);
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("onNeedCheckAndPreloadAudioVideo  PreloadVideo videoTopic:");
      paramEngineData.append(localObject1);
      paramEngineData.append(" files:");
      paramEngineData.append(localArrayList);
      QLog.i("GameRoomPresenterImp", 2, paramEngineData.toString());
    }
  }
  
  private void d(int paramInt1, int paramInt2, EngineData paramEngineData)
  {
    Object localObject1 = null;
    List localList = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject2 = paramEngineData.a();
      localObject1 = localList;
      if (localObject2 != null)
      {
        localObject1 = localList;
        if ((localObject2 instanceof TopicSongGuess)) {
          localObject1 = (TopicSongGuess)localObject2;
        }
      }
      localList = paramEngineData.b();
    }
    else
    {
      localList = null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = AVGameBusinessCtrl.b().a();
    boolean bool = paramEngineData.jdField_a_of_type_Boolean;
    paramInt2 = 0;
    if ((bool) && ((!paramEngineData.jdField_a_of_type_Boolean) || (!paramEngineData.h()))) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramEngineData = (EngineData)localObject2;
    if (localObject2 == null)
    {
      paramEngineData = (EngineData)localObject2;
      if (paramInt1 == 0) {
        paramEngineData = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
      }
    }
    if ((localObject1 != null) && (paramEngineData != null))
    {
      localObject2 = new AVGameMediaFileInfo();
      ((AVGameMediaFileInfo)localObject2).jdField_a_of_type_JavaLangString = ((TopicSongGuess)localObject1).a.jdField_a_of_type_JavaLangString;
      ((AVGameMediaFileInfo)localObject2).jdField_a_of_type_Long = (((TopicSongGuess)localObject1).a.jdField_a_of_type_Int * 1000);
      localArrayList.add(localObject2);
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramInt1 = paramInt2;
        while (paramInt1 < localList.size())
        {
          Object localObject3 = (ITopic)localList.get(paramInt1);
          if ((localObject3 != null) && ((localObject3 instanceof TopicSongGuess)))
          {
            localObject2 = new AVGameMediaFileInfo();
            localObject3 = (TopicSongGuess)localObject3;
            ((AVGameMediaFileInfo)localObject2).jdField_a_of_type_JavaLangString = ((TopicSongGuess)localObject3).a.jdField_a_of_type_JavaLangString;
            ((AVGameMediaFileInfo)localObject2).jdField_a_of_type_Long = (((TopicSongGuess)localObject3).a.jdField_a_of_type_Int * 1000);
            localArrayList.add(localObject2);
          }
          paramInt1 += 1;
        }
      }
      paramEngineData.a(localArrayList);
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("onNeedCheckAndPreloadAudioVideo PreloadAudio videoTopic:");
      paramEngineData.append(localObject1);
      paramEngineData.append(" files:");
      paramEngineData.append(localArrayList);
      QLog.i("GameRoomPresenterImp", 2, paramEngineData.toString());
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
    AVGameUserInfo localAVGameUserInfo2 = null;
    if (bool1) {
      localObject1 = ((EngineData)localObject1).b();
    } else {
      localObject1 = null;
    }
    boolean bool2;
    if ((localPlayer != null) && (localObject1 != null) && (TextUtils.equals(localPlayer.uin, ((Player)localObject1).uin))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    AVGameUserInfo localAVGameUserInfo1;
    if (localPlayer != null) {
      localAVGameUserInfo1 = a(localPlayer.uin);
    } else {
      localAVGameUserInfo1 = null;
    }
    if (localObject1 != null) {
      localAVGameUserInfo2 = a(((Player)localObject1).uin);
    }
    if ((localAVGameUserInfo1 != null) && (!localAVGameUserInfo1.mMicOn)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3;
    if ((localAVGameUserInfo1 != null) && (!localAVGameUserInfo1.hasCameraVideo())) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if ((localAVGameUserInfo2 != null) && (!localAVGameUserInfo2.mMicOn)) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool5;
    if ((localAVGameUserInfo2 != null) && (!localAVGameUserInfo2.hasCameraVideo())) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    boolean bool7 = this.jdField_c_of_type_Boolean;
    boolean bool8 = this.jdField_b_of_type_Boolean;
    long l = this.jdField_b_of_type_Long;
    Object localObject2 = AVGameBusinessCtrl.b().a();
    if (localObject2 != null) {
      bool1 = ((AVGameSession)localObject2).e;
    }
    if ((i != 0) && (i != 10))
    {
      if (bool2)
      {
        if (bool1) {
          a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690277));
        }
        for (;;)
        {
          bool6 = false;
          break label481;
          if (!bool3) {
            break;
          }
          if (!GameEngine.a().a().a().opened_match) {
            a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690278));
          }
        }
      }
      for (;;)
      {
        break;
        if ((bool1) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_b_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690273), 3000);
        }
        else if ((bool1) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_b_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690273));
        }
        else if ((bool4) && (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin))
        {
          this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690274));
        }
        else if ((bool5) && (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin))
        {
          this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690275));
        }
      }
    }
    boolean bool6 = true;
    label481:
    this.jdField_c_of_type_Boolean = bool1;
    if (bool6) {
      b(1);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append("gameStatus:");
      ((StringBuffer)localObject2).append(i);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("self:");
      ((StringBuffer)localObject2).append(localPlayer);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("player:");
      ((StringBuffer)localObject2).append(localObject1);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("isSelfPlaying:");
      ((StringBuffer)localObject2).append(bool2);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("selfAV:");
      ((StringBuffer)localObject2).append(localAVGameUserInfo1);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("playerAV:");
      ((StringBuffer)localObject2).append(localAVGameUserInfo2);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("isSelfNoOpenAudio:");
      ((StringBuffer)localObject2).append(bool1);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("isSelfNoOpenCamera:");
      ((StringBuffer)localObject2).append(bool3);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("isPlayerNoOpenAudio:");
      ((StringBuffer)localObject2).append(bool4);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("isPlayerNoOpenCamera:");
      ((StringBuffer)localObject2).append(bool5);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("noPermanentTip:");
      ((StringBuffer)localObject2).append(bool6);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("selfAudioTipShowed:");
      ((StringBuffer)localObject2).append(bool8);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("lastIsSelfAudioNoOpen:");
      ((StringBuffer)localObject2).append(bool7);
      ((StringBuffer)localObject2).append("\n");
      ((StringBuffer)localObject2).append("lastOtherAVPlayingTipUin:");
      ((StringBuffer)localObject2).append(l);
      ((StringBuffer)localObject2).append("\n");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAndShowAVStatusTips|");
      ((StringBuilder)localObject1).append(((StringBuffer)localObject2).toString());
      QLog.d("GameRoomPresenterImp", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable()");
    }
    m();
    long l = GameEngine.a().a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRefreshGameListRunnable() nextRefreshTimeInterval = ");
      localStringBuilder.append(l);
      QLog.i("GameRoomPresenterImp", 2, localStringBuilder.toString());
    }
    if (l != 9223372036854775807L)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startRefreshGameListRunnable() postRunnable and nextRefreshTimeInterval = ");
        localStringBuilder.append(l);
        QLog.i("GameRoomPresenterImp", 2, localStringBuilder.toString());
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
    if (localObject == null) {
      return;
    }
    if (GameEngine.a().a().getCurrentAccountUin().equals(((Player)localObject).uin)) {
      return;
    }
    boolean bool = AVGamePerfReporter.a();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    String str1 = paramEngineData.a().a().b();
    String str2 = paramEngineData.b();
    String str3 = ((Player)localObject).uin;
    if (bool) {
      localObject = AVGamePerfReporter.a().a();
    } else {
      localObject = "";
    }
    localAVGamePerfReporter.a(bool, "others", str1, 0L, str2, str3, (String)localObject, paramEngineData.a());
  }
  
  private void p(EngineData paramEngineData)
  {
    int j = paramEngineData.c();
    int i = 1;
    if ((j == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 3000L))
    {
      Player localPlayer = paramEngineData.a();
      paramEngineData = paramEngineData.b();
      if ((localPlayer == null) || (paramEngineData == null) || (!TextUtils.equals(localPlayer.uin, paramEngineData.uin))) {
        i = 0;
      }
      if (localPlayer != null) {
        paramEngineData = a(localPlayer.uin);
      } else {
        paramEngineData = null;
      }
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
    Object localObject = GameEngine.a().a().a();
    if (localObject != null) {
      localObject = ((GameItem)localObject).e;
    } else {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGamePrepareTransparentBgURL = ");
      localStringBuilder.append((String)localObject);
      QLog.d("GameRoomPresenterImp", 2, localStringBuilder.toString());
    }
    return localObject;
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
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getMemberVideoDisplayInfoList bigVideoInfo:");
    ((StringBuilder)localObject1).append(localObject2);
    ((StringBuilder)localObject1).append("  playingRect:");
    ((StringBuilder)localObject1).append(localRectF);
    ((StringBuilder)localObject1).append(" displayList:");
    ((StringBuilder)localObject1).append(localArrayList);
    ((StringBuilder)localObject1).append(" aVList:");
    ((StringBuilder)localObject1).append(localList);
    QLog.i("GameRoomPresenterImp", 1, ((StringBuilder)localObject1).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRoomOtherMemberExit exitType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" kickUin:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" exitRoomTip:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" engineData:");
    localStringBuilder.append(paramEngineData);
    QLog.i("GameRoomPresenterImp", 1, localStringBuilder.toString());
    if (3 == paramInt) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString2, null);
    } else {
      a(paramString2);
    }
    i(paramEngineData);
    a(-1);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView;
    if (localObject != null) {
      ((IGameRoomView)localObject).a(paramLong, paramInt, paramString1, paramString2);
    }
    EngineData localEngineData = GameEngine.a().a();
    String str4 = "";
    if (paramString2 != null)
    {
      try
      {
        int i = paramString2.lastIndexOf("]");
        if (i >= 0)
        {
          localObject = paramString2.substring(i + 2);
          try
          {
            String str1 = paramString2.substring(0, i + 1);
            i = str1.indexOf("[");
            int j = str1.indexOf("]");
            if ((i >= 0) && (j >= 0) && (i < j))
            {
              paramString2 = paramString2.substring(i + 1, j);
              if (paramString2 != null)
              {
                paramString2 = paramString2.split("\\|");
                if ((paramString2 != null) && (paramString2.length > 0))
                {
                  paramString2 = paramString2[0];
                  break label191;
                }
              }
            }
            paramString2 = "";
          }
          catch (Exception localException1)
          {
            paramString2 = (String)localObject;
            break label213;
          }
        }
        else
        {
          paramString2 = "";
          localObject = paramString2;
        }
        label191:
        String str2 = paramString2;
        paramString2 = (String)localObject;
        localObject = str2;
      }
      catch (Exception localException2)
      {
        paramString2 = "";
        label213:
        localException2.printStackTrace();
        localObject = "";
      }
    }
    else
    {
      paramString2 = "";
      localObject = paramString2;
    }
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    String str3 = str4;
    if (localEngineData.a().a() != null) {
      str3 = localEngineData.a().a().b();
    }
    localAVGamePerfReporter.a(false, paramString2, str3, paramInt, paramString1, String.valueOf(paramLong), (String)localObject, localEngineData.a());
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
    else
    {
      local9.run();
    }
    e();
    k(paramEngineData);
    l(paramEngineData);
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
      paramString = a().getResources().getString(2131690519);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(1, paramString);
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushOnChangeUserStatus uin = ");
      localStringBuilder.append(paramString);
      QLog.d("GameRoomPresenterImp", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGameStartFail uin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" gameType:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" roomId:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" errorCode ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" errMsg:");
      localStringBuilder.append(paramString2);
      QLog.i("GameRoomPresenterImp", 2, localStringBuilder.toString());
    }
    if (paramInt2 == 404)
    {
      paramString1 = a().getResources().getString(2131690321);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString1, null);
    }
    else if (paramInt2 == 405)
    {
      paramString1 = a().getResources().getString(2131690512);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(GameEngine.a().a());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exitGameRoom svrAlreadyExit:");
      localStringBuilder.append(paramBoolean);
      QLog.i("GameRoomPresenterImp", 2, localStringBuilder.toString());
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
      AVGameExceptionReporter.a().a(6, null, String.valueOf(paramInt), paramString);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1)
    {
      paramString = GameEngine.a().a();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b(false);
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter;
      if (localObject != null) {
        ((ISurvivalStagePresenter)localObject).a(paramString);
      }
      if ((paramBoolean2) && (paramString.g()))
      {
        n(paramString);
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString);
      }
    }
    else
    {
      localObject = null;
      if ((paramInt == 650) || (paramInt == 651)) {
        localObject = paramString;
      }
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131690331);
      }
      GameEngine.a().a(false, 1);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, false);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    paramSurvivalPkResultInfo = GameEngine.a().a();
    paramInt = paramSurvivalPkResultInfo.o();
    if ((paramInt != 6) && (paramInt != 7))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramSurvivalPkResultInfo);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramSurvivalPkResultInfo);
      ISurvivalStagePresenter localISurvivalStagePresenter = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter;
      if (localISurvivalStagePresenter != null) {
        localISurvivalStagePresenter.a(paramSurvivalPkResultInfo);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.c();
    com.tencent.qav.thread.ThreadManager.a().postDelayed(new GameRoomPresenterImp.5(this, paramSurvivalPkResultInfo), 2000L);
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
    if (paramInt2 != 601) {
      paramString = null;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131690465);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(str, null);
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
    if (paramInt2 != 750) {
      paramString = null;
    }
    paramArrayOfByte = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramArrayOfByte = this.jdField_a_of_type_AndroidContentContext.getString(2131690465);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramArrayOfByte, null);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter;
      if (paramString != null) {
        paramString.a(GameEngine.a().a());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRoomSelfExit exitType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" exitRoomTip:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" engineData:");
    localStringBuilder.append(paramEngineData);
    QLog.i("GameRoomPresenterImp", 1, localStringBuilder.toString());
    if ((GameEngine.a().i()) && (paramInt != 1)) {
      AVGameExceptionReporter.a().a(12, null, String.valueOf(paramInt), paramString);
    }
    switch (paramInt)
    {
    case 0: 
    case 12: 
    default: 
      a(true, paramInt);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.e();
      return true;
    case 13: 
      paramEngineData = paramString;
      if (paramString == null) {
        paramEngineData = this.jdField_a_of_type_AndroidContentContext.getString(2131690422);
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramEngineData, new GameRoomPresenterImp.8(this));
      return true;
    case 8: 
      a(false, paramInt);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.e();
      return true;
    case 5: 
    case 9: 
    case 10: 
    case 11: 
      a(false, paramInt);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    case 3: 
    case 4: 
    case 6: 
    case 7: 
      a(true, paramInt);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
    return true;
  }
  
  public String b()
  {
    Object localObject = GameEngine.a().a().a();
    if (localObject != null) {
      localObject = ((GameItem)localObject).d;
    } else {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGamePrepareBgURL = ");
      localStringBuilder.append((String)localObject);
      QLog.d("GameRoomPresenterImp", 2, localStringBuilder.toString());
    }
    return localObject;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnswerRightPush scoreThisTime = ");
      localStringBuilder.append(paramInt);
      QLog.d("GameRoomPresenterImp", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushOnRoomEnter roomEnterTip = ");
      localStringBuilder.append(paramString);
      QLog.d("GameRoomPresenterImp", 2, localStringBuilder.toString());
    }
    a().h();
    a(paramString);
    i(paramEngineData);
    if ((paramEngineData.e()) && (paramEngineData.a(paramEngineData.e(GameEngine.a().a().getCurrentAccountUin()))))
    {
      if (AVGameUtil.b() == 2)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.h();
        return;
      }
      n();
      a(a().getResources().getString(2131690393));
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
    if ((!paramBoolean) && (GameEngine.a().i())) {
      AVGameExceptionReporter.a().a(7, null, String.valueOf(paramInt), paramString);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushMemberEnterForPk  ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("GameRoomPresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = GameEngine.a().a().getCurrentAccountUin();
    if ((paramEngineData.e((String)localObject)) && (!((String)localObject).equals(paramString)))
    {
      boolean bool = AVGameBusinessCtrl.b().e();
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      long l;
      if (bool) {
        l = 1000L;
      } else {
        l = 2000L;
      }
      paramString.sendEmptyMessageDelayed(10, l);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramEngineData);
    paramString = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter;
    if (paramString != null) {
      paramString.a(paramEngineData);
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
    String str1;
    if (bool) {
      str1 = AVGamePerfReporter.a().a();
    } else {
      str1 = "";
    }
    localAVGamePerfReporter.a(bool, "timeout", str2, 0L, str3, str4, str1, paramEngineData.a());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int k = 0;
    switch (i)
    {
    default: 
      return true;
    case 10: 
      GameEngine.a().a(0, null);
      return true;
    case 9: 
      paramMessage = this.jdField_a_of_type_AndroidContentContext;
      if (paramMessage != null)
      {
        if (!(paramMessage instanceof IAVGameRootContainer)) {
          return true;
        }
        paramMessage = (IAVGameRootContainer)paramMessage;
        if (paramMessage.checkDestroyed()) {
          return true;
        }
      }
      break;
    }
    for (;;)
    {
      int j;
      try
      {
        if ((paramMessage.checkDestroyed()) || (AVGameBusinessCtrl.b().a() != 1)) {
          break label377;
        }
        i = 1;
        j = k;
        if (AVGameBusinessCtrl.b().a() != 0) {
          break label382;
        }
        j = k;
        if (AVGameBusinessCtrl.b().d()) {
          break label382;
        }
        j = 1;
      }
      catch (Exception paramMessage)
      {
        label164:
        paramMessage.printStackTrace();
        return true;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690271));
      return true;
      return true;
      if (MSFNetInfoMonitor.b() != 1)
      {
        a(this.jdField_a_of_type_AndroidContentContext.getString(2131690399));
        ReportController.b(null, "dc00898", "", "", "0X800B040", "0X800B040", 0, 0, "", "", "", "");
        return true;
        j(GameEngine.a().a());
        a(0);
        f();
        return true;
        f();
        return true;
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(GameEngine.a().a());
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(GameEngine.a().a());
        return true;
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(GameEngine.a().a());
        return true;
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(GameEngine.a().a());
        return true;
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(GameEngine.a().a());
        return true;
        a(-1);
      }
      label377:
      label382:
      do
      {
        return true;
        i = 0;
        break;
        if (i != 0) {
          break label164;
        }
      } while (j == 0);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshAll engineData:");
      ((StringBuilder)localObject).append(paramEngineData);
      QLog.d("GameRoomPresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramEngineData);
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
    if (localObject != null) {
      ((IStagePresenter)localObject).a(paramEngineData);
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter;
    if (localObject != null) {
      ((ISurvivalStagePresenter)localObject).a(paramEngineData);
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter;
    if (localObject != null) {
      ((IAVControlUiPresenter)localObject).a(paramEngineData);
    }
    j(paramEngineData);
    a(50);
  }
  
  public void j()
  {
    QLog.d("GameRoomPresenterImp", 2, "onPkMatchTimeout");
    if (GameEngine.a().f()) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690423), null);
    }
  }
  
  public void j(EngineData paramEngineData)
  {
    int i = paramEngineData.a();
    StringBuilder localStringBuilder = null;
    Object localObject;
    Player localPlayer1;
    if ((i != 0) && (i != 10))
    {
      Player localPlayer2 = paramEngineData.b();
      localObject = localStringBuilder;
      localPlayer1 = localPlayer2;
      if (localPlayer2 != null)
      {
        localObject = localStringBuilder;
        localPlayer1 = localPlayer2;
        if (paramEngineData.b(localPlayer2.uin))
        {
          localObject = localPlayer2.uin;
          localPlayer1 = localPlayer2;
        }
      }
    }
    else
    {
      localPlayer1 = null;
      localObject = localStringBuilder;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("playerBigVideoChanged player:");
    localStringBuilder.append(localPlayer1);
    localStringBuilder.append("  gameStatus:");
    localStringBuilder.append(i);
    localStringBuilder.append("  gameType:");
    localStringBuilder.append(paramEngineData.c());
    QLog.i("GameRoomPresenterImp", 1, localStringBuilder.toString());
    paramEngineData = this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter;
    if (paramEngineData != null) {
      paramEngineData.a((String)localObject);
    }
  }
  
  public void k()
  {
    if (GameEngine.a().i()) {
      AVGameExceptionReporter.a().a(5, null, null, null);
    }
    QLog.d("GameRoomPresenterImp", 1, "onTopicTimeout");
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690461), this.jdField_a_of_type_AndroidContentContext.getString(2131690462), this.jdField_a_of_type_AndroidContentContext.getString(2131690463), null, new GameRoomPresenterImp.6(this), true);
  }
  
  public void k(EngineData paramEngineData)
  {
    int i = paramEngineData.a();
    int j = paramEngineData.c();
    if (j == 3) {
      a(i, j, paramEngineData);
    } else if (j == 4) {
      b(i, j, paramEngineData);
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("onNeedCheckAndPlayAudioVideo gameStatus:");
      paramEngineData.append(i);
      paramEngineData.append(" gameType:");
      paramEngineData.append(j);
      QLog.i("GameRoomPresenterImp", 2, paramEngineData.toString());
    }
  }
  
  public void l(EngineData paramEngineData)
  {
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().a();
    int i;
    if ((paramEngineData.jdField_a_of_type_Boolean) && ((!paramEngineData.jdField_a_of_type_Boolean) || (!paramEngineData.h()))) {
      i = 0;
    } else {
      i = 1;
    }
    paramEngineData = localIAVGameMediaPlayerCtrl;
    if (localIAVGameMediaPlayerCtrl == null)
    {
      paramEngineData = localIAVGameMediaPlayerCtrl;
      if (i == 0) {
        paramEngineData = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
      }
    }
    if (paramEngineData != null) {
      paramEngineData.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndReleaseAudioVideo");
    }
  }
  
  public void m(EngineData paramEngineData)
  {
    int i = paramEngineData.a();
    int j = paramEngineData.c();
    if ((i != 0) && (i != 10))
    {
      if (j == 3)
      {
        c(i, j, paramEngineData);
        return;
      }
      if (j == 4) {
        d(i, j, paramEngineData);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("onNeedCheckAndPreloadAudioVideo gameStatus:");
      paramEngineData.append(i);
      paramEngineData.append(" gameType:");
      paramEngineData.append(j);
      QLog.i("GameRoomPresenterImp", 2, paramEngineData.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp
 * JD-Core Version:    0.7.0.1
 */