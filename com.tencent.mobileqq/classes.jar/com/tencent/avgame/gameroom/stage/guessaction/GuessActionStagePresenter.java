package com.tencent.avgame.gameroom.stage.guessaction;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class GuessActionStagePresenter
  implements IGameStagePresenter
{
  IStagePresenter a;
  IGameStageView b;
  private boolean c = false;
  
  public GuessActionStagePresenter(IGameStageView paramIGameStageView)
  {
    this.b = paramIGameStageView;
  }
  
  public IStagePresenter a()
  {
    return this.a;
  }
  
  public String a(Context paramContext, EngineData paramEngineData)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGamePrepareBottomTip null context");
      }
      return "";
    }
    boolean bool = IGameEngine.k(paramEngineData);
    paramEngineData = paramEngineData.h().b.nick;
    if (bool) {
      return paramContext.getResources().getString(2131887176);
    }
    return String.format(paramContext.getResources().getString(2131887177), new Object[] { ContactUtils.a(paramEngineData, 8.0F) });
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return paramContext.getResources().getString(2131887175);
      }
      return paramContext.getResources().getString(2131887180);
    }
    return paramContext.getResources().getString(2131887174);
  }
  
  public void a(ITopic paramITopic)
  {
    this.b.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    if ((!this.c) && (GameEngine.a().s().e().opened_match))
    {
      this.a.a().b(this.a.a().m().getString(2131887187));
      this.c = true;
    }
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
    this.a.a().e(true);
    this.a.a().a(paramEngineData.h().f.c * 1000, paramEngineData.h().o());
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().f.e * 1000, paramEngineData.h().n());
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean b(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void c(EngineData paramEngineData)
  {
    a(GameEngine.k(paramEngineData), true);
    a(paramEngineData.s());
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().f.e * 1000, paramEngineData.h().n());
    this.a.a().a(paramEngineData.h().f.c * 1000, paramEngineData.h().o());
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData)
  {
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.GuessActionStagePresenter
 * JD-Core Version:    0.7.0.1
 */