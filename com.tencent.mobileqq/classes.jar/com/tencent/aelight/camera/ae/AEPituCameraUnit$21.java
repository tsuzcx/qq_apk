package com.tencent.aelight.camera.ae;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$21
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  AEPituCameraUnit$21(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    String str = this.a.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCurrentRatio---onChanged: ratio=");
    localStringBuilder.append(paramRatio);
    AEQLog.b(str, localStringBuilder.toString());
    if (paramRatio == null) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == paramRatio) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
    AECameraPrefsUtil.a().a("sp_key_ae_camera_ratio", paramRatio.code, 0);
    if (this.a.b == AECaptureMode.NORMAL)
    {
      this.a.k();
      this.a.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.21
 * JD-Core Version:    0.7.0.1
 */