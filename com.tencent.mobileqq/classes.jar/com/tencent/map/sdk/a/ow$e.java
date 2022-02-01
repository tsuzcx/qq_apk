package com.tencent.map.sdk.a;

import android.support.annotation.NonNull;

final class ow$e<T>
  implements ow.f<T>
{
  private final ow.d<T> a;
  private final ow.j<T> b;
  private final ow.f<T> c;
  
  ow$e(@NonNull ow.f<T> paramf, @NonNull ow.d<T> paramd, @NonNull ow.j<T> paramj)
  {
    this.c = paramf;
    this.a = paramd;
    this.b = paramj;
  }
  
  public final T a()
  {
    Object localObject2 = this.c.a();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.a.a();
      or.a("PoolUtil", "Created new ".concat(String.valueOf(localObject1)));
    }
    if ((localObject1 instanceof ow.g)) {
      ((ow.g)localObject1).b().a(false);
    }
    return localObject1;
  }
  
  public final boolean a(@NonNull T paramT)
  {
    if ((paramT instanceof ow.g)) {
      ((ow.g)paramT).b().a(true);
    }
    return this.c.a(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ow.e
 * JD-Core Version:    0.7.0.1
 */