package com.tencent.av.app;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class GMemoryMonitor
{
  VideoAppInterface a;
  ComponentCallbacks b;
  
  public GMemoryMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        if (this.b != null)
        {
          this.a.getApplication().unregisterComponentCallbacks(this.b);
          this.b = null;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GMemoryMonitor", 2, "onDestroy unregisterComponentCallbacks failed", localThrowable);
        }
      }
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportLowMemory  level = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",isExit = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("GMemoryMonitor", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("lowMemoryLevel", String.valueOf(paramInt));
      ((HashMap)localObject1).put("isExit", String.valueOf(paramBoolean));
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "av_qua_low_memory", true, 0L, 0L, (HashMap)localObject1, "", true);
      localObject1 = Build.MODEL;
      Object localObject2 = String.valueOf(Build.VERSION.SDK_INT);
      String str1 = this.a.getCurrentAccountUin();
      StringBuilder localStringBuilder1 = new StringBuilder();
      Object localObject3 = this.a.b().k();
      if (localObject3 != null)
      {
        String str2 = ((SessionInfo)localObject3).s;
        localObject3 = ((SessionInfo)localObject3).f;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.a.b().p(str2));
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("reportLowMemory  ,roomID = ");
          localStringBuilder2.append((String)localObject4);
          QLog.d("GMemoryMonitor", 2, localStringBuilder2.toString());
        }
        localStringBuilder1.append("Android");
        localStringBuilder1.append('|');
        localStringBuilder1.append((String)localObject1);
        localStringBuilder1.append('|');
        localStringBuilder1.append((String)localObject2);
        localStringBuilder1.append('|');
        localStringBuilder1.append((String)localObject2);
        localStringBuilder1.append('|');
        localStringBuilder1.append(str1);
        localStringBuilder1.append('|');
        localStringBuilder1.append(str2);
        localStringBuilder1.append('|');
        localStringBuilder1.append((String)localObject4);
        localStringBuilder1.append('|');
        localStringBuilder1.append((String)localObject3);
        localStringBuilder1.append('|');
        localStringBuilder1.append(paramInt);
      }
      localObject1 = localStringBuilder1.toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportLowMemory  dcDetail = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("GMemoryMonitor", 2, ((StringBuilder)localObject2).toString());
      }
      DcReportUtil.a(null, "dc02660", (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("GMemoryMonitor", 1, "reportLowMemory  Exception", localException);
    }
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        if (this.b == null)
        {
          this.b = new GMemoryMonitor.1(this);
          BaseApplicationImpl.getApplication().getApplicationContext().registerComponentCallbacks(this.b);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("GMemoryMonitor", 1, "registerComponentCallbacks failed", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GMemoryMonitor
 * JD-Core Version:    0.7.0.1
 */