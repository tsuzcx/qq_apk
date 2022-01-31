package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;
import java.lang.ref.WeakReference;

class ArkModel$AppPathCallback
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<ArkModel> mWeakWrapper;
  
  public ArkModel$AppPathCallback(WeakReference<ArkModel> paramWeakReference)
  {
    this.mWeakWrapper = paramWeakReference;
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    ArkModel localArkModel = (ArkModel)this.mWeakWrapper.get();
    if (localArkModel == null)
    {
      ArkModel.access$000().logE("ArkApp.ArkModel", "onGetAppPathByName.wrapper == null");
      return;
    }
    if (paramAppPathInfo != null) {}
    for (paramObject = paramAppPathInfo.path;; paramObject = null)
    {
      localArkModel.mExtraTimerRecord.getAppFromLocal = false;
      localArkModel.mExtraTimerRecord.endOfGetApp = System.currentTimeMillis();
      if ((paramAppPathInfo != null) && (paramAppPathInfo.appTempInfo != null))
      {
        paramAppPathInfo = paramAppPathInfo.appTempInfo.templateView;
        ArkModel.access$100(localArkModel).view = paramAppPathInfo;
      }
      ArkModel.access$200(localArkModel, paramObject, paramInt, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkModel.AppPathCallback
 * JD-Core Version:    0.7.0.1
 */