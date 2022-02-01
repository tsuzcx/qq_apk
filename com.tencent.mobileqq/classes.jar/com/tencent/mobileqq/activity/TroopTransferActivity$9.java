package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopTransferActivity$9
  implements View.OnClickListener
{
  TroopTransferActivity$9(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.9
 * JD-Core Version:    0.7.0.1
 */