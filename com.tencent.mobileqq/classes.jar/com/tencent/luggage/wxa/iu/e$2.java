package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;

class e$2
  implements Runnable
{
  e$2(e parame, d paramd1, d paramd2, Runnable paramRunnable) {}
  
  public void run()
  {
    boolean bool = this.d.d(this.a);
    Object localObject = this.b;
    if (localObject != null) {
      ((d)localObject).b(this.a.B(), null);
    }
    this.c.run();
    if ((bool) && (this.b != null) && (e.c(this.d))) {
      this.b.aA();
    }
    localObject = this.b;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((d)localObject).aa();
    }
    o.d("MicroMsg.AppBrandRuntimeContainer", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", new Object[] { Boolean.valueOf(bool), localObject, Boolean.valueOf(e.c(this.d)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e.2
 * JD-Core Version:    0.7.0.1
 */