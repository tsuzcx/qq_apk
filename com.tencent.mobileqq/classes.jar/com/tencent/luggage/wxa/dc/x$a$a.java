package com.tencent.luggage.wxa.dc;

import android.app.Activity;
import com.tencent.luggage.wxa.bi.b;
import com.tencent.luggage.wxa.iu.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class x$a$a
  implements Runnable
{
  x$a$a(Activity paramActivity, Function0 paramFunction01, Function0 paramFunction02) {}
  
  public final void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!this.a.isDestroyed()))
    {
      localObject = this.a;
      if ((localObject instanceof b))
      {
        int i = ((b)localObject).c();
        if (i != 0)
        {
          if (i != 1)
          {
            this.c.invoke();
            return;
          }
          localObject = ((b)this.a).d();
          if ((localObject != null) && (((d)localObject).aw() == true) && (!((d)localObject).av()) && (!((d)localObject).au()))
          {
            this.c.invoke();
            return;
          }
          this.b.invoke();
          return;
        }
        this.b.invoke();
        return;
      }
      this.c.invoke();
      return;
    }
    this.b.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.x.a.a
 * JD-Core Version:    0.7.0.1
 */