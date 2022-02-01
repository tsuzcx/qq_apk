package com.tencent.map.sdk.a;

import java.math.BigInteger;

public final class dy
  extends dt
{
  private static final Class<?>[] b = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  public Object a;
  
  public dy(Boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  public dy(Number paramNumber)
  {
    a(paramNumber);
  }
  
  public dy(String paramString)
  {
    a(paramString);
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof Character))
    {
      this.a = String.valueOf(((Character)paramObject).charValue());
      return;
    }
    if (((paramObject instanceof Number)) || (b(paramObject))) {}
    for (boolean bool = true;; bool = false)
    {
      eg.a(bool);
      this.a = paramObject;
      return;
    }
  }
  
  private static boolean a(dy paramdy)
  {
    if ((paramdy.a instanceof Number))
    {
      paramdy = (Number)paramdy.a;
      return ((paramdy instanceof BigInteger)) || ((paramdy instanceof Long)) || ((paramdy instanceof Integer)) || ((paramdy instanceof Short)) || ((paramdy instanceof Byte));
    }
    return false;
  }
  
  private static boolean b(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return true;
    }
    paramObject = paramObject.getClass();
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label45;
      }
      if (arrayOfClass[i].isAssignableFrom(paramObject)) {
        break;
      }
      i += 1;
    }
    label45:
    return false;
  }
  
  public final Number b()
  {
    if ((this.a instanceof String)) {
      return new el((String)this.a);
    }
    return (Number)this.a;
  }
  
  public final String c()
  {
    if ((this.a instanceof Number)) {
      return b().toString();
    }
    if ((this.a instanceof Boolean)) {
      return ((Boolean)this.a).toString();
    }
    return (String)this.a;
  }
  
  public final double d()
  {
    if ((this.a instanceof Number)) {
      return b().doubleValue();
    }
    return Double.parseDouble(c());
  }
  
  public final float e()
  {
    if ((this.a instanceof Number)) {
      return b().floatValue();
    }
    return Float.parseFloat(c());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    double d1;
    double d2;
    do
    {
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (dy)paramObject;
          if (this.a != null) {
            break;
          }
        } while (paramObject.a == null);
        return false;
        if ((!a(this)) || (!a(paramObject))) {
          break;
        }
      } while (b().longValue() == paramObject.b().longValue());
      return false;
      if ((!(this.a instanceof Number)) || (!(paramObject.a instanceof Number))) {
        break;
      }
      d1 = b().doubleValue();
      d2 = paramObject.b().doubleValue();
    } while ((d1 == d2) || ((Double.isNaN(d1)) && (Double.isNaN(d2))));
    return false;
    return this.a.equals(paramObject.a);
  }
  
  public final long f()
  {
    if ((this.a instanceof Number)) {
      return b().longValue();
    }
    return Long.parseLong(c());
  }
  
  public final int g()
  {
    if ((this.a instanceof Number)) {
      return b().intValue();
    }
    return Integer.parseInt(c());
  }
  
  public final boolean h()
  {
    if ((this.a instanceof Boolean)) {
      return ((Boolean)this.a).booleanValue();
    }
    return Boolean.parseBoolean(c());
  }
  
  public final int hashCode()
  {
    if (this.a == null) {
      return 31;
    }
    long l;
    if (a(this))
    {
      l = b().longValue();
      return (int)(l ^ l >>> 32);
    }
    if ((this.a instanceof Number))
    {
      l = Double.doubleToLongBits(b().doubleValue());
      return (int)(l ^ l >>> 32);
    }
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.dy
 * JD-Core Version:    0.7.0.1
 */