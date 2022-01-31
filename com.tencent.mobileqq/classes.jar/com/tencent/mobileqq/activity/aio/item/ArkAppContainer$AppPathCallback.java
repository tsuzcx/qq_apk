package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public final class ArkAppContainer$AppPathCallback
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference a;
  
  public ArkAppContainer$AppPathCallback(WeakReference paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    paramObject = (ArkAppContainer)this.a.get();
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    String str = paramObject.a(paramString);
    if (paramAppPathInfo != null) {}
    for (paramString = paramAppPathInfo.a;; paramString = null)
    {
      paramObject.a.a = false;
      paramObject.a.b = System.currentTimeMillis();
      paramObject.a(paramString, paramInt, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer.AppPathCallback
 * JD-Core Version:    0.7.0.1
 */