package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$8
  implements Runnable
{
  QQStoryItemBuilder$8(QQStoryItemBuilder paramQQStoryItemBuilder, String paramString1, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.a);
    StringBuilder localStringBuilder;
    if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQStoryItemBuilder setVideoView 2: storyVideoItem = ");
        localStringBuilder.append(localStoryVideoItem);
        QLog.d("Q.qqstory.share", 2, localStringBuilder.toString());
      }
      this.this$0.a(this.b, this.c, localStoryVideoItem, this.e);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQStoryItemBuilder setVideoView 1: storyVideoItem = ");
      localStringBuilder.append(localStoryVideoItem);
      QLog.d("Q.qqstory.share", 2, localStringBuilder.toString());
    }
    ((Activity)this.this$0.a).runOnUiThread(new QQStoryItemBuilder.8.1(this));
    this.this$0.a(this.b, this.a, this.c, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */