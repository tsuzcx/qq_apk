package com.tencent.mobileqq.activity.activateFriend.biz;

import aewd;
import com.tencent.qphone.base.util.QLog;

public class ReminderDataManager$7
  implements Runnable
{
  public void run()
  {
    int i = aewd.a(this.this$0, 9223372036854775806L);
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "delete reminder list count: ", Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.7
 * JD-Core Version:    0.7.0.1
 */