package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import ukp;
import ukq;
import wsv;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(ukq paramukq) {}
  
  public void run()
  {
    wsv.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    ukq.a(this.a);
    ukp.a(this.a.jdField_a_of_type_Ukp, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!ukq.a(this.a)) {
      ukp.a(this.a.jdField_a_of_type_Ukp).postDelayed(ukq.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */