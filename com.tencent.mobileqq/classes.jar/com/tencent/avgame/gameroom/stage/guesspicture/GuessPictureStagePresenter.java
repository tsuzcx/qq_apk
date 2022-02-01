package com.tencent.avgame.gameroom.stage.guesspicture;

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

public class GuessPictureStagePresenter
  implements IGameStagePresenter
{
  IStagePresenter a;
  IGameStageView b;
  
  public GuessPictureStagePresenter(IGameStageView paramIGameStageView)
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
    if (paramContext != null)
    {
      if (paramContext.a == 2)
      {
        paramContext = MobileQQ.sMobileQQ;
        paramContext = MobileQQ.getContext().getResources().getString(2131887252);
      }
      else
      {
        paramContext = paramContext.t;
        paramEngineData = paramContext;
        if (!TextUtils.isEmpty(paramContext))
        {
          paramEngineData = paramContext;
          if (paramContext.contains("\\n")) {
            paramEngineData = paramContext.replace("\\n", "\n");
          }
        }
        paramContext = paramEngineData;
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("getGamePrepareBottomTip result = ");
          paramContext.append(paramEngineData);
          QLog.d("GuessPictureStagePresenter", 2, paramContext.toString());
          paramContext = paramEngineData;
        }
      }
    }
    else {
      paramContext = null;
    }
    paramEngineData = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = MobileQQ.sMobileQQ;
      paramEngineData = MobileQQ.getContext().getResources().getString(2131887252);
    }
    return paramEngineData;
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
    String str = paramContext.getResources().getString(2131887253);
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
    a(GameEngine.a().d(), false);
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
    a(GameEngine.a().d(), true);
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
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().f.e * 1000, paramEngineData.h().n());
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
    a(GameEngine.a().d(), true);
    a(paramEngineData.s());
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().p(), paramEngineData.h().n());
    if (this.b.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramEngineData.A() + 1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramEngineData.B());
      paramEngineData = localStringBuilder.toString();
      this.b.setTitleRight(paramEngineData);
      return;
    }
    if (paramEngineData.h().f.d())
    {
      this.a.a().a(paramEngineData.h().f.c * 1000, paramEngineData.h().o());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEngineData.A() + 1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramEngineData.B());
    paramEngineData = localStringBuilder.toString();
    this.a.a().c(paramEngineData);
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStagePresenter
 * JD-Core Version:    0.7.0.1
 */