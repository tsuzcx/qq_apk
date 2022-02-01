package com.tencent.map.sdk.a;

public enum gh$b
{
  public final int g;
  
  private gh$b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public static b a(int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < values().length) {}
    }
    else
    {
      i = 0;
    }
    b localb1 = a;
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    paramInt = 0;
    while (paramInt < j)
    {
      b localb2 = arrayOfb[paramInt];
      if (localb2.g == i) {
        return localb2;
      }
      paramInt += 1;
    }
    return localb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.gh.b
 * JD-Core Version:    0.7.0.1
 */