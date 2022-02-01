package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import com.tencent.qphone.base.util.QLog;

class EffectSettingUi$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  EffectSettingUi$2(EffectSettingUi paramEffectSettingUi, ViewTreeObserver paramViewTreeObserver, HorizontalScrollView paramHorizontalScrollView) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.removeOnGlobalLayoutListener(this);
    } else {
      this.a.removeGlobalOnLayoutListener(this);
    }
    QLog.w(this.c.g, 1, "onGlobalLayout");
    this.b.setTag(new Object());
    this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi.2
 * JD-Core Version:    0.7.0.1
 */