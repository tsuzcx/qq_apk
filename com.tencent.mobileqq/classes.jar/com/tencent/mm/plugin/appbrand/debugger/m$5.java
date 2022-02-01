package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

class m$5
  implements Runnable
{
  m$5(m paramm) {}
  
  public void run()
  {
    if (m.e(this.a).y())
    {
      m.f(this.a).setImageResource(2130838683);
      m.g(this.a).setText(this.a.getContext().getString(2131886885));
    }
    else if (m.e(this.a).x())
    {
      m.f(this.a).setImageResource(2130838683);
      m.g(this.a).setText(this.a.getContext().getString(2131886886));
    }
    else
    {
      m.f(this.a).setImageResource(2130838682);
      m.g(this.a).setText(this.a.getContext().getString(2131886884));
    }
    m.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.m.5
 * JD-Core Version:    0.7.0.1
 */