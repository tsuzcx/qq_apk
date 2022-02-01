package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGameGuideHelper$4
  implements View.OnClickListener
{
  TroopGameGuideHelper$4(TroopGameGuideHelper paramTroopGameGuideHelper) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    TroopReportor.a("Grp_AIO", "AIO_clk", "game_tips_clk_off", 0, 0, new String[] { this.a.b });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper.4
 * JD-Core Version:    0.7.0.1
 */