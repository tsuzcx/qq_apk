package com.tencent.av.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;

class EffectSettingBtn$4
  implements ViewTreeObserver.OnPreDrawListener
{
  EffectSettingBtn$4(EffectSettingBtn paramEffectSettingBtn, TextView paramTextView) {}
  
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    this.b.b.b().k().bJ = true;
    UITools.b(this.b.b);
    QLog.d("qav_face_guide", 1, "onPreDraw");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingBtn.4
 * JD-Core Version:    0.7.0.1
 */