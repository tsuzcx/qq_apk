package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class Makeup3DJsModule$3$1
  implements Runnable
{
  Makeup3DJsModule$3$1(Makeup3DJsModule.3 param3, String paramString) {}
  
  public void run()
  {
    Object localObject = CMGetResPathUtil.a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] fileJsonFilePath is null!");
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_JavaLangString, "file face.json is not exists!");
      return;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists())
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] file face.json is not exists!");
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_JavaLangString, "file face.json is not exists!");
      return;
    }
    try
    {
      localObject = FileUtils.readFileToString((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put(ApolloConstant.b, new JSONObject((String)localObject));
        this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_JavaLangString, localJSONObject);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_JavaLangString, "file face.json is empty!");
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] file face.json is empty!");
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$3.jdField_a_of_type_JavaLangString, localException.getMessage());
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] read file face.json error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.3.1
 * JD-Core Version:    0.7.0.1
 */