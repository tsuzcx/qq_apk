package com.tencent.avgame.gamelogic.listener;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import java.util.HashMap;

public abstract interface GameRoomStatusListener
{
  public abstract void a(int paramInt, String paramString1, String paramString2, EngineData paramEngineData);
  
  public abstract void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt);
  
  public abstract void a(long paramLong, boolean paramBoolean);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(EngineData paramEngineData, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString, int paramInt, EngineData paramEngineData);
  
  public abstract void a(String paramString, EngineData paramEngineData);
  
  public abstract void a(HashMap<String, String> paramHashMap);
  
  public abstract void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong);
  
  public abstract void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2);
  
  public abstract void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo);
  
  public abstract void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(boolean paramBoolean, long paramLong, int paramInt, String paramString);
  
  public abstract void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString);
  
  public abstract void a(boolean paramBoolean, String paramString);
  
  public abstract boolean a(int paramInt, String paramString, EngineData paramEngineData);
  
  public abstract void b(EngineData paramEngineData);
  
  public abstract void b(String paramString, EngineData paramEngineData);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong);
  
  public abstract void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString);
  
  public abstract void c(EngineData paramEngineData, int paramInt);
  
  public abstract void c(String paramString, EngineData paramEngineData);
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.listener.GameRoomStatusListener
 * JD-Core Version:    0.7.0.1
 */