package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EffectSettingUi$1
  implements View.OnClickListener
{
  EffectSettingUi$1(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.c();
    int k = paramView.getId();
    Object localObject = paramView.getTag(2131446795);
    if ((localObject instanceof Boolean)) {
      bool = ((Boolean)localObject).booleanValue();
    } else {
      bool = false;
    }
    int m = EffectSettingUi.a(this.a);
    boolean bool = EffectSettingUi.a(this.a, l, k, bool);
    int i;
    if (k == 4) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (i != 0)
    {
      localObject = ((AVActivity)this.a.getContext()).aa;
      if ((localObject != null) && ((localObject == null) || (((EffectFilterPanel)localObject).getVisibility() != 8))) {
        j = 0;
      } else {
        j = 1;
      }
    }
    if ((bool) && ((m != k) || (j != 0))) {
      this.a.h.a(new Object[] { Integer.valueOf(6105), Integer.valueOf(k), Long.valueOf(l) });
    }
    if (bool)
    {
      localObject = VideoController.f().m(true);
      if (localObject != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.a.g, 1, "onShow clear state");
        }
        ((EffectController)localObject).a(k);
      }
    }
    this.a.h.a(new Object[] { Integer.valueOf(165), Integer.valueOf(1) });
    if (m != k) {
      this.a.a(k, bool);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi.1
 * JD-Core Version:    0.7.0.1
 */