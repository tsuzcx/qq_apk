package com.tencent.mobileqq.apollo.api.web.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.utils.ApolloResUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class ApolloJsPluginImpl$8$2
  implements Runnable
{
  ApolloJsPluginImpl$8$2(ApolloJsPluginImpl.8 param8, HashMap paramHashMap) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        int i = ((Integer)((Iterator)localObject1).next()).intValue();
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject2 = ApolloResUtil.a((String)localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] fileJsonFilePath is null!");
          this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_JavaLangString, "file face.json is not exists!");
          return;
        }
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists()) {
          break label246;
        }
        localObject2 = FileUtils.b((File)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ApolloUtilImpl.mergeJSON(localJSONObject, new JSONObject((String)localObject2));
          continue;
        }
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] file face.json is empty!");
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_JavaLangString, localException.getMessage());
        ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, false, localException.getMessage());
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] read file face.json error!", localException);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_JavaLangString, "file face.json is empty!");
      ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, false, "file face.json is empty!");
      return;
      label246:
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] file face.json is not exists!");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_JavaLangString, "file face.json is not exists!");
    }
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put(ApolloConstant.b, localException);
    IApolloJsCallBack localIApolloJsCallBack = ApolloJsPluginImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
    if (localIApolloJsCallBack != null)
    {
      localObject2 = new CmShowAssetsData();
      ((CmShowAssetsData)localObject2).b = ((JSONObject)localObject1).toString();
      localIApolloJsCallBack.a((CmShowAssetsData)localObject2, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackOk(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_JavaLangString);
    ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, true, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.8.2
 * JD-Core Version:    0.7.0.1
 */