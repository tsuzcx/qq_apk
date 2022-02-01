package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

class NormalVideoARRenderable$3
  implements Runnable
{
  NormalVideoARRenderable$3(NormalVideoARRenderable paramNormalVideoARRenderable) {}
  
  @TargetApi(11)
  public void run()
  {
    try
    {
      NormalVideoARRenderable.a(this.this$0).updateTexImage();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        localThrowable.printStackTrace();
      }
    }
    NormalVideoARRenderable.a(this.this$0).getTransformMatrix(NormalVideoARRenderable.a(this.this$0));
    if (ScanTorchActivity.b)
    {
      Object localObject = this.this$0;
      ((NormalVideoARRenderable)localObject).b += 1L;
      if (this.this$0.b >= 30L)
      {
        this.this$0.b = 0L;
        long l = System.currentTimeMillis();
        float f = 30000.0F / (float)(l - this.this$0.a);
        this.this$0.a = l;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("video fetch=");
        ((StringBuilder)localObject).append(f);
        QLog.d("render", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable.3
 * JD-Core Version:    0.7.0.1
 */