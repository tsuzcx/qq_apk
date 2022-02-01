package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ab$o
  extends ClickableSpan
{
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "arg0");
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
    if (this.a.d().h())
    {
      ab.a(this.a, false, 1, null);
      return;
    }
    o.b("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
    paramView = this.a;
    String str = paramView.b().getString(2131886805);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(R.stri…end_verify_code_frequent)");
    ab.c(paramView, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.ab.o
 * JD-Core Version:    0.7.0.1
 */