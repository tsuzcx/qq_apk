package com.tencent.luggage.wxa.kb;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.jx.z;
import com.tencent.luggage.wxa.qz.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class e$6
  implements View.OnClickListener
{
  e$6(e parame, u paramu) {}
  
  public void onClick(View paramView)
  {
    o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
    String str = this.a.getContext().getString(2131886768);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("");
    localStringBuilder.append(n.a());
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("do open url:");
    localStringBuilder.append(str);
    o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", localStringBuilder.toString());
    ((z)this.a.a(z.class)).a(this.a.getContext(), str, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.e.6
 * JD-Core Version:    0.7.0.1
 */