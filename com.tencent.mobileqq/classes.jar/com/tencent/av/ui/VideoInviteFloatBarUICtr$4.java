package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;

class VideoInviteFloatBarUICtr$4
  implements Runnable
{
  VideoInviteFloatBarUICtr$4(VideoInviteFloatBarUICtr paramVideoInviteFloatBarUICtr) {}
  
  public void run()
  {
    String str = UITools.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a());
    if (this.this$0.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null)
    {
      this.this$0.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(str);
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() % 60L >= 1L) {
        this.this$0.a();
      }
    }
    else
    {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.4
 * JD-Core Version:    0.7.0.1
 */