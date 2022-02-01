package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class StorySingleFileDownloader$1
  implements Runnable
{
  StorySingleFileDownloader$1(StorySingleFileDownloader paramStorySingleFileDownloader) {}
  
  public void run()
  {
    Iterator localIterator = StorySingleFileDownloader.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
      StorySingleFileDownloader.b(this.this$0).a(localDownloadTask);
      Object localObject = localDownloadTask.l.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof StorySingleFileDownloader.FileDownloadListener)))
      {
        StorySingleFileDownloader.a(this.this$0, localDownloadTask.b, localDownloadTask.c, (StorySingleFileDownloader.FileDownloadListener)localObject);
        SLog.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localDownloadTask.a });
      }
    }
    StorySingleFileDownloader.a(this.this$0).clear();
    SLog.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */