package com.google.protobuf;

abstract class UnknownFieldSchema<T, B>
{
  abstract B a();
  
  abstract T a(B paramB);
  
  abstract void a(B paramB, int paramInt1, int paramInt2);
  
  abstract void a(B paramB, int paramInt, long paramLong);
  
  abstract void a(B paramB, int paramInt, ByteString paramByteString);
  
  abstract void a(B paramB, int paramInt, T paramT);
  
  abstract void a(T paramT, Writer paramWriter);
  
  abstract void a(Object paramObject, T paramT);
  
  abstract boolean a(Reader paramReader);
  
  final boolean a(B paramB, Reader paramReader)
  {
    int j = paramReader.c();
    int i = WireFormat.b(j);
    j = WireFormat.a(j);
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5)
              {
                a(paramB, i, paramReader.k());
                return true;
              }
              throw InvalidProtocolBufferException.invalidWireType();
            }
            return false;
          }
          Object localObject = a();
          j = WireFormat.a(i, 4);
          b(localObject, paramReader);
          if (j == paramReader.c())
          {
            a(paramB, i, a(localObject));
            return true;
          }
          throw InvalidProtocolBufferException.invalidEndTag();
        }
        a(paramB, i, paramReader.o());
        return true;
      }
      b(paramB, i, paramReader.j());
      return true;
    }
    a(paramB, i, paramReader.h());
    return true;
  }
  
  abstract T b(Object paramObject);
  
  abstract void b(B paramB, int paramInt, long paramLong);
  
  final void b(B paramB, Reader paramReader)
  {
    while ((paramReader.b() != 2147483647) && (a(paramB, paramReader))) {}
  }
  
  abstract void b(T paramT, Writer paramWriter);
  
  abstract void b(Object paramObject, B paramB);
  
  abstract B c(Object paramObject);
  
  abstract T c(T paramT1, T paramT2);
  
  abstract void d(Object paramObject);
  
  abstract int e(T paramT);
  
  abstract int f(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSchema
 * JD-Core Version:    0.7.0.1
 */