package com.tencent.luggage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class PhoneNumberVerifyCodeUI$j
  implements DialogInterface.OnClickListener
{
  PhoneNumberVerifyCodeUI$j(PhoneNumberVerifyCodeUI paramPhoneNumberVerifyCodeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "cancel to verify sms");
    paramDialogInterface.dismiss();
    PhoneNumberVerifyCodeUI.c(this.a);
    PhoneNumberVerifyCodeUI.b(this.a, "user cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.j
 * JD-Core Version:    0.7.0.1
 */