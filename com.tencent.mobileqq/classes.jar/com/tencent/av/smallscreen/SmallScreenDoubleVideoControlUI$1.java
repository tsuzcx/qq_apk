package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class SmallScreenDoubleVideoControlUI$1
  implements Runnable
{
  SmallScreenDoubleVideoControlUI$1(SmallScreenDoubleVideoControlUI paramSmallScreenDoubleVideoControlUI, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      Object localObject = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(((SessionInfo)localObject).c, 225);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(225);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(((SessionInfo)localObject).c, 9);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), ((SessionInfo)localObject).c, Boolean.valueOf(true) });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exit when onCreate fail, seq[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenDoubleVideoControlUI", 1, ((StringBuilder)localObject).toString());
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.1
 * JD-Core Version:    0.7.0.1
 */