package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lga;
import lyy;

public class SmallScreenDoubleVideoControlUI$1
  implements Runnable
{
  public SmallScreenDoubleVideoControlUI$1(lyy paramlyy, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      lga locallga = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(locallga.d, 225);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(225);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(locallga.d, 9);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), locallga.d, Boolean.valueOf(true) });
      QLog.w("SmallScreenDoubleVideoControlUI", 1, "exit when onCreate fail, seq[" + this.a + "]");
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.1
 * JD-Core Version:    0.7.0.1
 */