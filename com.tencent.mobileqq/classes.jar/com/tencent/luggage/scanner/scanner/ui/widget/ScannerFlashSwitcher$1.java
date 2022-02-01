package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;

class ScannerFlashSwitcher$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ScannerFlashSwitcher$1(ScannerFlashSwitcher paramScannerFlashSwitcher) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ScannerFlashSwitcher.a(this.a).setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.ScannerFlashSwitcher.1
 * JD-Core Version:    0.7.0.1
 */