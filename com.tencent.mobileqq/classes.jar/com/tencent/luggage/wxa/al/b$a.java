package com.tencent.luggage.wxa.al;

import android.text.TextUtils;

final class b$a
{
  public final int a;
  public final int b;
  public final String c;
  
  public b$a(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (a)paramObject;
      return (this.a == paramObject.a) && (this.b == paramObject.b) && (TextUtils.equals(this.c, paramObject.c));
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a;
    int k = this.b;
    String str = this.c;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.al.b.a
 * JD-Core Version:    0.7.0.1
 */