package com.tencent.avgame.gamelogic;

import com.tencent.avgame.gamelogic.controller.HeartBeatController;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QualityReporter
{
  public static long a = 0L;
  
  public static void a()
  {
    long l = Math.abs(System.currentTimeMillis() - a);
    HashMap localHashMap;
    String str;
    if ((a == 0L) || (l > HeartBeatController.a * 3))
    {
      localHashMap = new HashMap();
      if (a != 0L) {
        break label121;
      }
      str = "1";
      localHashMap.put("report_key_param_is_local_heart_beat_stop", str);
      if (QLog.isColorLevel()) {
        if (a != 0L) {
          break label127;
        }
      }
    }
    label121:
    label127:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QualityReporter", 2, String.format("reportHeartBeatExp [isStop，duration]=[%b,%d]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) }));
      ThreadManager.post(new QualityReporter.3(l, localHashMap), 5, null, false);
      return;
      str = "0";
      break;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ThreadManager.post(new QualityReporter.2(paramInt1, paramInt2, paramInt3, paramInt4), 5, null, false);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.post(new QualityReporter.1(paramBoolean, paramInt), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.QualityReporter
 * JD-Core Version:    0.7.0.1
 */