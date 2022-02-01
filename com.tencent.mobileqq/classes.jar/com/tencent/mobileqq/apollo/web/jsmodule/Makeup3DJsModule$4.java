package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ipc.business.ICm3DMakeup.Save3DFaceListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import org.json.JSONException;
import org.json.JSONObject;

class Makeup3DJsModule$4
  implements ICm3DMakeup.Save3DFaceListener
{
  Makeup3DJsModule$4(Makeup3DJsModule paramMakeup3DJsModule, String paramString) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_JavaLangString, "get faceUrl failed");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_JavaLangString, "get faceUrl is empty");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      boolean bool = QzoneConfig.getInstance().getConfig("CMShow", "CMShow3DFaceUrlReplace", true);
      String str1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShow3DFaceCosHost", "3dcmshow-75972.gzc.vod.tencent-cloud.com");
      String str2 = QzoneConfig.getInstance().getConfig("CMShow", "CMShow3DFaceCdnHost", "3dcmshow.gtimg.cn");
      if ((bool) && (paramString.contains(str1))) {
        localJSONObject.put(ApolloConstant.e, paramString.replace(str1, str2));
      } else {
        localJSONObject.put(ApolloConstant.e, paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_JavaLangString, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_JavaLangString, "get faceUrl failed");
      QLog.e("[cmshow]Makeup3DJsModule", 1, new Object[] { "save3DFaceData json parser error", paramString.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.4
 * JD-Core Version:    0.7.0.1
 */