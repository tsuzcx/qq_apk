package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.b;
import com.tencent.mm.ui.i;

class KeyStepAnalyserDetailActivity$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  KeyStepAnalyserDetailActivity$3(KeyStepAnalyserDetailActivity paramKeyStepAnalyserDetailActivity, b paramb, Context paramContext) {}
  
  public void onGlobalLayout()
  {
    this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    if (this.a.getWidth() > 0)
    {
      Point localPoint = i.a(this.b);
      KeyStepAnalyserDetailActivity.a(this.c, localPoint.x / 2 - this.a.getWidth() / 2);
      KeyStepAnalyserDetailActivity.b(this.c, localPoint.y / 2 - this.a.getHeight() / 2 - this.c.findViewById(2131434940).getHeight() - this.c.findViewById(2131427509).getHeight());
      KeyStepAnalyserDetailActivity.c(this.c, this.a.getWidth() / 2.0F);
      KeyStepAnalyserDetailActivity.d(this.c, this.a.getHeight() / 2.0F);
      KeyStepAnalyserDetailActivity localKeyStepAnalyserDetailActivity = this.c;
      KeyStepAnalyserDetailActivity.e(localKeyStepAnalyserDetailActivity, KeyStepAnalyserDetailActivity.f(localKeyStepAnalyserDetailActivity, localPoint.x / this.a.getWidth()));
      KeyStepAnalyserDetailActivity.c(this.c).setTranslationX(KeyStepAnalyserDetailActivity.b(this.c));
      KeyStepAnalyserDetailActivity.c(this.c).setTranslationY(KeyStepAnalyserDetailActivity.d(this.c));
      KeyStepAnalyserDetailActivity.c(this.c).setPivotX(KeyStepAnalyserDetailActivity.e(this.c));
      KeyStepAnalyserDetailActivity.c(this.c).setPivotY(KeyStepAnalyserDetailActivity.f(this.c));
      KeyStepAnalyserDetailActivity.c(this.c).setScaleX(KeyStepAnalyserDetailActivity.g(this.c));
      KeyStepAnalyserDetailActivity.c(this.c).setScaleY(KeyStepAnalyserDetailActivity.g(this.c));
      KeyStepAnalyserDetailActivity.h(this.c).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */