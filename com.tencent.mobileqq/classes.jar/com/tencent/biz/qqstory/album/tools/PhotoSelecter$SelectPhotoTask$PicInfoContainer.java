package com.tencent.biz.qqstory.album.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.support.logging.SLog;

class PhotoSelecter$SelectPhotoTask$PicInfoContainer
  implements Comparable<PicInfoContainer>
{
  StoryAlbum.PicInfo a;
  Bitmap b;
  int c;
  
  public int a(@NonNull PicInfoContainer paramPicInfoContainer)
  {
    return (int)(this.a.g - paramPicInfoContainer.a.g);
  }
  
  public Bitmap a(Context paramContext)
  {
    if (this.b == null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      try
      {
        this.b = this.a.a(paramContext, 1, localOptions);
        this.b = PhotoSimilar.a(this.b);
      }
      catch (Exception paramContext)
      {
        SLog.c(PhotoSelecter.a, "get thumbnail failed!", paramContext);
      }
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.PhotoSelecter.SelectPhotoTask.PicInfoContainer
 * JD-Core Version:    0.7.0.1
 */