package com.google.protobuf;

import java.util.List;

public final class GeneratedMessageV3$FieldAccessorTable
{
  private final Descriptors.Descriptor a;
  private final GeneratedMessageV3.FieldAccessorTable.FieldAccessor[] b;
  private String[] c;
  private final GeneratedMessageV3.FieldAccessorTable.OneofAccessor[] d;
  private volatile boolean e;
  
  public GeneratedMessageV3$FieldAccessorTable(Descriptors.Descriptor paramDescriptor, String[] paramArrayOfString)
  {
    this.a = paramDescriptor;
    this.c = paramArrayOfString;
    this.b = new GeneratedMessageV3.FieldAccessorTable.FieldAccessor[paramDescriptor.f().size()];
    this.d = new GeneratedMessageV3.FieldAccessorTable.OneofAccessor[paramDescriptor.g().size()];
    this.e = false;
  }
  
  private GeneratedMessageV3.FieldAccessorTable.FieldAccessor a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.v() == this.a)
    {
      if (!paramFieldDescriptor.u()) {
        return this.b[paramFieldDescriptor.a()];
      }
      throw new IllegalArgumentException("This type does not have extensions.");
    }
    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
  }
  
  private GeneratedMessageV3.FieldAccessorTable.OneofAccessor a(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    if (paramOneofDescriptor.c() == this.a) {
      return this.d[paramOneofDescriptor.a()];
    }
    throw new IllegalArgumentException("OneofDescriptor does not match message type.");
  }
  
  private static boolean b(Descriptors.FileDescriptor paramFileDescriptor)
  {
    return paramFileDescriptor.j() == Descriptors.FileDescriptor.Syntax.PROTO2;
  }
  
  public FieldAccessorTable a(Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1)
  {
    if (this.e) {
      return this;
    }
    try
    {
      if (this.e) {
        return this;
      }
      k = this.b.length;
      j = 0;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int k;
        int j;
        int i;
        String str;
        Descriptors.FieldDescriptor localFieldDescriptor;
        int m;
        for (;;)
        {
          throw paramClass;
        }
        i += 1;
      }
    }
    str = null;
    if (i < k)
    {
      localFieldDescriptor = (Descriptors.FieldDescriptor)this.a.f().get(i);
      if (localFieldDescriptor.w() != null) {
        str = this.c[(localFieldDescriptor.w().a() + k)];
      }
      if (localFieldDescriptor.p())
      {
        if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          if (localFieldDescriptor.m()) {
            this.b[i] = new GeneratedMessageV3.FieldAccessorTable.MapFieldAccessor(localFieldDescriptor, this.c[i], paramClass, paramClass1);
          } else {
            this.b[i] = new GeneratedMessageV3.FieldAccessorTable.RepeatedMessageFieldAccessor(localFieldDescriptor, this.c[i], paramClass, paramClass1);
          }
        }
        else if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.ENUM) {
          this.b[i] = new GeneratedMessageV3.FieldAccessorTable.RepeatedEnumFieldAccessor(localFieldDescriptor, this.c[i], paramClass, paramClass1);
        } else {
          this.b[i] = new GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor(localFieldDescriptor, this.c[i], paramClass, paramClass1);
        }
      }
      else if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        this.b[i] = new GeneratedMessageV3.FieldAccessorTable.SingularMessageFieldAccessor(localFieldDescriptor, this.c[i], paramClass, paramClass1, str);
      } else if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.ENUM) {
        this.b[i] = new GeneratedMessageV3.FieldAccessorTable.SingularEnumFieldAccessor(localFieldDescriptor, this.c[i], paramClass, paramClass1, str);
      } else if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.STRING) {
        this.b[i] = new GeneratedMessageV3.FieldAccessorTable.SingularStringFieldAccessor(localFieldDescriptor, this.c[i], paramClass, paramClass1, str);
      } else {
        this.b[i] = new GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor(localFieldDescriptor, this.c[i], paramClass, paramClass1, str);
      }
    }
    else
    {
      m = this.d.length;
      i = j;
      while (i < m)
      {
        this.d[i] = new GeneratedMessageV3.FieldAccessorTable.OneofAccessor(this.a, this.c[(i + k)], paramClass, paramClass1);
        i += 1;
      }
      this.e = true;
      this.c = null;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
 * JD-Core Version:    0.7.0.1
 */