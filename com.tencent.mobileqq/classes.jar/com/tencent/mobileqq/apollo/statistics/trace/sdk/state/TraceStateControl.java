package com.tencent.mobileqq.apollo.statistics.trace.sdk.state;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.statistics.trace.data.AnnotationData;
import com.tencent.mobileqq.apollo.api.statistics.trace.data.ResultData;
import com.tencent.mobileqq.apollo.api.statistics.trace.data.SpanData;
import com.tencent.mobileqq.apollo.api.statistics.trace.data.TraceData;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportInstance;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class TraceStateControl
  implements TraceStateMachineScheduler.StateMachine, TraceStateMachineScheduler.TimeOutState
{
  private int jdField_a_of_type_Int = 0;
  private TraceData jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData = new TraceData();
  private TraceConfig jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig;
  private TraceStateMachineScheduler jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler;
  private ConcurrentHashMap<Integer, SpanData> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  public TraceStateControl(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.featureId = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.version = "8.5.5";
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler = new TraceStateMachineScheduler(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig = TraceReportInstance.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.b(paramInt)) {}
    for (paramInt = -1;; paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.a(paramInt, this);
      return;
    }
  }
  
  private long a()
  {
    return (System.currentTimeMillis() & 0xFFFFFFFF) << 10 | (int)(Math.random() * 1000.0D) & 0x3FF;
  }
  
  private int b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.traceId = a();
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.timestamp = paramBundle.getLong("timestamp");
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.startTime = paramBundle.getLong("startTime");
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.serverTime = paramBundle.getLong("serverTime");
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.featureKey = paramBundle.getString("featureKey");
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.isSampleFocus = paramBundle.getBoolean("isSampleFocus");
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.initJavaHeap = paramBundle.getInt("initJavaHeap");
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.initNativeHeap = paramBundle.getInt("initNativeHeap");
    return -1;
  }
  
  private int c(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    int j = paramBundle.getInt("errCode", -100);
    Object localObject = paramBundle.getString("msg");
    long l1 = paramBundle.getLong("timestamp");
    long l2 = paramBundle.getLong("serverTime");
    long l3 = paramBundle.getLong("startTime");
    int k = paramBundle.getInt("extKey");
    long l4 = paramBundle.getLong("extValue");
    paramBundle = (SpanData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    if (paramBundle == null)
    {
      paramBundle = new SpanData(i);
      paramBundle.c = l3;
      paramBundle.jdField_a_of_type_Long = l1;
      paramBundle.b = l2;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), paramBundle);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (paramBundle.jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null) {
          paramBundle.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
        }
        localObject = a((String)localObject, l1, l2);
        paramBundle.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localObject);
      }
      if (k > 0)
      {
        if (paramBundle.jdField_a_of_type_JavaUtilMap == null) {
          paramBundle.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        paramBundle.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(k), Long.valueOf(l4));
      }
      if (j != -100)
      {
        this.jdField_a_of_type_Int = 2;
        return 0;
      }
      return -1;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.b();
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler = null;
  }
  
  private int d(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    int j = paramBundle.getInt("errCode");
    long l = paramBundle.getLong("endTime");
    paramBundle = paramBundle.getString("featureKey");
    TraceReportInstance.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.featureId, paramBundle);
    paramBundle = (SpanData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    if (paramBundle == null) {
      throw new IllegalArgumentException("illegal span");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.mSpanQueue == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.mSpanQueue = new LinkedBlockingQueue();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.mSpanQueue.contains(paramBundle)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.mSpanQueue.remove(paramBundle);
    }
    paramBundle.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataResultData = a(j, paramBundle.c, l);
    paramBundle.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.mSpanQueue.offer(paramBundle);
    if (j != 0)
    {
      this.jdField_a_of_type_Int = 3;
      return 0;
    }
    return -1;
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      SpanData localSpanData = (SpanData)localIterator.next();
      if (!localSpanData.jdField_a_of_type_Boolean)
      {
        if (localSpanData.jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null) {
          localSpanData.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
        }
        AnnotationData localAnnotationData = a("timeout fail", 0L, 0L);
        localSpanData.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localAnnotationData);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.mSpanQueue == null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.mSpanQueue = new LinkedBlockingQueue();
        }
        localSpanData.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataResultData = a(-101, localSpanData.c, localSpanData.c);
        localSpanData.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.mSpanQueue.offer(localSpanData);
      }
    }
  }
  
  private int e(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = true;
    int j = paramBundle.getInt("featureId");
    String str2 = paramBundle.getString("featureKey");
    int i = j;
    if (j == 0) {
      i = this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.featureId;
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.featureKey;
    }
    j = TraceReportInstance.a().a(i, str1);
    if (((i < 0) || (!TextUtils.isEmpty(str1))) && (QLog.isColorLevel())) {
      QLog.d("TraceReport" + this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(j), 1, new Object[] { "featureId:", Integer.valueOf(j), ",traceId:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.traceId), ",mappingFeatureId:", Integer.valueOf(i), ",featureKey:", str1 });
    }
    i = paramBundle.getInt("errCode", 0);
    long l = paramBundle.getLong("endTime");
    if (i == -101) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.featureId = j;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.result = a(i, this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.startTime, l);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.isSampleFocus)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.endJavaHeap = paramBundle.getInt("endJavaHeap");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.endNativeHeap = paramBundle.getInt("endNativeHeap");
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.endJavaHeap == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.endNativeHeap == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.endJavaHeap = TraceUtil.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.endNativeHeap = TraceUtil.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.result.f = (this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.endJavaHeap - this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.initJavaHeap);
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.result.g = (this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.endNativeHeap - this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.initNativeHeap);
    }
    if (i != 0) {
      QLog.e("TraceReport" + this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(j), 1, new Object[] { "traceEnd:", this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.toString() });
    }
    for (;;)
    {
      TraceReportInstance.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData);
      this.jdField_a_of_type_Int = 4;
      return 0;
      QLog.i("TraceReport" + this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(j), 1, "traceEnd:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.toString());
    }
  }
  
  public int a(Bundle paramBundle)
  {
    int i = this.jdField_a_of_type_Int;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      c();
      return -1;
    case 0: 
      return b(paramBundle);
    case 3: 
      return e(paramBundle);
    case 1: 
      return c(paramBundle);
    }
    return d(paramBundle);
  }
  
  public AnnotationData a(String paramString, long paramLong1, long paramLong2)
  {
    return new AnnotationData(paramString, paramLong1, paramLong2);
  }
  
  public ResultData a(int paramInt, long paramLong1, long paramLong2)
  {
    long l = 0L;
    ResultData localResultData = new ResultData();
    localResultData.jdField_a_of_type_Int = paramInt;
    localResultData.e = NetworkUtil.a(null);
    if (paramLong2 > 0L)
    {
      paramLong1 = paramLong2 - paramLong1;
      if (paramLong1 >= 0L) {
        break label83;
      }
      paramLong1 = l;
    }
    label83:
    for (;;)
    {
      if (paramLong1 > 2147483647L) {}
      for (paramInt = 2147483647;; paramInt = (int)paramLong1)
      {
        localResultData.b = paramInt;
        return localResultData;
        paramLong2 = SystemClock.uptimeMillis();
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Int == 4) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.a(new Bundle());
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.a(paramBundle);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 3;
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) {
      localBundle.putInt("errCode", -101);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.a(localBundle);
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.a(paramBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.a(paramBundle);
  }
  
  public void d(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData == null) {}
    do
    {
      return;
      String str = paramBundle.getString("tuid");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.extra1 = paramBundle.getInt("extra1");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.extra2 = paramBundle.getInt("extra2");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.extra3 = paramBundle.getInt("extra3");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.tUid = str;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport" + this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiStatisticsTraceDataTraceData.featureId), 2, new Object[] { "updateTraceData:", paramBundle.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.state.TraceStateControl
 * JD-Core Version:    0.7.0.1
 */