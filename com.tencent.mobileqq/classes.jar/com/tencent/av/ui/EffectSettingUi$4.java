package com.tencent.av.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.qphone.base.util.QLog;

class EffectSettingUi$4
  implements View.OnTouchListener
{
  EffectSettingUi$4(EffectSettingUi paramEffectSettingUi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    BaseToolbar.keepInToolbar(this.a.h, -1008L);
    paramView = this.a.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("m_qav_effect_bottom, onTouchEvent[");
    localStringBuilder.append(paramMotionEvent.getAction());
    localStringBuilder.append("]");
    QLog.w(paramView, 1, localStringBuilder.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi.4
 * JD-Core Version:    0.7.0.1
 */