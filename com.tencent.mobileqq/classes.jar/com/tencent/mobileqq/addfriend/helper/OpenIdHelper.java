package com.tencent.mobileqq.addfriend.helper;

import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.friend.listeners.OnOpenIdGetListener;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;

public class OpenIdHelper
{
  private static OpenIdHelper jdField_a_of_type_ComTencentMobileqqAddfriendHelperOpenIdHelper;
  MessageCache jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  private OpenIdHelper(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache = new MessageCache(paramAppRuntime);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public static OpenIdHelper a(AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_ComTencentMobileqqAddfriendHelperOpenIdHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqAddfriendHelperOpenIdHelper == null) {
          jdField_a_of_type_ComTencentMobileqqAddfriendHelperOpenIdHelper = new OpenIdHelper(paramAppRuntime);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqAddfriendHelperOpenIdHelper;
  }
  
  public OpenID a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString);
  }
  
  public void a(String paramString, OnOpenIdGetListener paramOnOpenIdGetListener)
  {
    if (a(paramString) != null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get openid key = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("openid", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0);
    HashMap localHashMap = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    localHashMap.put("RequestCustomSig", localRequestCustomSig);
    localHashMap.put("OpenAppid", paramString);
    ((AccountManager)localObject).changeToken(localHashMap, new OpenIdHelper.1(this, paramString, paramOnOpenIdGetListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.helper.OpenIdHelper
 * JD-Core Version:    0.7.0.1
 */