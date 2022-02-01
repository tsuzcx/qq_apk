package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class GeneratedMessageV3$FieldAccessorTable$RepeatedEnumFieldAccessor
  extends GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor
{
  private Descriptors.EnumDescriptor k;
  private final Method l;
  private final Method m;
  private boolean n;
  private Method o;
  private Method p;
  private Method q;
  private Method r;
  
  GeneratedMessageV3$FieldAccessorTable$RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1)
  {
    super(paramFieldDescriptor, paramString, paramClass, paramClass1);
    this.k = paramFieldDescriptor.z();
    this.l = GeneratedMessageV3.access$1000(this.a, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
    this.m = GeneratedMessageV3.access$1000(this.a, "getValueDescriptor", new Class[0]);
    this.n = paramFieldDescriptor.d().k();
    if (this.n)
    {
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("get");
      paramFieldDescriptor.append(paramString);
      paramFieldDescriptor.append("Value");
      this.o = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE });
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("get");
      paramFieldDescriptor.append(paramString);
      paramFieldDescriptor.append("Value");
      this.p = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE });
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("set");
      paramFieldDescriptor.append(paramString);
      paramFieldDescriptor.append("Value");
      this.q = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE, Integer.TYPE });
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("add");
      paramFieldDescriptor.append(paramString);
      paramFieldDescriptor.append("Value");
      this.r = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE });
    }
  }
  
  public Object a(GeneratedMessageV3.Builder paramBuilder)
  {
    ArrayList localArrayList = new ArrayList();
    int j = c(paramBuilder);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramBuilder, i));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Object a(GeneratedMessageV3.Builder paramBuilder, int paramInt)
  {
    if (this.n)
    {
      paramInt = ((Integer)GeneratedMessageV3.access$1100(this.p, paramBuilder, new Object[] { Integer.valueOf(paramInt) })).intValue();
      return this.k.b(paramInt);
    }
    return GeneratedMessageV3.access$1100(this.m, super.a(paramBuilder, paramInt), new Object[0]);
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    ArrayList localArrayList = new ArrayList();
    int j = d(paramGeneratedMessageV3);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramGeneratedMessageV3, i));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3, int paramInt)
  {
    if (this.n)
    {
      paramInt = ((Integer)GeneratedMessageV3.access$1100(this.o, paramGeneratedMessageV3, new Object[] { Integer.valueOf(paramInt) })).intValue();
      return this.k.b(paramInt);
    }
    return GeneratedMessageV3.access$1100(this.m, super.a(paramGeneratedMessageV3, paramInt), new Object[0]);
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, int paramInt, Object paramObject)
  {
    if (this.n)
    {
      GeneratedMessageV3.access$1100(this.q, paramBuilder, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((Descriptors.EnumValueDescriptor)paramObject).getNumber()) });
      return;
    }
    super.a(paramBuilder, paramInt, GeneratedMessageV3.access$1100(this.l, null, new Object[] { paramObject }));
  }
  
  public void b(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    if (this.n)
    {
      GeneratedMessageV3.access$1100(this.r, paramBuilder, new Object[] { Integer.valueOf(((Descriptors.EnumValueDescriptor)paramObject).getNumber()) });
      return;
    }
    super.b(paramBuilder, GeneratedMessageV3.access$1100(this.l, null, new Object[] { paramObject }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedEnumFieldAccessor
 * JD-Core Version:    0.7.0.1
 */