package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public final class ArkAppContainer$AppPathCallback
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<ArkAppContainer> a;
  
  public ArkAppContainer$AppPathCallback(WeakReference<ArkAppContainer> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    ArkAppContainer localArkAppContainer = (ArkAppContainer)this.a.get();
    if (localArkAppContainer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    String str = localArkAppContainer.b(paramString);
    if (paramAppPathInfo != null) {
      paramString = paramAppPathInfo.path;
    } else {
      paramString = null;
    }
    localArkAppContainer.f.getAppFromLocal = false;
    localArkAppContainer.f.endOfGetApp = System.currentTimeMillis();
    ArkAppContainer.a(paramAppPathInfo);
    localArkAppContainer.a(paramString, paramInt, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer.AppPathCallback
 * JD-Core Version:    0.7.0.1
 */