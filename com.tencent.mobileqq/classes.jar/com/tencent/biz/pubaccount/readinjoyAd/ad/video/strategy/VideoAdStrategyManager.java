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
  public static int a;
  public static AtomicBoolean a;
  public static AtomicInteger a;
  public static boolean a;
  public static int b;
  public static boolean b;
  public static int c;
  public static boolean c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j = 0;
  public static int k = 0;
  public static int l = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_Int = 2;
    jdField_b_of_type_Int = 10;
    jdField_c_of_type_Int = 25;
    d = 2;
    e = 2;
    f = 0;
    g = 0;
    h = 0;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    i = 5;
    jdField_c_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Int != 0) {
      return;
    }
    Object localObject = Aladdin.getConfig(319);
    jdField_a_of_type_Int = ((AladdinConfig)localObject).getIntegerFromString("strategy", 1);
    jdField_b_of_type_Int = ((AladdinConfig)localObject).getIntegerFromString("ad_first_time", 10);
    jdField_c_of_type_Int = ((AladdinConfig)localObject).getIntegerFromString("ad_interval_time", 25);
    d = ((AladdinConfig)localObject).getIntegerFromString("ad_pre_req", 2);
    e = ((AladdinConfig)localObject).getIntegerFromString("ad_protect_gap", 2);
    f = ((AladdinConfig)localObject).getIntegerFromString("ad_first_pos", 4);
    g = ((AladdinConfig)localObject).getIntegerFromString("ad_interval_pos", 3);
    h = ((AladdinConfig)localObject).getIntegerFromString("ad_protect_interval", 3);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
    localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAdStrategyFromAladin: strategy = ");
    localStringBuilder.append(jdField_a_of_type_Int);
    localStringBuilder.append(" adFirstTime = ");
    localStringBuilder.append(jdField_b_of_type_Int);
    localStringBuilder.append(" adIntervalTime = ");
    localStringBuilder.append(jdField_c_of_type_Int);
    localStringBuilder.append(" adPreReq = ");
    localStringBuilder.append(d);
    localStringBuilder.append(" adProtectGap = ");
    localStringBuilder.append(e);
    localStringBuilder.append(" adFirstPos = ");
    localStringBuilder.append(f);
    localStringBuilder.append(" adIntervalPos = ");
    localStringBuilder.append(g);
    localStringBuilder.append(" adProtectInterval = ");
    localStringBuilder.append(h);
    ((IRIJAdLogService)localObject).d("VideoAdStrategy", localStringBuilder.toString());
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.a != null) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeVvCount  count : ");
      localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      ReadInJoyAdLog.a("VideoAdStrategyManager", localStringBuilder.toString());
      if (paramVideoPlayParam.a.r)
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        return;
      }
      int m = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      paramVideoPlayParam = new StringBuilder();
      paramVideoPlayParam.append("changeVvCount  count : ");
      paramVideoPlayParam.append(m);
      ReadInJoyAdLog.a("VideoAdStrategyManager", paramVideoPlayParam.toString());
      return;
    }
    ReadInJoyAdLog.a("VideoAdStrategyManager", "changeVvCount error");
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Int == 2;
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    j = 0;
    k = 0;
    l = 0;
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel())
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("judge isNotVVStrategy : adStrategy = ");
      localStringBuilder.append(jdField_a_of_type_Int);
      localIRIJAdLogService.d("VideoAdStrategyManager", localStringBuilder.toString());
    }
    int m = jdField_a_of_type_Int;
    boolean bool = true;
    if (m != 0)
    {
      if (m == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean c()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static boolean d()
  {
    if (QLog.isColorLevel())
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("judge isNotMixStrategy : adStrategy = ");
      localStringBuilder.append(jdField_a_of_type_Int);
      localIRIJAdLogService.d("VideoAdStrategyManager", localStringBuilder.toString());
    }
    return jdField_a_of_type_Int != 3;
  }
  
  public static boolean e()
  {
    if (QLog.isColorLevel())
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("judge isNotTimeStrategy : adStrategy = ");
      localStringBuilder.append(jdField_a_of_type_Int);
      localIRIJAdLogService.d("VideoAdStrategyManager", localStringBuilder.toString());
    }
    return jdField_a_of_type_Int != 1;
  }
  
  public static boolean f()
  {
    return (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (jdField_a_of_type_Int == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyManager
 * JD-Core Version:    0.7.0.1
 */