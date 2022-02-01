package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import mlb;
import mlc;
import mvd;

public class VideoInviteFloatBarUICtr$4
  implements Runnable
{
  public VideoInviteFloatBarUICtr$4(mlc parammlc) {}
  
  public void run()
  {
    String str = mvd.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a());
    if (this.this$0.jdField_a_of_type_Mlb != null)
    {
      this.this$0.jdField_a_of_type_Mlb.a(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.4
 * JD-Core Version:    0.7.0.1
 */