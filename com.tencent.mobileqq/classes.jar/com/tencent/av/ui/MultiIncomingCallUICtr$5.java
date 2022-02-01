package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;

class MultiIncomingCallUICtr$5
  implements Runnable
{
  MultiIncomingCallUICtr$5(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  public void run()
  {
    String str = UITools.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a());
    if (this.this$0.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null)
    {
      this.this$0.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(str);
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() % 60L >= 1L)
      {
        this.this$0.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a();
        this.this$0.a();
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.5
 * JD-Core Version:    0.7.0.1
 */