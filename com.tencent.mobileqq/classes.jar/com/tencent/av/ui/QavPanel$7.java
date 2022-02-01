package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mhe;

class QavPanel$7
  implements Runnable
{
  QavPanel$7(QavPanel paramQavPanel, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.this$0.jdField_a_of_type_ArrayOfMhe[this.jdField_a_of_type_Int] == null)) {
      return;
    }
    if (this.jdField_a_of_type_Int != this.this$0.b)
    {
      QLog.w(this.this$0.jdField_a_of_type_JavaLangString, 1, "doShowAnimation, invalid menuType[" + this.jdField_a_of_type_Int + "], curMenuType[" + this.this$0.b + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    this.this$0.jdField_a_of_type_ArrayOfMhe[this.jdField_a_of_type_Int].a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.b);
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.7
 * JD-Core Version:    0.7.0.1
 */