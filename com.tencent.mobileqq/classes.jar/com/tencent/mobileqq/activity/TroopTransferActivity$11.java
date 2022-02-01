package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopTransferActivity$11
  implements View.OnClickListener
{
  TroopTransferActivity$11(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.11
 * JD-Core Version:    0.7.0.1
 */