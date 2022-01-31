package com.tencent.mapsdk.rastercore.b;

public final class b
{
  private c a;
  private c b;
  
  public b(c paramc1, c paramc2)
  {
    paramc1 = new a().a(paramc1).a(paramc2);
    this.a = new c(a.a(paramc1), a.b(paramc1));
    this.b = new c(a.c(paramc1), a.d(paramc1));
  }
  
  public final c a()
  {
    return this.a;
  }
  
  public final c b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
    } while ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)));
    return false;
  }
  
  public final int hashCode()
  {
    return com.tencent.mapsdk.rastercore.f.b.a(new Object[] { this.a, this.b });
  }
  
  public final String toString()
  {
    return com.tencent.mapsdk.rastercore.f.b.a(new String[] { com.tencent.mapsdk.rastercore.f.b.a("southwest", this.a), com.tencent.mapsdk.rastercore.f.b.a("northeast", this.b) });
  }
  
  public static final class a
  {
    private double a = 1.7976931348623157E+308D;
    private double b = -1.797693134862316E+308D;
    private double c = 1.7976931348623157E+308D;
    private double d = -1.797693134862316E+308D;
    
    public final a a(c paramc)
    {
      this.a = Math.min(this.a, paramc.a());
      this.b = Math.max(this.b, paramc.a());
      this.d = Math.max(this.d, paramc.b());
      this.c = Math.min(this.c, paramc.b());
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.b.b
 * JD-Core Version:    0.7.0.1
 */