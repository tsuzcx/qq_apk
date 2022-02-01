package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;

class e$6
  implements Runnable
{
  e$6(e parame, d paramd, Object paramObject) {}
  
  public void run()
  {
    if (!this.c.d(this.a))
    {
      o.b("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", new Object[] { this.a.aa() });
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
    o.d("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(e.c(this.c)) });
    this.c.a(locald, this.a, new e.6.1(this, locald));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e.6
 * JD-Core Version:    0.7.0.1
 */