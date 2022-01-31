package com.tencent.mobileqq.activity.leba;

import aieq;
import axlx;
import com.tencent.qphone.base.util.QLog;

public class LebaShowListManager$1
  implements Runnable
{
  public LebaShowListManager$1(aieq paramaieq, axlx paramaxlx, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        axlx localaxlx = this.jdField_a_of_type_Axlx;
        i = (int)this.jdField_a_of_type_Long;
        boolean bool = this.jdField_a_of_type_Boolean;
        if (this.b != -9223372036854775808L) {
          continue;
        }
        l = this.c;
        i = localaxlx.a(i, bool, l);
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
      l = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaShowListManager.1
 * JD-Core Version:    0.7.0.1
 */