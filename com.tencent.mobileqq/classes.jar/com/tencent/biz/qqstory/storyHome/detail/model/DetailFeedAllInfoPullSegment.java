package com.tencent.biz.qqstory.storyHome.detail.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class DetailFeedAllInfoPullSegment
  extends JobSegment<DetailFeedItem, DetailFeedItem>
{
  private DetailFeedItem a;
  private JobContext b;
  private ParallelStream c;
  
  private void a(String paramString)
  {
    this.c = ParallelStream.of(new DetailFeedAllInfoPullSegment.RequestViewCountSegment(this), paramString);
    FeedCommentSync localFeedCommentSync1;
    if (this.a.b())
    {
      localFeedCommentSync1 = new FeedCommentSync(paramString, 2, "", 0);
      FeedCommentSync localFeedCommentSync2 = new FeedCommentSync(paramString, 2, "", 1);
      this.c = this.c.map(new DetailFeedAllInfoPullSegment.RequestLikeListSegment(this, 0), paramString).map(new DetailFeedAllInfoPullSegment.RequestLikeListSegment(this, 1), paramString).map(new DetailFeedAllInfoPullSegment.RequestCommentListSegment(this), localFeedCommentSync1).map(new DetailFeedAllInfoPullSegment.RequestCommentListSegment(this), localFeedCommentSync2);
    }
    else
    {
      localFeedCommentSync1 = new FeedCommentSync(paramString, 2, "");
      this.c = this.c.map(new DetailFeedAllInfoPullSegment.RequestLikeListSegment(this, -1), paramString).map(new DetailFeedAllInfoPullSegment.RequestCommentListSegment(this), localFeedCommentSync1);
    }
    this.c.subscribe(new DetailFeedAllInfoPullSegment.Observer(this));
  }
  
  protected void a(JobContext paramJobContext, DetailFeedItem paramDetailFeedItem)
  {
    if ((paramDetailFeedItem != null) && (paramDetailFeedItem.a != null) && (!TextUtils.isEmpty(paramDetailFeedItem.a.feedId)))
    {
      this.b = paramJobContext;
      this.a = paramDetailFeedItem;
      a(paramDetailFeedItem.a.feedId);
      return;
    }
    SLog.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
    notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
  }
  
  protected void onCancel()
  {
    super.onCancel();
    this.c.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment
 * JD-Core Version:    0.7.0.1
 */