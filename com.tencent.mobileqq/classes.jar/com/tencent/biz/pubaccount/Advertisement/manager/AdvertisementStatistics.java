package com.tencent.biz.pubaccount.Advertisement.manager;

import android.os.SystemClock;
import com.tencent.mobileqq.imaxad.inject.ImaxadThirdProcessorProxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AdvertisementStatistics
{
  private static AdvertisementStatistics f = new AdvertisementStatistics();
  public ImaxadThirdProcessorProxy a = new ImaxadThirdProcessorProxy();
  private long b = 0L;
  private AdvertisementStatistics.Report c = new AdvertisementStatistics.Report(null);
  private boolean d = false;
  private boolean e = false;
  
  public static AdvertisementStatistics a()
  {
    try
    {
      if (f == null) {
        f = new AdvertisementStatistics();
      }
      AdvertisementStatistics localAdvertisementStatistics = f;
      return localAdvertisementStatistics;
    }
    finally {}
  }
  
  public static void b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoId", paramString2);
    localHashMap.put("uin", paramString1);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "IMAX_Ad_VIDEO_PRELOADED_RATE", true, 0L, 0L, localHashMap, "", false);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportImaxVideoCoverRate:");
      paramString1.append(paramString2);
      QLog.i("AdvertisementStatistics", 2, paramString1.toString());
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    this.d = false;
    this.e = false;
    this.c.b();
    this.b = paramLong;
    long l = this.a.b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mClickTime:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" sToolShowTime:");
      ((StringBuilder)localObject).append(l);
      QLog.i("AdvertisementStatistics", 2, ((StringBuilder)localObject).toString());
    }
    if ((l != 0L) && (l <= paramLong))
    {
      localObject = this.c;
      ((AdvertisementStatistics.Report)localObject).d = 1;
      ((AdvertisementStatistics.Report)localObject).g = 0L;
    }
    else
    {
      localObject = this.c;
      ((AdvertisementStatistics.Report)localObject).d = 0;
      ((AdvertisementStatistics.Report)localObject).g = (l - paramLong);
    }
    l = SystemClock.uptimeMillis();
    Object localObject = this.c;
    ((AdvertisementStatistics.Report)localObject).f = (l - paramLong);
    ((AdvertisementStatistics.Report)localObject).b = paramString;
    ((AdvertisementStatistics.Report)localObject).j = paramBoolean;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.c.a = "IMAX_Ad_videoLoadErr";
    HashMap localHashMap = new HashMap();
    localHashMap.put("adId", paramString1);
    localHashMap.put("vid", paramString2);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.b;
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementStatistics", 2, this.c.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "IMAX_Ad_videoLoadErr", true, l1 - l2, 0L, localHashMap, "", false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.e) {
      return;
    }
    this.e = true;
    AdvertisementStatistics.Report localReport = this.c;
    localReport.a = "IMAX_Ad_Remind_Dialog_Click";
    localReport.b = paramString1;
    localReport.c = paramString2;
    paramString1 = localReport.a();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(this.c.toString());
      paramString2.append(" ok ");
      paramString2.append(paramBoolean);
      QLog.i("AdvertisementStatistics", 2, paramString2.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", this.c.a, paramBoolean, this.c.h, 0L, paramString1, "", false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    Object localObject = this.c.a();
    if (paramBoolean) {
      this.c.a = "IMAX_Ad_StartCost_ByUsr";
    } else {
      this.c.a = "IMAX_Ad_StartCost";
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", this.c.a, true, this.c.i, 0L, (HashMap)localObject, "", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remindUsr:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(this.c.toString());
      QLog.i("AdvertisementStatistics", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b()
  {
    if (this.c.h == -1L) {
      this.c.h = (SystemClock.uptimeMillis() - this.b);
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (this.c.i == -1L)
    {
      AdvertisementStatistics.Report localReport = this.c;
      localReport.c = paramString;
      localReport.i = (SystemClock.uptimeMillis() - this.b);
      a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics
 * JD-Core Version:    0.7.0.1
 */