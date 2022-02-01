package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class FeedCommentBackgroundSyncer$SyncAllCommentFragment
  extends JobSegment<FeedCommentSync, CommentListPageLoader.GetFeedCommentEvent>
{
  private int a;
  private List<CommentEntry> b = new ArrayList();
  private CommentListPageLoader c;
  
  protected void a(JobContext paramJobContext, FeedCommentSync paramFeedCommentSync)
  {
    this.c = new CommentListPageLoader(paramFeedCommentSync, new FeedCommentBackgroundSyncer.SyncAllCommentFragment.1(this, paramJobContext, paramFeedCommentSync));
    this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.SyncAllCommentFragment
 * JD-Core Version:    0.7.0.1
 */