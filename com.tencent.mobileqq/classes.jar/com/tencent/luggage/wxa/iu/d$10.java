package com.tencent.luggage.wxa.iu;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;

class d$10
  extends AppBrandMainProcessService.a
{
  private boolean b = false;
  
  d$10(d paramd) {}
  
  public void a(String paramString)
  {
    if (this.b) {
      d.m(this.a);
    }
    this.b = false;
  }
  
  public void b(String paramString)
  {
    this.b = true;
    this.a.aB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.10
 * JD-Core Version:    0.7.0.1
 */