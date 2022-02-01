package com.tencent.avgame.gameresult;

import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;

public abstract class GameResultBaseHelper
  implements IGameResultPresenter
{
  public abstract void a();
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (IGameEngine.J()) {
      return;
    }
    EngineData localEngineData = IGameEngine.I().s();
    IGameEngine.I().a(localEngineData.n());
    IGameEngine.I().a(false, 1, paramBoolean);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public boolean f()
  {
    return false;
  }
  
  @Deprecated
  public void g() {}
  
  public void h()
  {
    a(false);
  }
  
  @Deprecated
  public void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultBaseHelper
 * JD-Core Version:    0.7.0.1
 */