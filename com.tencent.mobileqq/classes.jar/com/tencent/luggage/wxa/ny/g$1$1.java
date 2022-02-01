package com.tencent.luggage.wxa.ny;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;

class g$1$1
  implements DialogInterface.OnCancelListener
{
  g$1$1(g.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    g.a(this.a.d, ((ModulePkgInfo)this.a.b.a).name, a.d.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.g.1.1
 * JD-Core Version:    0.7.0.1
 */