package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class SDKEmotionSettingManager$18
  implements IFavroamingManagerService.AddCustomEmotionsCallback
{
  SDKEmotionSettingManager$18(SDKEmotionSettingManager paramSDKEmotionSettingManager, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("upLoadEmotions progress=");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", addEmotionsResults=");
      localStringBuilder.append(paramList);
      localStringBuilder.append(", isTimeOut=");
      localStringBuilder.append(SDKEmotionSettingManager.m(this.b));
      QLog.d("SDKEmotionSettingManager", 2, localStringBuilder.toString());
    }
    if (!SDKEmotionSettingManager.m(this.b))
    {
      SDKEmotionSettingManager.b(this.b, paramList);
      SDKEmotionSettingManager.a(this.b, this.a, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUploadFinish , addEmotionsResults=");
      localStringBuilder.append(paramList);
      localStringBuilder.append(", isTimeOut=");
      localStringBuilder.append(SDKEmotionSettingManager.m(this.b));
      QLog.d("SDKEmotionSettingManager", 2, localStringBuilder.toString());
    }
    if (!SDKEmotionSettingManager.m(this.b))
    {
      SDKEmotionSettingManager.e(this.b).removeMessages(11);
      SDKEmotionSettingManager.a(this.b, this.a, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.18
 * JD-Core Version:    0.7.0.1
 */