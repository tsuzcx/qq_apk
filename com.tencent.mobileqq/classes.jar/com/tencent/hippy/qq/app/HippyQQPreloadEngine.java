package com.tencent.hippy.qq.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.hippy.qq.api.IHippyComponentFactory;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.inject.ComponentInjectFactory;
import com.tencent.hippy.qq.utils.HippyErrorManager;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ecshop.view.hippy.api.IQQShopHippyApi;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.hippy.api.IVasHippyApi;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.EngineInitStatus;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;
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
  private int mPreloadSceneType;
  private long mPreloadStartTime;
  private IUpdateListener mUpdateListener = new HippyQQPreloadEngine.3(this);
  
  public HippyQQPreloadEngine(QBaseFragment paramQBaseFragment, String paramString1, String paramString2)
  {
    super(paramQBaseFragment, paramString1, paramString2);
    this.providers.add(((IHippyUtils)QRoute.api(IHippyUtils.class)).getGameCenterHippyAPIProvider());
    this.providers.add(((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).getQQGameHippyAPIProvider());
    paramQBaseFragment = (IQQComicHippyUtil)QRoute.api(IQQComicHippyUtil.class);
    if (paramQBaseFragment.isBoodoModule(paramString1))
    {
      setViewCreator(paramQBaseFragment.createHippyCustomViewCreator());
      this.providers.add(paramQBaseFragment.createHippyAPIProvider());
    }
    this.mMainBundleLoadListener = ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).checkCreateHippyListener(paramString1);
    if (this.mMainBundleLoadListener != null) {
      this.mMainBundleLoadListener.onStart();
    }
    if ("tkdPatrol".equals(paramString1))
    {
      paramQBaseFragment = ComponentInjectFactory.getHippyComponentFactory("tkd");
      setViewCreator(paramQBaseFragment.getViewCreator());
      this.providers.add(paramQBaseFragment.getApiProvider());
    }
    paramQBaseFragment = (IVasHippyApi)QRoute.api(IVasHippyApi.class);
    if (paramQBaseFragment.isVasModule(paramString1))
    {
      setViewCreator(paramQBaseFragment.createHippyCustomViewCreator());
      this.providers.add(paramQBaseFragment.createHippyAPIProvider());
    }
    paramQBaseFragment = (IMiniGamePublicAccountApi)QRoute.api(IMiniGamePublicAccountApi.class);
    if (paramQBaseFragment.isMiniGamePAModule(paramString1)) {
      this.providers.add(paramQBaseFragment.createHippyProvider());
    }
    paramQBaseFragment = (IQQShopHippyApi)QRoute.api(IQQShopHippyApi.class);
    if (paramQBaseFragment.isQQShopModule(paramString1)) {
      this.providers.add(paramQBaseFragment.createHippyProvider());
    }
  }
  
  private final void callBackError(int paramInt, String paramString)
  {
    this.mPreloadEndTime = System.currentTimeMillis();
    if (this.mEngineListener != null) {
      this.mEngineListener.onError(paramInt, paramString);
    }
    if (this.mMainBundleLoadListener != null) {
      this.mMainBundleLoadListener.onMainBundleLoadResult(paramInt, getModuleName(), null, 0);
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
    if ((this.mMainBundleLoadListener != null) && (this.mHippyRootView != null) && (getHippyEngine() != null)) {
      this.mMainBundleLoadListener.onMainBundleLoadResult(0, getModuleName(), getHippyEngine().getEngineContext(), this.mHippyRootView.getId());
    }
    reportPreloadResult(0, null);
    this.mMapLoadStepsTime.clear();
  }
  
  private void checkAndLoad()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAndLoad update:");
    localStringBuilder.append(this.mIsCheckUpdateFinished);
    localStringBuilder.append(" initEngine:");
    localStringBuilder.append(this.mIsInitEngineFinished);
    QLog.i("HippyQQPreloadEngine", 1, localStringBuilder.toString());
    if (this.mIsCheckUpdateFinished)
    {
      if (!this.mIsInitEngineFinished) {
        return;
      }
      if (this.mIsPreloadCreating)
      {
        preloadHippy();
        return;
      }
      loadHippy();
    }
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
      loadModule();
      return;
    }
  }
  
  private void onJsBundleUpdateComplte(int paramInt, String paramString)
  {
    if ((QLog.isColorLevel()) || (paramInt != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onJsBundleUpdateComplte onUpdateComplete retCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" retMsg:");
      localStringBuilder.append(paramString);
      QLog.i("HippyQQPreloadEngine", 2, localStringBuilder.toString());
    }
    if ((paramInt == 2) && (this.mIsPreloadCreating))
    {
      callBackError(paramInt, "preload not allowed");
      return;
    }
    if (isMainThread())
    {
      this.mIsCheckUpdateFinished = true;
      checkAndLoad();
      return;
    }
    ThreadManager.getUIHandler().post(new HippyQQPreloadEngine.2(this));
  }
  
  private void precreateHippy(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.mIsPreloadCreated = true;
    this.mIsPreloadCreating = true;
    this.mPreloadSceneType = paramInt;
    this.mIsPredraw = paramBoolean1;
    this.mPreloadStartTime = System.currentTimeMillis();
    this.mEngineListener = paramHippyQQEngineListener;
    if (((IHippyLibrary)QRoute.api(IHippyLibrary.class)).isLibrayExists()) {
      HippyErrorManager.getInstance().operationStart("loadHippySo");
    }
    ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(this);
    updateJsBundle(paramBoolean2);
  }
  
  private void predrawModule(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Hippy: predrawModule start:");
    ((StringBuilder)localObject).append(getModuleName());
    ((StringBuilder)localObject).append(" this:");
    ((StringBuilder)localObject).append(this);
    QLog.d("Hippy", 1, ((StringBuilder)localObject).toString());
    HippyEngine.ModuleLoadParams localModuleLoadParams = new HippyEngine.ModuleLoadParams();
    localModuleLoadParams.context = MobileQQ.sMobileQQ.getApplicationContext();
    if (TextUtils.isEmpty(this.componentName)) {
      localObject = getModuleName();
    } else {
      localObject = this.componentName;
    }
    localModuleLoadParams.componentName = ((String)localObject);
    localModuleLoadParams.jsFilePath = paramString;
    localModuleLoadParams.nativeParams = getNativeParams();
    localModuleLoadParams.jsParams = getJsParamsMap(localModuleLoadParams);
    this.mModuleVersion = this.mPreloadModuleVersion;
    this.mHippyRootView = getHippyEngine().loadModule(localModuleLoadParams, new HippyQQPreloadEngine.1(this));
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
      int i = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(getModuleName());
      if (i != -1)
      {
        ??? = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleIndex(getModuleName(), i);
        if ((??? != null) && (((File)???).exists()))
        {
          this.mPreloadModuleVersion = i;
          this.mMapLoadStepsTime.put("loadModuleStart", Long.valueOf(System.currentTimeMillis()));
          if (this.mIsPredraw)
          {
            predrawModule(((File)???).getAbsolutePath());
            return;
          }
          preloadModule(((File)???).getAbsolutePath());
          return;
        }
        ((IHippySetting)QRoute.api(IHippySetting.class)).setModuleVersion(getModuleName(), 0);
      }
      callBackError(-20001, "js bundle not exists");
      return;
    }
  }
  
  private void preloadModule(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hippy: preloadModule start:");
    localStringBuilder.append(getModuleName());
    localStringBuilder.append(" this:");
    localStringBuilder.append(this);
    QLog.d("Hippy", 1, localStringBuilder.toString());
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
    ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).removeJsBundleUpdateListener(getModuleName(), this.mUpdateListener);
  }
  
  protected HashMap<String, Long> generatePreloadStepCosts()
  {
    long l4 = this.mPreloadStartTime;
    long l1;
    if (this.mMapLoadStepsTime.containsKey("loadLibEnd")) {
      l1 = ((Long)this.mMapLoadStepsTime.get("loadLibEnd")).longValue();
    } else {
      l1 = 0L;
    }
    long l2;
    if (this.mMapLoadStepsTime.containsKey("initEngineEnd")) {
      l2 = ((Long)this.mMapLoadStepsTime.get("initEngineEnd")).longValue();
    } else {
      l2 = 0L;
    }
    long l3;
    if (this.mMapLoadStepsTime.containsKey("loadModuleStart")) {
      l3 = ((Long)this.mMapLoadStepsTime.get("loadModuleStart")).longValue();
    } else {
      l3 = 0L;
    }
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
    if (l5 > 0L)
    {
      l1 = this.mPreloadStartTime;
      if (l1 > 0L) {
        localLinkedHashMap.put("total", Long.valueOf(l5 - l1));
      }
    }
    return localLinkedHashMap;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initHippyEngine isCanInitHippyEngine:");
    ((StringBuilder)localObject).append(bool);
    QLog.i("HippyQQPreloadEngine", 1, ((StringBuilder)localObject).toString());
    if (!bool) {
      return;
    }
    if ((!TextUtils.isEmpty(getJsBundleType())) && (getJsBundleType().equals("react"))) {
      localObject = "react.android.js";
    } else {
      localObject = "vue.android.js";
    }
    if (TextUtils.isEmpty(((IHippyLibrary)QRoute.api(IHippyLibrary.class)).getCoreJsFilePath((String)localObject)))
    {
      QLog.e("HippyQQPreloadEngine", 1, "initHippyEngine corejs empty");
      return;
    }
    HippyErrorManager.getInstance().operationStart("initHippyEngine");
    super.initHippyEngine();
  }
  
  public void initHippyInContainer(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    if (((IHippyLibrary)QRoute.api(IHippyLibrary.class)).isLibrayExists()) {
      HippyErrorManager.getInstance().operationStart("loadHippySo");
    }
    super.initHippyInContainer(paramViewGroup, paramJSONObject, paramBoolean, paramHippyQQEngineListener);
    updateJsBundle(false);
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
    boolean bool2 = isPreloaded();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((!isReady()) || (((IHippyUpdate)QRoute.api(IHippyUpdate.class)).checkUpdateJsBundleInterval(getModuleName()))) {
      bool1 = true;
    }
    return bool1;
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
        File localFile = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleIndex(getModuleName(), this.mPreloadModuleVersion);
        if ((localFile != null) && (localFile.exists()))
        {
          this.mModuleVersion = this.mPreloadModuleVersion;
          loadModule(localFile.getAbsolutePath());
        }
      }
    }
    else {
      super.loadModule();
    }
  }
  
  protected void onInitEngineComplete(HippyEngine.EngineInitStatus paramEngineInitStatus, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInitEngineComplete statusCode:");
    localStringBuilder.append(paramEngineInitStatus);
    QLog.i("HippyQQPreloadEngine", 1, localStringBuilder.toString());
    this.mIsInitEngineFinished = true;
    HippyErrorManager.getInstance().operationEnd("initHippyEngine");
    if ((QLog.isColorLevel()) || (paramEngineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Hippy: initEngine statusCode=");
      localStringBuilder.append(paramEngineInitStatus);
      localStringBuilder.append(", msg=");
      localStringBuilder.append(paramString);
      QLog.d("Hippy", 1, localStringBuilder.toString());
    }
    if (paramEngineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK)
    {
      callBackError(paramEngineInitStatus.value(), paramString);
      return;
    }
    checkAndLoad();
  }
  
  public void onLoadSuccess()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccess mIsPreloadCreated:");
    localStringBuilder.append(this.mIsPreloadCreated);
    localStringBuilder.append(" mIsPreloadCreating:");
    localStringBuilder.append(this.mIsPreloadCreating);
    QLog.i("HippyQQPreloadEngine", 1, localStringBuilder.toString());
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
  
  public void predrawHippy(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener, boolean paramBoolean, int paramInt)
  {
    precreateHippy(paramHippyQQEngineListener, true, paramBoolean, paramInt);
  }
  
  public void preloadHippy(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener, boolean paramBoolean, int paramInt)
  {
    precreateHippy(paramHippyQQEngineListener, false, paramBoolean, paramInt);
  }
  
  public void setFragment(QBaseFragment paramQBaseFragment)
  {
    this.mFragment = paramQBaseFragment;
  }
  
  protected void updateJsBundle(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateJsBundleBySSO moduleName:");
      ((StringBuilder)localObject).append(getModuleName());
      QLog.i("HippyQQPreloadEngine", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.mIsCheckUpdateFinished)
    {
      if (TextUtils.isEmpty(getModuleName())) {
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isCheckPreload", paramBoolean);
      ((Bundle)localObject).putInt("preloadSceneType", this.mPreloadSceneType);
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).updateJsBundle(getModuleName(), ((IHippyUtils)QRoute.api(IHippyUtils.class)).isUpdateHippyJsBundleByHttp(), 4, (Bundle)localObject, this.mUpdateListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQPreloadEngine
 * JD-Core Version:    0.7.0.1
 */