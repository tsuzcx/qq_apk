package com.tencent.mobileqq.ar.ARRenderModel;

import akmr;
import android.graphics.SurfaceTexture;

public class OnlineVideoARRenderable$3
  implements Runnable
{
  public OnlineVideoARRenderable$3(akmr paramakmr) {}
  
  public void run()
  {
    if (akmr.a(this.this$0)) {}
    try
    {
      akmr.a(this.this$0).updateTexImage();
      akmr.a(this.this$0).getTransformMatrix(akmr.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.3
 * JD-Core Version:    0.7.0.1
 */