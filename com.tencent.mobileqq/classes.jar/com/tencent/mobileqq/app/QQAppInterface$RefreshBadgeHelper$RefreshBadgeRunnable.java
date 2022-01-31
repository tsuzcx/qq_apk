package com.tencent.mobileqq.app;

import bhnv;
import com.tencent.qphone.base.util.QLog;

class QQAppInterface$RefreshBadgeHelper$RefreshBadgeRunnable
  implements Runnable
{
  QQAppInterface$RefreshBadgeHelper$RefreshBadgeRunnable(QQAppInterface.RefreshBadgeHelper paramRefreshBadgeHelper) {}
  
  public void a()
  {
    int i;
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l))
    {
      i = 0;
      if (i == QQAppInterface.RefreshBadgeHelper.a(this.a)) {
        break label137;
      }
      QQAppInterface.RefreshBadgeHelper.a(this.a, i);
      bhnv.a(QQAppInterface.j(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), i);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, String.format("unread: %d islogin: %s isReleased: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()), Boolean.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l) }));
      }
    }
    label137:
    while (!QLog.isColorLevel())
    {
      return;
      i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
      break;
    }
    QLog.d("QQAppInterface", 2, "refreshAppBadge fail cause same unreadcount = " + QQAppInterface.RefreshBadgeHelper.a(this.a));
  }
  
  public void run()
  {
    a();
    QQAppInterface.RefreshBadgeHelper localRefreshBadgeHelper = this.a;
    localRefreshBadgeHelper.jdField_a_of_type_Int -= 1;
    QQAppInterface.RefreshBadgeHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable
 * JD-Core Version:    0.7.0.1
 */