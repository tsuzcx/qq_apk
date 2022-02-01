package com.tencent.biz.qqstory.album.model;

import java.util.Comparator;

final class StoryAlbum$1
  implements Comparator<StoryAlbum.PicInfo>
{
  public int a(StoryAlbum.PicInfo paramPicInfo1, StoryAlbum.PicInfo paramPicInfo2)
  {
    if ((paramPicInfo1 != paramPicInfo2) && (paramPicInfo1.b != paramPicInfo2.b))
    {
      if (paramPicInfo1.b < paramPicInfo2.b) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.StoryAlbum.1
 * JD-Core Version:    0.7.0.1
 */