package com.tencent.mobileqq.apollo.web.api.impl;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ApolloJsPluginImpl$2
  implements QQPermissionCallback
{
  ApolloJsPluginImpl$2(ApolloJsPluginImpl paramApolloJsPluginImpl) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (ApolloJsPluginImpl.access$100(this.a) != null) {
      DialogUtil.a(ApolloJsPluginImpl.access$100(this.a), paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("[cmshow]ApolloJsPlugin", 1, "[startRecord] grant");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.2
 * JD-Core Version:    0.7.0.1
 */