package com.tencent.avgame.qav;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class AsyncExitTask
{
  private static boolean jdField_a_of_type_Boolean = false;
  private static boolean b;
  private int jdField_a_of_type_Int = -1;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("LYA-AL00")) && (!Build.MODEL.equalsIgnoreCase("MI 9")) && (!Build.MODEL.equalsIgnoreCase("vivo Y66")) && (!Build.MODEL.equalsIgnoreCase("vivo Y67")) && (!Build.MODEL.equalsIgnoreCase("vivo Y67A")) && (!Build.MODEL.equalsIgnoreCase("vivo Y67L")) && (!Build.MODEL.equalsIgnoreCase("vivo X9Plus")) && (!Build.MODEL.equalsIgnoreCase("vivo X9Plus L")) && (!Build.MODEL.equalsIgnoreCase("vivo X9s")) && (!Build.MODEL.equalsIgnoreCase("vivo X9s L")) && (!Build.MODEL.equalsIgnoreCase("vivo X9s Plus")) && (!Build.MODEL.equalsIgnoreCase("vivo X9s Plus L")) && (!Build.MODEL.equalsIgnoreCase("Redmi S2"))) {
      bool = false;
    } else {
      bool = true;
    }
    b = bool;
  }
  
  public static void a()
  {
    if ((!b) && (!jdField_a_of_type_Boolean)) {
      ThreadManager.excute(new AsyncExitTask.1(), 16, null, true);
    }
  }
  
  public static boolean a()
  {
    if (!b)
    {
      long l = SystemClock.elapsedRealtime();
      String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qavAsyncQuitCfg.name(), "0");
      if ("1".equals(str)) {
        b = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("useAsync, dpcValue[");
        localStringBuilder.append(str);
        localStringBuilder.append("], model[");
        localStringBuilder.append(Build.MODEL);
        localStringBuilder.append("], cost[");
        localStringBuilder.append(SystemClock.elapsedRealtime() - l);
        localStringBuilder.append("], initDpcMng[");
        localStringBuilder.append(jdField_a_of_type_Boolean);
        localStringBuilder.append("]");
        QLog.i("AsyncExitTask", 2, localStringBuilder.toString());
      }
    }
    return b;
  }
  
  public int a(QQGAudioCtrl arg1)
  {
    this.jdField_a_of_type_Int = -1000001;
    ThreadManager.excute(new AsyncExitTask.2(this, ???), 16, null, false);
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait(2000);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      int i;
      if (this.jdField_a_of_type_Int == -1000001) {
        i = 261;
      } else {
        i = -1;
      }
      ??? = new StringBuilder();
      ???.append("asyncExitRoom.quitRoom end. continue. quitResult = ");
      ???.append(this.jdField_a_of_type_Int);
      QLog.d("AsyncExitTask", 1, ???.toString());
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AsyncExitTask
 * JD-Core Version:    0.7.0.1
 */