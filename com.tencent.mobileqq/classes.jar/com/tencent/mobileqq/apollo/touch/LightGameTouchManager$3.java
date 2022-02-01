package com.tencent.mobileqq.apollo.touch;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

class LightGameTouchManager$3
  extends IApolloRunnableTask
{
  LightGameTouchManager$3(LightGameTouchManager paramLightGameTouchManager, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    try
    {
      ApolloSurfaceView.nativeTouchInput(LightGameTouchManager.a(this.this$0).getSavaWrapper().mDirector, this.a, this.b, this.c, this.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send touch event err e=");
      localStringBuilder.append(localThrowable.toString());
      QLog.e("[cmshow]LightGameTouchManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.touch.LightGameTouchManager.3
 * JD-Core Version:    0.7.0.1
 */