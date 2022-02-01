package com.tencent.avgame.gameroom.pkstage;

import android.graphics.Color;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.IGameRoomPresenter;

public class GameSurvivalPkPresenterImpl
  implements ISurvivalStagePresenter
{
  protected EngineData a;
  private ISurvivalStageView b;
  private IGameRoomPresenter c;
  
  public GameSurvivalPkPresenterImpl(ISurvivalStageView paramISurvivalStageView)
  {
    this.b = paramISurvivalStageView;
  }
  
  private void a()
  {
    this.b.d();
  }
  
  private void a(EngineData paramEngineData, boolean paramBoolean)
  {
    this.b.a(paramEngineData.R(), paramBoolean);
  }
  
  private void b()
  {
    this.b.f();
  }
  
  private boolean b(EngineData paramEngineData)
  {
    EngineData localEngineData = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localEngineData != null)
    {
      if (paramEngineData == null) {
        return false;
      }
      bool1 = bool2;
      if (localEngineData != null)
      {
        bool1 = bool2;
        if (localEngineData.X() == paramEngineData.X()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c(EngineData paramEngineData)
  {
    this.b.b();
  }
  
  private void d(EngineData paramEngineData)
  {
    this.b.c();
  }
  
  private void e(EngineData paramEngineData)
  {
    this.b.a(paramEngineData.ag());
  }
  
  private void f(EngineData paramEngineData)
  {
    if (paramEngineData.x != null)
    {
      int i = 0;
      try
      {
        int j = Color.parseColor(paramEngineData.x.p);
        i = j;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.b.a(i);
      this.b.a(paramEngineData.x.q, paramEngineData.x.r, paramEngineData.x.s, paramEngineData.x.t, paramEngineData.x.u);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    if (paramEngineData == null) {
      return;
    }
    int i = paramEngineData.X();
    this.b.a(paramEngineData);
    EngineData localEngineData;
    switch (i)
    {
    case 3: 
    default: 
      break;
    case 10: 
      if (!b(paramEngineData)) {
        this.b.a(true);
      }
      break;
    case 8: 
    case 9: 
      if (!b(paramEngineData)) {
        this.b.e();
      }
      break;
    case 6: 
    case 7: 
      if (!b(paramEngineData)) {
        c(paramEngineData);
      }
      break;
    case 5: 
      if (!b(paramEngineData)) {
        this.b.a();
      }
      break;
    case 4: 
      if (!b(paramEngineData))
      {
        localEngineData = this.a;
        if ((localEngineData != null) && (localEngineData.X() == 9)) {
          this.b.e();
        } else {
          this.b.a(false);
        }
      }
      break;
    case 2: 
      if (!b(paramEngineData)) {
        a();
      }
      break;
    case 1: 
      if (b(paramEngineData))
      {
        a(paramEngineData, true);
      }
      else
      {
        localEngineData = this.a;
        if (((localEngineData != null) && (localEngineData.X() != 0)) || (this.a == null) || (paramEngineData == null)) {
          d(paramEngineData);
        }
      }
      break;
    case 0: 
      if (b(paramEngineData))
      {
        a(paramEngineData, false);
        if (paramEngineData.N()) {
          e(paramEngineData);
        } else {
          b();
        }
      }
      else
      {
        if (paramEngineData.N()) {
          f(paramEngineData);
        }
        a(paramEngineData, false);
        c(paramEngineData);
      }
      break;
    }
    this.a = paramEngineData.w();
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.c = paramIGameRoomPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.pkstage.GameSurvivalPkPresenterImpl
 * JD-Core Version:    0.7.0.1
 */