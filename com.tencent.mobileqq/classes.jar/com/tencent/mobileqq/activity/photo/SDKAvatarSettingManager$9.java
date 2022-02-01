package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SDKAvatarSettingManager$9
  implements DialogInterface.OnClickListener
{
  SDKAvatarSettingManager$9(SDKAvatarSettingManager paramSDKAvatarSettingManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.b();
      SDKAvatarSettingManager.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.9
 * JD-Core Version:    0.7.0.1
 */