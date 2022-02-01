package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopPobingItemBuilder$2
  implements View.OnClickListener
{
  TroopPobingItemBuilder$2(TroopPobingItemBuilder paramTroopPobingItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131429755) {
      TroopPobingItemBuilder.a(this.a).a(paramView);
    } else if (paramView.getId() == 2131429756) {
      TroopPobingItemBuilder.a(this.a).b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */