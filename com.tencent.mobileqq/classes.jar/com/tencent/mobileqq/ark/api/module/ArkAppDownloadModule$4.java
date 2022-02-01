package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ArkAppDownloadModule$4
  implements DialogInterface.OnClickListener
{
  ArkAppDownloadModule$4(ArkAppDownloadModule paramArkAppDownloadModule, WadlParams paramWadlParams, Context paramContext, double paramDouble) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl [StartDownload] dialog callback appid=", this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.a, ",name=", this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.j, ",which:", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppDownloadModule.d(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule), new ArkAppDownloadModule.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.4
 * JD-Core Version:    0.7.0.1
 */