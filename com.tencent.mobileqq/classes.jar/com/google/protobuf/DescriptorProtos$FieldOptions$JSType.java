package com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$FieldOptions$JSType
  implements ProtocolMessageEnum
{
  public static final int JS_NORMAL_VALUE = 0;
  public static final int JS_NUMBER_VALUE = 2;
  public static final int JS_STRING_VALUE = 1;
  private static final JSType[] VALUES = values();
  private static final Internal.EnumLiteMap<JSType> internalValueMap;
  private final int value;
  
  static
  {
    JS_NUMBER = new JSType("JS_NUMBER", 2, 2);
    $VALUES = new JSType[] { JS_NORMAL, JS_STRING, JS_NUMBER };
    internalValueMap = new DescriptorProtos.FieldOptions.JSType.1();
  }
  
  private DescriptorProtos$FieldOptions$JSType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static JSType forNumber(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return JS_NUMBER;
      }
      return JS_STRING;
    }
    return JS_NORMAL;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)DescriptorProtos.FieldOptions.getDescriptor().j().get(1);
  }
  
  public static Internal.EnumLiteMap<JSType> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static JSType valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static JSType valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
  {
    if (paramEnumValueDescriptor.f() == getDescriptor()) {
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
    return this.value;
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)getDescriptor().e().get(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FieldOptions.JSType
 * JD-Core Version:    0.7.0.1
 */