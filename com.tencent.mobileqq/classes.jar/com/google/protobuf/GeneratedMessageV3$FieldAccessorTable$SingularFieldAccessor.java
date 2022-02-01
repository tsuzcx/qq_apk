package com.google.protobuf;

import java.lang.reflect.Method;

class GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor
  implements GeneratedMessageV3.FieldAccessorTable.FieldAccessor
{
  protected final Class<?> a;
  protected final Method b;
  protected final Method c;
  protected final Method d;
  protected final Method e;
  protected final Method f;
  protected final Method g;
  protected final Method h;
  protected final Method i;
  protected final Descriptors.FieldDescriptor j;
  protected final boolean k;
  protected final boolean l;
  
  GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString1, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1, String paramString2)
  {
    this.j = paramFieldDescriptor;
    if (paramFieldDescriptor.w() != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.k = bool;
    if ((!GeneratedMessageV3.FieldAccessorTable.a(paramFieldDescriptor.d())) && ((this.k) || (paramFieldDescriptor.g() != Descriptors.FieldDescriptor.JavaType.MESSAGE))) {
      bool = false;
    } else {
      bool = true;
    }
    this.l = bool;
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString1);
    this.b = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[0]);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString1);
    this.c = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
    this.a = this.b.getReturnType();
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("set");
    paramFieldDescriptor.append(paramString1);
    this.d = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { this.a });
    boolean bool = this.l;
    Object localObject = null;
    if (bool)
    {
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("has");
      paramFieldDescriptor.append(paramString1);
      paramFieldDescriptor = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[0]);
    }
    else
    {
      paramFieldDescriptor = null;
    }
    this.e = paramFieldDescriptor;
    if (this.l)
    {
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("has");
      paramFieldDescriptor.append(paramString1);
      paramFieldDescriptor = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
    }
    else
    {
      paramFieldDescriptor = null;
    }
    this.f = paramFieldDescriptor;
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("clear");
    paramFieldDescriptor.append(paramString1);
    this.g = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
    if (this.k)
    {
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("get");
      paramFieldDescriptor.append(paramString2);
      paramFieldDescriptor.append("Case");
      paramFieldDescriptor = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[0]);
    }
    else
    {
      paramFieldDescriptor = null;
    }
    this.h = paramFieldDescriptor;
    paramFieldDescriptor = localObject;
    if (this.k)
    {
      paramFieldDescriptor = new StringBuilder();
      paramFieldDescriptor.append("get");
      paramFieldDescriptor.append(paramString2);
      paramFieldDescriptor.append("Case");
      paramFieldDescriptor = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
    }
    this.i = paramFieldDescriptor;
  }
  
  private int e(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return ((Internal.EnumLite)GeneratedMessageV3.access$1100(this.h, paramGeneratedMessageV3, new Object[0])).getNumber();
  }
  
  private int f(GeneratedMessageV3.Builder paramBuilder)
  {
    return ((Internal.EnumLite)GeneratedMessageV3.access$1100(this.i, paramBuilder, new Object[0])).getNumber();
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
    throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return GeneratedMessageV3.access$1100(this.b, paramGeneratedMessageV3, new Object[0]);
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3, int paramInt)
  {
    throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    GeneratedMessageV3.access$1100(this.d, paramBuilder, new Object[] { paramObject });
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
    throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
  }
  
  public boolean b(GeneratedMessageV3.Builder paramBuilder)
  {
    boolean bool2 = this.l;
    boolean bool1 = false;
    if (!bool2)
    {
      if (this.k)
      {
        if (f(paramBuilder) == this.j.f()) {
          bool1 = true;
        }
        return bool1;
      }
      return a(paramBuilder).equals(this.j.s()) ^ true;
    }
    return ((Boolean)GeneratedMessageV3.access$1100(this.f, paramBuilder, new Object[0])).booleanValue();
  }
  
  public int c(GeneratedMessageV3.Builder paramBuilder)
  {
    throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
  }
  
  public boolean c(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    boolean bool2 = this.l;
    boolean bool1 = false;
    if (!bool2)
    {
      if (this.k)
      {
        if (e(paramGeneratedMessageV3) == this.j.f()) {
          bool1 = true;
        }
        return bool1;
      }
      return a(paramGeneratedMessageV3).equals(this.j.s()) ^ true;
    }
    return ((Boolean)GeneratedMessageV3.access$1100(this.e, paramGeneratedMessageV3, new Object[0])).booleanValue();
  }
  
  public int d(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
  }
  
  public void d(GeneratedMessageV3.Builder paramBuilder)
  {
    GeneratedMessageV3.access$1100(this.g, paramBuilder, new Object[0]);
  }
  
  public Message.Builder e(GeneratedMessageV3.Builder paramBuilder)
  {
    throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor
 * JD-Core Version:    0.7.0.1
 */