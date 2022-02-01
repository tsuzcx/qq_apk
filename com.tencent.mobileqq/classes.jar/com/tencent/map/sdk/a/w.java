package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.util.concurrent.ThreadPoolExecutor;

public final class w
  implements t
{
  private static w a = new w();
  
  public static w a()
  {
    return a;
  }
  
  public final u a(String paramString, byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return new y(paramString, paramArrayOfByte);
    }
    throw new IllegalArgumentException("url is empty");
  }
  
  public final v a(u paramu)
  {
    if (paramu != null)
    {
      if ((paramu instanceof y))
      {
        y localy = (y)paramu;
        localy.h = null;
        boolean bool = false;
        as.a("app_http_use_proxy", 0, 1, 1);
        paramu = new ab(localy);
        localy.i = paramu;
        if (localy.k <= 0)
        {
          localy.a(paramu.a());
        }
        else
        {
          as.a.a().a.execute(new x(paramu, localy));
          bool = localy.b() ^ true;
        }
        bh localbh = localy.c();
        if (bool) {
          localy.n = true;
        }
        paramu = localbh;
        if (localbh == null)
        {
          paramu = new StringBuilder("force return timeout:");
          paramu.append(localy.k);
          paramu = new bh(-14, paramu.toString());
        }
        return new z(paramu);
      }
      throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
    }
    throw new RuntimeException("execute...IHttpRequest is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.w
 * JD-Core Version:    0.7.0.1
 */