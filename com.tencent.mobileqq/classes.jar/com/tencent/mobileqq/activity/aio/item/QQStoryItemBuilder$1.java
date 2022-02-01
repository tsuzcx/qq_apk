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
    QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = (QQStoryItemBuilder.QQStoryMsgHolder)AIOUtils.a(paramView);
    if (paramView == localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localQQStoryMsgHolder);
    } else if (paramView == localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout) {
      this.a.a(localQQStoryMsgHolder);
    }
    ReportController.b(this.a.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "5", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */