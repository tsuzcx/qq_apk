package com.tencent.mobileqq.apollo.api.web.impl;

import com.tencent.mobileqq.apollo.ApolloClientQIPCModule;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ApolloJsPluginImpl$7
  implements IApolloResManager.ApolloDressInfoListener
{
  ApolloJsPluginImpl$7(ApolloJsPluginImpl paramApolloJsPluginImpl, Map paramMap, String paramString1, String paramString2) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    QLog.i("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] onGetApolloDressInfo: " + paramHashMap + ", errMsg: " + paramString);
    paramString = new CmShowAssetsData();
    if (paramHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramString.a.put(localEntry.getValue(), paramHashMap.get(localEntry.getKey()));
      }
    }
    ApolloClientQIPCModule.a(this.jdField_a_of_type_JavaLangString, new ApolloJsPluginImpl.7.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.7
 * JD-Core Version:    0.7.0.1
 */