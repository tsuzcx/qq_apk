package com.tencent.mobileqq.apollo.statistics.trace.sdk.component;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.statistics.trace.data.AnnotationData;
import com.tencent.mobileqq.apollo.statistics.trace.data.ResultData;
import com.tencent.mobileqq.apollo.statistics.trace.data.SpanData;
import com.tencent.mobileqq.apollo.statistics.trace.data.TraceData;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportInstance;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.ReportTrace.ExtParam;
import com.tencent.pb.ReportTrace.ReportAnnoReq;
import com.tencent.pb.ReportTrace.ReportHead;
import com.tencent.pb.ReportTrace.ReportTraceReq;
import com.tencent.pb.ReportTrace.ReportTraceRsp;
import com.tencent.pb.ReportTrace.SpanAnnoEntry;
import com.tencent.pb.ReportTrace.SpanEntry;
import com.tencent.pb.ReportTrace.TraceAnnoEntry;
import com.tencent.pb.ReportTrace.TraceEntry;
import com.tencent.pb.ReportTrace.reportStat;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class DefaultTraceNetwork
  implements ITraceNetwork, BusinessObserver
{
  private WeakReference<ITraceReportStrategyListener> a;
  
  private ReportTrace.ReportHead a(TraceConfig paramTraceConfig, String paramString)
  {
    ReportTrace.ReportHead localReportHead = new ReportTrace.ReportHead();
    localReportHead.appid.set(paramTraceConfig.a());
    localReportHead.platform.set(109);
    paramTraceConfig = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramTraceConfig = "8.8.17";
    }
    localReportHead.ver.set(paramTraceConfig);
    paramTraceConfig = DeviceInfoUtil.g();
    if (!TextUtils.isEmpty(paramTraceConfig)) {
      localReportHead.os_ver.set(paramTraceConfig);
    }
    paramTraceConfig = DeviceInfoUtil.u();
    if (!TextUtils.isEmpty(paramTraceConfig)) {
      localReportHead.model.set(paramTraceConfig);
    }
    paramTraceConfig = DeviceInfoUtil.b();
    if (!TextUtils.isEmpty(paramTraceConfig)) {
      localReportHead.udid.set(paramTraceConfig);
    }
    return localReportHead;
  }
  
  private ReportTrace.SpanEntry a(SpanData paramSpanData)
  {
    ReportTrace.SpanEntry localSpanEntry = new ReportTrace.SpanEntry();
    localSpanEntry.span_id.set(paramSpanData.a);
    localSpanEntry.time_stamp.set(paramSpanData.b);
    if (paramSpanData.e != null) {
      localSpanEntry.result.set(a(paramSpanData.e));
    }
    if ((paramSpanData.h != null) && (paramSpanData.h.size() > 0))
    {
      paramSpanData = paramSpanData.h.entrySet().iterator();
      while (paramSpanData.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramSpanData.next();
        ReportTrace.ExtParam localExtParam = new ReportTrace.ExtParam();
        localExtParam.param_id.set(((Integer)localEntry.getKey()).intValue());
        localExtParam.value.set(((Long)localEntry.getValue()).longValue());
        localSpanEntry.param_list.add(localExtParam);
      }
    }
    return localSpanEntry;
  }
  
  private ReportTrace.TraceEntry a(TraceData paramTraceData, TraceConfig paramTraceConfig)
  {
    ReportTrace.TraceEntry localTraceEntry = new ReportTrace.TraceEntry();
    localTraceEntry.feature_id.set(paramTraceData.featureId);
    localTraceEntry.trace_id.set(paramTraceData.traceId);
    localTraceEntry.from_uid.set(paramTraceConfig.f());
    if (!TextUtils.isEmpty(paramTraceData.tUid)) {
      localTraceEntry.to_uid.set(paramTraceData.tUid);
    }
    localTraceEntry.time_stamp.set(paramTraceData.timestamp);
    localTraceEntry.server_timestamp.set(paramTraceData.serverTime);
    if (paramTraceData.result != null) {
      localTraceEntry.result.set(a(paramTraceData.result));
    }
    if (paramTraceData.mSpanQueue != null)
    {
      paramTraceConfig = paramTraceData.mSpanQueue.iterator();
      while (paramTraceConfig.hasNext())
      {
        SpanData localSpanData = (SpanData)paramTraceConfig.next();
        localTraceEntry.span_list.add(a(localSpanData));
      }
    }
    localTraceEntry.extra1.set(paramTraceData.extra1);
    localTraceEntry.extra2.set(paramTraceData.extra2);
    localTraceEntry.extra3.set(paramTraceData.extra3);
    return localTraceEntry;
  }
  
  private ReportTrace.reportStat a(ResultData paramResultData)
  {
    ReportTrace.reportStat localreportStat = new ReportTrace.reportStat();
    localreportStat.ret.set(paramResultData.a);
    localreportStat.cost.set(paramResultData.b);
    localreportStat.net_type.set(paramResultData.e);
    localreportStat.cpu.set(paramResultData.d);
    localreportStat.memory.set(paramResultData.c);
    localreportStat.java_heap.set(paramResultData.f);
    localreportStat.native_heap.set(paramResultData.g);
    return localreportStat;
  }
  
  private List<ReportTrace.SpanAnnoEntry> a(BlockingQueue<SpanData> paramBlockingQueue)
  {
    if ((paramBlockingQueue != null) && (paramBlockingQueue.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramBlockingQueue = paramBlockingQueue.iterator();
      while (paramBlockingQueue.hasNext())
      {
        SpanData localSpanData = (SpanData)paramBlockingQueue.next();
        if ((localSpanData.g != null) && (localSpanData.g.size() > 0))
        {
          Iterator localIterator = localSpanData.g.iterator();
          while (localIterator.hasNext())
          {
            AnnotationData localAnnotationData = (AnnotationData)localIterator.next();
            ReportTrace.SpanAnnoEntry localSpanAnnoEntry = new ReportTrace.SpanAnnoEntry();
            localSpanAnnoEntry.span_id.set(localSpanData.a);
            if (!TextUtils.isEmpty(localAnnotationData.c)) {
              localSpanAnnoEntry.anno_msg.set(localAnnotationData.c);
            }
            if (localSpanData.e != null) {
              localSpanAnnoEntry.errCode.set(localSpanData.e.a);
            }
            localSpanAnnoEntry.time_stamp.set(localAnnotationData.a);
            localArrayList.add(localSpanAnnoEntry);
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(AppRuntime paramAppRuntime, TraceConfig paramTraceConfig, String paramString, List<ReportTrace.TraceEntry> paramList)
  {
    if ((paramAppRuntime != null) && (paramTraceConfig != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      ReportTrace.ReportTraceReq localReportTraceReq = new ReportTrace.ReportTraceReq();
      localReportTraceReq.head.set(a(paramTraceConfig, paramString));
      localReportTraceReq.trace_list.set(paramList);
      paramTraceConfig = new NewIntent(paramAppRuntime.getApplication(), TraceServlet.class);
      paramTraceConfig.putExtra("cmd", "apollo_monitor.report_trace");
      paramTraceConfig.putExtra("data", localReportTraceReq.toByteArray());
      paramTraceConfig.putExtra("timeout", 30000);
      paramTraceConfig.setObserver(this);
      paramAppRuntime.startServlet(paramTraceConfig);
    }
  }
  
  private void b(AppRuntime paramAppRuntime, TraceConfig paramTraceConfig, String paramString, List<ReportTrace.TraceAnnoEntry> paramList)
  {
    if ((paramAppRuntime != null) && (paramTraceConfig != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      ReportTrace.ReportAnnoReq localReportAnnoReq = new ReportTrace.ReportAnnoReq();
      localReportAnnoReq.head.set(a(paramTraceConfig, paramString));
      localReportAnnoReq.anno_list.set(paramList);
      paramTraceConfig = new NewIntent(paramAppRuntime.getApplication(), TraceServlet.class);
      paramTraceConfig.putExtra("cmd", "apollo_monitor.report_anno");
      paramTraceConfig.putExtra("data", localReportAnnoReq.toByteArray());
      paramTraceConfig.putExtra("timeout", 30000);
      paramTraceConfig.setObserver(this);
      paramAppRuntime.startServlet(paramTraceConfig);
    }
  }
  
  public void a(ITraceReportStrategyListener paramITraceReportStrategyListener)
  {
    this.a = new WeakReference(paramITraceReportStrategyListener);
  }
  
  public void a(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    TraceConfig localTraceConfig = TraceReportInstance.a().b();
    if ((localAppRuntime != null) && (paramList != null) && (localTraceConfig != null) && (!TextUtils.isEmpty(localTraceConfig.f())))
    {
      ArrayList localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceEntry localTraceEntry = a(localTraceData, localTraceConfig);
        if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.8.17")))
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localTraceEntry);
          a(localAppRuntime, localTraceConfig, localTraceData.version, localArrayList2);
        }
        else
        {
          localArrayList1.add(a(localTraceData, localTraceConfig));
        }
      }
      a(localAppRuntime, localTraceConfig, null, localArrayList1);
    }
  }
  
  public void b(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    TraceConfig localTraceConfig = TraceReportInstance.a().b();
    if ((localAppRuntime != null) && (paramList != null) && (localTraceConfig != null) && (!TextUtils.isEmpty(localTraceConfig.f())))
    {
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceAnnoEntry localTraceAnnoEntry = new ReportTrace.TraceAnnoEntry();
        localTraceAnnoEntry.uid.set(localTraceConfig.f());
        localTraceAnnoEntry.trace_id.set(localTraceData.traceId);
        localTraceAnnoEntry.feature_id.set(localTraceData.featureId);
        localTraceAnnoEntry.server_timestamp.set(localTraceData.serverTime);
        if ((localTraceData.result != null) && (localTraceData.result.a != 0))
        {
          localTraceAnnoEntry.ret.set(localTraceData.result.a);
          Object localObject = a(localTraceData.mSpanQueue);
          if (localObject != null) {
            localTraceAnnoEntry.span_anno_list.addAll((Collection)localObject);
          }
          if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.8.17")))
          {
            localObject = new ArrayList();
            ((List)localObject).add(localTraceAnnoEntry);
            b(localAppRuntime, localTraceConfig, localTraceData.version, (List)localObject);
          }
          else
          {
            i = 1;
            localArrayList.add(localTraceAnnoEntry);
          }
        }
      }
      if (i != 0) {
        b(localAppRuntime, localTraceConfig, null, localArrayList);
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("cmd");
    Object localObject1;
    if (("apollo_monitor.report_trace".equals(str)) || ("apollo_monitor.report_anno".equals(str)))
    {
      if (!paramBoolean)
      {
        paramInt = paramBundle.getInt("retryTime");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cmd:");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(",retryTime:");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.w("[cmshow][TraceReport]", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        paramInt = 0;
      }
      if (("apollo_monitor.report_trace".equals(str)) && (paramBoolean) && (this.a != null)) {
        localObject1 = new ReportTrace.ReportTraceRsp();
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = (ITraceReportStrategyListener)this.a.get();
        if (localObject2 != null)
        {
          ((ReportTrace.ReportTraceRsp)localObject1).mergeFrom(paramBundle.getByteArray("data"));
          int i = ((ReportTrace.ReportTraceRsp)localObject1).report_interval.get();
          int j = ((ReportTrace.ReportTraceRsp)localObject1).report_num.get();
          if (((ReportTrace.ReportTraceRsp)localObject1).report_fail.get() != 1) {
            break label336;
          }
          bool = true;
          ((ITraceReportStrategyListener)localObject2).a(i, j, bool);
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow][TraceReport]", 1, localException, new Object[0]);
      }
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((!paramBoolean) && (paramInt < 1) && (localAppRuntime != null))
      {
        localObject2 = new NewIntent(localAppRuntime.getApplication(), TraceServlet.class);
        ((NewIntent)localObject2).putExtra("retryTime", paramInt + 1);
        ((NewIntent)localObject2).putExtra("cmd", str);
        ((NewIntent)localObject2).putExtra("data", paramBundle.getByteArray("request_data"));
        ((NewIntent)localObject2).putExtra("timeout", 30000);
        ((NewIntent)localObject2).setObserver(this);
        localAppRuntime.startServlet((NewIntent)localObject2);
      }
      return;
      label336:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.component.DefaultTraceNetwork
 * JD-Core Version:    0.7.0.1
 */