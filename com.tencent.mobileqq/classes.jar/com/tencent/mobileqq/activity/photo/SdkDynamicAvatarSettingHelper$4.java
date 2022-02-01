package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class SdkDynamicAvatarSettingHelper$4
  implements DialogInterface.OnClickListener
{
  SdkDynamicAvatarSettingHelper$4(Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      SdkDynamicAvatarSettingHelper.a(this.jdField_a_of_type_AndroidAppActivity, false, this.jdField_a_of_type_JavaLangString, this.b, false);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SdkDynamicAvatarSettingHelper.4
 * JD-Core Version:    0.7.0.1
 */