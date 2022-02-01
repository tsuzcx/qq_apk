package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.ServiceProtocolSerializable;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQIdentiferUtil
{
  public static void a(FaceDetectForThirdPartyManager.AppConf paramAppConf, String paramString)
  {
    if ((paramAppConf == null) || (paramAppConf.serviceProtocols.isEmpty()))
    {
      QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", appConf.serviceProtocols.isEmpty, not save" });
      ForwardUtils.a(null, paramString, 1, new String[0]);
      return;
    }
    paramAppConf = (FaceDetectForThirdPartyManager.ServiceProtocolSerializable)paramAppConf.serviceProtocols.get(0);
    if ((TextUtils.isEmpty(paramAppConf.name)) || (TextUtils.isEmpty(paramAppConf.url)))
    {
      QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", sp.name || sp.url empty, not save" });
      ForwardUtils.a(null, paramString, 1, new String[0]);
      return;
    }
    QLog.d("QQIdentiferUtil", 1, new Object[] { "report action=", paramString, ", auto save" });
    ForwardUtils.a(null, paramString, 2, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferUtil
 * JD-Core Version:    0.7.0.1
 */