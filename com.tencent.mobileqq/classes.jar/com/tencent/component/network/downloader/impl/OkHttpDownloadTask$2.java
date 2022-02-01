package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.module.common.ProgressResponseBody.ProgressListener;

class OkHttpDownloadTask$2
  implements ProgressResponseBody.ProgressListener
{
  OkHttpDownloadTask$2(OkHttpDownloadTask paramOkHttpDownloadTask) {}
  
  public void update(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramLong2 > 0L)
    {
      float f = (float)paramLong1 * 1.0F / (float)paramLong2;
      if (f - OkHttpDownloadTask.access$200(this.this$0) >= 0.1F)
      {
        OkHttpDownloadTask.access$202(this.this$0, f);
        OkHttpDownloadTask localOkHttpDownloadTask = this.this$0;
        localOkHttpDownloadTask.notifyDownloadProgress(localOkHttpDownloadTask.getUrlKey(), this.this$0.mContentLength, OkHttpDownloadTask.access$200(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.OkHttpDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */