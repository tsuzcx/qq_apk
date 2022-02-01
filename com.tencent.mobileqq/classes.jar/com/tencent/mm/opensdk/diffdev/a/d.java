package com.tencent.mm.opensdk.diffdev.a;

public enum d
{
  private int a;
  
  static
  {
    d locald = new d("UUID_ERROR", 5, 500);
    g = locald;
    h = new d[] { b, c, d, e, f, locald };
  }
  
  private d(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UUIDStatusCode:");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d
 * JD-Core Version:    0.7.0.1
 */