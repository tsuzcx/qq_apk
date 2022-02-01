package com.tencent.av;

import com.tencent.av.utils.PhoneStatusMonitor;

class VideoController$3
  implements Runnable
{
  VideoController$3(VideoController paramVideoController) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = new VideoController.QQPhoneStatusListener(this.this$0);
    this.this$0.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor = new PhoneStatusMonitor(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.3
 * JD-Core Version:    0.7.0.1
 */