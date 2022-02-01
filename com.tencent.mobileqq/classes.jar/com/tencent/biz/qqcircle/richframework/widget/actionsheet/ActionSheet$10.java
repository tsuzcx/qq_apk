package com.tencent.biz.qqcircle.richframework.widget.actionsheet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActionSheet$10
  implements View.OnClickListener
{
  ActionSheet$10(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (ActionSheet.k(this.a) != null) {
      ActionSheet.k(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.10
 * JD-Core Version:    0.7.0.1
 */