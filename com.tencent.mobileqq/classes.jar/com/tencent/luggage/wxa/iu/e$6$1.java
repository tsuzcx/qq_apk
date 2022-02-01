package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.f;
import java.util.HashMap;
import java.util.LinkedList;

class e$6$1
  implements Runnable
{
  e$6$1(e.6 param6, d paramd) {}
  
  public void run()
  {
    this.b.a.ai().setVisibility(8);
    e.d(this.b.c).remove(this.b.a);
    e.e(this.b.c).put(this.b.a.aa(), this.b.a);
    if (this.a != null)
    {
      e.a(this.b.c, this.a);
      e.b(this.b.c, this.a);
    }
    this.b.a.ay();
    if (e.c(this.b.c))
    {
      localObject = this.a;
      if (localObject != null) {
        ((d)localObject).aA();
      }
    }
    String str = this.b.a.aa();
    Object localObject = this.a;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((d)localObject).aa();
    }
    o.d("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str, localObject, Boolean.valueOf(e.c(this.b.c)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e.6.1
 * JD-Core Version:    0.7.0.1
 */