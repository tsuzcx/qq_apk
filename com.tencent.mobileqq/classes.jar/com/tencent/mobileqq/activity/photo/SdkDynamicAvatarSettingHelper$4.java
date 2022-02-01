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
      SdkDynamicAvatarSettingHelper.a(this.a, false, this.b, this.c, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SdkDynamicAvatarSettingHelper.4
 * JD-Core Version:    0.7.0.1
 */