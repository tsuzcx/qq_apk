package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Comparator;

public class VideoListHomeFeed$StoryVideoListComp
  implements Comparator<StoryVideoItem>
{
  private boolean a;
  
  public VideoListHomeFeed$StoryVideoListComp(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int a(StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    boolean bool1 = paramStoryVideoItem1.isUploadFail();
    boolean bool2 = paramStoryVideoItem2.isUploadFail();
    int j = 1;
    int i = 1;
    if (bool1 == bool2)
    {
      if (paramStoryVideoItem1.mCreateTime == paramStoryVideoItem2.mCreateTime) {
        return 0;
      }
      if (paramStoryVideoItem1.mCreateTime > paramStoryVideoItem2.mCreateTime)
      {
        if (this.a) {
          return 1;
        }
        return -1;
      }
      if (this.a) {
        i = -1;
      }
      return i;
    }
    if (paramStoryVideoItem1.isUploadFail())
    {
      if (this.a) {
        return 1;
      }
      return -1;
    }
    if (paramStoryVideoItem2.isUploadFail())
    {
      i = j;
      if (this.a) {
        i = -1;
      }
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed.StoryVideoListComp
 * JD-Core Version:    0.7.0.1
 */