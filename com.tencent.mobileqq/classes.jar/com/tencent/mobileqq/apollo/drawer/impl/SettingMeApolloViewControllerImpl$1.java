package com.tencent.mobileqq.apollo.drawer.impl;

import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class SettingMeApolloViewControllerImpl$1
  implements Runnable
{
  SettingMeApolloViewControllerImpl$1(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = SettingMeApolloViewControllerImpl.access$000(this.this$0);
    if (localQQAppInterface == null) {
      return;
    }
    boolean bool = ApolloUtilImpl.isApolloUser(localQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, new Object[] { "[updateCmshowStatus] isApolloUser=", Boolean.valueOf(bool) });
    }
    if (bool)
    {
      SettingMeApolloViewControllerImpl.access$100(this.this$0);
      SettingMeApolloViewControllerImpl.access$200(this.this$0);
    }
    SettingMeApolloViewControllerImpl.access$300(this.this$0);
    SettingMeApolloViewControllerImpl.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */