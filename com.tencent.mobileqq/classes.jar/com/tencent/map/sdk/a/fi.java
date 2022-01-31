package com.tencent.map.sdk.a;

final class fi
{
  private final String[] a = new String[1024];
  
  public final String a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramInt2 > 20)
    {
      localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      return localObject;
    }
    paramInt3 = paramInt3 >>> 20 ^ paramInt3 >>> 12 ^ paramInt3;
    int i = (paramInt3 ^ paramInt3 >>> 7 ^ paramInt3 >>> 4) & this.a.length - 1;
    String str = this.a[i];
    if ((str == null) || (str.length() != paramInt2))
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      this.a[i] = paramArrayOfChar;
      return paramArrayOfChar;
    }
    paramInt3 = 0;
    for (;;)
    {
      localObject = str;
      if (paramInt3 >= paramInt2) {
        break;
      }
      if (str.charAt(paramInt3) != paramArrayOfChar[(paramInt1 + paramInt3)])
      {
        paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
        this.a[i] = paramArrayOfChar;
        return paramArrayOfChar;
      }
      paramInt3 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.fi
 * JD-Core Version:    0.7.0.1
 */