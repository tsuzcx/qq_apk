package com.tencent.luggage.wxa.iu;

import android.app.Activity;
import com.tencent.luggage.wxa.or.b;
import com.tencent.luggage.wxa.pc.a;
import com.tencent.luggage.wxa.qz.o;

class e$4
  extends a
{
  e$4(e parame) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (this.a.u() == paramActivity)
    {
      o.d("MicroMsg.AppBrandRuntimeContainer", "onActivityDestroyed %s", new Object[] { paramActivity.getLocalClassName() });
      e.b(this.a);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (this.a.u() == paramActivity)
    {
      o.d("MicroMsg.AppBrandRuntimeContainer", "onActivityPaused %s", new Object[] { paramActivity.getLocalClassName() });
      e.a(this.a, false);
      e.b(this.a, true);
      this.a.v().c();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (this.a.u() == paramActivity)
    {
      o.d("MicroMsg.AppBrandRuntimeContainer", "onActivityResumed %s", new Object[] { paramActivity.getLocalClassName() });
      e.a(this.a, true);
      e.b(this.a, false);
      this.a.v().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e.4
 * JD-Core Version:    0.7.0.1
 */