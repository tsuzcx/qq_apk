package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.wxa.qz.o;

class c$3
  implements DialogInterface.OnCancelListener
{
  c$3(c paramc, c.a parama) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    o.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
    this.a.a(3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c.3
 * JD-Core Version:    0.7.0.1
 */