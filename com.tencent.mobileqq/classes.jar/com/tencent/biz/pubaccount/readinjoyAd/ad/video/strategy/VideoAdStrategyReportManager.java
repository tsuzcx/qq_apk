package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoAdStrategyReportManager
{
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoAdStrategyReportManager.1(this, Looper.getMainLooper());
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean = false;
  
  private int a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.size();
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((!paramBoolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1))
    {
      localStringBuilder = new StringBuilder().append("repeat startPlay, so return isMainThread : ");
      if (Looper.myLooper() == Looper.getMainLooper()) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        ReadInJoyAdLog.a("VideoAdReportManager", paramBoolean);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startTiming :").append(this.jdField_a_of_type_Long).append(" isMainThread : ");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ReadInJoyAdLog.a("VideoAdReportManager", paramBoolean);
      this.jdField_a_of_type_Long += 1L;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 1000L);
      return;
    }
  }
  
  private int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Integer)((Map.Entry)localIterator.next()).getValue()).intValue() + i) {}
    return i;
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.a != null))
    {
      if (paramVideoPlayParam.a.c)
      {
        paramVideoPlayParam = paramVideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportData;
        if (paramVideoPlayParam.jdField_a_of_type_Int <= 0)
        {
          ReadInJoyAdLog.a("VideoAdReportManager", "lastAdDistance: " + a());
          paramVideoPlayParam.jdField_a_of_type_Int = a();
        }
        if (paramVideoPlayParam.jdField_a_of_type_Long <= 0L)
        {
          ReadInJoyAdLog.a("VideoAdReportManager", "lastAdTime: " + a());
          paramVideoPlayParam.jdField_a_of_type_Long = a();
        }
        if (paramVideoPlayParam.b <= 0)
        {
          paramVideoPlayParam.b = b();
          ReadInJoyAdLog.a("VideoAdReportManager", "lastAdDistanceVV: " + b());
        }
        h();
        g();
      }
    }
    else {
      return;
    }
    a();
    a(paramVideoPlayParam.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      int i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i + 1));
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    g();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
      a(true);
    }
  }
  
  public void d()
  {
    f();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    StringBuilder localStringBuilder = new StringBuilder().append("pauseTiming :").append(this.jdField_a_of_type_Long).append(" isMainThread : ");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoyAdLog.a("VideoAdReportManager", bool);
      return;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    ReadInJoyAdLog.a("VideoAdReportManager", "restoreTiming :" + this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyReportManager
 * JD-Core Version:    0.7.0.1
 */