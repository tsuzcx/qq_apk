package com.tencent.av.ui.effect.menuview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.qphone.base.util.QLog;

class QavEffectMenuView$1
  implements View.OnTouchListener
{
  QavEffectMenuView$1(QavEffectMenuView paramQavEffectMenuView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    BaseToolbar.keepInToolbar(QavEffectMenuView.a(this.a), -1008L);
    paramView = new StringBuilder();
    paramView.append("m_qav_effect_bottom, onTouchEvent[");
    paramView.append(paramMotionEvent.getAction());
    paramView.append("]");
    QLog.w("QavEffectMenuView", 1, paramView.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.menuview.QavEffectMenuView.1
 * JD-Core Version:    0.7.0.1
 */