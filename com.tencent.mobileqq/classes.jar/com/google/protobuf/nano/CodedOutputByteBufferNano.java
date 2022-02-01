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
      paramObject = new StringBuilder();
      paramObject.append("Unknown type: ");
      paramObject.append(paramInt2);
      throw new IllegalArgumentException(paramObject.toString());
    case 18: 
      return computeSInt64Size(paramInt1, ((Long)paramObject).longValue());
    case 17: 
      return computeSInt32Size(paramInt1, ((Integer)paramObject).intValue());
    case 16: 
      return computeSFixed64Size(paramInt1, ((Long)paramObject).longValue());
    case 15: 
      return computeSFixed32Size(paramInt1, ((Integer)paramObject).intValue());
    case 14: 
      return computeEnumSize(paramInt1, ((Integer)paramObject).intValue());
    case 13: 
      return computeUInt32Size(paramInt1, ((Integer)paramObject).intValue());
    case 12: 
      return computeBytesSize(paramInt1, (byte[])paramObject);
    case 11: 
      return computeMessageSize(paramInt1, (MessageNano)paramObject);
    case 10: 
      return computeGroupSize(paramInt1, (MessageNano)paramObject);
    case 9: 
      return computeStringSize(paramInt1, (String)paramObject);
    case 8: 
      return computeBoolSize(paramInt1, ((Boolean)paramObject).booleanValue());
    case 7: 
      return computeFixed32Size(paramInt1, ((Integer)paramObject).intValue());
    case 6: 
      return computeFixed64Size(paramInt1, ((Long)paramObject).longValue());
    case 5: 
      return computeInt32Size(paramInt1, ((Integer)paramObject).intValue());
    case 4: 
      return computeUInt64Size(paramInt1, ((Long)paramObject).longValue());
    case 3: 
      return computeInt64Size(paramInt1, ((Long)paramObject).longValue());
    case 2: 
      return computeFloatSize(paramInt1, ((Float)paramObject).floatValue());
    }
    return computeDoubleSize(paramInt1, ((Double)paramObject).doubleValue());
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
    return computeRawVarint32Size(i) + i;
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
    if ((paramInt & 0xF0000000) == 0) {
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
    if ((paramLong & 0x0) == 0L) {
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
    return computeRawVarint32Size(i) + i;
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
    int m = paramInt2 + paramInt1;
    paramInt2 = 0;
    int n;
    while (paramInt2 < k)
    {
      j = paramInt2 + paramInt1;
      if (j >= m) {
        break;
      }
      n = paramCharSequence.charAt(paramInt2);
      if (n >= 128) {
        break;
      }
      paramArrayOfByte[j] = ((byte)n);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    int j = paramInt1 + paramInt2;
    paramInt1 = paramInt2;
    while (paramInt1 < k)
    {
      int i = paramCharSequence.charAt(paramInt1);
      if ((i < 128) && (j < m))
      {
        paramInt2 = j + 1;
        paramArrayOfByte[j] = ((byte)i);
      }
      for (;;)
      {
        break;
        if ((i < 2048) && (j <= m - 2))
        {
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(i >>> 6 | 0x3C0));
          paramInt2 = n + 1;
          paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
        }
        else if (((i < 55296) || (57343 < i)) && (j <= m - 3))
        {
          paramInt2 = j + 1;
          paramArrayOfByte[j] = ((byte)(i >>> 12 | 0x1E0));
          j = paramInt2 + 1;
          paramArrayOfByte[paramInt2] = ((byte)(i >>> 6 & 0x3F | 0x80));
          paramInt2 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          if (j > m - 4) {
            break label458;
          }
          paramInt2 = paramInt1 + 1;
          if (paramInt2 == paramCharSequence.length()) {
            break label422;
          }
          char c = paramCharSequence.charAt(paramInt2);
          if (!Character.isSurrogatePair(i, c)) {
            break label420;
          }
          paramInt1 = Character.toCodePoint(i, c);
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(paramInt1 >>> 18 | 0xF0));
          j = n + 1;
          paramArrayOfByte[n] = ((byte)(paramInt1 >>> 12 & 0x3F | 0x80));
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(paramInt1 >>> 6 & 0x3F | 0x80));
          j = n + 1;
          paramArrayOfByte[n] = ((byte)(paramInt1 & 0x3F | 0x80));
          paramInt1 = paramInt2;
          paramInt2 = j;
        }
      }
      paramInt1 += 1;
      j = paramInt2;
      continue;
      label420:
      paramInt1 = paramInt2;
      label422:
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("Unpaired surrogate at index ");
      paramCharSequence.append(paramInt1 - 1);
      throw new IllegalArgumentException(paramCharSequence.toString());
      label458:
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("Failed writing ");
      paramCharSequence.append(i);
      paramCharSequence.append(" at index ");
      paramCharSequence.append(j);
      throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
    }
    return j;
  }
  
  private static void encode(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (!paramByteBuffer.isReadOnly())
    {
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
      return;
    }
    throw new ReadOnlyBufferException();
  }
  
  private static void encodeDirect(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    while (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128)
      {
        paramByteBuffer.put((byte)i);
      }
      else if (i < 2048)
      {
        paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
        paramByteBuffer.put((byte)(i & 0x3F | 0x80));
      }
      else if ((i >= 55296) && (57343 >= i))
      {
        int k = j + 1;
        if (k != paramCharSequence.length())
        {
          char c = paramCharSequence.charAt(k);
          if (Character.isSurrogatePair(i, c))
          {
            j = Character.toCodePoint(i, c);
            paramByteBuffer.put((byte)(j >>> 18 | 0xF0));
            paramByteBuffer.put((byte)(j >>> 12 & 0x3F | 0x80));
            paramByteBuffer.put((byte)(j >>> 6 & 0x3F | 0x80));
            paramByteBuffer.put((byte)(j & 0x3F | 0x80));
            j = k;
          }
          else
          {
            j = k;
          }
        }
        else
        {
          paramCharSequence = new StringBuilder();
          paramCharSequence.append("Unpaired surrogate at index ");
          paramCharSequence.append(j - 1);
          throw new IllegalArgumentException(paramCharSequence.toString());
        }
      }
      else
      {
        paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
        paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
        paramByteBuffer.put((byte)(i & 0x3F | 0x80));
      }
      j += 1;
    }
  }
  
  public static int encodeZigZag32(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  public static long encodeZigZag64(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  private static int encodedLength(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int j = 0;
    while ((j < m) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    int i = m;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break label87;
      }
      k = paramCharSequence.charAt(j);
      if (k >= 2048) {
        break;
      }
      i += (127 - k >>> 31);
      j += 1;
    }
    int k = i + encodedLengthGeneral(paramCharSequence, j);
    label87:
    if (k >= m) {
      return k;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(k + 4294967296L);
    paramCharSequence = new IllegalArgumentException(paramCharSequence.toString());
    for (;;)
    {
      throw paramCharSequence;
    }
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      else
      {
        int k = i + 2;
        i = k;
        j = paramInt;
        if (55296 <= n)
        {
          i = k;
          j = paramInt;
          if (n <= 57343) {
            if (Character.codePointAt(paramCharSequence, paramInt) >= 65536)
            {
              j = paramInt + 1;
              i = k;
            }
            else
            {
              paramCharSequence = new StringBuilder();
              paramCharSequence.append("Unpaired surrogate at index ");
              paramCharSequence.append(paramInt);
              throw new IllegalArgumentException(paramCharSequence.toString());
            }
          }
        }
      }
      paramInt = j + 1;
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
    if (spaceLeft() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      paramObject = new StringBuilder();
      paramObject.append("Unknown type: ");
      paramObject.append(paramInt2);
      throw new IOException(paramObject.toString());
    case 18: 
      writeSInt64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 17: 
      writeSInt32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 16: 
      writeSFixed64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 15: 
      writeSFixed32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 14: 
      writeEnum(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 13: 
      writeUInt32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 12: 
      writeBytes(paramInt1, (byte[])paramObject);
      return;
    case 11: 
      writeMessage(paramInt1, (MessageNano)paramObject);
      return;
    case 10: 
      writeGroup(paramInt1, (MessageNano)paramObject);
      return;
    case 9: 
      writeString(paramInt1, (String)paramObject);
      return;
    case 8: 
      writeBool(paramInt1, ((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      writeFixed32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 6: 
      writeFixed64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 5: 
      writeInt32(paramInt1, ((Integer)paramObject).intValue());
      return;
    case 4: 
      writeUInt64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 3: 
      writeInt64(paramInt1, ((Long)paramObject).longValue());
      return;
    case 2: 
      writeFloat(paramInt1, ((Float)paramObject).floatValue());
      return;
    }
    writeDouble(paramInt1, ((Double)paramObject).doubleValue());
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
    if (this.buffer.hasRemaining())
    {
      this.buffer.put(paramByte);
      return;
    }
    throw new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
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
    if (this.buffer.remaining() >= 4)
    {
      this.buffer.putInt(paramInt);
      return;
    }
    throw new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
  }
  
  public void writeRawLittleEndian64(long paramLong)
  {
    if (this.buffer.remaining() >= 8)
    {
      this.buffer.putLong(paramLong);
      return;
    }
    throw new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
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
    try
    {
      int i = computeRawVarint32Size(paramString.length());
      if (i == computeRawVarint32Size(paramString.length() * 3))
      {
        int j = this.buffer.position();
        if (this.buffer.remaining() >= i)
        {
          this.buffer.position(j + i);
          encode(paramString, this.buffer);
          int k = this.buffer.position();
          this.buffer.position(j);
          writeRawVarint32(k - j - i);
          this.buffer.position(k);
          return;
        }
        throw new CodedOutputByteBufferNano.OutOfSpaceException(j + i, this.buffer.limit());
      }
      writeRawVarint32(encodedLength(paramString));
      encode(paramString, this.buffer);
      return;
    }
    catch (BufferOverflowException paramString)
    {
      CodedOutputByteBufferNano.OutOfSpaceException localOutOfSpaceException = new CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
      localOutOfSpaceException.initCause(paramString);
      throw localOutOfSpaceException;
    }
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