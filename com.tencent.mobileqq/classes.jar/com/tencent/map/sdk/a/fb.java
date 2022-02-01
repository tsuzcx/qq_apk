package com.tencent.map.sdk.a;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class fb<T>
  extends ee<T>
{
  private final dn a;
  private final ee<T> b;
  private final Type c;
  
  fb(dn paramdn, ee<T> paramee, Type paramType)
  {
    this.a = paramdn;
    this.b = paramee;
    this.c = paramType;
  }
  
  public final T a(fe paramfe)
  {
    return this.b.a(paramfe);
  }
  
  public final void a(fg paramfg, T paramT)
  {
    Object localObject1 = this.b;
    Object localObject3 = this.c;
    Object localObject2 = localObject3;
    if (paramT != null) {
      if ((localObject3 != Object.class) && (!(localObject3 instanceof TypeVariable)))
      {
        localObject2 = localObject3;
        if (!(localObject3 instanceof Class)) {}
      }
      else
      {
        localObject2 = paramT.getClass();
      }
    }
    if (localObject2 != this.c)
    {
      localObject2 = this.a.a(fd.a((Type)localObject2));
      localObject1 = localObject2;
      if ((localObject2 instanceof ey.a))
      {
        localObject3 = this.b;
        localObject1 = localObject2;
        if (!(localObject3 instanceof ey.a)) {
          localObject1 = localObject3;
        }
      }
    }
    ((ee)localObject1).a(paramfg, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fb
 * JD-Core Version:    0.7.0.1
 */