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
    if (this.a.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().ab = true;
    }
    this.a.a.n();
    if ((this.a.a.c == 1) && (this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.MyGAudioUIObserver.AutoCheckVideoRunnable
 * JD-Core Version:    0.7.0.1
 */