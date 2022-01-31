package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import mki;
import mkj;
import muc;

public class VideoInviteFloatBarUICtr$4
  implements Runnable
{
  public VideoInviteFloatBarUICtr$4(mkj parammkj) {}
  
  public void run()
  {
    String str = muc.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a());
    if (this.this$0.jdField_a_of_type_Mki != null)
    {
      this.this$0.jdField_a_of_type_Mki.a(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.4
 * JD-Core Version:    0.7.0.1
 */