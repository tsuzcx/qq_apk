package com.tencent.mobileqq.apollo.touch;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;

class LightGameTouchManager$2
  extends IApolloRunnableTask
{
  LightGameTouchManager$2(LightGameTouchManager paramLightGameTouchManager, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    ApolloSurfaceView.nativeTouchInput(LightGameTouchManager.a(this.this$0).getSavaWrapper().mDirector, this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.touch.LightGameTouchManager.2
 * JD-Core Version:    0.7.0.1
 */