package com.tencent.av.ui.funchat.record;

public class PCMFrame
{
  public byte[] a;
  public long b = 0L;
  public long c;
  
  public PCMFrame(byte[] paramArrayOfByte, long paramLong)
  {
    this.a = paramArrayOfByte;
    this.b = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PCMFrame:");
    byte[] arrayOfByte = this.a;
    int i;
    if (arrayOfByte == null) {
      i = -1;
    } else {
      i = arrayOfByte.length;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", idx=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", pts=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.PCMFrame
 * JD-Core Version:    0.7.0.1
 */