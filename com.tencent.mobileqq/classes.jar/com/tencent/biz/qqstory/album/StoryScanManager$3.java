package com.tencent.biz.qqstory.album;

import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import java.util.Comparator;

final class StoryScanManager$3
  implements Comparator<StoryAlbum.PicInfo>
{
  public int a(StoryAlbum.PicInfo paramPicInfo1, StoryAlbum.PicInfo paramPicInfo2)
  {
    if ((paramPicInfo1 == paramPicInfo2) || (paramPicInfo1.b == paramPicInfo2.b)) {
      return 0;
    }
    if (paramPicInfo1.b < paramPicInfo2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryScanManager.3
 * JD-Core Version:    0.7.0.1
 */