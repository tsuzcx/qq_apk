package com.tencent.aelight.camera.ae;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qqlive.module.videoreport.VideoReport;

class AEPituCameraUnit$24
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  AEPituCameraUnit$24(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" mCurrentRatio---onChanged: ratio=");
    localStringBuilder.append(paramRatio);
    AEQLog.b(str, localStringBuilder.toString());
    if (paramRatio == null) {
      return;
    }
    VideoReport.setPageParams(this.a.s(), "ae_ratio", paramRatio.toString());
    if (this.a.w == paramRatio) {
      return;
    }
    this.a.w = paramRatio;
    AECameraPrefsUtil.a().a("sp_key_ae_camera_ratio", paramRatio.code, 0);
    this.a.h.setCurrentRatio(paramRatio);
    if (this.a.x == AECaptureMode.NORMAL)
    {
      this.a.z();
      this.a.A();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.24
 * JD-Core Version:    0.7.0.1
 */