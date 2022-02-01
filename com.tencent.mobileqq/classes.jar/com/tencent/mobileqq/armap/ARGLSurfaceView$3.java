package com.tencent.mobileqq.armap;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;

class ARGLSurfaceView$3
  extends OrientationEventListener
{
  ARGLSurfaceView$3(ARGLSurfaceView paramARGLSurfaceView, Context paramContext, Activity paramActivity)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt != -1)
    {
      paramInt = ((WindowManager)this.val$activity.getSystemService("window")).getDefaultDisplay().getRotation();
      this.this$0.queueEvent(new ARGLSurfaceView.3.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */