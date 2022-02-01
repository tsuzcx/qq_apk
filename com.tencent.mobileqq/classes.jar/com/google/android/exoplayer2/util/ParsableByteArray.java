package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class ParsableByteArray
{
  public byte[] data;
  private int limit;
  private int position;
  
  public ParsableByteArray() {}
  
  public ParsableByteArray(int paramInt)
  {
    this.data = new byte[paramInt];
    this.limit = paramInt;
  }
  
  public ParsableByteArray(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    this.limit = paramArrayOfByte.length;
  }
  
  public ParsableByteArray(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
  }
  
  public int bytesLeft()
  {
    return this.limit - this.position;
  }
  
  public int capacity()
  {
    byte[] arrayOfByte = this.data;
    if (arrayOfByte == null) {
      return 0;
    }
    return arrayOfByte.length;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int limit()
  {
    return this.limit;
  }
  
  public char peekChar()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    int j = arrayOfByte[i];
    return (char)(arrayOfByte[(i + 1)] & 0xFF | (j & 0xFF) << 8);
  }
  
  public int peekUnsignedByte()
  {
    return this.data[this.position] & 0xFF;
  }
  
  public void readBytes(ParsableBitArray paramParsableBitArray, int paramInt)
  {
    readBytes(paramParsableBitArray.data, 0, paramInt);
    paramParsableBitArray.setPosition(0);
  }
  
  public void readBytes(ByteBuffer paramByteBuffer, int paramInt)
  {
    paramByteBuffer.put(this.data, this.position, paramInt);
    this.position += paramInt;
  }
  
  public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(this.data, this.position, paramArrayOfByte, paramInt1, paramInt2);
    this.position += paramInt2;
  }
  
  public double readDouble()
  {
    return Double.longBitsToDouble(readLong());
  }
  
  public float readFloat()
  {
    return Float.intBitsToFloat(readInt());
  }
  
  public int readInt()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    int k = this.position;
    this.position = (k + 1);
    k = arrayOfByte[k];
    int m = this.position;
    this.position = (m + 1);
    return arrayOfByte[m] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public int readInt24()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    int k = this.position;
    this.position = (k + 1);
    return arrayOfByte[k] & 0xFF | (i & 0xFF) << 24 >> 8 | (j & 0xFF) << 8;
  }
  
  public String readLine()
  {
    if (bytesLeft() == 0) {
      return null;
    }
    int i = this.position;
    while ((i < this.limit) && (!Util.isLinebreak(this.data[i]))) {
      i += 1;
    }
    int j = this.position;
    if (i - j >= 3)
    {
      localObject = this.data;
      if ((localObject[j] == -17) && (localObject[(j + 1)] == -69) && (localObject[(j + 2)] == -65)) {
        this.position = (j + 3);
      }
    }
    Object localObject = this.data;
    j = this.position;
    localObject = new String((byte[])localObject, j, i - j);
    this.position = i;
    i = this.position;
    j = this.limit;
    if (i == j) {
      return localObject;
    }
    if (this.data[i] == 13)
    {
      this.position = (i + 1);
      if (this.position == j) {
        return localObject;
      }
    }
    byte[] arrayOfByte = this.data;
    i = this.position;
    if (arrayOfByte[i] == 10) {
      this.position = (i + 1);
    }
    return localObject;
  }
  
  public int readLittleEndianInt()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    int k = this.position;
    this.position = (k + 1);
    k = arrayOfByte[k];
    int m = this.position;
    this.position = (m + 1);
    return (arrayOfByte[m] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public int readLittleEndianInt24()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    int k = this.position;
    this.position = (k + 1);
    return (arrayOfByte[k] & 0xFF) << 16 | i & 0xFF | (j & 0xFF) << 8;
  }
  
  public long readLittleEndianLong()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l2 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l3 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l4 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l5 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l6 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l7 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    return l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48 | (0xFF & arrayOfByte[i]) << 56;
  }
  
  public short readLittleEndianShort()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    return (short)((arrayOfByte[j] & 0xFF) << 8 | i & 0xFF);
  }
  
  public long readLittleEndianUnsignedInt()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l2 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l3 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    return l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (0xFF & arrayOfByte[i]) << 24;
  }
  
  public int readLittleEndianUnsignedInt24()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    int k = this.position;
    this.position = (k + 1);
    return (arrayOfByte[k] & 0xFF) << 16 | i & 0xFF | (j & 0xFF) << 8;
  }
  
  public int readLittleEndianUnsignedIntToInt()
  {
    int i = readLittleEndianInt();
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(i);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int readLittleEndianUnsignedShort()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    return (arrayOfByte[j] & 0xFF) << 8 | i & 0xFF;
  }
  
  public long readLong()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l2 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l3 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l4 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l5 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l6 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l7 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    return (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | 0xFF & arrayOfByte[i];
  }
  
  public String readNullTerminatedString()
  {
    if (bytesLeft() == 0) {
      return null;
    }
    int i = this.position;
    while ((i < this.limit) && (this.data[i] != 0)) {
      i += 1;
    }
    Object localObject = this.data;
    int j = this.position;
    localObject = new String((byte[])localObject, j, i - j);
    this.position = i;
    i = this.position;
    if (i < this.limit) {
      this.position = (i + 1);
    }
    return localObject;
  }
  
  public String readNullTerminatedString(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    int i = this.position + paramInt - 1;
    if ((i < this.limit) && (this.data[i] == 0)) {
      i = paramInt - 1;
    } else {
      i = paramInt;
    }
    String str = new String(this.data, this.position, i);
    this.position += paramInt;
    return str;
  }
  
  public short readShort()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    return (short)(arrayOfByte[j] & 0xFF | (i & 0xFF) << 8);
  }
  
  public String readString(int paramInt)
  {
    return readString(paramInt, Charset.forName("UTF-8"));
  }
  
  public String readString(int paramInt, Charset paramCharset)
  {
    paramCharset = new String(this.data, this.position, paramInt, paramCharset);
    this.position += paramInt;
    return paramCharset;
  }
  
  public int readSynchSafeInt()
  {
    return readUnsignedByte() << 21 | readUnsignedByte() << 14 | readUnsignedByte() << 7 | readUnsignedByte();
  }
  
  public int readUnsignedByte()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int readUnsignedFixedPoint1616()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    this.position += 2;
    return j & 0xFF | (i & 0xFF) << 8;
  }
  
  public long readUnsignedInt()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l2 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    long l3 = arrayOfByte[i];
    i = this.position;
    this.position = (i + 1);
    return (l1 & 0xFF) << 24 | (l2 & 0xFF) << 16 | (l3 & 0xFF) << 8 | 0xFF & arrayOfByte[i];
  }
  
  public int readUnsignedInt24()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    int k = this.position;
    this.position = (k + 1);
    return arrayOfByte[k] & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  public int readUnsignedIntToInt()
  {
    int i = readInt();
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(i);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long readUnsignedLongToLong()
  {
    long l = readLong();
    if (l >= 0L) {
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(l);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int readUnsignedShort()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    int j = this.position;
    this.position = (j + 1);
    return arrayOfByte[j] & 0xFF | (i & 0xFF) << 8;
  }
  
  public long readUtf8EncodedLong()
  {
    long l = this.data[this.position];
    int i = 7;
    int j;
    int k;
    for (;;)
    {
      j = 1;
      if (i < 0) {
        break;
      }
      k = 1 << i;
      if ((k & l) == 0L)
      {
        if (i < 6)
        {
          l &= k - 1;
          i = 7 - i;
          break label78;
        }
        if (i != 7) {
          break;
        }
        i = 1;
        break label78;
      }
      i -= 1;
    }
    i = 0;
    label78:
    if (i != 0)
    {
      while (j < i)
      {
        k = this.data[(this.position + j)];
        if ((k & 0xC0) == 128)
        {
          l = l << 6 | k & 0x3F;
          j += 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid UTF-8 sequence continuation byte: ");
          ((StringBuilder)localObject).append(l);
          throw new NumberFormatException(((StringBuilder)localObject).toString());
        }
      }
      this.position += i;
      return l;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid UTF-8 sequence first byte: ");
    ((StringBuilder)localObject).append(l);
    localObject = new NumberFormatException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void reset()
  {
    this.position = 0;
    this.limit = 0;
  }
  
  public void reset(int paramInt)
  {
    byte[] arrayOfByte;
    if (capacity() < paramInt) {
      arrayOfByte = new byte[paramInt];
    } else {
      arrayOfByte = this.data;
    }
    reset(arrayOfByte, paramInt);
  }
  
  public void reset(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
    this.position = 0;
  }
  
  public void setLimit(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= this.data.length)) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    this.limit = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= this.limit)) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    this.position = paramInt;
  }
  
  public void skipBytes(int paramInt)
  {
    setPosition(this.position + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ParsableByteArray
 * JD-Core Version:    0.7.0.1
 */