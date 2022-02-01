package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class SmallScreenMultiVideoControlUI$MyGAudioUIObserver$AutoCheckVideoRunnable
  implements Runnable
{
  SmallScreenMultiVideoControlUI$MyGAudioUIObserver$AutoCheckVideoRunnable(SmallScreenMultiVideoControlUI.MyGAudioUIObserver paramMyGAudioUIObserver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "AutoCheckVideoRunnable");
    }
    if (this.a.b.z != null) {
      this.a.b.z.k().bv = true;
    }
    this.a.b.o();
    if ((this.a.b.c == 1) && (this.a.b.y != null)) {
      this.a.b.y.a(this.a.b.r());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.MyGAudioUIObserver.AutoCheckVideoRunnable
 * JD-Core Version:    0.7.0.1
 */