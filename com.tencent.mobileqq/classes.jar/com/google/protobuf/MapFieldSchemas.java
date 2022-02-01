package com.google.protobuf;

import java.lang.reflect.Constructor;

final class MapFieldSchemas
{
  private static final MapFieldSchema a = ;
  private static final MapFieldSchema b = new MapFieldSchemaLite();
  
  static MapFieldSchema a()
  {
    return a;
  }
  
  static MapFieldSchema b()
  {
    return b;
  }
  
  private static MapFieldSchema c()
  {
    try
    {
      MapFieldSchema localMapFieldSchema = (MapFieldSchema)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localMapFieldSchema;
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
 * Qualified Name:     com.google.protobuf.MapFieldSchemas
 * JD-Core Version:    0.7.0.1
 */