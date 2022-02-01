package com.tencent.biz.qqstory.base.preload;

import java.util.Map;

class StorySingleFileDownloader$3
  implements Runnable
{
  StorySingleFileDownloader$3(StorySingleFileDownloader paramStorySingleFileDownloader, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = DownloadTask.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    localObject = (DownloadTask)StorySingleFileDownloader.a(this.this$0).get(localObject);
    if (localObject != null) {
      ((DownloadTask)localObject).a.remove("DOWNLOAD_TASK_KEY_LISTENER");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3
 * JD-Core Version:    0.7.0.1
 */