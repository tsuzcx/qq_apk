package com.tencent.luggage.wxa.jp;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jo.a;
import com.tencent.luggage.wxa.jo.c;
import java.util.Set;
import rx.functions.Action1;

class h$6
  implements Action1<com.tencent.luggage.wxa.jo.b>
{
  h$6(h paramh, com.tencent.luggage.wxa.jr.b paramb) {}
  
  public void a(com.tencent.luggage.wxa.jo.b paramb)
  {
    if ((paramb != null) && (paramb.f != null))
    {
      if (paramb.g == null) {
        return;
      }
      h.a(this.b).remove(paramb.a);
      paramb = c.a(paramb);
      if (paramb != null)
      {
        String str = h.a(this.b, this.a.a("USN"));
        if (!TextUtils.isEmpty(str))
        {
          paramb.a().k = str;
          a.a().a(str, paramb);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.h.6
 * JD-Core Version:    0.7.0.1
 */