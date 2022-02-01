package com.tencent.luggage.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.pd.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class PhoneNumberVerifyCodeUI$i
  implements DialogInterface.OnClickListener
{
  PhoneNumberVerifyCodeUI$i(PhoneNumberVerifyCodeUI paramPhoneNumberVerifyCodeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject1 = PhoneNumberVerifyCodeUI.d(this.a);
    EditVerifyCodeView localEditVerifyCodeView = null;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
    } else {
      localObject1 = null;
    }
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "to verify sms %s", new Object[] { localObject1 });
    localObject1 = PhoneNumberVerifyCodeUI.d(this.a);
    if (localObject1 != null)
    {
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      if ((localObject1 != null) && (((String)localObject1).length() == 6))
      {
        paramDialogInterface.dismiss();
        PhoneNumberVerifyCodeUI.c(this.a);
        localObject1 = this.a;
        localEditVerifyCodeView = PhoneNumberVerifyCodeUI.d((PhoneNumberVerifyCodeUI)localObject1);
        paramDialogInterface = localObject2;
        if (localEditVerifyCodeView != null) {
          paramDialogInterface = localEditVerifyCodeView.getText();
        }
        PhoneNumberVerifyCodeUI.a((PhoneNumberVerifyCodeUI)localObject1, String.valueOf(paramDialogInterface));
        return;
      }
    }
    paramDialogInterface = PhoneNumberVerifyCodeUI.d(this.a);
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getText();
      if (paramDialogInterface != null)
      {
        paramDialogInterface = Integer.valueOf(paramDialogInterface.length());
        break label154;
      }
    }
    paramDialogInterface = null;
    label154:
    if (paramDialogInterface == null) {
      Intrinsics.throwNpe();
    }
    if (paramDialogInterface.intValue() < 6)
    {
      o.b("MicroMsg.PhoneNumberVerifyCodeUI", "code is length is < 6");
      PhoneNumberVerifyCodeUI.c(this.a);
      paramDialogInterface = this.a;
      f.a((Context)paramDialogInterface, paramDialogInterface.getString(2131886809));
      return;
    }
    localObject1 = PhoneNumberVerifyCodeUI.d(this.a);
    paramDialogInterface = localEditVerifyCodeView;
    if (localObject1 != null)
    {
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      paramDialogInterface = localEditVerifyCodeView;
      if (localObject1 != null) {
        paramDialogInterface = Integer.valueOf(((String)localObject1).length());
      }
    }
    if (paramDialogInterface == null) {
      Intrinsics.throwNpe();
    }
    if (paramDialogInterface.intValue() == 0)
    {
      o.b("MicroMsg.PhoneNumberVerifyCodeUI", "code is empty");
      PhoneNumberVerifyCodeUI.c(this.a);
      paramDialogInterface = this.a;
      f.a((Context)paramDialogInterface, paramDialogInterface.getString(2131886808));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.i
 * JD-Core Version:    0.7.0.1
 */