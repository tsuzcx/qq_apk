package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import rck;
import tencent.im.oidb.oidb_0xb6f.Identity;
import tencent.im.oidb.oidb_0xb6f.ReportFreqReqBody;
import tencent.im.oidb.oidb_0xb6f.ReqBody;

public class DoraemonAPIReporterMain
  implements DoraemonAPIReporter
{
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "app is null");
      return;
    }
    oidb_0xb6f.ReqBody localReqBody = new oidb_0xb6f.ReqBody();
    localReqBody.report_freq_req.identity.appType.set(paramInt1);
    try
    {
      localReqBody.report_freq_req.identity.appid.set(Integer.parseInt(paramString1));
      localReqBody.report_freq_req.identity.apiName.set(paramString2);
      localReqBody.report_freq_req.identity.setHasFlag(true);
      localReqBody.report_freq_req.invoke_times.set(paramInt2);
      localReqBody.report_freq_req.setHasFlag(true);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.report", 2, "send " + paramInt1 + "|" + paramString1 + "|" + paramString2 + "|" + paramInt2);
      }
      ProtoUtils.a(localAppRuntime, new rck(this, paramInt1, paramString1, paramString2, paramInt2), localReqBody.toByteArray(), "OidbSvc.0xb6f_1", 2927, 1, null, 0L);
      return;
    }
    catch (NumberFormatException paramString2)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "parse appid error appid=" + paramString1, paramString2);
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.report", 2, "updateFrequenceData " + paramInt + "|" + paramString1 + "|" + paramString2 + " min=" + paramLong1 + ", day=" + paramLong2);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, 1);
  }
  
  public void a(DoraemonAPIReporter.OnFrequenceDataUpdateListener paramOnFrequenceDataUpdateListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain
 * JD-Core Version:    0.7.0.1
 */