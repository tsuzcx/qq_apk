package com.tencent.luggage.wxa.b;

public class e$b
{
  private final String a;
  private final h b;
  
  e$b(String paramString, h paramh)
  {
    this.a = paramString;
    this.b = paramh;
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
    paramObject = (b)paramObject;
    return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b));
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() + 31) * 31 + this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.e.b
 * JD-Core Version:    0.7.0.1
 */