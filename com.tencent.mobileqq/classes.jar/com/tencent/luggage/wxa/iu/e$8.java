package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;

class e$8
  implements Runnable
{
  e$8(e parame) {}
  
  public void run()
  {
    try
    {
      d locald = this.a.getActiveRuntime();
      if (locald != null)
      {
        e.a(this.a, locald, true);
        e.b(this.a, locald);
        locald.aA();
        return;
      }
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.AppBrandRuntimeContainer", "doOnResume e=%s", new Object[] { localException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e.8
 * JD-Core Version:    0.7.0.1
 */