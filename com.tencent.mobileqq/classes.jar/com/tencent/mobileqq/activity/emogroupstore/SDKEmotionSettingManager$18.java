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
      localStringBuilder.append(SDKEmotionSettingManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager));
      QLog.d("SDKEmotionSettingManager", 2, localStringBuilder.toString());
    }
    if (!SDKEmotionSettingManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager))
    {
      SDKEmotionSettingManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager, paramList);
      SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager, this.jdField_a_of_type_Int, paramFloat);
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
      localStringBuilder.append(SDKEmotionSettingManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager));
      QLog.d("SDKEmotionSettingManager", 2, localStringBuilder.toString());
    }
    if (!SDKEmotionSettingManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager))
    {
      SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).removeMessages(11);
      SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.18
 * JD-Core Version:    0.7.0.1
 */