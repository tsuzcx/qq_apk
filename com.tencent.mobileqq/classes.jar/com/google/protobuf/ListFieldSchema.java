package com.google.protobuf;

import java.util.List;

abstract class ListFieldSchema
{
  private static final ListFieldSchema a = new ListFieldSchema.ListFieldSchemaFull(null);
  private static final ListFieldSchema b = new ListFieldSchema.ListFieldSchemaLite(null);
  
  static ListFieldSchema a()
  {
    return a;
  }
  
  static ListFieldSchema b()
  {
    return b;
  }
  
  abstract <L> List<L> a(Object paramObject, long paramLong);
  
  abstract <L> void a(Object paramObject1, Object paramObject2, long paramLong);
  
  abstract void b(Object paramObject, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ListFieldSchema
 * JD-Core Version:    0.7.0.1
 */