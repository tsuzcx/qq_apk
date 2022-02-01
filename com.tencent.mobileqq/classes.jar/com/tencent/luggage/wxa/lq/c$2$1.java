package com.tencent.luggage.wxa.lq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.iu.h;
import java.util.HashMap;
import java.util.Map;

class c$2$1
  implements DialogInterface.OnClickListener
{
  c$2$1(c.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("confirm", Boolean.valueOf(true));
    paramDialogInterface.put("cancel", Boolean.valueOf(false));
    this.a.a.a(this.a.f, this.a.k.a("ok", paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.c.2.1
 * JD-Core Version:    0.7.0.1
 */