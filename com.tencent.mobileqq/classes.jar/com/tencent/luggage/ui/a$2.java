package com.tencent.luggage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.jvm.functions.Function0;

class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public void onClick(View paramView)
  {
    if (a.e(this.a) != null)
    {
      a.e(this.a).invoke();
    }
    else if (a.f(this.a) != null)
    {
      c.a(a.f(this.a).aa(), c.d.a);
      a.f(this.a).E();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.a.2
 * JD-Core Version:    0.7.0.1
 */