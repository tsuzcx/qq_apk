package com.google.protobuf;

import java.util.Arrays;

public final class UnknownFieldSetLite
{
  private static final UnknownFieldSetLite a = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
  private int b;
  private int[] c;
  private Object[] d;
  private int e = -1;
  private boolean f;
  
  private UnknownFieldSetLite()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private UnknownFieldSetLite(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = paramArrayOfInt;
    this.d = paramArrayOfObject;
    this.f = paramBoolean;
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt)
  {
    int j = 17;
    int i = 0;
    while (i < paramInt)
    {
      j = j * 31 + paramArrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  private static int a(Object[] paramArrayOfObject, int paramInt)
  {
    int j = 17;
    int i = 0;
    while (i < paramInt)
    {
      j = j * 31 + paramArrayOfObject[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public static UnknownFieldSetLite a()
  {
    return a;
  }
  
  static UnknownFieldSetLite a(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2)
  {
    int i = paramUnknownFieldSetLite1.b + paramUnknownFieldSetLite2.b;
    int[] arrayOfInt = Arrays.copyOf(paramUnknownFieldSetLite1.c, i);
    System.arraycopy(paramUnknownFieldSetLite2.c, 0, arrayOfInt, paramUnknownFieldSetLite1.b, paramUnknownFieldSetLite2.b);
    Object[] arrayOfObject = Arrays.copyOf(paramUnknownFieldSetLite1.d, i);
    System.arraycopy(paramUnknownFieldSetLite2.d, 0, arrayOfObject, paramUnknownFieldSetLite1.b, paramUnknownFieldSetLite2.b);
    return new UnknownFieldSetLite(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void a(int paramInt, Object paramObject, Writer paramWriter)
  {
    int i = WireFormat.b(paramInt);
    paramInt = WireFormat.a(paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 5)
            {
              paramWriter.g(i, ((Integer)paramObject).intValue());
              return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
          }
          if (paramWriter.a() == Writer.FieldOrder.ASCENDING)
          {
            paramWriter.h(i);
            ((UnknownFieldSetLite)paramObject).b(paramWriter);
            paramWriter.i(i);
            return;
          }
          paramWriter.i(i);
          ((UnknownFieldSetLite)paramObject).b(paramWriter);
          paramWriter.h(i);
          return;
        }
        paramWriter.a(i, (ByteString)paramObject);
        return;
      }
      paramWriter.e(i, ((Long)paramObject).longValue());
      return;
    }
    paramWriter.a(i, ((Long)paramObject).longValue());
  }
  
  private static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfObject1[i].equals(paramArrayOfObject2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  static UnknownFieldSetLite b()
  {
    return new UnknownFieldSetLite();
  }
  
  private void g()
  {
    int i = this.b;
    if (i == this.c.length)
    {
      if (i < 4) {
        i = 8;
      } else {
        i >>= 1;
      }
      i = this.b + i;
      this.c = Arrays.copyOf(this.c, i);
      this.d = Arrays.copyOf(this.d, i);
    }
  }
  
  void a(int paramInt, Object paramObject)
  {
    d();
    g();
    int[] arrayOfInt = this.c;
    int i = this.b;
    arrayOfInt[i] = paramInt;
    this.d[i] = paramObject;
    this.b = (i + 1);
  }
  
  void a(Writer paramWriter)
  {
    if (paramWriter.a() == Writer.FieldOrder.DESCENDING)
    {
      i = this.b - 1;
      while (i >= 0)
      {
        paramWriter.a(WireFormat.b(this.c[i]), this.d[i]);
        i -= 1;
      }
    }
    int i = 0;
    while (i < this.b)
    {
      paramWriter.a(WireFormat.b(this.c[i]), this.d[i]);
      i += 1;
    }
  }
  
  final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < this.b)
    {
      MessageLiteToString.a(paramStringBuilder, paramInt, String.valueOf(WireFormat.b(this.c[i])), this.d[i]);
      i += 1;
    }
  }
  
  public void b(Writer paramWriter)
  {
    if (this.b == 0) {
      return;
    }
    if (paramWriter.a() == Writer.FieldOrder.ASCENDING)
    {
      i = 0;
      while (i < this.b)
      {
        a(this.c[i], this.d[i], paramWriter);
        i += 1;
      }
    }
    int i = this.b - 1;
    while (i >= 0)
    {
      a(this.c[i], this.d[i], paramWriter);
      i -= 1;
    }
  }
  
  public void c()
  {
    this.f = false;
  }
  
  void d()
  {
    if (this.f) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public int e()
  {
    int i = this.e;
    if (i != -1) {
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.b)
    {
      j += CodedOutputStream.d(WireFormat.b(this.c[i]), (ByteString)this.d[i]);
      i += 1;
    }
    this.e = j;
    return j;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof UnknownFieldSetLite)) {
      return false;
    }
    paramObject = (UnknownFieldSetLite)paramObject;
    int i = this.b;
    if ((i == paramObject.b) && (a(this.c, paramObject.c, i))) {
      return a(this.d, paramObject.d, this.b);
    }
    return false;
  }
  
  public int f()
  {
    int i = this.e;
    if (i != -1) {
      return i;
    }
    int j = 0;
    int k = 0;
    while (j < this.b)
    {
      int m = this.c[j];
      i = WireFormat.b(m);
      m = WireFormat.a(m);
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m == 5) {
                i = CodedOutputStream.k(i, ((Integer)this.d[j]).intValue());
              } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
              }
            }
            else {
              i = CodedOutputStream.h(i) * 2 + ((UnknownFieldSetLite)this.d[j]).f();
            }
          }
          else {
            i = CodedOutputStream.c(i, (ByteString)this.d[j]);
          }
        }
        else {
          i = CodedOutputStream.i(i, ((Long)this.d[j]).longValue());
        }
      }
      else {
        i = CodedOutputStream.g(i, ((Long)this.d[j]).longValue());
      }
      k += i;
      j += 1;
    }
    this.e = k;
    return k;
  }
  
  public int hashCode()
  {
    int i = this.b;
    return ((527 + i) * 31 + a(this.c, i)) * 31 + a(this.d, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSetLite
 * JD-Core Version:    0.7.0.1
 */