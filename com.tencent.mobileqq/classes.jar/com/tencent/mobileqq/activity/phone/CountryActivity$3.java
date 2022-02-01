package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.widget.IndexView;

class CountryActivity$3
  implements DialogInterface.OnDismissListener
{
  CountryActivity$3(CountryActivity paramCountryActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.c.e.offsetTopAndBottom(-this.a);
    this.c.d.setVisibility(0);
    this.c.a.setVisibility(0);
    this.c.e.startAnimation(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity.3
 * JD-Core Version:    0.7.0.1
 */