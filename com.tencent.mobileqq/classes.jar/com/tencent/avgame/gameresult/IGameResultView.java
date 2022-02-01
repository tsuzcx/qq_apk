package com.tencent.avgame.gameresult;

import android.app.Activity;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.EngineData;

public abstract interface IGameResultView
{
  public abstract Activity a();
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(AVGameAppInterface paramAVGameAppInterface, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public abstract void b(EngineData paramEngineData);
  
  public abstract void b(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.IGameResultView
 * JD-Core Version:    0.7.0.1
 */