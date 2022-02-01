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
  protected IGameRoomView a;
  protected IGameListPresenter b;
  protected IStagePresenter c;
  protected ISeatPresenter d;
  protected IOverlayPresenter e;
  protected IAVControlUiPresenter f;
  protected IStageRecordPresenter g;
  protected ISurvivalStagePresenter h;
  protected Context i;
  protected Handler j;
  protected GameRoomPresenterImp.MyNetObserver k = null;
  protected AVGameUIEventCallback l = new GameRoomPresenterImp.1(this);
  protected DialogInterface.OnClickListener m = new GameRoomPresenterImp.2(this);
  public Runnable n = new GameRoomPresenterImp.3(this);
  private int o = 0;
  private boolean p = false;
  private long q = 0L;
  private boolean r = false;
  private long s = 0L;
  private boolean t = false;
  
  public GameRoomPresenterImp(IGameRoomView paramIGameRoomView)
  {
    this.a = paramIGameRoomView;
  }
  
  private void a(int paramInt1, int paramInt2, EngineData paramEngineData)
  {
    Object localObject3 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = paramEngineData.s();
      if ((localObject1 != null) && ((localObject1 instanceof TopicOperGuessVideo)))
      {
        localObject1 = (TopicOperGuessVideo)localObject1;
        break label50;
      }
    }
    Object localObject1 = null;
    label50:
    Object localObject4 = AVGameBusinessCtrl.b().n();
    boolean bool1 = paramEngineData.f;
    boolean bool2 = true;
    boolean bool3 = false;
    if ((bool1) && ((!paramEngineData.f) || (!paramEngineData.O()))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Object localObject2 = localObject4;
    if (localObject4 == null)
    {
      localObject2 = localObject4;
      if (!bool1) {
        localObject2 = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((TopicOperGuessVideo)localObject1).i.a)))
    {
      bool2 = bool3;
      if (localObject2 != null)
      {
        localObject4 = ((TopicOperGuessVideo)localObject1).i.a;
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
            if (paramEngineData.h().n() < paramEngineData.h().p())
            {
              long l2 = paramEngineData.h().n();
              long l1 = l2;
              if (l2 > ((TopicOperGuessVideo)localObject1).i.c * 1000) {
                l1 = 0L;
              }
              if ((((IAVGameMediaPlayerCtrl)localObject2).c()) && (TextUtils.equals((CharSequence)localObject4, ((IAVGameMediaPlayerCtrl)localObject2).a())))
              {
                ((IAVGameMediaPlayerCtrl)localObject2).b();
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
        ((IAVGameMediaPlayerCtrl)localObject2).e();
        if (!bool1)
        {
          ((IAVGameMediaPlayerCtrl)localObject2).g();
          bool1 = bool2;
        }
        else
        {
          ((IAVGameMediaPlayerCtrl)localObject2).f();
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
      if (paramInt2 == 3) {
        this.f.a(false);
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
      localObject1 = paramEngineData.s();
      if ((localObject1 != null) && ((localObject1 instanceof TopicSongGuess)))
      {
        localObject1 = (TopicSongGuess)localObject1;
        break label50;
      }
    }
    Object localObject1 = null;
    label50:
    Object localObject3 = AVGameBusinessCtrl.b().n();
    boolean bool1 = paramEngineData.f;
    boolean bool2 = false;
    if ((bool1) && ((!paramEngineData.f) || (!paramEngineData.O()))) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = localObject3;
      if (paramInt2 == 0) {
        localObject2 = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((TopicSongGuess)localObject1).i.a)))
    {
      localObject3 = str;
      bool1 = bool2;
      if (localObject2 != null)
      {
        str = ((TopicSongGuess)localObject1).i.a;
        ((IAVGameMediaPlayerCtrl)localObject2).a(false);
        localObject3 = str;
        bool1 = bool2;
        if (paramInt1 != 3)
        {
          localObject3 = str;
          bool1 = bool2;
          if (paramInt1 != 4)
          {
            long l2 = paramEngineData.h().n();
            long l1 = l2;
            if (l2 > ((TopicSongGuess)localObject1).i.c * 1000) {
              l1 = 0L;
            }
            if ((((IAVGameMediaPlayerCtrl)localObject2).c()) && (TextUtils.equals(str, ((IAVGameMediaPlayerCtrl)localObject2).a())))
            {
              ((IAVGameMediaPlayerCtrl)localObject2).b();
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
        ((IAVGameMediaPlayerCtrl)localObject2).e();
        if (paramInt2 == 0) {
          ((IAVGameMediaPlayerCtrl)localObject2).g();
        } else {
          ((IAVGameMediaPlayerCtrl)localObject2).f();
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
      localObject2 = paramEngineData.s();
      localObject1 = localList;
      if (localObject2 != null)
      {
        localObject1 = localList;
        if ((localObject2 instanceof TopicOperGuessVideo)) {
          localObject1 = (TopicOperGuessVideo)localObject2;
        }
      }
      localList = paramEngineData.C();
    }
    else
    {
      localList = null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = AVGameBusinessCtrl.b().n();
    boolean bool = paramEngineData.f;
    paramInt2 = 0;
    if ((bool) && ((!paramEngineData.f) || (!paramEngineData.O()))) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramEngineData = (EngineData)localObject2;
    if (localObject2 == null)
    {
      paramEngineData = (EngineData)localObject2;
      if (paramInt1 == 0) {
        paramEngineData = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      }
    }
    if ((localObject1 != null) && (paramEngineData != null))
    {
      localObject2 = new AVGameMediaFileInfo();
      ((AVGameMediaFileInfo)localObject2).a = ((TopicOperGuessVideo)localObject1).i.a;
      ((AVGameMediaFileInfo)localObject2).c = (((TopicOperGuessVideo)localObject1).i.c * 1000);
      ((AVGameMediaFileInfo)localObject2).e = ((TopicOperGuessVideo)localObject1).i.b;
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
            ((AVGameMediaFileInfo)localObject2).a = ((TopicOperGuessVideo)localObject3).i.a;
            ((AVGameMediaFileInfo)localObject2).e = ((TopicOperGuessVideo)localObject3).i.b;
            ((AVGameMediaFileInfo)localObject2).c = (((TopicOperGuessVideo)localObject3).i.c * 1000);
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
      localObject2 = paramEngineData.s();
      localObject1 = localList;
      if (localObject2 != null)
      {
        localObject1 = localList;
        if ((localObject2 instanceof TopicSongGuess)) {
          localObject1 = (TopicSongGuess)localObject2;
        }
      }
      localList = paramEngineData.C();
    }
    else
    {
      localList = null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = AVGameBusinessCtrl.b().n();
    boolean bool = paramEngineData.f;
    paramInt2 = 0;
    if ((bool) && ((!paramEngineData.f) || (!paramEngineData.O()))) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramEngineData = (EngineData)localObject2;
    if (localObject2 == null)
    {
      paramEngineData = (EngineData)localObject2;
      if (paramInt1 == 0) {
        paramEngineData = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      }
    }
    if ((localObject1 != null) && (paramEngineData != null))
    {
      localObject2 = new AVGameMediaFileInfo();
      ((AVGameMediaFileInfo)localObject2).a = ((TopicSongGuess)localObject1).i.a;
      ((AVGameMediaFileInfo)localObject2).c = (((TopicSongGuess)localObject1).i.c * 1000);
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
            ((AVGameMediaFileInfo)localObject2).a = ((TopicSongGuess)localObject3).i.a;
            ((AVGameMediaFileInfo)localObject2).c = (((TopicSongGuess)localObject3).i.c * 1000);
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
  
  private void n(EngineData paramEngineData)
  {
    paramEngineData = paramEngineData.ai();
    if (!TextUtils.isEmpty(paramEngineData)) {
      a(paramEngineData, 1000);
    }
  }
  
  private void o(EngineData paramEngineData)
  {
    Object localObject = paramEngineData.h().e;
    if (localObject == null) {
      return;
    }
    if (GameEngine.a().f().getCurrentAccountUin().equals(((Player)localObject).uin)) {
      return;
    }
    boolean bool = AVGamePerfReporter.b();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    String str1 = paramEngineData.h().h().d();
    String str2 = paramEngineData.n();
    String str3 = ((Player)localObject).uin;
    if (bool) {
      localObject = AVGamePerfReporter.a().c();
    } else {
      localObject = "";
    }
    localAVGamePerfReporter.a(bool, "others", str1, 0L, str2, str3, (String)localObject, paramEngineData.i());
  }
  
  private void p(EngineData paramEngineData)
  {
    int i2 = paramEngineData.o();
    int i1 = 1;
    if ((i2 == 1) && (System.currentTimeMillis() - this.q > 3000L))
    {
      Player localPlayer = paramEngineData.q();
      paramEngineData = paramEngineData.r();
      if ((localPlayer == null) || (paramEngineData == null) || (!TextUtils.equals(localPlayer.uin, paramEngineData.uin))) {
        i1 = 0;
      }
      if (localPlayer != null) {
        paramEngineData = a(localPlayer.uin);
      } else {
        paramEngineData = null;
      }
      if ((i1 != 0) && (paramEngineData != null))
      {
        if (!paramEngineData.hasVideo()) {
          ReportController.b(null, "dc00898", "", "", "0X800B03E", "0X800B03E", 0, 0, "", "", "", "");
        }
        paramEngineData = AVGameBusinessCtrl.b().j();
        if ((paramEngineData != null) && (paramEngineData.i)) {
          ReportController.b(null, "dc00898", "", "", "0X800B03F", "0X800B03F", 0, 0, "", "", "", "");
        }
      }
      this.q = System.currentTimeMillis();
    }
  }
  
  private void v()
  {
    this.j.removeMessages(6);
    this.j.sendEmptyMessageDelayed(6, 1000L);
  }
  
  private void w()
  {
    Object localObject1 = GameEngine.a().s();
    int i1 = ((EngineData)localObject1).j();
    boolean bool1 = ((EngineData)localObject1).z();
    Player localPlayer = ((EngineData)localObject1).q();
    AVGameUserInfo localAVGameUserInfo2 = null;
    if (bool1) {
      localObject1 = ((EngineData)localObject1).r();
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
    boolean bool7 = this.t;
    boolean bool8 = this.r;
    long l1 = this.s;
    Object localObject2 = AVGameBusinessCtrl.b().j();
    if (localObject2 != null) {
      bool1 = ((AVGameSession)localObject2).i;
    }
    if ((i1 != 0) && (i1 != 10))
    {
      if (bool2)
      {
        if (bool1) {
          a(1, this.i.getString(2131887188));
        }
        for (;;)
        {
          bool6 = false;
          break label481;
          if (!bool3) {
            break;
          }
          if (!GameEngine.a().s().e().opened_match) {
            a(1, this.i.getString(2131887189));
          }
        }
      }
      for (;;)
      {
        break;
        if ((bool1) && (!this.t))
        {
          this.r = true;
          a(this.i.getString(2131887184), 3000);
        }
        else if ((bool1) && (!this.r))
        {
          this.r = true;
          b(this.i.getString(2131887184));
        }
        else if ((bool4) && (this.s != localAVGameUserInfo2.mUin))
        {
          this.s = localAVGameUserInfo2.mUin;
          b(this.i.getString(2131887185));
        }
        else if ((bool5) && (this.s != localAVGameUserInfo2.mUin))
        {
          this.s = localAVGameUserInfo2.mUin;
          b(this.i.getString(2131887186));
        }
      }
    }
    boolean bool6 = true;
    label481:
    this.t = bool1;
    if (bool6) {
      b(1);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append("gameStatus:");
      ((StringBuffer)localObject2).append(i1);
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
      ((StringBuffer)localObject2).append(l1);
      ((StringBuffer)localObject2).append("\n");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAndShowAVStatusTips|");
      ((StringBuilder)localObject1).append(((StringBuffer)localObject2).toString());
      QLog.d("GameRoomPresenterImp", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void x()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable()");
    }
    y();
    long l1 = GameEngine.a().u();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRefreshGameListRunnable() nextRefreshTimeInterval = ");
      localStringBuilder.append(l1);
      QLog.i("GameRoomPresenterImp", 2, localStringBuilder.toString());
    }
    if (l1 != 9223372036854775807L)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startRefreshGameListRunnable() postRunnable and nextRefreshTimeInterval = ");
        localStringBuilder.append(l1);
        QLog.i("GameRoomPresenterImp", 2, localStringBuilder.toString());
      }
      com.tencent.qav.thread.ThreadManager.a().postDelayed(this.n, l1 * 1000L + 2000L);
    }
  }
  
  private void y()
  {
    com.tencent.qav.thread.ThreadManager.a().removeCallbacks(this.n);
  }
  
  private void z()
  {
    GameEngine.a().w();
  }
  
  public AVGameUserInfo a(String paramString)
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().j();
    if (localAVGameSession != null) {
      return localAVGameSession.a(Long.valueOf(paramString).longValue());
    }
    return null;
  }
  
  public void a()
  {
    EngineData localEngineData = GameEngine.a().s();
    this.j.removeMessages(6);
    this.j.removeMessages(7);
    this.j.sendEmptyMessageDelayed(7, 1000L);
    m(localEngineData);
    k(localEngineData);
    x();
    QLog.i("GameRoomPresenterImp", 1, "onFragmentStart");
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.j.sendEmptyMessageDelayed(1, 0L);
      return;
    }
    if ((GameEngine.a().A()) && (!GameEngine.a().B()))
    {
      RectF localRectF = this.c.b();
      this.a.a(localRectF);
      return;
    }
    this.a.a(n());
    this.c.b(GameEngine.a().s());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.b(paramInt, paramString);
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
      this.a.a(paramString2, null);
    } else {
      b(paramString2);
    }
    i(paramEngineData);
    a(-1);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((IGameRoomView)localObject).a(paramLong, paramInt, paramString1, paramString2);
    }
    EngineData localEngineData = GameEngine.a().s();
    String str4 = "";
    if (paramString2 != null)
    {
      try
      {
        int i1 = paramString2.lastIndexOf("]");
        if (i1 >= 0)
        {
          localObject = paramString2.substring(i1 + 2);
          try
          {
            String str1 = paramString2.substring(0, i1 + 1);
            i1 = str1.indexOf("[");
            int i2 = str1.indexOf("]");
            if ((i1 >= 0) && (i2 >= 0) && (i1 < i2))
            {
              paramString2 = paramString2.substring(i1 + 1, i2);
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
    if (localEngineData.h().h() != null) {
      str3 = localEngineData.h().h().d();
    }
    localAVGamePerfReporter.a(false, paramString2, str3, paramInt, paramString1, String.valueOf(paramLong), (String)localObject, localEngineData.i());
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.a.a(1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    i(GameEngine.a().s());
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    EngineData localEngineData = GameEngine.a().s();
    this.b.a(localEngineData);
    this.d.a(localEngineData);
    this.f.b(false);
    this.f.c(paramBoolean);
    if (paramBoolean) {
      this.p = paramBoolean;
    }
  }
  
  public void a(Context paramContext, IGameListPresenter paramIGameListPresenter, IStagePresenter paramIStagePresenter, ISeatPresenter paramISeatPresenter, IOverlayPresenter paramIOverlayPresenter, IAVControlUiPresenter paramIAVControlUiPresenter, IStageRecordPresenter paramIStageRecordPresenter, ISurvivalStagePresenter paramISurvivalStagePresenter)
  {
    this.j = new Handler(this);
    this.i = paramContext;
    this.b = paramIGameListPresenter;
    this.c = paramIStagePresenter;
    this.d = paramISeatPresenter;
    this.e = paramIOverlayPresenter;
    this.f = paramIAVControlUiPresenter;
    this.g = paramIStageRecordPresenter;
    this.h = paramISurvivalStagePresenter;
    GameEngine.a().a(this);
    GameEngine.a().a(this);
    AVGameBusinessCtrl.b().a(this.l);
    if (this.k == null)
    {
      this.k = new GameRoomPresenterImp.MyNetObserver(this.j);
      ObserverCenter.a().a(this.k, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "init");
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    this.b.a(paramEngineData);
    AVGamePerfReporter.a().a("param_StepGameReady", 0);
    if (this.b.b()) {
      AVGamePerfReporter.a().a("param_StepGameCanStart");
    }
    x();
  }
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    if (paramInt == 4)
    {
      this.a.h();
      this.f.b(false);
    }
    i(paramEngineData);
    QLog.d("GameRoomPresenterImp", 2, "onChangeUserStatusSuccess");
    com.tencent.mobileqq.app.ThreadManager.excute(new GameRoomPresenterImp.7(this), 16, null, false);
  }
  
  public void a(EngineData paramEngineData, String paramString)
  {
    this.c.a(paramEngineData);
    this.c.a(paramString, paramEngineData.o());
  }
  
  public void a(EngineData paramEngineData, boolean paramBoolean)
  {
    AVGamePerfReporter.a().a(false, paramEngineData.i());
    if (paramEngineData.M())
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
    v();
    k(paramEngineData);
    l(paramEngineData);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 3) && ((paramInt1 == 113) || (paramInt1 == 109)))
    {
      paramString = m().getResources().getString(2131887430);
      this.a.a(1, paramString);
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
    if ((paramString.equals(GameEngine.a().f().getAccount())) && (paramInt == 1))
    {
      this.a.h();
      this.f.b(false);
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
      paramString1 = m().getResources().getString(2131887232);
      this.a.a(paramString1, null);
    }
    else if (paramInt2 == 405)
    {
      paramString1 = m().getResources().getString(2131887423);
      this.a.a(1, paramString1);
      i(GameEngine.a().s());
    }
    else if ((paramInt2 == 406) && (paramString2 != null) && (paramString2.length() > 0))
    {
      this.a.a(paramString2, null);
    }
    else if (paramInt2 != 408)
    {
      this.a.a(1, "开始游戏失败");
    }
    this.c.a(GameEngine.a().s());
  }
  
  public void a(String paramString, EngineData paramEngineData)
  {
    i(paramEngineData);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.d.a(GameEngine.a().s());
  }
  
  public void a(boolean paramBoolean)
  {
    Player localPlayer = GameEngine.a().s().q();
    ReportController.b(null, "dc00898", "", "", "0X800B035", "0X800B035", FloatWindowController.c().a(localPlayer) + 1, 0, "1", "", "", "");
    FloatWindowController.c().a(m(), paramBoolean, false);
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
      z();
    }
    this.a.j();
    GameEngine.a().a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    this.d.a(GameEngine.a().s());
    if ((!paramBoolean) && (GameEngine.a().D())) {
      AVGameExceptionReporter.a().a(6, null, String.valueOf(paramInt), paramString);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1)
    {
      paramString = GameEngine.a().s();
      this.f.b(false);
      localObject = this.h;
      if (localObject != null) {
        ((ISurvivalStagePresenter)localObject).a(paramString);
      }
      if ((paramBoolean2) && (paramString.N()))
      {
        n(paramString);
        this.a.a(paramString);
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
        paramString = this.i.getString(2131887242);
      }
      GameEngine.a().a(false, 1);
      this.a.a(paramString, this.m, false);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    paramSurvivalPkResultInfo = GameEngine.a().s();
    paramInt = paramSurvivalPkResultInfo.X();
    if ((paramInt != 6) && (paramInt != 7))
    {
      this.d.a(paramSurvivalPkResultInfo);
      this.c.a(paramSurvivalPkResultInfo);
      ISurvivalStagePresenter localISurvivalStagePresenter = this.h;
      if (localISurvivalStagePresenter != null) {
        localISurvivalStagePresenter.a(paramSurvivalPkResultInfo);
      }
      return;
    }
    this.a.g();
    com.tencent.qav.thread.ThreadManager.a().postDelayed(new GameRoomPresenterImp.5(this, paramSurvivalPkResultInfo), 2000L);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramString = GameEngine.a().s();
      this.b.a(paramString);
      this.d.a(paramString);
      return;
    }
    if (paramInt2 != 601) {
      paramString = null;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.i.getString(2131887376);
    }
    this.a.a(str, null);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    paramString = GameEngine.a().s();
    this.b.a(paramString);
    this.d.a(paramString);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramArrayOfByte = GameEngine.a().s();
      this.b.a(paramArrayOfByte);
      this.b.h();
      this.d.a(paramArrayOfByte);
      this.f.b(false);
      return;
    }
    if (paramInt2 != 750) {
      paramString = null;
    }
    paramArrayOfByte = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramArrayOfByte = this.i.getString(2131887376);
    }
    this.a.a(paramArrayOfByte, null);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = this.h;
      if (paramString != null) {
        paramString.a(GameEngine.a().s());
      }
      this.d.a(GameEngine.a().s());
      return;
    }
    this.a.a(paramString, new GameRoomPresenterImp.4(this), false);
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
    if ((GameEngine.a().D()) && (paramInt != 1)) {
      AVGameExceptionReporter.a().a(12, null, String.valueOf(paramInt), paramString);
    }
    switch (paramInt)
    {
    case 0: 
    case 12: 
    default: 
      a(true, paramInt);
      this.a.i();
      return true;
    case 13: 
      paramEngineData = paramString;
      if (paramString == null) {
        paramEngineData = this.i.getString(2131887333);
      }
      this.a.a(paramEngineData, new GameRoomPresenterImp.8(this));
      return true;
    case 8: 
      a(false, paramInt);
      this.a.i();
      return true;
    case 5: 
    case 9: 
    case 10: 
    case 11: 
      a(false, paramInt);
      this.a.a(paramString, this.m);
      return true;
    case 3: 
    case 4: 
    case 6: 
    case 7: 
      a(true, paramInt);
      this.a.a(paramString, this.m);
    }
    return true;
  }
  
  public void b()
  {
    this.j.removeMessages(7);
    y();
  }
  
  public void b(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void b(long paramLong, String paramString1, String paramString2) {}
  
  public void b(EngineData paramEngineData)
  {
    if (!GameEngine.a().d()) {
      this.b.a(paramEngineData);
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
    this.c.a(paramEngineData);
    this.d.a(paramEngineData);
    o(paramEngineData);
  }
  
  public void b(String paramString)
  {
    this.a.a(paramString);
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
    f().l();
    b(paramString);
    i(paramEngineData);
    if ((paramEngineData.L()) && (paramEngineData.a(paramEngineData.g(GameEngine.a().f().getCurrentAccountUin()))))
    {
      if (AVGameUtil.b() == 2)
      {
        this.b.k();
        return;
      }
      z();
      b(m().getResources().getString(2131887304));
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    this.d.a(GameEngine.a().s());
    if ((!paramBoolean) && (GameEngine.a().D())) {
      AVGameExceptionReporter.a().a(7, null, String.valueOf(paramInt), paramString);
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    paramString = GameEngine.a().s();
    this.b.a(paramString);
    this.b.i();
    this.d.a(paramString);
    this.f.b(false);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "destroy");
    }
    this.d.e();
    this.c.g();
    AVGameBusinessCtrl.b().b(this.l);
    GameEngine.a().b(this);
    GameEngine.a().b(this);
    this.j.removeCallbacksAndMessages(null);
    if (this.k != null)
    {
      ObserverCenter.a().b(this.k);
      this.k = null;
    }
  }
  
  public void c(EngineData paramEngineData)
  {
    this.a.f();
    i(paramEngineData);
    this.r = false;
    this.s = 0L;
    z();
    v();
    p(paramEngineData);
    this.f.b(true);
    AVGamePerfReporter.a().a(true, paramEngineData.i());
  }
  
  public void c(EngineData paramEngineData, int paramInt)
  {
    i(paramEngineData);
  }
  
  public void c(String paramString)
  {
    this.a.b(paramString);
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
    Object localObject = GameEngine.a().f().getCurrentAccountUin();
    if ((paramEngineData.g((String)localObject)) && (!((String)localObject).equals(paramString)))
    {
      boolean bool = AVGameBusinessCtrl.b().o();
      paramString = this.j;
      long l1;
      if (bool) {
        l1 = 1000L;
      } else {
        l1 = 2000L;
      }
      paramString.sendEmptyMessageDelayed(10, l1);
    }
    this.d.a(paramEngineData);
    paramString = this.h;
    if (paramString != null) {
      paramString.a(paramEngineData);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    v();
  }
  
  public ISeatPresenter d()
  {
    return this.d;
  }
  
  public void d(EngineData paramEngineData)
  {
    this.c.a(paramEngineData);
  }
  
  public void d(String paramString, EngineData paramEngineData)
  {
    this.c.a(paramString, paramEngineData);
  }
  
  public void d(boolean paramBoolean)
  {
    v();
  }
  
  public IOverlayPresenter e()
  {
    return this.e;
  }
  
  public void e(EngineData paramEngineData)
  {
    m(paramEngineData);
  }
  
  public void e(String paramString, EngineData paramEngineData)
  {
    this.c.b(paramString, paramEngineData);
  }
  
  public void e(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public IGameRoomView f()
  {
    return this.a;
  }
  
  public void f(EngineData paramEngineData)
  {
    this.a.f();
    this.r = false;
    this.s = 0L;
    i(paramEngineData);
    v();
    AVGameHandler.a().b().post(new GameRoomPresenterImp.10(this));
    p(paramEngineData);
    this.f.b(true);
    z();
    AVGamePerfReporter.a().a(true, paramEngineData.i());
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.p = paramBoolean;
    }
  }
  
  public IStageRecordPresenter g()
  {
    return this.g;
  }
  
  public void g(EngineData paramEngineData)
  {
    i(paramEngineData);
    v();
    p(paramEngineData);
  }
  
  public void h()
  {
    this.b.a(GameEngine.a().s());
  }
  
  public void h(EngineData paramEngineData)
  {
    this.c.a(paramEngineData);
    boolean bool = AVGamePerfReporter.b();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    String str2 = paramEngineData.h().h().d();
    String str3 = paramEngineData.n();
    String str4 = GameEngine.a().f().getCurrentAccountUin();
    String str1;
    if (bool) {
      str1 = AVGamePerfReporter.a().c();
    } else {
      str1 = "";
    }
    localAVGamePerfReporter.a(bool, "timeout", str2, 0L, str3, str4, str1, paramEngineData.i());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    int i3 = 0;
    switch (i1)
    {
    default: 
      return true;
    case 10: 
      GameEngine.a().a(0, null);
      return true;
    case 9: 
      paramMessage = this.i;
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
      int i2;
      try
      {
        if ((paramMessage.checkDestroyed()) || (AVGameBusinessCtrl.b().i() != 1)) {
          break label377;
        }
        i1 = 1;
        i2 = i3;
        if (AVGameBusinessCtrl.b().i() != 0) {
          break label382;
        }
        i2 = i3;
        if (AVGameBusinessCtrl.b().k()) {
          break label382;
        }
        i2 = 1;
      }
      catch (Exception paramMessage)
      {
        label164:
        paramMessage.printStackTrace();
        return true;
      }
      b(this.i.getString(2131887182));
      return true;
      return true;
      if (MSFNetInfoMonitor.b() != 1)
      {
        b(this.i.getString(2131887310));
        ReportController.b(null, "dc00898", "", "", "0X800B040", "0X800B040", 0, 0, "", "", "", "");
        return true;
        j(GameEngine.a().s());
        a(0);
        w();
        return true;
        w();
        return true;
        this.b.a(GameEngine.a().s());
        this.d.a(GameEngine.a().s());
        this.c.a(GameEngine.a().s());
        return true;
        this.b.a(GameEngine.a().s());
        return true;
        this.c.a(GameEngine.a().s());
        return true;
        this.d.a(GameEngine.a().s());
        return true;
        a(-1);
      }
      label377:
      label382:
      do
      {
        return true;
        i1 = 0;
        break;
        if (i1 != 0) {
          break label164;
        }
      } while (i2 == 0);
    }
  }
  
  public void i()
  {
    if (!GameEngine.a().d()) {
      this.b.a(GameEngine.a().s());
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
    this.d.a(paramEngineData);
    this.b.a(paramEngineData);
    Object localObject = this.c;
    if (localObject != null) {
      ((IStagePresenter)localObject).a(paramEngineData);
    }
    localObject = this.h;
    if (localObject != null) {
      ((ISurvivalStagePresenter)localObject).a(paramEngineData);
    }
    localObject = this.f;
    if (localObject != null) {
      ((IAVControlUiPresenter)localObject).a(paramEngineData);
    }
    j(paramEngineData);
    a(50);
  }
  
  public void j()
  {
    if (!GameEngine.a().d()) {
      this.b.a(GameEngine.a().s());
    }
  }
  
  public void j(EngineData paramEngineData)
  {
    int i1 = paramEngineData.j();
    StringBuilder localStringBuilder = null;
    Object localObject;
    Player localPlayer1;
    if ((i1 != 0) && (i1 != 10))
    {
      Player localPlayer2 = paramEngineData.r();
      localObject = localStringBuilder;
      localPlayer1 = localPlayer2;
      if (localPlayer2 != null)
      {
        localObject = localStringBuilder;
        localPlayer1 = localPlayer2;
        if (paramEngineData.d(localPlayer2.uin))
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
    localStringBuilder.append(i1);
    localStringBuilder.append("  gameType:");
    localStringBuilder.append(paramEngineData.o());
    QLog.i("GameRoomPresenterImp", 1, localStringBuilder.toString());
    paramEngineData = this.f;
    if (paramEngineData != null) {
      paramEngineData.a((String)localObject);
    }
  }
  
  public void k()
  {
    QLog.d("GameRoomPresenterImp", 2, "onPkMatchTimeout");
    if (GameEngine.a().A()) {
      this.a.a(this.i.getString(2131887334), null);
    }
  }
  
  public void k(EngineData paramEngineData)
  {
    int i1 = paramEngineData.j();
    int i2 = paramEngineData.o();
    if (i2 == 3) {
      a(i1, i2, paramEngineData);
    } else if (i2 == 4) {
      b(i1, i2, paramEngineData);
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("onNeedCheckAndPlayAudioVideo gameStatus:");
      paramEngineData.append(i1);
      paramEngineData.append(" gameType:");
      paramEngineData.append(i2);
      QLog.i("GameRoomPresenterImp", 2, paramEngineData.toString());
    }
  }
  
  public void l()
  {
    if (GameEngine.a().D()) {
      AVGameExceptionReporter.a().a(5, null, null, null);
    }
    QLog.d("GameRoomPresenterImp", 1, "onTopicTimeout");
    this.a.a(this.i.getString(2131887372), this.i.getString(2131887373), this.i.getString(2131887374), null, new GameRoomPresenterImp.6(this), true);
  }
  
  public void l(EngineData paramEngineData)
  {
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().n();
    int i1;
    if ((paramEngineData.f) && ((!paramEngineData.f) || (!paramEngineData.O()))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    paramEngineData = localIAVGameMediaPlayerCtrl;
    if (localIAVGameMediaPlayerCtrl == null)
    {
      paramEngineData = localIAVGameMediaPlayerCtrl;
      if (i1 == 0) {
        paramEngineData = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      }
    }
    if (paramEngineData != null) {
      paramEngineData.d();
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndReleaseAudioVideo");
    }
  }
  
  public Activity m()
  {
    return this.a.d();
  }
  
  public void m(EngineData paramEngineData)
  {
    int i1 = paramEngineData.j();
    int i2 = paramEngineData.o();
    if ((i1 != 0) && (i1 != 10))
    {
      if (i2 == 3)
      {
        c(i1, i2, paramEngineData);
        return;
      }
      if (i2 == 4) {
        d(i1, i2, paramEngineData);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("onNeedCheckAndPreloadAudioVideo gameStatus:");
      paramEngineData.append(i1);
      paramEngineData.append(" gameType:");
      paramEngineData.append(i2);
      QLog.i("GameRoomPresenterImp", 2, paramEngineData.toString());
    }
  }
  
  public List<MemberVideoDisplayInfo> n()
  {
    List localList = o();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.d.d();
    if (localObject1 != null) {
      localArrayList.addAll((Collection)localObject1);
    }
    RectF localRectF = this.c.b();
    Object localObject2 = null;
    localObject1 = null;
    if (localRectF != null)
    {
      int i1 = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i1 >= localArrayList.size()) {
          break;
        }
        localObject2 = (MemberVideoDisplayInfo)localArrayList.get(i1);
        if (((MemberVideoDisplayInfo)localObject2).h)
        {
          ((MemberVideoDisplayInfo)localObject2).b = Math.round(localRectF.left);
          ((MemberVideoDisplayInfo)localObject2).c = Math.round(localRectF.top);
          ((MemberVideoDisplayInfo)localObject2).d = Math.round(localRectF.width());
          ((MemberVideoDisplayInfo)localObject2).e = Math.round(localRectF.height());
          localObject1 = localObject2;
        }
        if (((MemberVideoDisplayInfo)localObject2).m)
        {
          ((MemberVideoDisplayInfo)localObject2).i = Math.round(localRectF.left);
          ((MemberVideoDisplayInfo)localObject2).j = Math.round(localRectF.top);
          ((MemberVideoDisplayInfo)localObject2).k = Math.round(localRectF.width());
          ((MemberVideoDisplayInfo)localObject2).l = Math.round(localRectF.height());
        }
        i1 += 1;
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
  
  public List<AVGameUserInfo> o()
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().j();
    ArrayList localArrayList = new ArrayList();
    if (localAVGameSession != null) {
      localAVGameSession.b(localArrayList);
    }
    return localArrayList;
  }
  
  public List<Player> p()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(GameEngine.a().s().e().getPlayers());
    return localArrayList;
  }
  
  public void q()
  {
    this.a.k();
  }
  
  public String r()
  {
    Object localObject = GameEngine.a().s().f();
    if (localObject != null) {
      localObject = ((GameItem)localObject).g;
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
  
  public String s()
  {
    Object localObject = GameEngine.a().s().f();
    if (localObject != null) {
      localObject = ((GameItem)localObject).f;
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
  
  public boolean t()
  {
    return this.p;
  }
  
  public RectF u()
  {
    return this.d.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp
 * JD-Core Version:    0.7.0.1
 */