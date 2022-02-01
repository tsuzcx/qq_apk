package com.tencent.luggage.wxa.sx;

import java.util.LinkedList;

public class a
{
  private final com.tencent.luggage.wxa.sy.b a;
  private final com.tencent.luggage.wxa.ta.a b;
  private int c = 0;
  
  public a(byte[] paramArrayOfByte, com.tencent.luggage.wxa.sy.b paramb)
  {
    this.b = com.tencent.luggage.wxa.ta.a.a(paramArrayOfByte);
    this.a = paramb;
  }
  
  public int a()
  {
    this.c = this.b.a();
    return com.tencent.luggage.wxa.sz.a.b(this.c);
  }
  
  public int a(int paramInt)
  {
    return this.b.e();
  }
  
  public int b(int paramInt)
  {
    return a(paramInt);
  }
  
  public void b()
  {
    int i = com.tencent.luggage.wxa.sz.a.a(this.c);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ");
    localStringBuffer.append(com.tencent.luggage.wxa.sz.a.b(this.c));
    localStringBuffer.append(" - ");
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 5)
          {
            localStringBuffer.append("float value: ");
            localStringBuffer.append(Float.toString(this.b.c()));
          }
        }
        else
        {
          localStringBuffer.append("Length delimited (String or ByteString) value: ");
          localStringBuffer.append(this.b.g());
        }
      }
      else
      {
        localStringBuffer.append("double value: ");
        localStringBuffer.append(Double.toString(this.b.b()));
      }
    }
    else
    {
      localStringBuffer.append("varint (long, int or boolean) value: ");
      localStringBuffer.append(this.b.i());
    }
    this.a.a(localStringBuffer.toString());
  }
  
  public String c(int paramInt)
  {
    return this.b.g();
  }
  
  public boolean d(int paramInt)
  {
    return this.b.f();
  }
  
  public double e(int paramInt)
  {
    return this.b.b();
  }
  
  public float f(int paramInt)
  {
    return this.b.c();
  }
  
  public long g(int paramInt)
  {
    return this.b.d();
  }
  
  public com.tencent.luggage.wxa.qu.b h(int paramInt)
  {
    return this.b.h();
  }
  
  public LinkedList<byte[]> i(int paramInt)
  {
    return this.b.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sx.a
 * JD-Core Version:    0.7.0.1
 */