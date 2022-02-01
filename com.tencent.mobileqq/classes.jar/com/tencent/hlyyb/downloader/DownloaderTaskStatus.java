package com.tencent.hlyyb.downloader;

public enum DownloaderTaskStatus
{
  static
  {
    DOWNLOADING = new DownloaderTaskStatus("DOWNLOADING", 2);
    COMPLETE = new DownloaderTaskStatus("COMPLETE", 3);
    FAILED = new DownloaderTaskStatus("FAILED", 4);
    PAUSED = new DownloaderTaskStatus("PAUSED", 5);
  }
  
  private DownloaderTaskStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.DownloaderTaskStatus
 * JD-Core Version:    0.7.0.1
 */