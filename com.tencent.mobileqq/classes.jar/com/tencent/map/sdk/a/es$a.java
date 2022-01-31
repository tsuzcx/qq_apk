package com.tencent.map.sdk.a;

import java.lang.reflect.Type;
import java.util.Collection;

final class es$a<E>
  extends ee<Collection<E>>
{
  private final dn b;
  private final Type c;
  private final ee<E> d;
  private final en<? extends Collection<E>> e;
  
  public es$a(dn paramdn, Type paramType, ee<E> paramee, en<? extends Collection<E>> paramen)
  {
    this.b = paramType;
    this.c = paramee;
    this.d = new fb(paramType, paramen, paramee);
    Object localObject;
    this.e = localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.es.a
 * JD-Core Version:    0.7.0.1
 */