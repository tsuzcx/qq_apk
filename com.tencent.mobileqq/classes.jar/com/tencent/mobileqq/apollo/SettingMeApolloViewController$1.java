package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SettingMeApolloViewController$1
  implements Runnable
{
  SettingMeApolloViewController$1(SettingMeApolloViewController paramSettingMeApolloViewController) {}
  
  public void run()
  {
    Object localObject = (QQSettingMe)SettingMeApolloViewController.a(this.this$0).get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while (localObject == null);
    boolean bool = ApolloGameUtil.a((QQAppInterface)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("SettingMeApolloViewController", 2, new Object[] { "[updateCmshowStatus] isApolloUser=", Boolean.valueOf(bool) });
    }
    if (bool) {
      this.this$0.b();
    }
    this.this$0.c();
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController.1
 * JD-Core Version:    0.7.0.1
 */