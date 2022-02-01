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
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new DetailFeedAllInfoPullSegment.RequestViewCountSegment(this), paramString);
    FeedCommentSync localFeedCommentSync1;
    FeedCommentSync localFeedCommentSync2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a())
    {
      localFeedCommentSync1 = new FeedCommentSync(paramString, 2, "", 0);
      localFeedCommentSync2 = new FeedCommentSync(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new DetailFeedAllInfoPullSegment.RequestLikeListSegment(this, 0), paramString).map(new DetailFeedAllInfoPullSegment.RequestLikeListSegment(this, 1), paramString).map(new DetailFeedAllInfoPullSegment.RequestCommentListSegment(this), localFeedCommentSync1).map(new DetailFeedAllInfoPullSegment.RequestCommentListSegment(this), localFeedCommentSync2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new DetailFeedAllInfoPullSegment.RequestLikeListSegment(this, -1), paramString).map(new DetailFeedAllInfoPullSegment.RequestCommentListSegment(this), localFeedCommentSync1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new DetailFeedAllInfoPullSegment.Observer(this));
      return;
      localFeedCommentSync1 = new FeedCommentSync(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, DetailFeedItem paramDetailFeedItem)
  {
    if ((paramDetailFeedItem == null) || (paramDetailFeedItem.a == null) || (TextUtils.isEmpty(paramDetailFeedItem.a.feedId)))
    {
      SLog.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
    a(paramDetailFeedItem.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment
 * JD-Core Version:    0.7.0.1
 */