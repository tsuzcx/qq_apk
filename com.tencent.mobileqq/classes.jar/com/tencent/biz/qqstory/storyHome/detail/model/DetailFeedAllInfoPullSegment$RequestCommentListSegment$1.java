package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetFeedCommentRequest;
import com.tencent.biz.qqstory.network.request.GetFeedCommentRequest.GetFeedCommentResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

class DetailFeedAllInfoPullSegment$RequestCommentListSegment$1
  implements CmdTaskManger.CommandCallback<GetFeedCommentRequest, GetFeedCommentRequest.GetFeedCommentResponse>
{
  DetailFeedAllInfoPullSegment$RequestCommentListSegment$1(DetailFeedAllInfoPullSegment.RequestCommentListSegment paramRequestCommentListSegment, JobContext paramJobContext, FeedCommentSync paramFeedCommentSync) {}
  
  public void a(@NonNull GetFeedCommentRequest paramGetFeedCommentRequest, @Nullable GetFeedCommentRequest.GetFeedCommentResponse paramGetFeedCommentResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramGetFeedCommentResponse != null) && (!paramErrorMessage.isFail()))
    {
      boolean bool1;
      if (this.b.d == 0) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      ((CommentManager)SuperManager.a(17)).a(paramGetFeedCommentResponse.e, this.b.a, bool1, true);
      boolean bool2 = paramGetFeedCommentResponse.a;
      if ((!paramGetFeedCommentResponse.a) && (paramGetFeedCommentResponse.e.size() == 0))
      {
        SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
        bool2 = true;
      }
      paramGetFeedCommentRequest = new DetailFeedAllInfoPullSegment.CommentData(bool1, paramGetFeedCommentResponse.e, paramGetFeedCommentResponse.f, bool2, paramGetFeedCommentResponse.b);
      DetailFeedAllInfoPullSegment.RequestCommentListSegment.a(this.c, paramGetFeedCommentRequest);
      return;
    }
    SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
    DetailFeedAllInfoPullSegment.RequestCommentListSegment.a(this.c, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.RequestCommentListSegment.1
 * JD-Core Version:    0.7.0.1
 */