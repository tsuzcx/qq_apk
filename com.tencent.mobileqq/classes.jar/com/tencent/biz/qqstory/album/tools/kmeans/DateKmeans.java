package com.tencent.biz.qqstory.album.tools.kmeans;

import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import java.util.List;

public class DateKmeans
  extends KmeansPlus<StoryAlbum.PicInfo>
{
  private int a = 200;
  
  protected double a()
  {
    return 0.3D;
  }
  
  protected int a()
  {
    return this.a;
  }
  
  protected long a(StoryAlbum.PicInfo paramPicInfo1, StoryAlbum.PicInfo paramPicInfo2)
  {
    if ((paramPicInfo1 != paramPicInfo2) && (paramPicInfo1.b == paramPicInfo2.b)) {
      return 1L;
    }
    return Math.abs(paramPicInfo1.b - paramPicInfo2.b);
  }
  
  protected StoryAlbum.PicInfo a(List<StoryAlbum.PicInfo> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((StoryAlbum.PicInfo)paramList.get(i)).b;
      i += 1;
    }
    StoryAlbum.PicInfo localPicInfo = new StoryAlbum.PicInfo();
    localPicInfo.b = (l / paramList.size());
    return localPicInfo;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected boolean a(long paramLong)
  {
    int i = b();
    if (i > 0) {
      if (paramLong / i >= 1500L) {}
    }
    while (paramLong < 200L)
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected boolean a(StoryAlbum.PicInfo paramPicInfo1, StoryAlbum.PicInfo paramPicInfo2)
  {
    return paramPicInfo1.b == paramPicInfo2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.kmeans.DateKmeans
 * JD-Core Version:    0.7.0.1
 */