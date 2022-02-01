package com.google.protobuf;

import java.util.List;

public enum Field$Cardinality
  implements ProtocolMessageEnum
{
  public static final int CARDINALITY_OPTIONAL_VALUE = 1;
  public static final int CARDINALITY_REPEATED_VALUE = 3;
  public static final int CARDINALITY_REQUIRED_VALUE = 2;
  public static final int CARDINALITY_UNKNOWN_VALUE = 0;
  private static final Cardinality[] VALUES = values();
  private static final Internal.EnumLiteMap<Cardinality> internalValueMap;
  private final int value;
  
  static
  {
    CARDINALITY_OPTIONAL = new Cardinality("CARDINALITY_OPTIONAL", 1, 1);
    CARDINALITY_REQUIRED = new Cardinality("CARDINALITY_REQUIRED", 2, 2);
    CARDINALITY_REPEATED = new Cardinality("CARDINALITY_REPEATED", 3, 3);
    UNRECOGNIZED = new Cardinality("UNRECOGNIZED", 4, -1);
    $VALUES = new Cardinality[] { CARDINALITY_UNKNOWN, CARDINALITY_OPTIONAL, CARDINALITY_REQUIRED, CARDINALITY_REPEATED, UNRECOGNIZED };
    internalValueMap = new Field.Cardinality.1();
  }
  
  private Field$Cardinality(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Cardinality forNumber(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return CARDINALITY_REPEATED;
        }
        return CARDINALITY_REQUIRED;
      }
      return CARDINALITY_OPTIONAL;
    }
    return CARDINALITY_UNKNOWN;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)Field.getDescriptor().j().get(1);
  }
  
  public static Internal.EnumLiteMap<Cardinality> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static Cardinality valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static Cardinality valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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
 * Qualified Name:     com.google.protobuf.Field.Cardinality
 * JD-Core Version:    0.7.0.1
 */