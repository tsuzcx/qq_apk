package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;

class StorySingleFileDownloader$4
  implements Runnable
{
  StorySingleFileDownloader$4(StorySingleFileDownloader paramStorySingleFileDownloader, DownloadTask paramDownloadTask, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!StorySingleFileDownloader.a(this.this$0).containsKey(this.a.a)) {
      return;
    }
    StorySingleFileDownloader.a(this.this$0).remove(this.a.a);
    StorySingleFileDownloader.a(this.this$0, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */