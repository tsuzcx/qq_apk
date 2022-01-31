package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import java.lang.ref.WeakReference;

final class ArkAppMgr$GetAppPathTask
  implements Runnable
{
  public String mAppName;
  public String mAppView;
  public ArkAppMgr.IGetLocalAppPath mCallback;
  public String mMinVersion;
  public WeakReference<ArkAppMgr> mWeakObject;
  
  public ArkAppMgr$GetAppPathTask(ArkAppMgr paramArkAppMgr, String paramString1, String paramString2, String paramString3, ArkAppMgr.IGetLocalAppPath paramIGetLocalAppPath)
  {
    this.mWeakObject = new WeakReference(paramArkAppMgr);
    this.mAppName = paramString1;
    this.mAppView = paramString2;
    this.mMinVersion = paramString3;
    this.mCallback = paramIGetLocalAppPath;
  }
  
  public void run()
  {
    Object localObject = (ArkAppMgr)this.mWeakObject.get();
    if (localObject == null)
    {
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "ArkAppMgr.GetAppPathTask.object.null");
      return;
    }
    localObject = ((ArkAppMgr)localObject).getAppPathByNameFromLocal(this.mAppName, this.mAppView, this.mMinVersion, false);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "ArkAppMgr.GetAppPathTask.path.null");
      return;
    }
    ArkDispatchTask.getInstance().postToMainThread(new ArkAppMgr.GetAppPathTask.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.GetAppPathTask
 * JD-Core Version:    0.7.0.1
 */