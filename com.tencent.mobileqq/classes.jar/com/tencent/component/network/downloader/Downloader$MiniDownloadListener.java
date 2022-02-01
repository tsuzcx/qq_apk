package com.tencent.component.network.downloader;

import java.util.List;
import java.util.Map;

public abstract interface Downloader$MiniDownloadListener
  extends Downloader.DownloadListener
{
  public abstract void onDownloadHeadersReceived(String paramString, int paramInt, Map<String, List<String>> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.Downloader.MiniDownloadListener
 * JD-Core Version:    0.7.0.1
 */