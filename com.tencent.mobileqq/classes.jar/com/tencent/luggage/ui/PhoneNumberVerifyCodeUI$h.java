package com.tencent.luggage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class PhoneNumberVerifyCodeUI$h
  implements DialogInterface.OnDismissListener
{
  PhoneNumberVerifyCodeUI$h(PhoneNumberVerifyCodeUI paramPhoneNumberVerifyCodeUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "cancel to verify sms");
    PhoneNumberVerifyCodeUI.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.h
 * JD-Core Version:    0.7.0.1
 */