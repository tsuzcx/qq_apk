package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistManager;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl.PushDecodeMsg;
import com.tencent.avgame.video.api.IVideoRouter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class GuessStarClickStagePresenter
  implements IGameStagePresenter
{
  IStagePresenter a;
  GuessStarClickStageView b;
  IAVGameMediaPlayerCtrl.PushDecodeMsg c;
  Handler d = new Handler(Looper.getMainLooper());
  boolean e = false;
  
  public GuessStarClickStagePresenter(GuessStarClickStageView paramGuessStarClickStageView)
  {
    this.b = paramGuessStarClickStageView;
  }
  
  private void a(IAVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg, boolean paramBoolean)
  {
    if (IAVGameBusinessCtrl.q()) {
      return;
    }
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl2 = IAVGameBusinessCtrl.p().n();
    int i;
    if ((GameEngine.a().A()) && (!GameEngine.a().B())) {
      i = 1;
    } else {
      i = 0;
    }
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl1 = localIAVGameMediaPlayerCtrl2;
    if (localIAVGameMediaPlayerCtrl2 == null)
    {
      localIAVGameMediaPlayerCtrl1 = localIAVGameMediaPlayerCtrl2;
      if (i != 0) {
        localIAVGameMediaPlayerCtrl1 = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      }
    }
    if (localIAVGameMediaPlayerCtrl1 != null)
    {
      if (paramPushDecodeMsg == null) {
        return;
      }
      if (paramBoolean)
      {
        localIAVGameMediaPlayerCtrl1.a(paramPushDecodeMsg);
        if (QLog.isColorLevel()) {
          QLog.i("GuessStarClickStagePresenter", 2, "changeVideoEndListener run ,registerPushDecideMsgListener");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("GuessStarClickStagePresenter", 2, "changeVideoEndListener run ,unRegisterPushDecideMsgListener");
        }
        localIAVGameMediaPlayerCtrl1.b(paramPushDecodeMsg);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    a(this.c, paramBoolean);
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  private void g(EngineData paramEngineData)
  {
    this.c = new GuessStarClickStagePresenter.2(this, paramEngineData);
  }
  
  public IStagePresenter a()
  {
    return this.a;
  }
  
  public String a(Context paramContext, EngineData paramEngineData)
  {
    paramContext = paramEngineData.f();
    if (paramContext == null)
    {
      QLog.d("GuessStarClickStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      return "";
    }
    paramEngineData = paramContext.t;
    paramContext = paramEngineData;
    if (!TextUtils.isEmpty(paramEngineData))
    {
      paramContext = paramEngineData;
      if (paramEngineData.contains("\\n")) {
        paramContext = paramEngineData.replace("\\n", "\n");
      }
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("getGamePrepareBottomTip result = ");
      paramEngineData.append(paramContext);
      QLog.d("GuessStarClickStagePresenter", 2, paramEngineData.toString());
    }
    return paramContext;
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessStarClickStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    EngineData localEngineData = GameEngine.a().s();
    ITopic localITopic = localEngineData.s();
    if ((localITopic != null) && ((localITopic instanceof TopicBase)) && (!TextUtils.isEmpty(((TopicBase)localITopic).r))) {
      return "";
    }
    if ((localEngineData.M()) && (localEngineData.Y() == 0)) {
      return paramContext.getResources().getString(2131887250);
    }
    return "";
  }
  
  public void a(ITopic paramITopic)
  {
    this.b.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    a(GameEngine.k(paramEngineData), false);
    this.a.a().e(false);
    this.a.a().m(paramEngineData);
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.a = paramIStagePresenter;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b.a(paramBoolean1, paramBoolean2);
  }
  
  public void b(EngineData paramEngineData)
  {
    c(false);
    g(paramEngineData);
    c(true);
    a(GameEngine.k(paramEngineData), true);
    a(paramEngineData.s());
    this.b.b(false);
    this.a.a().e(false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramEngineData.A() + 1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramEngineData.B());
    localObject = ((StringBuilder)localObject).toString();
    this.b.setTitleRight((String)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRealStartGame topicDuration = ");
      ((StringBuilder)localObject).append(paramEngineData.h().p());
      ((StringBuilder)localObject).append(",statusPassedTime = ");
      ((StringBuilder)localObject).append(paramEngineData.h().n());
      QLog.i("GuessStarClickStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
    this.a.a().k(paramEngineData);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    return false;
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.k(paramEngineData), true);
    a(paramEngineData.s());
    int i = paramEngineData.j();
    if ((!paramEngineData.O()) && ((i == 3) || (i == 4) || ((i == 2) && (paramEngineData.h().n() >= paramEngineData.h().p()))))
    {
      this.b.b(true);
      if (QLog.isColorLevel()) {
        QLog.i("GuessStarClickStagePresenter", 2, "onSwitchTopic restore");
      }
      if (paramEngineData.h().n() > paramEngineData.h().p()) {
        this.a.a(this.b.getTopicClockView(), paramEngineData.aj() * 1000, paramEngineData.h().n() - paramEngineData.h().p());
      } else {
        this.b.getTopicClockView().setVisibility(4);
      }
      this.e = true;
      ThreadManager.getSubThreadHandler().post(new GuessStarClickStagePresenter.1(this, paramEngineData));
    }
    else
    {
      c(false);
      g(paramEngineData);
      c(true);
      this.b.b(false);
      this.d.removeCallbacksAndMessages(null);
      this.e = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSwitchTopic topicDuration = ");
      ((StringBuilder)localObject).append(paramEngineData.h().p());
      ((StringBuilder)localObject).append(",statusPassedTime = ");
      ((StringBuilder)localObject).append(paramEngineData.h().n());
      ((StringBuilder)localObject).append("getDurationForClickPanelShow = ");
      ((StringBuilder)localObject).append(paramEngineData.aj() * 1000);
      QLog.i("GuessStarClickStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramEngineData.A() + 1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramEngineData.B());
    localObject = ((StringBuilder)localObject).toString();
    this.b.setTitleRight((String)localObject);
    this.a.a().k(paramEngineData);
  }
  
  public void d(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarClickStagePresenter", 2, "onAnswerRight run");
    }
  }
  
  public void e(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarClickStagePresenter", 2, "onAnswerTimeOut run");
    }
  }
  
  public void f(EngineData paramEngineData)
  {
    c(false);
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarClickStagePresenter", 2, "onGameOver run");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStagePresenter
 * JD-Core Version:    0.7.0.1
 */