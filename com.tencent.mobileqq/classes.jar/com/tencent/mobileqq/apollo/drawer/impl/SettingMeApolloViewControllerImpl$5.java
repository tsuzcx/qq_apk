package com.tencent.mobileqq.apollo.drawer.impl;

import android.view.ViewGroup;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class SettingMeApolloViewControllerImpl$5
  implements ISpriteDrawerInfoCallback
{
  SettingMeApolloViewControllerImpl$5(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl) {}
  
  public void a()
  {
    if (this.a.mApolloDrawer == null) {
      return;
    }
    QQAppInterface localQQAppInterface = SettingMeApolloViewControllerImpl.access$000(this.a);
    if (localQQAppInterface == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$500(this.a).get();
    if (localViewGroup == null) {
      return;
    }
    if (this.a.mApolloDrawer.a(SettingMeApolloViewControllerImpl.access$700(this.a), this.a.mRoleId, localQQAppInterface, localViewGroup.getContext()) == 0) {
      this.a.mApolloDrawer.a(SettingMeApolloViewControllerImpl.access$700(this.a), localViewGroup.getContext(), localQQAppInterface, this.a.mRoleId);
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
    ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$500(this.a).get();
    if (localViewGroup == null) {
      return;
    }
    if (paramInt1 == 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new SettingMeApolloViewControllerImpl.5.1(this, paramInt2, localViewGroup, localQQAppInterface, paramString));
  }
  
  public void b()
  {
    this.a.destroyApollo();
  }
  
  public void c()
  {
    Object localObject = this.a;
    ((SettingMeApolloViewControllerImpl)localObject).mIsSurfaceReady = true;
    localObject = SettingMeApolloViewControllerImpl.access$000((SettingMeApolloViewControllerImpl)localObject);
    if (localObject == null) {
      return;
    }
    SettingMeApolloViewControllerImpl.access$900(this.a, (QQAppInterface)localObject, "expose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.5
 * JD-Core Version:    0.7.0.1
 */