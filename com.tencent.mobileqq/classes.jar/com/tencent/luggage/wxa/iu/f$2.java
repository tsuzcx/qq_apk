package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;

class f$2
  implements Runnable
{
  f$2(f paramf, d paramd, Object paramObject) {}
  
  public void run()
  {
    if (!this.c.d(this.a))
    {
      o.b("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close with appId(%s), not top of stack, ignore", new Object[] { this.a.aa() });
      return;
    }
    d locald = this.c.a(this.a);
    if (locald != null) {
      locald.b(this.a.B(), this.b);
    }
    String str2 = this.a.aa();
    String str1;
    if (locald == null) {
      str1 = "null";
    } else {
      str1 = locald.aa();
    }
    o.d("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close before run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(f.b(this.c)) });
    this.c.a(locald, this.a, new f.2.1(this, locald));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.f.2
 * JD-Core Version:    0.7.0.1
 */