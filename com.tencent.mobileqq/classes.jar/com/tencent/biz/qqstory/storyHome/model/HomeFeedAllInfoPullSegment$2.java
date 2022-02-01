package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.BatchGetFeedCommentResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.FeedCommentInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class HomeFeedAllInfoPullSegment$2
  implements CmdTaskManger.CommandCallback<BatchGetFeedCommentRequest, BatchGetFeedCommentRequest.BatchGetFeedCommentResp>
{
  HomeFeedAllInfoPullSegment$2(HomeFeedAllInfoPullSegment paramHomeFeedAllInfoPullSegment, JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult) {}
  
  public void a(@NonNull BatchGetFeedCommentRequest paramBatchGetFeedCommentRequest, @Nullable BatchGetFeedCommentRequest.BatchGetFeedCommentResp arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new BatchGetFeedCommentRequest.BatchGetFeedCommentResp(paramErrorMessage);
    }
    else
    {
      if (paramErrorMessage.isFail()) {
        SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
      }
      CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
      Iterator localIterator = ???.a.iterator();
      for (;;)
      {
        paramErrorMessage = ???;
        if (!localIterator.hasNext()) {
          break;
        }
        paramErrorMessage = (BatchGetFeedCommentRequest.FeedCommentInfo)localIterator.next();
        localCommentManager.a(paramErrorMessage.e, paramErrorMessage.a, false, true);
        if (paramErrorMessage.c == 1) {
          paramErrorMessage.e.addAll(localCommentManager.b(paramErrorMessage.a, false));
        }
      }
    }
    synchronized (this.c)
    {
      HomeFeedAllInfoPullSegment.a(this.c, paramErrorMessage);
      HomeFeedAllInfoPullSegment.a(this.c).remove(paramBatchGetFeedCommentRequest);
      HomeFeedAllInfoPullSegment.a(this.c, this.b);
      return;
    }
    for (;;)
    {
      throw paramBatchGetFeedCommentRequest;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedAllInfoPullSegment.2
 * JD-Core Version:    0.7.0.1
 */