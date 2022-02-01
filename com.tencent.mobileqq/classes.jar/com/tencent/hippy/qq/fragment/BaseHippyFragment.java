package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.utils.HippyErrorManager;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
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
  private String mDomain;
  private Bundle mEmptyBundle = new Bundle();
  protected HippyQQPreloadEngine mHippyQQEngine;
  private boolean mIsDisablePreload = false;
  private boolean mIsPageAppeared = true;
  private String mJsBundleFramework;
  private String mJsBundleUrl;
  private long mLoadHippyStartTime;
  private String mModuleName;
  private int mUpdateJsBundleType = 0;
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
  
  private long getValueFromStepCosts(String paramString, HashMap<String, Long> paramHashMap)
  {
    if (paramHashMap.containsKey(paramString)) {
      return ((Long)paramHashMap.get(paramString)).longValue();
    }
    return 0L;
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
  
  private void readParameters()
  {
    this.mUrl = getParameters().getString("url");
    this.mModuleName = getParameters().getString("bundleName");
    this.mJsBundleUrl = getParameters().getString("bundleUrl");
    this.mDomain = getParameters().getString("domain");
    this.mJsBundleFramework = getParameters().getString("framework");
    this.mUpdateJsBundleType = getParameters().getInt("updateJsBundleType");
    if ((TextUtils.isEmpty(this.mModuleName)) && (!TextUtils.isEmpty(this.mUrl)) && (this.mUrl.contains("v_bundleName"))) {}
    try
    {
      this.mModuleName = Uri.parse(this.mUrl).getQueryParameter("v_bundleName");
      return;
    }
    catch (Exception localException) {}
  }
  
  protected abstract JSONObject doBussinessInitData(JSONObject paramJSONObject);
  
  protected HashMap<String, Long> generateStepCosts()
  {
    Object localObject = getPerformanceData();
    long l1 = getValueFromStepCosts("openPageStart", (HashMap)localObject);
    long l2 = getValueFromStepCosts("pageCreateStart", (HashMap)localObject);
    long l3 = getValueFromStepCosts("loadHippyStart", (HashMap)localObject);
    long l4 = getValueFromStepCosts("loadLibStart", (HashMap)localObject);
    long l5 = getValueFromStepCosts("loadLibEnd", (HashMap)localObject);
    long l6 = getValueFromStepCosts("initEngineEnd", (HashMap)localObject);
    long l7 = getValueFromStepCosts("loadModuleStart", (HashMap)localObject);
    long l8 = getValueFromStepCosts("loadModuleEnd", (HashMap)localObject);
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
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startGameCenterActivity((Context)localObject, str1);
      }
      else
      {
        str2 = this.mModuleName;
        if ((str2 != null) && ((str2.startsWith("SGameOfficial")) || (this.mModuleName.startsWith("SGameOfficialV2")))) {
          HippyUtils.gotoGamePubAccountErrorUrl((Activity)localObject, str1);
        } else {
          HippyUtils.gotoBrowserActivity((Activity)localObject, str1);
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
    readParameters();
    if (TextUtils.isEmpty(this.mModuleName)) {
      return;
    }
    this.mHippyQQEngine = null;
    if (!this.mIsDisablePreload) {
      this.mHippyQQEngine = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).getPreloadedHippyQQEngine(this.mModuleName);
    }
    Object localObject1 = this.mHippyQQEngine;
    if (localObject1 == null)
    {
      this.mHippyQQEngine = new HippyQQPreloadEngine(this, this.mModuleName, this.mUrl);
    }
    else
    {
      ((HippyQQPreloadEngine)localObject1).setFragment(this);
      this.mHippyQQEngine.setHippyActivityLifecycleOwner(this);
      this.mHippyQQEngine.setPageUrl(this.mUrl);
    }
    this.mHippyQQEngine.setBundleUrl(this.mJsBundleUrl);
    this.mHippyQQEngine.setUpdateJsBundleType(this.mUpdateJsBundleType);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("HippyQQEngine:");
    ((StringBuilder)localObject1).append(this.mHippyQQEngine);
    ((StringBuilder)localObject1).append(" isPreload:");
    ((StringBuilder)localObject1).append(this.mHippyQQEngine.isPreloaded());
    ((StringBuilder)localObject1).append(" isPredraw:");
    ((StringBuilder)localObject1).append(this.mHippyQQEngine.isPredraw());
    QLog.i("BaseHippyFragment", 1, ((StringBuilder)localObject1).toString());
    Object localObject2;
    if (!TextUtils.isEmpty(this.mJsBundleFramework))
    {
      localObject2 = this.mJsBundleFramework;
      localObject1 = "react";
      if ((((String)localObject2).contains("react")) || (this.mJsBundleFramework.contains("vue")))
      {
        localObject2 = this.mHippyQQEngine;
        if (!this.mJsBundleFramework.contains("react")) {
          localObject1 = "vue";
        }
        ((HippyQQPreloadEngine)localObject2).setJsBundleType((String)localObject1);
      }
    }
    localObject1 = getQBaseActivity();
    if (localObject1 != null)
    {
      localObject1 = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).getJSInitData(((QBaseActivity)localObject1).getAppRuntime(), this.mModuleName, this.mUrl, this.mDomain);
      localObject2 = doBussinessInitData((JSONObject)localObject1);
      if (localObject2 != null) {
        this.mHippyQQEngine.setInitData((JSONObject)localObject2, (JSONObject)localObject2);
      } else {
        this.mHippyQQEngine.setInitData((JSONObject)localObject1, (JSONObject)localObject1);
      }
    }
    initHippy(getParameters(), paramViewGroup);
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
    if (this.isHandleBackEvent)
    {
      HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
      if (localHippyQQPreloadEngine != null) {
        return localHippyQQPreloadEngine.doOnBackPressed(new BaseHippyFragment.1(this));
      }
    }
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateView this:");
    localStringBuilder.append(this);
    QLog.i("BaseHippyFragment", 1, localStringBuilder.toString());
    this.mCreateViewStartTime = System.currentTimeMillis();
    this.mIsDisablePreload = getParameters().getBoolean("isDisablePreload");
    LiuHaiUtils.f(getActivity());
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
    paramString = this.mHippyQQEngine;
    if ((paramString != null) && (paramInt != 0) && (paramInt != -11)) {
      localHashMap2.putAll(paramString.generateReportExtraParams());
    }
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
    getParameters().putLong("openPageStart", 0L);
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
        ((OpenHippyInfo)localObject).from = "back";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.BaseHippyFragment
 * JD-Core Version:    0.7.0.1
 */