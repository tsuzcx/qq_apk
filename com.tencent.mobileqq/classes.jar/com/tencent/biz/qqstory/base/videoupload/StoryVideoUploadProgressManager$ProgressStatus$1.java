package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import wik;
import wil;
import yqp;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(wil paramwil) {}
  
  public void run()
  {
    yqp.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    wil.a(this.a);
    wik.a(this.a.jdField_a_of_type_Wik, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!wil.a(this.a)) {
      wik.a(this.a.jdField_a_of_type_Wik).postDelayed(wil.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */