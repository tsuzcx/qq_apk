package com.google.protobuf;

import java.util.List;

public enum Syntax
  implements ProtocolMessageEnum
{
  public static final int SYNTAX_PROTO2_VALUE = 0;
  public static final int SYNTAX_PROTO3_VALUE = 1;
  private static final Syntax[] VALUES = values();
  private static final Internal.EnumLiteMap<Syntax> internalValueMap;
  private final int value;
  
  static
  {
    $VALUES = new Syntax[] { SYNTAX_PROTO2, SYNTAX_PROTO3, UNRECOGNIZED };
    internalValueMap = new Syntax.1();
  }
  
  private Syntax(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Syntax forNumber(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return SYNTAX_PROTO3;
    }
    return SYNTAX_PROTO2;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)TypeProto.a().h().get(0);
  }
  
  public static Internal.EnumLiteMap<Syntax> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static Syntax valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static Syntax valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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
 * Qualified Name:     com.google.protobuf.Syntax
 * JD-Core Version:    0.7.0.1
 */