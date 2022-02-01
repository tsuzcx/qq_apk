package com.tencent.luggage.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/PhoneNumberVerifyCodeUI$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/luggage/ui/PhoneNumberVerifyCodeUI;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class PhoneNumberVerifyCodeUI$b
  extends CountDownTimer
{
  public PhoneNumberVerifyCodeUI$b(long paramLong1, long paramLong2)
  {
    super(???, localObject);
  }
  
  public void onFinish()
  {
    PhoneNumberVerifyCodeUI.b(this.a);
  }
  
  public void onTick(long paramLong)
  {
    TextView localTextView = PhoneNumberVerifyCodeUI.a(this.a);
    if (localTextView != null)
    {
      PhoneNumberVerifyCodeUI localPhoneNumberVerifyCodeUI = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramLong / 1000);
      localTextView.setText((CharSequence)localPhoneNumberVerifyCodeUI.getString(2131886802, new Object[] { localStringBuilder.toString() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.b
 * JD-Core Version:    0.7.0.1
 */