package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.statistics.trace.data.FeatureKeyData;
import com.tencent.mobileqq.apollo.api.statistics.trace.data.TraceData;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceMapping;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.report.TraceReportControl;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.state.TraceStateControl;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class TraceReportInstance
  implements Handler.Callback, ITraceReport
{
  private long jdField_a_of_type_Long = 0L;
  private TraceConfig jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig;
  private TraceReportControl jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<Integer, TraceStateControl> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, FeatureKeyData> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static TraceReportInstance a()
  {
    return TraceReportInstance.SingletonHolder.a();
  }
  
  public static boolean a()
  {
    return ApolloConfigUtils.a;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    TraceStateControl localTraceStateControl = (TraceStateControl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localTraceStateControl != null)
    {
      localTraceStateControl.a();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localTraceStateControl);
    }
    localTraceStateControl = new TraceStateControl(paramInt);
    paramBundle.putBoolean("isSampleFocus", a(paramInt));
    localTraceStateControl.a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localTraceStateControl);
  }
  
  private void c(int paramInt, Bundle paramBundle)
  {
    TraceStateControl localTraceStateControl = (TraceStateControl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localTraceStateControl == null)
    {
      QLog.e("TraceReport" + this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(paramInt), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localTraceStateControl.c(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localTraceStateControl);
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    TraceStateControl localTraceStateControl = (TraceStateControl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localTraceStateControl == null) {
      return;
    }
    localTraceStateControl.b(paramBundle);
  }
  
  private void e(int paramInt, Bundle paramBundle)
  {
    TraceStateControl localTraceStateControl = (TraceStateControl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localTraceStateControl == null) {
      return;
    }
    localTraceStateControl.d(paramBundle);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    try
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        paramInt = ((FeatureKeyData)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).a;
        return paramInt;
      }
    }
    finally {}
    return paramInt;
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      try
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          paramInt = ((FeatureKeyData)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).b;
          return paramInt;
        }
      }
      finally {}
    } while (!paramBoolean);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= -2147483648) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    FeatureKeyData localFeatureKeyData = new FeatureKeyData(paramInt, i);
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localFeatureKeyData);
      return i;
    }
    finally {}
  }
  
  public TraceConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a().a();
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(6);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {
      return;
    }
    paramBundle.putInt("featureId", a(paramInt, paramBundle.getString("featureKey"), false));
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {
      a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {}
    int i;
    do
    {
      return;
      i = a(paramInt, paramString, true);
    } while (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i)));
    this.jdField_b_of_type_JavaUtilSet.remove(Integer.valueOf(i));
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("initJavaHeap", TraceUtil.c());
      paramBundle.putInt("initNativeHeap", TraceUtil.d());
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(1, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
  }
  
  public void a(TraceData paramTraceData)
  {
    if ((!a()) || (paramTraceData.featureId < 0)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl.a(paramTraceData))
        {
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(6);
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(6, TraceReportControl.a);
          return;
        }
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(6);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport", 2, "sendTraceReport mTraceReportControl or config is null");
  }
  
  public void a(TraceConfig paramTraceConfig)
  {
    TraceConfig localTraceConfig = paramTraceConfig;
    if (paramTraceConfig == null)
    {
      localTraceConfig = TraceUtil.a();
      QLog.e("TraceReport", 1, "init error, outside not init config");
    }
    if (localTraceConfig == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig = localTraceConfig;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl = new TraceReportControl();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl.a(localTraceConfig);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(0);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig.a(paramInt);
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {
      a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {}
    int i;
    do
    {
      return;
      i = a(paramInt, paramString, false);
    } while (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i)));
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("endJavaHeap", TraceUtil.c());
      paramBundle.putInt("endNativeHeap", TraceUtil.d());
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {
      a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkTraceConfig == null) {}
    do
    {
      return;
      paramInt = a(paramInt, paramString, false);
    } while ((this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) || (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))));
    paramBundle.putInt("featureId", paramInt);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(3, paramBundle).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (Bundle)paramMessage.obj;
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl.a();
        continue;
        b(paramMessage.getInt("featureId"), paramMessage);
        continue;
        c(paramMessage.getInt("featureId"), paramMessage);
        continue;
        d(paramMessage.getInt("featureId"), paramMessage);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl.c();
          continue;
          e(paramMessage.getInt("featureId"), paramMessage);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkReportTraceReportControl.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportInstance
 * JD-Core Version:    0.7.0.1
 */