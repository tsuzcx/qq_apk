package com.tencent.mobileqq.ark.debug;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessorCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ArkAsyncShareMiniAppTest$1$1
  implements Runnable
{
  ArkAsyncShareMiniAppTest$1$1(ArkAsyncShareMiniAppTest.1 param1, JSONObject paramJSONObject, IArkMessagePreprocessorCallback paramIArkMessagePreprocessorCallback, Object paramObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_OrgJsonJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqArkShareIArkMessagePreprocessorCallback == null) || (this.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof Bundle))) {
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process return callback=", this.jdField_a_of_type_ComTencentMobileqqArkShareIArkMessagePreprocessorCallback });
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process engine res =", "test" });
      }
      try
      {
        long l = ((Bundle)this.jdField_a_of_type_JavaLangObject).getLong("key_process_message_uniseq");
        if (TextUtils.isEmpty("test")) {
          break;
        }
        JSONObject localJSONObject3 = new JSONObject(this.jdField_a_of_type_OrgJsonJSONObject.getString("forward_ark_app_meta"));
        JSONObject localJSONObject2 = localJSONObject3.optJSONObject("intro");
        JSONObject localJSONObject1 = localJSONObject2;
        if (localJSONObject2 == null) {
          localJSONObject1 = localJSONObject3.optJSONObject("detail");
        }
        localJSONObject1.put("desc", "uniseq=" + String.valueOf(l) + ", 更新metaData接口测试,测试更新meta中的desc");
        this.jdField_a_of_type_OrgJsonJSONObject.put("forward_ark_app_meta", localJSONObject3.toString());
        bool = true;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, "AAShare.mArkMessagePreprocessor process e =", localJSONException);
          boolean bool = false;
        }
      }
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process isProcessed=", Boolean.valueOf(bool), ", msgJson=", this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    } while (this.jdField_a_of_type_ComTencentMobileqqArkShareIArkMessagePreprocessorCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqArkShareIArkMessagePreprocessorCallback.a(bool, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkAsyncShareMiniAppTest.1.1
 * JD-Core Version:    0.7.0.1
 */