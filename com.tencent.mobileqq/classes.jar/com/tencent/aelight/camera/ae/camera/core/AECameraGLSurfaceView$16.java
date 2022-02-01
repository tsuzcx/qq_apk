package com.tencent.aelight.camera.ae.camera.core;

import android.content.Context;
import com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase;
import com.tencent.aelight.camera.ae.camera.util.AEOrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class AECameraGLSurfaceView$16
  extends AEOrientationEventListener
{
  AECameraGLSurfaceView$16(AECameraGLSurfaceView paramAECameraGLSurfaceView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    AECameraGLSurfaceView.access$1302(this.this$0, paramInt);
    if (AECameraGLSurfaceView.access$1400(this.this$0) != null) {
      AECameraGLSurfaceView.access$1400(this.this$0).onOrientionChanged(paramInt);
    }
    int j = 0;
    int i;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AECameraGLSurfaceView", 2, "OrientationEventListener unknown");
      }
      i = 90;
    }
    else
    {
      i = 0;
    }
    if ((paramInt <= 315) && (paramInt >= 45))
    {
      if ((paramInt > 45) && (paramInt < 135)) {
        paramInt = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        paramInt = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        paramInt = j;
      } else {
        paramInt = i;
      }
    }
    else {
      paramInt = 90;
    }
    if (AECameraGLSurfaceView.access$1500(this.this$0))
    {
      AECameraGLSurfaceView.access$1002(this.this$0, 90);
      return;
    }
    AECameraGLSurfaceView.access$1002(this.this$0, paramInt);
  }
  
  public void onPoseChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (AECameraGLSurfaceView.access$000(this.this$0) != null) {
      AECameraGLSurfaceView.access$000(this.this$0).a(paramFloat3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.16
 * JD-Core Version:    0.7.0.1
 */