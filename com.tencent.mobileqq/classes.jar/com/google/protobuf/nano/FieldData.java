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
    FieldData localFieldData = new FieldData();
    AssertionError localAssertionError;
    try
    {
      localFieldData.cachedExtension = this.cachedExtension;
      if (this.unknownFieldData == null) {
        localFieldData.unknownFieldData = null;
      } else {
        localFieldData.unknownFieldData.addAll(this.unknownFieldData);
      }
      if (this.value == null) {
        return localFieldData;
      }
      if ((this.value instanceof MessageNano))
      {
        localFieldData.value = ((MessageNano)this.value).clone();
        return localFieldData;
      }
      if ((this.value instanceof byte[]))
      {
        localFieldData.value = ((byte[])this.value).clone();
        return localFieldData;
      }
      boolean bool = this.value instanceof byte[][];
      int j = 0;
      int i = 0;
      Object localObject1;
      Object localObject2;
      if (bool)
      {
        localObject1 = (byte[][])this.value;
        localObject2 = new byte[localObject1.length][];
        localFieldData.value = localObject2;
        while (i < localObject1.length)
        {
          localObject2[i] = ((byte[])localObject1[i].clone());
          i += 1;
        }
      }
      if ((this.value instanceof boolean[]))
      {
        localFieldData.value = ((boolean[])this.value).clone();
        return localFieldData;
      }
      if ((this.value instanceof int[]))
      {
        localFieldData.value = ((int[])this.value).clone();
        return localFieldData;
      }
      if ((this.value instanceof long[]))
      {
        localFieldData.value = ((long[])this.value).clone();
        return localFieldData;
      }
      if ((this.value instanceof float[]))
      {
        localFieldData.value = ((float[])this.value).clone();
        return localFieldData;
      }
      if ((this.value instanceof double[]))
      {
        localFieldData.value = ((double[])this.value).clone();
        return localFieldData;
      }
      if ((this.value instanceof MessageNano[]))
      {
        localObject1 = (MessageNano[])this.value;
        localObject2 = new MessageNano[localObject1.length];
        localFieldData.value = localObject2;
        i = j;
        while (i < localObject1.length)
        {
          localObject2[i] = localObject1[i].clone();
          i += 1;
        }
      }
      return localFieldData;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localAssertionError = new AssertionError(localCloneNotSupportedException);
    }
    for (;;)
    {
      throw localAssertionError;
    }
  }
  
  int computeSerializedSize()
  {
    Object localObject = this.value;
    if (localObject != null) {
      return this.cachedExtension.computeSerializedSize(localObject);
    }
    localObject = this.unknownFieldData.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      i += ((UnknownFieldData)((Iterator)localObject).next()).computeSerializedSize();
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FieldData)) {
      return false;
    }
    paramObject = (FieldData)paramObject;
    if ((this.value != null) && (paramObject.value != null))
    {
      localObject = this.cachedExtension;
      if (localObject != paramObject.cachedExtension) {
        return false;
      }
      if (!((Extension)localObject).clazz.isArray()) {
        return this.value.equals(paramObject.value);
      }
      localObject = this.value;
      if ((localObject instanceof byte[])) {
        return Arrays.equals((byte[])localObject, (byte[])paramObject.value);
      }
      if ((localObject instanceof int[])) {
        return Arrays.equals((int[])localObject, (int[])paramObject.value);
      }
      if ((localObject instanceof long[])) {
        return Arrays.equals((long[])localObject, (long[])paramObject.value);
      }
      if ((localObject instanceof float[])) {
        return Arrays.equals((float[])localObject, (float[])paramObject.value);
      }
      if ((localObject instanceof double[])) {
        return Arrays.equals((double[])localObject, (double[])paramObject.value);
      }
      if ((localObject instanceof boolean[])) {
        return Arrays.equals((boolean[])localObject, (boolean[])paramObject.value);
      }
      return Arrays.deepEquals((Object[])localObject, (Object[])paramObject.value);
    }
    Object localObject = this.unknownFieldData;
    if (localObject != null)
    {
      List localList = paramObject.unknownFieldData;
      if (localList != null) {
        return ((List)localObject).equals(localList);
      }
    }
    try
    {
      boolean bool = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
  }
  
  UnknownFieldData getUnknownField(int paramInt)
  {
    List localList = this.unknownFieldData;
    if (localList == null) {
      return null;
    }
    if (paramInt < localList.size()) {
      return (UnknownFieldData)this.unknownFieldData.get(paramInt);
    }
    return null;
  }
  
  int getUnknownFieldSize()
  {
    List localList = this.unknownFieldData;
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
      return 527 + i;
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
    Object localObject = this.value;
    if (localObject != null)
    {
      this.cachedExtension.writeTo(localObject, paramCodedOutputByteBufferNano);
      return;
    }
    localObject = this.unknownFieldData.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UnknownFieldData)((Iterator)localObject).next()).writeTo(paramCodedOutputByteBufferNano);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.FieldData
 * JD-Core Version:    0.7.0.1
 */