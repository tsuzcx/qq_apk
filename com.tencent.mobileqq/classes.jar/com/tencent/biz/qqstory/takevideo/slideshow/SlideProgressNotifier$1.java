package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import bety;
import com.tencent.qphone.base.util.QLog;

class SlideProgressNotifier$1
  implements Runnable
{
  SlideProgressNotifier$1(SlideProgressNotifier paramSlideProgressNotifier, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProgressNotifier", 2, "SlideShowProgressUpdate : " + this.a + "%");
    }
    SlideProgressNotifier.a(this.this$0).a(this.this$0.a.getString(2131699913) + " " + this.a + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier.1
 * JD-Core Version:    0.7.0.1
 */