package com.google.protobuf;

import java.util.List;

public enum NullValue
  implements ProtocolMessageEnum
{
  public static final int NULL_VALUE_VALUE = 0;
  private static final NullValue[] VALUES = values();
  private static final Internal.EnumLiteMap<NullValue> internalValueMap;
  private final int value;
  
  static
  {
    $VALUES = new NullValue[] { NULL_VALUE, UNRECOGNIZED };
    internalValueMap = new NullValue.1();
  }
  
  private NullValue(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static NullValue forNumber(int paramInt)
  {
    if (paramInt != 0) {
      return null;
    }
    return NULL_VALUE;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)StructProto.a().h().get(0);
  }
  
  public static Internal.EnumLiteMap<NullValue> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static NullValue valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static NullValue valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
  {
    if (paramEnumValueDescriptor.f() == getDescriptor())
    {
      if (paramEnumValueDescriptor.a() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[paramEnumValueDescriptor.a()];
    }
    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
  }
  
  public final Descriptors.EnumDescriptor getDescriptorForType()
  {
    return getDescriptor();
  }
  
  public final int getNumber()
  {
    if (this != UNRECOGNIZED) {
      return this.value;
    }
    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)getDescriptor().e().get(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.NullValue
 * JD-Core Version:    0.7.0.1
 */