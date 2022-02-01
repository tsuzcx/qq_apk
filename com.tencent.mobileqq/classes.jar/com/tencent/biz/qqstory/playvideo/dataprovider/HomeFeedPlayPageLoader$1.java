package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest.GetStoryFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedListPageLoader.FeedIdPullSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

class HomeFeedPlayPageLoader$1
  implements CmdTaskManger.CommandCallback<GetStoryFeedIdListRequest, GetStoryFeedIdListRequest.GetStoryFeedIdListResponse>
{
  HomeFeedPlayPageLoader$1(HomeFeedPlayPageLoader paramHomeFeedPlayPageLoader, IGroupPageLoader.CallBack paramCallBack) {}
  
  public void a(@NonNull GetStoryFeedIdListRequest paramGetStoryFeedIdListRequest, @Nullable GetStoryFeedIdListRequest.GetStoryFeedIdListResponse paramGetStoryFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((!paramErrorMessage.isFail()) && (paramGetStoryFeedIdListResponse != null))
    {
      HomeFeedPlayPageLoader.a(this.b);
      this.b.c.a(paramGetStoryFeedIdListResponse.e, paramGetStoryFeedIdListResponse.b, paramGetStoryFeedIdListResponse.a);
      ((FeedManager)SuperManager.a(11)).c(paramGetStoryFeedIdListResponse.e);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      boolean bool = HomeFeedListPageLoader.FeedIdPullSegment.a(paramGetStoryFeedIdListResponse, localAtomicBoolean);
      SLog.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramGetStoryFeedIdListResponse.f), Integer.valueOf(HomeFeedPlayPageLoader.b(this.b)), Boolean.valueOf(bool) });
      if ((!paramGetStoryFeedIdListResponse.a) && (HomeFeedPlayPageLoader.b(this.b) < 10) && ((!paramGetStoryFeedIdListResponse.f) || (bool)))
      {
        SLog.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
        paramGetStoryFeedIdListRequest.f = this.b.c.c();
        CmdTaskManger.a().a(paramGetStoryFeedIdListRequest, this);
        return;
      }
      if (localAtomicBoolean.getAndSet(false)) {
        this.b.c.d();
      }
      this.a.a(paramErrorMessage, FeedIdBasePlayPageLoader.b(paramGetStoryFeedIdListResponse.e), paramGetStoryFeedIdListResponse.a);
      return;
    }
    SLog.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
    this.a.a(paramErrorMessage, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.HomeFeedPlayPageLoader.1
 * JD-Core Version:    0.7.0.1
 */