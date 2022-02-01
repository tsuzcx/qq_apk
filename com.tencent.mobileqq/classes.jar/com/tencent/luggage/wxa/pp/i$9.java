package com.tencent.luggage.wxa.pp;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.luggage.wxa.qz.s;

class i$9
  implements View.OnKeyListener
{
  i$9(i parami) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = this.a;
    boolean bool;
    if (67 == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    i.c(paramView, bool);
    if (i.g(this.a))
    {
      i.m(this.a).b(i.l(this.a));
      i.m(this.a).b(i.l(this.a), 1000L);
      return false;
    }
    i.l(this.a).run();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.9
 * JD-Core Version:    0.7.0.1
 */