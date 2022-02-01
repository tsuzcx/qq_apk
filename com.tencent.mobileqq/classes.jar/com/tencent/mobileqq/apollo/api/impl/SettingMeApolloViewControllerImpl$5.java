package com.tencent.mobileqq.apollo.api.impl;

import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQSettingMe;
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
    if (this.a.mApolloDrawer == null) {}
    Object localObject;
    ViewGroup localViewGroup;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQSettingMe)SettingMeApolloViewControllerImpl.access$000(this.a).get();
        } while (localObject == null);
        localObject = ((QQSettingMe)localObject).a();
      } while (localObject == null);
      localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$100(this.a).get();
    } while ((localViewGroup == null) || (this.a.mApolloDrawer.a(SettingMeApolloViewControllerImpl.access$300(this.a), this.a.mRoleId, (AppInterface)localObject, localViewGroup.getContext()) != 0));
    this.a.mApolloDrawer.a(SettingMeApolloViewControllerImpl.access$300(this.a), localViewGroup.getContext(), (QQAppInterface)localObject, this.a.mRoleId);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SettingMeApolloViewController", 2, new Object[] { "[onApolloClick] ", "apolloStatus:", Integer.valueOf(paramInt1), ",clickPart:", Integer.valueOf(paramInt2), ",apolloId:", paramString });
    }
    Object localObject = (QQSettingMe)SettingMeApolloViewControllerImpl.access$000(this.a).get();
    if (localObject == null) {}
    ViewGroup localViewGroup;
    do
    {
      do
      {
        return;
        localObject = ((QQSettingMe)localObject).a();
      } while (localObject == null);
      localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$100(this.a).get();
    } while ((localViewGroup == null) || (paramInt1 == 0));
    ThreadManager.getUIHandler().post(new SettingMeApolloViewControllerImpl.5.1(this, paramInt2, localViewGroup, (QQAppInterface)localObject, paramString));
  }
  
  public void b()
  {
    this.a.destroyApollo();
  }
  
  public void c()
  {
    this.a.mIsSurfaceReady = true;
    Object localObject = (QQSettingMe)SettingMeApolloViewControllerImpl.access$000(this.a).get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while (localObject == null);
    SettingMeApolloViewControllerImpl.access$500(this.a, (QQAppInterface)localObject, "expose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.SettingMeApolloViewControllerImpl.5
 * JD-Core Version:    0.7.0.1
 */