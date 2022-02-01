package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

class SmallScreenVideoController$3
  implements Runnable
{
  SmallScreenVideoController$3(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI instanceof SmallScreenDoubleVideoControlUI))
    {
      String str = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      int i = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().P;
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), str, Integer.valueOf(i) });
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.3
 * JD-Core Version:    0.7.0.1
 */