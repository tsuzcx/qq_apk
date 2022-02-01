package com.tencent.mobileqq.ark.API;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;

class ArkAppDownloadModule$10$1
  implements DialogInterface.OnClickListener
{
  ArkAppDownloadModule$10$1(ArkAppDownloadModule.10 param10) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    WadlProxyServiceUtil.a().b(this.a.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams);
    ArkAppDownloadModule.a(this.a.this$0, true);
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "7", "", this.a.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.a, "");
    if ((paramDialogInterface instanceof QQCustomDialog))
    {
      if (!((QQCustomDialog)paramDialogInterface).getCheckBoxState()) {
        bool = true;
      }
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences == null) {}
    }
    try
    {
      this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.a.b, bool).apply();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("ark.download.module", 1, "start download sp error : ", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.10.1
 * JD-Core Version:    0.7.0.1
 */