package com.tencent.luggage.wxa.ny;

import android.content.Context;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;

class g$1$2
  implements Function<Context, i.a>
{
  g$1$2(g.1 param1) {}
  
  public i.a a(Context paramContext)
  {
    Object localObject = g.a(this.a.d).ah();
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = g.a(this.a.d).ag();
    }
    localObject = new e(paramContext);
    ((e)localObject).setMessage(paramContext.getString(2131891457));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.g.1.2
 * JD-Core Version:    0.7.0.1
 */