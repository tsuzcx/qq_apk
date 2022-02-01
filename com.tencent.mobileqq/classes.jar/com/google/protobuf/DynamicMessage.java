package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DynamicMessage
  extends AbstractMessage
{
  private final Descriptors.Descriptor a;
  private final FieldSet<Descriptors.FieldDescriptor> b;
  private final Descriptors.FieldDescriptor[] c;
  private final UnknownFieldSet d;
  private int e = -1;
  
  DynamicMessage(Descriptors.Descriptor paramDescriptor, FieldSet<Descriptors.FieldDescriptor> paramFieldSet, Descriptors.FieldDescriptor[] paramArrayOfFieldDescriptor, UnknownFieldSet paramUnknownFieldSet)
  {
    this.a = paramDescriptor;
    this.b = paramFieldSet;
    this.c = paramArrayOfFieldDescriptor;
    this.d = paramUnknownFieldSet;
  }
  
  public static DynamicMessage a(Descriptors.Descriptor paramDescriptor)
  {
    Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = new Descriptors.FieldDescriptor[paramDescriptor.a().getOneofDeclCount()];
    return new DynamicMessage(paramDescriptor, FieldSet.b(), arrayOfFieldDescriptor, UnknownFieldSet.b());
  }
  
  private void a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.v() == this.a) {
      return;
    }
    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
  }
  
  private void a(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    if (paramOneofDescriptor.c() == this.a) {
      return;
    }
    throw new IllegalArgumentException("OneofDescriptor does not match message type.");
  }
  
  static boolean a(Descriptors.Descriptor paramDescriptor, FieldSet<Descriptors.FieldDescriptor> paramFieldSet)
  {
    paramDescriptor = paramDescriptor.f().iterator();
    while (paramDescriptor.hasNext())
    {
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)paramDescriptor.next();
      if ((localFieldDescriptor.n()) && (!paramFieldSet.a(localFieldDescriptor))) {
        return false;
      }
    }
    return paramFieldSet.k();
  }
  
  public static DynamicMessage.Builder b(Descriptors.Descriptor paramDescriptor)
  {
    return new DynamicMessage.Builder(paramDescriptor, null);
  }
  
  public DynamicMessage a()
  {
    return a(this.a);
  }
  
  public DynamicMessage.Builder b()
  {
    return new DynamicMessage.Builder(this.a, null);
  }
  
  public DynamicMessage.Builder c()
  {
    return b().a(this);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    return this.b.h();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return this.a;
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    a(paramFieldDescriptor);
    Object localObject2 = this.b.b(paramFieldDescriptor);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramFieldDescriptor.p()) {
        return Collections.emptyList();
      }
      if (paramFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        return a(paramFieldDescriptor.y());
      }
      localObject1 = paramFieldDescriptor.s();
    }
    return localObject1;
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    a(paramOneofDescriptor);
    return this.c[paramOneofDescriptor.a()];
  }
  
  public Parser<DynamicMessage> getParserForType()
  {
    return new DynamicMessage.1(this);
  }
  
  public int getSerializedSize()
  {
    int i = this.e;
    if (i != -1) {
      return i;
    }
    int j;
    if (this.a.e().getMessageSetWireFormat())
    {
      i = this.b.m();
      j = this.d.e();
    }
    else
    {
      i = this.b.l();
      j = this.d.getSerializedSize();
    }
    i += j;
    this.e = i;
    return i;
  }
  
  public UnknownFieldSet getUnknownFields()
  {
    return this.d;
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    a(paramFieldDescriptor);
    return this.b.a(paramFieldDescriptor);
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    a(paramOneofDescriptor);
    return this.c[paramOneofDescriptor.a()] != null;
  }
  
  public boolean isInitialized()
  {
    return a(this.a, this.b);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (this.a.e().getMessageSetWireFormat())
    {
      this.b.b(paramCodedOutputStream);
      this.d.a(paramCodedOutputStream);
      return;
    }
    this.b.a(paramCodedOutputStream);
    this.d.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DynamicMessage
 * JD-Core Version:    0.7.0.1
 */