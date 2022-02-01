package com.tencent.map.sdk.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class er<E>
  extends ee<Object>
{
  public static final ef a = new er.1();
  private final dn b;
  private final Class<E> c;
  private final ee<E> d;
  
  public er(dn paramdn, ee<E> paramee, Class<E> paramClass)
  {
    this.b = paramdn;
    this.d = new fb(paramdn, paramee, paramClass);
    this.c = paramClass;
  }
  
  public final Object a(fe paramfe)
  {
    if (paramfe.f() == ff.i)
    {
      paramfe.k();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramfe.a();
    while (paramfe.e()) {
      localArrayList.add(this.d.a(paramfe));
    }
    paramfe.b();
    paramfe = Array.newInstance(this.c, localArrayList.size());
    int i = 0;
    while (i < localArrayList.size())
    {
      Array.set(paramfe, i, localArrayList.get(i));
      i += 1;
    }
    return paramfe;
  }
  
  public final void a(fg paramfg, Object paramObject)
  {
    if (paramObject == null)
    {
      paramfg.e();
      return;
    }
    paramfg.a();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.d.a(paramfg, localObject);
      i += 1;
    }
    paramfg.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.er
 * JD-Core Version:    0.7.0.1
 */