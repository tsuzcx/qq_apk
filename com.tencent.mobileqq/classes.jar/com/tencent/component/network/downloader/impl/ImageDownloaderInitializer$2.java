package com.tencent.component.network.downloader.impl;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.handler.ContentHandler;
import com.tencent.component.network.utils.StringUtil;
import okhttp3.Response;
import org.apache.http.HttpResponse;

final class ImageDownloaderInitializer$2
  implements ContentHandler
{
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse)
  {
    paramDownloadResult = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty(paramDownloadResult)) {}
    while (!StringUtil.startsWithIgnoreCase(paramDownloadResult, "image")) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ImageDownloaderInitializer.2
 * JD-Core Version:    0.7.0.1
 */