package com.tencent.mobileqq.apollo.api.web.impl;

import android.app.Activity;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class ApolloJsPluginImpl$8
  implements IApolloResManager.ApolloDressInfoListener
{
  ApolloJsPluginImpl$8(ApolloJsPluginImpl paramApolloJsPluginImpl, long paramLong, ArrayList paramArrayList, String paramString, Activity paramActivity, int paramInt, Map paramMap) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("duration", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    ((Map)localObject).put("itemids", this.jdField_a_of_type_JavaUtilArrayList.toString());
    ApolloDtReportUtil.a("dressup_3d_page", "model", "change_dress", (Map)localObject);
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] onGetApolloDressInfo: " + paramHashMap + ", errMsg: " + paramString);
    if (paramHashMap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, paramString);
      ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, false, paramString);
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] dress info is null " + paramString);
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ApolloJsPluginImpl.8.1(this));
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      paramString = new CmShowAssetsData();
      localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramString.a.put(localEntry.getValue(), paramHashMap.get(localEntry.getKey()));
      }
      paramHashMap = ApolloJsPluginImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
      if ((paramHashMap instanceof IApolloJsCallBack))
      {
        ((IApolloJsCallBack)paramHashMap).a(paramString, 2);
        ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, true, "");
        this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackOk(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] no apolloJsCallBack to handle this event!");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, "no apolloJsCallBack to handle this event!");
      ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, false, "no apolloJsCallBack to handle this event!");
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      ThreadManager.getFileThreadHandler().post(new ApolloJsPluginImpl.8.2(this, paramHashMap));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, "invalid param: type");
    ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, false, "invalid param: type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.8
 * JD-Core Version:    0.7.0.1
 */