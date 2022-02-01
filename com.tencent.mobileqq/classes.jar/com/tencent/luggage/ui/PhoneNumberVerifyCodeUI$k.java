package com.tencent.luggage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class PhoneNumberVerifyCodeUI$k
  implements DialogInterface.OnClickListener
{
  PhoneNumberVerifyCodeUI$k(PhoneNumberVerifyCodeUI paramPhoneNumberVerifyCodeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PhoneNumberVerifyCodeUI.b(this.a, "fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.k
 * JD-Core Version:    0.7.0.1
 */