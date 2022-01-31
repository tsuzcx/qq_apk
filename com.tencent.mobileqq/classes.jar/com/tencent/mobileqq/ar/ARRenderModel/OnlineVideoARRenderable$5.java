package com.tencent.mobileqq.ar.ARRenderModel;

import albd;
import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class OnlineVideoARRenderable$5
  implements Runnable
{
  public OnlineVideoARRenderable$5(albd paramalbd, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void run()
  {
    if (albd.f(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { albd.f(this.this$0) }, 0);
    }
    if (albd.g(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { albd.g(this.this$0) }, 0);
    }
    if (albd.h(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { albd.h(this.this$0) }, 0);
    }
    try
    {
      albd.b(this.this$0, albd.a(this.this$0, 1, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      albd.c(this.this$0, albd.a(this.this$0, 2, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      albd.d(this.this$0, albd.a(this.this$0, 3, this.c, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      albd.b(this.this$0, true);
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