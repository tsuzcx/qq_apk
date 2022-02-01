package com.google.protobuf;

import java.util.List;

public enum Field$Kind
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
  public static final int TYPE_UNKNOWN_VALUE = 0;
  private static final Kind[] VALUES = values();
  private static final Internal.EnumLiteMap<Kind> internalValueMap;
  private final int value;
  
  static
  {
    TYPE_DOUBLE = new Kind("TYPE_DOUBLE", 1, 1);
    TYPE_FLOAT = new Kind("TYPE_FLOAT", 2, 2);
    TYPE_INT64 = new Kind("TYPE_INT64", 3, 3);
    TYPE_UINT64 = new Kind("TYPE_UINT64", 4, 4);
    TYPE_INT32 = new Kind("TYPE_INT32", 5, 5);
    TYPE_FIXED64 = new Kind("TYPE_FIXED64", 6, 6);
    TYPE_FIXED32 = new Kind("TYPE_FIXED32", 7, 7);
    TYPE_BOOL = new Kind("TYPE_BOOL", 8, 8);
    TYPE_STRING = new Kind("TYPE_STRING", 9, 9);
    TYPE_GROUP = new Kind("TYPE_GROUP", 10, 10);
    TYPE_MESSAGE = new Kind("TYPE_MESSAGE", 11, 11);
    TYPE_BYTES = new Kind("TYPE_BYTES", 12, 12);
    TYPE_UINT32 = new Kind("TYPE_UINT32", 13, 13);
    TYPE_ENUM = new Kind("TYPE_ENUM", 14, 14);
    TYPE_SFIXED32 = new Kind("TYPE_SFIXED32", 15, 15);
    TYPE_SFIXED64 = new Kind("TYPE_SFIXED64", 16, 16);
    TYPE_SINT32 = new Kind("TYPE_SINT32", 17, 17);
    TYPE_SINT64 = new Kind("TYPE_SINT64", 18, 18);
    UNRECOGNIZED = new Kind("UNRECOGNIZED", 19, -1);
    $VALUES = new Kind[] { TYPE_UNKNOWN, TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64, UNRECOGNIZED };
    internalValueMap = new Field.Kind.1();
  }
  
  private Field$Kind(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Kind forNumber(int paramInt)
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
    case 1: 
      return TYPE_DOUBLE;
    }
    return TYPE_UNKNOWN;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)Field.getDescriptor().j().get(0);
  }
  
  public static Internal.EnumLiteMap<Kind> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static Kind valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static Kind valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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
 * Qualified Name:     com.google.protobuf.Field.Kind
 * JD-Core Version:    0.7.0.1
 */