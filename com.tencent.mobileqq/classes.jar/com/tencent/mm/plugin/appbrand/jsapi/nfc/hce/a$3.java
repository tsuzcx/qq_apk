package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.qz.o;

class a$3
  implements DialogInterface.OnClickListener
{
  a$3(a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    o.d("MicroMsg.HCEActivityMgr", "alvinluo user click cancel button of NFC tips dialog.");
    a.a(this.a, 13001, "system NFC switch not opened");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.3
 * JD-Core Version:    0.7.0.1
 */