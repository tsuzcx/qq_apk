package com.tencent.component.network.downloader.handler;

import com.tencent.component.network.downloader.DownloadResult;
import okhttp3.Response;
import org.apache.http.HttpResponse;

public abstract interface ContentHandler
{
  public abstract boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.handler.ContentHandler
 * JD-Core Version:    0.7.0.1
 */