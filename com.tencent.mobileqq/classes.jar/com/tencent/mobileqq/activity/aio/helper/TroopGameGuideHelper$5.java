package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGameGuideHelper$5
  implements View.OnClickListener
{
  TroopGameGuideHelper$5(TroopGameGuideHelper paramTroopGameGuideHelper) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    if ((TroopGameGuideHelper.a(this.a) != null) && (TroopGameGuideHelper.a(this.a).ah != null) && (TroopGameGuideHelper.a(this.a).d != null))
    {
      if (this.a.e == null)
      {
        TroopGameGuideHelper localTroopGameGuideHelper = this.a;
        localTroopGameGuideHelper.e = ((ITroopGameHandler)TroopGameGuideHelper.a(localTroopGameGuideHelper).d.getBusinessHandler(BusinessHandlerFactory.TROOP_GAME_HANDLER));
      }
      if (this.a.e != null)
      {
        TroopGameGuideHelper.a(this.a).d.addObserver(TroopGameGuideHelper.c(this.a));
        this.a.e.a(TroopGameGuideHelper.a(this.a).ah.b, true);
      }
      TroopReportor.a("Grp_AIO", "AIO_clk", "game_tips_clk_on", 0, 0, new String[] { this.a.d });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper.5
 * JD-Core Version:    0.7.0.1
 */