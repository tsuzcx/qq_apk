package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_0xb6f.Identity;
import tencent.im.oidb.oidb_0xb6f.ReportFreqReqBody;
import tencent.im.oidb.oidb_0xb6f.ReqBody;

public class DoraemonAPIReporterMain
  implements DoraemonAPIReporter
{
  DoraemonAPIReporter.OnFrequenceDataUpdateListener a;
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    if (MobileQQ.sProcessId != 1)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "process is not main process");
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "app is null");
      return;
    }
    oidb_0xb6f.ReqBody localReqBody = new oidb_0xb6f.ReqBody();
    localReqBody.report_freq_req.identity.apptype.set(paramInt1);
    try
    {
      localReqBody.report_freq_req.identity.appid.set(Integer.parseInt(paramString2));
      localReqBody.report_freq_req.identity.apiName.set(paramString3);
      localReqBody.report_freq_req.identity.setHasFlag(true);
      localReqBody.report_freq_req.invoke_times.set(paramInt2);
      localReqBody.report_freq_req.setHasFlag(true);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("send key=");
        paramString2.append(paramString1);
        paramString2.append(", api=");
        paramString2.append(paramString3);
        paramString2.append(", count=");
        paramString2.append(paramInt2);
        QLog.i("DoraemonOpenAPI.report", 2, paramString2.toString());
      }
      ProtoUtils.a(localAppRuntime, new DoraemonAPIReporterMain.2(this, paramString1, paramString3, paramInt2), localReqBody.toByteArray(), "OidbSvc.0xb6f_1", 2927, 1, null, 0L);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      paramString3 = new StringBuilder();
      paramString3.append("parse appid error appid=");
      paramString3.append(paramString2);
      QLog.e("DoraemonOpenAPI.report", 1, paramString3.toString(), paramString1);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFrequenceData key=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", api=");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", remain=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", exp=");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("DoraemonOpenAPI.report", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject != null) && (MobileQQ.sProcessId == 1)) {
      ThreadManager.post(new DoraemonAPIReporterMain.3(this, (AppRuntime)localObject, paramInt, paramString2, paramString3, paramLong1, paramLong2), 5, null, true);
    } else {
      QLog.e("DoraemonOpenAPI.report", 1, "app is null or process is not main process");
    }
    localObject = this.a;
    if (localObject != null) {
      ThreadManager.getUIHandler().post(new DoraemonAPIReporterMain.4(this, (DoraemonAPIReporter.OnFrequenceDataUpdateListener)localObject, paramString1, paramInt, paramString2, paramString3, paramLong1, paramLong2));
    }
  }
  
  private void a(String paramString, List<APIQuotaEntity> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFrequenceDataBatch key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("DoraemonOpenAPI.report", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      HashMap localHashMap = new HashMap(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        APIQuotaEntity localAPIQuotaEntity = (APIQuotaEntity)paramList.next();
        APIQuotaItem localAPIQuotaItem = new APIQuotaItem();
        localAPIQuotaItem.remainTimes = localAPIQuotaEntity.remainTimes;
        localAPIQuotaItem.expireTimeMillis = localAPIQuotaEntity.expireTimeMillis;
        localHashMap.put(localAPIQuotaEntity.apiName, localAPIQuotaItem);
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIReporterMain.5(this, (DoraemonAPIReporter.OnFrequenceDataUpdateListener)localObject, paramString, localHashMap));
    }
  }
  
  public void a(DoraemonAPIReporter.OnFrequenceDataUpdateListener paramOnFrequenceDataUpdateListener)
  {
    this.a = paramOnFrequenceDataUpdateListener;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (MobileQQ.sProcessId != 1)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "process is not main process");
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "app is null");
      return;
    }
    ThreadManager.post(new DoraemonAPIReporterMain.1(this, localAppRuntime, paramInt, paramString2, paramString1), 5, null, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, paramString2, paramString3, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain
 * JD-Core Version:    0.7.0.1
 */