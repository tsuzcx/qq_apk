package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;

public abstract interface IVideoPreloader$OnPreloadListener
{
  public abstract void a(String paramString, int paramInt1, int paramInt2, DownloadTask paramDownloadTask);
  
  public abstract void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask);
  
  public abstract void a(String paramString, int paramInt, DownloadTask paramDownloadTask);
  
  public abstract void a(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask);
  
  public abstract void b(String paramString, int paramInt, DownloadTask paramDownloadTask);
  
  public abstract void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.IVideoPreloader.OnPreloadListener
 * JD-Core Version:    0.7.0.1
 */