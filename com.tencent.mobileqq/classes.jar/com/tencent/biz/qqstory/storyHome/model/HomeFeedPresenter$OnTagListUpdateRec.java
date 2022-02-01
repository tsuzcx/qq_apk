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
    Object localObject1 = HomeFeedPresenter.b(paramHomeFeedPresenter);
    paramFeedTagListUpdateEvent = paramFeedTagListUpdateEvent.a;
    TagManager localTagManager = (TagManager)SuperManager.a(27);
    localObject1 = ((ArrayList)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (StoryHomeFeed)((Iterator)localObject1).next();
      if ((localObject2 instanceof VideoListHomeFeed))
      {
        GetFeedTagInfoListRequest.FeedTagInfoList localFeedTagInfoList = (GetFeedTagInfoListRequest.FeedTagInfoList)paramFeedTagListUpdateEvent.get(((StoryHomeFeed)localObject2).g().feedId);
        if (localFeedTagInfoList != null)
        {
          localObject2 = (VideoListHomeFeed)localObject2;
          ((VideoListHomeFeed)localObject2).j = localTagManager.a(((VideoListHomeFeed)localObject2).a(), localFeedTagInfoList.b);
          i = 1;
        }
      }
    }
    if (i != 0) {
      HomeFeedPresenter.c(paramHomeFeedPresenter).j();
    }
  }
  
  public Class acceptEventClass()
  {
    return TagManager.FeedTagListUpdateEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull TagManager.FeedTagListUpdateEvent paramFeedTagListUpdateEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.OnTagListUpdateRec
 * JD-Core Version:    0.7.0.1
 */