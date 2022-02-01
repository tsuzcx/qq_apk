package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;
import java.util.Map;

class f$2$1
  implements Runnable
{
  f$2$1(f.2 param2, d paramd) {}
  
  public void run()
  {
    if (this.a != null)
    {
      this.b.a.ai().setVisibility(8);
      f.c(this.b.c).remove(this.b.a);
      f.d(this.b.c).put(this.b.a.aa(), this.b.a);
      f.a(this.b.c, this.a);
      f.b(this.b.c, this.a);
    }
    this.b.a.ay();
    if (f.b(this.b.c))
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
    o.d("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str, localObject, Boolean.valueOf(f.b(this.b.c)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.f.2.1
 * JD-Core Version:    0.7.0.1
 */