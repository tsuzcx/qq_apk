package com.tencent.luggage.wxa.dc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/UIN64;", "", "value", "", "(J)V", "toByte", "", "toChar", "", "toDouble", "", "toFloat", "", "toInt", "", "toLong", "toShort", "", "toString", "", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class m
  extends Number
{
  public static final m.a a = new m.a(null);
  private final long b;
  
  public m(long paramLong)
  {
    this.b = paramLong;
  }
  
  public byte a()
  {
    return (byte)(int)this.b;
  }
  
  public double b()
  {
    return this.b;
  }
  
  public final byte byteValue()
  {
    return a();
  }
  
  public float c()
  {
    return (float)this.b;
  }
  
  public int d()
  {
    return (int)this.b;
  }
  
  public final double doubleValue()
  {
    return b();
  }
  
  public long e()
  {
    return this.b;
  }
  
  public short f()
  {
    return (short)(int)this.b;
  }
  
  public final float floatValue()
  {
    return c();
  }
  
  public final int intValue()
  {
    return d();
  }
  
  public final long longValue()
  {
    return e();
  }
  
  public final short shortValue()
  {
    return f();
  }
  
  @NotNull
  public String toString()
  {
    return a.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.m
 * JD-Core Version:    0.7.0.1
 */