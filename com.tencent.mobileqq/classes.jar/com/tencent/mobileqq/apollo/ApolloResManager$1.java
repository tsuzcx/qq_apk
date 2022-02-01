package com.tencent.mobileqq.apollo;

import amme;
import amof;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class ApolloResManager$1
  implements Runnable
{
  ApolloResManager$1(ApolloResManager paramApolloResManager, QQAppInterface paramQQAppInterface, String paramString, amof paramamof) {}
  
  public void run()
  {
    amme localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((!TextUtils.isEmpty(str)) && (str.equals(this.jdField_a_of_type_JavaLangString)) && (localamme != null))
    {
      ApolloBaseInfo localApolloBaseInfo = localamme.b(this.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder().append("getApolloDressInfo sync : ");
      if (localApolloBaseInfo == null) {}
      for (str = null;; str = localApolloBaseInfo.toString())
      {
        QLog.d("cm_res", 1, str);
        if ((localApolloBaseInfo == null) || (!ApolloResManager.a(this.this$0, localamme, localApolloBaseInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Amof, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false))) {
          break;
        }
        return;
      }
    }
    if (localVasExtensionHandler == null)
    {
      this.jdField_a_of_type_Amof.a(null, "VasExtensionHandler is null", -5004);
      return;
    }
    if (ApolloResManager.a(this.this$0) != null) {
      localVasExtensionHandler.b(ApolloResManager.a(this.this$0));
    }
    ApolloResManager.a(this.this$0, ApolloResManager.a(this.this$0, localamme, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Amof, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    localVasExtensionHandler.a(ApolloResManager.a(this.this$0));
    localVasExtensionHandler.b(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloResManager.1
 * JD-Core Version:    0.7.0.1
 */