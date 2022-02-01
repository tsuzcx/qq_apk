package com.a;

public final class e
  implements m, Cloneable
{
  private final int a;
  
  public e(l paraml, int paramInt, String paramString)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Status code may not be negative.");
    }
    this.a = paramInt;
  }
  
  public final int a()
  {
    return this.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.a.e
 * JD-Core Version:    0.7.0.1
 */