package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.utils.HippyErrorManager;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseHippyFragment
  extends QPublicBaseFragment
  implements HippyActivityLifecycleOwner
{
  protected static final String TAG = "BaseHippyFragment";
  private boolean isHandleBackEvent = true;
  private long mCreateViewStartTime;
  private HippyActivityLifecycleDispatcher mDispatcher = new HippyActivityLifecycleDispatcher();
  private Bundle mEmptyBundle = new Bundle();
  protected HippyQQPreloadEngine mHippyQQEngine;
  private boolean mIsDisablePreload = false;
  private boolean mIsPageAppeared = true;
  private long mLoadHippyStartTime;
  private String mModuleName;
  private String mUrl;
  
  private void doActivityBack()
  {
    if (getQBaseActivity() != null) {
      getQBaseActivity().doOnBackPressed();
    }
  }
  
  private int getModuleVersion()
  {
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
    if (localHippyQQPreloadEngine != null) {
      return localHippyQQPreloadEngine.getModuleVersion();
    }
    return 0;
  }
  
  private void initHippy(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    if (this.mHippyQQEngine == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    Object localObject = localJSONObject;
    if (paramBundle != null)
    {
      localObject = localJSONObject;
      if (paramBundle.containsKey("param")) {
        try
        {
          localObject = new JSONObject(paramBundle.getString("param"));
        }
        catch (JSONException paramBundle)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initHippy error:");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.e("BaseHippyFragment", 1, ((StringBuilder)localObject).toString());
          localObject = localJSONObject;
        }
      }
    }
    if (!this.mHippyQQEngine.isReady()) {
      QLog.e("BaseHippyFragment", 1, "HippyQQEngine not ready");
    }
    this.mHippyQQEngine.initHippyInContainer(paramViewGroup, (JSONObject)localObject, false, new BaseHippyFragment.2(this));
  }
  
  private void printPerformanceData(HashMap<String, Long> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hippy Performancedata isPreload:");
    Object localObject = this.mHippyQQEngine;
    boolean bool;
    if (localObject != null) {
      bool = ((HippyQQPreloadEngine)localObject).isPreloaded();
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(',');
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      localObject = (Map.Entry)paramHashMap.next();
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append(':');
      localStringBuilder.append(((Map.Entry)localObject).getValue());
      localStringBuilder.append(',');
    }
    QLog.i("BaseHippyFragment", 2, localStringBuilder.toString());
  }
  
  protected abstract JSONObject doBussinessInitData(JSONObject paramJSONObject);
  
  protected HashMap<String, Long> generateStepCosts()
  {
    Object localObject = getPerformanceData();
    long l1;
    if (((HashMap)localObject).containsKey("openPageStart")) {
      l1 = ((Long)((HashMap)localObject).get("openPageStart")).longValue();
    } else {
      l1 = 0L;
    }
    long l2;
    if (((HashMap)localObject).containsKey("pageCreateStart")) {
      l2 = ((Long)((HashMap)localObject).get("pageCreateStart")).longValue();
    } else {
      l2 = 0L;
    }
    long l3;
    if (((HashMap)localObject).containsKey("loadHippyStart")) {
      l3 = ((Long)((HashMap)localObject).get("loadHippyStart")).longValue();
    } else {
      l3 = 0L;
    }
    long l4;
    if (((HashMap)localObject).containsKey("loadLibStart")) {
      l4 = ((Long)((HashMap)localObject).get("loadLibStart")).longValue();
    } else {
      l4 = 0L;
    }
    long l5;
    if (((HashMap)localObject).containsKey("loadLibEnd")) {
      l5 = ((Long)((HashMap)localObject).get("loadLibEnd")).longValue();
    } else {
      l5 = 0L;
    }
    long l6;
    if (((HashMap)localObject).containsKey("initEngineEnd")) {
      l6 = ((Long)((HashMap)localObject).get("initEngineEnd")).longValue();
    } else {
      l6 = 0L;
    }
    long l7;
    if (((HashMap)localObject).containsKey("loadModuleStart")) {
      l7 = ((Long)((HashMap)localObject).get("loadModuleStart")).longValue();
    } else {
      l7 = 0L;
    }
    long l8;
    if (((HashMap)localObject).containsKey("loadModuleEnd")) {
      l8 = ((Long)((HashMap)localObject).get("loadModuleEnd")).longValue();
    } else {
      l8 = 0L;
    }
    localObject = new LinkedHashMap();
    if ((l2 > 0L) && (l1 > 0L)) {
      ((LinkedHashMap)localObject).put("ActivityCreate", Long.valueOf(l2 - l1));
    }
    if ((l3 > 0L) && (l2 > 0L)) {
      ((LinkedHashMap)localObject).put("containerCreate", Long.valueOf(l3 - l2));
    }
    if ((l4 > 0L) && (l3 > 0L)) {
      ((LinkedHashMap)localObject).put("prepareData", Long.valueOf(l4 - l3));
    }
    if ((l5 > 0L) && (l4 > 0L)) {
      ((LinkedHashMap)localObject).put("loadLibrary", Long.valueOf(l5 - l4));
    }
    if ((l6 > 0L) && (l5 > 0L)) {
      ((LinkedHashMap)localObject).put("initEngine", Long.valueOf(l6 - l5));
    }
    if ((l7 > 0L) && (l6 > 0L)) {
      ((LinkedHashMap)localObject).put("checkJsBundle", Long.valueOf(l7 - l6));
    }
    if ((l8 > 0L) && (l7 > 0L)) {
      ((LinkedHashMap)localObject).put("loadJsBundle", Long.valueOf(l8 - l7));
    }
    if ((l8 > 0L) && (l1 > 0L)) {
      ((LinkedHashMap)localObject).put("total", Long.valueOf(l8 - l1));
    }
    return localObject;
  }
  
  @NotNull
  public HippyActivityLifecycleDispatcher getActivityLifecycleDispatcher()
  {
    return this.mDispatcher;
  }
  
  protected String getLastStepName()
  {
    HashMap localHashMap = getPerformanceData();
    Iterator localIterator = localHashMap.keySet().iterator();
    Object localObject = "";
    long l = 0L;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Long)localHashMap.get(str)).longValue() > l)
      {
        l = ((Long)localHashMap.get(str)).longValue();
        localObject = str;
      }
    }
    return localObject;
  }
  
  public String getModuleName()
  {
    return this.mModuleName;
  }
  
  protected Bundle getParameters()
  {
    Bundle localBundle1;
    if (getArguments() != null) {
      localBundle1 = getArguments().getBundle("params");
    } else {
      localBundle1 = null;
    }
    Bundle localBundle2 = localBundle1;
    if (localBundle1 == null) {
      localBundle2 = this.mEmptyBundle;
    }
    return localBundle2;
  }
  
  public HashMap<String, Long> getPerformanceData()
  {
    HashMap localHashMap = new HashMap();
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
    if (localHippyQQPreloadEngine != null) {
      localHashMap.putAll(localHippyQQPreloadEngine.getLoadStepsTime());
    }
    localHashMap.put("pageCreateStart", Long.valueOf(this.mCreateViewStartTime));
    localHashMap.put("loadHippyStart", Long.valueOf(this.mLoadHippyStartTime));
    long l2 = getParameters().getLong("openPageStart");
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = this.mCreateViewStartTime;
    }
    localHashMap.put("openPageStart", Long.valueOf(l1));
    return localHashMap;
  }
  
  protected boolean gotoErrorUrl()
  {
    String str1 = getParameters().getString("errorUrl");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Hippy: initHippy errorUrl:");
    ((StringBuilder)localObject).append(str1);
    QLog.d("BaseHippyFragment", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    localObject = getQBaseActivity();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return false;
      }
      String str2 = this.mModuleName;
      if ((str2 != null) && (str2.startsWith("QQGameCenter")))
      {
        ((IHippyUtils)QRoute.api(IHippyUtils.class)).gotoGameCenterErrorUrl((Activity)localObject, str1);
      }
      else
      {
        str2 = this.mModuleName;
        if ((str2 != null) && ((str2.startsWith("SGameOfficial")) || (this.mModuleName.startsWith("SGameOfficialV2")))) {
          ((IHippyUtils)QRoute.api(IHippyUtils.class)).gotoGamePubAccountErrorUrl((Activity)localObject, str1);
        } else {
          ((IHippyUtils)QRoute.api(IHippyUtils.class)).gotoBrowserActivity((Activity)localObject, str1);
        }
      }
      ((Activity)localObject).finish();
      return true;
    }
    return false;
  }
  
  public boolean isFragmentDestroyed()
  {
    return (getQBaseActivity() == null) || (getQBaseActivity().isFinishing());
  }
  
  public boolean isWrapContent()
  {
    return getParameters().getBoolean("isEnbaleRightFling");
  }
  
  protected void loadHippy(ViewGroup paramViewGroup)
  {
    this.mLoadHippyStartTime = System.currentTimeMillis();
    this.mUrl = getParameters().getString("url");
    Object localObject3 = getParameters().getString("bundleName");
    Object localObject4 = getParameters().getString("bundleUrl");
    String str1 = getParameters().getString("domain");
    String str2 = getParameters().getString("framework");
    Object localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(this.mUrl))
      {
        localObject1 = localObject3;
        if (!this.mUrl.contains("v_bundleName")) {}
      }
    }
    try
    {
      localObject1 = Uri.parse(this.mUrl).getQueryParameter("v_bundleName");
      this.mModuleName = ((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      this.mHippyQQEngine = null;
      if (!this.mIsDisablePreload) {
        this.mHippyQQEngine = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).getPreloadedHippyQQEngine((String)localObject1);
      }
      localObject3 = this.mHippyQQEngine;
      if (localObject3 == null)
      {
        this.mHippyQQEngine = new HippyQQPreloadEngine(this, (String)localObject1, this.mUrl);
      }
      else
      {
        ((HippyQQPreloadEngine)localObject3).setFragment(this);
        this.mHippyQQEngine.setHippyActivityLifecycleOwner(this);
        this.mHippyQQEngine.setPageUrl(this.mUrl);
      }
      this.mHippyQQEngine.setBundleUrl((String)localObject4);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("HippyQQEngine:");
      ((StringBuilder)localObject3).append(this.mHippyQQEngine);
      ((StringBuilder)localObject3).append(" isPreload:");
      ((StringBuilder)localObject3).append(this.mHippyQQEngine.isPreloaded());
      ((StringBuilder)localObject3).append(" isPredraw:");
      ((StringBuilder)localObject3).append(this.mHippyQQEngine.isPredraw());
      QLog.i("BaseHippyFragment", 1, ((StringBuilder)localObject3).toString());
      if (!TextUtils.isEmpty(str2))
      {
        localObject3 = "react";
        if ((str2.contains("react")) || (str2.contains("vue")))
        {
          localObject4 = this.mHippyQQEngine;
          if (!str2.contains("react")) {
            localObject3 = "vue";
          }
          ((HippyQQPreloadEngine)localObject4).setJsBundleType((String)localObject3);
        }
      }
      localObject3 = getQBaseActivity();
      if (localObject3 != null)
      {
        localObject1 = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).getJSInitData(((QBaseActivity)localObject3).getAppRuntime(), (String)localObject1, this.mUrl, str1);
        localObject3 = doBussinessInitData((JSONObject)localObject1);
        if (localObject3 != null) {
          this.mHippyQQEngine.setInitData((JSONObject)localObject3, (JSONObject)localObject3);
        } else {
          this.mHippyQQEngine.setInitData((JSONObject)localObject1, (JSONObject)localObject1);
        }
      }
      initHippy(getParameters(), paramViewGroup);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityCreated this:");
    localStringBuilder.append(this);
    QLog.i("BaseHippyFragment", 1, localStringBuilder.toString());
    this.mDispatcher.onActivityCreated(getQBaseActivity(), paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mDispatcher.onActivityResult(getQBaseActivity(), paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (!this.isHandleBackEvent) {
      return false;
    }
    return this.mHippyQQEngine.doOnBackPressed(new BaseHippyFragment.1(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateView this:");
    localStringBuilder.append(this);
    QLog.i("BaseHippyFragment", 1, localStringBuilder.toString());
    this.mCreateViewStartTime = System.currentTimeMillis();
    this.mIsDisablePreload = getParameters().getBoolean("isDisablePreload");
    LiuHaiUtils.a(getActivity());
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.mDispatcher.onActivityDestroyed(getQBaseActivity());
    this.mDispatcher.clearAllListener();
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
    if (localHippyQQPreloadEngine != null)
    {
      localHippyQQPreloadEngine.onDestroy();
      if (!this.mIsDisablePreload) {
        preloadEngine();
      }
    }
    HippyErrorManager.getInstance().endAllOperation();
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (!this.mIsDisablePreload) {
      preloadEngine();
    }
  }
  
  protected void onLoadHippyError(int paramInt, String paramString) {}
  
  protected final void onLoadHippyFinish(int paramInt, String paramString)
  {
    HashMap localHashMap1 = generateStepCosts();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("ret", Integer.valueOf(paramInt));
    localHashMap2.put("errMsg", paramString);
    paramString = this.mHippyQQEngine;
    boolean bool2 = false;
    if (paramString != null) {
      bool1 = paramString.isPreloaded();
    } else {
      bool1 = false;
    }
    localHashMap2.put("isPreload", Boolean.valueOf(bool1));
    paramString = this.mHippyQQEngine;
    boolean bool1 = bool2;
    if (paramString != null) {
      bool1 = paramString.isPredraw();
    }
    localHashMap2.put("isPredraw", Boolean.valueOf(bool1));
    localHashMap2.put("from", getParameters().getString("from"));
    HippyReporter.getInstance().reportHippyLoadResult(3, this.mModuleName, getModuleVersion(), localHashMap2, localHashMap1);
    if (QLog.isColorLevel()) {
      printPerformanceData(localHashMap1);
    }
    HippyErrorManager.getInstance().endAllOperation();
  }
  
  protected void onLoadHippySuccess() {}
  
  public void onPause()
  {
    super.onPause();
    if (this.mIsPageAppeared)
    {
      this.mDispatcher.onActivityPaused(getQBaseActivity());
      HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
      if (localHippyQQPreloadEngine != null) {
        localHippyQQPreloadEngine.onPause();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mIsPageAppeared)
    {
      this.mDispatcher.onActivityResumed(getQBaseActivity());
      HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
      if (localHippyQQPreloadEngine != null) {
        localHippyQQPreloadEngine.onResume();
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mDispatcher.onActivitySaveInstanceState(getQBaseActivity(), paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.mDispatcher.onActivityStarted(getQBaseActivity());
  }
  
  public void onStop()
  {
    super.onStop();
    this.mDispatcher.onActivityStopped(getQBaseActivity());
  }
  
  protected void preloadEngine()
  {
    Object localObject = this.mHippyQQEngine;
    if (localObject != null)
    {
      boolean bool1 = ((HippyQQPreloadEngine)localObject).isPreloaded();
      boolean bool2 = false;
      if ((!bool1) && (!getParameters().getBoolean("isPreloadWhenClosed"))) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if ((this.mHippyQQEngine.isPredraw()) || (getParameters().getBoolean("isPredrawWhenClosed"))) {
        bool2 = true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadEngine isPreload:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" isPredraw:");
        ((StringBuilder)localObject).append(bool2);
        QLog.d("BaseHippyFragment", 2, ((StringBuilder)localObject).toString());
      }
      if ((bool1) || (bool2))
      {
        localObject = new OpenHippyInfo();
        ((OpenHippyInfo)localObject).bundleName = this.mModuleName;
        ((OpenHippyInfo)localObject).url = this.mUrl;
        ((OpenHippyInfo)localObject).isPreload = bool1;
        ((OpenHippyInfo)localObject).isPredraw = bool2;
        ((OpenHippyInfo)localObject).processName = "local";
        ((OpenHippyInfo)localObject).isPreloadFromExitPage = true;
        ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage((OpenHippyInfo)localObject);
      }
    }
  }
  
  public void sendHippyNativeEvent(String paramString, HippyMap paramHippyMap)
  {
    try
    {
      if ((this.mHippyQQEngine != null) && (paramHippyMap != null) && (!TextUtils.isEmpty(paramString)))
      {
        ((EventDispatcher)this.mHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramHippyMap);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("sendHippyNativeEvent fail:");
      paramHippyMap.append(paramString.getMessage());
      QLog.d("BaseHippyFragment", 1, paramHippyMap.toString());
    }
  }
  
  public void setPageAppeared(boolean paramBoolean)
  {
    this.mIsPageAppeared = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.BaseHippyFragment
 * JD-Core Version:    0.7.0.1
 */