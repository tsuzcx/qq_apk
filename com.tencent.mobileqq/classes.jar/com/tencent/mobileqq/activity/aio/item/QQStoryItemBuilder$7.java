package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$7
  implements Runnable
{
  QQStoryItemBuilder$7(QQStoryItemBuilder paramQQStoryItemBuilder, String paramString, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, StoryVideoItem paramStoryVideoItem, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQStoryItemBuilder handleGetVideo 3: fileName = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("QQStoryItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    ((QQStoryItemBuilder.QQStoryMsgHolder)localObject).C = true;
    ((QQStoryItemBuilder.QQStoryMsgHolder)localObject).x.b();
    this.b.x.setVisibility(8);
    PlayModeUtils.a(this.b.d, this.c.mLocalMaskPath, this.c.mOriginalMaskPicUrl, false, this.this$0.z, this.this$0.A);
    this.this$0.a(this.b, this.d, this.c.mVideoWidth, this.c.mVideoHeight, this.c.mVideoThumbnailUrl, this.a);
    this.this$0.b(this.b, this.d, this.c, this.e);
    this.this$0.c(this.b, this.d, this.c, this.e);
    QQStoryItemBuilder.a(this.this$0, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */