package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  StoryVideoUploadProgressManager$ProgressStatus$1(StoryVideoUploadProgressManager.ProgressStatus paramProgressStatus) {}
  
  public void run()
  {
    SLog.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.a);
    StoryVideoUploadProgressManager.ProgressStatus.a(this.a);
    StoryVideoUploadProgressManager.a(this.a.f, this.a.a, this.a.e);
    if (!StoryVideoUploadProgressManager.ProgressStatus.b(this.a)) {
      StoryVideoUploadProgressManager.a(this.a.f).postDelayed(StoryVideoUploadProgressManager.ProgressStatus.c(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */