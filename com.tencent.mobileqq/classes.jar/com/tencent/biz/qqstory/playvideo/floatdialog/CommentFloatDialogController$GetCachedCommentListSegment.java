package com.tencent.biz.qqstory.playvideo.floatdialog;

import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class CommentFloatDialogController$GetCachedCommentListSegment
  extends JobSegment<DetailFeedItem, DetailFeedItem>
{
  public CommentFloatDialogController$GetCachedCommentListSegment(CommentFloatDialogController paramCommentFloatDialogController) {}
  
  protected void a(JobContext paramJobContext, DetailFeedItem paramDetailFeedItem)
  {
    paramDetailFeedItem.a(CommentFloatDialogController.e(this.a).a(paramDetailFeedItem.a.feedId, true), true, true);
    if (paramDetailFeedItem.b()) {
      paramDetailFeedItem.a(CommentFloatDialogController.e(this.a).a(CommentFloatDialogController.d(this.a), false), true, false);
    }
    SLog.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", CommentFloatDialogController.a(this.a).toString());
    notifyResult(paramDetailFeedItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.GetCachedCommentListSegment
 * JD-Core Version:    0.7.0.1
 */