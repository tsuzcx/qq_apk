package com.tencent.luggage.wxa.rt;

final class e$d
{
  final d a;
  final String b;
  final int c;
  
  private e$d(d paramd, String paramString, int paramInt)
  {
    this.a = paramd;
    this.b = paramString;
    this.c = paramInt;
  }
  
  boolean a()
  {
    return this.a != null;
  }
  
  public String toString()
  {
    if (!a()) {
      return "[INVALID]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(this.a.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.e.d
 * JD-Core Version:    0.7.0.1
 */