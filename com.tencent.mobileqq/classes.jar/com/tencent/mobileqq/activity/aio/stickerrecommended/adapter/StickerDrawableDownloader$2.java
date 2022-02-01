package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

final class StickerDrawableDownloader$2
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = paramDownloadParams.tag;
    paramDownloadParams = paramBitmap;
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      paramDownloadParams = paramBitmap;
      if (localObject.length == 3)
      {
        if (localObject[0] == 0) {
          localObject[0] = paramBitmap.getWidth();
        }
        if (localObject[1] == 0) {
          localObject[1] = paramBitmap.getHeight();
        }
        paramBitmap = BaseImageUtil.c(paramBitmap, localObject[2], localObject[0], localObject[1]);
        paramDownloadParams = paramBitmap;
        if (paramBitmap == null)
        {
          paramDownloadParams = paramBitmap;
          if (QLog.isDevelopLevel())
          {
            QLog.w("StickerDrawableDownloader", 2, "ROUND_CORNER_DECODER bitmap == null");
            paramDownloadParams = paramBitmap;
          }
        }
      }
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerDrawableDownloader.2
 * JD-Core Version:    0.7.0.1
 */