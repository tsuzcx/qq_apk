package com.tencent.mobileqq.apollo.statistics.trace.sdk.state;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.statistics.trace.data.AnnotationData;
import com.tencent.mobileqq.apollo.statistics.trace.data.ResultData;
import com.tencent.mobileqq.apollo.statistics.trace.data.SpanData;
import com.tencent.mobileqq.apollo.statistics.trace.data.TraceData;
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
  private TraceData jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData = new TraceData();
  private TraceConfig jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig;
  private TraceStateMachineScheduler jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler;
  private ConcurrentHashMap<Integer, SpanData> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  public TraceStateControl(int paramInt)
  {
    TraceData localTraceData = this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData;
    localTraceData.featureId = paramInt;
    localTraceData.version = "8.7.0";
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler = new TraceStateMachineScheduler(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig = TraceReportInstance.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.b(paramInt)) {
      paramInt = -1;
    } else {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler.a(paramInt, this);
  }
  
  private long a()
  {
    return (System.currentTimeMillis() & 0xFFFFFFFF) << 10 | (int)(Math.random() * 1000.0D) & 0x3FF;
  }
  
  private int b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.traceId = a();
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.timestamp = paramBundle.getLong("timestamp");
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.startTime = paramBundle.getLong("startTime");
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.serverTime = paramBundle.getLong("serverTime");
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.featureKey = paramBundle.getString("featureKey");
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.isSampleFocus = paramBundle.getBoolean("isSampleFocus");
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.initJavaHeap = paramBundle.getInt("initJavaHeap");
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.initNativeHeap = paramBundle.getInt("initNativeHeap");
    return -1;
  }
  
  private int c(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    String str = paramBundle.getString("msg");
    long l1 = paramBundle.getLong("timestamp");
    long l2 = paramBundle.getLong("serverTime");
    long l3 = paramBundle.getLong("startTime");
    int j = paramBundle.getInt("extKey");
    long l4 = paramBundle.getLong("extValue");
    Object localObject2 = (SpanData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new SpanData(i);
      ((SpanData)localObject1).c = l3;
      ((SpanData)localObject1).jdField_a_of_type_Long = l1;
      ((SpanData)localObject1).b = l2;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localObject1);
    }
    if (!TextUtils.isEmpty(str))
    {
      if (((SpanData)localObject1).jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null) {
        ((SpanData)localObject1).jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
      }
      localObject2 = a(str, l1, l2);
      ((SpanData)localObject1).jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localObject2);
    }
    if (j > 0)
    {
      if (((SpanData)localObject1).jdField_a_of_type_JavaUtilMap == null) {
        ((SpanData)localObject1).jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      ((SpanData)localObject1).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), Long.valueOf(l4));
    }
    if (paramBundle.getInt("errCode", -100) != -100)
    {
      this.jdField_a_of_type_Int = 2;
      return 0;
    }
    return -1;
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
    paramBundle.getString("featureKey");
    SpanData localSpanData = (SpanData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    if (localSpanData != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.mSpanQueue == null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.mSpanQueue = new LinkedBlockingQueue();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.mSpanQueue.contains(localSpanData)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.mSpanQueue.remove(localSpanData);
      }
      i = paramBundle.getInt("errCode");
      long l = paramBundle.getLong("endTime");
      localSpanData.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataResultData = a(i, localSpanData.c, l);
      localSpanData.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.mSpanQueue.offer(localSpanData);
      if (i != 0)
      {
        this.jdField_a_of_type_Int = 3;
        return 0;
      }
      return -1;
    }
    throw new IllegalArgumentException("illegal span");
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
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.mSpanQueue == null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.mSpanQueue = new LinkedBlockingQueue();
        }
        localSpanData.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataResultData = a(-101, localSpanData.c, localSpanData.c);
        localSpanData.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.mSpanQueue.offer(localSpanData);
      }
    }
  }
  
  private int e(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = true;
    int j = paramBundle.getInt("featureId");
    Object localObject2 = paramBundle.getString("featureKey");
    int i = j;
    if (j == 0) {
      i = this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.featureId;
    }
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.featureKey;
    }
    j = TraceReportInstance.a().a(i, (String)localObject1);
    if (((i < 0) || (!TextUtils.isEmpty((CharSequence)localObject1))) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[cmshow][TraceReport]");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(j));
      QLog.d(((StringBuilder)localObject2).toString(), 1, new Object[] { "featureId:", Integer.valueOf(j), ",traceId:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.traceId), ",mappingFeatureId:", Integer.valueOf(i), ",featureKey:", localObject1 });
    }
    i = paramBundle.getInt("errCode", 0);
    long l = paramBundle.getLong("endTime");
    if (i == -101) {
      d();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData;
    ((TraceData)localObject1).featureId = j;
    ((TraceData)localObject1).result = a(i, ((TraceData)localObject1).startTime, l);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.isSampleFocus)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.endJavaHeap = paramBundle.getInt("endJavaHeap");
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.endNativeHeap = paramBundle.getInt("endNativeHeap");
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.endJavaHeap == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.endNativeHeap == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.endJavaHeap = TraceUtil.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.endNativeHeap = TraceUtil.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.result.f = (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.endJavaHeap - this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.initJavaHeap);
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.result.g = (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.endNativeHeap - this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.initNativeHeap);
    }
    if (i != 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[cmshow][TraceReport]");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(j));
      QLog.e(paramBundle.toString(), 1, new Object[] { "traceEnd:", this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.toString() });
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[cmshow][TraceReport]");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(j));
      paramBundle = paramBundle.toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("traceEnd:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.toString());
      QLog.i(paramBundle, 1, ((StringBuilder)localObject1).toString());
    }
    TraceReportInstance.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData);
    this.jdField_a_of_type_Int = 4;
    return 0;
  }
  
  public int a(Bundle paramBundle)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            c();
            return -1;
          }
          return e(paramBundle);
        }
        return d(paramBundle);
      }
      return c(paramBundle);
    }
    return b(paramBundle);
  }
  
  public AnnotationData a(String paramString, long paramLong1, long paramLong2)
  {
    return new AnnotationData(paramString, paramLong1, paramLong2);
  }
  
  public ResultData a(int paramInt, long paramLong1, long paramLong2)
  {
    ResultData localResultData = new ResultData();
    localResultData.jdField_a_of_type_Int = paramInt;
    localResultData.e = NetworkUtil.getSystemNetwork(null);
    if (paramLong2 <= 0L) {
      paramLong2 = SystemClock.uptimeMillis();
    }
    paramLong2 -= paramLong1;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = 0L;
    }
    if (paramLong1 > 2147483647L) {
      paramInt = 2147483647;
    } else {
      paramInt = (int)paramLong1;
    }
    localResultData.b = paramInt;
    return localResultData;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Int == 4) {
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData;
    if (localObject == null) {
      return;
    }
    ((TraceData)localObject).extra1 = paramBundle.getInt("extra1");
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.extra2 = paramBundle.getInt("extra2");
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.extra3 = paramBundle.getInt("extra3");
    localObject = paramBundle.getString("tuid");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.tUid = ((String)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[cmshow][TraceReport]");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataTraceData.featureId));
      QLog.d(((StringBuilder)localObject).toString(), 2, new Object[] { "updateTraceData:", paramBundle.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.state.TraceStateControl
 * JD-Core Version:    0.7.0.1
 */