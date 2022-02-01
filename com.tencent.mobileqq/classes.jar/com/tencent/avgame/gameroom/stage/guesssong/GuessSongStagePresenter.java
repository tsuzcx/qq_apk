package com.tencent.avgame.gameroom.stage.guesssong;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GuessSongStagePresenter
  implements IGameStagePresenter
{
  IStagePresenter a;
  IGameStageView b;
  
  public GuessSongStagePresenter(IGameStageView paramIGameStageView)
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
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      paramContext = "";
    }
    else
    {
      paramContext = paramContext.t;
    }
    Object localObject = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = MobileQQ.sMobileQQ;
      localObject = MobileQQ.getContext().getResources().getString(2131887255);
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
    }
    paramContext = paramEngineData.x();
    if (!TextUtils.isEmpty(paramContext))
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append(paramContext);
      paramEngineData.append("\n");
      paramContext = paramEngineData.toString();
    }
    else
    {
      QLog.e("GuessPictureStagePresenter", 1, "songTypeString tips isEmpty");
    }
    if (TextUtils.isEmpty(paramContext)) {
      return localObject;
    }
    paramEngineData = new StringBuilder();
    paramEngineData.append(paramContext);
    paramEngineData.append((String)localObject);
    return paramEngineData.toString();
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    String str = paramContext.getResources().getString(2131887254);
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
  
  public void a(ITopic paramITopic)
  {
    this.b.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    a(GameEngine.k(paramEngineData), false);
    this.a.a().e(false);
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
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().p(), paramEngineData.h().n());
    Object localObject;
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
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongStagePresenter
 * JD-Core Version:    0.7.0.1
 */