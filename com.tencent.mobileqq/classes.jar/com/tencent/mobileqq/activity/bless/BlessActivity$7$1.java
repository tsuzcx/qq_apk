package com.tencent.mobileqq.activity.bless;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;

class BlessActivity$7$1
  implements Runnable
{
  BlessActivity$7$1(BlessActivity.7 param7) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.f(this.a.a), 2, "videoview bring to top");
    }
    if (BlessActivity.h(this.a.a) != null) {
      BlessActivity.h(this.a.a).setVisibility(8);
    }
    if (BlessActivity.g(this.a.a) != null) {
      BlessActivity.g(this.a.a).bringToFront();
    }
    this.a.a.findViewById(2131436227).bringToFront();
    this.a.a.findViewById(2131447463).bringToFront();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.7.1
 * JD-Core Version:    0.7.0.1
 */