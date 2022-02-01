package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;

class QQStoryItemBuilder$5
  implements Runnable
{
  QQStoryItemBuilder$5(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder) {}
  
  public void run()
  {
    QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = this.a;
    localQQStoryMsgHolder.C = true;
    localQQStoryMsgHolder.x.setDrawStatus(1);
    this.a.x.setVisibility(0);
    this.a.x.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */