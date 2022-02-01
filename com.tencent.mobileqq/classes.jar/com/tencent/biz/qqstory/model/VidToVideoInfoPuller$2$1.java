package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Comparator;

class VidToVideoInfoPuller$2$1
  implements Comparator<StoryVideoItem>
{
  VidToVideoInfoPuller$2$1(VidToVideoInfoPuller.2 param2) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller.2.1
 * JD-Core Version:    0.7.0.1
 */