package c.t.m.g;

import android.text.TextUtils;
import java.util.concurrent.ThreadPoolExecutor;

public final class g
  implements d
{
  private static g a = new g();
  
  public static g a()
  {
    return a;
  }
  
  public final e a(String paramString, byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return new i(paramString, paramArrayOfByte);
    }
    throw new IllegalArgumentException("url is empty");
  }
  
  public final f a(e parame)
  {
    if (parame != null)
    {
      if ((parame instanceof i))
      {
        i locali = (i)parame;
        locali.g = null;
        locali.n = System.currentTimeMillis();
        boolean bool = false;
        x.a.a("app_http_use_proxy", 0, 1, 1);
        parame = new l(locali);
        locali.h = parame;
        if (locali.j <= 0)
        {
          locali.a(parame.a());
        }
        else
        {
          aa.a.a().a.execute(new h(parame, locali));
          bool = locali.c() ^ true;
        }
        ao localao = locali.d();
        if (bool) {
          locali.m = true;
        }
        parame = localao;
        if (localao == null)
        {
          parame = new StringBuilder("force return timeout:");
          parame.append(locali.j);
          parame = new ao(-14, parame.toString());
        }
        return new j(parame);
      }
      throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
    }
    throw new RuntimeException("execute...IHttpRequest is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.g
 * JD-Core Version:    0.7.0.1
 */