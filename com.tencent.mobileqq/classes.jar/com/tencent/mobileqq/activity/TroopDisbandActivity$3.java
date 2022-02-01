package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopDisbandActivity$3
  implements View.OnClickListener
{
  TroopDisbandActivity$3(TroopDisbandActivity paramTroopDisbandActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.3
 * JD-Core Version:    0.7.0.1
 */