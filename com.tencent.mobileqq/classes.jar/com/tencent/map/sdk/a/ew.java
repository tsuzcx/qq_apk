package com.tencent.map.sdk.a;

import java.lang.reflect.Type;
import java.util.Map;

public final class ew
  implements ef
{
  final boolean a;
  private final ei b;
  
  public ew(ei paramei, boolean paramBoolean)
  {
    this.b = paramei;
    this.a = paramBoolean;
  }
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    Object localObject = paramfd.b;
    if (!Map.class.isAssignableFrom(paramfd.a)) {
      return null;
    }
    Type[] arrayOfType = eh.b((Type)localObject, eh.b((Type)localObject));
    localObject = arrayOfType[0];
    if ((localObject == Boolean.TYPE) || (localObject == Boolean.class)) {}
    for (localObject = fc.f;; localObject = paramdn.a(fd.a((Type)localObject)))
    {
      ee localee = paramdn.a(fd.a(arrayOfType[1]));
      paramfd = this.b.a(paramfd);
      return new ew.a(this, paramdn, arrayOfType[0], (ee)localObject, arrayOfType[1], localee, paramfd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ew
 * JD-Core Version:    0.7.0.1
 */