package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.CommentListener;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

class FeedCommentBackgroundSyncer$SyncAllCommentFragment$1
  implements CommentListPageLoader.CommentListener
{
  FeedCommentBackgroundSyncer$SyncAllCommentFragment$1(FeedCommentBackgroundSyncer.SyncAllCommentFragment paramSyncAllCommentFragment, JobContext paramJobContext, FeedCommentSync paramFeedCommentSync) {}
  
  public void a(CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.b });
      return;
    }
    FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.c);
    SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(FeedCommentBackgroundSyncer.SyncAllCommentFragment.b(this.c)), paramGetFeedCommentEvent);
    if (paramGetFeedCommentEvent.g.isSuccess())
    {
      FeedCommentBackgroundSyncer.SyncAllCommentFragment.c(this.c).addAll(paramGetFeedCommentEvent.k);
      if ((!paramGetFeedCommentEvent.a) && (FeedCommentBackgroundSyncer.SyncAllCommentFragment.b(this.c) < 10))
      {
        SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(FeedCommentBackgroundSyncer.SyncAllCommentFragment.b(this.c)));
        FeedCommentBackgroundSyncer.SyncAllCommentFragment.d(this.c).c();
        return;
      }
      paramGetFeedCommentEvent.k = FeedCommentBackgroundSyncer.SyncAllCommentFragment.c(this.c);
      SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(FeedCommentBackgroundSyncer.SyncAllCommentFragment.c(this.c).size()));
      FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.c, paramGetFeedCommentEvent);
      return;
    }
    paramGetFeedCommentEvent.k = FeedCommentBackgroundSyncer.SyncAllCommentFragment.c(this.c);
    SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(FeedCommentBackgroundSyncer.SyncAllCommentFragment.c(this.c).size()));
    FeedCommentBackgroundSyncer.SyncAllCommentFragment.b(this.c, paramGetFeedCommentEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.SyncAllCommentFragment.1
 * JD-Core Version:    0.7.0.1
 */