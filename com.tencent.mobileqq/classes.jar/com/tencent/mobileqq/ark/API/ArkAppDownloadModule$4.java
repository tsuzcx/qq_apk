package com.tencent.mobileqq.ark.API;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

class ArkAppDownloadModule$4
  implements DialogInterface.OnClickListener
{
  ArkAppDownloadModule$4(ArkAppDownloadModule paramArkAppDownloadModule, WadlParams paramWadlParams, Context paramContext, double paramDouble) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl [StartDownload] dialog callback appid=", this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.a, ",name=", this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.j, ",which:", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      ArkAppCenter.a().post(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule.a, new ArkAppDownloadModule.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.4
 * JD-Core Version:    0.7.0.1
 */