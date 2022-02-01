package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DynamicMessage$Builder
  extends AbstractMessage.Builder<Builder>
{
  private final Descriptors.Descriptor a;
  private FieldSet<Descriptors.FieldDescriptor> b;
  private final Descriptors.FieldDescriptor[] c;
  private UnknownFieldSet d;
  
  private DynamicMessage$Builder(Descriptors.Descriptor paramDescriptor)
  {
    this.a = paramDescriptor;
    this.b = FieldSet.a();
    this.d = UnknownFieldSet.b();
    this.c = new Descriptors.FieldDescriptor[paramDescriptor.a().getOneofDeclCount()];
    if (paramDescriptor.e().getMapEntry()) {
      f();
    }
  }
  
  private void b(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    if (paramOneofDescriptor.c() == this.a) {
      return;
    }
    throw new IllegalArgumentException("OneofDescriptor does not match message type.");
  }
  
  private void c(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.v() == this.a) {
      return;
    }
    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
  }
  
  private void c(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    Internal.a(paramObject);
    if ((paramObject instanceof Descriptors.EnumValueDescriptor)) {
      return;
    }
    throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
  }
  
  private void d(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    if (paramFieldDescriptor.p())
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        c(paramFieldDescriptor, paramObject.next());
      }
    }
    c(paramFieldDescriptor, paramObject);
  }
  
  private void f()
  {
    Iterator localIterator = this.a.f().iterator();
    while (localIterator.hasNext())
    {
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)localIterator.next();
      if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        this.b.a(localFieldDescriptor, DynamicMessage.a(localFieldDescriptor.y()));
      } else {
        this.b.a(localFieldDescriptor, localFieldDescriptor.s());
      }
    }
  }
  
  private void g()
  {
    if (this.b.e()) {
      this.b = this.b.f();
    }
  }
  
  public Builder a()
  {
    if (this.b.e()) {
      this.b = FieldSet.a();
    } else {
      this.b.g();
    }
    if (this.a.e().getMapEntry()) {
      f();
    }
    this.d = UnknownFieldSet.b();
    return this;
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    c(paramFieldDescriptor);
    if (paramFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      return new Builder(paramFieldDescriptor.y());
    }
    throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    c(paramFieldDescriptor);
    g();
    if (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.ENUM) {
      d(paramFieldDescriptor, paramObject);
    }
    Object localObject = paramFieldDescriptor.w();
    if (localObject != null)
    {
      int i = ((Descriptors.OneofDescriptor)localObject).a();
      localObject = this.c[i];
      if ((localObject != null) && (localObject != paramFieldDescriptor)) {
        this.b.c((FieldSet.FieldDescriptorLite)localObject);
      }
      this.c[i] = paramFieldDescriptor;
    }
    else if ((paramFieldDescriptor.d().j() == Descriptors.FileDescriptor.Syntax.PROTO3) && (!paramFieldDescriptor.p()) && (paramFieldDescriptor.g() != Descriptors.FieldDescriptor.JavaType.MESSAGE) && (paramObject.equals(paramFieldDescriptor.s())))
    {
      this.b.c(paramFieldDescriptor);
      return this;
    }
    this.b.a(paramFieldDescriptor, paramObject);
    return this;
  }
  
  public Builder a(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    b(paramOneofDescriptor);
    paramOneofDescriptor = this.c[paramOneofDescriptor.a()];
    if (paramOneofDescriptor != null) {
      b(paramOneofDescriptor);
    }
    return this;
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof DynamicMessage))
    {
      paramMessage = (DynamicMessage)paramMessage;
      if (DynamicMessage.a(paramMessage) == this.a)
      {
        g();
        this.b.a(DynamicMessage.b(paramMessage));
        b(DynamicMessage.c(paramMessage));
        int i = 0;
        for (;;)
        {
          Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.c;
          if (i >= arrayOfFieldDescriptor.length) {
            break;
          }
          if (arrayOfFieldDescriptor[i] == null)
          {
            arrayOfFieldDescriptor[i] = DynamicMessage.d(paramMessage)[i];
          }
          else if ((DynamicMessage.d(paramMessage)[i] != null) && (this.c[i] != DynamicMessage.d(paramMessage)[i]))
          {
            this.b.c(this.c[i]);
            this.c[i] = DynamicMessage.d(paramMessage)[i];
          }
          i += 1;
        }
        return this;
      }
      throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
    }
    return (Builder)super.mergeFrom(paramMessage);
  }
  
  public Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    this.d = paramUnknownFieldSet;
    return this;
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    c(paramFieldDescriptor);
    g();
    Object localObject = paramFieldDescriptor.w();
    if (localObject != null)
    {
      int i = ((Descriptors.OneofDescriptor)localObject).a();
      localObject = this.c;
      if (localObject[i] == paramFieldDescriptor) {
        localObject[i] = null;
      }
    }
    this.b.c(paramFieldDescriptor);
    return this;
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    c(paramFieldDescriptor);
    g();
    this.b.b(paramFieldDescriptor, paramObject);
    return this;
  }
  
  public Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    this.d = UnknownFieldSet.a(this.d).a(paramUnknownFieldSet).a();
    return this;
  }
  
  public DynamicMessage b()
  {
    if (isInitialized()) {
      return c();
    }
    Descriptors.Descriptor localDescriptor = this.a;
    FieldSet localFieldSet = this.b;
    Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.c;
    throw newUninitializedMessageException(new DynamicMessage(localDescriptor, localFieldSet, (Descriptors.FieldDescriptor[])Arrays.copyOf(arrayOfFieldDescriptor, arrayOfFieldDescriptor.length), this.d));
  }
  
  public DynamicMessage c()
  {
    this.b.d();
    Descriptors.Descriptor localDescriptor = this.a;
    FieldSet localFieldSet = this.b;
    Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.c;
    return new DynamicMessage(localDescriptor, localFieldSet, (Descriptors.FieldDescriptor[])Arrays.copyOf(arrayOfFieldDescriptor, arrayOfFieldDescriptor.length), this.d);
  }
  
  public Builder d()
  {
    Builder localBuilder = new Builder(this.a);
    localBuilder.b.a(this.b);
    localBuilder.b(this.d);
    Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.c;
    System.arraycopy(arrayOfFieldDescriptor, 0, localBuilder.c, 0, arrayOfFieldDescriptor.length);
    return localBuilder;
  }
  
  public DynamicMessage e()
  {
    return DynamicMessage.a(this.a);
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
    c(paramFieldDescriptor);
    Object localObject2 = this.b.b(paramFieldDescriptor);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramFieldDescriptor.p()) {
        return Collections.emptyList();
      }
      if (paramFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        return DynamicMessage.a(paramFieldDescriptor.y());
      }
      localObject1 = paramFieldDescriptor.s();
    }
    return localObject1;
  }
  
  public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    b(paramOneofDescriptor);
    return this.c[paramOneofDescriptor.a()];
  }
  
  public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
  }
  
  public UnknownFieldSet getUnknownFields()
  {
    return this.d;
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    c(paramFieldDescriptor);
    return this.b.a(paramFieldDescriptor);
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    b(paramOneofDescriptor);
    return this.c[paramOneofDescriptor.a()] != null;
  }
  
  public boolean isInitialized()
  {
    return DynamicMessage.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DynamicMessage.Builder
 * JD-Core Version:    0.7.0.1
 */