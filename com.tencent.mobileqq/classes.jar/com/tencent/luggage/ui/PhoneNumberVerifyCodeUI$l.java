package com.tencent.luggage.ui;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/PhoneNumberVerifyCodeUI$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class PhoneNumberVerifyCodeUI$l
  extends ClickableSpan
{
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "arg0");
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "click the resend spanBuilder, do resend sms");
    paramView = PhoneNumberVerifyCodeUI.f(this.a);
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    if (paramView.h())
    {
      PhoneNumberVerifyCodeUI.a(this.a, false, 1, null);
      return;
    }
    o.b("MicroMsg.PhoneNumberVerifyCodeUI", "allow_send_sms is false, show send_verify_code_frequent error");
    paramView = this.a;
    String str = paramView.getString(2131886805);
    Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.app_b…end_verify_code_frequent)");
    PhoneNumberVerifyCodeUI.c(paramView, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.l
 * JD-Core Version:    0.7.0.1
 */