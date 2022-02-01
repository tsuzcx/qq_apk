package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ab$c
  extends CountDownTimer
{
  public ab$c(long paramLong1, long paramLong2)
  {
    super(???, localObject);
  }
  
  public void onFinish()
  {
    ab.b(this.a);
  }
  
  public void onTick(long paramLong)
  {
    TextView localTextView = ab.a(this.a);
    if (localTextView != null)
    {
      Context localContext = this.a.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramLong / 1000);
      localTextView.setText((CharSequence)localContext.getString(2131886802, new Object[] { localStringBuilder.toString() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.ab.c
 * JD-Core Version:    0.7.0.1
 */