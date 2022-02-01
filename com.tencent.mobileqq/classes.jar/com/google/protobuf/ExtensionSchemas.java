package com.google.protobuf;

import java.lang.reflect.Constructor;

final class ExtensionSchemas
{
  private static final ExtensionSchema<?> a = new ExtensionSchemaLite();
  private static final ExtensionSchema<?> b = c();
  
  static ExtensionSchema<?> a()
  {
    return a;
  }
  
  static ExtensionSchema<?> b()
  {
    ExtensionSchema localExtensionSchema = b;
    if (localExtensionSchema != null) {
      return localExtensionSchema;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
  
  private static ExtensionSchema<?> c()
  {
    try
    {
      ExtensionSchema localExtensionSchema = (ExtensionSchema)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localExtensionSchema;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionSchemas
 * JD-Core Version:    0.7.0.1
 */