package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.web.IApolloJsCallBack;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class Makeup3DJsModule$1$1$1
  implements Runnable
{
  Makeup3DJsModule$1$1$1(Makeup3DJsModule.1.1 param1) {}
  
  public void run()
  {
    Object localObject = CMGetResPathUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] fileJsonFilePath is null!");
      this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.b, "file face.json is not exists!");
      return;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists())
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] file face.json is not exists!");
      this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.b, "file face.json is not exists!");
      return;
    }
    try
    {
      localObject = FileUtils.readFileToString((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.b, "file face.json is empty!");
        return;
      }
      IApolloJsCallBack localIApolloJsCallBack = Makeup3DJsModule.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule);
      if (localIApolloJsCallBack == null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.b, "no apolloJsCallBack to handle this event!");
        QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] no apolloJsCallBack to handle this event!");
        return;
      }
      this.a.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData.b = ((String)localObject);
      localIApolloJsCallBack.a(this.a.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData, 3);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.b);
      return;
    }
    catch (Exception localException)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebJsmoduleMakeup3DJsModule$1.b, localException.getMessage());
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] read file face.json error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.1.1.1
 * JD-Core Version:    0.7.0.1
 */