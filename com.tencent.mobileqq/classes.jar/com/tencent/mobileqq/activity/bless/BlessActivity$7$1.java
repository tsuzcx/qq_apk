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
      QLog.d(BlessActivity.a(this.a.a), 2, "videoview bring to top");
    }
    if (BlessActivity.b(this.a.a) != null) {
      BlessActivity.b(this.a.a).setVisibility(8);
    }
    if (BlessActivity.a(this.a.a) != null) {
      BlessActivity.a(this.a.a).bringToFront();
    }
    this.a.a.findViewById(2131369534).bringToFront();
    this.a.a.findViewById(2131379432).bringToFront();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.7.1
 * JD-Core Version:    0.7.0.1
 */