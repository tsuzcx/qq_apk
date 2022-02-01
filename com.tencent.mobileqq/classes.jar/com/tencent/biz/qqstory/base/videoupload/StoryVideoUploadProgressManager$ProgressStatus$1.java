package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  StoryVideoUploadProgressManager$ProgressStatus$1(StoryVideoUploadProgressManager.ProgressStatus paramProgressStatus) {}
  
  public void run()
  {
    SLog.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    StoryVideoUploadProgressManager.ProgressStatus.a(this.a);
    StoryVideoUploadProgressManager.a(this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadProgressManager, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!StoryVideoUploadProgressManager.ProgressStatus.a(this.a)) {
      StoryVideoUploadProgressManager.a(this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadProgressManager).postDelayed(StoryVideoUploadProgressManager.ProgressStatus.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */