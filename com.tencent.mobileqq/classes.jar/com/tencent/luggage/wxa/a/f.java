package com.tencent.luggage.wxa.a;

public class f
{
  public static final f a = new f(null, null);
  public static final f b = new f(f.a.a, null);
  public static final f c = new f(f.a.f, f.b.a);
  public static final f d = new f(f.a.b, f.b.a);
  public static final f e = new f(f.a.j, f.b.a);
  public static final f f = new f(f.a.c, f.b.a);
  public static final f g = new f(f.a.i, f.b.a);
  public static final f h = new f(f.a.f, f.b.b);
  public static final f i = new f(f.a.b, f.b.b);
  private f.a j;
  private f.b k;
  
  f(f.a parama, f.b paramb)
  {
    this.j = parama;
    this.k = paramb;
  }
  
  public f.a a()
  {
    return this.j;
  }
  
  public f.b b()
  {
    return this.k;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (f)paramObject;
    return (this.j == paramObject.j) && (this.k == paramObject.k);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.k);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.f
 * JD-Core Version:    0.7.0.1
 */