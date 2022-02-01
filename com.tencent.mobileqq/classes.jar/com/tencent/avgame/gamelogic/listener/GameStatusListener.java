package com.tencent.avgame.gamelogic.listener;

import com.tencent.avgame.gamelogic.data.EngineData;

public abstract interface GameStatusListener
{
  public abstract void a(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(long paramLong, String paramString1, String paramString2);
  
  public abstract void a(EngineData paramEngineData, String paramString);
  
  public abstract void a(EngineData paramEngineData, boolean paramBoolean);
  
  public abstract void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void b(long paramLong, String paramString1, String paramString2);
  
  public abstract void b(EngineData paramEngineData, int paramInt);
  
  public abstract void c(EngineData paramEngineData);
  
  public abstract void d(EngineData paramEngineData);
  
  public abstract void d(String paramString, EngineData paramEngineData);
  
  public abstract void e(EngineData paramEngineData);
  
  public abstract void e(String paramString, EngineData paramEngineData);
  
  public abstract void f(EngineData paramEngineData);
  
  public abstract void g(EngineData paramEngineData);
  
  public abstract void h(EngineData paramEngineData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.listener.GameStatusListener
 * JD-Core Version:    0.7.0.1
 */