package com.tencent.mapsdk.rastercore.b;

import com.tencent.mapsdk.rastercore.f.b;

public final class e
{
  private f a;
  private f b;
  
  public e(f paramf1, f paramf2)
  {
    paramf1 = new a().a(paramf1).a(paramf2);
    this.a = new f(a.a(paramf1), a.b(paramf1));
    this.b = new f(a.c(paramf1), a.d(paramf1));
  }
  
  public final f a()
  {
    return this.a;
  }
  
  public final f b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
    } while ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)));
    return false;
  }
  
  public final int hashCode()
  {
    return b.a(new Object[] { this.a, this.b });
  }
  
  public final String toString()
  {
    return b.a(new String[] { b.a("southwest", this.a), b.a("northeast", this.b) });
  }
  
  public static final class a
  {
    private double a = 1.7976931348623157E+308D;
    private double b = -1.797693134862316E+308D;
    private double c = 1.7976931348623157E+308D;
    private double d = -1.797693134862316E+308D;
    
    public final a a(f paramf)
    {
      this.a = Math.min(this.a, paramf.a());
      this.b = Math.max(this.b, paramf.a());
      this.d = Math.max(this.d, paramf.b());
      this.c = Math.min(this.c, paramf.b());
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.b.e
 * JD-Core Version:    0.7.0.1
 */