package com.tencent.mobileqq.ar.ARRenderModel;

import albc;
import android.graphics.SurfaceTexture;

public class OnlineVideoARRenderable$3
  implements Runnable
{
  public OnlineVideoARRenderable$3(albc paramalbc) {}
  
  public void run()
  {
    if (albc.a(this.this$0)) {}
    try
    {
      albc.a(this.this$0).updateTexImage();
      albc.a(this.this$0).getTransformMatrix(albc.a(this.this$0));
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