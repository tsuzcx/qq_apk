package com.tencent.avgame.gamelogic.controller;

import android.util.SparseArray;
import com.tencent.avgame.audio.AudioRouter;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.video.VideoRouter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class SurvivalAssistManager
  implements SurvivalAssistCallback, GameRoomStatusListener
{
  public static final int a;
  private static final SparseArray<SurvivalAssistCallback> a;
  public static final int b;
  private static int c = 0;
  
  static
  {
    int i = c;
    c = i + 1;
    jdField_a_of_type_Int = i;
    i = c;
    c = i + 1;
    b = i;
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(c);
  }
  
  public SurvivalAssistManager()
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(jdField_a_of_type_Int, new AudioRouter());
    jdField_a_of_type_AndroidUtilSparseArray.put(b, new VideoRouter());
  }
  
  public SurvivalAssistCallback a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= c)) {
      return null;
    }
    return (SurvivalAssistCallback)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString1, String paramString2, EngineData paramEngineData) {}
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt) {}
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void a(EngineData paramEngineData) {}
  
  public void a(EngineData paramEngineData, int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(String paramString, int paramInt, EngineData paramEngineData) {}
  
  public void a(String paramString, EngineData paramEngineData) {}
  
  public void a(HashMap<String, String> paramHashMap) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong) {}
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (GameEngine.a().f()) && (!GameEngine.a().g()))
    {
      d();
      QLog.d("SurvivalAssistManager", 1, "onSurvivalPoolEnter");
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(EngineData paramEngineData) {}
  
  public void b(String paramString, EngineData paramEngineData) {}
  
  public void b(boolean paramBoolean)
  {
    if ((GameEngine.a().f()) && (!GameEngine.a().g()))
    {
      e();
      QLog.d("SurvivalAssistManager", 1, "onSurvivalGameOver");
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong) {}
  
  public void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void c()
  {
    QLog.d("SurvivalAssistManager", 1, "clear");
    if ((GameEngine.a().f()) && (!GameEngine.a().g())) {
      e();
    }
  }
  
  public void c(EngineData paramEngineData, int paramInt) {}
  
  public void c(String paramString, EngineData paramEngineData) {}
  
  public void d()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((SurvivalAssistCallback)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).d();
      i += 1;
    }
  }
  
  public void e()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((SurvivalAssistCallback)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).e();
      i += 1;
    }
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalAssistManager
 * JD-Core Version:    0.7.0.1
 */