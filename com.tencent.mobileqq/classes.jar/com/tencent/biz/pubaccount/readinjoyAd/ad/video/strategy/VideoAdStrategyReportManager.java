package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdStrategyReportManager;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdStrategyReportData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoAdStrategyReportManager
  implements IVideoAdStrategyReportManager
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if ((!paramBoolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("repeat startPlay, so return isMainThread : ");
      paramBoolean = bool1;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramBoolean = true;
      }
      localStringBuilder.append(paramBoolean);
      ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTiming :");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isMainThread : ");
    paramBoolean = bool2;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      paramBoolean = true;
    }
    localStringBuilder.append(paramBoolean);
    ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
    this.jdField_a_of_type_Long += 1L;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 1000L);
  }
  
  private int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((Integer)((Map.Entry)localIterator.next()).getValue()).intValue();
    }
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
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.a != null))
    {
      if (paramVideoPlayParam.a.r)
      {
        paramVideoPlayParam = paramVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdStrategyReportData;
        StringBuilder localStringBuilder;
        if (paramVideoPlayParam.jdField_a_of_type_Int <= 0)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("lastAdDistance: ");
          localStringBuilder.append(a());
          ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
          paramVideoPlayParam.jdField_a_of_type_Int = a();
        }
        if (paramVideoPlayParam.jdField_a_of_type_Long <= 0L)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("lastAdTime: ");
          localStringBuilder.append(a());
          ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
          paramVideoPlayParam.jdField_a_of_type_Long = a();
        }
        if (paramVideoPlayParam.b <= 0)
        {
          paramVideoPlayParam.b = b();
          paramVideoPlayParam = new StringBuilder();
          paramVideoPlayParam.append("lastAdDistanceVV: ");
          paramVideoPlayParam.append(b());
          ReadInJoyAdLog.a("VideoAdReportManager", paramVideoPlayParam.toString());
        }
        h();
        g();
        return;
      }
      a();
      a(paramVideoPlayParam.a.jdField_a_of_type_JavaLangString);
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseTiming :");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isMainThread : ");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
  }
  
  public void g()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("restoreTiming :");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    ReadInJoyAdLog.a("VideoAdReportManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyReportManager
 * JD-Core Version:    0.7.0.1
 */