package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;

class QQStoryItemBuilder$6
  implements Runnable
{
  QQStoryItemBuilder$6(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    Long localLong = (Long)this.a.c.getTag();
    if (localLong != null)
    {
      if (localLong.longValue() != this.b) {
        return;
      }
      this.a.x.setDrawStatus(2);
      this.a.x.setVisibility(0);
      QQStoryItemBuilder.a(this.a.c, this.c.mVideoThumbnailUrl, this.this$0.z, this.this$0.A, this.this$0.x);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */