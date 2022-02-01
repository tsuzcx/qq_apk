package com.tencent.avgame.gamelogic.listener;

import com.tencent.avgame.gamelogic.data.EngineData;

public abstract interface GameResultListener
{
  public abstract void a(EngineData paramEngineData, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString, int paramInt, EngineData paramEngineData);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2);
  
  public abstract void i(EngineData paramEngineData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.listener.GameResultListener
 * JD-Core Version:    0.7.0.1
 */