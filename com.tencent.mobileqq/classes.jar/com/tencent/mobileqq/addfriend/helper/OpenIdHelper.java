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
  private static OpenIdHelper c;
  MessageCache a;
  AppRuntime b;
  
  private OpenIdHelper(AppRuntime paramAppRuntime)
  {
    this.a = new MessageCache(paramAppRuntime);
    this.b = paramAppRuntime;
  }
  
  public static OpenIdHelper a(AppRuntime paramAppRuntime)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new OpenIdHelper(paramAppRuntime);
        }
      }
      finally {}
    }
    return c;
  }
  
  public OpenID a(String paramString)
  {
    return this.a.T(paramString);
  }
  
  public void a(String paramString, OpenID paramOpenID)
  {
    this.a.a(paramString, paramOpenID);
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
    Object localObject = (AccountManager)this.b.getManager(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.helper.OpenIdHelper
 * JD-Core Version:    0.7.0.1
 */