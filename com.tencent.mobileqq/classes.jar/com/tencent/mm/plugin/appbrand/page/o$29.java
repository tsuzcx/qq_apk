package com.tencent.mm.plugin.appbrand.page;

class o$29
  implements o.d
{
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  o$29(o paramo, String paramString, bg parambg) {}
  
  public void a()
  {
    if (this.e) {
      return;
    }
    if (o.d(this.c) == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandPageContainer", "attempt to proceed but destroyed, url[%s], type[%s]", new Object[] { this.a, this.b });
      return;
    }
    if (!this.d)
    {
      o.a(this.c, this.a, this.b, this.f);
      this.d = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.29
 * JD-Core Version:    0.7.0.1
 */