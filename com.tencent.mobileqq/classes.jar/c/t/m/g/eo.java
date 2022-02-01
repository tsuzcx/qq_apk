package c.t.m.g;

import android.content.Context;
import android.util.Pair;
import java.io.IOException;

public final class eo
  implements ey
{
  private static d a = null;
  
  public eo(Context paramContext, String paramString)
  {
    try
    {
      a = a.a(new b(paramContext, "test_uuid", paramString));
      return;
    }
    catch (Throwable paramContext)
    {
      a = null;
    }
  }
  
  private static String a(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      i += 1;
    }
  }
  
  public final Pair<byte[], String> a(String paramString, byte[] paramArrayOfByte)
  {
    if (a == null) {
      throw new IOException("can not init net sdk");
    }
    try
    {
      d locald = a;
      paramString = locald.a(paramString, paramArrayOfByte);
      paramString.a("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
      paramString.b();
      new StringBuilder("req id: ").append(paramString.a());
      paramString = locald.a(paramString);
      if (paramString.a() == 0) {
        break label123;
      }
      throw new IOException("net sdk error: errorCode=" + paramString.a());
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof IOException)) {
        break label230;
      }
    }
    throw ((IOException)paramString);
    label123:
    switch (paramString.b())
    {
    }
    for (;;)
    {
      throw new IOException("net sdk error: httpStatus=" + paramString.b());
      if (paramString.c() != null)
      {
        paramArrayOfByte = a(paramString.a("content-type"));
        return Pair.create(paramString.c(), paramArrayOfByte);
      }
      paramString = Pair.create("{}".getBytes(), "utf-8");
      return paramString;
      label230:
      throw new IOException(paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.eo
 * JD-Core Version:    0.7.0.1
 */