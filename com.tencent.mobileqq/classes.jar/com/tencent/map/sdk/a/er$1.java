package com.tencent.map.sdk.a;

import java.lang.reflect.GenericArrayType;

final class er$1
  implements ef
{
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    paramfd = paramfd.b;
    if ((!(paramfd instanceof GenericArrayType)) && ((!(paramfd instanceof Class)) || (!((Class)paramfd).isArray()))) {
      return null;
    }
    paramfd = eh.d(paramfd);
    return new er(paramdn, paramdn.a(fd.a(paramfd)), eh.b(paramfd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.er.1
 * JD-Core Version:    0.7.0.1
 */