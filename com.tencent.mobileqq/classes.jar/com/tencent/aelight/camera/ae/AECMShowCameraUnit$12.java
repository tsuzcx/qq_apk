package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import java.util.HashMap;

class AECMShowCameraUnit$12
  implements Runnable
{
  AECMShowCameraUnit$12(AECMShowCameraUnit paramAECMShowCameraUnit, CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void run()
  {
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.putAll(this.a.namePathMap);
    localCmShowAssetsData.jdField_a_of_type_JavaLangString = this.a.rolePath;
    localCmShowAssetsData.b = this.a.cmJsonString;
    localCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.put("role", localCmShowAssetsData.jdField_a_of_type_JavaLangString);
    this.this$0.a.queueEvent(new AECMShowCameraUnit.12.1(this, localCmShowAssetsData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.12
 * JD-Core Version:    0.7.0.1
 */