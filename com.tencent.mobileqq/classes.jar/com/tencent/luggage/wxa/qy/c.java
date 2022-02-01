package com.tencent.luggage.wxa.qy;

import com.tencent.luggage.wxa.qz.m;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b>
{
  private final int a;
  protected int b = 0;
  private com.tencent.luggage.wxa.rk.b<c> c;
  
  public c()
  {
    this(0);
  }
  
  public c(int paramInt)
  {
    this.a = paramInt;
  }
  
  int a()
  {
    return this.a;
  }
  
  public abstract boolean a(T paramT);
  
  int b()
  {
    if (this.b == 0)
    {
      long l = System.currentTimeMillis();
      Type localType2 = getClass().getGenericSuperclass();
      Type localType1 = localType2;
      if (!(localType2 instanceof ParameterizedType)) {
        localType1 = getClass().getSuperclass().getGenericSuperclass();
      }
      localType1 = ((ParameterizedType)localType1).getActualTypeArguments()[0];
      this.b = ((Class)localType1).getName().hashCode();
      o.f("IListener", "genEventID, %s<%s>, useTime:%d", new Object[] { getClass().getName(), localType1, Long.valueOf(System.currentTimeMillis() - l) });
    }
    return this.b;
  }
  
  public com.tencent.luggage.wxa.rk.b<c> c()
  {
    try
    {
      if (this.c == null)
      {
        m.a(this);
        this.c = a.a.a(this);
      }
      com.tencent.luggage.wxa.rk.b localb = this.c;
      return localb;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      if (this.c != null)
      {
        m.b((c)this.c.b());
        this.c.a();
        this.c = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qy.c
 * JD-Core Version:    0.7.0.1
 */