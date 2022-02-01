package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

class AECMShowRequestController$4
  implements IApolloResManager.ApolloDressInfoListener
{
  AECMShowRequestController$4(AECMShowRequestController paramAECMShowRequestController, HashMap paramHashMap, List paramList, int paramInt, String paramString) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestCmJoyDressInfo], apolloDressInfo=");
    localStringBuilder.append(paramHashMap);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    AEQLog.a("AECMShowRequestController", localStringBuilder.toString());
    if (paramHashMap != null)
    {
      paramHashMap = AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController, this.jdField_a_of_type_JavaUtilHashMap, paramHashMap);
      paramString = AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController, this.jdField_a_of_type_JavaUtilList);
      AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController, this.jdField_a_of_type_Int, paramHashMap, this.jdField_a_of_type_JavaLangString, paramString);
      return;
    }
    if (AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController) != null) {
      ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController));
    }
    if (AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController) != null) {
      AECMShowRequestController.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController).a(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.4
 * JD-Core Version:    0.7.0.1
 */