package com.a;

public final class b
  implements g, Cloneable
{
  private final String a;
  private final String b;
  
  public b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "key";
    }
    this.a = str;
    this.b = paramString2;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final Object clone()
  {
    return super.clone();
  }
  
  public final String toString()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.a.b
 * JD-Core Version:    0.7.0.1
 */