package com.tencent.luggage.wxa.kt;

import android.view.View;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import java.util.HashMap;
import java.util.Map;

class g$1
  implements q
{
  g$1(g paramg, e parame, boolean paramBoolean, int paramInt) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!(paramView instanceof t)) {
      return;
    }
    Object localObject = this.a.c(this.b).a(this.c, false);
    if (localObject == null) {
      return;
    }
    localObject = ((a.b)localObject).b("data", null);
    if (localObject == null) {
      return;
    }
    paramView = ((t)paramView).getTargetView();
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localObject);
    localHashMap.put("scrollLeft", Integer.valueOf(com.tencent.luggage.wxa.pc.g.b(paramInt1)));
    localHashMap.put("scrollTop", Integer.valueOf(com.tencent.luggage.wxa.pc.g.b(paramInt2)));
    localHashMap.put("scrollWidth", Integer.valueOf(com.tencent.luggage.wxa.pc.g.b(paramView.getWidth())));
    localHashMap.put("scrollHeight", Integer.valueOf(com.tencent.luggage.wxa.pc.g.b(paramView.getHeight())));
    paramView = new p().b(localHashMap);
    this.a.a(paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.g.1
 * JD-Core Version:    0.7.0.1
 */