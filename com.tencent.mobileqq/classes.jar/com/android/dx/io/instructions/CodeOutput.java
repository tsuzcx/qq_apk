package com.android.dx.io.instructions;

public abstract interface CodeOutput
  extends CodeCursor
{
  public abstract void write(short paramShort);
  
  public abstract void write(short paramShort1, short paramShort2);
  
  public abstract void write(short paramShort1, short paramShort2, short paramShort3);
  
  public abstract void write(short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  public abstract void write(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5);
  
  public abstract void write(byte[] paramArrayOfByte);
  
  public abstract void write(int[] paramArrayOfInt);
  
  public abstract void write(long[] paramArrayOfLong);
  
  public abstract void write(short[] paramArrayOfShort);
  
  public abstract void writeInt(int paramInt);
  
  public abstract void writeLong(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.CodeOutput
 * JD-Core Version:    0.7.0.1
 */