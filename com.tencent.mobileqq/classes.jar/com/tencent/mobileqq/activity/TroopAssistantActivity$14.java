package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssistantActivity$14
  implements View.OnClickListener
{
  TroopAssistantActivity$14(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.isFinishing())
    {
      TroopAssistantActivity localTroopAssistantActivity = this.a;
      localTroopAssistantActivity.f = false;
      if (localTroopAssistantActivity.k != null)
      {
        this.a.k.a(4);
        this.a.d();
        this.a.c();
      }
      if (TroopAssistantManager.a().d()) {
        TroopAssistantManager.a().i(this.a.app);
      }
      TroopAssistantActivity.b(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.14
 * JD-Core Version:    0.7.0.1
 */