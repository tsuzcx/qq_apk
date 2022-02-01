package com.tencent.luggage.wxa.ny;

import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.qt.a;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;

class g$2
  implements a.b
{
  g$2(g paramg, a parama, g.a parama1, i parami1, i parami2, a.b paramb) {}
  
  public void a(a.d paramd)
  {
    this.a.a = true;
    if (a.d.a == paramd)
    {
      localObject = this.b;
      if ((localObject != null) && (((g.a)localObject).b))
      {
        if (!((ModulePkgInfo)this.c.a).independent) {
          g.a(this.f, "__APP__", "options.injectModuleJS");
        }
        g.a(this.f, ((ModulePkgInfo)this.c.a).name, "options.injectModuleJS");
      }
    }
    g.a(this.f).d(new g.2.1(this));
    Object localObject = this.e;
    if (localObject != null) {
      ((a.b)localObject).a(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.g.2
 * JD-Core Version:    0.7.0.1
 */