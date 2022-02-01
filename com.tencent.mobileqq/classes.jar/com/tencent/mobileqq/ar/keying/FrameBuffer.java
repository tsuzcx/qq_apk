package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class FrameBuffer
{
  private int jdField_a_of_type_Int;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private int jdField_b_of_type_Int;
  private int[] jdField_b_of_type_ArrayOfInt = null;
  
  private void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (arrayOfInt != null)
      {
        GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
        this.jdField_a_of_type_ArrayOfInt = null;
      }
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      if (arrayOfInt != null)
      {
        GLES20.glDeleteTextures(1, arrayOfInt, 0);
        this.jdField_b_of_type_ArrayOfInt = null;
      }
      this.jdField_a_of_type_ArrayOfInt = new int[1];
      this.jdField_b_of_type_ArrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, this.jdField_a_of_type_ArrayOfInt, 0);
      GLES20.glGenTextures(1, this.jdField_b_of_type_ArrayOfInt, 0);
      GLES20.glBindTexture(3553, this.jdField_b_of_type_ArrayOfInt[0]);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ArrayOfInt[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jdField_b_of_type_ArrayOfInt[0], 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      return;
    }
    throw new IllegalArgumentException("width & height should > 0!");
  }
  
  public int a()
  {
    int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
    if (arrayOfInt != null) {
      return arrayOfInt[0];
    }
    return 0;
  }
  
  public void a()
  {
    int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.jdField_b_of_type_ArrayOfInt = null;
    }
    arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
      this.jdField_a_of_type_ArrayOfInt = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_ArrayOfInt == null) || (paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int))
    {
      long l = System.currentTimeMillis();
      b(paramInt1, paramInt2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" init need ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.i("Keying_FrameBuffer", 2, localStringBuilder.toString());
    }
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ArrayOfInt[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.FrameBuffer
 * JD-Core Version:    0.7.0.1
 */