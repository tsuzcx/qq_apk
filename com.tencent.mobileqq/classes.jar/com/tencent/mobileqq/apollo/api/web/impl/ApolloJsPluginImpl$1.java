package com.tencent.mobileqq.apollo.api.web.impl;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ApolloJsPluginImpl$1
  implements QQPermissionCallback
{
  ApolloJsPluginImpl$1(ApolloJsPluginImpl paramApolloJsPluginImpl) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (ApolloJsPluginImpl.access$000(this.a) != null) {
      DialogUtil.a(ApolloJsPluginImpl.access$000(this.a), paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("ApolloJsPlugin", 1, "[startRecord] grant");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.1
 * JD-Core Version:    0.7.0.1
 */