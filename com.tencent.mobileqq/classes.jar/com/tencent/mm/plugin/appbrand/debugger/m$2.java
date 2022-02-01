package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.qz.o;

class m$2
  implements Runnable
{
  m$2(m paramm) {}
  
  public void run()
  {
    if (m.b(this.a) == null)
    {
      o.c("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
      return;
    }
    if (m.c(this.a))
    {
      this.a.setVisibility(0);
      if (m.b(this.a).indexOfChild(this.a) == -1) {
        m.b(this.a).addView(this.a);
      }
      m.b(this.a).bringChildToFront(this.a);
      localm = this.a;
      localm.setBackgroundColor(localm.getContext().getResources().getColor(2131166284));
      return;
    }
    m localm = this.a;
    localm.setBackgroundColor(localm.getContext().getResources().getColor(2131168376));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.m.2
 * JD-Core Version:    0.7.0.1
 */