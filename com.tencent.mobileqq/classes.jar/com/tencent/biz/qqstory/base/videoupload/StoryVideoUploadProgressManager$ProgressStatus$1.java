package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;
import wcz;
import wda;
import ykq;

public class StoryVideoUploadProgressManager$ProgressStatus$1
  implements Runnable
{
  public StoryVideoUploadProgressManager$ProgressStatus$1(wda paramwda) {}
  
  public void run()
  {
    ykq.a("StoryVideoUploadProgressManager", "progress running, id=%s", this.a.jdField_a_of_type_JavaLangString);
    wda.a(this.a);
    wcz.a(this.a.jdField_a_of_type_Wcz, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    if (!wda.a(this.a)) {
      wcz.a(this.a.jdField_a_of_type_Wcz).postDelayed(wda.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1
 * JD-Core Version:    0.7.0.1
 */