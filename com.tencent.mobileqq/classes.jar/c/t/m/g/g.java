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
  
  public final f.a a(e parame)
  {
    int i = 0;
    if (parame == null) {
      throw new RuntimeException("execute...IHttpRequest is null");
    }
    if (!(parame instanceof i)) {
      throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
    }
    i locali = (i)parame;
    locali.k = System.currentTimeMillis();
    v.a("app_http_use_proxy", 0, 1, 1);
    parame = new k(locali);
    if (locali.g <= 0)
    {
      locali.a(parame.a());
      parame = locali.d();
      if (i != 0) {
        locali.j = true;
      }
      if (parame != null) {
        break label164;
      }
      parame = new aj(-14, "force return timeout:" + locali.g);
    }
    label164:
    for (;;)
    {
      return new f.a(parame);
      x.a.a().a.execute(new h(parame, locali));
      if (locali.c()) {
        break;
      }
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.g
 * JD-Core Version:    0.7.0.1
 */