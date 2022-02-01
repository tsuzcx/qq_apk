package com.tencent.ark.open;

import com.tencent.ark.Logger;
import java.lang.ref.WeakReference;

class ArkModel$AppPathCallback
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<ArkModel> mWeakWrapper;
  
  public ArkModel$AppPathCallback(WeakReference<ArkModel> paramWeakReference)
  {
    this.mWeakWrapper = paramWeakReference;
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    ArkModel localArkModel = (ArkModel)this.mWeakWrapper.get();
    if (localArkModel == null)
    {
      Logger.logE("ArkApp.ArkModel", "onGetAppPathByName.wrapper == null");
      return;
    }
    if (paramAppPathInfo != null) {
      paramAppPathInfo = paramAppPathInfo.path;
    } else {
      paramAppPathInfo = null;
    }
    localArkModel.mExtraTimerRecord.getAppFromLocal = false;
    localArkModel.mExtraTimerRecord.endOfGetApp = System.currentTimeMillis();
    ArkModel.access$100(localArkModel, paramAppPathInfo, ArkModel.access$000(localArkModel), paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkModel.AppPathCallback
 * JD-Core Version:    0.7.0.1
 */