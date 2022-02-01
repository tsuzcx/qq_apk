package com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$FieldDescriptorProto$Label
  implements ProtocolMessageEnum
{
  public static final int LABEL_OPTIONAL_VALUE = 1;
  public static final int LABEL_REPEATED_VALUE = 3;
  public static final int LABEL_REQUIRED_VALUE = 2;
  private static final Label[] VALUES = values();
  private static final Internal.EnumLiteMap<Label> internalValueMap;
  private final int value;
  
  static
  {
    LABEL_REPEATED = new Label("LABEL_REPEATED", 2, 3);
    $VALUES = new Label[] { LABEL_OPTIONAL, LABEL_REQUIRED, LABEL_REPEATED };
    internalValueMap = new DescriptorProtos.FieldDescriptorProto.Label.1();
  }
  
  private DescriptorProtos$FieldDescriptorProto$Label(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Label forNumber(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        return LABEL_REPEATED;
      }
      return LABEL_REQUIRED;
    }
    return LABEL_OPTIONAL;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().j().get(1);
  }
  
  public static Internal.EnumLiteMap<Label> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static Label valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public static Label valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label
 * JD-Core Version:    0.7.0.1
 */