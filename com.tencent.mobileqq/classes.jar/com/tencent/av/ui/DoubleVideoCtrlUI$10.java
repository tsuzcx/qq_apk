package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$10
  implements Runnable
{
  DoubleVideoCtrlUI$10(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void run()
  {
    if (!this.this$0.h())
    {
      Object localObject = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(((SessionInfo)localObject).c, 239);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(239);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(((SessionInfo)localObject).c, 9);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), ((SessionInfo)localObject).c, Boolean.valueOf(true) });
      localObject = this.this$0.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, exit when OnCreate, seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.10
 * JD-Core Version:    0.7.0.1
 */