package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.model.TagManager.FeedTagListUpdateEvent;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest.FeedTagInfoList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class HomeFeedPresenter$OnTagListUpdateRec
  extends UIBaseEventReceiver<HomeFeedPresenter, TagManager.FeedTagListUpdateEvent>
{
  public HomeFeedPresenter$OnTagListUpdateRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull TagManager.FeedTagListUpdateEvent paramFeedTagListUpdateEvent)
  {
    Object localObject = HomeFeedPresenter.a(paramHomeFeedPresenter);
    paramFeedTagListUpdateEvent = paramFeedTagListUpdateEvent.a;
    TagManager localTagManager = (TagManager)SuperManager.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)((Iterator)localObject).next();
      if ((localStoryHomeFeed instanceof VideoListHomeFeed))
      {
        GetFeedTagInfoListRequest.FeedTagInfoList localFeedTagInfoList = (GetFeedTagInfoListRequest.FeedTagInfoList)paramFeedTagListUpdateEvent.get(localStoryHomeFeed.a().feedId);
        if (localFeedTagInfoList == null) {
          break label129;
        }
        ((VideoListHomeFeed)localStoryHomeFeed).d = localTagManager.a(((VideoListHomeFeed)localStoryHomeFeed).a(), localFeedTagInfoList.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        HomeFeedPresenter.a(paramHomeFeedPresenter).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return TagManager.FeedTagListUpdateEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull TagManager.FeedTagListUpdateEvent paramFeedTagListUpdateEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.OnTagListUpdateRec
 * JD-Core Version:    0.7.0.1
 */