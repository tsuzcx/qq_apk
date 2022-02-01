package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class SlideProgressNotifier$1
  implements Runnable
{
  SlideProgressNotifier$1(SlideProgressNotifier paramSlideProgressNotifier, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SlideShowProgressUpdate : ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("%");
      QLog.d("QQProgressNotifier", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = SlideProgressNotifier.a(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.a.getString(2131699372));
    localStringBuilder.append(" ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("%");
    ((QQProgressDialog)localObject).a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier.1
 * JD-Core Version:    0.7.0.1
 */