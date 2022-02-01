package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import mfa;
import mlh;
import mvk;

public class MultiIncomingCallUICtr$5
  implements Runnable
{
  public MultiIncomingCallUICtr$5(mfa parammfa) {}
  
  public void run()
  {
    String str = mvk.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a());
    if (this.this$0.jdField_a_of_type_Mlh != null)
    {
      this.this$0.jdField_a_of_type_Mlh.a(str);
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() % 60L >= 1L)
      {
        this.this$0.jdField_a_of_type_Mlh.a();
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
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.5
 * JD-Core Version:    0.7.0.1
 */