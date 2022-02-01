package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jm.a;
import rx.functions.Action1;

class h$5
  implements Action1<Throwable>
{
  h$5(h paramh) {}
  
  public void a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (paramThrowable.getMessage() != null))
    {
      String str = h.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action send fail:");
      localStringBuilder.append(paramThrowable.getMessage());
      a.b(str, localStringBuilder.toString());
      return;
    }
    a.b(h.d(), "action send fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.h.5
 * JD-Core Version:    0.7.0.1
 */