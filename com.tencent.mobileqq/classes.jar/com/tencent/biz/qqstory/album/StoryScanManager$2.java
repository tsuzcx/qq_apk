package com.tencent.biz.qqstory.album;

import com.tencent.biz.qqstory.album.model.StoryAlbum;
import java.util.Comparator;

final class StoryScanManager$2
  implements Comparator<StoryAlbum>
{
  public int a(StoryAlbum paramStoryAlbum1, StoryAlbum paramStoryAlbum2)
  {
    if (paramStoryAlbum1.a() > paramStoryAlbum2.a()) {}
    do
    {
      return 1;
      if (paramStoryAlbum1.a() < paramStoryAlbum2.a()) {
        return -1;
      }
      if (paramStoryAlbum1.d() == paramStoryAlbum2.d()) {
        return 0;
      }
    } while (paramStoryAlbum1.d() < paramStoryAlbum2.d());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryScanManager.2
 * JD-Core Version:    0.7.0.1
 */