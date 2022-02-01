package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

class TroopTransferActivity$8
  implements DialogInterface.OnDismissListener
{
  TroopTransferActivity$8(TroopTransferActivity paramTroopTransferActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    try
    {
      this.c.f.offsetTopAndBottom(-this.a);
      this.c.a.setVisibility(0);
      this.c.f.startAnimation(this.b);
      paramDialogInterface = (InputMethodManager)this.c.getSystemService("input_method");
      if (paramDialogInterface != null)
      {
        paramDialogInterface.hideSoftInputFromWindow(this.c.getWindow().peekDecorView().getWindowToken(), 0);
        return;
      }
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.8
 * JD-Core Version:    0.7.0.1
 */