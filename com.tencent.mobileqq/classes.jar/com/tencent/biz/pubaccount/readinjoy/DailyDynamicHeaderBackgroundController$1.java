package com.tencent.biz.pubaccount.readinjoy;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.StackBlur;

final class DailyDynamicHeaderBackgroundController$1
  extends URLDrawableDecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    paramDownloadParams = paramBitmap.copy(paramBitmap.getConfig(), true);
    StackBlur.a(paramDownloadParams, 40);
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderBackgroundController.1
 * JD-Core Version:    0.7.0.1
 */