package com.tencent.mobileqq.activity.photo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.utils.QQCustomDialog;

class SDKAvatarSettingManager$7
  implements DialogInterface.OnKeyListener
{
  SDKAvatarSettingManager$7(SDKAvatarSettingManager paramSDKAvatarSettingManager) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.a.a.dismiss();
      paramDialogInterface = this.a;
      SDKAvatarSettingManager.a(paramDialogInterface, SDKAvatarSettingManager.a(paramDialogInterface), true, Long.valueOf(SDKAvatarSettingManager.b(this.a)).longValue(), true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.7
 * JD-Core Version:    0.7.0.1
 */