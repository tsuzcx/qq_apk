package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbstractMessage
  extends AbstractMessageLite
  implements Message
{
  protected int memoizedSize = -1;
  
  private static boolean compareBytes(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
      return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
    }
    return toByteString(paramObject1).equals(toByteString(paramObject2));
  }
  
  static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> paramMap1, Map<Descriptors.FieldDescriptor, Object> paramMap2)
  {
    if (paramMap1.size() != paramMap2.size()) {
      return false;
    }
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Descriptors.FieldDescriptor)localIterator.next();
      if (!paramMap2.containsKey(localObject2)) {
        return false;
      }
      Object localObject3 = paramMap1.get(localObject2);
      Object localObject1 = paramMap2.get(localObject2);
      if (((Descriptors.FieldDescriptor)localObject2).i() == Descriptors.FieldDescriptor.Type.BYTES)
      {
        if (((Descriptors.FieldDescriptor)localObject2).p())
        {
          localObject2 = (List)localObject3;
          localObject1 = (List)localObject1;
          if (((List)localObject2).size() != ((List)localObject1).size()) {
            return false;
          }
          int i = 0;
          while (i < ((List)localObject2).size())
          {
            if (!compareBytes(((List)localObject2).get(i), ((List)localObject1).get(i))) {
              return false;
            }
            i += 1;
          }
        }
        else if (!compareBytes(localObject3, localObject1))
        {
          return false;
        }
      }
      else if (((Descriptors.FieldDescriptor)localObject2).m())
      {
        if (!compareMapField(localObject3, localObject1)) {
          return false;
        }
      }
      else if (!localObject3.equals(localObject1)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean compareMapField(Object paramObject1, Object paramObject2)
  {
    return MapFieldLite.equals(convertMapEntryListToMap((List)paramObject1), convertMapEntryListToMap((List)paramObject2));
  }
  
  private static Map convertMapEntryListToMap(List paramList)
  {
    if (paramList.isEmpty()) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    Message localMessage = (Message)localIterator.next();
    paramList = localMessage.getDescriptorForType();
    Descriptors.FieldDescriptor localFieldDescriptor1 = paramList.a("key");
    Descriptors.FieldDescriptor localFieldDescriptor2 = paramList.a("value");
    Object localObject = localMessage.getField(localFieldDescriptor2);
    paramList = localObject;
    if ((localObject instanceof Descriptors.EnumValueDescriptor)) {
      paramList = Integer.valueOf(((Descriptors.EnumValueDescriptor)localObject).getNumber());
    }
    localHashMap.put(localMessage.getField(localFieldDescriptor1), paramList);
    while (localIterator.hasNext())
    {
      localMessage = (Message)localIterator.next();
      localObject = localMessage.getField(localFieldDescriptor2);
      paramList = localObject;
      if ((localObject instanceof Descriptors.EnumValueDescriptor)) {
        paramList = Integer.valueOf(((Descriptors.EnumValueDescriptor)localObject).getNumber());
      }
      localHashMap.put(localMessage.getField(localFieldDescriptor1), paramList);
    }
    return localHashMap;
  }
  
  @Deprecated
  protected static int hashBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  @Deprecated
  protected static int hashEnum(Internal.EnumLite paramEnumLite)
  {
    return paramEnumLite.getNumber();
  }
  
  @Deprecated
  protected static int hashEnumList(List<? extends Internal.EnumLite> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = i * 31 + hashEnum((Internal.EnumLite)paramList.next())) {}
    return i;
  }
  
  protected static int hashFields(int paramInt, Map<Descriptors.FieldDescriptor, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = (Descriptors.FieldDescriptor)((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      paramInt = paramInt * 37 + ((Descriptors.FieldDescriptor)localObject1).f();
      int i;
      if (((Descriptors.FieldDescriptor)localObject1).m())
      {
        i = paramInt * 53;
        paramInt = hashMapField(localObject2);
      }
      for (;;)
      {
        paramInt = i + paramInt;
        break;
        if (((Descriptors.FieldDescriptor)localObject1).i() != Descriptors.FieldDescriptor.Type.ENUM)
        {
          i = paramInt * 53;
          paramInt = localObject2.hashCode();
        }
        else if (((Descriptors.FieldDescriptor)localObject1).p())
        {
          localObject1 = (List)localObject2;
          i = paramInt * 53;
          paramInt = Internal.a((List)localObject1);
        }
        else
        {
          i = paramInt * 53;
          paramInt = Internal.a((Internal.EnumLite)localObject2);
        }
      }
    }
    return paramInt;
  }
  
  @Deprecated
  protected static int hashLong(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  private static int hashMapField(Object paramObject)
  {
    return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List)paramObject));
  }
  
  private static ByteString toByteString(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return ByteString.copyFrom((byte[])paramObject);
    }
    return (ByteString)paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Message)) {
      return false;
    }
    paramObject = (Message)paramObject;
    if (getDescriptorForType() != paramObject.getDescriptorForType()) {
      return false;
    }
    return (compareFields(getAllFields(), paramObject.getAllFields())) && (getUnknownFields().equals(paramObject.getUnknownFields()));
  }
  
  public List<String> findInitializationErrors()
  {
    return MessageReflection.b(this);
  }
  
  public String getInitializationErrorString()
  {
    return MessageReflection.a(findInitializationErrors());
  }
  
  int getMemoizedSerializedSize()
  {
    return this.memoizedSize;
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    this.memoizedSize = MessageReflection.a(this, getAllFields());
    return this.memoizedSize;
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    throw new UnsupportedOperationException("hasOneof() is not implemented.");
  }
  
  public int hashCode()
  {
    int j = this.memoizedHashCode;
    int i = j;
    if (j == 0)
    {
      i = hashFields(779 + getDescriptorForType().hashCode(), getAllFields()) * 29 + getUnknownFields().hashCode();
      this.memoizedHashCode = i;
    }
    return i;
  }
  
  public boolean isInitialized()
  {
    return MessageReflection.a(this);
  }
  
  protected Message.Builder newBuilderForType(AbstractMessage.BuilderParent paramBuilderParent)
  {
    throw new UnsupportedOperationException("Nested builder is not supported for this type.");
  }
  
  UninitializedMessageException newUninitializedMessageException()
  {
    return AbstractMessage.Builder.newUninitializedMessageException(this);
  }
  
  void setMemoizedSerializedSize(int paramInt)
  {
    this.memoizedSize = paramInt;
  }
  
  public final String toString()
  {
    return TextFormat.a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    MessageReflection.a(this, getAllFields(), paramCodedOutputStream, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AbstractMessage
 * JD-Core Version:    0.7.0.1
 */