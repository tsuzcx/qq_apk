package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qphone.base.util.QLog;

public class GuessStarStagePresenter
  implements IGameStagePresenter
{
  IStagePresenter a;
  IGameStageView b;
  private boolean c = false;
  private Runnable d = new GuessStarStagePresenter.1(this);
  
  public GuessStarStagePresenter(IGameStageView paramIGameStageView)
  {
    this.b = paramIGameStageView;
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
      QLog.d("GuessStarStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
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
      QLog.d("GuessStarStagePresenter", 2, paramEngineData.toString());
    }
    return paramContext;
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessStarStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    String str = paramContext.getResources().getString(2131887174);
    EngineData localEngineData = GameEngine.a().s();
    ITopic localITopic = localEngineData.s();
    if ((localITopic != null) && ((localITopic instanceof TopicBase)) && (!TextUtils.isEmpty(((TopicBase)localITopic).r))) {
      return "";
    }
    if ((localEngineData.M()) && (localEngineData.Y() == 0)) {
      return paramContext.getResources().getString(2131887249);
    }
    if (localEngineData.M()) {
      return "";
    }
    return str;
  }
  
  public void a(int paramInt)
  {
    AVGameHandler.a().c().removeCallbacks(this.d);
    AVGameHandler.a().c().postDelayed(this.d, paramInt);
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
    if (!paramBoolean2) {
      c();
    }
  }
  
  public void b(EngineData paramEngineData)
  {
    a(GameEngine.k(paramEngineData), true);
    a(paramEngineData.s());
    Object localObject;
    if (this.b.a())
    {
      this.a.a().e(false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.A() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.B());
      localObject = ((StringBuilder)localObject).toString();
      this.b.setTitleRight((String)localObject);
    }
    else if (paramEngineData.h().f.d())
    {
      this.a.a().e(true);
      this.a.a().a(paramEngineData.h().f.c * 1000, paramEngineData.h().o());
    }
    else
    {
      this.a.a().e(true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.A() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.B());
      localObject = ((StringBuilder)localObject).toString();
      this.a.a().c((String)localObject);
    }
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().p(), paramEngineData.h().n());
    this.c = true;
    int i = paramEngineData.h().p() - paramEngineData.h().n() - 5000;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRealStartGame delayMs = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",topicDuration = ");
      ((StringBuilder)localObject).append(paramEngineData.h().p());
      ((StringBuilder)localObject).append(",statusPassedTime = ");
      ((StringBuilder)localObject).append(paramEngineData.h().n());
      QLog.i("GuessStarStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0) {
      a(i);
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
  
  public void c()
  {
    AVGameHandler.a().c().removeCallbacks(this.d);
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.k(paramEngineData), true);
    a(paramEngineData.s());
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().p(), paramEngineData.h().n());
    int i = paramEngineData.h().p() - paramEngineData.h().n() - 5000;
    if ((i > 0) && (this.c)) {
      a(i);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSwitchTopic delayMs = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",topicDuration = ");
      ((StringBuilder)localObject).append(paramEngineData.h().p());
      ((StringBuilder)localObject).append(",statusPassedTime = ");
      ((StringBuilder)localObject).append(paramEngineData.h().n());
      QLog.i("GuessStarStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.A() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.B());
      localObject = ((StringBuilder)localObject).toString();
      this.b.setTitleRight((String)localObject);
    }
    else if (paramEngineData.h().f.d())
    {
      this.a.a().a(paramEngineData.h().f.c * 1000, paramEngineData.h().o());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.A() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.B());
      localObject = ((StringBuilder)localObject).toString();
      this.a.a().c((String)localObject);
    }
    this.a.a().k(paramEngineData);
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter
 * JD-Core Version:    0.7.0.1
 */