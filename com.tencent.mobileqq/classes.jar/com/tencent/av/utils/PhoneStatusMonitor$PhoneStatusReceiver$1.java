package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import msb;
import msc;
import msd;
import msf;

public class PhoneStatusMonitor$PhoneStatusReceiver$1
  implements Runnable
{
  public PhoneStatusMonitor$PhoneStatusReceiver$1(msd parammsd, String paramString) {}
  
  public void run()
  {
    boolean bool = msf.d(this.jdField_a_of_type_Msd.a.jdField_a_of_type_AndroidContentContext);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, String.format("PhoneStatusReceiver, isCallingRunnable end, action[%s], mIsCalling[%s], isCalling[%s]", new Object[] { this.jdField_a_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Msd.a.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
    }
    if ((this.jdField_a_of_type_Msd.a.jdField_a_of_type_Boolean) && (!bool))
    {
      this.jdField_a_of_type_Msd.a.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Msd.a.jdField_a_of_type_Msc != null) {
        this.jdField_a_of_type_Msd.a.jdField_a_of_type_Msc.a(false);
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Msd.a.jdField_a_of_type_Boolean) || (!bool));
      this.jdField_a_of_type_Msd.a.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Msd.a.jdField_a_of_type_Msc == null);
    this.jdField_a_of_type_Msd.a.jdField_a_of_type_Msc.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusReceiver.1
 * JD-Core Version:    0.7.0.1
 */