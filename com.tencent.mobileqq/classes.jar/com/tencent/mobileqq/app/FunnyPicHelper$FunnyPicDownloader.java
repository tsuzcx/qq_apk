package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.emoticonview.LooperGifImage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.io.OutputStream;
import mqq.app.MobileQQ;
import org.apache.http.Header;

public class FunnyPicHelper$FunnyPicDownloader
  extends AbsDownloader
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.getHeader("funnypic_type");
    if (paramURLDrawableHandler != null)
    {
      paramURLDrawableHandler = paramURLDrawableHandler.getValue();
      float f = paramDownloadParams.mGifRoundCorner;
      if ((!TextUtils.isEmpty(paramURLDrawableHandler)) && (Integer.valueOf(paramURLDrawableHandler).intValue() == 2)) {
        return new LooperGifImage(paramFile, true, f, 3);
      }
    }
    return null;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      paramOutputStream = (String)paramDownloadParams.tag;
      paramDownloadParams = AppConstants.SDCARD_IMG_FAVORITE;
      paramURLDrawableHandler = new StringBuilder();
      paramURLDrawableHandler.append(paramDownloadParams);
      paramURLDrawableHandler.append(Utils.Crc64String(paramOutputStream));
      paramDownloadParams = new File(paramURLDrawableHandler.toString());
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
      paramOutputStream = new DownloadTask(paramOutputStream, paramDownloadParams);
      if (((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download(paramOutputStream, MobileQQ.sMobileQQ.waitAppRuntime(null)) == 0) {
        return paramDownloadParams;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FunnyPicHelper.FunnyPicDownloader
 * JD-Core Version:    0.7.0.1
 */