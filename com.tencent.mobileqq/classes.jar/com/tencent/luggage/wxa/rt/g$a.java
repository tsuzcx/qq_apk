package com.tencent.luggage.wxa.rt;

final class g$a
  extends h.b
  implements Comparable<String>
{
  final int a;
  
  g$a(String paramString1, String paramString2, d paramd, int paramInt)
  {
    super(paramString1, paramString2, paramd);
    this.a = paramInt;
  }
  
  public int a(String paramString)
  {
    return this.b.compareTo(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.d.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.g.a
 * JD-Core Version:    0.7.0.1
 */