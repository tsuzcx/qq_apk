package com.tencent.luggage.wxa.em;

import androidx.annotation.NonNull;
import com.tencent.luggage.setting.ui.WxaSettingActivity.a;
import com.tencent.luggage.wxa.by.a.c;
import com.tencent.luggage.wxa.oo.a;
import com.tencent.luggage.wxa.qz.o;

class d$5
  implements a.c
{
  d$5(d paramd) {}
  
  public void a(@NonNull Object paramObject)
  {
    if ((paramObject instanceof WxaSettingActivity.a))
    {
      o.d("Luggage.STANDALONE.Runtime", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", new Object[] { this.a.aa() });
      a.a(this.a.aa());
      d locald = this.a;
      d.a(locald, locald, (WxaSettingActivity.a)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.d.5
 * JD-Core Version:    0.7.0.1
 */