package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import sje;
import sjf;
import urk;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(sjf paramsjf) {}
  
  public void run()
  {
    urk.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    sjf.a(this.a);
    sje.a(this.a.jdField_a_of_type_Sje, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!sjf.a(this.a)) {
      sje.a(this.a.jdField_a_of_type_Sje).postDelayed(sjf.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */