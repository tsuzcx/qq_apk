package com.tencent.luggage.wxa.kt;

import android.view.View;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.pc.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class n$1
  implements q
{
  n$1(n paramn, e parame, JSONObject paramJSONObject, int paramInt) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!(paramView instanceof t)) {
      return;
    }
    Object localObject = this.a.c(n.a(this.d, this.b)).a(this.c, false);
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
    localHashMap.put("scrollLeft", Integer.valueOf(g.b(paramInt1)));
    localHashMap.put("scrollTop", Integer.valueOf(g.b(paramInt2)));
    localHashMap.put("scrollWidth", Integer.valueOf(g.b(paramView.getWidth())));
    localHashMap.put("scrollHeight", Integer.valueOf(g.b(paramView.getHeight())));
    paramView = new p().b(localHashMap);
    this.a.a(paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.n.1
 * JD-Core Version:    0.7.0.1
 */