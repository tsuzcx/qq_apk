package com.tencent.map.sdk.a;

public enum qh
{
  public final int e;
  
  private qh(int paramInt)
  {
    this.e = paramInt;
  }
  
  public static qh a(int paramInt)
  {
    qh[] arrayOfqh = values();
    int j = arrayOfqh.length;
    int i = 0;
    while (i < j)
    {
      qh localqh = arrayOfqh[i];
      if (localqh.e == paramInt) {
        return localqh;
      }
      i += 1;
    }
    return a;
  }
  
  public static int b(int paramInt)
  {
    switch (qh.1.a[a(paramInt).ordinal()])
    {
    case 3: 
    default: 
      return 5;
    case 1: 
      return 10;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.qh
 * JD-Core Version:    0.7.0.1
 */