package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildForwardSelectionGuildListAdapter$1
  implements View.OnClickListener
{
  QQGuildForwardSelectionGuildListAdapter$1(QQGuildForwardSelectionGuildListAdapter paramQQGuildForwardSelectionGuildListAdapter) {}
  
  public void onClick(View paramView)
  {
    QQGuildForwardSelectionGuildListAdapter.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter.1
 * JD-Core Version:    0.7.0.1
 */