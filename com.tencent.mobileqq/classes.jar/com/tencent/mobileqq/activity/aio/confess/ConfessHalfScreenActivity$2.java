package com.tencent.mobileqq.activity.aio.confess;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcClient;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ConfessHalfScreenActivity$2
  implements Runnable
{
  ConfessHalfScreenActivity$2(ConfessHalfScreenActivity paramConfessHalfScreenActivity) {}
  
  public void run()
  {
    Object localObject = CampusCircleIpcClient.a().f();
    if ((localObject != null) && (localObject.length == 2))
    {
      boolean bool1 = ((Boolean)localObject[0]).booleanValue();
      boolean bool2 = ((Boolean)localObject[1]).booleanValue();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume .isSucess =");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", isInTroopAIO=");
      ((StringBuilder)localObject).append(bool2);
      QLog.e("WebLog_QQBrowserActivity", 1, ((StringBuilder)localObject).toString());
      if ((bool1) && (!bool2)) {
        ThreadManager.getUIHandler().post(new ConfessHalfScreenActivity.2.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.2
 * JD-Core Version:    0.7.0.1
 */