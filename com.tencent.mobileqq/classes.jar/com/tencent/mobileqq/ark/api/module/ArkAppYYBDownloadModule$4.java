package com.tencent.mobileqq.ark.api.module;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

class ArkAppYYBDownloadModule$4
  implements DialogInterface.OnClickListener
{
  ArkAppYYBDownloadModule$4(ArkAppYYBDownloadModule paramArkAppYYBDownloadModule, String paramString1, String paramString2, DownloadInfo paramDownloadInfo, boolean paramBoolean, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("ArkApp.downloadyyb.module", 1, new Object[] { "ark.dctrl [doDownloadAction] dialog callback appid=", this.jdField_a_of_type_JavaLangString, ",name=", this.b, ",which:", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      ArkAppYYBDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.4
 * JD-Core Version:    0.7.0.1
 */