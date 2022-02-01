package com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$MethodOptions$IdempotencyLevel
  implements ProtocolMessageEnum
{
  public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
  public static final int IDEMPOTENT_VALUE = 2;
  public static final int NO_SIDE_EFFECTS_VALUE = 1;
  private static final IdempotencyLevel[] VALUES = values();
  private static final Internal.EnumLiteMap<IdempotencyLevel> internalValueMap;
  private final int value;
  
  static
  {
    IDEMPOTENT = new IdempotencyLevel("IDEMPOTENT", 2, 2);
    $VALUES = new IdempotencyLevel[] { IDEMPOTENCY_UNKNOWN, NO_SIDE_EFFECTS, IDEMPOTENT };
    internalValueMap = new DescriptorProtos.MethodOptions.IdempotencyLevel.1();
  }
  
  private DescriptorProtos$MethodOptions$IdempotencyLevel(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static IdempotencyLevel forNumber(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return IDEMPOTENT;
      }
      return NO_SIDE_EFFECTS;
    }
    return IDEMPOTENCY_UNKNOWN;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)DescriptorProtos.MethodOptions.getDescriptor().j().get(0);
  }
  
  public static Internal.EnumLiteMap<IdempotencyLevel> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static IdempotencyLevel valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static IdempotencyLevel valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel
 * JD-Core Version:    0.7.0.1
 */