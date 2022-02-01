package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoAdStrategyManager
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  public static int b = 2;
  public static int c = 10;
  public static int d = 25;
  public static int e = 2;
  public static int f = 2;
  public static int g = 0;
  public static int h = 0;
  public static int i = 0;
  public static boolean j = false;
  public static boolean k = false;
  public static int l = 5;
  public static boolean m = false;
  public static AtomicInteger n = new AtomicInteger(0);
  public static int o = 0;
  public static int p = 0;
  public static int q = 0;
  
  public static void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null) && (n != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeVvCount  count : ");
      localStringBuilder.append(n.get());
      ReadInJoyAdLog.a("VideoAdStrategyManager", localStringBuilder.toString());
      if (paramVideoPlayParam.c.aq)
      {
        n.set(0);
        return;
      }
      int i1 = n.incrementAndGet();
      paramVideoPlayParam = new StringBuilder();
      paramVideoPlayParam.append("changeVvCount  count : ");
      paramVideoPlayParam.append(i1);
      ReadInJoyAdLog.a("VideoAdStrategyManager", paramVideoPlayParam.toString());
      return;
    }
    ReadInJoyAdLog.a("VideoAdStrategyManager", "changeVvCount error");
  }
  
  public static boolean a()
  {
    return b == 2;
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel())
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("judge isNotVVStrategy : adStrategy = ");
      localStringBuilder.append(b);
      localIRIJAdLogService.d("VideoAdStrategyManager", localStringBuilder.toString());
    }
    int i1 = b;
    boolean bool = true;
    if (i1 != 0)
    {
      if (i1 == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean c()
  {
    return m;
  }
  
  public static boolean d()
  {
    if (QLog.isColorLevel())
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("judge isNotMixStrategy : adStrategy = ");
      localStringBuilder.append(b);
      localIRIJAdLogService.d("VideoAdStrategyManager", localStringBuilder.toString());
    }
    return b != 3;
  }
  
  public static boolean e()
  {
    if (QLog.isColorLevel())
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("judge isNotTimeStrategy : adStrategy = ");
      localStringBuilder.append(b);
      localIRIJAdLogService.d("VideoAdStrategyManager", localStringBuilder.toString());
    }
    return b != 1;
  }
  
  public static boolean f()
  {
    return (a.get()) && (b == 1);
  }
  
  public static void g()
  {
    if (b != 0) {
      return;
    }
    Object localObject = Aladdin.getConfig(319);
    b = ((AladdinConfig)localObject).getIntegerFromString("strategy", 1);
    c = ((AladdinConfig)localObject).getIntegerFromString("ad_first_time", 10);
    d = ((AladdinConfig)localObject).getIntegerFromString("ad_interval_time", 25);
    e = ((AladdinConfig)localObject).getIntegerFromString("ad_pre_req", 2);
    f = ((AladdinConfig)localObject).getIntegerFromString("ad_protect_gap", 2);
    g = ((AladdinConfig)localObject).getIntegerFromString("ad_first_pos", 4);
    h = ((AladdinConfig)localObject).getIntegerFromString("ad_interval_pos", 3);
    i = ((AladdinConfig)localObject).getIntegerFromString("ad_protect_interval", 3);
    a.compareAndSet(false, true);
    localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAdStrategyFromAladin: strategy = ");
    localStringBuilder.append(b);
    localStringBuilder.append(" adFirstTime = ");
    localStringBuilder.append(c);
    localStringBuilder.append(" adIntervalTime = ");
    localStringBuilder.append(d);
    localStringBuilder.append(" adPreReq = ");
    localStringBuilder.append(e);
    localStringBuilder.append(" adProtectGap = ");
    localStringBuilder.append(f);
    localStringBuilder.append(" adFirstPos = ");
    localStringBuilder.append(g);
    localStringBuilder.append(" adIntervalPos = ");
    localStringBuilder.append(h);
    localStringBuilder.append(" adProtectInterval = ");
    localStringBuilder.append(i);
    ((IRIJAdLogService)localObject).d("VideoAdStrategy", localStringBuilder.toString());
  }
  
  public static void h()
  {
    a.compareAndSet(true, false);
    b = 0;
    j = false;
    k = false;
    n.set(0);
    o = 0;
    p = 0;
    q = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyManager
 * JD-Core Version:    0.7.0.1
 */