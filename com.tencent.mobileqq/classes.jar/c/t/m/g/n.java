package c.t.m.g;

import android.text.TextUtils;

public final class n
{
  public String a = "";
  public int b = -1;
  public int c = -1;
  public int d = -1;
  public byte e;
  private byte f = 1;
  private String[] g;
  
  public n() {}
  
  public n(String paramString)
  {
    this.a = paramString;
    this.b = -1;
  }
  
  public final String a()
  {
    return this.a + ":" + this.b;
  }
  
  public final boolean a(n paramn)
  {
    return (paramn != null) && (this.a.equals(paramn.a)) && (this.b == paramn.b);
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      this.g = paramString.split(":");
      if (this.g.length == 2)
      {
        this.a = this.g[0];
        if (cn.d(this.a)) {
          try
          {
            this.b = Integer.parseInt(this.g[1]);
            if (this.b >= 0)
            {
              int i = this.b;
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
    return false;
  }
  
  public final boolean b()
  {
    return this.e == 3;
  }
  
  public final String toString()
  {
    return this.a + ":" + this.b + ",protocalType:" + this.f + ",ipType:" + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.n
 * JD-Core Version:    0.7.0.1
 */