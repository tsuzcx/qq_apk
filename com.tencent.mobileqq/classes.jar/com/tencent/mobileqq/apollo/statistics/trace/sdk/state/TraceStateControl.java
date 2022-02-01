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
  private int a = 0;
  private TraceStateMachineScheduler b;
  private TraceData c = new TraceData();
  private TraceConfig d;
  private ConcurrentHashMap<Integer, SpanData> e = new ConcurrentHashMap();
  private boolean f = false;
  
  public TraceStateControl(int paramInt)
  {
    TraceData localTraceData = this.c;
    localTraceData.featureId = paramInt;
    localTraceData.version = "8.8.17";
    this.b = new TraceStateMachineScheduler(this);
    this.d = TraceReportInstance.a().b();
    if (this.d.c(paramInt)) {
      paramInt = -1;
    } else {
      paramInt = this.d.b();
    }
    this.b.a(paramInt, this);
  }
  
  private long c()
  {
    return (System.currentTimeMillis() & 0xFFFFFFFF) << 10 | (int)(Math.random() * 1000.0D) & 0x3FF;
  }
  
  private void d()
  {
    this.b.b();
    this.b.a();
    this.b = null;
  }
  
  private void e()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      SpanData localSpanData = (SpanData)localIterator.next();
      if (!localSpanData.f)
      {
        if (localSpanData.g == null) {
          localSpanData.g = new LinkedBlockingQueue();
        }
        AnnotationData localAnnotationData = a("timeout fail", 0L, 0L);
        localSpanData.g.offer(localAnnotationData);
        if (this.c.mSpanQueue == null) {
          this.c.mSpanQueue = new LinkedBlockingQueue();
        }
        localSpanData.e = a(-101, localSpanData.d, localSpanData.d);
        localSpanData.f = true;
        this.c.mSpanQueue.offer(localSpanData);
      }
    }
  }
  
  private int f(Bundle paramBundle)
  {
    this.c.traceId = c();
    this.c.timestamp = paramBundle.getLong("timestamp");
    this.c.startTime = paramBundle.getLong("startTime");
    this.c.serverTime = paramBundle.getLong("serverTime");
    this.c.featureKey = paramBundle.getString("featureKey");
    this.c.isSampleFocus = paramBundle.getBoolean("isSampleFocus");
    this.c.initJavaHeap = paramBundle.getInt("initJavaHeap");
    this.c.initNativeHeap = paramBundle.getInt("initNativeHeap");
    return -1;
  }
  
  private int g(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    String str = paramBundle.getString("msg");
    long l1 = paramBundle.getLong("timestamp");
    long l2 = paramBundle.getLong("serverTime");
    long l3 = paramBundle.getLong("startTime");
    int j = paramBundle.getInt("extKey");
    long l4 = paramBundle.getLong("extValue");
    Object localObject2 = (SpanData)this.e.get(Integer.valueOf(i));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new SpanData(i);
      ((SpanData)localObject1).d = l3;
      ((SpanData)localObject1).b = l1;
      ((SpanData)localObject1).c = l2;
      this.e.put(Integer.valueOf(i), localObject1);
    }
    if (!TextUtils.isEmpty(str))
    {
      if (((SpanData)localObject1).g == null) {
        ((SpanData)localObject1).g = new LinkedBlockingQueue();
      }
      localObject2 = a(str, l1, l2);
      ((SpanData)localObject1).g.offer(localObject2);
    }
    if (j > 0)
    {
      if (((SpanData)localObject1).h == null) {
        ((SpanData)localObject1).h = new HashMap();
      }
      ((SpanData)localObject1).h.put(Integer.valueOf(j), Long.valueOf(l4));
    }
    if (paramBundle.getInt("errCode", -100) != -100)
    {
      this.a = 2;
      return 0;
    }
    return -1;
  }
  
  private int h(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    paramBundle.getString("featureKey");
    SpanData localSpanData = (SpanData)this.e.get(Integer.valueOf(i));
    if (localSpanData != null)
    {
      if (this.c.mSpanQueue == null) {
        this.c.mSpanQueue = new LinkedBlockingQueue();
      }
      if (this.c.mSpanQueue.contains(localSpanData)) {
        this.c.mSpanQueue.remove(localSpanData);
      }
      i = paramBundle.getInt("errCode");
      long l = paramBundle.getLong("endTime");
      localSpanData.e = a(i, localSpanData.d, l);
      localSpanData.f = true;
      this.c.mSpanQueue.offer(localSpanData);
      if (i != 0)
      {
        this.a = 3;
        return 0;
      }
      return -1;
    }
    throw new IllegalArgumentException("illegal span");
  }
  
  private int i(Bundle paramBundle)
  {
    this.f = true;
    int j = paramBundle.getInt("featureId");
    Object localObject2 = paramBundle.getString("featureKey");
    int i = j;
    if (j == 0) {
      i = this.c.featureId;
    }
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.c.featureKey;
    }
    j = TraceReportInstance.a().a(i, (String)localObject1);
    if (((i < 0) || (!TextUtils.isEmpty((CharSequence)localObject1))) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[cmshow][TraceReport]");
      ((StringBuilder)localObject2).append(this.d.a(j));
      QLog.d(((StringBuilder)localObject2).toString(), 1, new Object[] { "featureId:", Integer.valueOf(j), ",traceId:", Long.valueOf(this.c.traceId), ",mappingFeatureId:", Integer.valueOf(i), ",featureKey:", localObject1 });
    }
    i = paramBundle.getInt("errCode", 0);
    long l = paramBundle.getLong("endTime");
    if (i == -101) {
      e();
    }
    localObject1 = this.c;
    ((TraceData)localObject1).featureId = j;
    ((TraceData)localObject1).result = a(i, ((TraceData)localObject1).startTime, l);
    if (this.c.isSampleFocus)
    {
      this.c.endJavaHeap = paramBundle.getInt("endJavaHeap");
      this.c.endNativeHeap = paramBundle.getInt("endNativeHeap");
      if ((this.c.endJavaHeap == 0) && (this.c.endNativeHeap == 0))
      {
        this.c.endJavaHeap = TraceUtil.c();
        this.c.endNativeHeap = TraceUtil.d();
      }
      this.c.result.f = (this.c.endJavaHeap - this.c.initJavaHeap);
      this.c.result.g = (this.c.endNativeHeap - this.c.initNativeHeap);
    }
    if (i != 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[cmshow][TraceReport]");
      paramBundle.append(this.d.a(j));
      QLog.e(paramBundle.toString(), 1, new Object[] { "traceEnd:", this.c.toString() });
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[cmshow][TraceReport]");
      paramBundle.append(this.d.a(j));
      paramBundle = paramBundle.toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("traceEnd:");
      ((StringBuilder)localObject1).append(this.c.toString());
      QLog.i(paramBundle, 1, ((StringBuilder)localObject1).toString());
    }
    TraceReportInstance.a().a(this.c);
    this.a = 4;
    return 0;
  }
  
  public AnnotationData a(String paramString, long paramLong1, long paramLong2)
  {
    return new AnnotationData(paramString, paramLong1, paramLong2);
  }
  
  public ResultData a(int paramInt, long paramLong1, long paramLong2)
  {
    ResultData localResultData = new ResultData();
    localResultData.a = paramInt;
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
    if (this.f) {
      return;
    }
    if (this.a == 4) {
      return;
    }
    this.f = true;
    this.a = 4;
    this.b.a(new Bundle());
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.f) {
      return;
    }
    this.a = 0;
    this.b.a(paramBundle);
  }
  
  public void b()
  {
    this.a = 3;
    Bundle localBundle = new Bundle();
    if (this.e.size() > 0) {
      localBundle.putInt("errCode", -101);
    }
    this.b.a(localBundle);
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.f) {
      return;
    }
    this.a = 1;
    this.b.a(paramBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    if (this.f) {
      return;
    }
    this.a = 3;
    this.b.a(paramBundle);
  }
  
  public void d(Bundle paramBundle)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    ((TraceData)localObject).extra1 = paramBundle.getInt("extra1");
    this.c.extra2 = paramBundle.getInt("extra2");
    this.c.extra3 = paramBundle.getInt("extra3");
    localObject = paramBundle.getString("tuid");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.c.tUid = ((String)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[cmshow][TraceReport]");
      ((StringBuilder)localObject).append(this.d.a(this.c.featureId));
      QLog.d(((StringBuilder)localObject).toString(), 2, new Object[] { "updateTraceData:", paramBundle.toString() });
    }
  }
  
  public int e(Bundle paramBundle)
  {
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            d();
            return -1;
          }
          return i(paramBundle);
        }
        return h(paramBundle);
      }
      return g(paramBundle);
    }
    return f(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.state.TraceStateControl
 * JD-Core Version:    0.7.0.1
 */