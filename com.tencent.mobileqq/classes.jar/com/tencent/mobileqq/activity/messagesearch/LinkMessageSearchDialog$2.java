package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LinkMessageSearchDialog$2
  implements View.OnClickListener
{
  LinkMessageSearchDialog$2(LinkMessageSearchDialog paramLinkMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.d.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.LinkMessageSearchDialog.2
 * JD-Core Version:    0.7.0.1
 */