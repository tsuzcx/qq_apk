package com.android.dx.io.instructions;

import java.io.EOFException;

public final class ShortArrayCodeInput
  extends BaseCodeCursor
  implements CodeInput
{
  private final short[] array;
  
  public ShortArrayCodeInput(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      throw new NullPointerException("array == null");
    }
    this.array = paramArrayOfShort;
  }
  
  public boolean hasMore()
  {
    return cursor() < this.array.length;
  }
  
  public int read()
  {
    try
    {
      int i = this.array[cursor()];
      advance(1);
      return i & 0xFFFF;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new EOFException();
    }
  }
  
  public int readInt()
  {
    return read() | read() << 16;
  }
  
  public long readLong()
  {
    return read() | read() << 16 | read() << 32 | read() << 48;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.ShortArrayCodeInput
 * JD-Core Version:    0.7.0.1
 */