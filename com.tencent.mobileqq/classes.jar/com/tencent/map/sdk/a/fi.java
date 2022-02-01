package com.tencent.map.sdk.a;

final class fi
{
  private final String[] a = new String[1024];
  
  public final String a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > 20) {
      return new String(paramArrayOfChar, paramInt1, paramInt2);
    }
    paramInt3 ^= paramInt3 >>> 20 ^ paramInt3 >>> 12;
    Object localObject = this.a;
    int i = (paramInt3 ^ paramInt3 >>> 7 ^ paramInt3 >>> 4) & localObject.length - 1;
    localObject = localObject[i];
    if ((localObject != null) && (((String)localObject).length() == paramInt2))
    {
      paramInt3 = 0;
      while (paramInt3 < paramInt2)
      {
        if (((String)localObject).charAt(paramInt3) != paramArrayOfChar[(paramInt1 + paramInt3)])
        {
          paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
          this.a[i] = paramArrayOfChar;
          return paramArrayOfChar;
        }
        paramInt3 += 1;
      }
      return localObject;
    }
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    this.a[i] = paramArrayOfChar;
    return paramArrayOfChar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fi
 * JD-Core Version:    0.7.0.1
 */