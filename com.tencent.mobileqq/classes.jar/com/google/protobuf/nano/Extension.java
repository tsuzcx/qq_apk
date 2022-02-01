package com.google.protobuf.nano;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.google.protobuf.nano.UnknownFieldData;>;

public class Extension<M extends ExtendableMessageNano<M>, T>
{
  public static final int TYPE_BOOL = 8;
  public static final int TYPE_BYTES = 12;
  public static final int TYPE_DOUBLE = 1;
  public static final int TYPE_ENUM = 14;
  public static final int TYPE_FIXED32 = 7;
  public static final int TYPE_FIXED64 = 6;
  public static final int TYPE_FLOAT = 2;
  public static final int TYPE_GROUP = 10;
  public static final int TYPE_INT32 = 5;
  public static final int TYPE_INT64 = 3;
  public static final int TYPE_MESSAGE = 11;
  public static final int TYPE_SFIXED32 = 15;
  public static final int TYPE_SFIXED64 = 16;
  public static final int TYPE_SINT32 = 17;
  public static final int TYPE_SINT64 = 18;
  public static final int TYPE_STRING = 9;
  public static final int TYPE_UINT32 = 13;
  public static final int TYPE_UINT64 = 4;
  protected final Class<T> clazz;
  protected final boolean repeated;
  public final int tag;
  protected final int type;
  
  private Extension(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.clazz = paramClass;
    this.tag = paramInt2;
    this.repeated = paramBoolean;
  }
  
  @Deprecated
  public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T> createMessageTyped(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    return new Extension(paramInt1, paramClass, paramInt2, false);
  }
  
  public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T> createMessageTyped(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new Extension(paramInt, paramClass, (int)paramLong, false);
  }
  
  public static <M extends ExtendableMessageNano<M>, T> Extension<M, T> createPrimitiveTyped(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new Extension.PrimitiveExtension(paramInt, paramClass, (int)paramLong, false, 0, 0);
  }
  
  public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T[]> createRepeatedMessageTyped(int paramInt, Class<T[]> paramClass, long paramLong)
  {
    return new Extension(paramInt, paramClass, (int)paramLong, true);
  }
  
  public static <M extends ExtendableMessageNano<M>, T> Extension<M, T> createRepeatedPrimitiveTyped(int paramInt, Class<T> paramClass, long paramLong1, long paramLong2, long paramLong3)
  {
    return new Extension.PrimitiveExtension(paramInt, paramClass, (int)paramLong1, true, (int)paramLong2, (int)paramLong3);
  }
  
  private T getRepeatedValueFrom(List<UnknownFieldData> paramList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject = (UnknownFieldData)paramList.get(i);
      if (((UnknownFieldData)localObject).bytes.length != 0) {
        readDataInto((UnknownFieldData)localObject, localArrayList);
      }
      i += 1;
    }
    int k = localArrayList.size();
    if (k == 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = this.clazz.cast(Array.newInstance(this.clazz.getComponentType(), k));
    i = j;
    for (;;)
    {
      paramList = (List<UnknownFieldData>)localObject;
      if (i >= k) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  private T getSingularValueFrom(List<UnknownFieldData> paramList)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    paramList = (UnknownFieldData)paramList.get(paramList.size() - 1);
    return this.clazz.cast(readData(CodedInputByteBufferNano.newInstance(paramList.bytes)));
  }
  
  protected int computeRepeatedSerializedSize(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + computeSingularSerializedSize(Array.get(paramObject, i));
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  int computeSerializedSize(Object paramObject)
  {
    if (this.repeated) {
      return computeRepeatedSerializedSize(paramObject);
    }
    return computeSingularSerializedSize(paramObject);
  }
  
  protected int computeSingularSerializedSize(Object paramObject)
  {
    int i = WireFormatNano.getTagFieldNumber(this.tag);
    switch (this.type)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + this.type);
    case 10: 
      return CodedOutputByteBufferNano.computeGroupSize(i, (MessageNano)paramObject);
    }
    return CodedOutputByteBufferNano.computeMessageSize(i, (MessageNano)paramObject);
  }
  
  final T getValueFrom(List<UnknownFieldData> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (this.repeated) {
      return getRepeatedValueFrom(paramList);
    }
    return getSingularValueFrom(paramList);
  }
  
  protected Object readData(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    Class localClass;
    if (this.repeated) {
      localClass = this.clazz.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (InstantiationException paramCodedInputByteBufferNano)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramCodedInputByteBufferNano);
        localClass = this.clazz;
        continue;
        MessageNano localMessageNano = (MessageNano)localClass.newInstance();
        paramCodedInputByteBufferNano.readGroup(localMessageNano, WireFormatNano.getTagFieldNumber(this.tag));
        return localMessageNano;
        localMessageNano = (MessageNano)localClass.newInstance();
        paramCodedInputByteBufferNano.readMessage(localMessageNano);
        return localMessageNano;
      }
      catch (IllegalAccessException paramCodedInputByteBufferNano)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramCodedInputByteBufferNano);
      }
      catch (IOException paramCodedInputByteBufferNano)
      {
        throw new IllegalArgumentException("Error reading extension field", paramCodedInputByteBufferNano);
      }
    }
  }
  
  protected void readDataInto(UnknownFieldData paramUnknownFieldData, List<Object> paramList)
  {
    paramList.add(readData(CodedInputByteBufferNano.newInstance(paramUnknownFieldData.bytes)));
  }
  
  protected void writeRepeatedData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        writeSingularData(localObject, paramCodedOutputByteBufferNano);
      }
      i += 1;
    }
  }
  
  protected void writeSingularData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    for (;;)
    {
      try
      {
        paramCodedOutputByteBufferNano.writeRawVarint32(this.tag);
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      paramObject = (MessageNano)paramObject;
      int i = WireFormatNano.getTagFieldNumber(this.tag);
      paramCodedOutputByteBufferNano.writeGroupNoTag(paramObject);
      paramCodedOutputByteBufferNano.writeTag(i, 4);
      return;
      paramCodedOutputByteBufferNano.writeMessageNoTag((MessageNano)paramObject);
      return;
    }
  }
  
  void writeTo(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.repeated)
    {
      writeRepeatedData(paramObject, paramCodedOutputByteBufferNano);
      return;
    }
    writeSingularData(paramObject, paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.Extension
 * JD-Core Version:    0.7.0.1
 */