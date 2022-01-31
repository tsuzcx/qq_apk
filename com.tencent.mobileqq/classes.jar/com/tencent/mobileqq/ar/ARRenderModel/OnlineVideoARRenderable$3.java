package com.tencent.mobileqq.ar.ARRenderModel;

import albd;
import android.graphics.SurfaceTexture;

public class OnlineVideoARRenderable$3
  implements Runnable
{
  public OnlineVideoARRenderable$3(albd paramalbd) {}
  
  public void run()
  {
    if (albd.a(this.this$0)) {}
    try
    {
      albd.a(this.this$0).updateTexImage();
      albd.a(this.this$0).getTransformMatrix(albd.a(this.this$0));
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