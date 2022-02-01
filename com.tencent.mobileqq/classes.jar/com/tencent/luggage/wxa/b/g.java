package com.tencent.luggage.wxa.b;

class g
  extends h
{
  private final String d;
  
  g(String paramString)
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
    parami.c(this.d);
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
    paramObject = (g)paramObject;
    return this.d.equals(paramObject.d);
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  public boolean i()
  {
    return true;
  }
  
  public String j()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.g
 * JD-Core Version:    0.7.0.1
 */