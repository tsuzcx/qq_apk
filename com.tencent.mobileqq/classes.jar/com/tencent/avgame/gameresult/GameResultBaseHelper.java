package com.tencent.avgame.gameresult;

import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;

public abstract class GameResultBaseHelper
  implements IGameResultPresenter
{
  public abstract void a();
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    EngineData localEngineData = GameEngine.a().a();
    GameEngine.a().a(localEngineData.b());
    GameEngine.a().a(false, 1, paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultBaseHelper
 * JD-Core Version:    0.7.0.1
 */