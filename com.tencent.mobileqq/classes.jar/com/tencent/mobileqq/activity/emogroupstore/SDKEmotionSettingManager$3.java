package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class SDKEmotionSettingManager$3
  implements APICallback
{
  SDKEmotionSettingManager$3(SDKEmotionSettingManager paramSDKEmotionSettingManager, String paramString) {}
  
  public void a()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void a(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if (!SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.b) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.d();
      if (SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager) != null) {
        SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).removeCallbacks(SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.a(HardCodeUtil.a(2131713525), this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((!SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.d();
      if (SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager) != null) {
        SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).removeCallbacks(SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.a(HardCodeUtil.a(2131713524), this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if (!SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.b) {
        return;
      }
      if (SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager) != null) {
        SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).removeCallbacks(SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager));
      }
      SDKEmotionSettingManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.3
 * JD-Core Version:    0.7.0.1
 */