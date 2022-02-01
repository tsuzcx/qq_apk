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
    return this.a + ":" + this.b;
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i;
      if (paramString.startsWith("["))
      {
        if (paramString.contains("]"))
        {
          paramString = paramString.split("]");
          if ((paramString.length == 2) && (paramString[1].startsWith(":")))
          {
            String str = paramString[0].substring(1);
            if (as.c(str)) {
              try
              {
                i = Integer.parseInt(paramString[1].substring(1));
                if ((i < 0) || (i > 65535)) {
                  continue;
                }
                this.a = ("[" + str + "]");
                this.b = i;
                return true;
              }
              catch (NumberFormatException paramString)
              {
                paramString.printStackTrace();
                return false;
              }
            }
          }
        }
      }
      else
      {
        paramString = paramString.split(":");
        if (paramString.length == 2)
        {
          this.a = paramString[0];
          if (dg.d(this.a)) {
            try
            {
              this.b = Integer.parseInt(paramString[1]);
              if (this.b >= 0)
              {
                i = this.b;
                if (i <= 65535) {
                  return true;
                }
              }
            }
            catch (NumberFormatException paramString)
            {
              paramString.printStackTrace();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final boolean b()
  {
    return this.e == 3;
  }
  
  public final boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.a))
    {
      bool1 = bool2;
      if (this.a.charAt(0) == '[')
      {
        bool1 = bool2;
        if (this.a.charAt(this.a.length() - 1) == ']') {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final String toString()
  {
    return this.a + ":" + this.b + ",protocalType:" + this.f + ",ipType:" + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */