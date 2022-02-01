package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Descriptors$Descriptor
  extends Descriptors.GenericDescriptor
{
  private final int a;
  private DescriptorProtos.DescriptorProto b;
  private final String c;
  private final Descriptors.FileDescriptor d;
  private final Descriptor e;
  private final Descriptor[] f;
  private final Descriptors.EnumDescriptor[] g;
  private final Descriptors.FieldDescriptor[] h;
  private final Descriptors.FieldDescriptor[] i;
  private final Descriptors.OneofDescriptor[] j;
  
  private Descriptors$Descriptor(DescriptorProtos.DescriptorProto paramDescriptorProto, Descriptors.FileDescriptor paramFileDescriptor, Descriptor paramDescriptor, int paramInt)
  {
    this.a = paramInt;
    this.b = paramDescriptorProto;
    this.c = Descriptors.a(paramFileDescriptor, paramDescriptor, paramDescriptorProto.getName());
    this.d = paramFileDescriptor;
    this.e = paramDescriptor;
    this.j = new Descriptors.OneofDescriptor[paramDescriptorProto.getOneofDeclCount()];
    int m = 0;
    paramInt = 0;
    while (paramInt < paramDescriptorProto.getOneofDeclCount())
    {
      this.j[paramInt] = new Descriptors.OneofDescriptor(paramDescriptorProto.getOneofDecl(paramInt), paramFileDescriptor, this, paramInt, null);
      paramInt += 1;
    }
    this.f = new Descriptor[paramDescriptorProto.getNestedTypeCount()];
    paramInt = 0;
    while (paramInt < paramDescriptorProto.getNestedTypeCount())
    {
      this.f[paramInt] = new Descriptor(paramDescriptorProto.getNestedType(paramInt), paramFileDescriptor, this, paramInt);
      paramInt += 1;
    }
    this.g = new Descriptors.EnumDescriptor[paramDescriptorProto.getEnumTypeCount()];
    paramInt = 0;
    while (paramInt < paramDescriptorProto.getEnumTypeCount())
    {
      this.g[paramInt] = new Descriptors.EnumDescriptor(paramDescriptorProto.getEnumType(paramInt), paramFileDescriptor, this, paramInt, null);
      paramInt += 1;
    }
    this.h = new Descriptors.FieldDescriptor[paramDescriptorProto.getFieldCount()];
    paramInt = 0;
    while (paramInt < paramDescriptorProto.getFieldCount())
    {
      this.h[paramInt] = new Descriptors.FieldDescriptor(paramDescriptorProto.getField(paramInt), paramFileDescriptor, this, paramInt, false, null);
      paramInt += 1;
    }
    this.i = new Descriptors.FieldDescriptor[paramDescriptorProto.getExtensionCount()];
    paramInt = 0;
    while (paramInt < paramDescriptorProto.getExtensionCount())
    {
      this.i[paramInt] = new Descriptors.FieldDescriptor(paramDescriptorProto.getExtension(paramInt), paramFileDescriptor, this, paramInt, true, null);
      paramInt += 1;
    }
    paramInt = 0;
    int k;
    for (;;)
    {
      k = m;
      if (paramInt >= paramDescriptorProto.getOneofDeclCount()) {
        break;
      }
      paramDescriptor = this.j;
      Descriptors.OneofDescriptor.a(paramDescriptor[paramInt], new Descriptors.FieldDescriptor[paramDescriptor[paramInt].d()]);
      Descriptors.OneofDescriptor.a(this.j[paramInt], 0);
      paramInt += 1;
    }
    while (k < paramDescriptorProto.getFieldCount())
    {
      paramDescriptor = this.h[k].w();
      if (paramDescriptor != null) {
        Descriptors.OneofDescriptor.a(paramDescriptor)[Descriptors.OneofDescriptor.b(paramDescriptor)] = this.h[k];
      }
      k += 1;
    }
    Descriptors.FileDescriptor.a(paramFileDescriptor).c(this);
  }
  
  Descriptors$Descriptor(String paramString)
  {
    int k = paramString.lastIndexOf('.');
    String str2;
    String str1;
    if (k != -1)
    {
      str2 = paramString.substring(k + 1);
      str1 = paramString.substring(0, k);
    }
    else
    {
      str1 = "";
      str2 = paramString;
    }
    this.a = 0;
    this.b = DescriptorProtos.DescriptorProto.newBuilder().a(str2).a(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().a(1).b(536870912).c()).c();
    this.c = paramString;
    this.e = null;
    this.f = new Descriptor[0];
    this.g = new Descriptors.EnumDescriptor[0];
    this.h = new Descriptors.FieldDescriptor[0];
    this.i = new Descriptors.FieldDescriptor[0];
    this.j = new Descriptors.OneofDescriptor[0];
    this.d = new Descriptors.FileDescriptor(str1, this);
  }
  
  private void m()
  {
    Object localObject = this.f;
    int n = localObject.length;
    int m = 0;
    int k = 0;
    while (k < n)
    {
      localObject[k].m();
      k += 1;
    }
    localObject = this.h;
    n = localObject.length;
    k = 0;
    while (k < n)
    {
      Descriptors.FieldDescriptor.b(localObject[k]);
      k += 1;
    }
    localObject = this.i;
    n = localObject.length;
    k = m;
    while (k < n)
    {
      Descriptors.FieldDescriptor.b(localObject[k]);
      k += 1;
    }
  }
  
  public DescriptorProtos.DescriptorProto a()
  {
    return this.b;
  }
  
  public Descriptors.FieldDescriptor a(String paramString)
  {
    Descriptors.DescriptorPool localDescriptorPool = Descriptors.FileDescriptor.a(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append('.');
    localStringBuilder.append(paramString);
    paramString = localDescriptorPool.a(localStringBuilder.toString());
    if ((paramString != null) && ((paramString instanceof Descriptors.FieldDescriptor))) {
      return (Descriptors.FieldDescriptor)paramString;
    }
    return null;
  }
  
  public boolean a(int paramInt)
  {
    Iterator localIterator = this.b.getExtensionRangeList().iterator();
    while (localIterator.hasNext())
    {
      DescriptorProtos.DescriptorProto.ExtensionRange localExtensionRange = (DescriptorProtos.DescriptorProto.ExtensionRange)localIterator.next();
      if ((localExtensionRange.getStart() <= paramInt) && (paramInt < localExtensionRange.getEnd())) {
        return true;
      }
    }
    return false;
  }
  
  public Descriptors.FieldDescriptor b(int paramInt)
  {
    return (Descriptors.FieldDescriptor)Descriptors.DescriptorPool.a(Descriptors.FileDescriptor.a(this.d)).get(new Descriptors.DescriptorPool.DescriptorIntPair(this, paramInt));
  }
  
  public String b()
  {
    return this.b.getName();
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Descriptors.FileDescriptor d()
  {
    return this.d;
  }
  
  public DescriptorProtos.MessageOptions e()
  {
    return this.b.getOptions();
  }
  
  public List<Descriptors.FieldDescriptor> f()
  {
    return Collections.unmodifiableList(Arrays.asList(this.h));
  }
  
  public List<Descriptors.OneofDescriptor> g()
  {
    return Collections.unmodifiableList(Arrays.asList(this.j));
  }
  
  public List<Descriptors.FieldDescriptor> h()
  {
    return Collections.unmodifiableList(Arrays.asList(this.i));
  }
  
  public List<Descriptor> i()
  {
    return Collections.unmodifiableList(Arrays.asList(this.f));
  }
  
  public List<Descriptors.EnumDescriptor> j()
  {
    return Collections.unmodifiableList(Arrays.asList(this.g));
  }
  
  public boolean k()
  {
    return this.b.getExtensionRangeList().size() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.Descriptor
 * JD-Core Version:    0.7.0.1
 */