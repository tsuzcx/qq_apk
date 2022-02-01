package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import bezb;
import java.net.URL;

public class AppVideoDecoder
  implements bezb
{
  Context mContext;
  LocalMediaInfo mLocalMediaInfo;
  
  public AppVideoDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.mContext = paramContext;
    this.mLocalMediaInfo = paramLocalMediaInfo;
  }
  
  public Bitmap getBitmap(URL paramURL)
  {
    return ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(this.mLocalMediaInfo.path, 3), this.mLocalMediaInfo.thumbWidth, this.mLocalMediaInfo.thumbHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AppVideoDecoder
 * JD-Core Version:    0.7.0.1
 */