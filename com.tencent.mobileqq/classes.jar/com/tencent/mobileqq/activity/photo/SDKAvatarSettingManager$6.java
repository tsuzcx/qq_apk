package com.tencent.mobileqq.activity.photo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class SDKAvatarSettingManager$6
  implements DialogInterface.OnClickListener
{
  SDKAvatarSettingManager$6(SDKAvatarSettingManager paramSDKAvatarSettingManager, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009B6D", "0X8009B6D", 0, 0, "", "", "", "");
        paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager;
        SDKAvatarSettingManager.a(paramDialogInterface, SDKAvatarSettingManager.a(paramDialogInterface), true, Long.valueOf(SDKAvatarSettingManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager)).longValue(), true);
      }
    }
    else
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009B6C", "0X8009B6C", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager.b();
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager;
      SDKAvatarSettingManager.a(paramDialogInterface, SDKAvatarSettingManager.a(paramDialogInterface), true, Long.valueOf(SDKAvatarSettingManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager)).longValue(), false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSDKAvatarSettingManager.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.6
 * JD-Core Version:    0.7.0.1
 */