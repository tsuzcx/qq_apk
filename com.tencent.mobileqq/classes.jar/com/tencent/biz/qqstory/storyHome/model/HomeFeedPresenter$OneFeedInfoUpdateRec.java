package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.support.logging.SLog;

public class HomeFeedPresenter$OneFeedInfoUpdateRec
  extends UIBaseEventReceiver
{
  public HomeFeedPresenter$OneFeedInfoUpdateRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull OneFeedNodeInfoPullHandler.SingleFeedInfoEvent paramSingleFeedInfoEvent)
  {
    Object localObject = paramSingleFeedInfoEvent.a;
    paramSingleFeedInfoEvent = paramHomeFeedPresenter.a(((StoryHomeFeed)localObject).a.feedId);
    if (paramSingleFeedInfoEvent == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((StoryHomeFeed)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof VideoListHomeFeed)) || (!(paramSingleFeedInfoEvent instanceof VideoListHomeFeed)))
    {
      SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (VideoListHomeFeed)localObject;
    paramSingleFeedInfoEvent = (VideoListHomeFeed)paramSingleFeedInfoEvent;
    paramSingleFeedInfoEvent.a = ((VideoListHomeFeed)localObject).a;
    paramSingleFeedInfoEvent.a(((VideoListHomeFeed)localObject).b(), false);
    paramSingleFeedInfoEvent.b(((VideoListHomeFeed)localObject).c(), false);
    paramSingleFeedInfoEvent.c(((VideoListHomeFeed)localObject).a(), false);
    HomeFeedPresenter.a(paramHomeFeedPresenter).b(paramSingleFeedInfoEvent.a.feedId);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramSingleFeedInfoEvent);
  }
  
  public Class acceptEventClass()
  {
    return OneFeedNodeInfoPullHandler.SingleFeedInfoEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull OneFeedNodeInfoPullHandler.SingleFeedInfoEvent paramSingleFeedInfoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.OneFeedInfoUpdateRec
 * JD-Core Version:    0.7.0.1
 */