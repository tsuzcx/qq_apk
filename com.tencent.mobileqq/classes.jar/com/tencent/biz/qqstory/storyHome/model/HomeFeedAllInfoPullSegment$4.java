package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class HomeFeedAllInfoPullSegment$4
  implements CmdTaskManger.CommandCallback<GetFeedFeatureRequest, GetFeedFeatureResponse>
{
  HomeFeedAllInfoPullSegment$4(HomeFeedAllInfoPullSegment paramHomeFeedAllInfoPullSegment, JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult) {}
  
  public void a(@NonNull GetFeedFeatureRequest paramGetFeedFeatureRequest, @Nullable GetFeedFeatureResponse paramGetFeedFeatureResponse, @NonNull ErrorMessage arg3)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramGetFeedFeatureResponse == null) || (???.isFail())) {
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.c)
    {
      HomeFeedAllInfoPullSegment.a(this.c, paramGetFeedFeatureResponse);
      HomeFeedAllInfoPullSegment.a(this.c).remove(paramGetFeedFeatureRequest);
      HomeFeedAllInfoPullSegment.a(this.c, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedAllInfoPullSegment.4
 * JD-Core Version:    0.7.0.1
 */