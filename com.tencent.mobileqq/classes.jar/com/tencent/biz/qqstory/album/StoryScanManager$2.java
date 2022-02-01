package com.tencent.biz.qqstory.album;

import com.tencent.biz.qqstory.album.model.StoryAlbum;
import java.util.Comparator;

final class StoryScanManager$2
  implements Comparator<StoryAlbum>
{
  public int a(StoryAlbum paramStoryAlbum1, StoryAlbum paramStoryAlbum2)
  {
    if (paramStoryAlbum1.a() > paramStoryAlbum2.a()) {
      return 1;
    }
    if (paramStoryAlbum1.a() < paramStoryAlbum2.a()) {
      return -1;
    }
    if (paramStoryAlbum1.c() == paramStoryAlbum2.c()) {
      return 0;
    }
    if (paramStoryAlbum1.c() < paramStoryAlbum2.c()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryScanManager.2
 * JD-Core Version:    0.7.0.1
 */