package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class SdkDynamicAvatarSettingHelper$2
  implements APICallback
{
  SdkDynamicAvatarSettingHelper$2(QQAppInterface paramQQAppInterface, String paramString1, Activity paramActivity, String paramString2, String paramString3, String paramString4, Intent paramIntent) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onComplete");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.jdField_a_of_type_JavaLangString, "2", "", "");
    SdkDynamicAvatarSettingHelper.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131713517), this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onSuccess");
    }
    if (SdkDynamicAvatarSettingHelper.a(this.d))
    {
      paramJSONObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("open_id");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        OpenID localOpenID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(this.jdField_a_of_type_JavaLangString);
        if (localOpenID == null) {
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            long l2 = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(l1, paramJSONObject, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), new SdkDynamicAvatarSettingHelper.2.1(this, l2));
            return;
          }
          catch (Exception paramJSONObject)
          {
            QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenidDiff exception=", paramJSONObject);
            return;
          }
        }
        if (!paramJSONObject.equals(localOpenID.openID)) {
          SdkDynamicAvatarSettingHelper.b(this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      else
      {
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenid, openId null");
      }
    }
    else
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.jdField_a_of_type_JavaLangString, "3", "", "");
      SdkDynamicAvatarSettingHelper.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131713521), this.b, this.c, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SdkDynamicAvatarSettingHelper.2
 * JD-Core Version:    0.7.0.1
 */