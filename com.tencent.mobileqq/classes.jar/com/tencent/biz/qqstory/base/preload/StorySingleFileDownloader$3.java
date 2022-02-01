package com.tencent.biz.qqstory.base.preload;

import java.util.Map;

class StorySingleFileDownloader$3
  implements Runnable
{
  StorySingleFileDownloader$3(StorySingleFileDownloader paramStorySingleFileDownloader, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = DownloadTask.b(this.a, this.b);
    localObject = (DownloadTask)StorySingleFileDownloader.a(this.this$0).get(localObject);
    if (localObject != null) {
      ((DownloadTask)localObject).l.remove("DOWNLOAD_TASK_KEY_LISTENER");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3
 * JD-Core Version:    0.7.0.1
 */