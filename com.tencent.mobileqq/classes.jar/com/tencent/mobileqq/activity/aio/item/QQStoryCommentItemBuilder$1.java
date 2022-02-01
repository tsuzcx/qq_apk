package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQStoryCommentItemBuilder$1
  implements View.OnClickListener
{
  long a = 0L;
  
  QQStoryCommentItemBuilder$1(QQStoryCommentItemBuilder paramQQStoryCommentItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a >= 50L)
    {
      this.a = l;
      MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)((BaseBubbleBuilder.ViewHolder)AIOUtils.b(paramView)).q;
      if (TroopStoryUtil.a(localMessageForQQStoryComment.vid))
      {
        StoryPlayerLauncher.a(this.b.e, localMessageForQQStoryComment.vid, "CommentItemBuilder_Feed_Id", 1004);
        StoryReportor.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      }
      else
      {
        StoryPlayerLauncher.b((Activity)this.b.e, localMessageForQQStoryComment.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */