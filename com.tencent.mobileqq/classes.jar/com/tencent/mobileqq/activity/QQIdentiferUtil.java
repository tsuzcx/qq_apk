package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.AppConf.ServiceProtocolSerializable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQIdentiferUtil
{
  public static void a(AppConf paramAppConf, String paramString)
  {
    if ((paramAppConf != null) && (!paramAppConf.serviceProtocols.isEmpty()))
    {
      paramAppConf = (AppConf.ServiceProtocolSerializable)paramAppConf.serviceProtocols.get(0);
      if ((!TextUtils.isEmpty(paramAppConf.name)) && (!TextUtils.isEmpty(paramAppConf.url)))
      {
        QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", auto save" });
        ReportController.b(null, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
        return;
      }
      QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", sp.name || sp.url empty, not save" });
      ReportController.b(null, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
      return;
    }
    QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", appConf.serviceProtocols.isEmpty, not save" });
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferUtil
 * JD-Core Version:    0.7.0.1
 */