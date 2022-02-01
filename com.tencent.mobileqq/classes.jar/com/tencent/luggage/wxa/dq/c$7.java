package com.tencent.luggage.wxa.dq;

import com.tencent.mm.plugin.appbrand.page.am;

class c$7
  implements Runnable
{
  c$7(c paramc) {}
  
  public void run()
  {
    if (this.a.aj() == null) {
      return;
    }
    if (this.a.aj().getWebScrollY() == 0) {
      return;
    }
    c.a(this.a);
    this.a.aj().setVerticalScrollBarEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dq.c.7
 * JD-Core Version:    0.7.0.1
 */