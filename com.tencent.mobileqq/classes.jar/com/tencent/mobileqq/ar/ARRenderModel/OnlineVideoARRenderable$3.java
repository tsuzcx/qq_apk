package com.tencent.mobileqq.ar.ARRenderModel;

import amwh;
import android.graphics.SurfaceTexture;

public class OnlineVideoARRenderable$3
  implements Runnable
{
  public OnlineVideoARRenderable$3(amwh paramamwh) {}
  
  public void run()
  {
    if (amwh.a(this.this$0)) {}
    try
    {
      amwh.a(this.this$0).updateTexImage();
      amwh.a(this.this$0).getTransformMatrix(amwh.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.3
 * JD-Core Version:    0.7.0.1
 */