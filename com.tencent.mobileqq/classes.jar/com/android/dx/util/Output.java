package com.android.dx.util;

import com.android.dex.util.ByteOutput;

public abstract interface Output
  extends ByteOutput
{
  public abstract void alignTo(int paramInt);
  
  public abstract void assertCursor(int paramInt);
  
  public abstract int getCursor();
  
  public abstract void write(ByteArray paramByteArray);
  
  public abstract void write(byte[] paramArrayOfByte);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeByte(int paramInt);
  
  public abstract void writeInt(int paramInt);
  
  public abstract void writeLong(long paramLong);
  
  public abstract void writeShort(int paramInt);
  
  public abstract int writeSleb128(int paramInt);
  
  public abstract int writeUleb128(int paramInt);
  
  public abstract void writeZeroes(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.Output
 * JD-Core Version:    0.7.0.1
 */