package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.util.Log;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicLong;

class LengthHashURLConnectionDownloader$LengthHashDownloadTask
  extends SimpleURLConnectionDownloader.DownloadTask
{
  public LengthHashURLConnectionDownloader$LengthHashDownloadTask(TargetDownloadInfo paramTargetDownloadInfo, File paramFile1, File paramFile2, AtomicLong paramAtomicLong)
  {
    super(paramTargetDownloadInfo, paramFile1, paramFile2, paramAtomicLong);
  }
  
  public final File a()
  {
    long l = this.a.length();
    HttpURLConnection localHttpURLConnection = b();
    int i = localHttpURLConnection.getContentLength();
    if ((l != 0L) && (l == i)) {
      Log.d("LengthCheckDownloader", "下载的文件没有变化，不进行下载 fileLenght:" + l);
    }
    for (;;)
    {
      return this.a;
      a(localHttpURLConnection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.LengthHashURLConnectionDownloader.LengthHashDownloadTask
 * JD-Core Version:    0.7.0.1
 */