package com.tencent.luggage.wxa.lq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.wxa.iu.h;
import java.util.HashMap;
import java.util.Map;

class c$2$3
  implements DialogInterface.OnCancelListener
{
  c$2$3(c.2 param2) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("confirm", Boolean.valueOf(false));
    paramDialogInterface.put("cancel", Boolean.valueOf(true));
    this.a.a.a(this.a.f, this.a.k.a("ok", paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.c.2.3
 * JD-Core Version:    0.7.0.1
 */