package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;

class f$3
  implements Runnable
{
  f$3(f paramf, d paramd) {}
  
  public void run()
  {
    o.d("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", new Object[] { this.a.aa() });
    Object localObject = new f.3.1(this);
    if (!this.b.b(this.a))
    {
      o.d("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { this.a.aa() });
      ((Runnable)localObject).run();
      return;
    }
    d locald = this.b.a(this.a);
    localObject = new f.3.2(this, locald, (Runnable)localObject);
    this.b.a(locald, this.a, (Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.f.3
 * JD-Core Version:    0.7.0.1
 */