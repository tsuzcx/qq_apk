package com.tencent.luggage.wxa.ct;

import android.content.Context;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;

class a$8$1
  implements Runnable
{
  a$8$1(a.8 param8, GeolocationPermissions.Callback paramCallback, String paramString) {}
  
  public void run()
  {
    l locall = a.c(this.c.a).getDialogContainer();
    if (locall == null)
    {
      this.a.invoke(this.b, false, false);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.dialog.b localb = new com.tencent.mm.plugin.appbrand.widget.dialog.b(this.c.a.getContext());
    localb.setTitle(this.c.a.getContext().getString(2131890777));
    localb.setMessage(this.c.a.getContext().getString(2131890776, new Object[] { this.b }));
    localb.setPositiveButton(2131887629, new a.8.1.1(this));
    localb.setNegativeButton(2131887626, new a.8.1.2(this));
    localb.setCancelable(false);
    locall.a(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.8.1
 * JD-Core Version:    0.7.0.1
 */