package com.tencent.luggage.wxa.lq;

import android.view.MenuItem;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.mm.ui.base.i.e;
import java.util.HashMap;
import java.util.Map;

class b$1$2
  implements i.e
{
  b$1$2(b.1 param1, Map paramMap) {}
  
  public void a(MenuItem paramMenuItem, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("tapIndex", Integer.valueOf(paramMenuItem.getItemId()));
    if ((this.a.containsKey(Integer.valueOf(paramInt))) && (b.c() != null)) {
      b.c().a(((Integer)this.a.get(Integer.valueOf(paramInt))).intValue());
    }
    this.b.a.a(this.b.f, this.b.g.a("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.b.1.2
 * JD-Core Version:    0.7.0.1
 */