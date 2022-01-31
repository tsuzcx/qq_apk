package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import kvq;

class DoubleVideoCtrlUI$5
  extends TimerTask
{
  boolean a = this.b;
  
  DoubleVideoCtrlUI$5(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) || (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    kvq localkvq;
    do
    {
      return;
      localkvq = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localkvq == null);
    if (localkvq.P <= 0)
    {
      if (this.this$0.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilTimer.cancel();
        this.this$0.jdField_a_of_type_JavaUtilTimer = null;
      }
      QLog.w(this.this$0.c, 1, "StartGlassCheck, cancel cur Timer");
      return;
    }
    for (;;)
    {
      long l3;
      try
      {
        if (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break label333;
        }
        l1 = ((AVActivity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d);
        long l2 = System.currentTimeMillis();
        if (l1 == 0L) {
          break;
        }
        l3 = l2 - l1;
        QLog.w(this.this$0.c, 1, "StartGlassCheck, interval[" + l3 + "], mCheck[" + this.a + "], mCurrentDoubleVideoGlassSwitch[" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().O + "]");
        if ((l3 > this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().P * 1000) && (this.a))
        {
          this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.runOnUiThread(new DoubleVideoCtrlUI.5.1(this, l2, l1));
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.w(this.this$0.c, 1, "StartGlassCheck, Exception", localException);
        l1 = 0L;
        continue;
      }
      if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().O == 0) || (l3 >= 1000L)) {
        break;
      }
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.runOnUiThread(new DoubleVideoCtrlUI.5.2(this));
      return;
      label333:
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.5
 * JD-Core Version:    0.7.0.1
 */