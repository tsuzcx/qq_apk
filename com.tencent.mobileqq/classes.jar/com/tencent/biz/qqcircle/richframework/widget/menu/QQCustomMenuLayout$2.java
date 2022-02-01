package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomMenuLayout$2
  implements View.OnClickListener
{
  QQCustomMenuLayout$2(QQCustomMenuLayout paramQQCustomMenuLayout) {}
  
  public void onClick(View paramView)
  {
    QQCustomMenuLayout.a(this.a).c();
    QQCustomMenuLayout.b(this.a).onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuLayout.2
 * JD-Core Version:    0.7.0.1
 */