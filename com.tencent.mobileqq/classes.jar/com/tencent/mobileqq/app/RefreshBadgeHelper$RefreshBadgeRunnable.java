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
    if ((RefreshBadgeHelper.a(this.this$0).isLogin()) && (!RefreshBadgeHelper.a(this.this$0))) {
      i = RefreshBadgeHelper.a(this.this$0).a();
    } else {
      i = 0;
    }
    if (i != RefreshBadgeHelper.a(this.this$0))
    {
      RefreshBadgeHelper.a(this.this$0, i);
      BadgeUtils.a(RefreshBadgeHelper.a(this.this$0).getApplicationContext(), i);
      if (QLog.isColorLevel()) {
        QLog.d("RefreshBadgeHelper", 2, String.format("unread: %d islogin: %s isReleased: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(RefreshBadgeHelper.a(this.this$0).isLogin()), Boolean.valueOf(RefreshBadgeHelper.a(this.this$0)) }));
      }
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAppBadge fail cause same unreadcount = ");
      localStringBuilder.append(RefreshBadgeHelper.a(this.this$0));
      QLog.d("RefreshBadgeHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void run()
  {
    a();
    RefreshBadgeHelper localRefreshBadgeHelper = this.this$0;
    localRefreshBadgeHelper.a -= 1;
    RefreshBadgeHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.RefreshBadgeHelper.RefreshBadgeRunnable
 * JD-Core Version:    0.7.0.1
 */