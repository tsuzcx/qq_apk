package com.tencent.featuretoggle.hltxkg.common.a;

import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.e.c;

public final class a
{
  public int a = -1;
  public int b = -1;
  private String c = "";
  private int d = -1;
  private byte e;
  private byte f = 1;
  
  public a() {}
  
  public a(String paramString, int paramInt)
  {
    this.c = paramString;
    this.d = paramInt;
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final void a(byte paramByte)
  {
    this.e = paramByte;
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
        if (!i.c(paramString)) {
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
            this.c = ((StringBuilder)localObject).toString();
            this.d = i;
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
    this.c = paramString[0];
    if (!c.d(this.c)) {
      return false;
    }
    try
    {
      this.d = Integer.parseInt(paramString[1]);
      if (this.d >= 0)
      {
        i = this.d;
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
  
  public final byte b()
  {
    return this.e;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(":");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  public final boolean e()
  {
    return this.e == 3;
  }
  
  public final boolean f()
  {
    int i = this.e;
    return (i != 3) && (i != 4);
  }
  
  public final boolean g()
  {
    if ((!TextUtils.isEmpty(this.c)) && (this.c.charAt(0) == '['))
    {
      String str = this.c;
      if (str.charAt(str.length() - 1) == ']') {
        return true;
      }
    }
    return false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(":");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",protocalType:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",ipType:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.a
 * JD-Core Version:    0.7.0.1
 */