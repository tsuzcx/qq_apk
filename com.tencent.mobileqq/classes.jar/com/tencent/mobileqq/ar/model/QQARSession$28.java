package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.qphone.base.util.QLog;

class QQARSession$28
  implements Runnable
{
  QQARSession$28(QQARSession paramQQARSession) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Int == 2) && (QQARSession.a(this.this$0)))
    {
      if (this.this$0.e())
      {
        this.this$0.n();
        QQARSession.c(this.this$0, 0L);
        QQARSession.a(this.this$0, null);
        QQARSession.b(this.this$0, null);
      }
      this.this$0.a(5L);
      QQARSession.d(this.this$0);
      QQARSession localQQARSession = this.this$0;
      localQQARSession.b = false;
      if (localQQARSession.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(true, QQARSession.a(this.this$0), QQARSession.b(this.this$0));
      }
      QQARSession.a(this.this$0, 1);
      this.this$0.c = true;
      return;
    }
    QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.28
 * JD-Core Version:    0.7.0.1
 */