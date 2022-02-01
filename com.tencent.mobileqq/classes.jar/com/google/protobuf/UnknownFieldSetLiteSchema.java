package com.google.protobuf;

class UnknownFieldSetLiteSchema
  extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite>
{
  UnknownFieldSetLite a(UnknownFieldSetLite paramUnknownFieldSetLite)
  {
    paramUnknownFieldSetLite.c();
    return paramUnknownFieldSetLite;
  }
  
  UnknownFieldSetLite a(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2)
  {
    if (paramUnknownFieldSetLite2.equals(UnknownFieldSetLite.a())) {
      return paramUnknownFieldSetLite1;
    }
    return UnknownFieldSetLite.a(paramUnknownFieldSetLite1, paramUnknownFieldSetLite2);
  }
  
  void a(UnknownFieldSetLite paramUnknownFieldSetLite, int paramInt1, int paramInt2)
  {
    paramUnknownFieldSetLite.a(WireFormat.a(paramInt1, 5), Integer.valueOf(paramInt2));
  }
  
  void a(UnknownFieldSetLite paramUnknownFieldSetLite, int paramInt, long paramLong)
  {
    paramUnknownFieldSetLite.a(WireFormat.a(paramInt, 0), Long.valueOf(paramLong));
  }
  
  void a(UnknownFieldSetLite paramUnknownFieldSetLite, int paramInt, ByteString paramByteString)
  {
    paramUnknownFieldSetLite.a(WireFormat.a(paramInt, 2), paramByteString);
  }
  
  void a(UnknownFieldSetLite paramUnknownFieldSetLite1, int paramInt, UnknownFieldSetLite paramUnknownFieldSetLite2)
  {
    paramUnknownFieldSetLite1.a(WireFormat.a(paramInt, 3), paramUnknownFieldSetLite2);
  }
  
  void a(UnknownFieldSetLite paramUnknownFieldSetLite, Writer paramWriter)
  {
    paramUnknownFieldSetLite.b(paramWriter);
  }
  
  void a(Object paramObject, UnknownFieldSetLite paramUnknownFieldSetLite)
  {
    ((GeneratedMessageLite)paramObject).a = paramUnknownFieldSetLite;
  }
  
  boolean a(Reader paramReader)
  {
    return false;
  }
  
  int b(UnknownFieldSetLite paramUnknownFieldSetLite)
  {
    return paramUnknownFieldSetLite.f();
  }
  
  UnknownFieldSetLite b()
  {
    return UnknownFieldSetLite.b();
  }
  
  void b(UnknownFieldSetLite paramUnknownFieldSetLite, int paramInt, long paramLong)
  {
    paramUnknownFieldSetLite.a(WireFormat.a(paramInt, 1), Long.valueOf(paramLong));
  }
  
  void b(UnknownFieldSetLite paramUnknownFieldSetLite, Writer paramWriter)
  {
    paramUnknownFieldSetLite.a(paramWriter);
  }
  
  void b(Object paramObject, UnknownFieldSetLite paramUnknownFieldSetLite)
  {
    a(paramObject, paramUnknownFieldSetLite);
  }
  
  int c(UnknownFieldSetLite paramUnknownFieldSetLite)
  {
    return paramUnknownFieldSetLite.e();
  }
  
  void d(Object paramObject)
  {
    g(paramObject).c();
  }
  
  UnknownFieldSetLite g(Object paramObject)
  {
    return ((GeneratedMessageLite)paramObject).a;
  }
  
  UnknownFieldSetLite h(Object paramObject)
  {
    UnknownFieldSetLite localUnknownFieldSetLite2 = g(paramObject);
    UnknownFieldSetLite localUnknownFieldSetLite1 = localUnknownFieldSetLite2;
    if (localUnknownFieldSetLite2 == UnknownFieldSetLite.a())
    {
      localUnknownFieldSetLite1 = UnknownFieldSetLite.b();
      a(paramObject, localUnknownFieldSetLite1);
    }
    return localUnknownFieldSetLite1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSetLiteSchema
 * JD-Core Version:    0.7.0.1
 */