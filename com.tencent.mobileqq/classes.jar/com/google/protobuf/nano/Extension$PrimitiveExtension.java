package com.google.protobuf.nano;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

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
    int m = Array.getLength(paramObject);
    int i5 = this.type;
    int j = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int k = 0;
    int i = m;
    switch (i5)
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      paramObject = new StringBuilder();
      paramObject.append("Unexpected non-packable type ");
      paramObject.append(this.type);
      throw new IllegalArgumentException(paramObject.toString());
    case 18: 
      j = 0;
      for (;;)
      {
        i = j;
        if (k >= m) {
          break;
        }
        j += CodedOutputByteBufferNano.computeSInt64SizeNoTag(Array.getLong(paramObject, k));
        k += 1;
      }
    case 17: 
      i = 0;
      k = j;
      j = i;
      for (;;)
      {
        i = j;
        if (k >= m) {
          break;
        }
        j += CodedOutputByteBufferNano.computeSInt32SizeNoTag(Array.getInt(paramObject, k));
        k += 1;
      }
    case 14: 
      j = 0;
      k = n;
      for (;;)
      {
        i = j;
        if (k >= m) {
          break;
        }
        j += CodedOutputByteBufferNano.computeEnumSizeNoTag(Array.getInt(paramObject, k));
        k += 1;
      }
    case 13: 
      j = 0;
      k = i1;
      for (;;)
      {
        i = j;
        if (k >= m) {
          break;
        }
        j += CodedOutputByteBufferNano.computeUInt32SizeNoTag(Array.getInt(paramObject, k));
        k += 1;
      }
    case 5: 
      j = 0;
      k = i2;
      for (;;)
      {
        i = j;
        if (k >= m) {
          break;
        }
        j += CodedOutputByteBufferNano.computeInt32SizeNoTag(Array.getInt(paramObject, k));
        k += 1;
      }
    case 4: 
      j = 0;
      k = i3;
      for (;;)
      {
        i = j;
        if (k >= m) {
          break;
        }
        j += CodedOutputByteBufferNano.computeUInt64SizeNoTag(Array.getLong(paramObject, k));
        k += 1;
      }
    case 3: 
      j = 0;
      k = i4;
      for (;;)
      {
        i = j;
        if (k >= m) {
          break;
        }
        j += CodedOutputByteBufferNano.computeInt64SizeNoTag(Array.getLong(paramObject, k));
        k += 1;
      }
    case 2: 
    case 7: 
    case 15: 
      i = m * 4;
      break;
    case 1: 
    case 6: 
    case 16: 
      i = m * 8;
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
    paramObject = new StringBuilder();
    paramObject.append("Unexpected repeated extension tag ");
    paramObject.append(this.tag);
    paramObject.append(", unequal to both non-packed variant ");
    paramObject.append(this.nonPackedTag);
    paramObject.append(" and packed variant ");
    paramObject.append(this.packedTag);
    throw new IllegalArgumentException(paramObject.toString());
  }
  
  protected final int computeSingularSerializedSize(Object paramObject)
  {
    int i = WireFormatNano.getTagFieldNumber(this.tag);
    switch (this.type)
    {
    case 10: 
    case 11: 
    default: 
      paramObject = new StringBuilder();
      paramObject.append("Unknown type ");
      paramObject.append(this.type);
      throw new IllegalArgumentException(paramObject.toString());
    case 18: 
      return CodedOutputByteBufferNano.computeSInt64Size(i, ((Long)paramObject).longValue());
    case 17: 
      return CodedOutputByteBufferNano.computeSInt32Size(i, ((Integer)paramObject).intValue());
    case 16: 
      return CodedOutputByteBufferNano.computeSFixed64Size(i, ((Long)paramObject).longValue());
    case 15: 
      return CodedOutputByteBufferNano.computeSFixed32Size(i, ((Integer)paramObject).intValue());
    case 14: 
      return CodedOutputByteBufferNano.computeEnumSize(i, ((Integer)paramObject).intValue());
    case 13: 
      return CodedOutputByteBufferNano.computeUInt32Size(i, ((Integer)paramObject).intValue());
    case 12: 
      return CodedOutputByteBufferNano.computeBytesSize(i, (byte[])paramObject);
    case 9: 
      return CodedOutputByteBufferNano.computeStringSize(i, (String)paramObject);
    case 8: 
      return CodedOutputByteBufferNano.computeBoolSize(i, ((Boolean)paramObject).booleanValue());
    case 7: 
      return CodedOutputByteBufferNano.computeFixed32Size(i, ((Integer)paramObject).intValue());
    case 6: 
      return CodedOutputByteBufferNano.computeFixed64Size(i, ((Long)paramObject).longValue());
    case 5: 
      return CodedOutputByteBufferNano.computeInt32Size(i, ((Integer)paramObject).intValue());
    case 4: 
      return CodedOutputByteBufferNano.computeUInt64Size(i, ((Long)paramObject).longValue());
    case 3: 
      return CodedOutputByteBufferNano.computeInt64Size(i, ((Long)paramObject).longValue());
    case 2: 
      return CodedOutputByteBufferNano.computeFloatSize(i, ((Float)paramObject).floatValue());
    }
    return CodedOutputByteBufferNano.computeDoubleSize(i, ((Double)paramObject).doubleValue());
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
  
  protected void readDataInto(UnknownFieldData paramUnknownFieldData, List<Object> paramList)
  {
    if (paramUnknownFieldData.tag == this.nonPackedTag)
    {
      paramList.add(readData(CodedInputByteBufferNano.newInstance(paramUnknownFieldData.bytes)));
      return;
    }
    paramUnknownFieldData = CodedInputByteBufferNano.newInstance(paramUnknownFieldData.bytes);
    try
    {
      paramUnknownFieldData.pushLimit(paramUnknownFieldData.readRawVarint32());
      while (!paramUnknownFieldData.isAtEnd()) {
        paramList.add(readData(paramUnknownFieldData));
      }
      return;
    }
    catch (IOException paramUnknownFieldData)
    {
      paramUnknownFieldData = new IllegalArgumentException("Error reading extension field", paramUnknownFieldData);
    }
    for (;;)
    {
      throw paramUnknownFieldData;
    }
  }
  
  protected void writeRepeatedData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.tag == this.nonPackedTag)
    {
      super.writeRepeatedData(paramObject, paramCodedOutputByteBufferNano);
      return;
    }
    int i10;
    int i;
    if (this.tag == this.packedTag)
    {
      i10 = Array.getLength(paramObject);
      i = computePackedDataSize(paramObject);
    }
    for (;;)
    {
      try
      {
        paramCodedOutputByteBufferNano.writeRawVarint32(this.tag);
        paramCodedOutputByteBufferNano.writeRawVarint32(i);
        int i11 = this.type;
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
        i = 0;
        switch (i11)
        {
        case 9: 
        case 10: 
        case 11: 
        case 12: 
          break;
        case 18: 
          if (i >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeSInt64NoTag(Array.getLong(paramObject, i));
          i += 1;
          break;
        case 17: 
          if (j >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeSInt32NoTag(Array.getInt(paramObject, j));
          j += 1;
          break;
        case 16: 
          if (k >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeSFixed64NoTag(Array.getLong(paramObject, k));
          k += 1;
          break;
        case 15: 
          if (m >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeSFixed32NoTag(Array.getInt(paramObject, m));
          m += 1;
          break;
        case 14: 
          if (n >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeEnumNoTag(Array.getInt(paramObject, n));
          n += 1;
          break;
        case 13: 
          if (i1 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeUInt32NoTag(Array.getInt(paramObject, i1));
          i1 += 1;
          break;
        case 8: 
          if (i2 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeBoolNoTag(Array.getBoolean(paramObject, i2));
          i2 += 1;
          break;
        case 7: 
          if (i3 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeFixed32NoTag(Array.getInt(paramObject, i3));
          i3 += 1;
          break;
        case 6: 
          if (i4 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeFixed64NoTag(Array.getLong(paramObject, i4));
          i4 += 1;
          break;
        case 5: 
          if (i5 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeInt32NoTag(Array.getInt(paramObject, i5));
          i5 += 1;
          break;
        case 4: 
          if (i6 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeUInt64NoTag(Array.getLong(paramObject, i6));
          i6 += 1;
          break;
        case 3: 
          if (i7 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeInt64NoTag(Array.getLong(paramObject, i7));
          i7 += 1;
          break;
        case 2: 
          if (i8 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeFloatNoTag(Array.getFloat(paramObject, i8));
          i8 += 1;
          break;
        case 1: 
          if (i9 >= i10) {
            return;
          }
          paramCodedOutputByteBufferNano.writeDoubleNoTag(Array.getDouble(paramObject, i9));
          i9 += 1;
          continue;
          paramObject = new StringBuilder();
          paramObject.append("Unpackable type ");
          paramObject.append(this.type);
          throw new IllegalArgumentException(paramObject.toString());
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      paramObject = new StringBuilder();
      paramObject.append("Unexpected repeated extension tag ");
      paramObject.append(this.tag);
      paramObject.append(", unequal to both non-packed variant ");
      paramObject.append(this.nonPackedTag);
      paramObject.append(" and packed variant ");
      paramObject.append(this.packedTag);
      paramObject = new IllegalArgumentException(paramObject.toString());
      for (;;)
      {
        throw paramObject;
      }
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
          break;
        case 18: 
          paramCodedOutputByteBufferNano.writeSInt64NoTag(((Long)paramObject).longValue());
          return;
        case 17: 
          paramCodedOutputByteBufferNano.writeSInt32NoTag(((Integer)paramObject).intValue());
          return;
        case 16: 
          paramCodedOutputByteBufferNano.writeSFixed64NoTag(((Long)paramObject).longValue());
          return;
        case 15: 
          paramCodedOutputByteBufferNano.writeSFixed32NoTag(((Integer)paramObject).intValue());
          return;
        case 14: 
          paramCodedOutputByteBufferNano.writeEnumNoTag(((Integer)paramObject).intValue());
          return;
        case 13: 
          paramCodedOutputByteBufferNano.writeUInt32NoTag(((Integer)paramObject).intValue());
          return;
        case 12: 
          paramCodedOutputByteBufferNano.writeBytesNoTag((byte[])paramObject);
          return;
        case 9: 
          paramCodedOutputByteBufferNano.writeStringNoTag((String)paramObject);
          return;
        case 8: 
          paramCodedOutputByteBufferNano.writeBoolNoTag(((Boolean)paramObject).booleanValue());
          return;
        case 7: 
          paramCodedOutputByteBufferNano.writeFixed32NoTag(((Integer)paramObject).intValue());
          return;
        case 6: 
          paramCodedOutputByteBufferNano.writeFixed64NoTag(((Long)paramObject).longValue());
          return;
        case 5: 
          paramCodedOutputByteBufferNano.writeInt32NoTag(((Integer)paramObject).intValue());
          return;
        case 4: 
          paramCodedOutputByteBufferNano.writeUInt64NoTag(((Long)paramObject).longValue());
          return;
        case 3: 
          paramCodedOutputByteBufferNano.writeInt64NoTag(((Long)paramObject).longValue());
          return;
        case 2: 
          paramCodedOutputByteBufferNano.writeFloatNoTag(((Float)paramObject).floatValue());
          return;
        case 1: 
          paramCodedOutputByteBufferNano.writeDoubleNoTag(((Double)paramObject).doubleValue());
          return;
          paramObject = new StringBuilder();
          paramObject.append("Unknown type ");
          paramObject.append(this.type);
          throw new IllegalArgumentException(paramObject.toString());
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.protobuf.nano.Extension.PrimitiveExtension
 * JD-Core Version:    0.7.0.1
 */