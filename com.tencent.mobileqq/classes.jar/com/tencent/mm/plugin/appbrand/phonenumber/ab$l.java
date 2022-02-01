package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class ab$l
  implements DialogInterface.OnDismissListener
{
  ab$l(ab paramab) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
    ab.c(this.a);
    ab.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.ab.l
 * JD-Core Version:    0.7.0.1
 */