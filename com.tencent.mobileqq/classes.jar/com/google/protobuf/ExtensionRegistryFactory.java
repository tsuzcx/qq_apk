package com.google.protobuf;

import java.lang.reflect.Method;

final class ExtensionRegistryFactory
{
  static final Class<?> a = ;
  
  private static final ExtensionRegistryLite a(String paramString)
  {
    return (ExtensionRegistryLite)a.getDeclaredMethod(paramString, new Class[0]).invoke(null, new Object[0]);
  }
  
  static Class<?> a()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.ExtensionRegistry");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public static ExtensionRegistryLite b()
  {
    if (a != null) {}
    try
    {
      ExtensionRegistryLite localExtensionRegistryLite = a("getEmptyRegistry");
      return localExtensionRegistryLite;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    return ExtensionRegistryLite.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionRegistryFactory
 * JD-Core Version:    0.7.0.1
 */