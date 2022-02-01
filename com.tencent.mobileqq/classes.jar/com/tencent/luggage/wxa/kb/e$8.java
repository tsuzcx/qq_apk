package com.tencent.luggage.wxa.kb;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.page.u;

class e$8
  implements DialogInterface.OnClickListener
{
  e$8(e parame, com.tencent.luggage.wxa.qw.o paramo, u paramu, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
    this.a.c = true;
    this.b.a(this.c, this.d.b("ok"));
    e.a(this.d, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.e.8
 * JD-Core Version:    0.7.0.1
 */