package com.tencent.mobileqq.ar.ARRenderModel;

import android.graphics.SurfaceTexture;
import apfd;

public class OnlineVideoARRenderable$2
  implements Runnable
{
  public OnlineVideoARRenderable$2(apfd paramapfd) {}
  
  public void run()
  {
    if (apfd.a(this.this$0)) {}
    try
    {
      apfd.a(this.this$0).updateTexImage();
      apfd.a(this.this$0).getTransformMatrix(apfd.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.2
 * JD-Core Version:    0.7.0.1
 */