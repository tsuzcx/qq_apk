package com.tencent.luggage.wxa.ed;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.f;
import com.tencent.luggage.wxa.os.a;
import com.tencent.luggage.wxa.os.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.ui.i;

@SuppressLint({"ViewConstructor"})
public class c
  extends f<d>
  implements b
{
  private com.tencent.luggage.wxa.oq.e b;
  
  public void a(d paramd, com.tencent.luggage.wxa.do.c paramc, com.tencent.luggage.wxa.ou.d paramd1)
  {
    paramc.a(paramd1);
    super.a(paramd, paramc);
  }
  
  protected void a(@Nullable com.tencent.luggage.wxa.iu.d paramd1, @NonNull com.tencent.luggage.wxa.iu.d paramd2, @NonNull Runnable paramRunnable)
  {
    super.a(paramd1, paramd2, paramRunnable);
    String str;
    if (paramd1 == null) {
      str = "null";
    } else {
      str = paramd1.aa();
    }
    o.d("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { str, paramd2.aa() });
    paramRunnable.run();
    if ((getStackSize() <= 1) && (paramd1 == null))
    {
      a(false);
      o.d("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose: activity closed");
      return;
    }
    if (paramd2.aK()) {
      ((i)com.tencent.luggage.wxa.ba.e.a(i.class)).b(paramd1, null, paramd2, null);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Activity localActivity = getActivity();
    if (localActivity == null)
    {
      o.d("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "closeActivity: fail");
      return;
    }
    if (!localActivity.isFinishing())
    {
      localActivity.moveTaskToBack(true);
      if (getStackSize() <= 0)
      {
        localActivity.overridePendingTransition(0, 0);
        return;
      }
      ((i)com.tencent.luggage.wxa.ba.e.a(i.class)).a(localActivity);
    }
  }
  
  public com.tencent.luggage.wxa.oq.e getOrientationHandler()
  {
    if (this.b == null) {
      this.b = new a(this);
    }
    return this.b;
  }
  
  @Nullable
  public boolean i_()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.c
 * JD-Core Version:    0.7.0.1
 */