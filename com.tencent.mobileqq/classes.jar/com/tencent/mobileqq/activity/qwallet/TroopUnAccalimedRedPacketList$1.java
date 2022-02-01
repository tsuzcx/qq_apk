package com.tencent.mobileqq.activity.qwallet;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopUnAccalimedRedPacketList$1
  implements View.OnClickListener
{
  TroopUnAccalimedRedPacketList$1(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onClick(View paramView)
  {
    TroopUnAccalimedRedPacketList.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.1
 * JD-Core Version:    0.7.0.1
 */