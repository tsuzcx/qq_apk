package com.tencent.mobileqq.ar.ARRenderModel;

import akmr;
import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class OnlineVideoARRenderable$5
  implements Runnable
{
  public OnlineVideoARRenderable$5(akmr paramakmr, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void run()
  {
    if (akmr.f(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { akmr.f(this.this$0) }, 0);
    }
    if (akmr.g(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { akmr.g(this.this$0) }, 0);
    }
    if (akmr.h(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { akmr.h(this.this$0) }, 0);
    }
    try
    {
      akmr.b(this.this$0, akmr.a(this.this$0, 1, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      akmr.c(this.this$0, akmr.a(this.this$0, 2, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      akmr.d(this.this$0, akmr.a(this.this$0, 3, this.c, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      akmr.b(this.this$0, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 2, "drawFrame_soft exception=" + localException.getMessage());
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.5
 * JD-Core Version:    0.7.0.1
 */