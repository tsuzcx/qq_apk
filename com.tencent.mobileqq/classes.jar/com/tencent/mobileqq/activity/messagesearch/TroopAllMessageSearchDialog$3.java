package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAllMessageSearchDialog$3
  implements View.OnClickListener
{
  TroopAllMessageSearchDialog$3(TroopAllMessageSearchDialog paramTroopAllMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    TroopAllMessageSearchDialog localTroopAllMessageSearchDialog = this.a;
    localTroopAllMessageSearchDialog.l = null;
    localTroopAllMessageSearchDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog.3
 * JD-Core Version:    0.7.0.1
 */