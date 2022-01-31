package com.tencent.component.network.downloader.handler;

import com.squareup.okhttp.Response;
import com.tencent.component.network.downloader.DownloadResult;
import org.apache.http.HttpResponse;

public abstract interface ContentHandler
{
  public abstract boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.handler.ContentHandler
 * JD-Core Version:    0.7.0.1
 */