package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class SettingMeApolloViewControllerImpl$1
  implements Runnable
{
  SettingMeApolloViewControllerImpl$1(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl) {}
  
  public void run()
  {
    Object localObject = (QQSettingMe)SettingMeApolloViewControllerImpl.access$000(this.this$0).get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while (localObject == null);
    boolean bool = ApolloGameUtil.a((AppRuntime)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("SettingMeApolloViewController", 2, new Object[] { "[updateCmshowStatus] isApolloUser=", Boolean.valueOf(bool) });
    }
    if (bool) {
      this.this$0.getApolloCardAction();
    }
    this.this$0.parseApolloRedTouch();
    this.this$0.showPushInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.SettingMeApolloViewControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */