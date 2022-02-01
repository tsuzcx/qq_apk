package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lfe;
import lzj;

public class SmallScreenDoubleVideoControlUI$1
  implements Runnable
{
  public SmallScreenDoubleVideoControlUI$1(lzj paramlzj, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      lfe locallfe = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(locallfe.d, 225);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(225);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(locallfe.d, 9);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), locallfe.d, Boolean.valueOf(true) });
      QLog.w("SmallScreenDoubleVideoControlUI", 1, "exit when onCreate fail, seq[" + this.a + "]");
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.1
 * JD-Core Version:    0.7.0.1
 */