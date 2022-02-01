package com.tencent.mobileqq.ar.arengine;

import android.util.Log;

public class ARFacePreviewResample
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private void a(byte[] paramArrayOfByte)
  {
    long l = System.currentTimeMillis();
    nativeScaleYUVImage2(this.jdField_a_of_type_ArrayOfByte, this.d, this.e, paramArrayOfByte, this.jdField_a_of_type_Int, this.b);
    Log.d("ARFacePreviewResample", String.format("doResample time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
  }
  
  private native int nativeScaleYUVImage2(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4);
  
  public int a()
  {
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    if (this.b > 480)
    {
      this.e = (this.b / 2 / 4 * 4);
      this.d = ((this.jdField_a_of_type_Int * this.e / this.b + 3) / 4 * 4);
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.d * this.e * 3 >> 1];
      }
      return;
      this.e = this.b;
      this.d = this.jdField_a_of_type_Int;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(paramArrayOfByte);
      return true;
    }
    return false;
  }
  
  public byte[] a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public int b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARFacePreviewResample
 * JD-Core Version:    0.7.0.1
 */