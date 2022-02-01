package com.tencent.aelight.camera.ae;

import android.graphics.SurfaceTexture;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$8
  implements AECameraGLSurfaceView.AEGLSurfaceListener
{
  AEPituCameraUnit$8(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onDrawFrameWithEffect(int paramInt, AEFilterManager paramAEFilterManager)
  {
    this.a.a(paramInt, paramAEFilterManager);
  }
  
  public void onFirstFrameDone()
  {
    AELaunchRecorder.d().a("onFirstFrameDone");
    this.a.S();
  }
  
  public void onOrientionChanged(int paramInt)
  {
    this.a.d.setActivityOrientation(paramInt);
  }
  
  public void onPreviewSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.d.setFocusOperatorMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onPreviewSurfaceTextureCreate(SurfaceTexture paramSurfaceTexture)
  {
    Object localObject = this.a;
    ((AEPituCameraUnit)localObject).l = paramSurfaceTexture;
    paramSurfaceTexture = ((AEPituCameraUnit)localObject).a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPreviewSurfaceTextureCreate---");
    ((StringBuilder)localObject).append(this.a.l);
    AEQLog.b(paramSurfaceTexture, ((StringBuilder)localObject).toString());
    this.a.A();
  }
  
  public void onPreviewSurfaceTextureRelease()
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPreviewSurfaceTextureRelease---");
    localStringBuilder.append(this.a.l);
    AEQLog.b(str, localStringBuilder.toString());
    this.a.l = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.8
 * JD-Core Version:    0.7.0.1
 */