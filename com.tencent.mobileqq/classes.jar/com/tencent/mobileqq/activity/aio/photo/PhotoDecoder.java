package com.tencent.mobileqq.activity.aio.photo;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.downloader.GalleryDecoder;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  
  protected Object decodeVideo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i;
    if (paramDownloadParams.tag != null) {
      i = ((Integer)paramDownloadParams.tag).intValue();
    } else {
      i = 0;
    }
    if (i == 3)
    {
      paramURLDrawableHandler = ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
      Gallery.getAIOImageScale(paramURLDrawableHandler.getWidth(), paramURLDrawableHandler.getHeight(), paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
      return ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
    }
    return null;
  }
  
  protected String getLogTag()
  {
    return "PEAK";
  }
  
  protected void reportSafeDecode(SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption)
  {
    if ((!paramSafeDecodeOption.isInJustDecodeBounds) && (paramSafeDecodeOption.needRegionDecode))
    {
      HashMap localHashMap = paramSafeDecodeOption.getInfo();
      localHashMap.put("from", "GalleryDecoder");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "safeDecode", paramSafeDecodeOption.isGetBitmap, paramSafeDecodeOption.runTime, paramSafeDecodeOption.rawHeight * paramSafeDecodeOption.rawWidth, localHashMap, "");
    }
  }
  
  protected RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      RoundRectBitmap localRoundRectBitmap = new RoundRectBitmap(paramBitmap, paramInt);
      return localRoundRectBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label13:
      break label13;
    }
    return new RoundRectBitmap(paramBitmap, URLDrawableHelper.getRoundCorner());
  }
  
  protected boolean useJpegTurbo()
  {
    return ((ICompressOperator)QRoute.api(ICompressOperator.class)).decodeJpegByTrubo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoDecoder
 * JD-Core Version:    0.7.0.1
 */