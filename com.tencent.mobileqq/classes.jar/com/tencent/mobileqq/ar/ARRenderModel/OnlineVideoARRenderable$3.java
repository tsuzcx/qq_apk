package com.tencent.mobileqq.ar.ARRenderModel;

import amrs;
import android.graphics.SurfaceTexture;

public class OnlineVideoARRenderable$3
  implements Runnable
{
  public OnlineVideoARRenderable$3(amrs paramamrs) {}
  
  public void run()
  {
    if (amrs.a(this.this$0)) {}
    try
    {
      amrs.a(this.this$0).updateTexImage();
      amrs.a(this.this$0).getTransformMatrix(amrs.a(this.this$0));
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