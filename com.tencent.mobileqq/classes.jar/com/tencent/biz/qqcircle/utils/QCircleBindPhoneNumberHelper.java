package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

public class QCircleBindPhoneNumberHelper
{
  private static boolean a = false;
  
  public static void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshAccountState  isBackFromH5 : ");
    localStringBuilder.append(paramBoolean);
    QLog.i("QCircleBindPhoneNumberHelper", 1, localStringBuilder.toString());
    HostStaticInvokeHelper.sendQCircleAccountIdentityRequest(new QCircleBindPhoneNumberHelper.1(paramBoolean));
  }
  
  public static boolean a()
  {
    boolean bool3 = QCircleConfigHelper.u();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool3)
    {
      Object localObject = QCirclePluginConfig.a();
      bool1 = bool2;
      if (localObject != null)
      {
        int i = ((QCirclePluginConfig)localObject).u();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkIsBindPhoneNumber  isAuthenticated : ");
        ((StringBuilder)localObject).append(i);
        QLog.i("QCircleBindPhoneNumberHelper", 1, ((StringBuilder)localObject).toString());
        if (i == 0)
        {
          a(false);
          return true;
        }
        if (i == 2)
        {
          a(false);
          return false;
        }
        if (i == 1) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      if (a) {
        return false;
      }
      if (paramContext.getResources() != null)
      {
        String str1 = paramContext.getResources().getString(2131895637);
        String str2 = paramContext.getResources().getString(2131895635);
        QCircleBindPhoneNumberHelper.3 local3 = new QCircleBindPhoneNumberHelper.3(paramContext);
        paramContext = QCircleCustomDialog.a(paramContext, str1, str2, 2131895634, 2131895636, local3, local3);
        paramContext.setCancelable(false);
        a = true;
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(1).setThrActionType(paramInt));
        paramContext.show();
        QLog.i("QCircleBindPhoneNumberHelper", 1, "handleBindPhoneNumber  dialog show");
      }
      return true;
    }
    return false;
  }
  
  public static void b()
  {
    RFThreadManager.execute(new QCircleBindPhoneNumberHelper.2(), RFThreadManager.Normal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper
 * JD-Core Version:    0.7.0.1
 */