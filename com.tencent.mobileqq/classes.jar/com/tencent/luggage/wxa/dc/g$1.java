package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.dg.d;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

final class g$1
  implements Interceptor
{
  public Response intercept(Interceptor.Chain paramChain)
  {
    Request localRequest = paramChain.request();
    HttpUrl.Builder localBuilder = localRequest.url().newBuilder();
    if ((i.a.g()) && (!g.a())) {
      localBuilder.addQueryParameter("session_id", i.a.e());
    } else if ((i.a.g()) && (g.a())) {
      localBuilder.addQueryParameter("session_id", e.a.a("", d.a.d(), 1));
    } else if ((d.a.k()) && (!d.a.l())) {
      localBuilder.addQueryParameter("session_id", e.a.a("", d.a.d(), 1));
    } else {
      d.a.h();
    }
    return paramChain.proceed(localRequest.newBuilder().url(localBuilder.build()).build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.g.1
 * JD-Core Version:    0.7.0.1
 */