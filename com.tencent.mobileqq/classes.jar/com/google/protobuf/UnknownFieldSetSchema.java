package com.google.protobuf;

class UnknownFieldSetSchema
  extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder>
{
  int a(UnknownFieldSet paramUnknownFieldSet)
  {
    return paramUnknownFieldSet.getSerializedSize();
  }
  
  UnknownFieldSet a(UnknownFieldSet.Builder paramBuilder)
  {
    return paramBuilder.a();
  }
  
  UnknownFieldSet a(UnknownFieldSet paramUnknownFieldSet1, UnknownFieldSet paramUnknownFieldSet2)
  {
    return paramUnknownFieldSet1.g().a(paramUnknownFieldSet2).a();
  }
  
  void a(UnknownFieldSet.Builder paramBuilder, int paramInt1, int paramInt2)
  {
    paramBuilder.a(paramInt1, UnknownFieldSet.Field.a().a(paramInt2).a());
  }
  
  void a(UnknownFieldSet.Builder paramBuilder, int paramInt, long paramLong)
  {
    paramBuilder.a(paramInt, UnknownFieldSet.Field.a().a(paramLong).a());
  }
  
  void a(UnknownFieldSet.Builder paramBuilder, int paramInt, ByteString paramByteString)
  {
    paramBuilder.a(paramInt, UnknownFieldSet.Field.a().a(paramByteString).a());
  }
  
  void a(UnknownFieldSet.Builder paramBuilder, int paramInt, UnknownFieldSet paramUnknownFieldSet)
  {
    paramBuilder.a(paramInt, UnknownFieldSet.Field.a().a(paramUnknownFieldSet).a());
  }
  
  void a(UnknownFieldSet paramUnknownFieldSet, Writer paramWriter)
  {
    paramUnknownFieldSet.a(paramWriter);
  }
  
  void a(Object paramObject, UnknownFieldSet.Builder paramBuilder)
  {
    ((GeneratedMessageV3)paramObject).unknownFields = paramBuilder.a();
  }
  
  void a(Object paramObject, UnknownFieldSet paramUnknownFieldSet)
  {
    ((GeneratedMessageV3)paramObject).unknownFields = paramUnknownFieldSet;
  }
  
  boolean a(Reader paramReader)
  {
    return paramReader.a();
  }
  
  int b(UnknownFieldSet paramUnknownFieldSet)
  {
    return paramUnknownFieldSet.e();
  }
  
  UnknownFieldSet.Builder b()
  {
    return UnknownFieldSet.a();
  }
  
  void b(UnknownFieldSet.Builder paramBuilder, int paramInt, long paramLong)
  {
    paramBuilder.a(paramInt, UnknownFieldSet.Field.a().b(paramLong).a());
  }
  
  void b(UnknownFieldSet paramUnknownFieldSet, Writer paramWriter)
  {
    paramUnknownFieldSet.b(paramWriter);
  }
  
  void d(Object paramObject) {}
  
  UnknownFieldSet g(Object paramObject)
  {
    return ((GeneratedMessageV3)paramObject).unknownFields;
  }
  
  UnknownFieldSet.Builder h(Object paramObject)
  {
    return ((GeneratedMessageV3)paramObject).unknownFields.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSetSchema
 * JD-Core Version:    0.7.0.1
 */