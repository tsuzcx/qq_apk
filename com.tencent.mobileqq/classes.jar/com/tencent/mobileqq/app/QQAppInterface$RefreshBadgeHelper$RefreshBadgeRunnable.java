package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

class QQAppInterface$RefreshBadgeHelper$RefreshBadgeRunnable
  implements Runnable
{
  QQAppInterface$RefreshBadgeHelper$RefreshBadgeRunnable(QQAppInterface.RefreshBadgeHelper paramRefreshBadgeHelper) {}
  
  public void doRun()
  {
    int i;
    if ((!this.this$1.this$0.isLogin()) || (this.this$1.this$0.isReleased))
    {
      i = 0;
      if (i == QQAppInterface.RefreshBadgeHelper.access$2900(this.this$1)) {
        break label137;
      }
      QQAppInterface.RefreshBadgeHelper.access$2902(this.this$1, i);
      BadgeUtils.a(QQAppInterface.access$3000(this.this$1.this$0), i);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, String.format("unread: %d islogin: %s isReleased: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.this$1.this$0.isLogin()), Boolean.valueOf(this.this$1.this$0.isReleased) }));
      }
    }
    label137:
    while (!QLog.isColorLevel())
    {
      return;
      i = this.this$1.this$0.getAppBadgeCount();
      break;
    }
    QLog.d("QQAppInterface", 2, "refreshAppBadge fail cause same unreadcount = " + QQAppInterface.RefreshBadgeHelper.access$2900(this.this$1));
  }
  
  public void run()
  {
    doRun();
    QQAppInterface.RefreshBadgeHelper localRefreshBadgeHelper = this.this$1;
    localRefreshBadgeHelper.mRunningTaskNum -= 1;
    QQAppInterface.RefreshBadgeHelper.access$2800(this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable
 * JD-Core Version:    0.7.0.1
 */