package com.tencent.biz.qqstory.storyHome.model;

import java.util.Comparator;

class VideoListHomeFeed$HomeComp
  implements Comparator<StoryHomeFeed>
{
  public int a(StoryHomeFeed paramStoryHomeFeed1, StoryHomeFeed paramStoryHomeFeed2)
  {
    int i;
    if (((paramStoryHomeFeed1 instanceof HotRecommendHomeFeed)) && (((HotRecommendFeedItem)((HotRecommendHomeFeed)paramStoryHomeFeed1).a()).mIsTopLocation)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((paramStoryHomeFeed2 instanceof HotRecommendHomeFeed)) && (((HotRecommendFeedItem)((HotRecommendHomeFeed)paramStoryHomeFeed2).a()).mIsTopLocation)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j ^ i) != 0)
    {
      if (i != 0) {
        return -1;
      }
      return 1;
    }
    if (paramStoryHomeFeed1.a.dateTimeMillis == paramStoryHomeFeed2.a.dateTimeMillis)
    {
      if (((paramStoryHomeFeed1 instanceof VideoListHomeFeed)) && (VideoListHomeFeed.a((VideoListHomeFeed)paramStoryHomeFeed1))) {
        return -1;
      }
      if (((paramStoryHomeFeed2 instanceof VideoListHomeFeed)) && (VideoListHomeFeed.a((VideoListHomeFeed)paramStoryHomeFeed2))) {
        return 1;
      }
      return 0;
    }
    if (paramStoryHomeFeed1.a.dateTimeMillis > paramStoryHomeFeed2.a.dateTimeMillis) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed.HomeComp
 * JD-Core Version:    0.7.0.1
 */