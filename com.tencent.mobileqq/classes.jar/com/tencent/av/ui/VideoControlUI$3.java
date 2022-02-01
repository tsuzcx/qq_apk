package com.tencent.av.ui;

import android.os.Build;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$3
  extends QQAnimationListener
{
  VideoControlUI$3(VideoControlUI paramVideoControlUI) {}
  
  public void a()
  {
    this.a.n();
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    if (!this.a.af) {
      this.a.f(0);
    }
    if ("GT-I9100G".equals(Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.X, 2, "Model is 9100G, don't do animation");
      }
    }
    else {
      this.a.Z();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.3
 * JD-Core Version:    0.7.0.1
 */