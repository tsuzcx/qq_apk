package com.tencent.mobileqq.armap;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class ARGLSurfaceView$2
  implements Runnable
{
  ARGLSurfaceView$2(ARGLSurfaceView paramARGLSurfaceView, Activity paramActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      ARGLSurfaceView.nativeSetLogLevel(4);
    } else if (QLog.isColorLevel()) {
      ARGLSurfaceView.nativeSetLogLevel(2);
    } else {
      ARGLSurfaceView.nativeSetLogLevel(1);
    }
    ARGLSurfaceView localARGLSurfaceView = this.this$0;
    Activity localActivity = this.val$activity;
    localARGLSurfaceView.mEngineHandler = ARGLSurfaceView.access$400(localARGLSurfaceView, localActivity, localActivity.getAssets(), this.val$resPath, this.val$code);
    if (ARGLSurfaceView.access$100(this.this$0) != null) {
      ARGLSurfaceView.access$100(this.this$0).onInit(this.this$0.mEngineHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */