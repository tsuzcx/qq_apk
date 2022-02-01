package com.tencent.mm.plugin.appbrand.keylogger;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.widget.LinearLayout;

class KeyStepAnalyserDetailActivity$5
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  KeyStepAnalyserDetailActivity$5(KeyStepAnalyserDetailActivity paramKeyStepAnalyserDetailActivity) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (KeyStepAnalyserDetailActivity.c(this.a) == null) {
      return true;
    }
    KeyStepAnalyserDetailActivity.e(this.a, paramScaleGestureDetector.getScaleFactor() * KeyStepAnalyserDetailActivity.j(this.a));
    if (KeyStepAnalyserDetailActivity.g(this.a) <= 5.0F)
    {
      if (KeyStepAnalyserDetailActivity.g(this.a) < 0.1F) {
        return true;
      }
      KeyStepAnalyserDetailActivity.c(this.a).setTranslationX(KeyStepAnalyserDetailActivity.b(this.a));
      KeyStepAnalyserDetailActivity.c(this.a).setTranslationY(KeyStepAnalyserDetailActivity.d(this.a));
      KeyStepAnalyserDetailActivity.c(this.a).setPivotX(KeyStepAnalyserDetailActivity.e(this.a));
      KeyStepAnalyserDetailActivity.c(this.a).setPivotY(KeyStepAnalyserDetailActivity.f(this.a));
      KeyStepAnalyserDetailActivity.c(this.a).setScaleX(KeyStepAnalyserDetailActivity.g(this.a));
      KeyStepAnalyserDetailActivity.c(this.a).setScaleY(KeyStepAnalyserDetailActivity.g(this.a));
      paramScaleGestureDetector = this.a;
      KeyStepAnalyserDetailActivity.f(paramScaleGestureDetector, KeyStepAnalyserDetailActivity.g(paramScaleGestureDetector));
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.5
 * JD-Core Version:    0.7.0.1
 */