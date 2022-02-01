package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

class GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor
  implements GeneratedMessageV3.FieldAccessorTable.FieldAccessor
{
  protected final Class a;
  protected final Method b;
  protected final Method c;
  protected final Method d;
  protected final Method e;
  protected final Method f;
  protected final Method g;
  protected final Method h;
  protected final Method i;
  protected final Method j;
  
  GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1)
  {
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString);
    paramFieldDescriptor.append("List");
    this.b = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[0]);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString);
    paramFieldDescriptor.append("List");
    this.c = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString);
    this.d = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE });
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString);
    this.e = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE });
    this.a = this.d.getReturnType();
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("set");
    paramFieldDescriptor.append(paramString);
    this.f = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE, this.a });
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("add");
    paramFieldDescriptor.append(paramString);
    this.g = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { this.a });
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString);
    paramFieldDescriptor.append("Count");
    this.h = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[0]);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString);
    paramFieldDescriptor.append("Count");
    this.i = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("clear");
    paramFieldDescriptor.append(paramString);
    this.j = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
  }
  
  public Message.Builder a()
  {
    throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
  }
  
  public Object a(GeneratedMessageV3.Builder paramBuilder)
  {
    return GeneratedMessageV3.access$1100(this.c, paramBuilder, new Object[0]);
  }
  
  public Object a(GeneratedMessageV3.Builder paramBuilder, int paramInt)
  {
    return GeneratedMessageV3.access$1100(this.e, paramBuilder, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return GeneratedMessageV3.access$1100(this.b, paramGeneratedMessageV3, new Object[0]);
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3, int paramInt)
  {
    return GeneratedMessageV3.access$1100(this.d, paramGeneratedMessageV3, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, int paramInt, Object paramObject)
  {
    GeneratedMessageV3.access$1100(this.f, paramBuilder, new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    d(paramBuilder);
    paramObject = ((List)paramObject).iterator();
    while (paramObject.hasNext()) {
      b(paramBuilder, paramObject.next());
    }
  }
  
  public Message.Builder b(GeneratedMessageV3.Builder paramBuilder, int paramInt)
  {
    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
  }
  
  public Object b(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return a(paramGeneratedMessageV3);
  }
  
  public void b(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    GeneratedMessageV3.access$1100(this.g, paramBuilder, new Object[] { paramObject });
  }
  
  public boolean b(GeneratedMessageV3.Builder paramBuilder)
  {
    throw new UnsupportedOperationException("hasField() called on a repeated field.");
  }
  
  public int c(GeneratedMessageV3.Builder paramBuilder)
  {
    return ((Integer)GeneratedMessageV3.access$1100(this.i, paramBuilder, new Object[0])).intValue();
  }
  
  public boolean c(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    throw new UnsupportedOperationException("hasField() called on a repeated field.");
  }
  
  public int d(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return ((Integer)GeneratedMessageV3.access$1100(this.h, paramGeneratedMessageV3, new Object[0])).intValue();
  }
  
  public void d(GeneratedMessageV3.Builder paramBuilder)
  {
    GeneratedMessageV3.access$1100(this.j, paramBuilder, new Object[0]);
  }
  
  public Message.Builder e(GeneratedMessageV3.Builder paramBuilder)
  {
    throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor
 * JD-Core Version:    0.7.0.1
 */