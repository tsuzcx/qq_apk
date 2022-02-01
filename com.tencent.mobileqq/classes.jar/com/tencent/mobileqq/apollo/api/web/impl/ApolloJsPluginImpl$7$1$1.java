package com.tencent.mobileqq.apollo.api.web.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloResUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloJsPluginImpl$7$1$1
  implements Runnable
{
  ApolloJsPluginImpl$7$1$1(ApolloJsPluginImpl.7.1 param1) {}
  
  public void run()
  {
    Object localObject = ApolloResUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] fileJsonFilePath is null!");
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.b, "file face.json is not exists!");
      return;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists())
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] file face.json is not exists!");
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.b, "file face.json is not exists!");
      return;
    }
    try
    {
      localObject = FileUtils.b((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.b, "file face.json is empty!");
        return;
      }
    }
    catch (Exception localException)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.b, localException.getMessage());
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] read file face.json error!", localException);
      return;
    }
    IApolloJsCallBack localIApolloJsCallBack = ApolloJsPluginImpl.access$300(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
    if (localIApolloJsCallBack == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.b, "no apolloJsCallBack to handle this event!");
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] no apolloJsCallBack to handle this event!");
      return;
    }
    this.a.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData.b = localException;
    localIApolloJsCallBack.a(this.a.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData, 3);
    this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackOk(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$7.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.7.1.1
 * JD-Core Version:    0.7.0.1
 */