package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomMenuLayout$3
  implements View.OnClickListener
{
  QQCustomMenuLayout$3(QQCustomMenuLayout paramQQCustomMenuLayout, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    QQCustomMenuLayout localQQCustomMenuLayout = this.b;
    int i;
    if (this.a) {
      i = QQCustomMenuLayout.c(localQQCustomMenuLayout);
    } else {
      i = QQCustomMenuLayout.d(localQQCustomMenuLayout);
    }
    QQCustomMenuLayout.a(localQQCustomMenuLayout, localQQCustomMenuLayout.a(i), true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuLayout.3
 * JD-Core Version:    0.7.0.1
 */