package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoRsp;

class QualityReporter$ResponseObserver
  implements BusinessObserver
{
  private NewIntent a;
  
  QualityReporter$ResponseObserver(NewIntent paramNewIntent)
  {
    this.a = paramNewIntent;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QualityReporter", 2, "onSuccess: ");
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QualityReporter", 2, "onError: code=" + paramInt + ", msg=" + paramString);
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (paramBoolean)
    {
      cc_sso_report_svr.ReportInfoRsp localReportInfoRsp;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null)
        {
          a(-123, "data null");
          return;
        }
        localReportInfoRsp = new cc_sso_report_svr.ReportInfoRsp();
        localReportInfoRsp.mergeFrom(paramBundle);
        if ((localReportInfoRsp.ret_code.has()) && (localReportInfoRsp.ret_code.get() == 0))
        {
          a();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      a(localReportInfoRsp.ret_code.get(), localReportInfoRsp.ret_msg.get());
      return;
    }
    a(-123, "success=false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.QualityReporter.ResponseObserver
 * JD-Core Version:    0.7.0.1
 */