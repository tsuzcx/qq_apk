package com.tencent.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.QQMapView;

class PoiMapActivity$4
  implements DialogInterface.OnDismissListener
{
  PoiMapActivity$4(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PoiMapActivity.f(this.c).setEnabled(false);
    this.c.u.getHandler().postDelayed(new PoiMapActivity.4.1(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.4
 * JD-Core Version:    0.7.0.1
 */