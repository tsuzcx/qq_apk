package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class C2CLinkMessageSearchDialog$3
  implements View.OnClickListener
{
  C2CLinkMessageSearchDialog$3(C2CLinkMessageSearchDialog paramC2CLinkMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    C2CLinkMessageSearchDialog localC2CLinkMessageSearchDialog = this.a;
    localC2CLinkMessageSearchDialog.a = null;
    localC2CLinkMessageSearchDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog.3
 * JD-Core Version:    0.7.0.1
 */