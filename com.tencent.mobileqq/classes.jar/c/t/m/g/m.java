package c.t.m.g;

import android.text.TextUtils;

public final class m
{
  public String a = "";
  public int b = -1;
  public int c = -1;
  
  public m() {}
  
  public m(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public final String a()
  {
    return this.a + ":" + this.b;
  }
  
  public final boolean a(m paramm)
  {
    return (paramm != null) && (this.a.equals(paramm.a)) && (this.b == paramm.b);
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = paramString.split(":");
      if (paramString.length == 2)
      {
        this.a = paramString[0];
        if (ch.d(this.a)) {
          try
          {
            this.b = Integer.parseInt(paramString[1]);
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
    return this.b == -1;
  }
  
  public final String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.m
 * JD-Core Version:    0.7.0.1
 */