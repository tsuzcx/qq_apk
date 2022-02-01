package com.tencent.aelight.camera.ae;

import android.os.Handler;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEPituCameraUnit$1
  implements AECameraManager.CameraManagerListener
{
  AEPituCameraUnit$1(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onCameraPreviewSizeChanged(int paramInt1, int paramInt2)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCameraPreviewSizeChanged---width=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height=");
    localStringBuilder.append(paramInt2);
    AEQLog.b(str, localStringBuilder.toString());
    if (this.a.h != null) {
      this.a.h.onCameraPreviewSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onCameraPreviewStarted()
  {
    if (this.a.h != null) {
      this.a.h.onCameraPreviewStarted();
    }
  }
  
  public void onCameraStarted(boolean paramBoolean, String paramString)
  {
    Object localObject = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCameraStarted--success=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    this.a.a(paramBoolean, paramString);
    if (paramBoolean) {
      AELaunchRecorder.d().a("onCameraStart");
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.1.1(this));
    } else if (this.a.f != null) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.1.2(this));
    }
    if ((this.a.Y()) && (AEPituCameraUnit.a(this.a) != null))
    {
      AEPituCameraUnit.b(this.a);
      paramBoolean = AECameraPrefsUtil.a().b("sp_key_ae_camera_auto_beauty_switch", true, 0);
      AEPituCameraUnit.a(this.a).a(paramBoolean);
      paramString = this.a.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toggleAiBeauty on camera start: ");
      ((StringBuilder)localObject).append(paramBoolean);
      AEQLog.b(paramString, ((StringBuilder)localObject).toString());
    }
    else
    {
      int i = AEBeautyProviderView.getBeautyFeature();
      int j = AEBeautyProviderView.getSharpFaceFeature();
      this.a.R.a(i);
      this.a.R.b(j);
    }
    this.a.S.b(458753, new Object[0]);
  }
  
  public void onRetryOpenCamera()
  {
    AEQLog.b(this.a.a, "onRetryOpenCamera|OpenCamera Error.need retry!");
    this.a.D.post(new AEPituCameraUnit.1.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */