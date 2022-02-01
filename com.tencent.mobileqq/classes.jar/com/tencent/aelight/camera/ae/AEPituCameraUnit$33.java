package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.qphone.base.util.QLog;

class AEPituCameraUnit$33
  implements Runnable
{
  AEPituCameraUnit$33(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "onResourceDownload update filterpager begin");
    }
    FilterPagerViewStubHolder localFilterPagerViewStubHolder = this.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder;
    boolean bool;
    if (this.this$0.b == AECaptureMode.NORMAL) {
      bool = true;
    } else {
      bool = false;
    }
    localFilterPagerViewStubHolder.d(bool);
    ((AEMaterialManager)AEQIMManager.a(1)).b(false);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "onResourceDownload update filterpager end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.33
 * JD-Core Version:    0.7.0.1
 */