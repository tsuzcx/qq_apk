package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

class ScannerFlashSwitcher$2
  extends AnimatorListenerAdapter
{
  ScannerFlashSwitcher$2(ScannerFlashSwitcher paramScannerFlashSwitcher) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ScannerFlashSwitcher.a(this.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.ScannerFlashSwitcher.2
 * JD-Core Version:    0.7.0.1
 */