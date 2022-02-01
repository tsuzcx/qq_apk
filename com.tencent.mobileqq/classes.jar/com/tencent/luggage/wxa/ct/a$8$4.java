package com.tencent.luggage.wxa.ct;

import android.text.TextUtils;
import com.tencent.luggage.util.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.xweb.JsResult;

class a$8$4
  implements Runnable
{
  a$8$4(a.8 param8, JsResult paramJsResult, String paramString1, String paramString2) {}
  
  public void run()
  {
    l locall = a.c(this.d.a).getDialogContainer();
    if (locall == null)
    {
      this.a.cancel();
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.dialog.b localb = new com.tencent.mm.plugin.appbrand.widget.dialog.b(this.d.a.getContext());
    localb.setMessage(this.b);
    String str = m.a(this.c);
    if (!TextUtils.isEmpty(str)) {
      localb.setTitle(str);
    }
    localb.setCancelable(false);
    localb.setPositiveButton(2131887629, new a.8.4.1(this));
    localb.setNegativeButton(2131887626, new a.8.4.2(this));
    locall.a(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.8.4
 * JD-Core Version:    0.7.0.1
 */