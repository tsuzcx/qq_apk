package com.tencent.luggage.wxa.b;

class d
  extends h
{
  private final String d;
  
  d(String paramString)
  {
    if (paramString != null)
    {
      this.d = paramString;
      return;
    }
    throw new NullPointerException("string is null");
  }
  
  void a(i parami)
  {
    parami.b(this.d);
  }
  
  public boolean e()
  {
    return true;
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
    paramObject = (d)paramObject;
    return this.d.equals(paramObject.d);
  }
  
  public int f()
  {
    return Integer.parseInt(this.d, 10);
  }
  
  public long g()
  {
    return Long.parseLong(this.d, 10);
  }
  
  public double h()
  {
    return Double.parseDouble(this.d);
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
 * Qualified Name:     com.tencent.luggage.wxa.b.d
 * JD-Core Version:    0.7.0.1
 */