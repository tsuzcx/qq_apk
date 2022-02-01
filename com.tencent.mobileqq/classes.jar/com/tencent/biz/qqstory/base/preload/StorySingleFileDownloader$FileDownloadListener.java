package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract interface StorySingleFileDownloader$FileDownloadListener
{
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, int paramInt, ErrorMessage paramErrorMessage);
  
  public abstract void b(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.FileDownloadListener
 * JD-Core Version:    0.7.0.1
 */