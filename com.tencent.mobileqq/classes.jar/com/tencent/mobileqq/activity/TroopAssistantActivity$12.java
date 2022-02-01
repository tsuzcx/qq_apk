package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssistantActivity$12
  implements View.OnClickListener
{
  TroopAssistantActivity$12(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isFinishing()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.c = false;
      if (this.a.a != null)
      {
        this.a.a.a(4);
        this.a.d();
        this.a.c();
      }
      if (TroopAssistantManager.a().c()) {
        TroopAssistantManager.a().f(this.a.app);
      }
      TroopAssistantActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.12
 * JD-Core Version:    0.7.0.1
 */