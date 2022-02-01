package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Comparator;

class MyVideoSharePlayingListSync$1
  implements Comparator<StoryVideoItem>
{
  MyVideoSharePlayingListSync$1(MyVideoSharePlayingListSync paramMyVideoSharePlayingListSync) {}
  
  public int a(StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    if (paramStoryVideoItem1.mCreateTime > paramStoryVideoItem2.mCreateTime) {
      return 1;
    }
    if (paramStoryVideoItem1.mCreateTime < paramStoryVideoItem2.mCreateTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MyVideoSharePlayingListSync.1
 * JD-Core Version:    0.7.0.1
 */