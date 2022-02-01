package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import apil;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class NormalVideoARRenderable$3
  implements Runnable
{
  public NormalVideoARRenderable$3(apil paramapil) {}
  
  @TargetApi(11)
  public void run()
  {
    try
    {
      apil.a(this.this$0).updateTexImage();
      apil.a(this.this$0).getTransformMatrix(apil.a(this.this$0));
      if (ScanTorchActivity.h)
      {
        apil localapil = this.this$0;
        localapil.b += 1L;
        if (this.this$0.b >= 30L)
        {
          this.this$0.b = 0L;
          long l = System.currentTimeMillis();
          float f = 30000.0F / (float)(l - this.this$0.a);
          this.this$0.a = l;
          QLog.d("render", 2, "video fetch=" + f);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable.3
 * JD-Core Version:    0.7.0.1
 */