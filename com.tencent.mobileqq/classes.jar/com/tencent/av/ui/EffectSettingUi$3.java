package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class EffectSettingUi$3
  implements View.OnClickListener
{
  EffectSettingUi$3(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    BaseToolbar.keepInToolbar(this.a.h, -1007L);
    this.a.c(-1007L);
    AVEffectReport.b();
    if (EffectSettingUi.b(this.a) != null)
    {
      AVActivity localAVActivity = (AVActivity)EffectSettingUi.c(this.a).get();
      localAVActivity.ab.a(-1007L, localAVActivity, 99, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi.3
 * JD-Core Version:    0.7.0.1
 */