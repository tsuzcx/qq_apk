package com.google.protobuf.nano;

import java.io.IOException;
import java.lang.reflect.Array;

class Extension$PrimitiveExtension<M extends ExtendableMessageNano<M>, T>
  extends Extension<M, T>
{
  private final int nonPackedTag;
  private final int packedTag;
  
  public Extension$PrimitiveExtension(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramClass, paramInt2, paramBoolean, null);
    this.nonPackedTag = paramInt3;
    this.packedTag = paramInt4;
  }
  
  private int computePackedDataSize(Object paramObject)
  {
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int m = 0;
    int k = Array.getLength(paramObject);
    int i = k;
    switch (this.type)
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException("Unexpected non-packable type " + this.type);
    case 2: 
    case 7: 
    case 15: 
      i = k * 4;
    case 8: 
      return i;
    case 1: 
    case 6: 
    case 16: 
      return k * 8;
    case 5: 
      j = 0;
      for (i = m; j < k; i = m + i)
      {
        m = CodedOutputByteBufferNano.computeInt32SizeNoTag(Array.getInt(paramObject, j));
        j += 1;
      }
      return i;
    case 17: 
      j = 0;
      for (i = n; j < k; i = m + i)
      {
        m = CodedOutputByteBufferNano.computeSInt32SizeNoTag(Array.getInt(paramObject, j));
        j += 1;
      }
      return i;
    case 13: 
      j = 0;
      for (i = i1; j < k; i = m + i)
      {
        m = CodedOutputByteBufferNano.computeUInt32SizeNoTag(Array.getInt(paramObject, j));
        j += 1;
      }
      return i;
    case 3: 
      j = 0;
      for (i = i2; j < k; i = m + i)
      {
        m = CodedOutputByteBufferNano.computeInt64SizeNoTag(Array.getLong(paramObject, j));
        j += 1;
      }
      return i;
    case 18: 
      j = 0;
      for (i = i3; j < k; i = m + i)
      {
        m = CodedOutputByteBufferNano.computeSInt64SizeNoTag(Array.getLong(paramObject, j));
        j += 1;
      }
      return i;
    case 4: 
      j = 0;
      for (i = i4; j < k; i = m + i)
      {
        m = CodedOutputByteBufferNano.computeUInt64SizeNoTag(Array.getLong(paramObject, j));
        j += 1;
      }
      return i;
    }
    int j = 0;
    for (i = i5; j < k; i = m + i)
    {
      m = CodedOutputByteBufferNano.computeEnumSizeNoTag(Array.getInt(paramObject, j));
      j += 1;
    }
    return i;
  }
  
  protected int computeRepeatedSerializedSize(Object paramObject)
  {
    if (this.tag == this.nonPackedTag) {
      return super.computeRepeatedSerializedSize(paramObject);
    }
    if (this.tag == this.packedTag)
    {
      int i = computePackedDataSize(paramObject);
      return i + CodedOutputByteBufferNano.computeRawVarint32Size(i) + CodedOutputByteBufferNano.computeRawVarint32Size(this.tag);
    }
    throw new IllegalArgumentException("Unexpected repeated extension tag " + this.tag + ", unequal to both non-packed variant " + this.nonPackedTag + " and packed variant " + this.packedTag);
  }
  
  protected final int computeSingularSerializedSize(Object paramObject)
  {
    int i = WireFormatNano.getTagFieldNumber(this.tag);
    switch (this.type)
    {
    case 10: 
    case 11: 
    default: 
      throw new IllegalArgumentException("Unknown type " + this.type);
    case 1: 
      return CodedOutputByteBufferNano.computeDoubleSize(i, ((Double)paramObject).doubleValue());
    case 2: 
      return CodedOutputByteBufferNano.computeFloatSize(i, ((Float)paramObject).floatValue());
    case 3: 
      return CodedOutputByteBufferNano.computeInt64Size(i, ((Long)paramObject).longValue());
    case 4: 
      return CodedOutputByteBufferNano.computeUInt64Size(i, ((Long)paramObject).longValue());
    case 5: 
      return CodedOutputByteBufferNano.computeInt32Size(i, ((Integer)paramObject).intValue());
    case 6: 
      return CodedOutputByteBufferNano.computeFixed64Size(i, ((Long)paramObject).longValue());
    case 7: 
      return CodedOutputByteBufferNano.computeFixed32Size(i, ((Integer)paramObject).intValue());
    case 8: 
      return CodedOutputByteBufferNano.computeBoolSize(i, ((Boolean)paramObject).booleanValue());
    case 9: 
      return CodedOutputByteBufferNano.computeStringSize(i, (String)paramObject);
    case 12: 
      return CodedOutputByteBufferNano.computeBytesSize(i, (byte[])paramObject);
    case 13: 
      return CodedOutputByteBufferNano.computeUInt32Size(i, ((Integer)paramObject).intValue());
    case 14: 
      return CodedOutputByteBufferNano.computeEnumSize(i, ((Integer)paramObject).intValue());
    case 15: 
      return CodedOutputByteBufferNano.computeSFixed32Size(i, ((Integer)paramObject).intValue());
    case 16: 
      return CodedOutputByteBufferNano.computeSFixed64Size(i, ((Long)paramObject).longValue());
    case 17: 
      return CodedOutputByteBufferNano.computeSInt32Size(i, ((Integer)paramObject).intValue());
    }
    return CodedOutputByteBufferNano.computeSInt64Size(i, ((Long)paramObject).longValue());
  }
  
  protected Object readData(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    try
    {
      paramCodedInputByteBufferNano = paramCodedInputByteBufferNano.readPrimitiveField(this.type);
      return paramCodedInputByteBufferNano;
    }
    catch (IOException paramCodedInputByteBufferNano)
    {
      throw new IllegalArgumentException("Error reading extension field", paramCodedInputByteBufferNano);
    }
  }
  
  /* Error */
  protected void readDataInto(UnknownFieldData paramUnknownFieldData, java.util.List<Object> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 220	com/google/protobuf/nano/UnknownFieldData:tag	I
    //   4: aload_0
    //   5: getfield 15	com/google/protobuf/nano/Extension$PrimitiveExtension:nonPackedTag	I
    //   8: if_icmpne +22 -> 30
    //   11: aload_2
    //   12: aload_0
    //   13: aload_1
    //   14: getfield 223	com/google/protobuf/nano/UnknownFieldData:bytes	[B
    //   17: invokestatic 227	com/google/protobuf/nano/CodedInputByteBufferNano:newInstance	([B)Lcom/google/protobuf/nano/CodedInputByteBufferNano;
    //   20: invokevirtual 229	com/google/protobuf/nano/Extension$PrimitiveExtension:readData	(Lcom/google/protobuf/nano/CodedInputByteBufferNano;)Ljava/lang/Object;
    //   23: invokeinterface 235 2 0
    //   28: pop
    //   29: return
    //   30: aload_1
    //   31: getfield 223	com/google/protobuf/nano/UnknownFieldData:bytes	[B
    //   34: invokestatic 227	com/google/protobuf/nano/CodedInputByteBufferNano:newInstance	([B)Lcom/google/protobuf/nano/CodedInputByteBufferNano;
    //   37: astore_1
    //   38: aload_1
    //   39: aload_1
    //   40: invokevirtual 238	com/google/protobuf/nano/CodedInputByteBufferNano:readRawVarint32	()I
    //   43: invokevirtual 241	com/google/protobuf/nano/CodedInputByteBufferNano:pushLimit	(I)I
    //   46: pop
    //   47: aload_1
    //   48: invokevirtual 244	com/google/protobuf/nano/CodedInputByteBufferNano:isAtEnd	()Z
    //   51: ifne -22 -> 29
    //   54: aload_2
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 229	com/google/protobuf/nano/Extension$PrimitiveExtension:readData	(Lcom/google/protobuf/nano/CodedInputByteBufferNano;)Ljava/lang/Object;
    //   60: invokeinterface 235 2 0
    //   65: pop
    //   66: goto -19 -> 47
    //   69: astore_1
    //   70: new 32	java/lang/IllegalArgumentException
    //   73: dup
    //   74: ldc 212
    //   76: aload_1
    //   77: invokespecial 215	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	PrimitiveExtension
    //   0	81	1	paramUnknownFieldData	UnknownFieldData
    //   0	81	2	paramList	java.util.List<Object>
    // Exception table:
    //   from	to	target	type
    //   38	47	69	java/io/IOException
  }
  
  protected void writeRepeatedData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i = 0;
    if (this.tag == this.nonPackedTag)
    {
      super.writeRepeatedData(paramObject, paramCodedOutputByteBufferNano);
      return;
    }
    int i10;
    int i11;
    if (this.tag == this.packedTag)
    {
      i10 = Array.getLength(paramObject);
      i11 = computePackedDataSize(paramObject);
    }
    for (;;)
    {
      try
      {
        paramCodedOutputByteBufferNano.writeRawVarint32(this.tag);
        paramCodedOutputByteBufferNano.writeRawVarint32(i11);
        switch (this.type)
        {
        case 9: 
        case 10: 
        case 11: 
        case 12: 
          throw new IllegalArgumentException("Unpackable type " + this.type);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      while (i < i10)
      {
        paramCodedOutputByteBufferNano.writeBoolNoTag(Array.getBoolean(paramObject, i));
        i += 1;
      }
      break;
      while (j < i10)
      {
        paramCodedOutputByteBufferNano.writeFixed32NoTag(Array.getInt(paramObject, j));
        j += 1;
      }
      break;
      while (k < i10)
      {
        paramCodedOutputByteBufferNano.writeSFixed32NoTag(Array.getInt(paramObject, k));
        k += 1;
      }
      break;
      while (m < i10)
      {
        paramCodedOutputByteBufferNano.writeFloatNoTag(Array.getFloat(paramObject, m));
        m += 1;
      }
      break;
      while (n < i10)
      {
        paramCodedOutputByteBufferNano.writeFixed64NoTag(Array.getLong(paramObject, n));
        n += 1;
      }
      break;
      while (i1 < i10)
      {
        paramCodedOutputByteBufferNano.writeSFixed64NoTag(Array.getLong(paramObject, i1));
        i1 += 1;
      }
      break;
      while (i2 < i10)
      {
        paramCodedOutputByteBufferNano.writeDoubleNoTag(Array.getDouble(paramObject, i2));
        i2 += 1;
      }
      break;
      while (i3 < i10)
      {
        paramCodedOutputByteBufferNano.writeInt32NoTag(Array.getInt(paramObject, i3));
        i3 += 1;
      }
      break;
      while (i4 < i10)
      {
        paramCodedOutputByteBufferNano.writeSInt32NoTag(Array.getInt(paramObject, i4));
        i4 += 1;
      }
      break;
      while (i5 < i10)
      {
        paramCodedOutputByteBufferNano.writeUInt32NoTag(Array.getInt(paramObject, i5));
        i5 += 1;
      }
      break;
      while (i6 < i10)
      {
        paramCodedOutputByteBufferNano.writeInt64NoTag(Array.getLong(paramObject, i6));
        i6 += 1;
      }
      break;
      while (i7 < i10)
      {
        paramCodedOutputByteBufferNano.writeSInt64NoTag(Array.getLong(paramObject, i7));
        i7 += 1;
      }
      break;
      while (i8 < i10)
      {
        paramCodedOutputByteBufferNano.writeUInt64NoTag(Array.getLong(paramObject, i8));
        i8 += 1;
      }
      break;
      while (i9 < i10)
      {
        paramCodedOutputByteBufferNano.writeEnumNoTag(Array.getInt(paramObject, i9));
        i9 += 1;
      }
      break;
      throw new IllegalArgumentException("Unexpected repeated extension tag " + this.tag + ", unequal to both non-packed variant " + this.nonPackedTag + " and packed variant " + this.packedTag);
    }
  }
  
  protected final void writeSingularData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    for (;;)
    {
      try
      {
        paramCodedOutputByteBufferNano.writeRawVarint32(this.tag);
        switch (this.type)
        {
        case 10: 
        case 11: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      paramCodedOutputByteBufferNano.writeDoubleNoTag(((Double)paramObject).doubleValue());
      return;
      paramCodedOutputByteBufferNano.writeFloatNoTag(((Float)paramObject).floatValue());
      return;
      paramCodedOutputByteBufferNano.writeInt64NoTag(((Long)paramObject).longValue());
      return;
      paramCodedOutputByteBufferNano.writeUInt64NoTag(((Long)paramObject).longValue());
      return;
      paramCodedOutputByteBufferNano.writeInt32NoTag(((Integer)paramObject).intValue());
      return;
      paramCodedOutputByteBufferNano.writeFixed64NoTag(((Long)paramObject).longValue());
      return;
      paramCodedOutputByteBufferNano.writeFixed32NoTag(((Integer)paramObject).intValue());
      return;
      paramCodedOutputByteBufferNano.writeBoolNoTag(((Boolean)paramObject).booleanValue());
      return;
      paramCodedOutputByteBufferNano.writeStringNoTag((String)paramObject);
      return;
      paramCodedOutputByteBufferNano.writeBytesNoTag((byte[])paramObject);
      return;
      paramCodedOutputByteBufferNano.writeUInt32NoTag(((Integer)paramObject).intValue());
      return;
      paramCodedOutputByteBufferNano.writeEnumNoTag(((Integer)paramObject).intValue());
      return;
      paramCodedOutputByteBufferNano.writeSFixed32NoTag(((Integer)paramObject).intValue());
      return;
      paramCodedOutputByteBufferNano.writeSFixed64NoTag(((Long)paramObject).longValue());
      return;
      paramCodedOutputByteBufferNano.writeSInt32NoTag(((Integer)paramObject).intValue());
      return;
      paramCodedOutputByteBufferNano.writeSInt64NoTag(((Long)paramObject).longValue());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.Extension.PrimitiveExtension
 * JD-Core Version:    0.7.0.1
 */