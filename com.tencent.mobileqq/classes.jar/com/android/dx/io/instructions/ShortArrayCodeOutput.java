package com.android.dx.io.instructions;

public final class ShortArrayCodeOutput
  extends BaseCodeCursor
  implements CodeOutput
{
  private final short[] array;
  
  public ShortArrayCodeOutput(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxSize < 0");
    }
    this.array = new short[paramInt];
  }
  
  public short[] getArray()
  {
    int i = cursor();
    if (i == this.array.length) {
      return this.array;
    }
    short[] arrayOfShort = new short[i];
    System.arraycopy(this.array, 0, arrayOfShort, 0, i);
    return arrayOfShort;
  }
  
  public void write(short paramShort)
  {
    this.array[cursor()] = paramShort;
    advance(1);
  }
  
  public void write(short paramShort1, short paramShort2)
  {
    write(paramShort1);
    write(paramShort2);
  }
  
  public void write(short paramShort1, short paramShort2, short paramShort3)
  {
    write(paramShort1);
    write(paramShort2);
    write(paramShort3);
  }
  
  public void write(short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    write(paramShort1);
    write(paramShort2);
    write(paramShort3);
    write(paramShort4);
  }
  
  public void write(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5)
  {
    write(paramShort1);
    write(paramShort2);
    write(paramShort3);
    write(paramShort4);
    write(paramShort5);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length;
    int k = 0;
    int j = 1;
    int i = 0;
    if (k < m)
    {
      int n = paramArrayOfByte[k];
      if (j != 0) {
        i = n & 0xFF;
      }
      for (j = 0;; j = 1)
      {
        k += 1;
        break;
        i = n << 8 | i;
        write((short)i);
      }
    }
    if (j == 0) {
      write((short)i);
    }
  }
  
  public void write(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      writeInt(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public void write(long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      writeLong(paramArrayOfLong[i]);
      i += 1;
    }
  }
  
  public void write(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      write(paramArrayOfShort[i]);
      i += 1;
    }
  }
  
  public void writeInt(int paramInt)
  {
    write((short)paramInt);
    write((short)(paramInt >> 16));
  }
  
  public void writeLong(long paramLong)
  {
    write((short)(int)paramLong);
    write((short)(int)(paramLong >> 16));
    write((short)(int)(paramLong >> 32));
    write((short)(int)(paramLong >> 48));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.ShortArrayCodeOutput
 * JD-Core Version:    0.7.0.1
 */