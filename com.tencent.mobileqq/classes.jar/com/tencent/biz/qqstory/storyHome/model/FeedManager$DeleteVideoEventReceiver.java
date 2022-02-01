package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FeedManager$DeleteVideoEventReceiver
  extends QQUIEventReceiver<FeedManager, DeleteStoryVideoEvent>
{
  public FeedManager$DeleteVideoEventReceiver(@NonNull FeedManager paramFeedManager)
  {
    super(paramFeedManager);
  }
  
  public void a(@NonNull FeedManager paramFeedManager, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    Iterator localIterator = paramFeedManager.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (StoryHomeFeed)localIterator.next();
      if ((localObject instanceof GeneralHomeFeed))
      {
        localObject = (GeneralHomeFeed)localObject;
        if (((GeneralHomeFeed)localObject).b())
        {
          localObject = ((GeneralHomeFeed)localObject).a().iterator();
          int j = i;
          for (;;)
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramDeleteStoryVideoEvent.a)) {
              j = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramFeedManager.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.DeleteVideoEventReceiver
 * JD-Core Version:    0.7.0.1
 */