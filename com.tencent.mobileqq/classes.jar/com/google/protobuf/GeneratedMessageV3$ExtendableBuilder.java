package com.google.protobuf;

import java.util.Collections;
import java.util.Map;

public abstract class GeneratedMessageV3$ExtendableBuilder<MessageType extends GeneratedMessageV3.ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>>
  extends GeneratedMessageV3.Builder<BuilderType>
  implements GeneratedMessageV3.ExtendableMessageOrBuilder<MessageType>
{
  private FieldSet<Descriptors.FieldDescriptor> a = FieldSet.b();
  
  protected GeneratedMessageV3$ExtendableBuilder() {}
  
  protected GeneratedMessageV3$ExtendableBuilder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
  }
  
  private void a()
  {
    if (this.a.e()) {
      this.a = this.a.f();
    }
  }
  
  private void a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.v() == getDescriptorForType()) {
      return;
    }
    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
  }
  
  private FieldSet<Descriptors.FieldDescriptor> b()
  {
    this.a.d();
    return this.a;
  }
  
  protected final void a(GeneratedMessageV3.ExtendableMessage paramExtendableMessage)
  {
    a();
    this.a.a(GeneratedMessageV3.ExtendableMessage.access$600(paramExtendableMessage));
    onChanged();
  }
  
  public BuilderType b(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      a();
      this.a.c(paramFieldDescriptor);
      onChanged();
      return this;
    }
    return (ExtendableBuilder)super.clearField(paramFieldDescriptor);
  }
  
  public BuilderType b(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      a();
      this.a.a(paramFieldDescriptor, paramInt, paramObject);
      onChanged();
      return this;
    }
    return (ExtendableBuilder)super.setRepeatedField(paramFieldDescriptor, paramInt, paramObject);
  }
  
  public BuilderType c(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      a();
      this.a.b(paramFieldDescriptor, paramObject);
      onChanged();
      return this;
    }
    return (ExtendableBuilder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public BuilderType d(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      a();
      this.a.a(paramFieldDescriptor, paramObject);
      onChanged();
      return this;
    }
    return (ExtendableBuilder)super.setField(paramFieldDescriptor, paramObject);
  }
  
  public BuilderType g()
  {
    this.a = FieldSet.b();
    return (ExtendableBuilder)super.clear();
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    Map localMap = GeneratedMessageV3.Builder.access$900(this);
    localMap.putAll(this.a.h());
    return Collections.unmodifiableMap(localMap);
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      Object localObject = this.a.b(paramFieldDescriptor);
      if (localObject == null)
      {
        if (paramFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          return DynamicMessage.a(paramFieldDescriptor.y());
        }
        return paramFieldDescriptor.s();
      }
      return localObject;
    }
    return super.getField(paramFieldDescriptor);
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      return this.a.a(paramFieldDescriptor, paramInt);
    }
    return super.getRepeatedField(paramFieldDescriptor, paramInt);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      return this.a.d(paramFieldDescriptor);
    }
    return super.getRepeatedFieldCount(paramFieldDescriptor);
  }
  
  protected boolean h()
  {
    return this.a.k();
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      return this.a.a(paramFieldDescriptor);
    }
    return super.hasField(paramFieldDescriptor);
  }
  
  public boolean isInitialized()
  {
    return (super.isInitialized()) && (h());
  }
  
  public Message.Builder newBuilderForField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.u()) {
      return DynamicMessage.b(paramFieldDescriptor.y());
    }
    return super.newBuilderForField(paramFieldDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.ExtendableBuilder
 * JD-Core Version:    0.7.0.1
 */