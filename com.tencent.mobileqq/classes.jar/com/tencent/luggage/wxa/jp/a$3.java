package com.tencent.luggage.wxa.jp;

import java.io.IOException;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class a$3
  implements Observable.OnSubscribe<com.tencent.luggage.wxa.jr.e>
{
  a$3(a parama, com.tencent.luggage.wxa.jn.e parame) {}
  
  public void a(Subscriber<? super com.tencent.luggage.wxa.jr.e> paramSubscriber)
  {
    try
    {
      paramSubscriber.onNext(i.b().a(this.a));
      paramSubscriber.onCompleted();
      return;
    }
    catch (IOException localIOException)
    {
      Throwable localThrowable = localIOException.getCause();
      Object localObject = localThrowable;
      if (localThrowable == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Error msg: ");
        ((StringBuilder)localObject).append(localIOException.toString());
        localObject = new Throwable(((StringBuilder)localObject).toString());
      }
      paramSubscriber.onError((Throwable)localObject);
      com.tencent.luggage.wxa.jm.a.a("DlnaRepositoryImpl", localIOException, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.a.3
 * JD-Core Version:    0.7.0.1
 */