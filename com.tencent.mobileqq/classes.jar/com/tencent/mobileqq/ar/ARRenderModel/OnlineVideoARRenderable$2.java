package com.tencent.mobileqq.ar.ARRenderModel;

import android.graphics.SurfaceTexture;
import aocb;

public class OnlineVideoARRenderable$2
  implements Runnable
{
  public OnlineVideoARRenderable$2(aocb paramaocb) {}
  
  public void run()
  {
    if (aocb.a(this.this$0)) {}
    try
    {
      aocb.a(this.this$0).updateTexImage();
      aocb.a(this.this$0).getTransformMatrix(aocb.a(this.this$0));
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