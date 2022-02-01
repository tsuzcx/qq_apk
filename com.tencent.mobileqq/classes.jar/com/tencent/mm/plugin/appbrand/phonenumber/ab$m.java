package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.pd.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class ab$m
  implements DialogInterface.OnClickListener
{
  ab$m(ab paramab) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject1 = ab.e(this.a);
    EditVerifyCodeView localEditVerifyCodeView = null;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
    } else {
      localObject1 = null;
    }
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", new Object[] { localObject1 });
    localObject1 = ab.e(this.a);
    if (localObject1 != null)
    {
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      if ((localObject1 != null) && (((String)localObject1).length() == 6))
      {
        paramDialogInterface.dismiss();
        ab.c(this.a);
        ab.d(this.a);
        localObject1 = this.a;
        localEditVerifyCodeView = ab.e((ab)localObject1);
        paramDialogInterface = localObject2;
        if (localEditVerifyCodeView != null) {
          paramDialogInterface = localEditVerifyCodeView.getText();
        }
        ab.a((ab)localObject1, String.valueOf(paramDialogInterface));
        return;
      }
    }
    paramDialogInterface = ab.e(this.a);
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getText();
      if (paramDialogInterface != null)
      {
        paramDialogInterface = Integer.valueOf(paramDialogInterface.length());
        break label161;
      }
    }
    paramDialogInterface = null;
    label161:
    if (paramDialogInterface == null) {
      Intrinsics.throwNpe();
    }
    if (paramDialogInterface.intValue() < 6)
    {
      o.b("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
      f.a(this.a.b(), this.a.b().getString(2131886809), this.a.b().getString(2131886801), (DialogInterface.OnClickListener)ab.m.1.a);
      return;
    }
    localObject1 = ab.e(this.a);
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
      o.b("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
      f.a(this.a.b(), this.a.b().getString(2131886808), this.a.b().getString(2131886801), (DialogInterface.OnClickListener)ab.m.2.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.ab.m
 * JD-Core Version:    0.7.0.1
 */