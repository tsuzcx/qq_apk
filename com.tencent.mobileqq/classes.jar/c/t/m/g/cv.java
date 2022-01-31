package c.t.m.g;

import android.util.Base64;

public final class cv
{
  private static final byte[] a = new byte[0];
  
  public static byte[] a(String paramString)
  {
    try
    {
      paramString = dq.a(co.a(paramString.getBytes("UTF-8")), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
      if (!co.b(paramString))
      {
        paramString = Base64.encode(paramString, 2);
        if (!co.b(paramString)) {
          return paramString;
        }
      }
      paramString = a;
      return paramString;
    }
    catch (Throwable paramString)
    {
      co.b(paramString.toString());
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cv
 * JD-Core Version:    0.7.0.1
 */