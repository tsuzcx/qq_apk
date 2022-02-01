package com.tencent.luggage.wxa.u;

import android.text.TextUtils;

final class d$a
{
  public final String a;
  public final boolean b;
  
  public d$a(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (paramObject.getClass() != a.class) {
        return false;
      }
      paramObject = (a)paramObject;
      return (TextUtils.equals(this.a, paramObject.a)) && (this.b == paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    int j;
    if (this.b) {
      j = 1231;
    } else {
      j = 1237;
    }
    return (i + 31) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.u.d.a
 * JD-Core Version:    0.7.0.1
 */