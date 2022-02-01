package com.tencent.luggage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class PhoneNumberVerifyCodeUI$g
  implements DialogInterface.OnClickListener
{
  PhoneNumberVerifyCodeUI$g(PhoneNumberVerifyCodeUI paramPhoneNumberVerifyCodeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    o.b("MicroMsg.PhoneNumberVerifyCodeUI", "verify code is error, do send the right code");
    PhoneNumberVerifyCodeUI.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.g
 * JD-Core Version:    0.7.0.1
 */