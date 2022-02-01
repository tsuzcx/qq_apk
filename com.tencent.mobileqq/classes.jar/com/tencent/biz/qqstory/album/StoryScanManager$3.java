package com.tencent.biz.qqstory.album;

import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import java.util.Comparator;

final class StoryScanManager$3
  implements Comparator<StoryAlbum.PicInfo>
{
  public int a(StoryAlbum.PicInfo paramPicInfo1, StoryAlbum.PicInfo paramPicInfo2)
  {
    if ((paramPicInfo1 != paramPicInfo2) && (paramPicInfo1.g != paramPicInfo2.g))
    {
      if (paramPicInfo1.g < paramPicInfo2.g) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryScanManager.3
 * JD-Core Version:    0.7.0.1
 */