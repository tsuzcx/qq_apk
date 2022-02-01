package com.tencent.hippy.qq.app;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.HippyUpdateManager.IUpdateListener;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyErrorManager;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.BoodoHippyBirdge;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class HippyQQPreloadEngine
  extends HippyQQEngine
{
  public static final int STATUS_JSBUNDLE_NOT_EXISTS = -20001;
  protected static final String TAG = "HippyQQPreloadEngine";
  private Object mCheckAndLoadLock = new Object();
  private boolean mIsCheckUpdateFinished = false;
  private boolean mIsInitEngineFinished = false;
  private boolean mIsLoaded = false;
  private boolean mIsPredraw;
  private boolean mIsPreloadCreated;
  private boolean mIsPreloadCreating;
  private boolean mIsPreloaded = false;
  private long mPreloadEndTime;
  protected int mPreloadModuleVersion = 0;
  private long mPreloadStartTime;
  private HippyUpdateManager.IUpdateListener mUpdateListener = new HippyQQPreloadEngine.3(this);
  
  public HippyQQPreloadEngine(Fragment paramFragment, String paramString1, String paramString2)
  {
    super(paramFragment, paramString1, paramString2);
    this.providers.add(new GameCenterApiProvider());
    if (BoodoHippyBirdge.a(paramString1))
    {
      setViewCreator(new QQCustomViewCreator());
      this.providers.add(new BoodoApiProvider());
    }
  }
  
  private final void callBackError(int paramInt, String paramString)
  {
    this.mPreloadEndTime = System.currentTimeMillis();
    if (this.mEngineListener != null) {
      this.mEngineListener.onError(paramInt, paramString);
    }
    reportPreloadResult(paramInt, paramString);
    this.mMapLoadStepsTime.clear();
  }
  
  private final void callBackSuccess()
  {
    this.mPreloadEndTime = System.currentTimeMillis();
    if (this.mEngineListener != null) {
      this.mEngineListener.onSuccess();
    }
    reportPreloadResult(0, null);
    this.mMapLoadStepsTime.clear();
  }
  
  private void checkAndLoad()
  {
    QLog.i("HippyQQPreloadEngine", 1, "checkAndLoad update:" + this.mIsCheckUpdateFinished + " initEngine:" + this.mIsInitEngineFinished);
    if ((!this.mIsCheckUpdateFinished) || (!this.mIsInitEngineFinished)) {
      return;
    }
    if (this.mIsPreloadCreating)
    {
      preloadHippy();
      return;
    }
    loadHippy();
  }
  
  private void loadHippy()
  {
    synchronized (this.mCheckAndLoadLock)
    {
      if (this.mIsLoaded)
      {
        QLog.i("HippyQQPreloadEngine", 1, "loadHippy has loaded.");
        return;
      }
      this.mIsLoaded = true;
      if (isPredraw())
      {
        if (this.mHippyRootView.getParent() == null) {
          this.mContainer.addView(this.mHippyRootView);
        }
        this.mMapLoadStepsTime.put("loadModuleEnd", Long.valueOf(System.currentTimeMillis()));
        this.mModuleVersion = this.mPreloadModuleVersion;
        callBackSuccess();
        return;
      }
    }
    loadModule();
  }
  
  private void onJsBundleUpdateComplte(int paramInt, String paramString)
  {
    this.mIsCheckUpdateFinished = true;
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.i("HippyQQPreloadEngine", 2, "onJsBundleUpdateComplte onUpdateComplete retCode:" + paramInt + " retMsg:" + paramString);
    }
    if (isMainThread())
    {
      checkAndLoad();
      return;
    }
    ThreadManager.getUIHandler().post(new HippyQQPreloadEngine.2(this));
  }
  
  private void precreateHippy(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener, boolean paramBoolean)
  {
    this.mIsPreloadCreated = true;
    this.mIsPreloadCreating = true;
    this.mIsPredraw = paramBoolean;
    this.mPreloadStartTime = System.currentTimeMillis();
    this.mEngineListener = paramHippyQQEngineListener;
    if (HippyQQLibraryManager.getInstance().isLibrayExists()) {
      HippyErrorManager.getInstance().operationStart("loadHippySo");
    }
    HippyQQLibraryManager.getInstance().loadLibraryIfNeed(this);
    updateJsBundle();
  }
  
  private void predrawModule(String paramString)
  {
    QLog.d("Hippy", 1, "Hippy: predrawModule start:" + getModuleName());
    HippyEngine.ModuleLoadParams localModuleLoadParams = new HippyEngine.ModuleLoadParams();
    localModuleLoadParams.context = BaseApplicationImpl.getContext().getApplicationContext();
    if (TextUtils.isEmpty(this.componentName)) {}
    for (String str = getModuleName();; str = this.componentName)
    {
      localModuleLoadParams.componentName = str;
      localModuleLoadParams.jsFilePath = paramString;
      localModuleLoadParams.nativeParams = getNativeParams();
      localModuleLoadParams.jsParams = getJsParamsMap(localModuleLoadParams);
      this.mModuleVersion = this.mPreloadModuleVersion;
      this.mHippyRootView = getHippyEngine().loadModule(localModuleLoadParams, new HippyQQPreloadEngine.1(this));
      return;
    }
  }
  
  private void preloadHippy()
  {
    synchronized (this.mCheckAndLoadLock)
    {
      if (this.mIsPreloaded)
      {
        QLog.i("HippyQQPreloadEngine", 1, "preloadHippy has preloaded.");
        return;
      }
      this.mIsPreloaded = true;
      int i = UpdateSetting.getInstance().getModuleVersion(getModuleName());
      if (i == -1) {
        break label132;
      }
      ??? = HippyQQFileUtil.getModuleIndex(getModuleName(), i);
      if ((??? == null) || (!((File)???).exists())) {
        break label121;
      }
      this.mPreloadModuleVersion = i;
      this.mMapLoadStepsTime.put("loadModuleStart", Long.valueOf(System.currentTimeMillis()));
      if (this.mIsPredraw)
      {
        predrawModule(((File)???).getAbsolutePath());
        return;
      }
    }
    preloadModule(((File)???).getAbsolutePath());
    return;
    label121:
    UpdateSetting.getInstance().setModuleVersion(getModuleName(), 0);
    label132:
    callBackError(-20001, "js bundle not exists");
  }
  
  private void preloadModule(String paramString)
  {
    paramString = new HippyFileBundleLoader(paramString, true, getModuleName());
    getHippyEngine().preloadModule(paramString);
    this.mIsPreloadCreating = false;
    callBackSuccess();
  }
  
  private final void reportPreloadResult(int paramInt, String paramString)
  {
    HashMap localHashMap1 = generatePreloadStepCosts();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("ret", Integer.valueOf(paramInt));
    localHashMap2.put("errMsg", paramString);
    localHashMap2.put("isPreload", Boolean.valueOf(isPreloaded()));
    localHashMap2.put("isPredraw", Boolean.valueOf(isPredraw()));
    HippyReporter.getInstance().reportHippyLoadResult(10, getModuleName(), getPreloadModuleVersion(), localHashMap2, localHashMap1);
  }
  
  protected void destoryEngine()
  {
    super.destoryEngine();
    HippyUpdateManager.getInstance().removeJsBundleUpdateListener(getModuleName(), this.mUpdateListener);
  }
  
  protected HashMap<String, Long> generatePreloadStepCosts()
  {
    long l4 = this.mPreloadStartTime;
    long l1;
    long l2;
    if (this.mMapLoadStepsTime.containsKey("loadLibEnd"))
    {
      l1 = ((Long)this.mMapLoadStepsTime.get("loadLibEnd")).longValue();
      if (!this.mMapLoadStepsTime.containsKey("initEngineEnd")) {
        break label271;
      }
      l2 = ((Long)this.mMapLoadStepsTime.get("initEngineEnd")).longValue();
      label66:
      if (!this.mMapLoadStepsTime.containsKey("loadModuleStart")) {
        break label276;
      }
    }
    label271:
    label276:
    for (long l3 = ((Long)this.mMapLoadStepsTime.get("loadModuleStart")).longValue();; l3 = 0L)
    {
      long l5 = this.mPreloadEndTime;
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      if ((l1 > 0L) && (l4 > 0L)) {
        localLinkedHashMap.put("loadLibrary", Long.valueOf(l1 - l4));
      }
      if ((l2 > 0L) && (l1 > 0L)) {
        localLinkedHashMap.put("initEngine", Long.valueOf(l2 - l1));
      }
      if ((l3 > 0L) && (l2 > 0L)) {
        localLinkedHashMap.put("checkJsBundle", Long.valueOf(l3 - l2));
      }
      if ((l5 > 0L) && (l3 > 0L)) {
        localLinkedHashMap.put("loadJsBundle", Long.valueOf(l5 - l3));
      }
      if ((l5 > 0L) && (this.mPreloadStartTime > 0L)) {
        localLinkedHashMap.put("total", Long.valueOf(l5 - this.mPreloadStartTime));
      }
      return localLinkedHashMap;
      l1 = 0L;
      break;
      l2 = 0L;
      break label66;
    }
  }
  
  public HippyRootView getPredrawHippyRootView()
  {
    if (isPredraw()) {
      return this.mHippyRootView;
    }
    return null;
  }
  
  public int getPreloadModuleVersion()
  {
    return this.mPreloadModuleVersion;
  }
  
  protected void initHippyEngine()
  {
    boolean bool = isCanInitHippyEngine();
    QLog.i("HippyQQPreloadEngine", 1, "initHippyEngine isCanInitHippyEngine:" + bool);
    if (!bool) {
      return;
    }
    if ((!TextUtils.isEmpty(getJsBundleType())) && (getJsBundleType().equals("react"))) {}
    for (String str = "react.android.js"; TextUtils.isEmpty(HippyQQLibraryManager.getInstance().getCoreJsFilePath(str)); str = "vue.android.js")
    {
      QLog.e("HippyQQPreloadEngine", 1, "initHippyEngine corejs empty");
      return;
    }
    HippyErrorManager.getInstance().operationStart("initHippyEngine");
    super.initHippyEngine();
  }
  
  public void initHippyInContainer(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    if (HippyQQLibraryManager.getInstance().isLibrayExists()) {
      HippyErrorManager.getInstance().operationStart("loadHippySo");
    }
    super.initHippyInContainer(paramViewGroup, paramJSONObject, paramBoolean, paramHippyQQEngineListener);
    updateJsBundle();
  }
  
  protected boolean isCanCheckPackageUpdate()
  {
    return false;
  }
  
  protected boolean isCanInitHippyEngine()
  {
    if (this.mIsPreloadCreating) {
      return true;
    }
    return super.isCanInitHippyEngine();
  }
  
  public boolean isNeedShowLoading()
  {
    if (isPreloaded()) {}
    while ((isReady()) && (!HippyUpdateManager.getInstance().checkUpdateJsBundleInterval(getModuleName()))) {
      return false;
    }
    return true;
  }
  
  public boolean isPredraw()
  {
    return (this.mIsPreloadCreated) && (this.mIsPredraw);
  }
  
  public boolean isPreloaded()
  {
    return this.mIsPreloadCreated;
  }
  
  protected void loadModule()
  {
    if ((this.mIsPreloadCreated) && (!this.mIsPreloadCreating))
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
      return;
    }
    super.loadModule();
  }
  
  protected void onInitEngineComplete(int paramInt, String paramString)
  {
    QLog.i("HippyQQPreloadEngine", 1, "onInitEngineComplete statusCode:" + paramInt);
    this.mIsInitEngineFinished = true;
    HippyErrorManager.getInstance().operationEnd("initHippyEngine");
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.d("Hippy", 1, "Hippy: initEngine statusCode=" + paramInt + ", msg=" + paramString);
    }
    if (paramInt != 0)
    {
      callBackError(paramInt, paramString);
      return;
    }
    checkAndLoad();
  }
  
  public void onLoadSuccess()
  {
    QLog.i("HippyQQPreloadEngine", 1, "onLoadSuccess mIsPreloadCreated:" + this.mIsPreloadCreated + " mIsPreloadCreating:" + this.mIsPreloadCreating);
    HippyErrorManager.getInstance().operationEnd("loadHippySo");
    if ((this.mIsPreloadCreated) && (!this.mIsPreloadCreating))
    {
      checkAndLoad();
      return;
    }
    super.onLoadSuccess();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void predrawHippy(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    precreateHippy(paramHippyQQEngineListener, true);
  }
  
  public void preloadHippy(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    precreateHippy(paramHippyQQEngineListener, false);
  }
  
  public void setFragment(Fragment paramFragment)
  {
    this.mFragment = paramFragment;
  }
  
  protected void updateJsBundle()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyQQPreloadEngine", 2, "updateJsBundleBySSO moduleName:" + getModuleName());
    }
    if ((this.mIsCheckUpdateFinished) || (TextUtils.isEmpty(getModuleName()))) {
      return;
    }
    HippyUpdateManager.getInstance().updateJsBundle(getModuleName(), QQGameConfigUtil.i(), 4, this.mUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQPreloadEngine
 * JD-Core Version:    0.7.0.1
 */