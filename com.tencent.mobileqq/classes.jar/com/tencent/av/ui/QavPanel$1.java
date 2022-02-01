package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QavPanel$1
  implements View.OnClickListener
{
  QavPanel$1(QavPanel paramQavPanel) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.a != null)) {
      this.a.a.a.a(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.1
 * JD-Core Version:    0.7.0.1
 */