package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.support.logging.SLog;

public class HomeFeedPresenter$OneFeedInfoUpdateRec
  extends UIBaseEventReceiver<HomeFeedPresenter, OneFeedNodeInfoPullHandler.SingleFeedInfoEvent>
{
  public HomeFeedPresenter$OneFeedInfoUpdateRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull OneFeedNodeInfoPullHandler.SingleFeedInfoEvent paramSingleFeedInfoEvent)
  {
    Object localObject = paramSingleFeedInfoEvent.a;
    paramSingleFeedInfoEvent = paramHomeFeedPresenter.a(((StoryHomeFeed)localObject).f.feedId);
    if (paramSingleFeedInfoEvent == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((StoryHomeFeed)localObject).f.feedId });
      return;
    }
    if (((localObject instanceof VideoListHomeFeed)) && ((paramSingleFeedInfoEvent instanceof VideoListHomeFeed)))
    {
      localObject = (VideoListHomeFeed)localObject;
      paramSingleFeedInfoEvent = (VideoListHomeFeed)paramSingleFeedInfoEvent;
      paramSingleFeedInfoEvent.f = ((VideoListHomeFeed)localObject).f;
      paramSingleFeedInfoEvent.a(((VideoListHomeFeed)localObject).d(), false);
      paramSingleFeedInfoEvent.b(((VideoListHomeFeed)localObject).f(), false);
      paramSingleFeedInfoEvent.c(((VideoListHomeFeed)localObject).a(), false);
      HomeFeedPresenter.c(paramHomeFeedPresenter).b(paramSingleFeedInfoEvent.f.feedId);
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramSingleFeedInfoEvent);
      return;
    }
    SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
  }
  
  public Class acceptEventClass()
  {
    return OneFeedNodeInfoPullHandler.SingleFeedInfoEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull OneFeedNodeInfoPullHandler.SingleFeedInfoEvent paramSingleFeedInfoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.OneFeedInfoUpdateRec
 * JD-Core Version:    0.7.0.1
 */