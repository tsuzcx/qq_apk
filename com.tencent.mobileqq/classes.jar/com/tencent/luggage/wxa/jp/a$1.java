package com.tencent.luggage.wxa.jp;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class a$1
  implements Observable.OnSubscribe<com.tencent.luggage.wxa.jo.b>
{
  a$1(a parama, com.tencent.luggage.wxa.jr.b paramb) {}
  
  public void a(Subscriber<? super com.tencent.luggage.wxa.jo.b> paramSubscriber)
  {
    String str = this.a.a("LOCATION");
    if (TextUtils.isEmpty(str))
    {
      Log.e("DlnaRepositoryImpl", "mDevice location is empty");
      paramSubscriber.onError(new Throwable("mDevice location is empty"));
      return;
    }
    try
    {
      URL localURL = new URL(str);
      Object localObject = localURL.openStream();
      localObject = j.a().b((InputStream)localObject);
      if (localObject != null)
      {
        ((com.tencent.luggage.wxa.jo.b)localObject).a = str;
        ((com.tencent.luggage.wxa.jo.b)localObject).b = localURL.getHost();
        ((com.tencent.luggage.wxa.jo.b)localObject).c = localURL.getPort();
      }
      paramSubscriber.onNext(localObject);
      paramSubscriber.onCompleted();
      return;
    }
    catch (IOException localIOException)
    {
      paramSubscriber.onError(localIOException.getCause());
      com.tencent.luggage.wxa.jm.a.a("DlnaRepositoryImpl", localIOException, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.a.1
 * JD-Core Version:    0.7.0.1
 */