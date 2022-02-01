package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TenDocMessageSearchDialog$4
  implements View.OnClickListener
{
  TenDocMessageSearchDialog$4(TenDocMessageSearchDialog paramTenDocMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    TenDocMessageSearchDialog.f(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TenDocMessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */