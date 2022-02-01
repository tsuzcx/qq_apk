package com.tencent.hippy.qq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippyLifeCycleApi;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.INativeProxy;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.hippy.qq.module.tkd.TJsCallBack;
import com.tencent.hippy.qq.module.tkd.TNativeProxy;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.BackPressHandler;
import com.tencent.mtt.hippy.HippyEngine.EngineInitParams;
import com.tencent.mtt.hippy.HippyEngine.EngineInitStatus;
import com.tencent.mtt.hippy.HippyEngine.EngineState;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class HippyQQEngine
  implements LibraryLoadListener
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
  protected QBaseFragment mFragment;
  private JSONObject mGlobalData;
  private HippyEngine mHippyEngine;
  protected HippyRootView mHippyRootView;
  protected boolean mIsDestroyed = false;
  protected boolean mIsPageLoaded = false;
  protected boolean mIsResumed = false;
  private String mJsBundleType = "vue";
  protected OnMainBundleLoadListener mMainBundleLoadListener;
  protected HashMap<String, Long> mMapLoadStepsTime = new HashMap();
  private String mModuleName;
  protected int mModuleVersion = 0;
  private JSONObject mPageData;
  protected String mUrl;
  @androidx.annotation.NonNull
  private INativeProxy nativeProxy;
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
  
  public HippyQQEngine(QBaseFragment paramQBaseFragment, String paramString1, String paramString2)
  {
    this.mFragment = paramQBaseFragment;
    paramQBaseFragment = this.mFragment;
    if ((paramQBaseFragment instanceof HippyActivityLifecycleOwner)) {
      setHippyActivityLifecycleOwner((HippyActivityLifecycleOwner)paramQBaseFragment);
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
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString1);
        if (bool) {
          return;
        }
        i = 0;
      }
      finally
      {
        int i;
        continue;
        throw paramString1;
        continue;
      }
      try
      {
        if (i >= mEngines.size()) {
          continue;
        }
        localObject = (WeakReference)mEngines.valueAt(i);
        if (localObject == null) {
          break label155;
        }
        localObject = (HippyQQEngine)((WeakReference)localObject).get();
      }
      catch (Throwable paramString1)
      {
        continue;
        localObject = null;
        continue;
      }
      if ((localObject != null) && (!((HippyQQEngine)localObject).isDestroyed()) && ((TextUtils.isEmpty(paramString2)) || (paramString2.equals(((HippyQQEngine)localObject).mModuleName))))
      {
        localObject = ((HippyQQEngine)localObject).mHippyEngine;
        if ((localObject != null) && (((HippyEngine)localObject).getEngineState() == HippyEngine.EngineState.INITED)) {
          ((HippyEngine)localObject).sendEvent(paramString1, paramHippyMap);
        }
      }
      i += 1;
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
    try
    {
      Object localObject1 = (WeakReference)mEngines.get(paramInt);
      if (localObject1 != null) {
        localObject1 = (HippyQQEngine)((WeakReference)localObject1).get();
      } else {
        localObject1 = null;
      }
      return localObject1;
    }
    finally {}
  }
  
  private void init(String paramString1, String paramString2)
  {
    this.mModuleName = paramString1;
    this.mUrl = paramString2;
    this.nativeProxy = new TNativeProxy();
    initJsBundleTypeFromUrl();
  }
  
  private boolean isActivityDestroyed()
  {
    Activity localActivity = this.activity;
    return (localActivity != null) && (localActivity.isFinishing());
  }
  
  private boolean isFragmentDestroyed()
  {
    if (this.activity == null)
    {
      QBaseFragment localQBaseFragment = this.mFragment;
      if ((localQBaseFragment == null) || (localQBaseFragment.getActivity() == null)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  private boolean isPageDestroyed()
  {
    if (this.mModuleName.equals("TKDADwormhole")) {
      return false;
    }
    if ((!isActivityDestroyed()) && (!isFragmentDestroyed())) {
      return false;
    }
    HippyQQEngine.HippyQQEngineListener localHippyQQEngineListener = this.mEngineListener;
    if (localHippyQQEngineListener != null) {
      localHippyQQEngineListener.onError(-11, "fragment or activity destroyed!");
    }
    return true;
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
  
  protected static void putEngineInstance(int paramInt, HippyQQEngine paramHippyQQEngine)
  {
    try
    {
      mEngines.put(paramInt, new WeakReference(paramHippyQQEngine));
      return;
    }
    finally
    {
      paramHippyQQEngine = finally;
      throw paramHippyQQEngine;
    }
  }
  
  protected static void removeEngineInstance(int paramInt)
  {
    try
    {
      mEngines.remove(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
      long l = System.currentTimeMillis();
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(this.mModuleName, "oldUpdate", new HippyQQEngine.1(this, l));
    }
  }
  
  protected void destoryEngine()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyQQEngine", 2, "destoryEngine");
    }
    HippyEngine localHippyEngine = this.mHippyEngine;
    if (localHippyEngine != null)
    {
      localHippyEngine.destroyModule(this.mHippyRootView);
      this.mHippyEngine.destroyEngine();
    }
  }
  
  public void destroyEngineImmediately()
  {
    destroyEngineImmediately("default");
  }
  
  public void destroyEngineImmediately(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destoryEngineImmediately engine:");
      ((StringBuilder)localObject).append(this.mHippyEngine);
      QLog.i("HippyQQEngine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mHippyEngine;
    if ((localObject != null) && (!this.mIsDestroyed))
    {
      this.mIsDestroyed = true;
      ((HippyEngine)localObject).sendEvent("PageDestory", null);
      removeEngineInstance(this.mHippyEngine.getId());
      this.mFragment = null;
      this.mEngineListener = null;
      destoryEngine();
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("from", paramString);
    HippyReporter.getInstance().reportToDengTa(this.mModuleName, this.mModuleVersion, "hippy_remove_preLoad", -1, (HashMap)localObject);
  }
  
  public boolean doOnBackPressed(HippyEngine.BackPressHandler paramBackPressHandler)
  {
    HippyEngine localHippyEngine = this.mHippyEngine;
    if (localHippyEngine != null) {
      return localHippyEngine.onBackPressed(paramBackPressHandler);
    }
    return false;
  }
  
  protected void doUpdatePackageComplete(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.mModuleVersion <= 0)
    {
      String str = paramString2;
      if (paramString2 == null)
      {
        int i = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(this.mModuleName);
        if (i == -1) {
          paramString2 = null;
        } else {
          paramString2 = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleFile(this.mModuleName, i);
        }
        if (paramString2 == null) {
          str = null;
        } else {
          str = paramString2.getAbsolutePath();
        }
      }
      if (!TextUtils.isEmpty(str))
      {
        paramString2 = new StringBuilder();
        paramString2.append(str);
        paramString2.append("/");
        paramString2.append("index.android.jsbundle");
        loadModule(paramString2.toString());
      }
      else
      {
        paramString2 = this.mEngineListener;
        if (paramString2 != null) {
          paramString2.onError(paramInt, paramString1);
        }
      }
    }
    HippyReporter.getInstance().reportCheckUpdate(this.mModuleName, 5, paramInt, paramString1, l - paramLong, null);
  }
  
  protected void fillLoadParams(HippyEngine.ModuleLoadParams paramModuleLoadParams) {}
  
  public HashMap<String, String> generateReportExtraParams()
  {
    HashMap localHashMap = new HashMap();
    long l1 = ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).getCoreJsFileLength(getCoreJsFileName());
    long l2 = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleIndexFileLength(this.mModuleName, this.mModuleVersion);
    localHashMap.put("coreJsLength", String.valueOf(l1));
    localHashMap.put("busJsLength", String.valueOf(l2));
    return localHashMap;
  }
  
  public Activity getActivity()
  {
    Object localObject = this.activity;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.mFragment;
    if (localObject != null) {
      return ((QBaseFragment)localObject).getActivity();
    }
    return null;
  }
  
  public String getCoreJsFileName()
  {
    if ((!TextUtils.isEmpty(this.mJsBundleType)) && (this.mJsBundleType.equals("react"))) {
      return "react.android.js";
    }
    return "vue.android.js";
  }
  
  public QBaseFragment getFragment()
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
      localObject = MobileQQ.sMobileQQ.getApplicationContext();
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
    Object localObject = this.propsMap;
    if (localObject != null) {
      paramModuleLoadParams.pushAll((HippyMap)localObject);
    }
    paramModuleLoadParams.pushString("msgFromNative", "Hi js developer, I come from native code!");
    localObject = this.mBusinessData;
    if (localObject != null) {
      paramModuleLoadParams.pushString("cookie", ((JSONObject)localObject).toString());
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
    HippyCustomViewCreator localHippyCustomViewCreator = this.viewCreator;
    if (localHippyCustomViewCreator != null) {
      localHashMap.put("CustomViewCreator", localHippyCustomViewCreator);
    }
    return localHashMap;
  }
  
  @androidx.annotation.NonNull
  public INativeProxy getNativeProxy()
  {
    return this.nativeProxy;
  }
  
  public String getPageUrl()
  {
    return this.mUrl;
  }
  
  protected void initHippyEngine()
  {
    if (!isCanInitHippyEngine()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Hippy: initHippyEngine:");
    ((StringBuilder)localObject).append(this.mModuleName);
    QLog.d("Hippy", 1, ((StringBuilder)localObject).toString());
    localObject = getCoreJsFileName();
    localObject = ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).getCoreJsFilePath((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.d("Hippy", 1, "could not found core js file!");
      localObject = this.mEngineListener;
      if (localObject != null) {
        ((HippyQQEngine.HippyQQEngineListener)localObject).onError(-10, "could not found core js file!");
      }
      return;
    }
    HippyEngine.EngineInitParams localEngineInitParams = new HippyEngine.EngineInitParams();
    localEngineInitParams.context = getInitHippyEngineContext();
    localEngineInitParams.imageLoader = ((IHippyAdapter)QRoute.api(IHippyAdapter.class)).creatImageLoader();
    localEngineInitParams.httpAdapter = ((IHippyAdapter)QRoute.api(IHippyAdapter.class)).createHttpAdapter();
    localEngineInitParams.fontScaleAdapter = ((IHippyAdapter)QRoute.api(IHippyAdapter.class)).createFontScaleAdapter();
    localEngineInitParams.thirdPartyAdapter = ((IHippyAdapter)QRoute.api(IHippyAdapter.class)).createThirdPartyAdapter();
    localEngineInitParams.thirdPartyAdapter.setPageUrl(this.mUrl);
    localEngineInitParams.thirdPartyAdapter.setExtraData(this.mGlobalData);
    localEngineInitParams.debugMode = isDebugMode();
    boolean bool = localEngineInitParams.debugMode;
    localEngineInitParams.enableLog = false;
    localEngineInitParams.coreJSFilePath = ((String)localObject);
    localEngineInitParams.exceptionHandler = new HippyQQEngine.5(this);
    localEngineInitParams.engineMonitor = ((IHippyAdapter)QRoute.api(IHippyAdapter.class)).createEngineMonitorAdapter();
    HippyUtils.addBaseApiProvider(this.providers);
    localEngineInitParams.providers = this.providers;
    this.mHippyEngine = HippyEngine.create(localEngineInitParams);
    putEngineInstance(this.mHippyEngine.getId(), this);
    this.mHippyEngine.initEngine(new HippyQQEngine.6(this));
  }
  
  public void initHippyInContainer(@android.support.annotation.NonNull ViewGroup paramViewGroup, @android.support.annotation.NonNull JSONObject paramJSONObject, boolean paramBoolean, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    this.mModuleVersion = 0;
    this.mPageData = paramJSONObject;
    this.mEngineListener = paramHippyQQEngineListener;
    this.mContainer = paramViewGroup;
    this.mMapLoadStepsTime.put("loadLibStart", Long.valueOf(System.currentTimeMillis()));
    ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(this);
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
    return isPageDestroyed() ^ true;
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
    if (!((IHippyLibrary)QRoute.api(IHippyLibrary.class)).isLibraryLoaded()) {
      return false;
    }
    int i = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(this.mModuleName);
    if (i != -1)
    {
      File localFile = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleIndex(this.mModuleName, i);
      if ((localFile != null) && (localFile.exists())) {
        return true;
      }
    }
    return false;
  }
  
  protected void loadModule()
  {
    int i = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(this.mModuleName);
    Object localObject;
    if (i != -1)
    {
      localObject = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleIndex(this.mModuleName, i);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        this.mModuleVersion = i;
        loadModule(((File)localObject).getAbsolutePath());
      }
    }
    if (isCanCheckPackageUpdate())
    {
      checkPackageUpdate();
      return;
    }
    if (i == -1)
    {
      localObject = this.mEngineListener;
      if (localObject != null) {
        ((HippyQQEngine.HippyQQEngineListener)localObject).onError(-5, "no jsbundle");
      }
    }
  }
  
  protected void loadModule(String paramString)
  {
    if (isPageDestroyed()) {
      return;
    }
    HippyEngine.ModuleLoadParams localModuleLoadParams = new HippyEngine.ModuleLoadParams();
    localModuleLoadParams.context = getActivity();
    String str;
    if (TextUtils.isEmpty(this.componentName)) {
      str = this.mModuleName;
    } else {
      str = this.componentName;
    }
    localModuleLoadParams.componentName = str;
    localModuleLoadParams.jsFilePath = paramString;
    localModuleLoadParams.nativeParams = getNativeParams();
    fillLoadParams(localModuleLoadParams);
    localModuleLoadParams.jsParams = getJsParamsMap(localModuleLoadParams);
    this.mMapLoadStepsTime.put("loadModuleStart", Long.valueOf(System.currentTimeMillis()));
    this.mHippyRootView = this.mHippyEngine.loadModule(localModuleLoadParams, new HippyQQEngine.4(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onConsumeBackKeyEvent()
  {
    return false;
  }
  
  public void onDestroy()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy this:");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" engine:");
    ((StringBuilder)localObject).append(this.mHippyEngine);
    QLog.i("HippyQQEngine", 1, ((StringBuilder)localObject).toString());
    localObject = this.mHippyEngine;
    if ((localObject != null) && (!this.mIsDestroyed))
    {
      this.mIsDestroyed = true;
      ((HippyEngine)localObject).sendEvent("PageDestory", null);
      removeEngineInstance(this.mHippyEngine.getId());
      this.mFragment = null;
      this.activity = null;
      this.hippyActivityLifecycleOwner = null;
      this.mEngineListener = null;
      localObject = this.mMainBundleLoadListener;
      if (localObject != null)
      {
        ((OnMainBundleLoadListener)localObject).onDestroy(this.mModuleName, this);
        this.mMainBundleLoadListener = null;
      }
      ((IHippyLifeCycleApi)QRoute.api(IHippyLifeCycleApi.class)).onDestroy();
      destoryEngine();
    }
  }
  
  protected void onInitEngineComplete(HippyEngine.EngineInitStatus paramEngineInitStatus, String paramString)
  {
    Object localObject;
    if ((QLog.isColorLevel()) || (paramEngineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Hippy: initEngine statusCode=");
      ((StringBuilder)localObject).append(paramEngineInitStatus);
      ((StringBuilder)localObject).append(", msg=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Hippy", 1, ((StringBuilder)localObject).toString());
    }
    if (paramEngineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK)
    {
      localObject = this.mEngineListener;
      if (localObject != null) {
        ((HippyQQEngine.HippyQQEngineListener)localObject).onError(paramEngineInitStatus.value(), paramString);
      }
    }
    else
    {
      if (isDebugMode())
      {
        loadModule("index.android.jsbundle");
        return;
      }
      loadModule();
    }
  }
  
  public void onLoadFail(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load so error statusCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("HippyQQEngine", 1, ((StringBuilder)localObject).toString());
    localObject = this.mEngineListener;
    if (localObject != null) {
      ((HippyQQEngine.HippyQQEngineListener)localObject).onError(paramInt, paramString);
    }
  }
  
  public void onLoadSuccess()
  {
    this.mMapLoadStepsTime.put("loadLibEnd", Long.valueOf(System.currentTimeMillis()));
    initHippyEngine();
  }
  
  public void onPause()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPause ");
    ((StringBuilder)localObject).append(this.mModuleName);
    ((StringBuilder)localObject).append(" this:");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" engine:");
    ((StringBuilder)localObject).append(this.mHippyEngine);
    QLog.i("HippyQQEngine", 1, ((StringBuilder)localObject).toString());
    localObject = this.mHippyEngine;
    if (localObject != null)
    {
      ((HippyEngine)localObject).sendEvent("PageDisappear", null);
      this.mHippyEngine.onEnginePause();
    }
  }
  
  public void onResume()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResume ");
    ((StringBuilder)localObject).append(this.mModuleName);
    ((StringBuilder)localObject).append(" this:");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" engine:");
    ((StringBuilder)localObject).append(this.mHippyEngine);
    ((StringBuilder)localObject).append(" mIsResumed:");
    ((StringBuilder)localObject).append(this.mIsResumed);
    ((StringBuilder)localObject).append(" mIsPageLoaded:");
    ((StringBuilder)localObject).append(this.mIsPageLoaded);
    QLog.i("HippyQQEngine", 1, ((StringBuilder)localObject).toString());
    this.mIsResumed = true;
    localObject = this.mHippyEngine;
    if (localObject != null)
    {
      ((HippyEngine)localObject).onEngineResume();
      if (this.mIsPageLoaded) {
        this.mHippyEngine.sendEvent("PageAppear", null);
      }
    }
  }
  
  public void registerNativeMethod(String paramString1, String paramString2, TJsCallBack paramTJsCallBack)
  {
    this.nativeProxy.registerNativeMethod(paramString1, paramString2, paramTJsCallBack);
  }
  
  public void reload(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener) {}
  
  public void sendEvent(String paramString, Object paramObject)
  {
    HippyEngine localHippyEngine = this.mHippyEngine;
    if (localHippyEngine != null) {
      localHippyEngine.sendEvent(paramString, paramObject);
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine
 * JD-Core Version:    0.7.0.1
 */