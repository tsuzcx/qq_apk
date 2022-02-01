package com.tencent.mobileqq.ark.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ArkDownloadController$2
  implements DialogInterface.OnClickListener
{
  ArkDownloadController$2(ArkDownloadController paramArkDownloadController, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController).size())
        {
          ArkDownloadItem localArkDownloadItem = (ArkDownloadItem)ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController).get(i);
          if (localArkDownloadItem == null) {
            break label269;
          }
          localArkDownloadItem.a.onClick(ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController), paramInt);
          break label269;
        }
      }
      finally {}
      try
      {
        ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController, false);
        if ((ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController) != null) && (ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController).isShowing())) {
          ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController).dismiss();
        }
        ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
        continue;
        if (paramInt != 0) {
          continue;
        }
        ReportController.a(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController))) });
      if (paramInt == 1)
      {
        ReportController.a(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(ArkDownloadController.a(this.jdField_a_of_type_ComTencentMobileqqArkDownloadArkDownloadController)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      label269:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.download.ArkDownloadController.2
 * JD-Core Version:    0.7.0.1
 */