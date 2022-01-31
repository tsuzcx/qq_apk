package com.tencent.av.utils;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import msb;
import msf;

public class PhoneStatusMonitor$2
  implements Runnable
{
  public PhoneStatusMonitor$2(msb parammsb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable run");
    }
    if ((this.this$0.jdField_a_of_type_AndroidContentContext != null) && (!msf.d(this.this$0.jdField_a_of_type_AndroidContentContext)) && (this.this$0.jdField_a_of_type_AndroidOsHandler != null)) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new PhoneStatusMonitor.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.2
 * JD-Core Version:    0.7.0.1
 */