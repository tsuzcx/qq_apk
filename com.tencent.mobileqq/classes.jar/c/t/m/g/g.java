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
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("url is empty");
    }
    return new i(paramString, paramArrayOfByte);
  }
  
  public final f a(e parame)
  {
    int i = 0;
    if (parame == null) {
      throw new RuntimeException("execute...IHttpRequest is null");
    }
    if (!(parame instanceof i)) {
      throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
    }
    i locali = (i)parame;
    locali.g = null;
    locali.n = System.currentTimeMillis();
    x.a.a("app_http_use_proxy", 0, 1, 1);
    parame = new l(locali);
    locali.h = parame;
    if (locali.j <= 0)
    {
      locali.a(parame.a());
      parame = locali.d();
      if (i != 0) {
        locali.m = true;
      }
      if (parame != null) {
        break label174;
      }
      parame = new ao(-14, "force return timeout:" + locali.j);
    }
    label174:
    for (;;)
    {
      return new j(parame);
      aa.a.a().a.execute(new h(parame, locali));
      if (locali.c()) {
        break;
      }
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.g
 * JD-Core Version:    0.7.0.1
 */