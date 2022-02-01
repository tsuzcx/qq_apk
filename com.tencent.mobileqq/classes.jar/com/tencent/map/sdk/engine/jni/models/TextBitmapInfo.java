package com.tencent.map.sdk.engine.jni.models;

import com.tencent.map.sdk.a.pa;
import java.util.Arrays;

public class TextBitmapInfo
{
  byte[] a = new byte[4];
  public boolean bold;
  public float density;
  public int height;
  public int pitch;
  public int width;
  
  public void fill(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.a;
    boolean bool = false;
    Arrays.fill(arrayOfByte, (byte)0);
    System.arraycopy(paramArrayOfByte, 0, this.a, 0, 4);
    this.density = Float.intBitsToFloat(pa.a(this.a));
    System.arraycopy(paramArrayOfByte, 4, this.a, 0, 4);
    this.width = pa.a(this.a);
    System.arraycopy(paramArrayOfByte, 8, this.a, 0, 4);
    this.height = pa.a(this.a);
    System.arraycopy(paramArrayOfByte, 12, this.a, 0, 4);
    this.pitch = pa.a(this.a);
    System.arraycopy(paramArrayOfByte, 16, this.a, 0, 1);
    if (this.a[0] > 0) {
      bool = true;
    }
    this.bold = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.models.TextBitmapInfo
 * JD-Core Version:    0.7.0.1
 */