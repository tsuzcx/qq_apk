package com.tencent.mobileqq.activity.emogroupstore;

import java.util.List;

class SDKEmotionSettingManager$20
  implements Runnable
{
  SDKEmotionSettingManager$20(SDKEmotionSettingManager paramSDKEmotionSettingManager, int paramInt1, int paramInt2, int paramInt3) {}
  
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
      SDKEmotionSettingManager.a(localSDKEmotionSettingManager, SDKEmotionSettingManager.a(localSDKEmotionSettingManager), Long.valueOf(SDKEmotionSettingManager.b(this.this$0)).longValue(), true, null);
    }
    if (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (SDKEmotionSettingManager.n(this.this$0) != null)
      {
        i = j;
        if (SDKEmotionSettingManager.n(this.this$0).size() > 0) {
          i = ((Integer)SDKEmotionSettingManager.n(this.this$0).get(0)).intValue();
        }
      }
      SDKEmotionSettingManager.a(this.this$0, i, null);
      return;
    }
    SDKEmotionSettingManager.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */