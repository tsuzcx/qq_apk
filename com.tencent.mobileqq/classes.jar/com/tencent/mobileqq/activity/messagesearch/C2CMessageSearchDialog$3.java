package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class C2CMessageSearchDialog$3
  implements View.OnClickListener
{
  C2CMessageSearchDialog$3(C2CMessageSearchDialog paramC2CMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    C2CMessageSearchDialog localC2CMessageSearchDialog = this.a;
    localC2CMessageSearchDialog.l = null;
    localC2CMessageSearchDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog.3
 * JD-Core Version:    0.7.0.1
 */