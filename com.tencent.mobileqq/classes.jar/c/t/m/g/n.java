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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public final boolean a(n paramn)
  {
    return (paramn != null) && (this.a.equals(paramn.a)) && (this.b == paramn.b);
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.g = paramString.split(":");
    paramString = this.g;
    if (paramString.length != 2) {
      return false;
    }
    this.a = paramString[0];
    if (!cn.d(this.a)) {
      return false;
    }
    try
    {
      this.b = Integer.parseInt(this.g[1]);
      if (this.b >= 0)
      {
        int i = this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.n
 * JD-Core Version:    0.7.0.1
 */