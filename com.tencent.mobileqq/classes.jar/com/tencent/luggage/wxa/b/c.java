package com.tencent.luggage.wxa.b;

class c
  extends h
{
  private final String d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  
  c(String paramString)
  {
    this.d = paramString;
    this.e = "null".equals(paramString);
    this.f = "true".equals(paramString);
    this.g = "false".equals(paramString);
  }
  
  void a(i parami)
  {
    parami.a(this.d);
  }
  
  public boolean a()
  {
    return (this.f) || (this.g);
  }
  
  public boolean d()
  {
    if (this.e) {
      return super.d();
    }
    return this.f;
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
    paramObject = (c)paramObject;
    return this.d.equals(paramObject.d);
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  public String toString()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.c
 * JD-Core Version:    0.7.0.1
 */