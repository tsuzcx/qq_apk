package com.tencent.luggage.wxa.bt;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.a.a;
import com.tencent.luggage.wxa.ok.c.b;
import com.tencent.mm.plugin.appbrand.page.u;

final class a
  implements com.tencent.luggage.wxa.ok.c
{
  private final u a;
  private c.b b = null;
  
  public a(@NonNull u paramu)
  {
    this.a = paramu;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = com.tencent.luggage.wxa.rc.a.a(this.a.getContext());
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.ui.c.a((Window)localObject, true, true);
      return;
    }
    com.tencent.mm.plugin.appbrand.ui.c.a((Window)localObject, false);
  }
  
  public void a()
  {
    this.b = c.b.a;
    a(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.a.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.a.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
  }
  
  public void b()
  {
    this.b = c.b.b;
    a(true);
  }
  
  public void c()
  {
    if (this.b == null)
    {
      c.b localb;
      if (this.a.q().aj().f().b) {
        localb = c.b.a;
      } else {
        localb = c.b.b;
      }
      this.b = localb;
    }
    int i = a.1.a[this.b.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      b();
      return;
    }
    a();
  }
  
  public void d() {}
  
  public c.b e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bt.a
 * JD-Core Version:    0.7.0.1
 */