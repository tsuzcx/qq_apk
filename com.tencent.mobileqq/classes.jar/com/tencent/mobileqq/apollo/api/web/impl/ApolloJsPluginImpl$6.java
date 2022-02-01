package com.tencent.mobileqq.apollo.api.web.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

class ApolloJsPluginImpl$6
  implements IApolloResManager.ApolloDressInfoListener
{
  ApolloJsPluginImpl$6(ApolloJsPluginImpl paramApolloJsPluginImpl, String paramString, int paramInt) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] onGetApolloDressInfo: " + paramHashMap + ", errMsg: " + paramString);
    if (paramHashMap == null)
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] onGetApolloDressInfo apolloDressInfo is null! ");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, "apolloDressInfo is null");
      return;
    }
    paramHashMap = (String)paramHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (TextUtils.isEmpty(paramHashMap))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] dressPath is empty!");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ApolloJsPluginImpl.6.1(this, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.6
 * JD-Core Version:    0.7.0.1
 */