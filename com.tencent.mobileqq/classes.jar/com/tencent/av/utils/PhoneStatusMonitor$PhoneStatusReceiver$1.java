package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import muv;
import muw;
import mux;
import muz;

public class PhoneStatusMonitor$PhoneStatusReceiver$1
  implements Runnable
{
  public PhoneStatusMonitor$PhoneStatusReceiver$1(mux parammux, String paramString) {}
  
  public void run()
  {
    boolean bool = muz.d(this.jdField_a_of_type_Mux.a.jdField_a_of_type_AndroidContentContext);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, String.format("PhoneStatusReceiver, isCallingRunnable end, action[%s], mIsCalling[%s], isCalling[%s]", new Object[] { this.jdField_a_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Mux.a.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
    }
    if ((this.jdField_a_of_type_Mux.a.jdField_a_of_type_Boolean) && (!bool))
    {
      this.jdField_a_of_type_Mux.a.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Mux.a.jdField_a_of_type_Muw != null) {
        this.jdField_a_of_type_Mux.a.jdField_a_of_type_Muw.a(false);
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Mux.a.jdField_a_of_type_Boolean) || (!bool));
      this.jdField_a_of_type_Mux.a.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Mux.a.jdField_a_of_type_Muw == null);
    this.jdField_a_of_type_Mux.a.jdField_a_of_type_Muw.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusReceiver.1
 * JD-Core Version:    0.7.0.1
 */