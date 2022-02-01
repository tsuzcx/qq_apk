package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class SDKEmotionSettingManager$17
  implements DialogInterface.OnKeyListener
{
  SDKEmotionSettingManager$17(SDKEmotionSettingManager paramSDKEmotionSettingManager, int paramInt) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager))
      {
        SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager, this.jdField_a_of_type_Int);
      }
      else
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager;
        SDKEmotionSettingManager.a(paramDialogInterface, SDKEmotionSettingManager.a(paramDialogInterface), Long.valueOf(SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager)).longValue());
        SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.17
 * JD-Core Version:    0.7.0.1
 */