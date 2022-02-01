package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Video.Thumbnails;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class VideoDecoder
  implements BitmapDecoder
{
  Context mContext;
  LocalMediaInfo mLocalMediaInfo;
  
  public VideoDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.mContext = paramContext;
    this.mLocalMediaInfo = paramLocalMediaInfo;
  }
  
  public Bitmap getBitmap(URL paramURL)
  {
    paramURL = this.mContext.getContentResolver();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    return ThumbnailUtils.extractThumbnail(MediaStore.Video.Thumbnails.getThumbnail(paramURL, this.mLocalMediaInfo._id, 1, localOptions), this.mLocalMediaInfo.thumbWidth, this.mLocalMediaInfo.thumbHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */