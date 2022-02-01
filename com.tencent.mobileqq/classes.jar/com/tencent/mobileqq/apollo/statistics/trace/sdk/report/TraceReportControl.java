package com.tencent.mobileqq.apollo.statistics.trace.sdk.report;

import com.tencent.mobileqq.apollo.statistics.trace.data.ResultData;
import com.tencent.mobileqq.apollo.statistics.trace.data.TraceData;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceUtil;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceNetwork;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceReportStrategyListener;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceStorage;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TraceReportControl
  implements ITraceReportStrategyListener
{
  public static int a = 30000;
  private static int d = 3;
  private static int e = 10000;
  private TraceConfig b = null;
  private List<TraceData> c = new ArrayList();
  private boolean f = true;
  private boolean g = true;
  private long h = 0L;
  private int i = 0;
  private int j = 0;
  private long k = System.currentTimeMillis() - 540000L;
  
  private void b(TraceData paramTraceData)
  {
    if (paramTraceData != null)
    {
      if (paramTraceData.result == null) {
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.k;
      if (l1 - l2 < 1000L)
      {
        paramTraceData.result.c = this.i;
        paramTraceData.result.d = this.j;
        return;
      }
      if ((l1 - l2 > 600000L) || ((paramTraceData.isSampleFocus) && (l1 - this.k > 300000L)))
      {
        this.k = l1;
        l1 = System.currentTimeMillis();
        this.i = TraceUtil.b();
        this.j = TraceUtil.a();
        l2 = System.currentTimeMillis();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("samplingCpuAndMemory cpu:");
        localStringBuilder.append(this.j);
        localStringBuilder.append(",memory:");
        localStringBuilder.append(this.i);
        localStringBuilder.append(",isSampleFocus:");
        localStringBuilder.append(paramTraceData.isSampleFocus);
        localStringBuilder.append(",cost:");
        localStringBuilder.append(l2 - l1);
        QLog.i("[cmshow][TraceReport]", 1, localStringBuilder.toString());
        paramTraceData.result.c = this.i;
        paramTraceData.result.d = this.j;
      }
    }
  }
  
  private void c(List<TraceData> paramList)
  {
    ITraceStorage localITraceStorage = this.b.c();
    if (localITraceStorage != null) {
      localITraceStorage.b(paramList);
    }
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((TraceConfig)localObject).c();
    if (localObject != null)
    {
      localObject = ((ITraceStorage)localObject).a();
      if (localObject != null) {
        this.c = ((List)localObject);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][TraceReport]", 2, new Object[] { "onReportStrategyChange reportInterval:", Integer.valueOf(paramInt1), ",reportNum:", Integer.valueOf(paramInt2), ", isFailReport:", Boolean.valueOf(paramBoolean) });
    }
    if (paramInt1 > 0) {
      a = paramInt1 * 1000;
    }
    if (paramInt2 > 0) {
      d = paramInt2;
    }
    this.f = paramBoolean;
  }
  
  public void a(TraceConfig paramTraceConfig)
  {
    this.b = paramTraceConfig;
    paramTraceConfig = this.b.d();
    if (paramTraceConfig != null) {
      paramTraceConfig.a(this);
    }
    this.h = System.currentTimeMillis();
    this.g = true;
  }
  
  public void a(List<TraceData> paramList)
  {
    ITraceNetwork localITraceNetwork = this.b.d();
    if (localITraceNetwork != null)
    {
      localITraceNetwork.a(paramList);
      localITraceNetwork.b(paramList);
    }
  }
  
  public boolean a(TraceData paramTraceData)
  {
    long l1 = System.currentTimeMillis();
    b(paramTraceData);
    this.c.add(paramTraceData);
    boolean bool1 = this.g;
    boolean bool2 = false;
    boolean bool3 = false;
    if (bool1)
    {
      boolean bool4 = NetworkUtil.isNetworkAvailable(null);
      long l2 = l1 - this.h;
      int m = this.c.size();
      if ((paramTraceData.result != null) && (paramTraceData.result.a != 0) && (this.f)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (((m >= d) && (l2 > e)) || (((l2 > a) || (bool2)) && (bool4)))
      {
        a(this.c);
        c(this.c);
        this.c.clear();
        long l3 = System.currentTimeMillis();
        this.h = l3;
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow][TraceReport]", 2, new Object[] { "handleAddTraceReporting interval:", Long.valueOf(l2), ",reportSize:", Integer.valueOf(m), ",report all cost:", Long.valueOf(l3 - l1), ",isFailReport:", Boolean.valueOf(bool2) });
          bool1 = bool3;
        }
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramTraceData);
        b(localArrayList);
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool4)
      {
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow][TraceReport]", 2, "handleAddTraceReporting not network and save");
          return bool1;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][TraceReport]", 2, "handleAddTraceReporting not active and save");
      }
      b(this.c);
    }
    return bool2;
  }
  
  public void b()
  {
    int m = this.c.size();
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    if ((m > 0) && (bool) && (this.g))
    {
      a(this.c);
      c(this.c);
      this.c.clear();
      this.h = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][TraceReport]", 2, new Object[] { "handleAddTraceReporting flushDelayReport reportSize:", Integer.valueOf(m) });
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][TraceReport]", 2, new Object[] { "flushDelayReport reportSize:", Integer.valueOf(m), ", net:", Boolean.valueOf(bool), ",mActive:", Boolean.valueOf(this.g) });
    }
  }
  
  public void b(List<TraceData> paramList)
  {
    ITraceStorage localITraceStorage = this.b.c();
    if (localITraceStorage != null) {
      localITraceStorage.a(paramList);
    }
  }
  
  public void c()
  {
    this.g = false;
    b(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.report.TraceReportControl
 * JD-Core Version:    0.7.0.1
 */