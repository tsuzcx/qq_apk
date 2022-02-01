package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import voe;
import vof;
import xvv;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(vof paramvof) {}
  
  public void run()
  {
    xvv.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    vof.a(this.a);
    voe.a(this.a.jdField_a_of_type_Voe, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!vof.a(this.a)) {
      voe.a(this.a.jdField_a_of_type_Voe).postDelayed(vof.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */