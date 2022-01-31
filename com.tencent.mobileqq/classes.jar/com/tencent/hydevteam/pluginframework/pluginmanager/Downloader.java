package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import java.io.File;

@API
public abstract interface Downloader
{
  @API
  public abstract ProgressFuture<File> download(TargetDownloadInfo paramTargetDownloadInfo, File paramFile1, File paramFile2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.Downloader
 * JD-Core Version:    0.7.0.1
 */