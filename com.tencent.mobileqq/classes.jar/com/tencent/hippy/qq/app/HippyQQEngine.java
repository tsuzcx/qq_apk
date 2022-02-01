package com.tencent.hippy.qq.app;

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
import com.tencent.hippy.qq.module.tkd.TKDJsCallBack;
import com.tencent.hippy.qq.module.tkd.TKDNativeProxy;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.HippyQQLibraryManager.LibraryLoadListener;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.EngineInitParams;
import com.tencent.mtt.hippy.HippyEngine.EngineState;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
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
  protected static final String TAG = "HippyQQEngine";
  private static String mDebugMoudleName = "Demo";
  private static String mDebugServerHost = "localhost:38989";
  private static boolean mDebugSwitch;
  public static SparseArray<WeakReference<HippyQQEngine>> mEngines = new SparseArray();
  private static HashMap<String, Long> mModuleUpdateTime = new HashMap();
  protected String componentName;
  private JSONObject mBusinessData;
  private ViewGroup mContainer;
  protected HippyQQEngine.HippyQQEngineListener mEngineListener;
  protected Fragment mFragment;
  private JSONObject mGlobalData;
  private HippyEngine mHippyEngine;
  private HippyRootView mHippyRootView;
  private String mJsBundleType = "vue";
  protected HashMap<String, Long> mMapLoadStepsTime = new HashMap();
  private String mModuleName;
  protected int mModuleVersion;
  private JSONObject mPageData;
  private HippyQQUpdateManager mUpdateManager;
  protected String mUrl;
  @androidx.annotation.NonNull
  private final TKDNativeProxy nativeProxy;
  private HippyMap propsMap;
  protected List<HippyAPIProvider> providers = new ArrayList();
  protected HippyCustomViewCreator viewCreator;
  
  public HippyQQEngine(Fragment paramFragment, String paramString1, String paramString2)
  {
    this.mFragment = paramFragment;
    this.mModuleName = paramString1;
    this.mUrl = paramString2;
    this.nativeProxy = new TKDNativeProxy();
    initJsBundleTypeFromUrl();
  }
  
  public static void dispatchEvent(String paramString1, String paramString2, HippyMap paramHippyMap)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      int i = 0;
      try
      {
        if (i >= mEngines.size()) {
          continue;
        }
        Object localObject = (WeakReference)mEngines.valueAt(i);
        if (localObject != null) {}
        for (localObject = (HippyQQEngine)((WeakReference)localObject).get();; localObject = null)
        {
          if ((localObject != null) && ((TextUtils.isEmpty(paramString2)) || (paramString2.equals(((HippyQQEngine)localObject).mModuleName))))
          {
            localObject = ((HippyQQEngine)localObject).mHippyEngine;
            if ((localObject != null) && (((HippyEngine)localObject).getEngineState() == HippyEngine.EngineState.INITED)) {
              ((EventDispatcher)((HippyEngine)localObject).getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString1, paramHippyMap);
            }
          }
          i += 1;
          break;
        }
        return;
      }
      catch (Throwable paramString1) {}
    }
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
  
  @NotNull
  private HippyMap getJsParamsMap(HippyEngine.ModuleLoadParams paramModuleLoadParams)
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
  
  @NotNull
  private Map<String, Object> getNativeParams()
  {
    HashMap localHashMap = new HashMap();
    if (this.viewCreator != null) {
      localHashMap.put("CustomViewCreator", this.viewCreator);
    }
    return localHashMap;
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
      paramString = FileUtils.readObject("viola_cache_file_" + paramString + "_" + localAppRuntime.getAccount());
      if ((paramString instanceof String)) {
        return (String)paramString;
      }
      return null;
    }
    return null;
  }
  
  private boolean isFragmentDestroyed()
  {
    if ((this.mFragment == null) || (this.mFragment.getActivity() == null))
    {
      if (this.mEngineListener != null) {
        this.mEngineListener.onError(-11, "fragment or activity destroyed!");
      }
      return true;
    }
    return false;
  }
  
  public static boolean isMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public static void onDebugModuleAndPortChanged(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      mDebugMoudleName = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      mDebugServerHost = paramString2;
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
  
  public void doOnBackPressed() {}
  
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
      HippyReporter.getInstance().reportCheckUpdate(this.mModuleName, this.mModuleVersion, paramInt, paramString1, l - paramLong);
      return;
      paramString2 = "check package update error: " + paramString1;
      LogUtils.e("hippy", paramString2);
      if ((this.mModuleVersion <= 0) && (this.mEngineListener != null)) {
        this.mEngineListener.onError(paramInt, paramString2);
      }
    }
  }
  
  public Fragment getFragment()
  {
    return this.mFragment;
  }
  
  public HippyEngine getHippyEngine()
  {
    return this.mHippyEngine;
  }
  
  protected Context getInitHippyEngineContext()
  {
    if ((this.mFragment != null) && (this.mFragment.getActivity() != null)) {
      return this.mFragment.getActivity();
    }
    return BaseApplicationImpl.getContext().getApplicationContext();
  }
  
  public String getJsBundleType()
  {
    return this.mJsBundleType;
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
  
  @androidx.annotation.NonNull
  public TKDNativeProxy getNativeProxy()
  {
    return this.nativeProxy;
  }
  
  public void initHippy(@android.support.annotation.NonNull ViewGroup paramViewGroup, @android.support.annotation.NonNull JSONObject paramJSONObject, boolean paramBoolean, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    this.mContainer = ((ViewGroup)paramViewGroup.findViewById(2131381217));
    initHippyInContainer(this.mContainer, paramJSONObject, paramBoolean, paramHippyQQEngineListener);
  }
  
  protected void initHippyEngine()
  {
    if (!isCanInitHippyEngine()) {
      return;
    }
    if ((!TextUtils.isEmpty(this.mJsBundleType)) && (this.mJsBundleType.equals("react"))) {}
    for (String str = "react.android.js";; str = "vue.android.js")
    {
      str = HippyQQLibraryManager.getInstance().getCoreJsFilePath(str);
      if (!TextUtils.isEmpty(str)) {
        break label89;
      }
      QLog.d("Hippy", 1, "could not found core js file!");
      if (this.mEngineListener == null) {
        break;
      }
      this.mEngineListener.onError(-10, "could not found core js file!");
      return;
    }
    label89:
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
    localEngineInitParams.exceptionHandler = new HippyQQEngine.3(this);
    this.providers.add(new HippyQQAPIProvider());
    localEngineInitParams.providers = this.providers;
    this.mHippyEngine = HippyEngine.create(localEngineInitParams);
    mEngines.put(this.mHippyEngine.getId(), new WeakReference(this));
    this.mHippyEngine.initEngine(new HippyQQEngine.4(this));
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
    if (TextUtils.isEmpty(this.mUrl)) {}
    for (;;)
    {
      return;
      try
      {
        String str = Uri.parse(this.mUrl).getQueryParameter("framework");
        if (!TextUtils.isEmpty(str))
        {
          this.mJsBundleType = str;
          return;
        }
      }
      catch (Exception localException) {}
    }
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
    return !isFragmentDestroyed();
  }
  
  protected boolean isDebugMode()
  {
    return false;
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
  }
  
  protected void loadModule(String paramString)
  {
    if (isFragmentDestroyed()) {
      return;
    }
    HippyEngine.ModuleLoadParams localModuleLoadParams = new HippyEngine.ModuleLoadParams();
    localModuleLoadParams.context = this.mFragment.getActivity();
    if (TextUtils.isEmpty(this.componentName)) {}
    for (String str = this.mModuleName;; str = this.componentName)
    {
      localModuleLoadParams.componentName = str;
      localModuleLoadParams.jsFilePath = paramString;
      localModuleLoadParams.nativeParams = getNativeParams();
      localModuleLoadParams.jsParams = getJsParamsMap(localModuleLoadParams);
      this.mMapLoadStepsTime.put("loadModuleStart", Long.valueOf(System.currentTimeMillis()));
      this.mHippyRootView = this.mHippyEngine.loadModule(localModuleLoadParams, new HippyQQEngine.2(this));
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
    if (this.mHippyEngine != null)
    {
      mEngines.remove(this.mHippyEngine.getId());
      this.mHippyEngine.destroyModule(this.mHippyRootView);
      this.mHippyEngine.destroyEngine();
      this.mFragment = null;
      this.mEngineListener = null;
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
    if (this.mHippyEngine != null) {
      this.mHippyEngine.onEnginePause();
    }
  }
  
  public void onResume()
  {
    if (this.mHippyEngine != null) {
      this.mHippyEngine.onEngineResume();
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
  
  public void setComponentName(String paramString)
  {
    this.componentName = paramString;
  }
  
  @Deprecated
  public void setDebugMode(boolean paramBoolean) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine
 * JD-Core Version:    0.7.0.1
 */