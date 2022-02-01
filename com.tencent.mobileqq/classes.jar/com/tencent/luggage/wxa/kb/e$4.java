package com.tencent.luggage.wxa.kb;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class e$4
  implements View.OnClickListener
{
  e$4(e parame, com.tencent.luggage.wxa.qw.o paramo, u paramu, int paramInt) {}
  
  public void onClick(View paramView)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, acceptButton");
    this.a.c = true;
    this.b.a(this.c, this.d.b("ok"));
    e.a(this.d, this.b, this.a);
    e.a(this.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.e.4
 * JD-Core Version:    0.7.0.1
 */