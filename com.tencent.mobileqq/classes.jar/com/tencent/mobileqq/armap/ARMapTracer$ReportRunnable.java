package com.tencent.mobileqq.armap;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ARMapTracer$ReportRunnable
  implements Runnable
{
  public String a;
  public boolean b;
  public float c;
  public float d;
  public float e;
  public float f;
  public long g;
  public int h;
  
  public ARMapTracer$ReportRunnable(String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    if (this.g < 0L) {
      this.g = 0L;
    }
    for (;;)
    {
      try
      {
        this.g /= 1000L;
        Object localObject = new HashMap(10);
        Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
        if ((arrayOfMemoryInfo == null) || (arrayOfMemoryInfo.length <= 0)) {
          break label494;
        }
        k = arrayOfMemoryInfo[0].getTotalPss();
        i = arrayOfMemoryInfo[0].otherPss;
        m = arrayOfMemoryInfo[0].nativePss;
        j = arrayOfMemoryInfo[0].dalvikPss;
        ((HashMap)localObject).put("fpsAvg", String.valueOf(this.c));
        ((HashMap)localObject).put("fps0", String.valueOf(this.d));
        ((HashMap)localObject).put("fps18", String.valueOf(this.e));
        ((HashMap)localObject).put("fps25", String.valueOf(this.f));
        ((HashMap)localObject).put("duration", String.valueOf(this.g));
        ((HashMap)localObject).put("pss", String.valueOf(k));
        ((HashMap)localObject).put("level", String.valueOf(this.h));
        ((HashMap)localObject).put("devType", String.valueOf(ARMapTracer.a()));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a, "actARMapTrace", this.b, this.g, k, (HashMap)localObject, null);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder(200);
          ((StringBuilder)localObject).append("ReportRunnable [");
          ((StringBuilder)localObject).append("suc: ");
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append(", duration: ");
          ((StringBuilder)localObject).append(this.g);
          ((StringBuilder)localObject).append(", fpsAvg: ");
          ((StringBuilder)localObject).append(this.c);
          ((StringBuilder)localObject).append(", fps0: ");
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append(", fps18: ");
          ((StringBuilder)localObject).append(this.e);
          ((StringBuilder)localObject).append(", fps25: ");
          ((StringBuilder)localObject).append(this.f);
          ((StringBuilder)localObject).append(", level: ");
          ((StringBuilder)localObject).append(this.h);
          ((StringBuilder)localObject).append(", pss: ");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(", otherPss: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", nativePss: ");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(", dalvikPss: ");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append("]");
          QLog.i("ARMapTracer", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label494:
      int i = 0;
      int k = 0;
      int m = 0;
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapTracer.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */