package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import svx;
import svy;
import ved;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(svy paramsvy) {}
  
  public void run()
  {
    ved.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    svy.a(this.a);
    svx.a(this.a.jdField_a_of_type_Svx, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!svy.a(this.a)) {
      svx.a(this.a.jdField_a_of_type_Svx).postDelayed(svy.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */