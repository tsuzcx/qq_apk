package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.luggage.wxa.qz.o;

class b$b
  implements com.tencent.luggage.wxa.li.b
{
  private b$b(b paramb) {}
  
  public void a()
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onCreate");
  }
  
  public void b()
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onResume");
    if (b.g(this.a))
    {
      this.a.a();
      b.d(this.a, false);
    }
  }
  
  public void c()
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onPause");
    this.a.b();
    b.d(this.a, true);
  }
  
  public void d()
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b.b
 * JD-Core Version:    0.7.0.1
 */