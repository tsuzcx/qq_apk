package com.tencent.map.sdk.a;

final class ed$a
  implements ef
{
  private final fd<?> a;
  private final boolean b;
  private final Class<?> c;
  private final ea<?> d;
  private final ds<?> e;
  
  private ed$a(Object paramObject, fd<?> paramfd, boolean paramBoolean)
  {
    ea localea;
    if ((paramObject instanceof ea))
    {
      localea = (ea)paramObject;
      this.d = localea;
      if (!(paramObject instanceof ds)) {
        break label84;
      }
      paramObject = (ds)paramObject;
      label35:
      this.e = paramObject;
      if ((this.d == null) && (this.e == null)) {
        break label89;
      }
    }
    label84:
    label89:
    for (boolean bool = true;; bool = false)
    {
      eg.a(bool);
      this.a = paramfd;
      this.b = paramBoolean;
      this.c = null;
      return;
      localea = null;
      break;
      paramObject = null;
      break label35;
    }
  }
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    boolean bool;
    if (this.a != null) {
      if ((this.a.equals(paramfd)) || ((this.b) && (this.a.b == paramfd.a))) {
        bool = true;
      }
    }
    while (bool)
    {
      return new ed(this.d, this.e, paramdn, paramfd, this, (byte)0);
      bool = false;
      continue;
      bool = this.c.isAssignableFrom(paramfd.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ed.a
 * JD-Core Version:    0.7.0.1
 */