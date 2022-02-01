package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.wxa.qz.o;

class a$4
  implements DialogInterface.OnCancelListener
{
  a$4(a parama) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    o.d("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
    a.a(this.a, 13001, "system NFC switch not opened");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.4
 * JD-Core Version:    0.7.0.1
 */