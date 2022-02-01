package com.tencent.mobileqq.activity.emogroupstore;

import java.util.List;

class SDKEmotionSettingManager$21
  implements Runnable
{
  SDKEmotionSettingManager$21(SDKEmotionSettingManager paramSDKEmotionSettingManager, int paramInt1, int paramInt2, String paramString, List paramList, int paramInt3) {}
  
  public void run()
  {
    if (SDKEmotionSettingManager.k(this.this$0) != null) {
      SDKEmotionSettingManager.k(this.this$0).dismiss();
    }
    SDKEmotionSettingManager.a(this.this$0, false);
    SDKEmotionSettingManager localSDKEmotionSettingManager;
    if (this.a == this.b)
    {
      localSDKEmotionSettingManager = this.this$0;
      SDKEmotionSettingManager.a(localSDKEmotionSettingManager, SDKEmotionSettingManager.a(localSDKEmotionSettingManager), Long.valueOf(SDKEmotionSettingManager.b(this.this$0)).longValue(), true);
    }
    else
    {
      localSDKEmotionSettingManager = this.this$0;
      SDKEmotionSettingManager.a(localSDKEmotionSettingManager, SDKEmotionSettingManager.a(localSDKEmotionSettingManager), Long.valueOf(SDKEmotionSettingManager.b(this.this$0)).longValue(), true, this.c);
    }
    if (this.a == 1)
    {
      SDKEmotionSettingManager.a(this.this$0, ((Integer)this.d.get(0)).intValue(), this.c);
      return;
    }
    SDKEmotionSettingManager.a(this.this$0, this.b, this.e, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21
 * JD-Core Version:    0.7.0.1
 */