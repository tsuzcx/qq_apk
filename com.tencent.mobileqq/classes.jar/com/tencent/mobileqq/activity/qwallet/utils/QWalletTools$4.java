package com.tencent.mobileqq.activity.qwallet.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import axrl;
import bawx;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class QWalletTools$4
  implements Runnable
{
  public QWalletTools$4(String paramString1, int paramInt1, String paramString2, AppRuntime paramAppRuntime, String paramString3, String paramString4, int paramInt2, String paramString5, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tenpay_mqq");
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("||");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|0|1|0|android.");
    try
    {
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getPackageManager().getPackageInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getPackageName(), 0).versionName);
      localStringBuilder.append("|");
      localStringBuilder.append(bawx.a());
      localStringBuilder.append("|");
      if ((!TextUtils.isEmpty(this.c)) || (!TextUtils.isEmpty(this.d)))
      {
        localStringBuilder.append(this.c);
        localStringBuilder.append(".");
        localStringBuilder.append(this.d);
      }
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(".");
      if (!TextUtils.isEmpty(this.e)) {
        localStringBuilder.append(this.e.replace("|", ","));
      }
      localStringBuilder.append("|");
      if (0L != this.jdField_a_of_type_Long) {
        VACDReportUtil.a(this.jdField_a_of_type_Long, null, this.jdField_b_of_type_JavaLangString, "op_type=" + this.jdField_a_of_type_Int, 0, "");
      }
      axrl.a(BaseApplication.getContext()).b(this.jdField_a_of_type_MqqAppAppRuntime, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.4
 * JD-Core Version:    0.7.0.1
 */