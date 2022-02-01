package com.google.protobuf.nano;

public final class CodedInputByteBufferNano
{
  private static final int DEFAULT_RECURSION_LIMIT = 64;
  private static final int DEFAULT_SIZE_LIMIT = 67108864;
  private final byte[] buffer;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int bufferStart;
  private int currentLimit = 2147483647;
  private int lastTag;
  private int recursionDepth;
  private int recursionLimit = 64;
  private int sizeLimit = 67108864;
  
  private CodedInputByteBufferNano(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.bufferStart = paramInt1;
    this.bufferSize = (paramInt2 + paramInt1);
    this.bufferPos = paramInt1;
  }
  
  public static int decodeZigZag32(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public static long decodeZigZag64(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  public static CodedInputByteBufferNano newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedInputByteBufferNano newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedInputByteBufferNano(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void recomputeBufferSizeAfterLimit()
  {
    this.bufferSize += this.bufferSizeAfterLimit;
    int i = this.bufferSize;
    int j = this.currentLimit;
    if (i > j)
    {
      this.bufferSizeAfterLimit = (i - j);
      this.bufferSize = (i - this.bufferSizeAfterLimit);
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  public void checkLastTagWas(int paramInt)
  {
    if (this.lastTag == paramInt) {
      return;
    }
    throw InvalidProtocolBufferNanoException.invalidEndTag();
  }
  
  public int getBytesUntilLimit()
  {
    int i = this.currentLimit;
    if (i == 2147483647) {
      return -1;
    }
    return i - this.bufferPos;
  }
  
  public byte[] getData(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return WireFormatNano.EMPTY_BYTES;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.bufferStart;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public int getPosition()
  {
    return this.bufferPos - this.bufferStart;
  }
  
  public boolean isAtEnd()
  {
    return this.bufferPos == this.bufferSize;
  }
  
  public void popLimit(int paramInt)
  {
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }
  
  public int pushLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      paramInt += this.bufferPos;
      int i = this.currentLimit;
      if (paramInt <= i)
      {
        this.currentLimit = paramInt;
        recomputeBufferSizeAfterLimit();
        return i;
      }
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    throw InvalidProtocolBufferNanoException.negativeSize();
  }
  
  public boolean readBool()
  {
    return readRawVarint32() != 0;
  }
  
  public byte[] readBytes()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if ((i <= j - k) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, k, arrayOfByte, 0, i);
      this.bufferPos += i;
      return arrayOfByte;
    }
    if (i == 0) {
      return WireFormatNano.EMPTY_BYTES;
    }
    return readRawBytes(i);
  }
  
  public double readDouble()
  {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public int readEnum()
  {
    return readRawVarint32();
  }
  
  public int readFixed32()
  {
    return readRawLittleEndian32();
  }
  
  public long readFixed64()
  {
    return readRawLittleEndian64();
  }
  
  public float readFloat()
  {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public void readGroup(MessageNano paramMessageNano, int paramInt)
  {
    int i = this.recursionDepth;
    if (i < this.recursionLimit)
    {
      this.recursionDepth = (i + 1);
      paramMessageNano.mergeFrom(this);
      checkLastTagWas(WireFormatNano.makeTag(paramInt, 4));
      this.recursionDepth -= 1;
      return;
    }
    throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
  }
  
  public int readInt32()
  {
    return readRawVarint32();
  }
  
  public long readInt64()
  {
    return readRawVarint64();
  }
  
  public void readMessage(MessageNano paramMessageNano)
  {
    int i = readRawVarint32();
    if (this.recursionDepth < this.recursionLimit)
    {
      i = pushLimit(i);
      this.recursionDepth += 1;
      paramMessageNano.mergeFrom(this);
      checkLastTagWas(0);
      this.recursionDepth -= 1;
      popLimit(i);
      return;
    }
    throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
  }
  
  Object readPrimitiveField(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    case 11: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown type ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 18: 
      return Long.valueOf(readSInt64());
    case 17: 
      return Integer.valueOf(readSInt32());
    case 16: 
      return Long.valueOf(readSFixed64());
    case 15: 
      return Integer.valueOf(readSFixed32());
    case 14: 
      return Integer.valueOf(readEnum());
    case 13: 
      return Integer.valueOf(readUInt32());
    case 12: 
      return readBytes();
    case 9: 
      return readString();
    case 8: 
      return Boolean.valueOf(readBool());
    case 7: 
      return Integer.valueOf(readFixed32());
    case 6: 
      return Long.valueOf(readFixed64());
    case 5: 
      return Integer.valueOf(readInt32());
    case 4: 
      return Long.valueOf(readUInt64());
    case 3: 
      return Long.valueOf(readInt64());
    case 2: 
      return Float.valueOf(readFloat());
    }
    return Double.valueOf(readDouble());
  }
  
  public byte readRawByte()
  {
    int i = this.bufferPos;
    if (i != this.bufferSize)
    {
      byte[] arrayOfByte = this.buffer;
      this.bufferPos = (i + 1);
      return arrayOfByte[i];
    }
    throw InvalidProtocolBufferNanoException.truncatedMessage();
  }
  
  public byte[] readRawBytes(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.bufferPos;
      int j = this.currentLimit;
      if (i + paramInt <= j)
      {
        if (paramInt <= this.bufferSize - i)
        {
          byte[] arrayOfByte = new byte[paramInt];
          System.arraycopy(this.buffer, i, arrayOfByte, 0, paramInt);
          this.bufferPos += paramInt;
          return arrayOfByte;
        }
        throw InvalidProtocolBufferNanoException.truncatedMessage();
      }
      skipRawBytes(j - i);
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    throw InvalidProtocolBufferNanoException.negativeSize();
  }
  
  public int readRawLittleEndian32()
  {
    return readRawByte() & 0xFF | (readRawByte() & 0xFF) << 8 | (readRawByte() & 0xFF) << 16 | (readRawByte() & 0xFF) << 24;
  }
  
  public long readRawLittleEndian64()
  {
    int i = readRawByte();
    int j = readRawByte();
    int k = readRawByte();
    int m = readRawByte();
    int n = readRawByte();
    int i1 = readRawByte();
    int i2 = readRawByte();
    int i3 = readRawByte();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int readRawVarint32()
  {
    int i = readRawByte();
    if (i >= 0) {
      return i;
    }
    i &= 0x7F;
    int j = readRawByte();
    if (j >= 0) {
      j <<= 7;
    }
    for (;;)
    {
      return i | j;
      i |= (j & 0x7F) << 7;
      j = readRawByte();
      if (j >= 0)
      {
        j <<= 14;
      }
      else
      {
        i |= (j & 0x7F) << 14;
        j = readRawByte();
        if (j < 0) {
          break;
        }
        j <<= 21;
      }
    }
    int k = readRawByte();
    j = i | (j & 0x7F) << 21 | k << 28;
    if (k < 0)
    {
      i = 0;
      while (i < 5)
      {
        if (readRawByte() >= 0) {
          return j;
        }
        i += 1;
      }
      throw InvalidProtocolBufferNanoException.malformedVarint();
    }
    return j;
  }
  
  public long readRawVarint64()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    InvalidProtocolBufferNanoException localInvalidProtocolBufferNanoException = InvalidProtocolBufferNanoException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferNanoException;
    }
  }
  
  public int readSFixed32()
  {
    return readRawLittleEndian32();
  }
  
  public long readSFixed64()
  {
    return readRawLittleEndian64();
  }
  
  public int readSInt32()
  {
    return decodeZigZag32(readRawVarint32());
  }
  
  public long readSInt64()
  {
    return decodeZigZag64(readRawVarint64());
  }
  
  public String readString()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if ((i <= j - k) && (i > 0))
    {
      String str = new String(this.buffer, k, i, InternalNano.UTF_8);
      this.bufferPos += i;
      return str;
    }
    return new String(readRawBytes(i), InternalNano.UTF_8);
  }
  
  public int readTag()
  {
    if (isAtEnd())
    {
      this.lastTag = 0;
      return 0;
    }
    this.lastTag = readRawVarint32();
    int i = this.lastTag;
    if (i != 0) {
      return i;
    }
    throw InvalidProtocolBufferNanoException.invalidTag();
  }
  
  public int readUInt32()
  {
    return readRawVarint32();
  }
  
  public long readUInt64()
  {
    return readRawVarint64();
  }
  
  public void resetSizeCounter() {}
  
  public void rewindToPosition(int paramInt)
  {
    int i = this.bufferPos;
    int j = this.bufferStart;
    if (paramInt <= i - j)
    {
      if (paramInt >= 0)
      {
        this.bufferPos = (j + paramInt);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad position ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Position ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is beyond current ");
    localStringBuilder.append(this.bufferPos - this.bufferStart);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int setRecursionLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.recursionLimit;
      this.recursionLimit = paramInt;
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recursion limit cannot be negative: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int setSizeLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.sizeLimit;
      this.sizeLimit = paramInt;
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Size limit cannot be negative: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean skipField(int paramInt)
  {
    int i = WireFormatNano.getTagWireType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                readRawLittleEndian32();
                return true;
              }
              throw InvalidProtocolBufferNanoException.invalidWireType();
            }
            return false;
          }
          skipMessage();
          checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(paramInt), 4));
          return true;
        }
        skipRawBytes(readRawVarint32());
        return true;
      }
      readRawLittleEndian64();
      return true;
    }
    readInt32();
    return true;
  }
  
  public void skipMessage()
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i)));
  }
  
  public void skipRawBytes(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.bufferPos;
      int j = this.currentLimit;
      if (i + paramInt <= j)
      {
        if (paramInt <= this.bufferSize - i)
        {
          this.bufferPos = (i + paramInt);
          return;
        }
        throw InvalidProtocolBufferNanoException.truncatedMessage();
      }
      skipRawBytes(j - i);
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    throw InvalidProtocolBufferNanoException.negativeSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.protobuf.nano.CodedInputByteBufferNano
 * JD-Core Version:    0.7.0.1
 */