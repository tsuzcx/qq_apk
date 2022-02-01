package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;

final class RecentUtil$5
  implements Runnable
{
  RecentUtil$5(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a != null)
    {
      SubAccountControll.c(this.a);
      SubAccountControll.a(this.a, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.5
 * JD-Core Version:    0.7.0.1
 */