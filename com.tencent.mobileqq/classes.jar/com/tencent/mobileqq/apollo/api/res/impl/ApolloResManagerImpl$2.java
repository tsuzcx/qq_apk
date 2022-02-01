package com.tencent.mobileqq.apollo.api.res.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl.OnQueryBaseInfoListener;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ApolloResManagerImpl$2
  implements ApolloExtensionHandlerImpl.OnQueryBaseInfoListener
{
  ApolloResManagerImpl$2(ApolloResManagerImpl paramApolloResManagerImpl, String paramString, QQAppInterface paramQQAppInterface, IApolloManagerService paramIApolloManagerService, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public boolean a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("getApolloDressInfo onGetBaseInfo : ");
    if (paramApolloBaseInfo == null) {}
    for (String str = null;; str = paramApolloBaseInfo.toString())
    {
      QLog.d("cm_res", 1, str);
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.jdField_a_of_type_JavaLangString))) {
        break;
      }
      ApolloResManagerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService, this.jdField_a_of_type_JavaLangString, paramApolloBaseInfo, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$ApolloUserDressInfoListener);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("getApolloDressInfo onDressUpdated : ");
    Object localObject1;
    if (paramApolloBaseInfo == null)
    {
      localObject1 = null;
      QLog.d("cm_res", 1, (String)localObject1);
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.jdField_a_of_type_JavaLangString))) {
        break label163;
      }
      paramString = paramApolloBaseInfo;
      if (paramApolloBaseInfo == null)
      {
        paramString = paramApolloBaseInfo;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService != null)
        {
          paramApolloBaseInfo = this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService.getApolloBaseInfo(this.jdField_a_of_type_JavaLangString);
          localObject1 = new StringBuilder().append("getApolloDressInfo onDressUpdated getApolloBaseInfo : ");
          if (paramApolloBaseInfo != null) {
            break label155;
          }
        }
      }
    }
    label155:
    for (paramString = localObject2;; paramString = paramApolloBaseInfo.toString())
    {
      QLog.d("cm_res", 1, paramString);
      paramString = paramApolloBaseInfo;
      ApolloResManagerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService, this.jdField_a_of_type_JavaLangString, paramString, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$ApolloUserDressInfoListener);
      return true;
      localObject1 = paramApolloBaseInfo.toString();
      break;
    }
    label163:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */