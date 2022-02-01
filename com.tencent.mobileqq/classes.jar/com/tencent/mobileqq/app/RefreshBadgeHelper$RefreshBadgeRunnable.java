package com.tencent.mobileqq.app;

import com.tencent.mobileqq.util.api.IBadgeCountInjector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import mqq.app.AppRuntime;

class RefreshBadgeHelper$RefreshBadgeRunnable
  implements Runnable
{
  RefreshBadgeHelper$RefreshBadgeRunnable(RefreshBadgeHelper paramRefreshBadgeHelper) {}
  
  public void a()
  {
    int i;
    if ((RefreshBadgeHelper.b(this.this$0).isLogin()) && (!RefreshBadgeHelper.c(this.this$0))) {
      i = RefreshBadgeHelper.d(this.this$0).a();
    } else {
      i = 0;
    }
    if (i != RefreshBadgeHelper.e(this.this$0))
    {
      RefreshBadgeHelper.a(this.this$0, i);
      BadgeUtils.a(RefreshBadgeHelper.b(this.this$0).getApplicationContext(), i);
      if (QLog.isColorLevel()) {
        QLog.d("RefreshBadgeHelper", 2, String.format("unread: %d islogin: %s isReleased: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(RefreshBadgeHelper.b(this.this$0).isLogin()), Boolean.valueOf(RefreshBadgeHelper.c(this.this$0)) }));
      }
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAppBadge fail cause same unreadcount = ");
      localStringBuilder.append(RefreshBadgeHelper.e(this.this$0));
      QLog.d("RefreshBadgeHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void run()
  {
    a();
    RefreshBadgeHelper localRefreshBadgeHelper = this.this$0;
    localRefreshBadgeHelper.b -= 1;
    RefreshBadgeHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RefreshBadgeHelper.RefreshBadgeRunnable
 * JD-Core Version:    0.7.0.1
 */