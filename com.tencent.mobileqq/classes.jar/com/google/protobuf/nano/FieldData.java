package com.google.protobuf.nano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class FieldData
  implements Cloneable
{
  private Extension<?, ?> cachedExtension;
  private List<UnknownFieldData> unknownFieldData;
  private Object value;
  
  FieldData()
  {
    this.unknownFieldData = new ArrayList();
  }
  
  <T> FieldData(Extension<?, T> paramExtension, T paramT)
  {
    this.cachedExtension = paramExtension;
    this.value = paramT;
  }
  
  private byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[computeSerializedSize()];
    writeTo(CodedOutputByteBufferNano.newInstance(arrayOfByte));
    return arrayOfByte;
  }
  
  void addUnknownField(UnknownFieldData paramUnknownFieldData)
  {
    this.unknownFieldData.add(paramUnknownFieldData);
  }
  
  public final FieldData clone()
  {
    int i = 0;
    FieldData localFieldData = new FieldData();
    try
    {
      localFieldData.cachedExtension = this.cachedExtension;
      if (this.unknownFieldData == null) {
        localFieldData.unknownFieldData = null;
      }
      while (this.value == null)
      {
        return localFieldData;
        localFieldData.unknownFieldData.addAll(this.unknownFieldData);
      }
      if (!(this.value instanceof MessageNano)) {
        break label92;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    localCloneNotSupportedException.value = ((MessageNano)this.value).clone();
    return localCloneNotSupportedException;
    label92:
    if ((this.value instanceof byte[]))
    {
      localCloneNotSupportedException.value = ((byte[])this.value).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    if ((this.value instanceof byte[][]))
    {
      localObject1 = (byte[][])this.value;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.value instanceof boolean[]))
    {
      localCloneNotSupportedException.value = ((boolean[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof int[]))
    {
      localCloneNotSupportedException.value = ((int[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof long[]))
    {
      localCloneNotSupportedException.value = ((long[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof float[]))
    {
      localCloneNotSupportedException.value = ((float[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof double[]))
    {
      localCloneNotSupportedException.value = ((double[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof MessageNano[]))
    {
      localObject1 = (MessageNano[])this.value;
      localObject2 = new MessageNano[localObject1.length];
      localCloneNotSupportedException.value = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].clone();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  int computeSerializedSize()
  {
    int j;
    if (this.value != null)
    {
      j = this.cachedExtension.computeSerializedSize(this.value);
      return j;
    }
    Iterator localIterator = this.unknownFieldData.iterator();
    for (int i = 0;; i = ((UnknownFieldData)localIterator.next()).computeSerializedSize() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof FieldData));
      paramObject = (FieldData)paramObject;
      if ((this.value == null) || (paramObject.value == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.cachedExtension != paramObject.cachedExtension);
    if (!this.cachedExtension.clazz.isArray()) {
      return this.value.equals(paramObject.value);
    }
    if ((this.value instanceof byte[])) {
      return Arrays.equals((byte[])this.value, (byte[])paramObject.value);
    }
    if ((this.value instanceof int[])) {
      return Arrays.equals((int[])this.value, (int[])paramObject.value);
    }
    if ((this.value instanceof long[])) {
      return Arrays.equals((long[])this.value, (long[])paramObject.value);
    }
    if ((this.value instanceof float[])) {
      return Arrays.equals((float[])this.value, (float[])paramObject.value);
    }
    if ((this.value instanceof double[])) {
      return Arrays.equals((double[])this.value, (double[])paramObject.value);
    }
    if ((this.value instanceof boolean[])) {
      return Arrays.equals((boolean[])this.value, (boolean[])paramObject.value);
    }
    return Arrays.deepEquals((Object[])this.value, (Object[])paramObject.value);
    if ((this.unknownFieldData != null) && (paramObject.unknownFieldData != null)) {
      return this.unknownFieldData.equals(paramObject.unknownFieldData);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
  }
  
  UnknownFieldData getUnknownField(int paramInt)
  {
    if (this.unknownFieldData == null) {}
    while (paramInt >= this.unknownFieldData.size()) {
      return null;
    }
    return (UnknownFieldData)this.unknownFieldData.get(paramInt);
  }
  
  int getUnknownFieldSize()
  {
    if (this.unknownFieldData == null) {
      return 0;
    }
    return this.unknownFieldData.size();
  }
  
  <T> T getValue(Extension<?, T> paramExtension)
  {
    if (this.value != null)
    {
      if (this.cachedExtension != paramExtension) {
        throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
      }
    }
    else
    {
      this.cachedExtension = paramExtension;
      this.value = paramExtension.getValueFrom(this.unknownFieldData);
      this.unknownFieldData = null;
    }
    return this.value;
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  <T> void setValue(Extension<?, T> paramExtension, T paramT)
  {
    this.cachedExtension = paramExtension;
    this.value = paramT;
    this.unknownFieldData = null;
  }
  
  void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.value != null) {
      this.cachedExtension.writeTo(this.value, paramCodedOutputByteBufferNano);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.unknownFieldData.iterator();
      while (localIterator.hasNext()) {
        ((UnknownFieldData)localIterator.next()).writeTo(paramCodedOutputByteBufferNano);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.FieldData
 * JD-Core Version:    0.7.0.1
 */