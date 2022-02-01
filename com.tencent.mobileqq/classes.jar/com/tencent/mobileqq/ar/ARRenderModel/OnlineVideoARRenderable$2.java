package com.tencent.mobileqq.ar.ARRenderModel;

import android.graphics.SurfaceTexture;

class OnlineVideoARRenderable$2
  implements Runnable
{
  OnlineVideoARRenderable$2(OnlineVideoARRenderable paramOnlineVideoARRenderable) {}
  
  public void run()
  {
    if (OnlineVideoARRenderable.a(this.this$0)) {}
    try
    {
      OnlineVideoARRenderable.a(this.this$0).updateTexImage();
      OnlineVideoARRenderable.a(this.this$0).getTransformMatrix(OnlineVideoARRenderable.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.2
 * JD-Core Version:    0.7.0.1
 */