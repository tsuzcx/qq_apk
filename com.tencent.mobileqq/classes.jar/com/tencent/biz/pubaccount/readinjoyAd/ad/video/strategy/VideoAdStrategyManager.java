package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
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
    AladdinConfig localAladdinConfig = Aladdin.getConfig(319);
    jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("strategy", 1);
    jdField_b_of_type_Int = localAladdinConfig.getIntegerFromString("ad_first_time", 10);
    jdField_c_of_type_Int = localAladdinConfig.getIntegerFromString("ad_interval_time", 25);
    d = localAladdinConfig.getIntegerFromString("ad_pre_req", 2);
    e = localAladdinConfig.getIntegerFromString("ad_protect_gap", 2);
    f = localAladdinConfig.getIntegerFromString("ad_first_pos", 4);
    g = localAladdinConfig.getIntegerFromString("ad_interval_pos", 3);
    h = localAladdinConfig.getIntegerFromString("ad_protect_interval", 3);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
    ReadInJoyAdLog.a("VideoAdStrategy", "setAdStrategyFromAladin: strategy = " + jdField_a_of_type_Int + " adFirstTime = " + jdField_b_of_type_Int + " adIntervalTime = " + jdField_c_of_type_Int + " adPreReq = " + d + " adProtectGap = " + e + " adFirstPos = " + f + " adIntervalPos = " + g + " adProtectInterval = " + h);
  }
  
  public static void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam == null) || (paramVideoPlayParam.a == null) || (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger == null))
    {
      ReadInJoyAdLog.a("VideoAdStrategyManager", "changeVvCount error");
      return;
    }
    ReadInJoyAdLog.a("VideoAdStrategyManager", "changeVvCount  count : " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if (paramVideoPlayParam.a.jdField_c_of_type_Boolean)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      return;
    }
    int m = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    ReadInJoyAdLog.a("VideoAdStrategyManager", "changeVvCount  count : " + m);
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      ReadInJoyAdLog.a("VideoAdStrategyManager", "judge isNotVVStrategy : adStrategy = " + jdField_a_of_type_Int);
    }
    return (jdField_a_of_type_Int == 0) || (jdField_a_of_type_Int == 1);
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
    if (QLog.isColorLevel()) {
      ReadInJoyAdLog.a("VideoAdStrategyManager", "judge isNotMixStrategy : adStrategy = " + jdField_a_of_type_Int);
    }
    return jdField_a_of_type_Int != 3;
  }
  
  public static boolean c()
  {
    if (QLog.isColorLevel()) {
      ReadInJoyAdLog.a("VideoAdStrategyManager", "judge isNotTimeStrategy : adStrategy = " + jdField_a_of_type_Int);
    }
    return jdField_a_of_type_Int != 1;
  }
  
  public static boolean d()
  {
    return (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (jdField_a_of_type_Int == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyManager
 * JD-Core Version:    0.7.0.1
 */