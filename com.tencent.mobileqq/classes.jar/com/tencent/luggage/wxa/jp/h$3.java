package com.tencent.luggage.wxa.jp;

import rx.functions.Action1;

class h$3
  implements Action1<Throwable>
{
  h$3(h paramh, com.tencent.luggage.wxa.jq.a parama) {}
  
  public void a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (paramThrowable.getMessage() != null))
    {
      String str = h.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendTcpCustom fail: ");
      localStringBuilder.append(paramThrowable.getMessage());
      com.tencent.luggage.wxa.jm.a.b(str, localStringBuilder.toString());
    }
    paramThrowable = this.a;
    if (paramThrowable != null) {
      paramThrowable.b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.h.3
 * JD-Core Version:    0.7.0.1
 */