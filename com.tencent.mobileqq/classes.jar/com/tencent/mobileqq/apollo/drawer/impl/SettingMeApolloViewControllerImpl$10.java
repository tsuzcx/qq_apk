package com.tencent.mobileqq.apollo.drawer.impl;

import android.view.ViewGroup;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class SettingMeApolloViewControllerImpl$10
  implements ISpriteDrawerInfoCallback
{
  SettingMeApolloViewControllerImpl$10(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl) {}
  
  public void a()
  {
    if (SettingMeApolloViewControllerImpl.access$700(this.a) == null) {
      return;
    }
    QQAppInterface localQQAppInterface = SettingMeApolloViewControllerImpl.access$000(this.a);
    if (localQQAppInterface == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$600(this.a).get();
    if (localViewGroup == null) {
      return;
    }
    if (SettingMeApolloViewControllerImpl.access$700(this.a).a(SettingMeApolloViewControllerImpl.access$900(this.a), SettingMeApolloViewControllerImpl.access$1000(this.a), localQQAppInterface, localViewGroup.getContext()) == 0) {
      SettingMeApolloViewControllerImpl.access$700(this.a).a(SettingMeApolloViewControllerImpl.access$900(this.a), localViewGroup.getContext(), localQQAppInterface, SettingMeApolloViewControllerImpl.access$1000(this.a));
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, new Object[] { "[onApolloClick] ", "apolloStatus:", Integer.valueOf(paramInt1), ",clickPart:", Integer.valueOf(paramInt2), ",apolloId:", paramString });
    }
    QQAppInterface localQQAppInterface = SettingMeApolloViewControllerImpl.access$000(this.a);
    if (localQQAppInterface == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$600(this.a).get();
    if (localViewGroup == null) {
      return;
    }
    if (paramInt1 == 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new SettingMeApolloViewControllerImpl.10.1(this, paramInt2, localViewGroup, localQQAppInterface, paramString));
  }
  
  public void b()
  {
    this.a.destroyApollo();
  }
  
  public void c()
  {
    SettingMeApolloViewControllerImpl.access$1902(this.a, true);
    QQAppInterface localQQAppInterface = SettingMeApolloViewControllerImpl.access$000(this.a);
    if (localQQAppInterface == null) {
      return;
    }
    SettingMeApolloViewControllerImpl.access$2000(this.a, localQQAppInterface, "expose");
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.10
 * JD-Core Version:    0.7.0.1
 */