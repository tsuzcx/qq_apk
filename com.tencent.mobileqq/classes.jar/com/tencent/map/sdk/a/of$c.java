package com.tencent.map.sdk.a;

public abstract class of$c
  implements ny.a
{
  of.a g;
  public int h = 104857600;
  public of.b i = of.d();
  
  public of$c(of.a parama)
  {
    this.g = parama;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Options{mType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mCacheSize=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", keyGenerator=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.of.c
 * JD-Core Version:    0.7.0.1
 */