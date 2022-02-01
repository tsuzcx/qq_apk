package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.jvm.functions.Function0;

class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public void onClick(View paramView)
  {
    if (a.a(this.a) != null)
    {
      c.a(a.a(this.a).aa(), c.d.a);
      a.a(this.a).E();
    }
    else if (a.b(this.a) != null)
    {
      a.b(this.a).invoke();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.a.1
 * JD-Core Version:    0.7.0.1
 */