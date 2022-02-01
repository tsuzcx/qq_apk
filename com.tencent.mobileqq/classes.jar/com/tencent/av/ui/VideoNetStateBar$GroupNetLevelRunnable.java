package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class VideoNetStateBar$GroupNetLevelRunnable
  implements Runnable
{
  VideoNetStateBar$GroupNetLevelRunnable(VideoNetStateBar paramVideoNetStateBar) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoNetStateBar", 2, "mVideoController == null");
      }
      return;
    }
    int i = this.this$0.jdField_a_of_type_ComTencentAvVideoController.g();
    this.this$0.e = true;
    switch (i)
    {
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_Int = 1;
      if (QLog.isColorLevel()) {
        QLog.d("VideoNetStateBar", 2, String.format("getGAudioNetLevel[%s], mCurNetLevel[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.this$0.b) }));
      }
      if ((this.this$0.jdField_a_of_type_JavaLangRunnable == null) || (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) || (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() == null)) {
        break;
      }
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 2000L);
      return;
      this.this$0.b = 3;
      continue;
      this.this$0.b = 2;
      continue;
      this.this$0.b = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar.GroupNetLevelRunnable
 * JD-Core Version:    0.7.0.1
 */