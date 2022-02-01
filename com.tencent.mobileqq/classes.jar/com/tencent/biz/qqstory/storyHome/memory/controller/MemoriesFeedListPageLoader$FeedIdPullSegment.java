package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

class MemoriesFeedListPageLoader$FeedIdPullSegment
  extends JobSegment<Integer, FeedListPageLoaderBase.GetFeedIdListResult>
{
  private FeedListPageLoaderBase.FeedIdListCache a;
  
  public MemoriesFeedListPageLoader$FeedIdPullSegment(@NonNull FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    this.a = paramFeedIdListCache;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((FeedListPageLoaderBase.GetFeedIdListResult)localObject).a.size() <= 0) && (!((FeedListPageLoaderBase.GetFeedIdListResult)localObject).b))
    {
      localObject = new GetProfileFeedIdListRequest();
      ((GetProfileFeedIdListRequest)localObject).a = this.a.a();
      ((GetProfileFeedIdListRequest)localObject).b = QQStoryContext.a().b();
      CmdTaskManger.a().a((NetworkRequest)localObject, new MemoriesFeedListPageLoader.FeedIdPullSegment.1(this, paramJobContext, paramInteger));
      return;
    }
    SLog.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
    notifyResult(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesFeedListPageLoader.FeedIdPullSegment
 * JD-Core Version:    0.7.0.1
 */