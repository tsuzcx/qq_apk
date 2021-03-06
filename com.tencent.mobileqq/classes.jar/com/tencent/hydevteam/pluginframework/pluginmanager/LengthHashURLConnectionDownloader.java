package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.ProgressFuture;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

class LengthHashURLConnectionDownloader
  extends SimpleURLConnectionDownloader
{
  private final ExecutorService a = Executors.newSingleThreadExecutor();
  
  public ProgressFuture<File> download(TargetDownloadInfo paramTargetDownloadInfo, File paramFile1, File paramFile2)
  {
    AtomicLong localAtomicLong = new AtomicLong(0L);
    double d = paramTargetDownloadInfo.size;
    paramTargetDownloadInfo = new LengthHashURLConnectionDownloader.LengthHashDownloadTask(paramTargetDownloadInfo, paramFile1, paramFile2, localAtomicLong);
    return new LengthHashURLConnectionDownloader.1(this.a.submit(paramTargetDownloadInfo), d, localAtomicLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.LengthHashURLConnectionDownloader
 * JD-Core Version:    0.7.0.1
 */