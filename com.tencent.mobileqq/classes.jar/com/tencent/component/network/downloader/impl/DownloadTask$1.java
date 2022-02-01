package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;

final class DownloadTask$1
  extends ThreadLocal<HttpUtil.RequestOptions>
{
  protected HttpUtil.RequestOptions initialValue()
  {
    return new HttpUtil.RequestOptions();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask.1
 * JD-Core Version:    0.7.0.1
 */