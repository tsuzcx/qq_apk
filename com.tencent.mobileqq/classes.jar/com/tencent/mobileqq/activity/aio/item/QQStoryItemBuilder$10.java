package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$10
  implements Runnable
{
  QQStoryItemBuilder$10(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "showPlayIcon");
    }
    Object localObject = this.a;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.share", 2, "showPlayIcon: holder == null");
      }
      return;
    }
    localObject = (Long)((QQStoryItemBuilder.QQStoryMsgHolder)localObject).c.getTag();
    if (localObject != null)
    {
      if (((Long)localObject).longValue() != this.b) {
        return;
      }
      this.a.x.setDrawStatus(2);
      this.a.x.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */