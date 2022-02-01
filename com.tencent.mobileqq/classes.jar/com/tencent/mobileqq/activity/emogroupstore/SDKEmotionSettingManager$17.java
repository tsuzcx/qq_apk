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
      if (SDKEmotionSettingManager.l(this.b))
      {
        SDKEmotionSettingManager.a(this.b, this.a);
      }
      else
      {
        paramDialogInterface = this.b;
        SDKEmotionSettingManager.a(paramDialogInterface, SDKEmotionSettingManager.a(paramDialogInterface), Long.valueOf(SDKEmotionSettingManager.b(this.b)).longValue());
        SDKEmotionSettingManager.c(this.b);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.17
 * JD-Core Version:    0.7.0.1
 */