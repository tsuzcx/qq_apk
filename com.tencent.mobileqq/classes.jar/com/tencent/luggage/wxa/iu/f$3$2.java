package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;

class f$3$2
  implements Runnable
{
  f$3$2(f.3 param3, d paramd, Runnable paramRunnable) {}
  
  public void run()
  {
    boolean bool = this.c.b.d(this.c.a);
    Object localObject = this.a;
    if (localObject != null) {
      ((d)localObject).b(this.c.a.B(), null);
    }
    this.b.run();
    if ((bool) && (this.a != null) && (f.b(this.c.b))) {
      this.a.aA();
    }
    localObject = this.a;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((d)localObject).aa();
    }
    o.d("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), localObject, Boolean.valueOf(f.b(this.c.b)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.f.3.2
 * JD-Core Version:    0.7.0.1
 */