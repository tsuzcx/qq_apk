package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneratedMessage$GeneratedExtension<ContainingType extends Message, Type>
  extends Extension<ContainingType, Type>
{
  private GeneratedMessage.ExtensionDescriptorRetriever a;
  private final Class b;
  private final Message c;
  private final Method d;
  private final Method e;
  private final Extension.ExtensionType f;
  
  GeneratedMessage$GeneratedExtension(GeneratedMessage.ExtensionDescriptorRetriever paramExtensionDescriptorRetriever, Class paramClass, Message paramMessage, Extension.ExtensionType paramExtensionType)
  {
    if ((Message.class.isAssignableFrom(paramClass)) && (!paramClass.isInstance(paramMessage)))
    {
      paramExtensionDescriptorRetriever = new StringBuilder();
      paramExtensionDescriptorRetriever.append("Bad messageDefaultInstance for ");
      paramExtensionDescriptorRetriever.append(paramClass.getName());
      throw new IllegalArgumentException(paramExtensionDescriptorRetriever.toString());
    }
    this.a = paramExtensionDescriptorRetriever;
    this.b = paramClass;
    this.c = paramMessage;
    if (ProtocolMessageEnum.class.isAssignableFrom(paramClass))
    {
      this.d = GeneratedMessage.access$1100(paramClass, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      this.e = GeneratedMessage.access$1100(paramClass, "getValueDescriptor", new Class[0]);
    }
    else
    {
      this.d = null;
      this.e = null;
    }
    this.f = paramExtensionType;
  }
  
  public Message a()
  {
    return this.c;
  }
  
  protected Object a(Object paramObject)
  {
    Object localObject = b();
    if (((Descriptors.FieldDescriptor)localObject).p())
    {
      if ((((Descriptors.FieldDescriptor)localObject).g() != Descriptors.FieldDescriptor.JavaType.MESSAGE) && (((Descriptors.FieldDescriptor)localObject).g() != Descriptors.FieldDescriptor.JavaType.ENUM)) {
        return paramObject;
      }
      localObject = new ArrayList();
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        ((List)localObject).add(b(paramObject.next()));
      }
      return localObject;
    }
    return b(paramObject);
  }
  
  public Descriptors.FieldDescriptor b()
  {
    GeneratedMessage.ExtensionDescriptorRetriever localExtensionDescriptorRetriever = this.a;
    if (localExtensionDescriptorRetriever != null) {
      return localExtensionDescriptorRetriever.b();
    }
    throw new IllegalStateException("getDescriptor() called before internalInit()");
  }
  
  protected Object b(Object paramObject)
  {
    Descriptors.FieldDescriptor localFieldDescriptor = b();
    int i = GeneratedMessage.5.a[localFieldDescriptor.g().ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return paramObject;
      }
      return GeneratedMessage.access$1200(this.d, null, new Object[] { (Descriptors.EnumValueDescriptor)paramObject });
    }
    if (this.b.isInstance(paramObject)) {
      return paramObject;
    }
    return this.c.newBuilderForType().mergeFrom((Message)paramObject).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.GeneratedExtension
 * JD-Core Version:    0.7.0.1
 */