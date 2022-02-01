package com.tencent.map.sdk.a;

import java.io.File;

final class oe$b
  extends nz
{
  File a;
  private int b;
  
  oe$b(File paramFile, int paramInt)
  {
    this.a = paramFile;
    this.b = paramInt;
  }
  
  protected final int a()
  {
    return this.b;
  }
  
  public final void a(byte[] paramArrayOfByte) {}
  
  public final byte[] b()
  {
    return new byte[this.b];
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getName());
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.oe.b
 * JD-Core Version:    0.7.0.1
 */