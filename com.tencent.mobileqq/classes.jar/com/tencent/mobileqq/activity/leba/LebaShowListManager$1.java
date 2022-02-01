package com.tencent.mobileqq.activity.leba;

import ajek;
import azvi;
import com.tencent.qphone.base.util.QLog;

public class LebaShowListManager$1
  implements Runnable
{
  public LebaShowListManager$1(ajek paramajek, azvi paramazvi, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        azvi localazvi = this.jdField_a_of_type_Azvi;
        i = (int)this.jdField_a_of_type_Long;
        boolean bool = this.jdField_a_of_type_Boolean;
        if (this.jdField_b_of_type_Long != -9223372036854775808L) {
          continue;
        }
        l = this.c;
        i = localazvi.a(i, bool, l, this.jdField_b_of_type_Boolean);
      }
      catch (Exception localException)
      {
        long l;
        int j = -2;
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.lebatab.mgr", 2, localException.toString());
        i = j;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, result = " + i);
      }
      return;
      l = this.jdField_b_of_type_Long;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaShowListManager.1
 * JD-Core Version:    0.7.0.1
 */