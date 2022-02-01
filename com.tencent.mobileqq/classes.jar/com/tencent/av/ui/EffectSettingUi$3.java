package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import com.tencent.qphone.base.util.QLog;

class EffectSettingUi$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  EffectSettingUi$3(EffectSettingUi paramEffectSettingUi, ViewTreeObserver paramViewTreeObserver, HorizontalScrollView paramHorizontalScrollView) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_AndroidViewViewTreeObserver.removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a, 1, "onGlobalLayout");
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setTag(new Object());
      this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.d();
      return;
      this.jdField_a_of_type_AndroidViewViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi.3
 * JD-Core Version:    0.7.0.1
 */