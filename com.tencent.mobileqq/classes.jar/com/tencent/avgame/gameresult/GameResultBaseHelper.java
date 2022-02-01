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
    if (IGameEngine.k()) {
      return;
    }
    EngineData localEngineData = IGameEngine.a().a();
    IGameEngine.a().a(localEngineData.b());
    IGameEngine.a().a(false, 1, paramBoolean);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  @Deprecated
  public void e() {}
  
  public void f()
  {
    a(false);
  }
  
  @Deprecated
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultBaseHelper
 * JD-Core Version:    0.7.0.1
 */