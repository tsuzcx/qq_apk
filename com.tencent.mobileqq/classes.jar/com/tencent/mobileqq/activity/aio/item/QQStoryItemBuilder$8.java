package com.tencent.mobileqq.activity.aio.item;

import afyu;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import uvx;
import uwa;

class QQStoryItemBuilder$8
  implements Runnable
{
  QQStoryItemBuilder$8(QQStoryItemBuilder paramQQStoryItemBuilder, String paramString1, afyu paramafyu, long paramLong, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = ((uvx)uwa.a(5)).a(this.jdField_a_of_type_JavaLangString);
    if ((localStoryVideoItem == null) || (TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder setVideoView 1: storyVideoItem = " + localStoryVideoItem);
      }
      ((Activity)this.this$0.b).runOnUiThread(new QQStoryItemBuilder.8.1(this));
      this.this$0.a(this.jdField_a_of_type_Afyu, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder setVideoView 2: storyVideoItem = " + localStoryVideoItem);
    }
    this.this$0.a(this.jdField_a_of_type_Afyu, this.jdField_a_of_type_Long, localStoryVideoItem, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */