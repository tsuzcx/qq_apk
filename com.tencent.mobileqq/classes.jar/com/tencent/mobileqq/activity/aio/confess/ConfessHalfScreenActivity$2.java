package com.tencent.mobileqq.activity.aio.confess;

import apjv;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ConfessHalfScreenActivity$2
  implements Runnable
{
  ConfessHalfScreenActivity$2(ConfessHalfScreenActivity paramConfessHalfScreenActivity) {}
  
  public void run()
  {
    Object[] arrayOfObject = apjv.a().a();
    if ((arrayOfObject != null) && (arrayOfObject.length == 2))
    {
      boolean bool1 = ((Boolean)arrayOfObject[0]).booleanValue();
      boolean bool2 = ((Boolean)arrayOfObject[1]).booleanValue();
      QLog.e("WebLog_QQBrowserActivity", 1, "doOnResume .isSucess =" + bool1 + ", isInTroopAIO=" + bool2);
      if ((bool1) && (!bool2)) {
        ThreadManager.getUIHandler().post(new ConfessHalfScreenActivity.2.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.2
 * JD-Core Version:    0.7.0.1
 */