package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ark.ApplicationCallback;
import java.lang.ref.WeakReference;

public class ArkModel
  extends ArkViewModel
{
  private static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.ArkModel";
  private String mAppPath = null;
  public ArkAppInfo.TimeRecord mExtraTimerRecord = new ArkAppInfo.TimeRecord(this.mTimeRecord);
  private WeakReference<ArkModel> mWeakThis = new WeakReference(this);
  
  public ArkModel(ark.ApplicationCallback paramApplicationCallback, boolean paramBoolean)
  {
    super(paramApplicationCallback, paramBoolean);
  }
  
  private void loadArkApp(String paramString1, int paramInt, String paramString2)
  {
    boolean bool1;
    if (paramInt != 0)
    {
      bool1 = true;
      if (paramInt != -2) {
        break label117;
      }
    }
    String str1;
    String str2;
    String str3;
    label117:
    for (boolean bool2 = true;; bool2 = false)
    {
      str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
      str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
      str3 = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
      ArkUtil.createDir(str1);
      ArkUtil.createDir(str2);
      ArkUtil.createDir(str3);
      if (!TextUtils.isEmpty(paramString1)) {
        break label123;
      }
      ENV.logE("ArkApp.ArkModel", String.format("ArkTemp.loadArkApp app=null mAppInfo.appName=%s, mAppInfo.appView=%s, appPath=%s", new Object[] { this.mAppInfo.name, this.mAppInfo.view, paramString1 }));
      return;
      bool1 = false;
      break;
    }
    label123:
    doLoadArkApp(paramString1, str1, str2, str3, bool1, bool2, paramInt, paramString2);
  }
  
  public void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
    ArkDispatchTask.getInstance().postToArkThread(new ArkModel.1(this));
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    this.mExtraTimerRecord.beginOfGetApp = System.currentTimeMillis();
    Object localObject1 = "";
    String str1;
    String str2;
    boolean bool;
    if (!TextUtils.isEmpty(this.mAppPath))
    {
      localObject1 = this.mAppPath;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkModel.2(this, (String)localObject1));
        return true;
      }
    }
    else
    {
      ArkAppMgr.AppPathInfo localAppPathInfo = ArkAppMgr.getInstance().getAppPathInfoByNameFromLocal(this.mAppInfo.name, this.mAppInfo.view, this.mAppInfo.appMinVersion, true);
      str1 = "";
      str2 = "";
      if (localAppPathInfo == null) {
        break label331;
      }
      localObject2 = localAppPathInfo.path;
      localObject1 = localObject2;
      if (localAppPathInfo.appTempInfo == null) {
        break label331;
      }
      str1 = localAppPathInfo.appTempInfo.template;
      str2 = localAppPathInfo.appTempInfo.templateView;
      this.mAppInfo.view = str2;
      localObject1 = localObject2;
      bool = true;
    }
    for (Object localObject2 = str2;; localObject2 = str2)
    {
      ENV.logI("ArkApp.ArkModel", "onLoadApp:mAppInfo.name=" + this.mAppInfo.name + ",view=" + this.mAppInfo.view + ",isTempApp=" + bool + ",template=" + str1 + ",templateView=" + (String)localObject2 + ",appPath=" + (String)localObject1);
      break;
      localObject2 = this.mViewImpl;
      if (localObject2 != null) {
        ((ArkViewImplement)localObject2).onLoading();
      }
      ENV.logI("ArkApp.ArkModel", String.format("onLoadApp:mAppInfo.name=%s,appPath=%s,viewImplement=%h", new Object[] { this.mAppInfo.name, localObject1, localObject2 }));
      ArkAppMgr.getInstance().getAppPathByName(paramAppInfo.name, paramAppInfo.view, paramAppInfo.appMinVersion, null, new ArkModel.AppPathCallback(this.mWeakThis));
      return false;
      label331:
      bool = false;
    }
  }
  
  public void onLoadReport(int paramInt)
  {
    if (this.mAppInfo != null) {
      ArkAppReport.platformEventReport(this.mAppInfo.name, "ArkAppLoadState", paramInt, 0, 0L, 0L, 0L, this.mAppInfo.view, "");
    }
  }
  
  public void setAppPath(String paramString)
  {
    this.mAppPath = paramString;
    ENV.logE("ArkApp.ArkModel", "setAppPath:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkModel
 * JD-Core Version:    0.7.0.1
 */