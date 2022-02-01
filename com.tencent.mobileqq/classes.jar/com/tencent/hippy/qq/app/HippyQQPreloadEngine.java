package com.tencent.hippy.qq.app;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyErrorManager;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class HippyQQPreloadEngine
  extends HippyQQEngine
{
  protected static final String TAG = "HippyQQPreloadEngine";
  private boolean mIsPrecreated;
  private boolean mIsPreloadCreating;
  protected int mPreloadModuleVersion;
  
  public HippyQQPreloadEngine(Fragment paramFragment, String paramString1, String paramString2)
  {
    super(paramFragment, paramString1, paramString2);
    this.providers.add(new GameCenterApiProvider());
  }
  
  private void preloadModule(String paramString)
  {
    paramString = new HippyFileBundleLoader(paramString, true, getModuleName());
    getHippyEngine().preloadModule(paramString);
    this.mIsPreloadCreating = false;
    this.mMapLoadStepsTime.clear();
    if (this.mEngineListener != null) {
      this.mEngineListener.onSuccess();
    }
  }
  
  private void preloadModule(boolean paramBoolean)
  {
    int i = UpdateSetting.getInstance().getModuleVersion(getModuleName());
    if (i != -1)
    {
      localFile = HippyQQFileUtil.getModuleIndex(getModuleName(), i);
      if ((localFile != null) && (localFile.exists()))
      {
        this.mPreloadModuleVersion = i;
        preloadModule(localFile.getAbsolutePath());
      }
    }
    while (!paramBoolean)
    {
      File localFile;
      return;
    }
    checkPackageUpdate();
  }
  
  protected void doUpdatePackageComplete(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (this.mIsPreloadCreating)
    {
      preloadModule(false);
      return;
    }
    super.doUpdatePackageComplete(paramInt, paramString1, paramString2, paramLong);
  }
  
  public int getPreloadModuleVersion()
  {
    return this.mPreloadModuleVersion;
  }
  
  protected void initHippyEngine()
  {
    if (!isCanInitHippyEngine()) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(getJsBundleType())) && (getJsBundleType().equals("react"))) {}
      for (String str = "react.android.js"; !TextUtils.isEmpty(HippyQQLibraryManager.getInstance().getCoreJsFilePath(str)); str = "vue.android.js")
      {
        HippyErrorManager.getInstance().operationStart("initHippyEngine");
        super.initHippyEngine();
        return;
      }
    }
  }
  
  public void initHippyInContainer(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    if (HippyQQLibraryManager.getInstance().isLibrayExists()) {
      HippyErrorManager.getInstance().operationStart("loadHippySo");
    }
    super.initHippyInContainer(paramViewGroup, paramJSONObject, paramBoolean, paramHippyQQEngineListener);
  }
  
  protected boolean isCanInitHippyEngine()
  {
    if (this.mIsPreloadCreating) {
      return true;
    }
    return super.isCanInitHippyEngine();
  }
  
  public boolean isPrecreated()
  {
    return this.mIsPrecreated;
  }
  
  protected void loadModule()
  {
    if ((this.mIsPrecreated) && (!this.mIsPreloadCreating))
    {
      if (this.mPreloadModuleVersion > 0)
      {
        File localFile = HippyQQFileUtil.getModuleIndex(getModuleName(), this.mPreloadModuleVersion);
        if ((localFile != null) && (localFile.exists()))
        {
          this.mModuleVersion = this.mPreloadModuleVersion;
          loadModule(localFile.getAbsolutePath());
        }
      }
      if (isCanCheckPackageUpdate()) {
        checkPackageUpdate();
      }
      return;
    }
    super.loadModule();
  }
  
  protected void onInitEngineComplete(int paramInt, String paramString)
  {
    HippyErrorManager.getInstance().operationEnd("initHippyEngine");
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.d("Hippy", 1, "Hippy: initEngine statusCode=" + paramInt + ", msg=" + paramString);
    }
    if (paramInt != 0)
    {
      if (this.mEngineListener != null) {
        this.mEngineListener.onError(paramInt, paramString);
      }
      return;
    }
    if (this.mIsPreloadCreating)
    {
      preloadModule(true);
      return;
    }
    loadModule();
  }
  
  public void onLoadSuccess()
  {
    HippyErrorManager.getInstance().operationEnd("loadHippySo");
    if ((this.mIsPrecreated) && (!this.mIsPreloadCreating))
    {
      loadModule();
      return;
    }
    super.onLoadSuccess();
  }
  
  public void preloadEngine(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    this.mIsPrecreated = true;
    this.mIsPreloadCreating = true;
    this.mEngineListener = paramHippyQQEngineListener;
    if (HippyQQLibraryManager.getInstance().isLibrayExists()) {
      HippyErrorManager.getInstance().operationStart("loadHippySo");
    }
    HippyQQLibraryManager.getInstance().loadLibraryIfNeed(this);
  }
  
  public void setFragment(Fragment paramFragment)
  {
    this.mFragment = paramFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQPreloadEngine
 * JD-Core Version:    0.7.0.1
 */