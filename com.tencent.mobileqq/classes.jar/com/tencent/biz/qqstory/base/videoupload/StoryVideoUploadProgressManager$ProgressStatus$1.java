package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import swa;
import swb;
import veg;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(swb paramswb) {}
  
  public void run()
  {
    veg.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    swb.a(this.a);
    swa.a(this.a.jdField_a_of_type_Swa, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!swb.a(this.a)) {
      swa.a(this.a.jdField_a_of_type_Swa).postDelayed(swb.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */