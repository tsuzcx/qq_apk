package com.tencent.mm.plugin.appbrand.page;

class o$3
  implements Runnable
{
  o$3(o paramo, m paramm, String paramString) {}
  
  public void run()
  {
    int i = this.c.c(this.a);
    if (i < 0)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", new Object[] { this.c.getAppId(), this.a.getCurrentUrl() });
      return;
    }
    o.a(this.c, i + 1, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.3
 * JD-Core Version:    0.7.0.1
 */