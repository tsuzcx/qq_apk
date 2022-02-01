package com.tencent.luggage.wxa.ny;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;

class g$3
  implements a.b
{
  g$3(g paramg, boolean paramBoolean, ModulePkgInfo paramModulePkgInfo, a.b paramb) {}
  
  public void a(a.d paramd)
  {
    if ((a.d.a == paramd) && (this.a))
    {
      if (!this.b.independent) {
        g.a(this.d, "__APP__", "options.injectModuleJS");
      }
      g.a(this.d, this.b.name, "options.injectModuleJS");
    }
    a.b localb = this.c;
    if (localb != null) {
      localb.a(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.g.3
 * JD-Core Version:    0.7.0.1
 */