package com.google.protobuf;

import java.lang.reflect.Method;

final class GeneratedMessageV3$FieldAccessorTable$SingularEnumFieldAccessor
  extends GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor
{
  private Descriptors.EnumDescriptor m;
  private Method n;
  private Method o;
  private boolean p;
  private Method q;
  private Method r;
  private Method s;
  
  GeneratedMessageV3$FieldAccessorTable$SingularEnumFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString1, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1, String paramString2)
  {
    super(paramFieldDescriptor, paramString1, paramClass, paramClass1, paramString2);
    this.m = paramFieldDescriptor.z();
    this.n = GeneratedMessageV3.access$1000(this.a, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
    this.o = GeneratedMessageV3.access$1000(this.a, "getValueDescriptor", new Class[0]);
    this.p = paramFieldDescriptor.d().k();
    if (this.p)
    {
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("get");
      paramFieldDescriptor.append(paramString1);
      paramFieldDescriptor.append("Value");
      this.q = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[0]);
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("get");
      paramFieldDescriptor.append(paramString1);
      paramFieldDescriptor.append("Value");
      this.r = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("set");
      paramFieldDescriptor.append(paramString1);
      paramFieldDescriptor.append("Value");
      this.s = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE });
    }
  }
  
  public Object a(GeneratedMessageV3.Builder paramBuilder)
  {
    if (this.p)
    {
      int i = ((Integer)GeneratedMessageV3.access$1100(this.r, paramBuilder, new Object[0])).intValue();
      return this.m.b(i);
    }
    return GeneratedMessageV3.access$1100(this.o, super.a(paramBuilder), new Object[0]);
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    if (this.p)
    {
      int i = ((Integer)GeneratedMessageV3.access$1100(this.q, paramGeneratedMessageV3, new Object[0])).intValue();
      return this.m.b(i);
    }
    return GeneratedMessageV3.access$1100(this.o, super.a(paramGeneratedMessageV3), new Object[0]);
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    if (this.p)
    {
      GeneratedMessageV3.access$1100(this.s, paramBuilder, new Object[] { Integer.valueOf(((Descriptors.EnumValueDescriptor)paramObject).getNumber()) });
      return;
    }
    super.a(paramBuilder, GeneratedMessageV3.access$1100(this.n, null, new Object[] { paramObject }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularEnumFieldAccessor
 * JD-Core Version:    0.7.0.1
 */