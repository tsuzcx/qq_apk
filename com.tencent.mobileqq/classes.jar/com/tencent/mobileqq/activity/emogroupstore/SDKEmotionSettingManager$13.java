package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;

class SDKEmotionSettingManager$13
  implements DialogInterface.OnClickListener
{
  SDKEmotionSettingManager$13(SDKEmotionSettingManager paramSDKEmotionSettingManager, ArrayList paramArrayList, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SDKEmotionSettingManager.a(this.c, true);
    SDKEmotionSettingManager.k(this.c).a(1);
    SDKEmotionSettingManager.a(this.c, this.a.size(), 0.0F);
    if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      paramInt = (int)(90.0F / this.b);
      SDKEmotionSettingManager.k(this.c).b(paramInt);
    }
    SDKEmotionSettingManager.a(this.c, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.13
 * JD-Core Version:    0.7.0.1
 */