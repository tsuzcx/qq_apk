package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.Logger;
import com.tencent.ark.ark.ApplicationCallback;
import java.lang.ref.WeakReference;

public class ArkModel
  extends ArkViewModel
{
  private static final String TAG = "ArkApp.ArkModel";
  private String mAppPath = null;
  public ArkAppInfo.TimeRecord mExtraTimerRecord = new ArkAppInfo.TimeRecord(this.mTimeRecord);
  private String mResPath = null;
  private final WeakReference<ArkModel> mWeakThis = new WeakReference(this);
  
  public ArkModel(ark.ApplicationCallback paramApplicationCallback, boolean paramBoolean)
  {
    super(paramApplicationCallback, paramBoolean);
  }
  
  private void loadArkApp(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool1;
    if (paramInt != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (paramInt == -2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
    }
    ArkUtil.createDir(str1);
    ArkUtil.createDir(str2);
    ArkUtil.createDir(paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      Logger.logE("ArkApp.ArkModel", String.format("ArkTemp.loadArkApp app=null mAppInfo.appName=%s, mAppInfo.appView=%s, appPath=%s", new Object[] { this.mAppInfo.name, this.mAppInfo.view, paramString1 }));
    }
    doLoadArkApp(paramString1, str1, str2, paramString2, bool1, bool2, paramInt, paramString3);
  }
  
  protected void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
    ArkDispatchTask.getInstance().postToArkThread(new ArkModel.1(this));
  }
  
  protected boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    this.mExtraTimerRecord.beginOfGetApp = System.currentTimeMillis();
    String str;
    if (!TextUtils.isEmpty(this.mAppPath))
    {
      str = this.mAppPath;
    }
    else
    {
      str = ArkAppMgr.getInstance().getAppPathFromCache(this.mAppInfo.name, this.mAppInfo.appMinVersion);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadApp:mAppInfo.name=");
      ((StringBuilder)localObject).append(this.mAppInfo.name);
      ((StringBuilder)localObject).append(",view=");
      ((StringBuilder)localObject).append(this.mAppInfo.view);
      ((StringBuilder)localObject).append(",path=");
      ((StringBuilder)localObject).append(str);
      Logger.logI("ArkApp.ArkModel", ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(str))
    {
      ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkModel.2(this, str));
      return true;
    }
    Object localObject = this.mViewImpl;
    if (localObject != null) {
      ((ArkViewImplement)localObject).onLoading();
    }
    Logger.logI("ArkApp.ArkModel", String.format("onLoadApp:mAppInfo.name=%s,appPath=%s,viewImplement=%h", new Object[] { this.mAppInfo.name, str, localObject }));
    ArkAppMgr.getInstance().getAppPathByName(paramAppInfo.name, paramAppInfo.appMinVersion, new ArkModel.AppPathCallback(this.mWeakThis));
    return false;
  }
  
  public void setAppPath(String paramString)
  {
    this.mAppPath = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAppPath:");
    localStringBuilder.append(paramString);
    Logger.logE("ArkApp.ArkModel", localStringBuilder.toString());
  }
  
  public void setResPath(String paramString)
  {
    this.mResPath = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setResPath:");
    localStringBuilder.append(paramString);
    Logger.logE("ArkApp.ArkModel", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkModel
 * JD-Core Version:    0.7.0.1
 */