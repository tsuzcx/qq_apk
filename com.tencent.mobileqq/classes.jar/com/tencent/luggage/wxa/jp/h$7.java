package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jm.a;
import java.util.Set;
import rx.functions.Action1;

class h$7
  implements Action1<Throwable>
{
  h$7(h paramh) {}
  
  public void a(Throwable paramThrowable)
  {
    h.a(this.a).clear();
    if ((paramThrowable != null) && (paramThrowable.getMessage() != null))
    {
      String str = h.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get mDevice info err:");
      localStringBuilder.append(paramThrowable.getMessage());
      a.b(str, localStringBuilder.toString());
      return;
    }
    a.b(h.d(), "get mDevice info err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.h.7
 * JD-Core Version:    0.7.0.1
 */