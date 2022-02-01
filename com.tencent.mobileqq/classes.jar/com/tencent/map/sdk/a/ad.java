package com.tencent.map.sdk.a;

import android.text.TextUtils;

public final class ad
{
  public String a = "";
  public int b = -1;
  public int c = -1;
  public int d = -1;
  public byte e;
  private byte f = 1;
  
  public ad() {}
  
  public ad(String paramString)
  {
    this.a = paramString;
    this.b = -1;
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i;
    if (paramString.startsWith("["))
    {
      if (paramString.contains("]"))
      {
        Object localObject = paramString.split("]");
        if (localObject.length != 2) {
          return false;
        }
        if (!localObject[1].startsWith(":")) {
          return false;
        }
        paramString = localObject[0].substring(1);
        if (!as.c(paramString)) {
          return false;
        }
        try
        {
          i = Integer.parseInt(localObject[1].substring(1));
          if (i >= 0)
          {
            if (i > 65535) {
              return false;
            }
            localObject = new StringBuilder("[");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("]");
            this.a = ((StringBuilder)localObject).toString();
            this.b = i;
            return true;
          }
          return false;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    }
    paramString = paramString.split(":");
    if (paramString.length != 2) {
      return false;
    }
    this.a = paramString[0];
    if (!dg.d(this.a)) {
      return false;
    }
    try
    {
      this.b = Integer.parseInt(paramString[1]);
      if (this.b >= 0)
      {
        i = this.b;
        return i <= 65535;
      }
      return false;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public final boolean b()
  {
    return this.e == 3;
  }
  
  public final boolean c()
  {
    if ((!TextUtils.isEmpty(this.a)) && (this.a.charAt(0) == '['))
    {
      String str = this.a;
      if (str.charAt(str.length() - 1) == ']') {
        return true;
      }
    }
    return false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",protocalType:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",ipType:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */