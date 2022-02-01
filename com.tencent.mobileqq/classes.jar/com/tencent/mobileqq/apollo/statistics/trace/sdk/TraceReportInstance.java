package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.statistics.trace.data.FeatureKeyData;
import com.tencent.mobileqq.apollo.statistics.trace.data.TraceData;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceMapping;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.report.TraceReportControl;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.state.TraceStateControl;
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
  private ConcurrentHashMap<Integer, TraceStateControl> a = new ConcurrentHashMap();
  private Set<Integer> b = new CopyOnWriteArraySet();
  private Set<Integer> c = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, FeatureKeyData> d = new ConcurrentHashMap();
  private TraceConfig e;
  private TraceReportControl f;
  private MqqWeakReferenceHandler g = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  private AtomicInteger h = new AtomicInteger(-1);
  private long i = 0L;
  
  public static TraceReportInstance a()
  {
    return TraceReportInstance.SingletonHolder.a();
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    TraceStateControl localTraceStateControl = (TraceStateControl)this.a.get(Integer.valueOf(paramInt));
    if (localTraceStateControl != null)
    {
      localTraceStateControl.a();
      this.a.remove(Integer.valueOf(paramInt), localTraceStateControl);
    }
    localTraceStateControl = new TraceStateControl(paramInt);
    paramBundle.putBoolean("isSampleFocus", a(paramInt));
    localTraceStateControl.a(paramBundle);
    this.a.put(Integer.valueOf(paramInt), localTraceStateControl);
  }
  
  private void c(int paramInt, Bundle paramBundle)
  {
    TraceStateControl localTraceStateControl = (TraceStateControl)this.a.get(Integer.valueOf(paramInt));
    if (localTraceStateControl == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[cmshow][TraceReport]");
      paramBundle.append(this.e.a(paramInt));
      QLog.e(paramBundle.toString(), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localTraceStateControl.c(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().a(paramBundle);
    this.a.remove(Integer.valueOf(paramInt), localTraceStateControl);
    this.c.add(Integer.valueOf(paramInt));
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    TraceStateControl localTraceStateControl = (TraceStateControl)this.a.get(Integer.valueOf(paramInt));
    if (localTraceStateControl == null) {
      return;
    }
    localTraceStateControl.b(paramBundle);
  }
  
  public static boolean d()
  {
    return ApolloConfigUtils.g;
  }
  
  private void e(int paramInt, Bundle paramBundle)
  {
    TraceStateControl localTraceStateControl = (TraceStateControl)this.a.get(Integer.valueOf(paramInt));
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
      if (this.d.containsKey(paramString))
      {
        paramInt = ((FeatureKeyData)this.d.get(paramString)).a;
        return paramInt;
      }
      return paramInt;
    }
    finally {}
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    try
    {
      if (this.d.containsKey(paramString))
      {
        paramInt = ((FeatureKeyData)this.d.get(paramString)).b;
        return paramInt;
      }
      if (paramBoolean)
      {
        if (this.h.get() <= -2147483648) {
          this.h.set(-1);
        }
        int j = this.h.decrementAndGet();
        FeatureKeyData localFeatureKeyData = new FeatureKeyData(paramInt, j);
        try
        {
          this.d.put(paramString, localFeatureKeyData);
          return j;
        }
        finally {}
      }
      return paramInt;
    }
    finally {}
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.e == null) {
      return;
    }
    paramBundle.putInt("featureId", a(paramInt, paramBundle.getString("featureKey"), false));
    this.g.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.e == null) {
      a(null);
    }
    if (this.e == null) {
      return;
    }
    int j = a(paramInt, paramString, true);
    if (this.b.contains(Integer.valueOf(j))) {
      return;
    }
    this.c.remove(Integer.valueOf(j));
    paramBundle.putInt("featureId", j);
    if (a(paramInt))
    {
      paramBundle.putInt("initJavaHeap", TraceUtil.c());
      paramBundle.putInt("initNativeHeap", TraceUtil.d());
    }
    this.g.obtainMessage(1, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    if (!paramBoolean)
    {
      this.b.add(Integer.valueOf(paramInt));
      return;
    }
    this.b.remove(Integer.valueOf(paramInt));
  }
  
  public void a(TraceData paramTraceData)
  {
    if (d())
    {
      if (paramTraceData.featureId < 0) {
        return;
      }
      TraceReportControl localTraceReportControl = this.f;
      if ((localTraceReportControl != null) && (this.e != null))
      {
        if (localTraceReportControl.a(paramTraceData))
        {
          this.g.removeMessages(6);
          this.g.sendEmptyMessageDelayed(6, TraceReportControl.a);
          return;
        }
        this.g.removeMessages(6);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][TraceReport]", 2, "sendTraceReport mTraceReportControl or config is null");
      }
    }
  }
  
  public void a(TraceConfig paramTraceConfig)
  {
    TraceConfig localTraceConfig = paramTraceConfig;
    if (paramTraceConfig == null)
    {
      localTraceConfig = TraceUtil.e();
      QLog.e("[cmshow][TraceReport]", 1, "init error, outside not init config");
    }
    if (localTraceConfig == null) {
      return;
    }
    this.e = localTraceConfig;
    if (this.f == null) {
      this.f = new TraceReportControl();
    }
    this.f.a(localTraceConfig);
    this.g.sendEmptyMessage(0);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.d.remove(paramString);
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt)
  {
    TraceConfig localTraceConfig = this.e;
    if (localTraceConfig == null) {
      return false;
    }
    return localTraceConfig.b(paramInt);
  }
  
  public TraceConfig b()
  {
    return this.e;
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.e == null) {
      a(null);
    }
    if (this.e == null) {
      return;
    }
    int j = a(paramInt, paramString, false);
    if (this.b.contains(Integer.valueOf(j))) {
      return;
    }
    paramBundle.putInt("featureId", j);
    if (a(paramInt))
    {
      paramBundle.putInt("endJavaHeap", TraceUtil.c());
      paramBundle.putInt("endNativeHeap", TraceUtil.d());
    }
    this.g.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void c()
  {
    this.g.sendEmptyMessage(4);
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    TraceConfig localTraceConfig = this.e;
    if (localTraceConfig != null) {
      localTraceConfig.e().a();
    }
    this.g.removeMessages(6);
  }
  
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.e == null) {
      a(null);
    }
    if (this.e == null) {
      return;
    }
    paramInt = a(paramInt, paramString, false);
    if (this.b.contains(Integer.valueOf(paramInt))) {
      return;
    }
    if (this.c.contains(Integer.valueOf(paramInt))) {
      return;
    }
    paramBundle.putInt("featureId", paramInt);
    this.g.obtainMessage(3, paramBundle).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    paramMessage = (Bundle)paramMessage.obj;
    switch (j)
    {
    default: 
      break;
    case 6: 
      paramMessage = this.f;
      if (paramMessage != null) {
        paramMessage.b();
      }
      break;
    case 5: 
      e(paramMessage.getInt("featureId"), paramMessage);
      break;
    case 4: 
      paramMessage = this.f;
      if (paramMessage != null) {
        paramMessage.c();
      }
      break;
    case 3: 
      d(paramMessage.getInt("featureId"), paramMessage);
      break;
    case 2: 
      c(paramMessage.getInt("featureId"), paramMessage);
      break;
    case 1: 
      b(paramMessage.getInt("featureId"), paramMessage);
      break;
    case 0: 
      paramMessage = this.f;
      if (paramMessage != null) {
        paramMessage.a();
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportInstance
 * JD-Core Version:    0.7.0.1
 */