package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

class OnlineVideoARRenderable$4
  implements Runnable
{
  public void run()
  {
    if (OnlineVideoARRenderable.i(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { OnlineVideoARRenderable.i(this.this$0) }, 0);
    }
    if (OnlineVideoARRenderable.j(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { OnlineVideoARRenderable.j(this.this$0) }, 0);
    }
    if (OnlineVideoARRenderable.k(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { OnlineVideoARRenderable.k(this.this$0) }, 0);
    }
    try
    {
      OnlineVideoARRenderable.b(this.this$0, OnlineVideoARRenderable.a(this.this$0, 1, this.a, this.b, this.c));
      OnlineVideoARRenderable.c(this.this$0, OnlineVideoARRenderable.a(this.this$0, 2, this.d, this.b / 2, (this.c + 1) / 2));
      OnlineVideoARRenderable.d(this.this$0, OnlineVideoARRenderable.a(this.this$0, 3, this.e, this.b / 2, (this.c + 1) / 2));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("drawFrame_soft exception=");
        localStringBuilder.append(localException.getMessage());
        QLog.d("AREngine_OnlineVideoARRenderable", 2, localStringBuilder.toString());
        localException.printStackTrace();
      }
    }
    OnlineVideoARRenderable.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.4
 * JD-Core Version:    0.7.0.1
 */