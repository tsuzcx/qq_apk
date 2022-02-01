package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.model.SuperManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class HomeFeedPresenter$3
  implements Runnable
{
  HomeFeedPresenter$3(HomeFeedPresenter paramHomeFeedPresenter, ArrayList paramArrayList) {}
  
  public void run()
  {
    FeedVideoManager localFeedVideoManager = (FeedVideoManager)SuperManager.a(12);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (StoryHomeFeed)localIterator.next();
      if ((localObject instanceof VideoListHomeFeed))
      {
        localObject = (VideoListHomeFeed)localObject;
        FeedVideoInfo localFeedVideoInfo = ((VideoListHomeFeed)localObject).i().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((VideoListHomeFeed)localObject).a());
        localFeedVideoManager.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3
 * JD-Core Version:    0.7.0.1
 */