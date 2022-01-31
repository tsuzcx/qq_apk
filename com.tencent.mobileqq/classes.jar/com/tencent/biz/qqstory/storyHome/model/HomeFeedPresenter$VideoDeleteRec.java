package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeFeedPresenter$VideoDeleteRec
  extends UIBaseEventReceiver
{
  public HomeFeedPresenter$VideoDeleteRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramDeleteStoryVideoEvent);
    Object localObject2 = paramHomeFeedPresenter.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (StoryHomeFeed)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof VideoListHomeFeed)) {
          continue;
        }
        localObject1 = (VideoListHomeFeed)localObject1;
        Iterator localIterator = ((VideoListHomeFeed)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramDeleteStoryVideoEvent.a));
        ((VideoListHomeFeed)localObject1).a(localStoryVideoItem);
        paramDeleteStoryVideoEvent = (FeedVideoManager)SuperManager.a(12);
        localObject2 = paramDeleteStoryVideoEvent.a(((VideoListFeedItem)((VideoListHomeFeed)localObject1).a).feedId, ((VideoListFeedItem)((VideoListHomeFeed)localObject1).a).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((VideoListHomeFeed)localObject1).a());
          paramDeleteStoryVideoEvent.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((VideoListHomeFeed)localObject1).a().size() != 0) {
          break label330;
        }
        HomeFeedPresenter.a(paramHomeFeedPresenter).remove(i);
        FeedManager.b(((VideoListFeedItem)((VideoListHomeFeed)localObject1).a).feedId);
        HomeFeedPresenter.a(paramHomeFeedPresenter).b(((VideoListFeedItem)((VideoListHomeFeed)localObject1).a).feedId);
      }
      for (;;)
      {
        paramDeleteStoryVideoEvent.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramHomeFeedPresenter = (TagManager)SuperManager.a(27);
          paramDeleteStoryVideoEvent = new ArrayList();
          paramDeleteStoryVideoEvent.add(((VideoListHomeFeed)localObject1).a().feedId);
          paramHomeFeedPresenter.a(paramDeleteStoryVideoEvent);
          SLog.d(this.TAG, "delete video ,update tag list :%s", new Object[] { ((VideoListHomeFeed)localObject1).a().feedId });
        }
        return;
        label330:
        HomeFeedPresenter.a(paramHomeFeedPresenter).a((VideoListHomeFeed)localObject1);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.VideoDeleteRec
 * JD-Core Version:    0.7.0.1
 */