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
    this.bufferSize = (paramInt1 + paramInt2);
    this.bufferPos = paramInt1;
  }
  
  public static int decodeZigZag32(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static long decodeZigZag64(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
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
    if (i > this.currentLimit)
    {
      this.bufferSizeAfterLimit = (i - this.currentLimit);
      this.bufferSize -= this.bufferSizeAfterLimit;
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  public void checkLastTagWas(int paramInt)
  {
    if (this.lastTag != paramInt) {
      throw InvalidProtocolBufferNanoException.invalidEndTag();
    }
  }
  
  public int getBytesUntilLimit()
  {
    if (this.currentLimit == 2147483647) {
      return -1;
    }
    int i = this.bufferPos;
    return this.currentLimit - i;
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
    if (paramInt < 0) {
      throw InvalidProtocolBufferNanoException.negativeSize();
    }
    paramInt = this.bufferPos + paramInt;
    int i = this.currentLimit;
    if (paramInt > i) {
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
    return i;
  }
  
  public boolean readBool()
  {
    return readRawVarint32() != 0;
  }
  
  public byte[] readBytes()
  {
    int i = readRawVarint32();
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.bufferPos, arrayOfByte, 0, i);
      this.bufferPos = (i + this.bufferPos);
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
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
    }
    this.recursionDepth += 1;
    paramMessageNano.mergeFrom(this);
    checkLastTagWas(WireFormatNano.makeTag(paramInt, 4));
    this.recursionDepth -= 1;
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
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
    }
    i = pushLimit(i);
    this.recursionDepth += 1;
    paramMessageNano.mergeFrom(this);
    checkLastTagWas(0);
    this.recursionDepth -= 1;
    popLimit(i);
  }
  
  Object readPrimitiveField(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    case 11: 
    default: 
      throw new IllegalArgumentException("Unknown type " + paramInt);
    case 1: 
      return Double.valueOf(readDouble());
    case 2: 
      return Float.valueOf(readFloat());
    case 3: 
      return Long.valueOf(readInt64());
    case 4: 
      return Long.valueOf(readUInt64());
    case 5: 
      return Integer.valueOf(readInt32());
    case 6: 
      return Long.valueOf(readFixed64());
    case 7: 
      return Integer.valueOf(readFixed32());
    case 8: 
      return Boolean.valueOf(readBool());
    case 9: 
      return readString();
    case 12: 
      return readBytes();
    case 13: 
      return Integer.valueOf(readUInt32());
    case 14: 
      return Integer.valueOf(readEnum());
    case 15: 
      return Integer.valueOf(readSFixed32());
    case 16: 
      return Long.valueOf(readSFixed64());
    case 17: 
      return Integer.valueOf(readSInt32());
    }
    return Long.valueOf(readSInt64());
  }
  
  public byte readRawByte()
  {
    if (this.bufferPos == this.bufferSize) {
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] readRawBytes(int paramInt)
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferNanoException.negativeSize();
    }
    if (this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.bufferPos);
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    if (paramInt <= this.bufferSize - this.bufferPos)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.bufferPos, arrayOfByte, 0, paramInt);
      this.bufferPos += paramInt;
      return arrayOfByte;
    }
    throw InvalidProtocolBufferNanoException.truncatedMessage();
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
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = readRawByte();
      if (k >= 0) {
        return i | k << 21;
      }
      j = readRawByte();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (readRawByte() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw InvalidProtocolBufferNanoException.malformedVarint();
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
    throw InvalidProtocolBufferNanoException.malformedVarint();
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
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      String str = new String(this.buffer, this.bufferPos, i, InternalNano.UTF_8);
      this.bufferPos = (i + this.bufferPos);
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
    if (this.lastTag == 0) {
      throw InvalidProtocolBufferNanoException.invalidTag();
    }
    return this.lastTag;
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
    if (paramInt > this.bufferPos - this.bufferStart) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.bufferPos - this.bufferStart));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.bufferPos = (this.bufferStart + paramInt);
  }
  
  public int setRecursionLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Recursion limit cannot be negative: " + paramInt);
    }
    int i = this.recursionLimit;
    this.recursionLimit = paramInt;
    return i;
  }
  
  public int setSizeLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Size limit cannot be negative: " + paramInt);
    }
    int i = this.sizeLimit;
    this.sizeLimit = paramInt;
    return i;
  }
  
  public boolean skipField(int paramInt)
  {
    switch (WireFormatNano.getTagWireType(paramInt))
    {
    default: 
      throw InvalidProtocolBufferNanoException.invalidWireType();
    case 0: 
      readInt32();
      return true;
    case 1: 
      readRawLittleEndian64();
      return true;
    case 2: 
      skipRawBytes(readRawVarint32());
      return true;
    case 3: 
      skipMessage();
      checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    readRawLittleEndian32();
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
    if (paramInt < 0) {
      throw InvalidProtocolBufferNanoException.negativeSize();
    }
    if (this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.bufferPos);
      throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
    if (paramInt <= this.bufferSize - this.bufferPos)
    {
      this.bufferPos += paramInt;
      return;
    }
    throw InvalidProtocolBufferNanoException.truncatedMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.CodedInputByteBufferNano
 * JD-Core Version:    0.7.0.1
 */