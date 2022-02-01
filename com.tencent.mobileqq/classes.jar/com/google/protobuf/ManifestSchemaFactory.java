package com.google.protobuf;

import java.lang.reflect.Method;

final class ManifestSchemaFactory
  implements SchemaFactory
{
  private static final MessageInfoFactory b = new ManifestSchemaFactory.1();
  private final MessageInfoFactory a;
  
  public ManifestSchemaFactory()
  {
    this(a());
  }
  
  private ManifestSchemaFactory(MessageInfoFactory paramMessageInfoFactory)
  {
    this.a = ((MessageInfoFactory)Internal.a(paramMessageInfoFactory, "messageInfoFactory"));
  }
  
  private static MessageInfoFactory a()
  {
    return new ManifestSchemaFactory.CompositeMessageInfoFactory(new MessageInfoFactory[] { GeneratedMessageInfoFactory.a(), b() });
  }
  
  private static <T> Schema<T> a(Class<T> paramClass, MessageInfo paramMessageInfo)
  {
    if (GeneratedMessageLite.class.isAssignableFrom(paramClass))
    {
      if (a(paramMessageInfo)) {
        return MessageSchema.a(paramClass, paramMessageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.c(), ExtensionSchemas.a(), MapFieldSchemas.b());
      }
      return MessageSchema.a(paramClass, paramMessageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.c(), null, MapFieldSchemas.b());
    }
    if (a(paramMessageInfo)) {
      return MessageSchema.a(paramClass, paramMessageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.a(), ExtensionSchemas.b(), MapFieldSchemas.a());
    }
    return MessageSchema.a(paramClass, paramMessageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.b(), null, MapFieldSchemas.a());
  }
  
  private static boolean a(MessageInfo paramMessageInfo)
  {
    return paramMessageInfo.a() == ProtoSyntax.PROTO2;
  }
  
  private static MessageInfoFactory b()
  {
    try
    {
      MessageInfoFactory localMessageInfoFactory = (MessageInfoFactory)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localMessageInfoFactory;
    }
    catch (Exception localException)
    {
      label28:
      break label28;
    }
    return b;
  }
  
  public <T> Schema<T> a(Class<T> paramClass)
  {
    SchemaUtil.a(paramClass);
    MessageInfo localMessageInfo = this.a.b(paramClass);
    if (localMessageInfo.b())
    {
      if (GeneratedMessageLite.class.isAssignableFrom(paramClass)) {
        return MessageSetSchema.a(SchemaUtil.c(), ExtensionSchemas.a(), localMessageInfo.c());
      }
      return MessageSetSchema.a(SchemaUtil.a(), ExtensionSchemas.b(), localMessageInfo.c());
    }
    return a(paramClass, localMessageInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ManifestSchemaFactory
 * JD-Core Version:    0.7.0.1
 */