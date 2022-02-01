package com.tencent.mobileqq.apollo.view;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.utils.ApolloResDownloaderUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;

public class QQFrameZipDecoder
  extends SimpleFrameZipDecoder
  implements SimpleFrameZipDecoder.IDownloadable
{
  public QQFrameZipDecoder(SimpleFrameZipDecoder.OnFrameDecodeListener paramOnFrameDecodeListener)
  {
    super(null, paramOnFrameDecodeListener);
    this.a = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  public void a(SimpleFrameZipDecoder paramSimpleFrameZipDecoder, String paramString1, String paramString2, String paramString3)
  {
    int j = 1;
    this.c = 1;
    DownloadTask localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.N = true;
    localDownloadTask.J = true;
    localDownloadTask.L = "apollo_gif";
    localDownloadTask.e = 1;
    localDownloadTask.P = true;
    localDownloadTask.Q = true;
    localDownloadTask.a(new QQFrameZipDecoder.1(this, paramString1, paramString2, paramString3));
    paramSimpleFrameZipDecoder = BaseApplicationImpl.getApplication();
    if (paramSimpleFrameZipDecoder != null)
    {
      paramSimpleFrameZipDecoder = paramSimpleFrameZipDecoder.getRuntime();
      if ((paramSimpleFrameZipDecoder instanceof QQAppInterface))
      {
        paramSimpleFrameZipDecoder = (QQAppInterface)paramSimpleFrameZipDecoder;
        break label110;
      }
    }
    paramSimpleFrameZipDecoder = null;
    label110:
    int i = j;
    if (paramSimpleFrameZipDecoder != null)
    {
      paramSimpleFrameZipDecoder = ApolloResDownloaderUtil.a(paramSimpleFrameZipDecoder);
      i = j;
      if (paramSimpleFrameZipDecoder != null)
      {
        paramSimpleFrameZipDecoder.startDownload(localDownloadTask, localDownloadTask.a(), null);
        i = 0;
      }
    }
    if (i != 0) {
      ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localDownloadTask));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.QQFrameZipDecoder
 * JD-Core Version:    0.7.0.1
 */