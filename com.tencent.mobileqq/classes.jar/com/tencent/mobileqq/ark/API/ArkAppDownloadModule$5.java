package com.tencent.mobileqq.ark.API;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkAppDownloadModule$5
  implements Runnable
{
  ArkAppDownloadModule$5(ArkAppDownloadModule paramArkAppDownloadModule, Context paramContext, String paramString1, int paramInt, String paramString2, SharedPreferences paramSharedPreferences, String paramString3, String paramString4) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext.getString(2131690800), this.jdField_a_of_type_AndroidContentContext.getString(2131690229), new ArkAppDownloadModule.5.1(this), new ArkAppDownloadModule.5.2(this));
    localQQCustomDialog.setCheckBox(this.d, null);
    localQQCustomDialog.show();
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "6", "", this.b, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.5
 * JD-Core Version:    0.7.0.1
 */