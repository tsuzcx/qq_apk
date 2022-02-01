package com.tencent.mobileqq.activity.aio.photo;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.downloader.GalleryDecoder;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.HashMap;

public class PhotoDecoder
  extends GalleryDecoder
{
  private BaseApplicationImpl mApp;
  
  public PhotoDecoder(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(BaseApplicationImpl.getContext());
    this.mApp = paramBaseApplicationImpl;
  }
  
  public Object decodeVideo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i = 0;
    if (paramDownloadParams.tag != null) {
      i = ((Integer)paramDownloadParams.tag).intValue();
    }
    if (i == 3)
    {
      paramURLDrawableHandler = ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
      int j = paramURLDrawableHandler.getWidth();
      i = paramURLDrawableHandler.getHeight();
      float f = Gallery.a(j, i, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, null);
      j = (int)(j * f);
      i = (int)(i * f);
      return ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
    }
    return null;
  }
  
  public String getLogTag()
  {
    return "PEAK";
  }
  
  public void reportSafeDecode(SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption)
  {
    if ((!paramSafeDecodeOption.isInJustDecodeBounds) && (paramSafeDecodeOption.needRegionDecode))
    {
      HashMap localHashMap = paramSafeDecodeOption.getInfo();
      localHashMap.put("from", "GalleryDecoder");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "safeDecode", paramSafeDecodeOption.isGetBitmap, paramSafeDecodeOption.runTime, paramSafeDecodeOption.rawHeight * paramSafeDecodeOption.rawWidth, localHashMap, "");
    }
  }
  
  public RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      RoundRectBitmap localRoundRectBitmap = new RoundRectBitmap(paramBitmap, paramInt);
      return localRoundRectBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return new RoundRectBitmap(paramBitmap, 12.0F);
  }
  
  public boolean useJpegTurbo()
  {
    return Utils.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoDecoder
 * JD-Core Version:    0.7.0.1
 */