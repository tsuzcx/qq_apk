package com.tencent.hippy.qq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.hippy.qq.api.IHippyComponentFactory;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.inject.ComponentInjectFactory;
import com.tencent.hippy.qq.utils.HippyErrorManager;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.apollo.aio.panel.api.IApolloPanelProvider;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ecshop.view.hippy.api.IQQShopHippyApi;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.newnearby.hippy.INearbyHippyApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.hippy.api.IVasHippyApi;
import com.tencent.mobileqq.weather.api.IWeatherHippyApi;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.EngineInitStatus;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
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
  public static final String EVENT_JS_BUNDLE_UPDATED = "JsBundleUpdated";
  public static final int STATUS_JSBUNDLE_NOT_EXISTS = -20001;
  public static final int STATUS_LOW_MEMORY = -20002;
  protected static final String TAG = "HippyQQPreloadEngine";
  private Object mCheckAndLoadLock = new Object();
  private boolean mIsCheckUpdateFinished = false;
  private boolean mIsHippyLoaded = false;
  private boolean mIsInitEngineFinished = false;
  private boolean mIsPredraw;
  private boolean mIsPreload;
  private boolean mIsPreloadCreating;
  private boolean mIsPreloadFinished = false;
  private long mPreloadEndTime;
  private String mPreloadFrom;
  protected int mPreloadModuleVersion = 0;
  private int mPreloadSceneType;
  private long mPreloadStartTime;
  protected int mUpdateJsBundleType = 0;
  private IUpdateListener mUpdateListener = new HippyQQPreloadEngine.3(this);
  
  public HippyQQPreloadEngine(QBaseFragment paramQBaseFragment, Activity paramActivity, String paramString1, String paramString2)
  {
    super(paramActivity, paramString1, paramString2);
    initPreloadEngine(paramString1);
  }
  
  public HippyQQPreloadEngine(QBaseFragment paramQBaseFragment, String paramString1, String paramString2)
  {
    super(paramQBaseFragment, paramString1, paramString2);
    initPreloadEngine(paramString1);
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
    if (!this.mIsHippyLoaded) {
      this.mMapLoadStepsTime.clear();
    }
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
    if (!this.mIsHippyLoaded) {
      this.mMapLoadStepsTime.clear();
    }
  }
  
  private void checkAndLoad()
  {
    if (!isReadyToLoadHippy()) {
      return;
    }
    if (this.mIsPreloadCreating)
    {
      preloadHippy();
      return;
    }
    loadHippy();
  }
  
  private long getValueFromStepCosts(String paramString, HashMap<String, Long> paramHashMap)
  {
    if (paramHashMap.containsKey(paramString)) {
      return ((Long)paramHashMap.get(paramString)).longValue();
    }
    return 0L;
  }
  
  private void initPreloadEngine(String paramString)
  {
    HippyUtils.addGameCenterApiProvider(this.providers);
    Object localObject = (IQQComicHippyUtil)QRoute.api(IQQComicHippyUtil.class);
    if (((IQQComicHippyUtil)localObject).isBoodoModule(paramString))
    {
      setViewCreator(((IQQComicHippyUtil)localObject).createHippyCustomViewCreator());
      this.providers.add(((IQQComicHippyUtil)localObject).createHippyAPIProvider());
    }
    this.mMainBundleLoadListener = ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).checkCreateHippyListener(paramString);
    if (this.mMainBundleLoadListener != null) {
      this.mMainBundleLoadListener.onStart();
    }
    if ("tkdPatrol".equals(paramString))
    {
      localObject = ComponentInjectFactory.getHippyComponentFactory("tkd");
      setViewCreator(((IHippyComponentFactory)localObject).getViewCreator());
      this.providers.add(((IHippyComponentFactory)localObject).getApiProvider());
    }
    localObject = (IVasHippyApi)QRoute.api(IVasHippyApi.class);
    if (((IVasHippyApi)localObject).isVasModuleNeedToBeAdd(paramString))
    {
      setViewCreator(((IVasHippyApi)localObject).createHippyCustomViewCreator());
      this.providers.add(((IVasHippyApi)localObject).createHippyAPIProvider());
    }
    localObject = (IApolloPanelProvider)QRoute.api(IApolloPanelProvider.class);
    if (((IApolloPanelProvider)localObject).isCMModule(paramString)) {
      this.providers.add(((IApolloPanelProvider)localObject).createHippyProvider());
    }
    localObject = (IMiniGamePublicAccountApi)QRoute.api(IMiniGamePublicAccountApi.class);
    if (((IMiniGamePublicAccountApi)localObject).isMiniGamePAModule(paramString)) {
      this.providers.add(((IMiniGamePublicAccountApi)localObject).createHippyProvider());
    }
    localObject = (IQQShopHippyApi)QRoute.api(IQQShopHippyApi.class);
    if (((IQQShopHippyApi)localObject).isQQShopModule(paramString)) {
      this.providers.add(((IQQShopHippyApi)localObject).createHippyProvider());
    }
    localObject = (IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class);
    if (((IQQGameHippyApi)localObject).isQQGamePubHippyV2(paramString)) {
      setViewCreator(((IQQGameHippyApi)localObject).getQQGameHippyViewCreator());
    }
    this.providers.add(((IQQGameHippyApi)localObject).getQQGameHippyAPIProvider());
    localObject = (IWeatherHippyApi)QRoute.api(IWeatherHippyApi.class);
    if (((IWeatherHippyApi)localObject).isWeatherModule(paramString)) {
      this.providers.add(((IWeatherHippyApi)localObject).createHippyProvider());
    }
    localObject = (INearbyHippyApi)QRoute.api(INearbyHippyApi.class);
    if (((INearbyHippyApi)localObject).isNearbyModule(paramString)) {
      this.providers.add(((INearbyHippyApi)localObject).getNearbyHippyAPIProvider());
    }
  }
  
  private boolean isLowMemory()
  {
    ActivityManager localActivityManager = (ActivityManager)MobileQQ.getContext().getApplicationContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.lowMemory;
  }
  
  private boolean isReadyToLoadHippy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isReadyToLoadHippy update:");
    localStringBuilder.append(this.mIsCheckUpdateFinished);
    localStringBuilder.append(" initEngine:");
    localStringBuilder.append(this.mIsInitEngineFinished);
    localStringBuilder.append(" updateJsType:");
    localStringBuilder.append(this.mUpdateJsBundleType);
    QLog.i("HippyQQPreloadEngine", 1, localStringBuilder.toString());
    if (this.mUpdateJsBundleType != 1) {
      return (this.mIsCheckUpdateFinished) && (this.mIsInitEngineFinished);
    }
    if (this.mIsPreload) {
      return (this.mIsCheckUpdateFinished) && (this.mIsInitEngineFinished);
    }
    return (this.mIsInitEngineFinished) && (((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(getModuleName()) >= 0);
  }
  
  private void loadHippy()
  {
    synchronized (this.mCheckAndLoadLock)
    {
      if (this.mIsHippyLoaded)
      {
        QLog.i("HippyQQPreloadEngine", 1, "loadHippy has loaded.");
        return;
      }
      this.mIsHippyLoaded = true;
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
      localStringBuilder.append("onJsBundleUpdateComplte retCode:");
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
    }
    else
    {
      ThreadManager.getUIHandler().post(new HippyQQPreloadEngine.2(this));
    }
    if ((!this.mIsPreload) && (this.mIsInitEngineFinished) && (this.mUpdateJsBundleType == 1) && ((paramInt == 0) || (paramInt == 101)))
    {
      paramString = new HippyMap();
      paramString.pushString("bundleName", getModuleName());
      paramString.pushInt("newVersion", ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(getModuleName()));
      sendEvent("JsBundleUpdated", paramString);
    }
  }
  
  private void precreateHippy(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.mIsPreload = true;
    this.mIsPreloadCreating = true;
    this.mPreloadSceneType = paramInt;
    this.mIsPredraw = paramBoolean1;
    this.mPreloadStartTime = System.currentTimeMillis();
    this.mEngineListener = paramHippyQQEngineListener;
    if (isLowMemory())
    {
      paramHippyQQEngineListener = new StringBuilder();
      paramHippyQQEngineListener.append("Can't preload ");
      paramHippyQQEngineListener.append(getModuleName());
      paramHippyQQEngineListener.append(", because system is in low memory");
      paramHippyQQEngineListener = paramHippyQQEngineListener.toString();
      callBackError(-20002, paramHippyQQEngineListener);
      QLog.e("HippyQQPreloadEngine", 1, paramHippyQQEngineListener);
      return;
    }
    if (((IHippyLibrary)QRoute.api(IHippyLibrary.class)).isLibrayExists()) {
      HippyErrorManager.getInstance().operationStart("loadHippySo");
    }
    ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(this);
    updateJsBundle(paramBoolean2);
  }
  
  private void predrawModule(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("predrawModule start:");
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
      if (this.mIsPreloadFinished)
      {
        QLog.i("HippyQQPreloadEngine", 1, "preloadHippy has preloaded.");
        return;
      }
      this.mIsPreloadFinished = true;
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
    localStringBuilder.append("preloadModule start:");
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
    localHashMap2.put("from", this.mPreloadFrom);
    HippyReporter.getInstance().reportHippyLoadResult(10, getModuleName(), getPreloadModuleVersion(), localHashMap2, localHashMap1);
  }
  
  protected void destoryEngine()
  {
    super.destoryEngine();
    ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).removeJsBundleUpdateListener(getModuleName(), this.mUpdateListener);
  }
  
  protected HashMap<String, Long> generatePreloadStepCosts()
  {
    long l2 = this.mPreloadStartTime;
    long l3 = getValueFromStepCosts("loadLibEnd", this.mMapLoadStepsTime);
    long l4 = getValueFromStepCosts("initEngineEnd", this.mMapLoadStepsTime);
    long l5 = getValueFromStepCosts("loadModuleStart", this.mMapLoadStepsTime);
    long l1 = this.mPreloadEndTime;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((l3 > 0L) && (l2 > 0L)) {
      localLinkedHashMap.put("loadLibrary", Long.valueOf(l3 - l2));
    }
    if ((l4 > 0L) && (l3 > 0L)) {
      localLinkedHashMap.put("initEngine", Long.valueOf(l4 - l3));
    }
    if ((l5 > 0L) && (l4 > 0L)) {
      localLinkedHashMap.put("checkJsBundle", Long.valueOf(l5 - l4));
    }
    if ((l1 > 0L) && (l5 > 0L)) {
      localLinkedHashMap.put("loadJsBundle", Long.valueOf(l1 - l5));
    }
    if (l1 > 0L)
    {
      l2 = this.mPreloadStartTime;
      if (l2 > 0L) {
        localLinkedHashMap.put("total", Long.valueOf(l1 - l2));
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
    localObject = getCoreJsFileName();
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
    return (this.mIsPreload) && (this.mIsPredraw);
  }
  
  public boolean isPreloaded()
  {
    return this.mIsPreload;
  }
  
  protected void loadModule()
  {
    if ((this.mIsPreload) && (!this.mIsPreloadCreating))
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
    localStringBuilder.append("onLoadSuccess mIsPreload:");
    localStringBuilder.append(this.mIsPreload);
    localStringBuilder.append(" mIsPreloadCreating:");
    localStringBuilder.append(this.mIsPreloadCreating);
    QLog.i("HippyQQPreloadEngine", 1, localStringBuilder.toString());
    HippyErrorManager.getInstance().operationEnd("loadHippySo");
    if ((this.mIsPreload) && (!this.mIsPreloadCreating))
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
  
  public void setPreloadFrom(String paramString)
  {
    this.mPreloadFrom = paramString;
  }
  
  public void setUpdateJsBundleType(int paramInt)
  {
    this.mUpdateJsBundleType = paramInt;
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
      ((Bundle)localObject).putString("reportFrom", this.mPreloadFrom);
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).updateJsBundle(getModuleName(), ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, (Bundle)localObject, this.mUpdateListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQPreloadEngine
 * JD-Core Version:    0.7.0.1
 */