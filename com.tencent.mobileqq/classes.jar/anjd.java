import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
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

public class anjd
  implements anjg, BusinessObserver
{
  private WeakReference<anjh> a;
  
  private ReportTrace.ReportHead a(anit paramanit, String paramString)
  {
    ReportTrace.ReportHead localReportHead = new ReportTrace.ReportHead();
    localReportHead.appid.set(paramanit.a());
    localReportHead.platform.set(109);
    paramanit = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramanit = "8.4.10";
    }
    localReportHead.ver.set(paramanit);
    paramanit = DeviceInfoUtil.getDeviceOSVersion();
    if (!TextUtils.isEmpty(paramanit)) {
      localReportHead.os_ver.set(paramanit);
    }
    paramanit = DeviceInfoUtil.getModel();
    if (!TextUtils.isEmpty(paramanit)) {
      localReportHead.model.set(paramanit);
    }
    paramanit = DeviceInfoUtil.getIMEI();
    if (!TextUtils.isEmpty(paramanit)) {
      localReportHead.udid.set(paramanit);
    }
    return localReportHead;
  }
  
  private ReportTrace.SpanEntry a(anjn paramanjn)
  {
    ReportTrace.SpanEntry localSpanEntry = new ReportTrace.SpanEntry();
    localSpanEntry.span_id.set(paramanjn.jdField_a_of_type_Int);
    localSpanEntry.time_stamp.set(paramanjn.jdField_a_of_type_Long);
    if (paramanjn.jdField_a_of_type_Anjm != null) {
      localSpanEntry.result.set(a(paramanjn.jdField_a_of_type_Anjm));
    }
    if ((paramanjn.jdField_a_of_type_JavaUtilMap != null) && (paramanjn.jdField_a_of_type_JavaUtilMap.size() > 0))
    {
      paramanjn = paramanjn.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (paramanjn.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramanjn.next();
        ReportTrace.ExtParam localExtParam = new ReportTrace.ExtParam();
        localExtParam.param_id.set(((Integer)localEntry.getKey()).intValue());
        localExtParam.value.set(((Long)localEntry.getValue()).longValue());
        localSpanEntry.param_list.add(localExtParam);
      }
    }
    return localSpanEntry;
  }
  
  private ReportTrace.TraceEntry a(TraceData paramTraceData, anit paramanit)
  {
    ReportTrace.TraceEntry localTraceEntry = new ReportTrace.TraceEntry();
    localTraceEntry.feature_id.set(paramTraceData.featureId);
    localTraceEntry.trace_id.set(paramTraceData.traceId);
    localTraceEntry.from_uid.set(paramanit.a());
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
      paramanit = paramTraceData.mSpanQueue.iterator();
      while (paramanit.hasNext())
      {
        anjn localanjn = (anjn)paramanit.next();
        localTraceEntry.span_list.add(a(localanjn));
      }
    }
    localTraceEntry.extra1.set(paramTraceData.extra1);
    localTraceEntry.extra2.set(paramTraceData.extra2);
    localTraceEntry.extra3.set(paramTraceData.extra3);
    return localTraceEntry;
  }
  
  private ReportTrace.reportStat a(anjm paramanjm)
  {
    ReportTrace.reportStat localreportStat = new ReportTrace.reportStat();
    localreportStat.ret.set(paramanjm.jdField_a_of_type_Int);
    localreportStat.cost.set(paramanjm.b);
    localreportStat.net_type.set(paramanjm.e);
    localreportStat.cpu.set(paramanjm.d);
    localreportStat.memory.set(paramanjm.c);
    localreportStat.java_heap.set(paramanjm.f);
    localreportStat.native_heap.set(paramanjm.g);
    return localreportStat;
  }
  
  private List<ReportTrace.SpanAnnoEntry> a(BlockingQueue<anjn> paramBlockingQueue)
  {
    if ((paramBlockingQueue == null) || (paramBlockingQueue.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBlockingQueue = paramBlockingQueue.iterator();
    while (paramBlockingQueue.hasNext())
    {
      anjn localanjn = (anjn)paramBlockingQueue.next();
      if ((localanjn.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null) && (localanjn.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size() > 0))
      {
        Iterator localIterator = localanjn.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.iterator();
        while (localIterator.hasNext())
        {
          anjk localanjk = (anjk)localIterator.next();
          ReportTrace.SpanAnnoEntry localSpanAnnoEntry = new ReportTrace.SpanAnnoEntry();
          localSpanAnnoEntry.span_id.set(localanjn.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localanjk.jdField_a_of_type_JavaLangString)) {
            localSpanAnnoEntry.anno_msg.set(localanjk.jdField_a_of_type_JavaLangString);
          }
          if (localanjn.jdField_a_of_type_Anjm != null) {
            localSpanAnnoEntry.errCode.set(localanjn.jdField_a_of_type_Anjm.jdField_a_of_type_Int);
          }
          localSpanAnnoEntry.time_stamp.set(localanjk.jdField_a_of_type_Long);
          localArrayList.add(localSpanAnnoEntry);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(AppRuntime paramAppRuntime, anit paramanit, String paramString, List<ReportTrace.TraceEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramanit == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportTraceReq localReportTraceReq = new ReportTrace.ReportTraceReq();
    localReportTraceReq.head.set(a(paramanit, paramString));
    localReportTraceReq.trace_list.set(paramList);
    paramanit = new NewIntent(paramAppRuntime.getApplication(), anjj.class);
    paramanit.putExtra("cmd", "apollo_monitor.report_trace");
    paramanit.putExtra("data", localReportTraceReq.toByteArray());
    paramanit.putExtra("timeout", 30000);
    paramanit.setObserver(this);
    paramAppRuntime.startServlet(paramanit);
  }
  
  private void b(AppRuntime paramAppRuntime, anit paramanit, String paramString, List<ReportTrace.TraceAnnoEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramanit == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportAnnoReq localReportAnnoReq = new ReportTrace.ReportAnnoReq();
    localReportAnnoReq.head.set(a(paramanit, paramString));
    localReportAnnoReq.anno_list.set(paramList);
    paramanit = new NewIntent(paramAppRuntime.getApplication(), anjj.class);
    paramanit.putExtra("cmd", "apollo_monitor.report_anno");
    paramanit.putExtra("data", localReportAnnoReq.toByteArray());
    paramanit.putExtra("timeout", 30000);
    paramanit.setObserver(this);
    paramAppRuntime.startServlet(paramanit);
  }
  
  public void a(anjh paramanjh)
  {
    this.a = new WeakReference(paramanjh);
  }
  
  public void a(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    anit localanit = aniw.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localanit != null) && (!TextUtils.isEmpty(localanit.a())))
    {
      ArrayList localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceEntry localTraceEntry = a(localTraceData, localanit);
        if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.4.10")))
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localTraceEntry);
          a(localAppRuntime, localanit, localTraceData.version, localArrayList2);
        }
        else
        {
          localArrayList1.add(a(localTraceData, localanit));
        }
      }
      a(localAppRuntime, localanit, null, localArrayList1);
    }
  }
  
  public void b(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    anit localanit = aniw.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localanit != null) && (!TextUtils.isEmpty(localanit.a())))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceAnnoEntry localTraceAnnoEntry = new ReportTrace.TraceAnnoEntry();
        localTraceAnnoEntry.uid.set(localanit.a());
        localTraceAnnoEntry.trace_id.set(localTraceData.traceId);
        localTraceAnnoEntry.feature_id.set(localTraceData.featureId);
        localTraceAnnoEntry.server_timestamp.set(localTraceData.serverTime);
        int j = i;
        if (localTraceData.result != null)
        {
          j = i;
          if (localTraceData.result.jdField_a_of_type_Int != 0)
          {
            localTraceAnnoEntry.ret.set(localTraceData.result.jdField_a_of_type_Int);
            Object localObject = a(localTraceData.mSpanQueue);
            if (localObject != null) {
              localTraceAnnoEntry.span_anno_list.addAll((Collection)localObject);
            }
            if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.4.10")))
            {
              localObject = new ArrayList();
              ((List)localObject).add(localTraceAnnoEntry);
              b(localAppRuntime, localanit, localTraceData.version, (List)localObject);
              continue;
            }
            j = 1;
            localArrayList.add(localTraceAnnoEntry);
          }
        }
        i = j;
      }
      if (i != 0) {
        b(localAppRuntime, localanit, null, localArrayList);
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("cmd");
    if (("apollo_monitor.report_trace".equals(str)) || ("apollo_monitor.report_anno".equals(str)))
    {
      if (paramBoolean) {
        break label318;
      }
      paramInt = paramBundle.getInt("retryTime");
      QLog.w("TraceReport", 1, "cmd:" + str + ",retryTime:" + paramInt);
    }
    for (;;)
    {
      Object localObject1;
      if (("apollo_monitor.report_trace".equals(str)) && (paramBoolean) && (this.a != null)) {
        localObject1 = new ReportTrace.ReportTraceRsp();
      }
      for (;;)
      {
        try
        {
          localObject2 = (anjh)this.a.get();
          if (localObject2 != null)
          {
            ((ReportTrace.ReportTraceRsp)localObject1).mergeFrom(paramBundle.getByteArray("data"));
            int i = ((ReportTrace.ReportTraceRsp)localObject1).report_interval.get();
            int j = ((ReportTrace.ReportTraceRsp)localObject1).report_num.get();
            if (((ReportTrace.ReportTraceRsp)localObject1).report_fail.get() != 1) {
              continue;
            }
            bool = true;
            ((anjh)localObject2).a(i, j, bool);
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          boolean bool;
          QLog.e("TraceReport", 1, localException, new Object[0]);
          continue;
        }
        localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
        if ((!paramBoolean) && (paramInt < 1) && (localObject1 != null))
        {
          localObject2 = new NewIntent(((AppRuntime)localObject1).getApplication(), anjj.class);
          ((NewIntent)localObject2).putExtra("retryTime", paramInt + 1);
          ((NewIntent)localObject2).putExtra("cmd", str);
          ((NewIntent)localObject2).putExtra("data", paramBundle.getByteArray("request_data"));
          ((NewIntent)localObject2).putExtra("timeout", 30000);
          ((NewIntent)localObject2).setObserver(this);
          ((AppRuntime)localObject1).startServlet((NewIntent)localObject2);
        }
        return;
        bool = false;
      }
      label318:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjd
 * JD-Core Version:    0.7.0.1
 */