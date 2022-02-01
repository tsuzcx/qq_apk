package com.tencent.luggage.wxa.ok;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.do.a;
import com.tencent.luggage.wxa.or.n;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final u a;
  protected final AtomicReference<c.b> b = new AtomicReference();
  
  b(@NonNull u paramu)
  {
    this.b.set(c.b.a);
    this.a = paramu;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void c()
  {
    if ((this.a.y() instanceof n))
    {
      Activity localActivity = ((n)this.a.y()).u();
      if (localActivity == null) {
        return;
      }
      if (((a)this.a.b(a.class)).b)
      {
        com.tencent.mm.plugin.appbrand.ui.c.a(localActivity, true);
        return;
      }
      com.tencent.mm.plugin.appbrand.ui.c.a(localActivity, false);
    }
  }
  
  public void d() {}
  
  public c.b e()
  {
    return (c.b)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ok.b
 * JD-Core Version:    0.7.0.1
 */