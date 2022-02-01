package com.tencent.mobileqq.apollo.api.web.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloResUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class ApolloJsPluginImpl$6$1
  implements Runnable
{
  ApolloJsPluginImpl$6$1(ApolloJsPluginImpl.6 param6, String paramString) {}
  
  public void run()
  {
    Object localObject = ApolloResUtil.a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] fileJsonFilePath is null!");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_JavaLangString, "file face.json is not exists!");
      return;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists())
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] file face.json is not exists!");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_JavaLangString, "file face.json is not exists!");
      return;
    }
    try
    {
      localObject = FileUtils.b((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put(ApolloConstant.b, new JSONObject((String)localObject));
        this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackOk(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_JavaLangString, localJSONObject);
        return;
      }
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_JavaLangString, localException.getMessage());
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] read file face.json error!", localException);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$6.jdField_a_of_type_JavaLangString, "file face.json is empty!");
    QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] file face.json is empty!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.6.1
 * JD-Core Version:    0.7.0.1
 */