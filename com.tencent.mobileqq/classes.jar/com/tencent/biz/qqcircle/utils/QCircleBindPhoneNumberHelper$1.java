package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

final class QCircleBindPhoneNumberHelper$1
  implements AccountIdentityCallBack
{
  QCircleBindPhoneNumberHelper$1(boolean paramBoolean) {}
  
  public void onSuccess(boolean paramBoolean, String paramString)
  {
    int j = 2;
    int i;
    if (((paramString != null) && (paramString.trim().length() > 0)) || (paramBoolean))
    {
      Object localObject = QCirclePluginConfig.a();
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      ((QCirclePluginConfig)localObject).a(i);
      ((QCirclePluginConfig)localObject).a(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshAccountState  getAccountIdentitySuccess  isAuthenticated : ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("  ， url ： ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QCircleBindPhoneNumberHelper", 1, ((StringBuilder)localObject).toString());
    }
    if (this.a)
    {
      paramString = new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(4);
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      QCircleLpReportDc05504.report(paramString.setThrActionType(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper.1
 * JD-Core Version:    0.7.0.1
 */