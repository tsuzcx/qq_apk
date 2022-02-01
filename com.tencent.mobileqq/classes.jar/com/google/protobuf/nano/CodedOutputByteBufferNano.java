package com.google.protobuf.nano;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class CodedOutputByteBufferNano
{
  public static final int LITTLE_ENDIAN_32_SIZE = 4;
  public static final int LITTLE_ENDIAN_64_SIZE = 8;
  private static final int MAX_UTF8_EXPANSION = 3;
  private final ByteBuffer buffer;
  
  private CodedOutputByteBufferNano(ByteBuffer paramByteBuffer)
  {
    this.buffer = paramByteBuffer;
    this.buffer.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private CodedOutputByteBufferNano(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static int computeBoolSize(int paramInt, boolean paramBoolean)
  {
    return computeTagSize(paramInt) + computeBoolSizeNoTag(paramBoolean);
  }
  
  public static int computeBoolSizeNoTag(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int computeBytesSize(int paramInt, byte[] paramArrayOfByte)
  {
    return computeTagSize(paramInt) + computeBytesSizeNoTag(paramArrayOfByte);
  }
  
  public static int computeBytesSizeNoTag(byte[] paramArrayOfByte)
  {
    return computeRawVarint32Size(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int computeDoubleSize(int paramInt, double paramDouble)
  {
    return computeTagSize(paramInt) + computeDoubleSizeNoTag(paramDouble);
  }
  
  public static int computeDoubleSizeNoTag(double paramDouble)
  {
    return 8;
  }
  
  public static int computeEnumSize(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeEnumSizeNoTag(paramInt2);
  }
  
  public static int computeEnumSizeNoTag(int paramInt)
  {
    return computeRawVarint32Size(paramInt);
  }
  
  static int computeFieldSize(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("Unknown type: " + paramInt2);
    case 8: 
      return computeBoolSize(paramInt1, ((Boolean)paramObject).booleanValue());
    case 12: 
      return computeBytesSize(paramInt1, (byte[])paramObject);
    case 9: 
      return computeStringSize(paramInt1, (String)paramObject);
    case 2: 
      return computeFloatSize(paramInt1, ((Float)paramObject).floatValue());
    case 1: 
      return computeDoubleSize(paramInt1, ((Double)paramObject).doubleValue());
    case 14: 
      return computeEnumSize(paramInt1, ((Integer)paramObject).intValue());
    case 7: 
      return computeFixed32Size(paramInt1, ((Integer)paramObject).intValue());
    case 5: 
      return computeInt32Size(paramInt1, ((Integer)paramObject).intValue());
    case 13: 
      return computeUInt32Size(paramInt1, ((Integer)paramObject).intValue());
    case 17: 
      return computeSInt32Size(paramInt1, ((Integer)paramObject).intValue());
    case 15: 
      return computeSFixed32Size(paramInt1, ((Integer)paramObject).intValue());
    case 3: 
      return computeInt64Size(paramInt1, ((Long)paramObject).longValue());
    case 4: 
      return computeUInt64Size(paramInt1, ((Long)paramObject).longValue());
    case 18: 
      return computeSInt64Size(paramInt1, ((Long)paramObject).longValue());
    case 6: 
      return computeFixed64Size(paramInt1, ((Long)paramObject).longValue());
    case 16: 
      return computeSFixed64Size(paramInt1, ((Long)paramObject).longValue());
    case 11: 
      return computeMessageSize(paramInt1, (MessageNano)paramObject);
    }
    return computeGroupSize(paramInt1, (MessageNano)paramObject);
  }
  
  public static int computeFixed32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeFixed32SizeNoTag(paramInt2);
  }
  
  public static int computeFixed32SizeNoTag(int paramInt)
  {
    return 4;
  }
  
  public static int computeFixed64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeFixed64SizeNoTag(paramLong);
  }
  
  public static int computeFixed64SizeNoTag(long paramLong)
  {
    return 8;
  }
  
  public static int computeFloatSize(int paramInt, float paramFloat)
  {
    return computeTagSize(paramInt) + computeFloatSizeNoTag(paramFloat);
  }
  
  public static int computeFloatSizeNoTag(float paramFloat)
  {
    return 4;
  }
  
  public static int computeGroupSize(int paramInt, MessageNano paramMessageNano)
  {
    return computeTagSize(paramInt) * 2 + computeGroupSizeNoTag(paramMessageNano);
  }
  
  public static int computeGroupSizeNoTag(MessageNano paramMessageNano)
  {
    return paramMessageNano.getSerializedSize();
  }
  
  public static int computeInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeInt32SizeNoTag(paramInt2);
  }
  
  public static int computeInt32SizeNoTag(int paramInt)
  {
    if (paramInt >= 0) {
      return computeRawVarint32Size(paramInt);
    }
    return 10;
  }
  
  public static int computeInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeInt64SizeNoTag(paramLong);
  }
  
  public static int computeInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(paramLong);
  }
  
  public static int computeMessageSize(int paramInt, MessageNano paramMessageNano)
  {
    return computeTagSize(paramInt) + computeMessageSizeNoTag(paramMessageNano);
  }
  
  public static int computeMessageSizeNoTag(MessageNano paramMessageNano)
  {
    int i = paramMessageNano.getSerializedSize();
    return i + computeRawVarint32Size(i);
  }
  
  public static int computeRawVarint32Size(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int computeRawVarint64Size(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((0x0 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static int computeSFixed32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeSFixed32SizeNoTag(paramInt2);
  }
  
  public static int computeSFixed32SizeNoTag(int paramInt)
  {
    return 4;
  }
  
  public static int computeSFixed64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeSFixed64SizeNoTag(paramLong);
  }
  
  public static int computeSFixed64SizeNoTag(long paramLong)
  {
    return 8;
  }
  
  public static int computeSInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeSInt32SizeNoTag(paramInt2);
  }
  
  public static int computeSInt32SizeNoTag(int paramInt)
  {
    return computeRawVarint32Size(encodeZigZag32(paramInt));
  }
  
  public static int computeSInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeSInt64SizeNoTag(paramLong);
  }
  
  public static int computeSInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(encodeZigZag64(paramLong));
  }
  
  public static int computeStringSize(int paramInt, String paramString)
  {
    return computeTagSize(paramInt) + computeStringSizeNoTag(paramString);
  }
  
  public static int computeStringSizeNoTag(String paramString)
  {
    int i = encodedLength(paramString);
    return i + computeRawVarint32Size(i);
  }
  
  public static int computeTagSize(int paramInt)
  {
    return computeRawVarint32Size(WireFormatNano.makeTag(paramInt, 0));
  }
  
  public static int computeUInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeUInt32SizeNoTag(paramInt2);
  }
  
  public static int computeUInt32SizeNoTag(int paramInt)
  {
    return computeRawVarint32Size(paramInt);
  }
  
  public static int computeUInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeUInt64SizeNoTag(paramLong);
  }
  
  public static int computeUInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(paramLong);
  }
  
  private static int encode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label445;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException("Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label445:
      throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  private static void encode(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(encode(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    encodeDirect(paramCharSequence, paramByteBuffer);
  }
  
  private static void encodeDirect(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException("Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static int encodeZigZag32(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static long encodeZigZag64(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  private static int encodedLength(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while ((i < m) && (paramCharSequence.charAt(i) < '')) {
      i += 1;
    }
    for (;;)
    {
      int k = i;
      int j;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          j += 1;
          i = (127 - k >>> 31) + i;
        }
        else
        {
          k = i + encodedLengthGeneral(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m) {
          throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (k + 4294967296L));
        }
        return k;
        j = i;
        i = m;
      }
    }
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536) {
              throw new IllegalArgumentException("Unpaired surrogate at index " + paramInt);
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  public static CodedOutputByteBufferNano newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedOutputByteBufferNano newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedOutputByteBufferNano(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void checkNoSpaceLeft()
  {
    if (spaceLeft() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public int position()
  {
    return this.buffer.position();
  }
  
  public void reset()
  {
    this.buffer.clear();
  }
  
  public int spaceLeft()
  {
    return this.buffer.remaining();
  }
  
  public void writeBool(int paramInt, boolean paramBoolean)
  {
    writeTag(paramInt, 0);
    writeBoolNoTag(paramBoolean);
  }
  
  public void writeBoolNoTag(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      writeRawByte(i);
      return;
    }
  }
  
  public void writeBytes(int paramInt, byte[] paramArrayOfByte)
  {
    writeTag(paramInt, 2);
    writeBytesNoTag(paramArrayOfByte);
  }
  
  public void writeBytesNoTag(byte[] paramArrayOfByte)
  {
    writeRawVarint32(paramArrayOfByte.length);
    writeRawBytes(paramArrayOfByte);
  }
  
  public void writeDouble(int paramInt, double paramDouble)
  {
    writeTag(paramInt, 1);
    writeDoubleNoTag(paramDouble);
  }
  
  public void writeDoubleNoTag(double paramDouble)
  {
    writeRawLittleEndian64(Double.doubleToLongBits(paramDouble));
  }
  
  public void writeEnum(int paramInt1, int paramInt2)
  {
    writeTag(paramInt1, 0);
    writeEnumNoTag(paramInt2);
  }
  
  public void writeEnumNoTag(int paramInt)
  {
    writeRawVarint32(paramInt);
  }
  
  void writeField(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    default: 
      throw new IOException("Unknown type: " + paramInt2);
    case 1: 
      writeDouble(paramInt1, ((Double)paramObject).doubleValue());
      return;
    case 2: 
      writeFloat(paramInt1, ((Float)paramObject).floatValue());
      return;
    case 3: 
      writeInt64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 4: 
      writeUInt64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 5: 
      writeInt32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 6: 
      writeFixed64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 7: 
      writeFixed32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 8: 
      writeBool(paramInt1, ((Boolean)paramObject).booleanValue());
      return;
    case 9: 
      writeString(paramInt1, (String)paramObject);
      return;
    case 12: 
      writeBytes(paramInt1, (byte[])paramObject);
      return;
    case 13: 
      writeUInt32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 14: 
      writeEnum(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 15: 
      writeSFixed32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 16: 
      writeSFixed64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 17: 
      writeSInt32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 18: 
      writeSInt64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 11: 
      writeMessage(paramInt1, (MessageNano)paramObject);
      return;
    }
    writeGroup(paramInt1, (MessageNano)paramObject);
  }
  
  public void writeFixed32(int paramInt1, int paramInt2)
  {
    writeTag(paramInt1, 5);
    writeFixed32NoTag(paramInt2);
  }
  
  public void writeFixed32NoTag(int paramInt)
  {
    writeRawLittleEndian32(paramInt);
  }
  
  public void writeFixed64(int paramInt, long paramLong)
  {
    writeTag(paramInt, 1);
    writeFixed64NoTag(paramLong);
  }
  
  public void writeFixed64NoTag(long paramLong)
  {
    writeRawLittleEndian64(paramLong);
  }
  
  public void writeFloat(int paramInt, float paramFloat)
  {
    writeTag(paramInt, 5);
    writeFloatNoTag(paramFloat);
  }
  
  public void writeFloatNoTag(float paramFloat)
  {
    writeRawLittleEndian32(Float.floatToIntBits(paramFloat));
  }
  
  public void writeGroup(int paramInt, MessageNano paramMessageNano)
  {
    writeTag(paramInt, 3);
    writeGroupNoTag(paramMessageNano);
    writeTag(paramInt, 4);
  }
  
  public void writeGroupNoTag(MessageNano paramMessageNano)
  {
    paramMessageNano.writeTo(this);
  }
  
  public void writeInt32(int paramInt1, int paramInt2)
  {
    writeTag(paramInt1, 0);
    writeInt32NoTag(paramInt2);
  }
  
  public void writeInt32NoTag(int paramInt)
  {
    if (paramInt >= 0)
    {
      writeRawVarint32(paramInt);
      return;
    }
    writeRawVarint64(paramInt);
  }
  
  public void writeInt64(int paramInt, long paramLong)
  {
    writeTag(paramInt, 0);
    writeInt64NoTag(paramLong);
  }
  
  public void writeInt64NoTag(long paramLong)
  {
    writeRawVarint64(paramLong);
  }
  
  public void writeMessage(int paramInt, MessageNano paramMessageNano)
  {
    writeTag(paramInt, 2);
    writeMessageNoTag(paramMessageNano);
  }
  
  public void writeMessageNoTag(MessageNano paramMessageNano)
  {
    writeRawVarint32(paramMessageNano.getCachedSize());
    paramMessageNano.writeTo(this);
  }
  
  public void writeRawByte(byte paramByte)
  {
    if (!this.buffer.hasRemaining()) {
      throw new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }
    this.buffer.put(paramByte);
  }
  
  public void writeRawByte(int paramInt)
  {
    writeRawByte((byte)paramInt);
  }
  
  public void writeRawBytes(byte[] paramArrayOfByte)
  {
    writeRawBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void writeRawBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.buffer.remaining() >= paramInt2)
    {
      this.buffer.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
  }
  
  public void writeRawLittleEndian32(int paramInt)
  {
    if (this.buffer.remaining() < 4) {
      throw new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }
    this.buffer.putInt(paramInt);
  }
  
  public void writeRawLittleEndian64(long paramLong)
  {
    if (this.buffer.remaining() < 8) {
      throw new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }
    this.buffer.putLong(paramLong);
  }
  
  public void writeRawVarint32(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        writeRawByte(paramInt);
        return;
      }
      writeRawByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void writeRawVarint64(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        writeRawByte((int)paramLong);
        return;
      }
      writeRawByte((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void writeSFixed32(int paramInt1, int paramInt2)
  {
    writeTag(paramInt1, 5);
    writeSFixed32NoTag(paramInt2);
  }
  
  public void writeSFixed32NoTag(int paramInt)
  {
    writeRawLittleEndian32(paramInt);
  }
  
  public void writeSFixed64(int paramInt, long paramLong)
  {
    writeTag(paramInt, 1);
    writeSFixed64NoTag(paramLong);
  }
  
  public void writeSFixed64NoTag(long paramLong)
  {
    writeRawLittleEndian64(paramLong);
  }
  
  public void writeSInt32(int paramInt1, int paramInt2)
  {
    writeTag(paramInt1, 0);
    writeSInt32NoTag(paramInt2);
  }
  
  public void writeSInt32NoTag(int paramInt)
  {
    writeRawVarint32(encodeZigZag32(paramInt));
  }
  
  public void writeSInt64(int paramInt, long paramLong)
  {
    writeTag(paramInt, 0);
    writeSInt64NoTag(paramLong);
  }
  
  public void writeSInt64NoTag(long paramLong)
  {
    writeRawVarint64(encodeZigZag64(paramLong));
  }
  
  public void writeString(int paramInt, String paramString)
  {
    writeTag(paramInt, 2);
    writeStringNoTag(paramString);
  }
  
  public void writeStringNoTag(String paramString)
  {
    int i;
    int j;
    try
    {
      i = computeRawVarint32Size(paramString.length());
      if (i != computeRawVarint32Size(paramString.length() * 3)) {
        break label150;
      }
      j = this.buffer.position();
      if (this.buffer.remaining() < i) {
        throw new CodedOutputByteBufferNano.OutOfSpaceException(i + j, this.buffer.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      CodedOutputByteBufferNano.OutOfSpaceException localOutOfSpaceException = new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
      localOutOfSpaceException.initCause(paramString);
      throw localOutOfSpaceException;
    }
    this.buffer.position(j + i);
    encode(paramString, this.buffer);
    int k = this.buffer.position();
    this.buffer.position(j);
    writeRawVarint32(k - j - i);
    this.buffer.position(k);
    return;
    label150:
    writeRawVarint32(encodedLength(paramString));
    encode(paramString, this.buffer);
  }
  
  public void writeTag(int paramInt1, int paramInt2)
  {
    writeRawVarint32(WireFormatNano.makeTag(paramInt1, paramInt2));
  }
  
  public void writeUInt32(int paramInt1, int paramInt2)
  {
    writeTag(paramInt1, 0);
    writeUInt32NoTag(paramInt2);
  }
  
  public void writeUInt32NoTag(int paramInt)
  {
    writeRawVarint32(paramInt);
  }
  
  public void writeUInt64(int paramInt, long paramLong)
  {
    writeTag(paramInt, 0);
    writeUInt64NoTag(paramLong);
  }
  
  public void writeUInt64NoTag(long paramLong)
  {
    writeRawVarint64(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.CodedOutputByteBufferNano
 * JD-Core Version:    0.7.0.1
 */