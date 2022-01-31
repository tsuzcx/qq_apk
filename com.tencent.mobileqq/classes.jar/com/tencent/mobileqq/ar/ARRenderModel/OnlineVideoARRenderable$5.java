package com.tencent.mobileqq.ar.ARRenderModel;

import albc;
import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class OnlineVideoARRenderable$5
  implements Runnable
{
  public OnlineVideoARRenderable$5(albc paramalbc, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void run()
  {
    if (albc.f(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { albc.f(this.this$0) }, 0);
    }
    if (albc.g(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { albc.g(this.this$0) }, 0);
    }
    if (albc.h(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { albc.h(this.this$0) }, 0);
    }
    try
    {
      albc.b(this.this$0, albc.a(this.this$0, 1, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      albc.c(this.this$0, albc.a(this.this$0, 2, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      albc.d(this.this$0, albc.a(this.this$0, 3, this.c, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      albc.b(this.this$0, true);
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