package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class Protobuf
{
  private static final Protobuf a = new Protobuf();
  private final SchemaFactory b = new ManifestSchemaFactory();
  private final ConcurrentMap<Class<?>, Schema<?>> c = new ConcurrentHashMap();
  
  public static Protobuf a()
  {
    return a;
  }
  
  public <T> Schema<T> a(Class<T> paramClass)
  {
    Internal.a(paramClass, "messageType");
    Schema localSchema = (Schema)this.c.get(paramClass);
    Object localObject = localSchema;
    if (localSchema == null)
    {
      localObject = this.b.a(paramClass);
      paramClass = a(paramClass, (Schema)localObject);
      if (paramClass != null) {
        localObject = paramClass;
      }
    }
    return localObject;
  }
  
  public Schema<?> a(Class<?> paramClass, Schema<?> paramSchema)
  {
    Internal.a(paramClass, "messageType");
    Internal.a(paramSchema, "schema");
    return (Schema)this.c.putIfAbsent(paramClass, paramSchema);
  }
  
  public <T> Schema<T> a(T paramT)
  {
    return a(paramT.getClass());
  }
  
  public <T> void a(T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    a(paramT).a(paramT, paramReader, paramExtensionRegistryLite);
  }
  
  public <T> void a(T paramT, Writer paramWriter)
  {
    a(paramT).a(paramT, paramWriter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Protobuf
 * JD-Core Version:    0.7.0.1
 */