package com.tencent.featuretoggle.hltxkg.access.http.a;

import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpCallback;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpClient;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpRequest;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpResponse;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import com.tencent.featuretoggle.hltxkg.common.b.a.f;
import java.util.concurrent.ThreadPoolExecutor;

public final class a
  implements IHttpClient
{
  private static a a = new a();
  
  public static a a()
  {
    return a;
  }
  
  private e a(boolean paramBoolean, d paramd, IHttpCallback paramIHttpCallback)
  {
    paramd.h = paramIHttpCallback;
    i.a("app_http_use_proxy", 0, 1, 1);
    paramIHttpCallback = new com.tencent.featuretoggle.hltxkg.access.http.b.b(paramd);
    paramd.i = paramIHttpCallback;
    if (paramBoolean)
    {
      boolean bool;
      if (paramd.k <= 0)
      {
        paramd.a(paramIHttpCallback.a());
        bool = false;
      }
      else
      {
        i.a().b().execute(new c(this, paramIHttpCallback, paramd));
        bool = paramd.a() ^ true;
      }
      f localf = paramd.c();
      if (bool) {
        paramd.m = true;
      }
      paramIHttpCallback = localf;
      if (localf == null)
      {
        paramIHttpCallback = new StringBuilder("force return timeout:");
        paramIHttpCallback.append(paramd.k);
        paramIHttpCallback = new f(-14, paramIHttpCallback.toString(), 0);
      }
      return new e(paramIHttpCallback);
    }
    paramd.a(new e(paramIHttpCallback.a()));
    return null;
  }
  
  public final IHttpRequest createRequest(String paramString, byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return new d(paramString, paramArrayOfByte);
    }
    throw new IllegalArgumentException("url is empty");
  }
  
  public final void enqueue(IHttpRequest paramIHttpRequest, IHttpCallback paramIHttpCallback)
  {
    if (paramIHttpRequest != null)
    {
      if ((paramIHttpRequest instanceof d))
      {
        if (paramIHttpCallback != null)
        {
          paramIHttpRequest = (d)paramIHttpRequest;
          i.a().b().execute(new b(this, paramIHttpRequest, paramIHttpCallback));
          return;
        }
        throw new RuntimeException("enqueue...IHttpCallback is null");
      }
      throw new RuntimeException("enqueue...IHttpRequest should be create by API:createRequest");
    }
    throw new RuntimeException("enqueue...IHttpRequest is null");
  }
  
  public final IHttpResponse execute(IHttpRequest paramIHttpRequest)
  {
    if (paramIHttpRequest != null)
    {
      if ((paramIHttpRequest instanceof d)) {
        return a(true, (d)paramIHttpRequest, null);
      }
      throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
    }
    throw new RuntimeException("execute...IHttpRequest is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.access.http.a.a
 * JD-Core Version:    0.7.0.1
 */