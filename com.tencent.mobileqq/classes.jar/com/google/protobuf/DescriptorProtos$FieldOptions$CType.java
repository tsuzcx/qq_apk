package com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$FieldOptions$CType
  implements ProtocolMessageEnum
{
  public static final int CORD_VALUE = 1;
  public static final int STRING_PIECE_VALUE = 2;
  public static final int STRING_VALUE = 0;
  private static final CType[] VALUES = values();
  private static final Internal.EnumLiteMap<CType> internalValueMap;
  private final int value;
  
  static
  {
    CORD = new CType("CORD", 1, 1);
    STRING_PIECE = new CType("STRING_PIECE", 2, 2);
    $VALUES = new CType[] { STRING, CORD, STRING_PIECE };
    internalValueMap = new DescriptorProtos.FieldOptions.CType.1();
  }
  
  private DescriptorProtos$FieldOptions$CType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static CType forNumber(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return STRING_PIECE;
      }
      return CORD;
    }
    return STRING;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)DescriptorProtos.FieldOptions.getDescriptor().j().get(0);
  }
  
  public static Internal.EnumLiteMap<CType> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static CType valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static CType valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FieldOptions.CType
 * JD-Core Version:    0.7.0.1
 */