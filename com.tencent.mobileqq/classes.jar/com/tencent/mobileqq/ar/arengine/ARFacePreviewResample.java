package com.tencent.mobileqq.ar.arengine;

import android.util.Log;

public class ARFacePreviewResample
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private byte[] g;
  
  private void b(byte[] paramArrayOfByte)
  {
    long l = System.currentTimeMillis();
    nativeScaleYUVImage2(this.g, this.d, this.e, paramArrayOfByte, this.a, this.b);
    Log.d("ARFacePreviewResample", String.format("doResample time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
  }
  
  private native int nativeScaleYUVImage2(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4);
  
  public int a()
  {
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    paramInt1 = this.b;
    if (paramInt1 > 480)
    {
      this.e = (paramInt1 / 2 / 4 * 4);
      this.d = ((this.a * this.e / paramInt1 + 3) / 4 * 4);
      this.f = true;
    }
    else
    {
      this.e = paramInt1;
      this.d = this.a;
      this.f = false;
    }
    if (this.f) {
      this.g = new byte[this.d * this.e * 3 >> 1];
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.f)
    {
      b(paramArrayOfByte);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public byte[] c()
  {
    if (this.f) {
      return this.g;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARFacePreviewResample
 * JD-Core Version:    0.7.0.1
 */