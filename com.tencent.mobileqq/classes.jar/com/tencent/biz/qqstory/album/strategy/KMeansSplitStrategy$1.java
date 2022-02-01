package com.tencent.biz.qqstory.album.strategy;

import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import java.util.Comparator;

class KMeansSplitStrategy$1
  implements Comparator<StoryAlbum.PicInfo>
{
  KMeansSplitStrategy$1(KMeansSplitStrategy paramKMeansSplitStrategy) {}
  
  public int a(StoryAlbum.PicInfo paramPicInfo1, StoryAlbum.PicInfo paramPicInfo2)
  {
    if (paramPicInfo1.b == paramPicInfo2.b) {
      return 0;
    }
    if (paramPicInfo1.b > paramPicInfo2.b) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.KMeansSplitStrategy.1
 * JD-Core Version:    0.7.0.1
 */