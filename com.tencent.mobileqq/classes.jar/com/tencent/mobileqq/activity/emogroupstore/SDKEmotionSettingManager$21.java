package com.tencent.mobileqq.activity.emogroupstore;

import java.util.List;

class SDKEmotionSettingManager$21
  implements Runnable
{
  SDKEmotionSettingManager$21(SDKEmotionSettingManager paramSDKEmotionSettingManager, int paramInt1, int paramInt2, String paramString, List paramList, int paramInt3) {}
  
  public void run()
  {
    if (SDKEmotionSettingManager.a(this.this$0) != null) {
      SDKEmotionSettingManager.a(this.this$0).dismiss();
    }
    SDKEmotionSettingManager.a(this.this$0, false);
    SDKEmotionSettingManager localSDKEmotionSettingManager;
    if (this.jdField_a_of_type_Int == this.b)
    {
      localSDKEmotionSettingManager = this.this$0;
      SDKEmotionSettingManager.a(localSDKEmotionSettingManager, SDKEmotionSettingManager.a(localSDKEmotionSettingManager), Long.valueOf(SDKEmotionSettingManager.a(this.this$0)).longValue(), true);
    }
    else
    {
      localSDKEmotionSettingManager = this.this$0;
      SDKEmotionSettingManager.a(localSDKEmotionSettingManager, SDKEmotionSettingManager.a(localSDKEmotionSettingManager), Long.valueOf(SDKEmotionSettingManager.a(this.this$0)).longValue(), true, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      SDKEmotionSettingManager.a(this.this$0, ((Integer)this.jdField_a_of_type_JavaUtilList.get(0)).intValue(), this.jdField_a_of_type_JavaLangString);
      return;
    }
    SDKEmotionSettingManager.a(this.this$0, this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21
 * JD-Core Version:    0.7.0.1
 */