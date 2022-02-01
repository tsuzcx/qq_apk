package com.tencent.falco.base.libapi.downloader;

public abstract interface DownloadTaskState
{
  public static final int DownloadSDKTaskState_DELETE = 5;
  public static final int DownloadSDKTaskState_DOWNLOADING = 2;
  public static final int DownloadSDKTaskState_DOWNLOAD_START = 6;
  public static final int DownloadSDKTaskState_FAILED = 1;
  public static final int DownloadSDKTaskState_PAUSED = 4;
  public static final int DownloadSDKTaskState_SUCCEED = 0;
  public static final int DownloadSDKTaskState_UNKOWN = -1;
  public static final int DownloadSDKTaskState_WAITING = 3;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.downloader.DownloadTaskState
 * JD-Core Version:    0.7.0.1
 */