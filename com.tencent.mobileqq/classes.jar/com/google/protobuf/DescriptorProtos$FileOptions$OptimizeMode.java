package com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$FileOptions$OptimizeMode
  implements ProtocolMessageEnum
{
  public static final int CODE_SIZE_VALUE = 2;
  public static final int LITE_RUNTIME_VALUE = 3;
  public static final int SPEED_VALUE = 1;
  private static final OptimizeMode[] VALUES = values();
  private static final Internal.EnumLiteMap<OptimizeMode> internalValueMap;
  private final int value;
  
  static
  {
    CODE_SIZE = new OptimizeMode("CODE_SIZE", 1, 2);
    LITE_RUNTIME = new OptimizeMode("LITE_RUNTIME", 2, 3);
    $VALUES = new OptimizeMode[] { SPEED, CODE_SIZE, LITE_RUNTIME };
    internalValueMap = new DescriptorProtos.FileOptions.OptimizeMode.1();
  }
  
  private DescriptorProtos$FileOptions$OptimizeMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static OptimizeMode forNumber(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        return LITE_RUNTIME;
      }
      return CODE_SIZE;
    }
    return SPEED;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)DescriptorProtos.FileOptions.getDescriptor().j().get(0);
  }
  
  public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static OptimizeMode valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static OptimizeMode valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FileOptions.OptimizeMode
 * JD-Core Version:    0.7.0.1
 */