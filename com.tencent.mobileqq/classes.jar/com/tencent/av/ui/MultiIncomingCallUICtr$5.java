package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import mgv;
import mnc;
import mww;

public class MultiIncomingCallUICtr$5
  implements Runnable
{
  public MultiIncomingCallUICtr$5(mgv parammgv) {}
  
  public void run()
  {
    String str = mww.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a());
    if (this.this$0.jdField_a_of_type_Mnc != null)
    {
      this.this$0.jdField_a_of_type_Mnc.a(str);
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() % 60L >= 1L)
      {
        this.this$0.jdField_a_of_type_Mnc.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.5
 * JD-Core Version:    0.7.0.1
 */