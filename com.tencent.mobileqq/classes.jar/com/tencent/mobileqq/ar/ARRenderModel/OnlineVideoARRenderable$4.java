package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

class OnlineVideoARRenderable$4
  implements Runnable
{
  public void run()
  {
    if (OnlineVideoARRenderable.e(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { OnlineVideoARRenderable.e(this.this$0) }, 0);
    }
    if (OnlineVideoARRenderable.f(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { OnlineVideoARRenderable.f(this.this$0) }, 0);
    }
    if (OnlineVideoARRenderable.g(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { OnlineVideoARRenderable.g(this.this$0) }, 0);
    }
    try
    {
      OnlineVideoARRenderable.b(this.this$0, OnlineVideoARRenderable.a(this.this$0, 1, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      OnlineVideoARRenderable.c(this.this$0, OnlineVideoARRenderable.a(this.this$0, 2, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      OnlineVideoARRenderable.d(this.this$0, OnlineVideoARRenderable.a(this.this$0, 3, this.c, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      OnlineVideoARRenderable.a(this.this$0, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.4
 * JD-Core Version:    0.7.0.1
 */