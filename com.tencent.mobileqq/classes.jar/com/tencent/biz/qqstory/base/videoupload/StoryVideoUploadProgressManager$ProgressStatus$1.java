package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import wmf;
import wmg;
import yuk;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(wmg paramwmg) {}
  
  public void run()
  {
    yuk.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    wmg.a(this.a);
    wmf.a(this.a.jdField_a_of_type_Wmf, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!wmg.a(this.a)) {
      wmf.a(this.a.jdField_a_of_type_Wmf).postDelayed(wmg.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */