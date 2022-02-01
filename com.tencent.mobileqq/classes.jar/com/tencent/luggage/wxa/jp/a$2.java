package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jn.d;
import java.io.IOException;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class a$2
  implements Observable.OnSubscribe<Void>
{
  a$2(a parama, d paramd) {}
  
  public void a(Subscriber<? super Void> paramSubscriber)
  {
    try
    {
      i.a().a(this.a);
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
 * Qualified Name:     com.tencent.luggage.wxa.jp.a.2
 * JD-Core Version:    0.7.0.1
 */