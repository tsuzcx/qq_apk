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
    if ((paramObject instanceof ea)) {
      localea = (ea)paramObject;
    } else {
      localea = null;
    }
    this.d = localea;
    if ((paramObject instanceof ds)) {
      paramObject = (ds)paramObject;
    } else {
      paramObject = null;
    }
    this.e = paramObject;
    boolean bool;
    if ((this.d == null) && (this.e == null)) {
      bool = false;
    } else {
      bool = true;
    }
    eg.a(bool);
    this.a = paramfd;
    this.b = paramBoolean;
    this.c = null;
  }
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    fd localfd = this.a;
    boolean bool;
    if (localfd != null)
    {
      if ((!localfd.equals(paramfd)) && ((!this.b) || (this.a.b != paramfd.a))) {
        bool = false;
      } else {
        bool = true;
      }
    }
    else {
      bool = this.c.isAssignableFrom(paramfd.a);
    }
    if (bool) {
      return new ed(this.d, this.e, paramdn, paramfd, this, (byte)0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ed.a
 * JD-Core Version:    0.7.0.1
 */