package com.tencent.aelight.camera.ae;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$59
  implements Observer<Boolean>
{
  AEPituCameraUnit$59(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(Boolean paramBoolean)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AiBeautyToggle---onChanged: ");
    localStringBuilder.append(paramBoolean);
    AEQLog.b(str, localStringBuilder.toString());
    if (paramBoolean != null)
    {
      AECameraPrefsUtil.a().a("sp_key_ae_camera_auto_beauty_switch", paramBoolean.booleanValue(), 0);
      this.a.h.switchAIBeauty(paramBoolean.booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.59
 * JD-Core Version:    0.7.0.1
 */