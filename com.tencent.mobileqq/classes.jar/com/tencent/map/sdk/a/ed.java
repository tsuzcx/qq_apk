package com.tencent.map.sdk.a;

public final class ed<T>
  extends ee<T>
{
  private final ea<T> a;
  private final ds<T> b;
  private final dn c;
  private final fd<T> d;
  private final ef e;
  private ee<T> f;
  
  private ed(ea<T> paramea, ds<T> paramds, dn paramdn, fd<T> paramfd, ef paramef)
  {
    this.a = paramea;
    this.b = paramds;
    this.c = paramdn;
    this.d = paramfd;
    this.e = paramef;
  }
  
  private ee<T> a()
  {
    ee localee = this.f;
    if (localee != null) {
      return localee;
    }
    localee = this.c.a(this.e, this.d);
    this.f = localee;
    return localee;
  }
  
  public static ef a(fd<?> paramfd, Object paramObject)
  {
    return new ed.a(paramObject, paramfd, false, (byte)0);
  }
  
  public final T a(fe paramfe)
  {
    if (this.b == null) {
      return a().a(paramfe);
    }
    paramfe = ep.a(paramfe);
    if ((paramfe instanceof dv)) {
      return null;
    }
    return this.b.a(paramfe, this.d.b, this.c.a);
  }
  
  public final void a(fg paramfg, T paramT)
  {
    if (this.a == null)
    {
      a().a(paramfg, paramT);
      return;
    }
    if (paramT == null)
    {
      paramfg.e();
      return;
    }
    ep.a(this.a.a(paramT), paramfg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ed
 * JD-Core Version:    0.7.0.1
 */