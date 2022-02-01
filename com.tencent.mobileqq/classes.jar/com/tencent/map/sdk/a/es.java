package com.tencent.map.sdk.a;

import java.lang.reflect.Type;
import java.util.Collection;

public final class es
  implements ef
{
  private final ei a;
  
  public es(ei paramei)
  {
    this.a = paramei;
  }
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    Type localType = paramfd.b;
    Class localClass = paramfd.a;
    if (!Collection.class.isAssignableFrom(localClass)) {
      return null;
    }
    localType = eh.a(localType, localClass);
    return new es.a(this, paramdn, localType, paramdn.a(fd.a(localType)), this.a.a(paramfd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.es
 * JD-Core Version:    0.7.0.1
 */