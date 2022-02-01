package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lez;

class VideoLayerUIBase$2
  implements Runnable
{
  VideoLayerUIBase$2(VideoLayerUIBase paramVideoLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) {}
    try
    {
      String str = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d;
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(str);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "pauseVideo Runnable exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.2
 * JD-Core Version:    0.7.0.1
 */