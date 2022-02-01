package com.tencent.luggage.wxa.op;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class f$1
  implements View.OnClickListener
{
  f$1(f paramf) {}
  
  public void onClick(View paramView)
  {
    o.d(f.a(this.a), "onCloseButtonClick");
    if (f.b(this.a))
    {
      o.c(f.a(this.a), "onCloseButtonClick when mPipClickProcessing, return");
    }
    else if (f.c(this.a))
    {
      o.c(f.a(this.a), "onCloseButtonClick when mIsTransfering, return");
    }
    else
    {
      if ((f.d(this.a) != null) && (f.e(this.a) != null)) {
        f.e(this.a).a(f.d(this.a).h, e.b);
      }
      f.f(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.1
 * JD-Core Version:    0.7.0.1
 */