package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;

class StorySingleFileDownloader$4
  implements Runnable
{
  StorySingleFileDownloader$4(StorySingleFileDownloader paramStorySingleFileDownloader, DownloadTask paramDownloadTask, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!StorySingleFileDownloader.a(this.this$0).containsKey(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask.a)) {
      return;
    }
    StorySingleFileDownloader.a(this.this$0).remove(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask.a);
    StorySingleFileDownloader.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask, this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */