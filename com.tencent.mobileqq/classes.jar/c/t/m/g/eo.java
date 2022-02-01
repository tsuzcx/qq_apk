package c.t.m.g;

import android.content.Context;
import android.util.Pair;
import java.io.IOException;

public final class eo
  implements ey
{
  private static d a;
  
  public eo(Context paramContext, String paramString)
  {
    try
    {
      a = a.a(new b(paramContext, "test_uuid", paramString));
      return;
    }
    catch (Throwable paramContext)
    {
      label22:
      break label22;
    }
    a = null;
  }
  
  private static String a(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i].trim();
        int k = str.indexOf("charset=");
        if (-1 != k) {
          return str.substring(k + 8, str.length());
        }
        i += 1;
      }
    }
    return "GBK";
  }
  
  public final Pair<byte[], String> a(String paramString, byte[] paramArrayOfByte)
  {
    d locald = a;
    if (locald != null) {
      try
      {
        paramString = locald.a(paramString, paramArrayOfByte);
        paramString.a("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
        paramString.b();
        new StringBuilder("req id: ").append(paramString.a());
        paramString = locald.a(paramString);
        if (paramString.a() == 0)
        {
          int i = paramString.b();
          if (i != 200)
          {
            if (i != 204)
            {
              paramArrayOfByte = new StringBuilder("net sdk error: httpStatus=");
              paramArrayOfByte.append(paramString.b());
              throw new IOException(paramArrayOfByte.toString());
            }
          }
          else if (paramString.c() != null)
          {
            paramArrayOfByte = a(paramString.a("content-type"));
            return Pair.create(paramString.c(), paramArrayOfByte);
          }
          return Pair.create("{}".getBytes(), "utf-8");
        }
        paramArrayOfByte = new StringBuilder("net sdk error: errorCode=");
        paramArrayOfByte.append(paramString.a());
        throw new IOException(paramArrayOfByte.toString());
      }
      catch (Exception paramString)
      {
        if ((paramString instanceof IOException)) {
          throw ((IOException)paramString);
        }
        throw new IOException(paramString.getMessage());
      }
    }
    throw new IOException("can not init net sdk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.eo
 * JD-Core Version:    0.7.0.1
 */