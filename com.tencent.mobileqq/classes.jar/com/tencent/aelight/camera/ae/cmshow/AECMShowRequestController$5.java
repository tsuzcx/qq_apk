package com.tencent.aelight.camera.ae.cmshow;

import android.text.TextUtils;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

class AECMShowRequestController$5
  implements IApolloResManager.ApolloRoleInfoListener
{
  AECMShowRequestController$5(AECMShowRequestController paramAECMShowRequestController, HashMap paramHashMap, Map paramMap, String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestCmJoyRoleInfo], roleDir=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString2);
    AEQLog.a("AECMShowRequestController", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1))
    {
      if (AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController) != null) {
        ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController));
      }
      if (AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController) != null)
      {
        AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController, 100);
        AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController).b(AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController));
        paramString2 = new CmShowDataWrapper();
        paramString2.sceneMode = AECMShowRequestController.b(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController);
        paramString2.namePathMap = this.jdField_a_of_type_JavaUtilHashMap;
        paramString2.rolePath = paramString1;
        paramString2.dressidMaps = this.jdField_a_of_type_JavaUtilMap;
        paramString2.cmJsonString = this.jdField_a_of_type_JavaLangString;
        AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController).a(1, paramString2);
      }
    }
    else
    {
      if (AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController) != null) {
        ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController));
      }
      if (AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController) != null) {
        AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController).a(2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.5
 * JD-Core Version:    0.7.0.1
 */