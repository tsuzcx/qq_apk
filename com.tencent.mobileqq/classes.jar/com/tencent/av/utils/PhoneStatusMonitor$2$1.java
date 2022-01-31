package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import mhf;
import mhg;

class PhoneStatusMonitor$2$1
  implements Runnable
{
  PhoneStatusMonitor$2$1(PhoneStatusMonitor.2 param2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable run end  mIsCalling: " + this.a.this$0.jdField_a_of_type_Boolean);
    }
    if (this.a.this$0.jdField_a_of_type_Boolean)
    {
      this.a.this$0.jdField_a_of_type_Boolean = false;
      if (this.a.this$0.jdField_a_of_type_Mhg != null) {
        this.a.this$0.jdField_a_of_type_Mhg.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.2.1
 * JD-Core Version:    0.7.0.1
 */