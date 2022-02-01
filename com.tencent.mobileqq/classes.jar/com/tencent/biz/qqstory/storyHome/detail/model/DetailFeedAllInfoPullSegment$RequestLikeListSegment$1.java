package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class DetailFeedAllInfoPullSegment$RequestLikeListSegment$1
  implements CmdTaskManger.CommandCallback<DetailLikeListLoader.GetLikeListRequest, DetailLikeListLoader.GetLikeListResponse>
{
  DetailFeedAllInfoPullSegment$RequestLikeListSegment$1(DetailFeedAllInfoPullSegment.RequestLikeListSegment paramRequestLikeListSegment, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull DetailLikeListLoader.GetLikeListRequest paramGetLikeListRequest, @Nullable DetailLikeListLoader.GetLikeListResponse paramGetLikeListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramGetLikeListResponse != null) && (!paramErrorMessage.isFail()))
    {
      boolean bool;
      if (this.c.a == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((LikeManager)SuperManager.a(15)).a(paramGetLikeListResponse.e, this.b, bool, true);
      paramGetLikeListRequest = new DetailFeedAllInfoPullSegment.LikeData(bool, paramGetLikeListResponse.e, paramGetLikeListResponse.a, paramGetLikeListResponse.b);
      try
      {
        DetailFeedAllInfoPullSegment.RequestLikeListSegment.a(this.c, paramGetLikeListRequest);
        return;
      }
      catch (NullPointerException paramGetLikeListRequest)
      {
        SLog.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramGetLikeListRequest);
        DetailFeedAllInfoPullSegment.RequestLikeListSegment.b(this.c, new ErrorMessage());
        return;
      }
    }
    SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
    DetailFeedAllInfoPullSegment.RequestLikeListSegment.a(this.c, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.RequestLikeListSegment.1
 * JD-Core Version:    0.7.0.1
 */