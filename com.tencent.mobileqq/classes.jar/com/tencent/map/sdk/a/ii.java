package com.tencent.map.sdk.a;

public final class ii
{
  public final String a;
  public final String b;
  public final int c;
  public final String[] d;
  
  public ii(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    if (paramArrayOfString == null)
    {
      paramString1 = null;
    }
    else
    {
      paramString1 = new String[paramArrayOfString.length];
      System.arraycopy(paramArrayOfString, 0, paramString1, 0, paramString1.length);
    }
    this.d = paramString1;
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ii
 * JD-Core Version:    0.7.0.1
 */