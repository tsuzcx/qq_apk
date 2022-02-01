package com.tencent.biz.qqstory.playvideo.floatdialog;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.ClickNickCallback;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.lang.ref.WeakReference;

public class PlayerCommentSegment$ClickNickCallback
  implements SpannableStringUtils.ClickNickCallback
{
  private WeakReference<PlayerCommentSegment> a;
  
  public PlayerCommentSegment$ClickNickCallback(PlayerCommentSegment paramPlayerCommentSegment)
  {
    this.a = new WeakReference(paramPlayerCommentSegment);
  }
  
  public void a(String paramString, int paramInt)
  {
    SLog.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    PlayerCommentSegment localPlayerCommentSegment = (PlayerCommentSegment)this.a.get();
    if ((localPlayerCommentSegment != null) && (paramInt != 1002))
    {
      if (paramInt == 1003) {
        return;
      }
      StoryApi.a(PlayerCommentSegment.a(localPlayerCommentSegment), 12, paramString);
      if ((localPlayerCommentSegment.a != null) && (localPlayerCommentSegment.a.a != null))
      {
        paramInt = StoryReportor.a(localPlayerCommentSegment.a.a);
        if (localPlayerCommentSegment.a.a.getOwner().isMe()) {
          paramString = "1";
        } else {
          paramString = "2";
        }
        StoryReportor.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, StoryReportor.b(4444), "", localPlayerCommentSegment.a.a.feedId });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentSegment.ClickNickCallback
 * JD-Core Version:    0.7.0.1
 */