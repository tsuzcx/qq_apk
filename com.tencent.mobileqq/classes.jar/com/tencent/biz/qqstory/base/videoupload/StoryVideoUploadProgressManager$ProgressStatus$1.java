package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import uoy;
import uoz;
import wxe;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(uoz paramuoz) {}
  
  public void run()
  {
    wxe.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    uoz.a(this.a);
    uoy.a(this.a.jdField_a_of_type_Uoy, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!uoz.a(this.a)) {
      uoy.a(this.a.jdField_a_of_type_Uoy).postDelayed(uoz.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */