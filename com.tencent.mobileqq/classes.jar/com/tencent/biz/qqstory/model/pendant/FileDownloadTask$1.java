package com.tencent.biz.qqstory.model.pendant;

import com.tencent.biz.qqstory.base.download.DownloadProgressListener;

class FileDownloadTask$1
  implements DownloadProgressListener
{
  FileDownloadTask$1(FileDownloadTask paramFileDownloadTask, FileDownloadTask.Input paramInput) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    FileDownloadTask.a(this.b, new FileDownloadTask.Progress[] { new FileDownloadTask.Progress(this.a, paramLong1, paramLong2) });
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.pendant.FileDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */