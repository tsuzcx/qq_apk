package com.tencent.mobileqq.apollo.drawer.impl;

import android.view.ViewGroup;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.app.QQAppInterface;

class SettingMeApolloViewControllerImpl$10$1
  implements Runnable
{
  SettingMeApolloViewControllerImpl$10$1(SettingMeApolloViewControllerImpl.10 param10, int paramInt, ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (SettingMeApolloViewControllerImpl.access$700(this.e.a) == null) {
      return;
    }
    int i = this.a;
    if (i == 1) {
      SettingMeApolloViewControllerImpl.access$700(this.e.a).a(SettingMeApolloViewControllerImpl.access$900(this.e.a), this.b.getContext(), this.c);
    } else if (i == 2) {
      SettingMeApolloViewControllerImpl.access$700(this.e.a).b(SettingMeApolloViewControllerImpl.access$900(this.e.a), this.b.getContext(), this.c);
    } else {
      SettingMeApolloViewControllerImpl.access$1700(this.e.a, this.d);
    }
    SettingMeApolloViewControllerImpl.access$1800(this.e.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.10.1
 * JD-Core Version:    0.7.0.1
 */