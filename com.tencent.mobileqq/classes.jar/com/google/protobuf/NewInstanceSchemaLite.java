package com.google.protobuf;

final class NewInstanceSchemaLite
  implements NewInstanceSchema
{
  public Object a(Object paramObject)
  {
    return ((GeneratedMessageLite)paramObject).a(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.NewInstanceSchemaLite
 * JD-Core Version:    0.7.0.1
 */