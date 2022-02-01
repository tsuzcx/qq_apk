package com.tencent.hippy.qq.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import bgmg;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.adapter.HippyQQFontAdapter;
import com.tencent.hippy.qq.adapter.HippyQQImageLoader;
import com.tencent.hippy.qq.adapter.HippyQQThirdPartyAdapter;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.HippyQQLibraryManager.LibraryLoadListener;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngine.EngineInitParams;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class HippyQQEngine
  implements HippyQQLibraryManager.LibraryLoadListener
{
  protected static final String TAG = "HippyQQEngine";
  public static SparseArray<HippyQQEngine> mEngines = new SparseArray();
  private static HashMap<String, Long> mModuleUpdateTime = new HashMap();
  private ViewGroup mContainer;
  private HippyQQEngine.HippyQQEngineListener mEngineListener;
  private ViolaFragment mFragment;
  private HippyEngine mHippyEngine;
  private HippyRootView mHippyRootView;
  private JSONObject mInitData;
  private boolean mIsDebugMode;
  private String mJsBundleType = "vue";
  private String mModuleName;
  private int mModuleVersion;
  private JSONObject mPageData;
  private HippyQQUpdateManager mUpdateManager;
  
  public HippyQQEngine(ViolaFragment paramViolaFragment, String paramString)
  {
    this.mFragment = paramViolaFragment;
    this.mModuleName = paramString;
    initJsBundleTypeFromUrl();
  }
  
  private void checkPackageUpdate()
  {
    long l1;
    if (!TextUtils.isEmpty(this.mModuleName))
    {
      l1 = System.currentTimeMillis();
      if (mModuleUpdateTime.containsKey(this.mModuleName))
      {
        long l2 = ((Long)mModuleUpdateTime.get(this.mModuleName)).longValue();
        if ((this.mModuleVersion <= 0) || (l2 <= 0L) || (l1 - l2 >= 1800000L)) {}
      }
    }
    else
    {
      return;
    }
    mModuleUpdateTime.put(this.mModuleName, Long.valueOf(l1));
    this.mUpdateManager = new HippyQQUpdateManager();
    this.mUpdateManager.checkUpdate(this.mModuleName, this.mModuleVersion, new HippyQQEngine.1(this));
  }
  
  public static HippyQQEngine getEngineInstance(int paramInt)
  {
    return (HippyQQEngine)mEngines.get(paramInt);
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
      paramString = bgmg.a("viola_cache_file_" + paramString + "_" + localAppRuntime.getAccount());
      if ((paramString instanceof String)) {
        return (String)paramString;
      }
      return null;
    }
    return null;
  }
  
  private void initHippyEngine()
  {
    if (isFragmentDestroyed()) {
      return;
    }
    if ((!TextUtils.isEmpty(this.mJsBundleType)) && (this.mJsBundleType.equals("react"))) {}
    for (Object localObject1 = "react.android.js";; localObject1 = "vue.android.js")
    {
      localObject2 = HippyQQFileUtil.getCoreJsFilePath((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label72;
      }
      if (this.mEngineListener == null) {
        break;
      }
      this.mEngineListener.onError(-10, "could not found core js file!");
      return;
    }
    label72:
    localObject1 = new HippyEngine.EngineInitParams();
    ((HippyEngine.EngineInitParams)localObject1).context = this.mFragment.getActivity();
    ((HippyEngine.EngineInitParams)localObject1).imageLoader = new HippyQQImageLoader();
    ((HippyEngine.EngineInitParams)localObject1).fontScaleAdapter = new HippyQQFontAdapter();
    ((HippyEngine.EngineInitParams)localObject1).thirdPartyAdapter = new HippyQQThirdPartyAdapter();
    ((HippyEngine.EngineInitParams)localObject1).thirdPartyAdapter.setPageUrl(this.mFragment.a());
    ((HippyEngine.EngineInitParams)localObject1).debugMode = this.mIsDebugMode;
    ((HippyEngine.EngineInitParams)localObject1).enableLog = false;
    ((HippyEngine.EngineInitParams)localObject1).coreJSFilePath = ((String)localObject2);
    ((HippyEngine.EngineInitParams)localObject1).exceptionHandler = new HippyQQEngine.3(this);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(new HippyQQAPIProvider());
    ((HippyEngine.EngineInitParams)localObject1).providers = ((List)localObject2);
    this.mHippyEngine = HippyEngine.create((HippyEngine.EngineInitParams)localObject1);
    mEngines.put(this.mHippyEngine.getId(), this);
    this.mHippyEngine.initEngine(new HippyQQEngine.4(this));
  }
  
  private void initJsBundleTypeFromUrl()
  {
    String str = this.mFragment.a();
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return;
      try
      {
        str = Uri.parse(str).getQueryParameter("framework");
        if (!TextUtils.isEmpty(str))
        {
          this.mJsBundleType = str;
          return;
        }
      }
      catch (Exception localException) {}
    }
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
  
  private void loadModule(String paramString)
  {
    if (isFragmentDestroyed()) {
      return;
    }
    HippyEngine.ModuleLoadParams localModuleLoadParams = new HippyEngine.ModuleLoadParams();
    localModuleLoadParams.context = this.mFragment.getActivity();
    localModuleLoadParams.componentName = this.mModuleName;
    localModuleLoadParams.jsFilePath = paramString;
    localModuleLoadParams.jsParams = new HippyMap();
    localModuleLoadParams.jsParams.pushString("msgFromNative", "Hi js developer, I come from native code!");
    if (this.mInitData != null) {
      localModuleLoadParams.jsParams.pushString("cookie", this.mInitData.toString());
    }
    this.mHippyRootView = this.mHippyEngine.loadModule(localModuleLoadParams, new HippyQQEngine.2(this));
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
  
  public void doOnBackPressed() {}
  
  public Fragment getFragment()
  {
    return this.mFragment;
  }
  
  public HippyEngine getHippyEngine()
  {
    return this.mHippyEngine;
  }
  
  public void initHippy(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    this.mModuleVersion = 0;
    this.mPageData = paramJSONObject;
    this.mEngineListener = paramHippyQQEngineListener;
    this.mContainer = ((ViewGroup)paramViewGroup.findViewById(2131380966));
    HippyQQLibraryManager.getInstance().loadLibraryIfNeed(this);
  }
  
  public boolean isReady()
  {
    if (!HippyQQLibraryManager.getInstance().isLibraryLoaded()) {}
    File localFile;
    do
    {
      return false;
      int i = UpdateSetting.getInstance().getModuleVersion(this.mModuleName);
      if (i == -1) {
        break;
      }
      localFile = HippyQQFileUtil.getModuleIndex(this.mModuleName, i);
    } while ((localFile == null) || (!localFile.exists()));
    return true;
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
  
  public void onLoadFail(int paramInt, String paramString)
  {
    if (this.mEngineListener != null) {
      this.mEngineListener.onError(paramInt, paramString);
    }
  }
  
  public void onLoadSuccess()
  {
    initHippyEngine();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void reload(HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener) {}
  
  public void setDebugMode(boolean paramBoolean)
  {
    this.mIsDebugMode = paramBoolean;
  }
  
  public void setInitData(JSONObject paramJSONObject)
  {
    this.mInitData = paramJSONObject;
  }
  
  public void setJsBundleType(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mJsBundleType = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine
 * JD-Core Version:    0.7.0.1
 */