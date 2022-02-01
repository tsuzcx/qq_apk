package com.tencent.biz.qqstory.album.strategy;

import com.tencent.biz.qqstory.album.model.StoryAlbum;
import java.util.Comparator;

class KMeansSplitStrategy$2
  implements Comparator<StoryAlbum>
{
  KMeansSplitStrategy$2(KMeansSplitStrategy paramKMeansSplitStrategy) {}
  
  public int a(StoryAlbum paramStoryAlbum1, StoryAlbum paramStoryAlbum2)
  {
    if (paramStoryAlbum1.f() == paramStoryAlbum2.f()) {
      return 0;
    }
    if (paramStoryAlbum1.f() > paramStoryAlbum2.f()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.KMeansSplitStrategy.2
 * JD-Core Version:    0.7.0.1
 */