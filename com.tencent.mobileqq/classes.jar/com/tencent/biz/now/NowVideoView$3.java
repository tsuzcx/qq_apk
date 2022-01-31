package com.tencent.biz.now;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class NowVideoView$3
  extends Thread
{
  NowVideoView$3(NowVideoView paramNowVideoView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      if ((this != null) && (!this.this$0.jdField_a_of_type_Boolean))
      {
        if ((this.this$0.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Long > 2000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NowVideoView", 2, "no draw for Now");
          }
          this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        }
      }
      else
      {
        this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
        this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
        continue;
      }
      try
      {
        Thread.sleep(1000L);
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView.3
 * JD-Core Version:    0.7.0.1
 */