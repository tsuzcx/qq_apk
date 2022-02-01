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
    boolean bool;
    if ((!(paramObject instanceof Number)) && (!b(paramObject))) {
      bool = false;
    } else {
      bool = true;
    }
    eg.a(bool);
    this.a = paramObject;
  }
  
  private static boolean a(dy paramdy)
  {
    paramdy = paramdy.a;
    if ((paramdy instanceof Number))
    {
      paramdy = (Number)paramdy;
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
    while (i < j)
    {
      if (arrayOfClass[i].isAssignableFrom(paramObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final Number b()
  {
    Object localObject = this.a;
    if ((localObject instanceof String)) {
      return new el((String)localObject);
    }
    return (Number)localObject;
  }
  
  public final String c()
  {
    Object localObject = this.a;
    if ((localObject instanceof Number)) {
      return b().toString();
    }
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).toString();
    }
    return (String)localObject;
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (dy)paramObject;
      if (this.a == null) {
        return paramObject.a == null;
      }
      if ((a(this)) && (a(paramObject))) {
        return b().longValue() == paramObject.b().longValue();
      }
      if (((this.a instanceof Number)) && ((paramObject.a instanceof Number)))
      {
        double d1 = b().doubleValue();
        double d2 = paramObject.b().doubleValue();
        if (d1 != d2) {
          return (Double.isNaN(d1)) && (Double.isNaN(d2));
        }
        return true;
      }
      return this.a.equals(paramObject.a);
    }
    return false;
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
    Object localObject = this.a;
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return Boolean.parseBoolean(c());
  }
  
  public final int hashCode()
  {
    if (this.a == null) {
      return 31;
    }
    if (a(this)) {}
    Object localObject;
    for (long l = b().longValue();; l = Double.doubleToLongBits(b().doubleValue()))
    {
      return (int)(l >>> 32 ^ l);
      localObject = this.a;
      if (!(localObject instanceof Number)) {
        break;
      }
    }
    return localObject.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.dy
 * JD-Core Version:    0.7.0.1
 */