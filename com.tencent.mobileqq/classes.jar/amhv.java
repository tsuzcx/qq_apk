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

public class amhv
  implements amhy, BusinessObserver
{
  private WeakReference<amhz> a;
  
  private ReportTrace.ReportHead a(amhl paramamhl, String paramString)
  {
    ReportTrace.ReportHead localReportHead = new ReportTrace.ReportHead();
    localReportHead.appid.set(paramamhl.a());
    localReportHead.platform.set(109);
    paramamhl = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramamhl = "8.4.8";
    }
    localReportHead.ver.set(paramamhl);
    paramamhl = DeviceInfoUtil.getDeviceOSVersion();
    if (!TextUtils.isEmpty(paramamhl)) {
      localReportHead.os_ver.set(paramamhl);
    }
    paramamhl = DeviceInfoUtil.getModel();
    if (!TextUtils.isEmpty(paramamhl)) {
      localReportHead.model.set(paramamhl);
    }
    paramamhl = DeviceInfoUtil.getIMEI();
    if (!TextUtils.isEmpty(paramamhl)) {
      localReportHead.udid.set(paramamhl);
    }
    return localReportHead;
  }
  
  private ReportTrace.SpanEntry a(amif paramamif)
  {
    ReportTrace.SpanEntry localSpanEntry = new ReportTrace.SpanEntry();
    localSpanEntry.span_id.set(paramamif.jdField_a_of_type_Int);
    localSpanEntry.time_stamp.set(paramamif.jdField_a_of_type_Long);
    if (paramamif.jdField_a_of_type_Amie != null) {
      localSpanEntry.result.set(a(paramamif.jdField_a_of_type_Amie));
    }
    if ((paramamif.jdField_a_of_type_JavaUtilMap != null) && (paramamif.jdField_a_of_type_JavaUtilMap.size() > 0))
    {
      paramamif = paramamif.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (paramamif.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramamif.next();
        ReportTrace.ExtParam localExtParam = new ReportTrace.ExtParam();
        localExtParam.param_id.set(((Integer)localEntry.getKey()).intValue());
        localExtParam.value.set(((Long)localEntry.getValue()).longValue());
        localSpanEntry.param_list.add(localExtParam);
      }
    }
    return localSpanEntry;
  }
  
  private ReportTrace.TraceEntry a(TraceData paramTraceData, amhl paramamhl)
  {
    ReportTrace.TraceEntry localTraceEntry = new ReportTrace.TraceEntry();
    localTraceEntry.feature_id.set(paramTraceData.featureId);
    localTraceEntry.trace_id.set(paramTraceData.traceId);
    localTraceEntry.from_uid.set(paramamhl.a());
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
      paramamhl = paramTraceData.mSpanQueue.iterator();
      while (paramamhl.hasNext())
      {
        amif localamif = (amif)paramamhl.next();
        localTraceEntry.span_list.add(a(localamif));
      }
    }
    localTraceEntry.extra1.set(paramTraceData.extra1);
    localTraceEntry.extra2.set(paramTraceData.extra2);
    localTraceEntry.extra3.set(paramTraceData.extra3);
    return localTraceEntry;
  }
  
  private ReportTrace.reportStat a(amie paramamie)
  {
    ReportTrace.reportStat localreportStat = new ReportTrace.reportStat();
    localreportStat.ret.set(paramamie.jdField_a_of_type_Int);
    localreportStat.cost.set(paramamie.b);
    localreportStat.net_type.set(paramamie.e);
    localreportStat.cpu.set(paramamie.d);
    localreportStat.memory.set(paramamie.c);
    localreportStat.java_heap.set(paramamie.f);
    localreportStat.native_heap.set(paramamie.g);
    return localreportStat;
  }
  
  private List<ReportTrace.SpanAnnoEntry> a(BlockingQueue<amif> paramBlockingQueue)
  {
    if ((paramBlockingQueue == null) || (paramBlockingQueue.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBlockingQueue = paramBlockingQueue.iterator();
    while (paramBlockingQueue.hasNext())
    {
      amif localamif = (amif)paramBlockingQueue.next();
      if ((localamif.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null) && (localamif.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size() > 0))
      {
        Iterator localIterator = localamif.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.iterator();
        while (localIterator.hasNext())
        {
          amic localamic = (amic)localIterator.next();
          ReportTrace.SpanAnnoEntry localSpanAnnoEntry = new ReportTrace.SpanAnnoEntry();
          localSpanAnnoEntry.span_id.set(localamif.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localamic.jdField_a_of_type_JavaLangString)) {
            localSpanAnnoEntry.anno_msg.set(localamic.jdField_a_of_type_JavaLangString);
          }
          if (localamif.jdField_a_of_type_Amie != null) {
            localSpanAnnoEntry.errCode.set(localamif.jdField_a_of_type_Amie.jdField_a_of_type_Int);
          }
          localSpanAnnoEntry.time_stamp.set(localamic.jdField_a_of_type_Long);
          localArrayList.add(localSpanAnnoEntry);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(AppRuntime paramAppRuntime, amhl paramamhl, String paramString, List<ReportTrace.TraceEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramamhl == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportTraceReq localReportTraceReq = new ReportTrace.ReportTraceReq();
    localReportTraceReq.head.set(a(paramamhl, paramString));
    localReportTraceReq.trace_list.set(paramList);
    paramamhl = new NewIntent(paramAppRuntime.getApplication(), amib.class);
    paramamhl.putExtra("cmd", "apollo_monitor.report_trace");
    paramamhl.putExtra("data", localReportTraceReq.toByteArray());
    paramamhl.putExtra("timeout", 30000);
    paramamhl.setObserver(this);
    paramAppRuntime.startServlet(paramamhl);
  }
  
  private void b(AppRuntime paramAppRuntime, amhl paramamhl, String paramString, List<ReportTrace.TraceAnnoEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramamhl == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportAnnoReq localReportAnnoReq = new ReportTrace.ReportAnnoReq();
    localReportAnnoReq.head.set(a(paramamhl, paramString));
    localReportAnnoReq.anno_list.set(paramList);
    paramamhl = new NewIntent(paramAppRuntime.getApplication(), amib.class);
    paramamhl.putExtra("cmd", "apollo_monitor.report_anno");
    paramamhl.putExtra("data", localReportAnnoReq.toByteArray());
    paramamhl.putExtra("timeout", 30000);
    paramamhl.setObserver(this);
    paramAppRuntime.startServlet(paramamhl);
  }
  
  public void a(amhz paramamhz)
  {
    this.a = new WeakReference(paramamhz);
  }
  
  public void a(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    amhl localamhl = amho.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localamhl != null) && (!TextUtils.isEmpty(localamhl.a())))
    {
      ArrayList localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceEntry localTraceEntry = a(localTraceData, localamhl);
        if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.4.8")))
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localTraceEntry);
          a(localAppRuntime, localamhl, localTraceData.version, localArrayList2);
        }
        else
        {
          localArrayList1.add(a(localTraceData, localamhl));
        }
      }
      a(localAppRuntime, localamhl, null, localArrayList1);
    }
  }
  
  public void b(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    amhl localamhl = amho.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localamhl != null) && (!TextUtils.isEmpty(localamhl.a())))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceAnnoEntry localTraceAnnoEntry = new ReportTrace.TraceAnnoEntry();
        localTraceAnnoEntry.uid.set(localamhl.a());
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
            if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.4.8")))
            {
              localObject = new ArrayList();
              ((List)localObject).add(localTraceAnnoEntry);
              b(localAppRuntime, localamhl, localTraceData.version, (List)localObject);
              continue;
            }
            j = 1;
            localArrayList.add(localTraceAnnoEntry);
          }
        }
        i = j;
      }
      if (i != 0) {
        b(localAppRuntime, localamhl, null, localArrayList);
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
          localObject2 = (amhz)this.a.get();
          if (localObject2 != null)
          {
            ((ReportTrace.ReportTraceRsp)localObject1).mergeFrom(paramBundle.getByteArray("data"));
            int i = ((ReportTrace.ReportTraceRsp)localObject1).report_interval.get();
            int j = ((ReportTrace.ReportTraceRsp)localObject1).report_num.get();
            if (((ReportTrace.ReportTraceRsp)localObject1).report_fail.get() != 1) {
              continue;
            }
            bool = true;
            ((amhz)localObject2).a(i, j, bool);
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
          localObject2 = new NewIntent(((AppRuntime)localObject1).getApplication(), amib.class);
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
 * Qualified Name:     amhv
 * JD-Core Version:    0.7.0.1
 */