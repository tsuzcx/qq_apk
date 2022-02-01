package com.tencent.luggage.wxa.kt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class f$1
  implements View.OnClickListener
{
  f$1(f paramf, a.b paramb, e parame) {}
  
  public void onClick(View paramView)
  {
    o.d("MicroMsg.JsApiInsertImageView", "onClick");
    f.a locala = new f.a(null);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", this.a.b("data", ""));
    locala.b(localHashMap);
    if ("webview".equals(this.a.b("sendTo", null))) {
      this.b.a(locala);
    } else {
      this.b.a(locala, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.f.1
 * JD-Core Version:    0.7.0.1
 */