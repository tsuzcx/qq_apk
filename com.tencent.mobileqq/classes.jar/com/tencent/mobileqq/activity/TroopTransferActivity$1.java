package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopTransferActivity$1
  implements View.OnClickListener
{
  TroopTransferActivity$1(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.1
 * JD-Core Version:    0.7.0.1
 */