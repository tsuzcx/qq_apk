package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class EffectSettingBtn$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  @TargetApi(16)
  public void onGlobalLayout()
  {
    ViewTreeObserver localViewTreeObserver = this.a.c.getViewTreeObserver();
    if (Build.VERSION.SDK_INT >= 16) {
      localViewTreeObserver.removeOnGlobalLayoutListener(this);
    } else {
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
    this.a.g = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingBtn.1
 * JD-Core Version:    0.7.0.1
 */