package com.google.protobuf;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class Descriptors$EnumDescriptor
  extends Descriptors.GenericDescriptor
  implements Internal.EnumLiteMap<Descriptors.EnumValueDescriptor>
{
  private final int a;
  private DescriptorProtos.EnumDescriptorProto b;
  private final String c;
  private final Descriptors.FileDescriptor d;
  private final Descriptors.Descriptor e;
  private Descriptors.EnumValueDescriptor[] f;
  private final WeakHashMap<Integer, WeakReference<Descriptors.EnumValueDescriptor>> g = new WeakHashMap();
  
  private Descriptors$EnumDescriptor(DescriptorProtos.EnumDescriptorProto paramEnumDescriptorProto, Descriptors.FileDescriptor paramFileDescriptor, Descriptors.Descriptor paramDescriptor, int paramInt)
  {
    this.a = paramInt;
    this.b = paramEnumDescriptorProto;
    this.c = Descriptors.a(paramFileDescriptor, paramDescriptor, paramEnumDescriptorProto.getName());
    this.d = paramFileDescriptor;
    this.e = paramDescriptor;
    if (paramEnumDescriptorProto.getValueCount() != 0)
    {
      this.f = new Descriptors.EnumValueDescriptor[paramEnumDescriptorProto.getValueCount()];
      paramInt = 0;
      while (paramInt < paramEnumDescriptorProto.getValueCount())
      {
        this.f[paramInt] = new Descriptors.EnumValueDescriptor(paramEnumDescriptorProto.getValue(paramInt), paramFileDescriptor, this, paramInt, null);
        paramInt += 1;
      }
      Descriptors.FileDescriptor.a(paramFileDescriptor).c(this);
      return;
    }
    paramEnumDescriptorProto = new Descriptors.DescriptorValidationException(this, "Enums must contain at least one value.", null);
    for (;;)
    {
      throw paramEnumDescriptorProto;
    }
  }
  
  public DescriptorProtos.EnumDescriptorProto a()
  {
    return this.b;
  }
  
  public Descriptors.EnumValueDescriptor a(int paramInt)
  {
    return (Descriptors.EnumValueDescriptor)Descriptors.DescriptorPool.b(Descriptors.FileDescriptor.a(this.d)).get(new Descriptors.DescriptorPool.DescriptorIntPair(this, paramInt));
  }
  
  public Descriptors.EnumValueDescriptor a(String paramString)
  {
    Descriptors.DescriptorPool localDescriptorPool = Descriptors.FileDescriptor.a(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append('.');
    localStringBuilder.append(paramString);
    paramString = localDescriptorPool.a(localStringBuilder.toString());
    if ((paramString != null) && ((paramString instanceof Descriptors.EnumValueDescriptor))) {
      return (Descriptors.EnumValueDescriptor)paramString;
    }
    return null;
  }
  
  public Descriptors.EnumValueDescriptor b(int paramInt)
  {
    Descriptors.EnumValueDescriptor localEnumValueDescriptor = a(paramInt);
    if (localEnumValueDescriptor != null) {
      return localEnumValueDescriptor;
    }
    try
    {
      Integer localInteger = new Integer(paramInt);
      Object localObject2 = (WeakReference)this.g.get(localInteger);
      if (localObject2 != null) {
        localEnumValueDescriptor = (Descriptors.EnumValueDescriptor)((WeakReference)localObject2).get();
      }
      localObject2 = localEnumValueDescriptor;
      if (localEnumValueDescriptor == null)
      {
        localObject2 = new Descriptors.EnumValueDescriptor(this.d, this, localInteger, null);
        this.g.put(localInteger, new WeakReference(localObject2));
      }
      return localObject2;
    }
    finally {}
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
  
  public List<Descriptors.EnumValueDescriptor> e()
  {
    return Collections.unmodifiableList(Arrays.asList(this.f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.EnumDescriptor
 * JD-Core Version:    0.7.0.1
 */