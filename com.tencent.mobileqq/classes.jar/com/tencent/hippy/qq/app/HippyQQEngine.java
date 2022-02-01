package com.tencent.hippy.qq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.adapter.HippyQQFontAdapter;
import com.tencent.hippy.qq.adapter.HippyQQImageLoader;
import com.tencent.hippy.qq.adapter.HippyQQThirdPartyAdapter;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.hippy.qq.module.tkd.TKDJsCallBack;
import com.tencent.hippy.qq.module.tkd.TKDNativeProxy;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.HippyQQLibraryManager.LibraryLoadListener;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.BackPressHandler;
import com.tencent.mtt.hippy.HippyEngine.EngineInitParams;
import com.tencent.mtt.hippy.HippyEngine.EngineState;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class HippyQQEngine
  implements HippyQQLibraryManager.LibraryLoadListener
{
  private static final int DESTORY_ENGINE_DELAY_MILLIS = 3000;
  private static final String EVENT_PAGE_APPEAR = "PageAppear";
  private static final String EVENT_PAGE_DESTORY = "PageDestory";
  private static final String EVENT_PAGE_DISAPPEAR = "PageDisappear";
  protected static final String TAG = "HippyQQEngine";
  private static String mDebugMoudleName = HippyDebugUtil.getHippyBundleName();
  private static String mDebugServerHost = HippyDebugUtil.getHippyServerHost();
  private static boolean mDebugSwitch = ;
  public static SparseArray<WeakReference<HippyQQEngine>> mEngines = new SparseArray();
  private static HashMap<String, Long> mModuleUpdateTime = new HashMap();
  private Activity activity;
  protected String componentName;
  private HippyActivityLifecycleOwner hippyActivityLifecycleOwner;
  protected String mBundleUrl;
  private JSONObject mBusinessData;
  protected ViewGroup mContainer;
  protected HippyQQEngine.HippyQQEngineListener mEngineListener;
  protected Fragment mFragment;
  private JSONObject mGlobalData;
  private HippyEngine mHippyEngine;
  protected HippyRootView mHippyRootView;
  protected boolean mIsDestroyed = false;
  protected boolean mIsPageLoaded = false;
  protected boolean mIsResumed = false;
  private String mJsBundleType = "vue";
  protected HashMap<String, Long> mMapLoadStepsTime = new HashMap();
  private String mModuleName;
  protected int mModuleVersion = 0;
  private JSONObject mPageData;
  private HippyQQUpdateManager mUpdateManager;
  protected String mUrl;
  @androidx.annotation.NonNull
  private TKDNativeProxy nativeProxy;
  private HippyMap propsMap;
  protected List<HippyAPIProvider> providers = new ArrayList();
  protected HippyCustomViewCreator viewCreator = null;
  
  public HippyQQEngine(Activity paramActivity, String paramString1, String paramString2)
  {
    this.activity = paramActivity;
    if ((paramActivity instanceof HippyActivityLifecycleOwner)) {
      setHippyActivityLifecycleOwner((HippyActivityLifecycleOwner)paramActivity);
    }
    init(paramString1, paramString2);
  }
  
  public HippyQQEngine(Fragment paramFragment, String paramString1, String paramString2)
  {
    this.mFragment = paramFragment;
    if ((this.mFragment instanceof HippyActivityLifecycleOwner)) {
      setHippyActivityLifecycleOwner((HippyActivityLifecycleOwner)this.mFragment);
    }
    init(paramString1, paramString2);
  }
  
  private void adapterJsBundleType(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("framework");
      if (!TextUtils.isEmpty(paramString)) {
        this.mJsBundleType = paramString;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void dispatchEvent(String paramString1, String paramString2, HippyMap paramHippyMap)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= mEngines.size()) {
          break;
        }
        localObject = (WeakReference)mEngines.valueAt(i);
        if (localObject == null) {
          break label124;
        }
        localObject = (HippyQQEngine)((WeakReference)localObject).get();
        if ((localObject != null) && (!((HippyQQEngine)localObject).isDestroyed()) && ((TextUtils.isEmpty(paramString2)) || (paramString2.equals(((HippyQQEngine)localObject).mModuleName))))
        {
          localObject = ((HippyQQEngine)localObject).mHippyEngine;
          if ((localObject != null) && (((HippyEngine)localObject).getEngineState() == HippyEngine.EngineState.INITED)) {
            ((HippyEngine)localObject).sendEvent(paramString1, paramHippyMap);
          }
        }
      }
      catch (Throwable paramString1)
      {
        return;
      }
      i += 1;
      continue;
      label124:
      Object localObject = null;
    }
  }
  
  private void doOnUpdateComplete(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    paramString1 = new HippyQQEngine.2(this, paramInt, paramString1, paramString2, paramLong);
    if (isMainThread())
    {
      paramString1.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramString1);
  }
  
  public static String getDebugMoudleName()
  {
    return mDebugMoudleName;
  }
  
  public static String getDebugServerHost()
  {
    return mDebugServerHost;
  }
  
  public static boolean getDebugSwitch()
  {
    return mDebugSwitch;
  }
  
  public static HippyQQEngine getEngineInstance(int paramInt)
  {
    WeakReference localWeakReference = (WeakReference)mEngines.get(paramInt);
    if (localWeakReference != null) {
      return (HippyQQEngine)localWeakReference.get();
    }
    return null;
  }
  
  public static int getModuleOnlineConfig(String paramString)
  {
    paramString = Aladdin.getConfig(311).getString(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  public static String getPageDataCacheFromUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Uri.parse(paramString).getQueryParameter("_ckey");
    if (!TextUtils.isEmpty(paramString))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime == null) {
        return null;
      }
      paramString = FileUtils.a("viola_cache_file_" + paramString + "_" + localAppRuntime.getAccount());
      if ((paramString instanceof String)) {
        return (String)paramString;
      }
      return null;
    }
    return null;
  }
  
  private void init(String paramString1, String paramString2)
  {
    this.mModuleName = paramString1;
    this.mUrl = paramString2;
    this.nativeProxy = new TKDNativeProxy();
    initJsBundleTypeFromUrl();
  }
  
  private boolean isActivityDestroyed()
  {
    return (this.activity != null) && (this.activity.isFinishing());
  }
  
  private boolean isFragmentDestroyed()
  {
    return (this.activity == null) && ((this.mFragment == null) || (this.mFragment.getActivity() == null));
  }
  
  public static boolean isMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  private boolean isPageDestroyed()
  {
    if ((isActivityDestroyed()) || (isFragmentDestroyed()))
    {
      if (this.mEngineListener != null) {
        this.mEngineListener.onError(-11, "fragment or activity destroyed!");
      }
      return true;
    }
    return false;
  }
  
  public static void onDebugModuleChanged(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mDebugMoudleName = paramString;
    }
  }
  
  public static void onDebugPortChanged(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mDebugServerHost = paramString;
    }
  }
  
  public static void onDebugSwitchChanged(boolean paramBoolean)
  {
    mDebugSwitch = paramBoolean;
  }
  
  public static void runTaskInUIThread(Runnable paramRunnable)
  {
    if (isMainThread())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  protected void checkPackageUpdate()
  {
    if (!TextUtils.isEmpty(this.mModuleName))
    {
      mModuleUpdateTime.put(this.mModuleName, Long.valueOf(System.currentTimeMillis()));
      this.mUpdateManager = new HippyQQUpdateManager();
      long l = System.currentTimeMillis();
      this.mUpdateManager.checkUpdate(this.mModuleName, new HippyQQEngine.1(this, l));
    }
  }
  
  protected void destoryEngine()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyQQEngine", 2, "destoryEngine");
    }
    if (this.mHippyEngine != null)
    {
      this.mHippyEngine.destroyModule(this.mHippyRootView);
      this.mHippyEngine.destroyEngine();
    }
  }
  
  public void destoryEngineImmediately()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyQQEngine", 2, "destoryEngineImmediately engine:" + this.mHippyEngine);
    }
    if ((this.mHippyEngine != null) && (!this.mIsDestroyed))
    {
      this.mIsDestroyed = true;
      this.mHippyEngine.sendEvent("PageDestory", null);
      mEngines.remove(this.mHippyEngine.getId());
      this.mFragment = null;
      this.mEngineListener = null;
      destoryEngine();
    }
  }
  
  public boolean doOnBackPressed(HippyEngine.BackPressHandler paramBackPressHandler)
  {
    if (this.mHippyEngine != null) {
      return this.mHippyEngine.onBackPressed(paramBackPressHandler);
    }
    return false;
  }
  
  protected void doUpdatePackageComplete(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(paramString2)) && (this.mModuleVersion <= 0)) {
        loadModule(paramString2 + "/" + "index.android.jsbundle");
      }
    }
    for (;;)
    {
      HippyReporter.getInstance().reportCheckUpdate(this.mModuleName, 5, paramInt, paramString1, l - paramLong);
      return;
      paramString2 = "check package update error: " + paramString1;
      LogUtils.e("hippy", paramString2);
      if ((this.mModuleVersion <= 0) && (this.mEngineListener != null)) {
        this.mEngineListener.onError(paramInt, paramString2);
      }
    }
  }
  
  public Activity getActivity()
  {
    if (this.activity != null) {
      return this.activity;
    }
    if (this.mFragment != null) {
      return this.mFragment.getActivity();
    }
    return null;
  }
  
  public Fragment getFragment()
  {
    return this.mFragment;
  }
  
  public HippyActivityLifecycleOwner getHippyActivityLifecycleOwner()
  {
    return this.hippyActivityLifecycleOwner;
  }
  
  public HippyEngine getHippyEngine()
  {
    return this.mHippyEngine;
  }
  
  public HippyRootView getHippyRootView()
  {
    return this.mHippyRootView;
  }
  
  protected Context getInitHippyEngineContext()
  {
    Activity localActivity = getActivity();
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseApplicationImpl.getContext().getApplicationContext();
    }
    return localObject;
  }
  
  public String getJsBundleType()
  {
    return this.mJsBundleType;
  }
  
  @NotNull
  protected HippyMap getJsParamsMap(HippyEngine.ModuleLoadParams paramModuleLoadParams)
  {
    paramModuleLoadParams = new HippyMap();
    if (this.propsMap != null) {
      paramModuleLoadParams.pushAll(this.propsMap);
    }
    paramModuleLoadParams.pushString("msgFromNative", "Hi js developer, I come from native code!");
    if (this.mBusinessData != null) {
      paramModuleLoadParams.pushString("cookie", this.mBusinessData.toString());
    }
    return paramModuleLoadParams;
  }
  
  public HashMap<String, Long> getLoadStepsTime()
  {
    return this.mMapLoadStepsTime;
  }
  
  public String getModuleName()
  {
    return this.mModuleName;
  }
  
  public int getModuleVersion()
  {
    return this.mModuleVersion;
  }
  
  @NotNull
  protected Map<String, Object> getNativeParams()
  {
    HashMap localHashMap = new HashMap();
    if (this.viewCreator != null) {
      localHashMap.put("CustomViewCreator", this.viewCreator);
    }
    return localHashMap;
  }
  
  @androidx.annotation.NonNull
  public TKDNativeProxy getNativeProxy()
  {
    return this.nativeProxy;
  }
  
  public String getPageUrl()
  {
    return this.mUrl;
  }
  
  public void initHippy(@android.support.annotation.NonNull ViewGroup paramViewGroup, @android.support.annotation.NonNull JSONObject paramJSONObject, boolean paramBoolean, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    this.mContainer = ((ViewGroup)paramViewGroup.findViewById(2131381681));
    initHippyInContainer(this.mContainer, paramJSONObject, paramBoolean, paramHippyQQEngineListener);
  }
  
  protected void initHippyEngine()
  {
    if (!isCanInitHippyEngine()) {
      return;
    }
    QLog.d("Hippy", 1, "Hippy: initHippyEngine:" + this.mModuleName);
    if ((!TextUtils.isEmpty(this.mJsBundleType)) && (this.mJsBundleType.equals("react"))) {}
    for (String str = "react.android.js";; str = "vue.android.js")
    {
      str = HippyQQLibraryManager.getInstance().getCoreJsFilePath(str);
      if (!TextUtils.isEmpty(str)) {
        break label119;
      }
      QLog.d("Hippy", 1, "could not found core js file!");
      if (this.mEngineListener == null) {
        break;
      }
      this.mEngineListener.onError(-10, "could not found core js file!");
      return;
    }
    label119:
    HippyEngine.EngineInitParams localEngineInitParams = new HippyEngine.EngineInitParams();
    localEngineInitParams.context = getInitHippyEngineContext();
    localEngineInitParams.appContext = BaseApplicationImpl.getContext().getApplicationContext();
    localEngineInitParams.imageLoader = new HippyQQImageLoader();
    localEngineInitParams.fontScaleAdapter = new HippyQQFontAdapter();
    localEngineInitParams.thirdPartyAdapter = new HippyQQThirdPartyAdapter();
    localEngineInitParams.thirdPartyAdapter.setPageUrl(this.mUrl);
    localEngineInitParams.thirdPartyAdapter.setExtraData(this.mGlobalData);
    localEngineInitParams.debugMode = isDebugMode();
    if (localEngineInitParams.debugMode) {}
    localEngineInitParams.enableLog = false;
    localEngineInitParams.coreJSFilePath = str;
    localEngineInitParams.exceptionHandler = new HippyQQEngine.5(this);
    this.providers.add(new HippyQQAPIProvider());
    localEngineInitParams.providers = this.providers;
    this.mHippyEngine = HippyEngine.create(localEngineInitParams);
    mEngines.put(this.mHippyEngine.getId(), new WeakReference(this));
    this.mHippyEngine.initEngine(new HippyQQEngine.6(this));
  }
  
  public void initHippyInContainer(@android.support.annotation.NonNull ViewGroup paramViewGroup, @android.support.annotation.NonNull JSONObject paramJSONObject, boolean paramBoolean, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    this.mModuleVersion = 0;
    this.mPageData = paramJSONObject;
    this.mEngineListener = paramHippyQQEngineListener;
    this.mContainer = paramViewGroup;
    this.mMapLoadStepsTime.put("loadLibStart", Long.valueOf(System.currentTimeMillis()));
    HippyQQLibraryManager.getInstance().loadLibraryIfNeed(this);
  }
  
  protected void initJsBundleTypeFromUrl()
  {
    if (TextUtils.isEmpty(this.mUrl)) {
      return;
    }
    adapterJsBundleType(this.mUrl);
  }
  
  protected boolean isCanCheckPackageUpdate()
  {
    if (TextUtils.isEmpty(this.mModuleName)) {
      return false;
    }
    long l2 = System.currentTimeMillis();
    if (mModuleUpdateTime.containsKey(this.mModuleName))
    {
      long l1 = ((Long)mModuleUpdateTime.get(this.mModuleName)).longValue();
      l2 -= l1;
      if ((this.mModuleVersion > 0) && (l1 > 0L) && (l2 > 0L) && (l2 < 1800000L)) {
        return false;
      }
    }
    return true;
  }
  
  protected boolean isCanInitHippyEngine()
  {
    return !isPageDestroyed();
  }
  
  protected boolean isDebugMode()
  {
    return false;
  }
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public boolean isReady()
  {
    if (!HippyQQLibraryManager.getInstance().isLibraryLoaded()) {}
    File localFile;
    do
    {
      int i;
      do
      {
        return false;
        i = UpdateSetting.getInstance().getModuleVersion(this.mModuleName);
      } while (i == -1);
      localFile = HippyQQFileUtil.getModuleIndex(this.mModuleName, i);
    } while ((localFile == null) || (!localFile.exists()));
    return true;
  }
  
  protected void loadModule()
  {
    int i = UpdateSetting.getInstance().getModuleVersion(this.mModuleName);
    if (i != -1)
    {
      File localFile = HippyQQFileUtil.getModuleIndex(this.mModuleName, i);
      if ((localFile != null) && (localFile.exists()))
      {
        this.mModuleVersion = i;
        loadModule(localFile.getAbsolutePath());
      }
    }
    if (isCanCheckPackageUpdate()) {
      checkPackageUpdate();
    }
    while ((i != -1) || (this.mEngineListener == null)) {
      return;
    }
    this.mEngineListener.onError(-5, "no jsbundle");
  }
  
  protected void loadModule(String paramString)
  {
    if (isPageDestroyed()) {
      return;
    }
    HippyEngine.ModuleLoadParams localModuleLoadParams = new HippyEngine.ModuleLoadParams();
    localModuleLoadParams.context = getActivity();
    if (TextUtils.isEmpty(this.componentName)) {}
    for (String str = this.mModuleName;; str = this.componentName)
    {
      localModuleLoadParams.componentName = str;
      localModuleLoadParams.jsFilePath = paramString;
      localModuleLoadParams.nativeParams = getNativeParams();
      localModuleLoadParams.jsParams = getJsParamsMap(localModuleLoadParams);
      this.mMapLoadStepsTime.put("loadModuleStart", Long.valueOf(System.currentTimeMillis()));
      this.mHippyRootView = this.mHippyEngine.loadModule(localModuleLoadParams, new HippyQQEngine.4(this));
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onConsumeBackKeyEvent()
  {
    return false;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyQQEngine", 2, "onDestroy engine:" + this.mHippyEngine);
    }
    if ((this.mHippyEngine != null) && (!this.mIsDestroyed))
    {
      this.mIsDestroyed = true;
      this.mHippyEngine.sendEvent("PageDestory", null);
      mEngines.remove(this.mHippyEngine.getId());
      this.mFragment = null;
      this.activity = null;
      this.hippyActivityLifecycleOwner = null;
      this.mEngineListener = null;
      ThreadManager.getUIHandler().postDelayed(new HippyQQEngine.7(this), 3000L);
    }
  }
  
  protected void onInitEngineComplete(int paramInt, String paramString)
  {
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
    if (isDebugMode())
    {
      loadModule("index.android.jsbundle");
      return;
    }
    loadModule();
  }
  
  public void onLoadFail(int paramInt, String paramString)
  {
    QLog.e("HippyQQEngine", 1, "load so error statusCode:" + paramInt + " msg:" + paramString);
    if (this.mEngineListener != null) {
      this.mEngineListener.onError(paramInt, paramString);
    }
  }
  
  public void onLoadSuccess()
  {
    this.mMapLoadStepsTime.put("loadLibEnd", Long.valueOf(System.currentTimeMillis()));
    initHippyEngine();
  }
  
  public void onPause()
  {
    QLog.i("HippyQQEngine", 1, "onPause " + this.mModuleName + " engine:" + this.mHippyEngine);
    if (this.mHippyEngine != null)
    {
      this.mHippyEngine.sendEvent("PageDisappear", null);
      this.mHippyEngine.onEnginePause();
    }
  }
  
  public void onResume()
  {
    QLog.i("HippyQQEngine", 1, "onResume " + this.mModuleName + " engine:" + this.mHippyEngine + " mIsResumed:" + this.mIsResumed + " mIsPageLoaded:" + this.mIsPageLoaded);
    this.mIsResumed = true;
    if (this.mHippyEngine != null)
    {
      this.mHippyEngine.onEngineResume();
      if (this.mIsPageLoaded) {
        this.mHippyEngine.sendEvent("PageAppear", null);
      }
    }
  }
  
  public void registerNativeMethod(String paramString1, String paramString2, TKDJsCallBack paramTKDJsCallBack)
  {
    this.nativeProxy.registerNativeMethod(paramString1, paramString2, paramTKDJsCallBack);
  }
  
  public void reload(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener) {}
  
  public void sendEvent(String paramString, Object paramObject)
  {
    if (this.mHippyEngine != null) {
      this.mHippyEngine.sendEvent(paramString, paramObject);
    }
  }
  
  public void setBundleUrl(String paramString)
  {
    this.mBundleUrl = paramString;
  }
  
  public void setComponentName(String paramString)
  {
    this.componentName = paramString;
  }
  
  @Deprecated
  public void setDebugMode(boolean paramBoolean) {}
  
  public final void setHippyActivityLifecycleOwner(HippyActivityLifecycleOwner paramHippyActivityLifecycleOwner)
  {
    this.hippyActivityLifecycleOwner = paramHippyActivityLifecycleOwner;
  }
  
  public void setInitData(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    this.mGlobalData = paramJSONObject1;
    this.mBusinessData = paramJSONObject2;
  }
  
  public void setJsBundleType(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mJsBundleType = paramString;
    }
  }
  
  public void setPageUrl(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public void setPropsMap(HippyMap paramHippyMap)
  {
    this.propsMap = paramHippyMap;
  }
  
  public void setViewCreator(HippyCustomViewCreator paramHippyCustomViewCreator)
  {
    this.viewCreator = paramHippyCustomViewCreator;
  }
  
  public void unRegisterNativeMethod(String paramString1, String paramString2)
  {
    this.nativeProxy.unRegisterNativeMethod(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine
 * JD-Core Version:    0.7.0.1
 */