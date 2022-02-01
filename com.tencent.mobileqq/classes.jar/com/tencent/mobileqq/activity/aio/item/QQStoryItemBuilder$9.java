package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.VideoInfoObserver;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$9
  extends PlayModeUtils.VideoInfoObserver
{
  QQStoryItemBuilder$9(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("QQStoryItemBuilder requestVideoInfo: errorCode = ");
      paramString.append(paramInt);
      paramString.append(", storyVideoItem = ");
      paramString.append(paramStoryVideoItem);
      QLog.d("Q.qqstory.share", 2, paramString.toString());
    }
    if ((paramInt == 0) && (paramStoryVideoItem != null))
    {
      this.g.a(this.d, this.e, paramStoryVideoItem, this.f);
      return;
    }
    if (paramInt == 10100)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQStoryItemBuilder", 2, "onGetVideo video has deleted");
      }
      this.g.a(this.d, this.e);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QQStoryItemBuilder", 2, "onGetVideo video error");
    }
    this.g.a(this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */