package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EffectSettingBtn$5
  implements View.OnClickListener
{
  EffectSettingBtn$5(EffectSettingBtn paramEffectSettingBtn) {}
  
  public void onClick(View paramView)
  {
    this.a.b.b().k().bJ = true;
    UITools.b(this.a.b);
    EffectSettingBtn.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingBtn.5
 * JD-Core Version:    0.7.0.1
 */