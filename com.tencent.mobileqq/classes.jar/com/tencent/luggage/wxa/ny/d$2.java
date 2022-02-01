package com.tencent.luggage.wxa.ny;

import android.content.Context;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.qz.v.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;

class d$2
  implements v.a
{
  d$2(d paramd, com.tencent.luggage.wxa.iu.d paramd1) {}
  
  public boolean p_()
  {
    if (!d.a(this.b))
    {
      if (d.b(this.b)) {
        return false;
      }
      Object localObject1 = this.a.ah();
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.a.ag();
      }
      if (d.c(this.b) == null) {
        localObject1 = null;
      } else {
        localObject1 = (i.a)d.c(this.b).apply(localObject2);
      }
      Object localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new e((Context)localObject2);
      }
      ((i.a)localObject3).setOnCancelListener(d.d(this.b));
      ((i.a)localObject3).setCancelable(true);
      ((i.a)localObject3).setCanceledOnTouchOutside(false);
      this.a.ao().a((i)localObject3);
      d.a(this.b, (i.a)localObject3);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.d.2
 * JD-Core Version:    0.7.0.1
 */