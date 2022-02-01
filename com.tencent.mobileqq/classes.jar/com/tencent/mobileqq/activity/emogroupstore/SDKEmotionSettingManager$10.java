package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class SDKEmotionSettingManager$10
  implements DialogInterface.OnKeyListener
{
  SDKEmotionSettingManager$10(SDKEmotionSettingManager paramSDKEmotionSettingManager) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      SDKEmotionSettingManager.a(this.a, SDKEmotionSettingManager.a(this.a), Long.valueOf(SDKEmotionSettingManager.a(this.a)).longValue());
      SDKEmotionSettingManager.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.10
 * JD-Core Version:    0.7.0.1
 */