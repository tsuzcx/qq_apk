package com.google.zxing.qrcode.decoder;

public final class Version$ECBlocks
{
  private final int a;
  private final Version.ECB[] b;
  
  Version$ECBlocks(int paramInt, Version.ECB... paramVarArgs)
  {
    this.a = paramInt;
    this.b = paramVarArgs;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    Version.ECB[] arrayOfECB = this.b;
    int k = arrayOfECB.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += arrayOfECB[i].a();
      i += 1;
    }
    return j;
  }
  
  public int c()
  {
    return this.a * b();
  }
  
  public Version.ECB[] d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Version.ECBlocks
 * JD-Core Version:    0.7.0.1
 */