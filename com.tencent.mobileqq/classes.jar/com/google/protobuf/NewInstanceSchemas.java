package com.google.protobuf;

import java.lang.reflect.Constructor;

final class NewInstanceSchemas
{
  private static final NewInstanceSchema a = ;
  private static final NewInstanceSchema b = new NewInstanceSchemaLite();
  
  static NewInstanceSchema a()
  {
    return a;
  }
  
  static NewInstanceSchema b()
  {
    return b;
  }
  
  private static NewInstanceSchema c()
  {
    try
    {
      NewInstanceSchema localNewInstanceSchema = (NewInstanceSchema)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localNewInstanceSchema;
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
 * Qualified Name:     com.google.protobuf.NewInstanceSchemas
 * JD-Core Version:    0.7.0.1
 */