package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner;

class PreloadDownloaderManager$1
  implements Runnable
{
  PreloadDownloaderManager$1(PreloadDownloaderManager paramPreloadDownloaderManager) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.b();
    this.this$0.jdField_a_of_type_JavaLangRunnable = null;
    CacheCleaner.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager.1
 * JD-Core Version:    0.7.0.1
 */