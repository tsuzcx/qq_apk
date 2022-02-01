package com.tencent.aelight.camera.ae.camera.core;

import android.content.Context;
import com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase;
import com.tencent.aelight.camera.ae.camera.util.AEOrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class AECameraGLSurfaceView$15
  extends AEOrientationEventListener
{
  AECameraGLSurfaceView$15(AECameraGLSurfaceView paramAECameraGLSurfaceView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    AECameraGLSurfaceView.access$1302(this.this$0, paramInt);
    if (AECameraGLSurfaceView.access$1400(this.this$0) != null) {
      AECameraGLSurfaceView.access$1400(this.this$0).onOrientionChanged(paramInt);
    }
    int k = 90;
    int j;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AECameraGLSurfaceView", 2, "OrientationEventListener unknown");
      }
      j = 90;
    }
    else
    {
      j = 0;
    }
    int i = k;
    if (paramInt <= 315) {
      if (paramInt < 45) {
        i = k;
      } else if ((paramInt > 45) && (paramInt < 135)) {
        i = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        i = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        i = 0;
      } else {
        i = j;
      }
    }
    AECameraGLSurfaceView.access$1002(this.this$0, i);
  }
  
  public void onPoseChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (AECameraGLSurfaceView.access$000(this.this$0) != null) {
      AECameraGLSurfaceView.access$000(this.this$0).a(paramFloat3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.15
 * JD-Core Version:    0.7.0.1
 */