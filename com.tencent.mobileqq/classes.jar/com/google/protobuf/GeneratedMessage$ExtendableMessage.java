package com.google.protobuf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class GeneratedMessage$ExtendableMessage<MessageType extends ExtendableMessage>
  extends GeneratedMessage
  implements GeneratedMessage.ExtendableMessageOrBuilder<MessageType>
{
  private static final long serialVersionUID = 1L;
  private final FieldSet<Descriptors.FieldDescriptor> extensions;
  
  protected GeneratedMessage$ExtendableMessage()
  {
    this.extensions = FieldSet.a();
  }
  
  protected GeneratedMessage$ExtendableMessage(GeneratedMessage.ExtendableBuilder<MessageType, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.extensions = GeneratedMessage.ExtendableBuilder.a(paramExtendableBuilder);
  }
  
  private void a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.v() == getDescriptorForType()) {
      return;
    }
    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
  }
  
  private void a(Extension<MessageType, ?> paramExtension)
  {
    if (paramExtension.b().v() == getDescriptorForType()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Extension is for type \"");
    localStringBuilder.append(paramExtension.b().v().c());
    localStringBuilder.append("\" which does not match message type \"");
    localStringBuilder.append(getDescriptorForType().c());
    localStringBuilder.append("\".");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected boolean extensionsAreInitialized()
  {
    return this.extensions.k();
  }
  
  protected int extensionsSerializedSize()
  {
    return this.extensions.l();
  }
  
  protected int extensionsSerializedSizeAsMessageSet()
  {
    return this.extensions.m();
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    Map localMap = GeneratedMessage.access$800(this, false);
    localMap.putAll(getExtensionFields());
    return Collections.unmodifiableMap(localMap);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw()
  {
    Map localMap = GeneratedMessage.access$800(this, false);
    localMap.putAll(getExtensionFields());
    return Collections.unmodifiableMap(localMap);
  }
  
  public final <Type> Type getExtension(Extension<MessageType, Type> paramExtension)
  {
    return getExtension(paramExtension);
  }
  
  public final <Type> Type getExtension(Extension<MessageType, List<Type>> paramExtension, int paramInt)
  {
    return getExtension(paramExtension, paramInt);
  }
  
  public final <Type> Type getExtension(ExtensionLite<MessageType, Type> paramExtensionLite)
  {
    paramExtensionLite = GeneratedMessage.access$500(paramExtensionLite);
    a(paramExtensionLite);
    Descriptors.FieldDescriptor localFieldDescriptor = paramExtensionLite.b();
    Object localObject = this.extensions.b(localFieldDescriptor);
    if (localObject == null)
    {
      if (localFieldDescriptor.p()) {
        return Collections.emptyList();
      }
      if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        return paramExtensionLite.a();
      }
      return paramExtensionLite.a(localFieldDescriptor.s());
    }
    return paramExtensionLite.a(localObject);
  }
  
  public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> paramExtensionLite, int paramInt)
  {
    paramExtensionLite = GeneratedMessage.access$500(paramExtensionLite);
    a(paramExtensionLite);
    Descriptors.FieldDescriptor localFieldDescriptor = paramExtensionLite.b();
    return paramExtensionLite.b(this.extensions.a(localFieldDescriptor, paramInt));
  }
  
  public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
  {
    return getExtension(paramGeneratedExtension);
  }
  
  public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt)
  {
    return getExtension(paramGeneratedExtension, paramInt);
  }
  
  public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> paramExtension)
  {
    return getExtensionCount(paramExtension);
  }
  
  public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> paramExtensionLite)
  {
    paramExtensionLite = GeneratedMessage.access$500(paramExtensionLite);
    a(paramExtensionLite);
    paramExtensionLite = paramExtensionLite.b();
    return this.extensions.d(paramExtensionLite);
  }
  
  public final <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension)
  {
    return getExtensionCount(paramGeneratedExtension);
  }
  
  protected Map<Descriptors.FieldDescriptor, Object> getExtensionFields()
  {
    return this.extensions.h();
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      Object localObject = this.extensions.b(paramFieldDescriptor);
      if (localObject == null)
      {
        if (paramFieldDescriptor.p()) {
          return Collections.emptyList();
        }
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
      return this.extensions.a(paramFieldDescriptor, paramInt);
    }
    return super.getRepeatedField(paramFieldDescriptor, paramInt);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      return this.extensions.d(paramFieldDescriptor);
    }
    return super.getRepeatedFieldCount(paramFieldDescriptor);
  }
  
  public final <Type> boolean hasExtension(Extension<MessageType, Type> paramExtension)
  {
    return hasExtension(paramExtension);
  }
  
  public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> paramExtensionLite)
  {
    paramExtensionLite = GeneratedMessage.access$500(paramExtensionLite);
    a(paramExtensionLite);
    return this.extensions.a(paramExtensionLite.b());
  }
  
  public final <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
  {
    return hasExtension(paramGeneratedExtension);
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.u())
    {
      a(paramFieldDescriptor);
      return this.extensions.a(paramFieldDescriptor);
    }
    return super.hasField(paramFieldDescriptor);
  }
  
  public boolean isInitialized()
  {
    return (super.isInitialized()) && (extensionsAreInitialized());
  }
  
  protected void makeExtensionsImmutable()
  {
    this.extensions.d();
  }
  
  protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter()
  {
    return new GeneratedMessage.ExtendableMessage.ExtensionWriter(this, false, null);
  }
  
  protected ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter()
  {
    return new GeneratedMessage.ExtendableMessage.ExtensionWriter(this, true, null);
  }
  
  protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
  {
    return MessageReflection.a(paramCodedInputStream, paramBuilder, paramExtensionRegistryLite, getDescriptorForType(), new MessageReflection.ExtensionAdapter(this.extensions), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.ExtendableMessage
 * JD-Core Version:    0.7.0.1
 */