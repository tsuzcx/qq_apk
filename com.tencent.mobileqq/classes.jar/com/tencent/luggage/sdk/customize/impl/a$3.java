package com.tencent.luggage.sdk.customize.impl;

class a$3
  implements Runnable
{
  a$3(a parama, com.tencent.luggage.wxa.iu.d paramd, Runnable paramRunnable) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject instanceof com.tencent.luggage.wxa.ed.d)) {
      ((com.tencent.luggage.wxa.ed.d)localObject).x();
    }
    localObject = this.b;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.a.3
 * JD-Core Version:    0.7.0.1
 */