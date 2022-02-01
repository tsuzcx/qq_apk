package com.google.protobuf;

import java.lang.reflect.Method;

class GeneratedMessageV3$FieldAccessorTable$OneofAccessor
{
  private final Descriptors.Descriptor a;
  private final Method b;
  private final Method c;
  private final Method d;
  
  GeneratedMessageV3$FieldAccessorTable$OneofAccessor(Descriptors.Descriptor paramDescriptor, String paramString, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1)
  {
    this.a = paramDescriptor;
    paramDescriptor = new StringBuilder();
    paramDescriptor.append("get");
    paramDescriptor.append(paramString);
    paramDescriptor.append("Case");
    this.b = GeneratedMessageV3.access$1000(paramClass, paramDescriptor.toString(), new Class[0]);
    paramDescriptor = new StringBuilder();
    paramDescriptor.append("get");
    paramDescriptor.append(paramString);
    paramDescriptor.append("Case");
    this.c = GeneratedMessageV3.access$1000(paramClass1, paramDescriptor.toString(), new Class[0]);
    paramDescriptor = new StringBuilder();
    paramDescriptor.append("clear");
    paramDescriptor.append(paramString);
    this.d = GeneratedMessageV3.access$1000(paramClass1, paramDescriptor.toString(), new Class[0]);
  }
  
  public boolean a(GeneratedMessageV3.Builder paramBuilder)
  {
    return ((Internal.EnumLite)GeneratedMessageV3.access$1100(this.c, paramBuilder, new Object[0])).getNumber() != 0;
  }
  
  public boolean a(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return ((Internal.EnumLite)GeneratedMessageV3.access$1100(this.b, paramGeneratedMessageV3, new Object[0])).getNumber() != 0;
  }
  
  public Descriptors.FieldDescriptor b(GeneratedMessageV3.Builder paramBuilder)
  {
    int i = ((Internal.EnumLite)GeneratedMessageV3.access$1100(this.c, paramBuilder, new Object[0])).getNumber();
    if (i > 0) {
      return this.a.b(i);
    }
    return null;
  }
  
  public Descriptors.FieldDescriptor b(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    int i = ((Internal.EnumLite)GeneratedMessageV3.access$1100(this.b, paramGeneratedMessageV3, new Object[0])).getNumber();
    if (i > 0) {
      return this.a.b(i);
    }
    return null;
  }
  
  public void c(GeneratedMessageV3.Builder paramBuilder)
  {
    GeneratedMessageV3.access$1100(this.d, paramBuilder, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.OneofAccessor
 * JD-Core Version:    0.7.0.1
 */