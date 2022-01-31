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
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("url is empty");
    }
    return new y(paramString, paramArrayOfByte);
  }
  
  public final v a(u paramu)
  {
    int i = 0;
    if (paramu == null) {
      throw new RuntimeException("execute...IHttpRequest is null");
    }
    if (!(paramu instanceof y)) {
      throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
    }
    y localy = (y)paramu;
    localy.h = null;
    as.a("app_http_use_proxy", 0, 1, 1);
    paramu = new ab(localy);
    localy.i = paramu;
    if (localy.k <= 0)
    {
      localy.a(paramu.a());
      paramu = localy.c();
      if (i != 0) {
        localy.n = true;
      }
      if (paramu != null) {
        break label167;
      }
      paramu = new bh(-14, "force return timeout:" + localy.k);
    }
    label167:
    for (;;)
    {
      return new z(paramu);
      as.a.a().a.execute(new x(paramu, localy));
      if (localy.b()) {
        break;
      }
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.w
 * JD-Core Version:    0.7.0.1
 */