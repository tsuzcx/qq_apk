package com.tencent.mm.plugin.appbrand.page;

class o$18
  implements Runnable
{
  o$18(o paramo) {}
  
  public void run()
  {
    if (o.h(this.a) != null) {
      return;
    }
    long l = System.currentTimeMillis();
    u localu2 = o.i(this.a);
    u localu1 = localu2;
    if (localu2 == null) {
      localu1 = new u();
    }
    localu1.a(this.a.getDecorWidgetFactory());
    localu1.a(this.a.getContext(), o.d(this.a));
    localu1.x();
    this.a.addView(localu1.getContentView(), 0);
    o.a(this.a, localu1);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.18
 * JD-Core Version:    0.7.0.1
 */