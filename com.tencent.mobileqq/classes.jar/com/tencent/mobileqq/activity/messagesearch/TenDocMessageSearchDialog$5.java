package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TenDocMessageSearchDialog$5
  implements View.OnClickListener
{
  TenDocMessageSearchDialog$5(TenDocMessageSearchDialog paramTenDocMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    TenDocMessageSearchDialog.a(this.a, paramView);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TenDocMessageSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */