package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQStoryItemBuilder$1
  implements View.OnClickListener
{
  QQStoryItemBuilder$1(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void onClick(View paramView)
  {
    QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = (QQStoryItemBuilder.QQStoryMsgHolder)AIOUtils.b(paramView);
    if (paramView == localQQStoryMsgHolder.u) {
      this.a.b(localQQStoryMsgHolder);
    } else if (paramView == localQQStoryMsgHolder.y) {
      this.a.a(localQQStoryMsgHolder);
    }
    ReportController.b(this.a.d, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "5", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */