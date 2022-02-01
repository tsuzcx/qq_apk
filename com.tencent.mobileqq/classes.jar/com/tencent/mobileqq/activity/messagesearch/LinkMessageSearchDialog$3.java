package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LinkMessageSearchDialog$3
  implements View.OnClickListener
{
  LinkMessageSearchDialog$3(LinkMessageSearchDialog paramLinkMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    LinkMessageSearchDialog localLinkMessageSearchDialog = this.a;
    localLinkMessageSearchDialog.l = null;
    localLinkMessageSearchDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.LinkMessageSearchDialog.3
 * JD-Core Version:    0.7.0.1
 */