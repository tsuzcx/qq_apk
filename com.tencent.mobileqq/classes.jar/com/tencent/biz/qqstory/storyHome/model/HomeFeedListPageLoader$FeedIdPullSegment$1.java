package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest.GetStoryFeedIdListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class HomeFeedListPageLoader$FeedIdPullSegment$1
  implements CmdTaskManger.CommandCallback<GetStoryFeedIdListRequest, GetStoryFeedIdListRequest.GetStoryFeedIdListResponse>
{
  HomeFeedListPageLoader$FeedIdPullSegment$1(HomeFeedListPageLoader.FeedIdPullSegment paramFeedIdPullSegment, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull GetStoryFeedIdListRequest paramGetStoryFeedIdListRequest, @Nullable GetStoryFeedIdListRequest.GetStoryFeedIdListResponse paramGetStoryFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((!paramErrorMessage.isFail()) && (paramGetStoryFeedIdListResponse != null))
    {
      HomeFeedListPageLoader.FeedIdPullSegment.a(this.d);
      HomeFeedListPageLoader.FeedIdPullSegment.b(this.d).a(paramGetStoryFeedIdListResponse.e, paramGetStoryFeedIdListResponse.b, paramGetStoryFeedIdListResponse.a);
      ((FeedManager)SuperManager.a(11)).c(paramGetStoryFeedIdListResponse.e);
      boolean bool = HomeFeedListPageLoader.FeedIdPullSegment.a(paramGetStoryFeedIdListResponse, this.b);
      SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramGetStoryFeedIdListResponse.f), Integer.valueOf(HomeFeedListPageLoader.FeedIdPullSegment.c(this.d)), Boolean.valueOf(bool) });
      if ((!paramGetStoryFeedIdListResponse.a) && (HomeFeedListPageLoader.FeedIdPullSegment.c(this.d) < 10) && ((!paramGetStoryFeedIdListResponse.f) || (bool)))
      {
        SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
        paramGetStoryFeedIdListRequest.f = HomeFeedListPageLoader.FeedIdPullSegment.b(this.d).c();
        CmdTaskManger.a().a(paramGetStoryFeedIdListRequest, this);
        return;
      }
      if (this.b.getAndSet(false)) {
        HomeFeedListPageLoader.FeedIdPullSegment.b(this.d).d();
      }
      paramGetStoryFeedIdListRequest = HomeFeedListPageLoader.FeedIdPullSegment.b(this.d).a(this.c.intValue(), 5);
      HomeFeedListPageLoader.FeedIdPullSegment.a(this.d, paramGetStoryFeedIdListRequest);
      return;
    }
    SLog.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
    HomeFeedListPageLoader.FeedIdPullSegment.a(this.d, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedListPageLoader.FeedIdPullSegment.1
 * JD-Core Version:    0.7.0.1
 */