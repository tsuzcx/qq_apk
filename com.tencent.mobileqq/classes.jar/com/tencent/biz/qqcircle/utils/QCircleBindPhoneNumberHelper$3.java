package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

final class QCircleBindPhoneNumberHelper$3
  implements DialogInterface.OnClickListener
{
  QCircleBindPhoneNumberHelper$3(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCircleBindPhoneNumberHelper.b(false);
    if (paramInt == 1)
    {
      paramDialogInterface = QCirclePluginConfig.a();
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.v();
        QCircleLauncher.a(this.a, paramDialogInterface, null, -1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleBindPhoneNumber  dialog click confirm ==> url : ");
        localStringBuilder.append(paramDialogInterface);
        QLog.i("QCircleBindPhoneNumberHelper", 1, localStringBuilder.toString());
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(2).setThrActionType(0));
      return;
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(3).setThrActionType(0));
    QLog.i("QCircleBindPhoneNumberHelper", 1, "handleBindPhoneNumber  dialog click cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper.3
 * JD-Core Version:    0.7.0.1
 */