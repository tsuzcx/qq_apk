package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderOrderModel;
import java.util.Comparator;

class ActivateFriendActivity$4
  implements Comparator<QQReminderOrderModel>
{
  ActivateFriendActivity$4(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(QQReminderOrderModel paramQQReminderOrderModel1, QQReminderOrderModel paramQQReminderOrderModel2)
  {
    long l = paramQQReminderOrderModel2.a - paramQQReminderOrderModel1.a;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.4
 * JD-Core Version:    0.7.0.1
 */