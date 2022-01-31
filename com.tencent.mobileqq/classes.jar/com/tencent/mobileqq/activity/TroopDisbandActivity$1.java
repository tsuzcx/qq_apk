package com.tencent.mobileqq.activity;

import akhp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopDisbandActivity$1
  implements Runnable
{
  TroopDisbandActivity$1(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  public void run()
  {
    try
    {
      akhp localakhp = (akhp)this.this$0.app.a(20);
      if (localakhp != null)
      {
        long l = Long.parseLong(this.this$0.a);
        localakhp.a(l, 0L, 5, 6, 1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(l));
        localakhp.a(localArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.disband", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.1
 * JD-Core Version:    0.7.0.1
 */