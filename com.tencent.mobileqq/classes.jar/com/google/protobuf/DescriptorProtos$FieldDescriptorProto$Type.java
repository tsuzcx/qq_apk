package com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$FieldDescriptorProto$Type
  implements ProtocolMessageEnum
{
  public static final int TYPE_BOOL_VALUE = 8;
  public static final int TYPE_BYTES_VALUE = 12;
  public static final int TYPE_DOUBLE_VALUE = 1;
  public static final int TYPE_ENUM_VALUE = 14;
  public static final int TYPE_FIXED32_VALUE = 7;
  public static final int TYPE_FIXED64_VALUE = 6;
  public static final int TYPE_FLOAT_VALUE = 2;
  public static final int TYPE_GROUP_VALUE = 10;
  public static final int TYPE_INT32_VALUE = 5;
  public static final int TYPE_INT64_VALUE = 3;
  public static final int TYPE_MESSAGE_VALUE = 11;
  public static final int TYPE_SFIXED32_VALUE = 15;
  public static final int TYPE_SFIXED64_VALUE = 16;
  public static final int TYPE_SINT32_VALUE = 17;
  public static final int TYPE_SINT64_VALUE = 18;
  public static final int TYPE_STRING_VALUE = 9;
  public static final int TYPE_UINT32_VALUE = 13;
  public static final int TYPE_UINT64_VALUE = 4;
  private static final Type[] VALUES = values();
  private static final Internal.EnumLiteMap<Type> internalValueMap;
  private final int value;
  
  static
  {
    TYPE_INT32 = new Type("TYPE_INT32", 4, 5);
    TYPE_FIXED64 = new Type("TYPE_FIXED64", 5, 6);
    TYPE_FIXED32 = new Type("TYPE_FIXED32", 6, 7);
    TYPE_BOOL = new Type("TYPE_BOOL", 7, 8);
    TYPE_STRING = new Type("TYPE_STRING", 8, 9);
    TYPE_GROUP = new Type("TYPE_GROUP", 9, 10);
    TYPE_MESSAGE = new Type("TYPE_MESSAGE", 10, 11);
    TYPE_BYTES = new Type("TYPE_BYTES", 11, 12);
    TYPE_UINT32 = new Type("TYPE_UINT32", 12, 13);
    TYPE_ENUM = new Type("TYPE_ENUM", 13, 14);
    TYPE_SFIXED32 = new Type("TYPE_SFIXED32", 14, 15);
    TYPE_SFIXED64 = new Type("TYPE_SFIXED64", 15, 16);
    TYPE_SINT32 = new Type("TYPE_SINT32", 16, 17);
    TYPE_SINT64 = new Type("TYPE_SINT64", 17, 18);
    $VALUES = new Type[] { TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64 };
    internalValueMap = new DescriptorProtos.FieldDescriptorProto.Type.1();
  }
  
  private DescriptorProtos$FieldDescriptorProto$Type(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Type forNumber(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 18: 
      return TYPE_SINT64;
    case 17: 
      return TYPE_SINT32;
    case 16: 
      return TYPE_SFIXED64;
    case 15: 
      return TYPE_SFIXED32;
    case 14: 
      return TYPE_ENUM;
    case 13: 
      return TYPE_UINT32;
    case 12: 
      return TYPE_BYTES;
    case 11: 
      return TYPE_MESSAGE;
    case 10: 
      return TYPE_GROUP;
    case 9: 
      return TYPE_STRING;
    case 8: 
      return TYPE_BOOL;
    case 7: 
      return TYPE_FIXED32;
    case 6: 
      return TYPE_FIXED64;
    case 5: 
      return TYPE_INT32;
    case 4: 
      return TYPE_UINT64;
    case 3: 
      return TYPE_INT64;
    case 2: 
      return TYPE_FLOAT;
    }
    return TYPE_DOUBLE;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().j().get(0);
  }
  
  public static Internal.EnumLiteMap<Type> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static Type valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static Type valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type
 * JD-Core Version:    0.7.0.1
 */