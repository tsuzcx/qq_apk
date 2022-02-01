package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class ArkAppDownloadModule$10
  implements Runnable
{
  ArkAppDownloadModule$10(ArkAppDownloadModule paramArkAppDownloadModule, Context paramContext, String paramString1, WadlParams paramWadlParams, SharedPreferences paramSharedPreferences, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject == null)
    {
      QLog.e("ark.download.module", 1, "start download context is null");
      return;
    }
    localObject = DialogUtil.a((Context)localObject, 230, null, this.jdField_a_of_type_JavaLangString, ((Context)localObject).getString(2131690728), this.jdField_a_of_type_AndroidContentContext.getString(2131690145), new ArkAppDownloadModule.10.1(this), new ArkAppDownloadModule.10.2(this));
    ((QQCustomDialog)localObject).setCheckBox(this.c, null);
    ((QQCustomDialog)localObject).show();
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "6", "", this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.jdField_a_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.10
 * JD-Core Version:    0.7.0.1
 */