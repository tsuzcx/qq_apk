package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo;
import com.tencent.hippy.qq.utils.HippyErrorManager;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseHippyFragment
  extends PublicBaseFragment
  implements HippyActivityLifecycleOwner
{
  protected static final String TAG = "BaseHippyFragment";
  private static HashMap<String, String> mNeedLoginStateInfoModules = new HashMap();
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
  
  static
  {
    mNeedLoginStateInfoModules.put("QQGameCenter", "gamecenter.qq.com");
    mNeedLoginStateInfoModules.put("QQBoodoComic", "qc.vip.qq.com");
    mNeedLoginStateInfoModules.put("SGameOfficial", "SGameOfficial.qq.com");
  }
  
  private void doActivityBack()
  {
    if (getActivity() != null) {
      getActivity().doOnBackPressed();
    }
  }
  
  public static JSONObject getJSInitData(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    String str = paramAppRuntime.getAccount();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("url", paramString2);
        }
        localJSONObject.put("QQVersion", DeviceInfoUtil.c());
        if (ImmersiveUtils.isSupporImmersive() != 1) {
          continue;
        }
        bool = true;
        localJSONObject.put("isSupporImmersive", bool);
        localJSONObject.put("statusBarHeight", ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getContext()));
        paramAppRuntime = mNeedLoginStateInfoModules.keySet().iterator();
        if (!paramAppRuntime.hasNext()) {
          continue;
        }
        paramString2 = (String)paramAppRuntime.next();
        if ((paramString2 == null) || (!paramString1.startsWith(paramString2))) {
          continue;
        }
        paramAppRuntime = (String)mNeedLoginStateInfoModules.get(paramString2);
        i = 1;
      }
      catch (JSONException paramAppRuntime)
      {
        boolean bool;
        paramAppRuntime.printStackTrace();
        continue;
        paramAppRuntime = null;
        int i = 0;
        continue;
      }
      if ((i != 0) && (paramAppRuntime != null))
      {
        localJSONObject.put("uin", HttpBaseUtil.b(str));
        localJSONObject.put("p_uin", HttpBaseUtil.b(str));
        localJSONObject.put("skey", localTicketManager.getSkey(str));
        localJSONObject.put("p_skey", localTicketManager.getPskey(str, paramAppRuntime));
      }
      return localJSONObject;
      bool = false;
    }
  }
  
  private int getModuleVersion()
  {
    if (this.mHippyQQEngine != null) {
      return this.mHippyQQEngine.getModuleVersion();
    }
    return 0;
  }
  
  private void initHippy(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    if (this.mHippyQQEngine == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        if (!this.mHippyQQEngine.isReady()) {
          QLog.e("BaseHippyFragment", 1, "HippyQQEngine not ready");
        }
        this.mHippyQQEngine.initHippyInContainer(paramViewGroup, paramBundle, false, new BaseHippyFragment.2(this));
        return;
      }
      catch (JSONException paramBundle)
      {
        QLog.e("BaseHippyFragment", 1, "initHippy error:" + paramBundle);
      }
      paramBundle = localJSONObject;
    }
  }
  
  private void printPerformanceData(HashMap<String, Long> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localStringBuilder.append("Hippy Performancedata isPreload:");
    if (this.mHippyQQEngine != null) {}
    for (boolean bool = this.mHippyQQEngine.isPreloaded();; bool = false)
    {
      ((StringBuilder)localObject).append(bool).append(',');
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (Map.Entry)paramHashMap.next();
        localStringBuilder.append((String)((Map.Entry)localObject).getKey()).append(':').append(((Map.Entry)localObject).getValue()).append(',');
      }
    }
    QLog.i("BaseHippyFragment", 2, localStringBuilder.toString());
  }
  
  protected abstract JSONObject doBussinessInitData(JSONObject paramJSONObject);
  
  protected HashMap<String, Long> generateStepCosts()
  {
    Object localObject = getPerformanceData();
    long l1;
    long l2;
    label58:
    long l3;
    label85:
    long l4;
    label112:
    long l5;
    label139:
    long l6;
    label166:
    long l7;
    if (((HashMap)localObject).containsKey("openPageStart"))
    {
      l1 = ((Long)((HashMap)localObject).get("openPageStart")).longValue();
      if (!((HashMap)localObject).containsKey("pageCreateStart")) {
        break label477;
      }
      l2 = ((Long)((HashMap)localObject).get("pageCreateStart")).longValue();
      if (!((HashMap)localObject).containsKey("loadHippyStart")) {
        break label482;
      }
      l3 = ((Long)((HashMap)localObject).get("loadHippyStart")).longValue();
      if (!((HashMap)localObject).containsKey("loadLibStart")) {
        break label488;
      }
      l4 = ((Long)((HashMap)localObject).get("loadLibStart")).longValue();
      if (!((HashMap)localObject).containsKey("loadLibEnd")) {
        break label494;
      }
      l5 = ((Long)((HashMap)localObject).get("loadLibEnd")).longValue();
      if (!((HashMap)localObject).containsKey("initEngineEnd")) {
        break label500;
      }
      l6 = ((Long)((HashMap)localObject).get("initEngineEnd")).longValue();
      if (!((HashMap)localObject).containsKey("loadModuleStart")) {
        break label506;
      }
      l7 = ((Long)((HashMap)localObject).get("loadModuleStart")).longValue();
      label193:
      if (!((HashMap)localObject).containsKey("loadModuleEnd")) {
        break label512;
      }
    }
    label512:
    for (long l8 = ((Long)((HashMap)localObject).get("loadModuleEnd")).longValue();; l8 = 0L)
    {
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
      l1 = 0L;
      break;
      label477:
      l2 = 0L;
      break label58;
      label482:
      l3 = 0L;
      break label85;
      label488:
      l4 = 0L;
      break label112;
      label494:
      l5 = 0L;
      break label139;
      label500:
      l6 = 0L;
      break label166;
      label506:
      l7 = 0L;
      break label193;
    }
  }
  
  @NotNull
  public HippyActivityLifecycleDispatcher getDispatcher()
  {
    return this.mDispatcher;
  }
  
  protected String getLastStepName()
  {
    HashMap localHashMap = getPerformanceData();
    Object localObject = "";
    long l = 0L;
    Iterator localIterator = localHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Long)localHashMap.get(str)).longValue() <= l) {
        break label86;
      }
      l = ((Long)localHashMap.get(str)).longValue();
      localObject = str;
    }
    label86:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  public String getModuleName()
  {
    return this.mModuleName;
  }
  
  protected Bundle getParameters()
  {
    Bundle localBundle1 = null;
    if (getArguments() != null) {
      localBundle1 = getArguments().getBundle("params");
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
    if (this.mHippyQQEngine != null) {
      localHashMap.putAll(this.mHippyQQEngine.getLoadStepsTime());
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
    Object localObject = getParameters().getString("errorUrl");
    QLog.d("BaseHippyFragment", 1, "Hippy: initHippy errorUrl:" + (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return false;
      localFragmentActivity = getActivity();
    } while ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
    if ((this.mModuleName != null) && (this.mModuleName.startsWith("QQGameCenter")))
    {
      QQGameHelper.a(localFragmentActivity, (String)localObject);
      localFragmentActivity.finish();
    }
    for (;;)
    {
      return true;
      if ((this.mModuleName != null) && (this.mModuleName.startsWith("SGameOfficial")))
      {
        localObject = new WadlReportBuilder();
        ((WadlReportBuilder)localObject).a("dc00087").g("771").c("206612").a(1, "76918").a(11, "1").a(12, "160");
        ((WadlReportBuilder)localObject).a(24, QQGameHelper.b());
        ((WadlReportBuilder)localObject).a(-4);
        ((WadlReportBuilder)localObject).a();
        QQGameHelper.b(localFragmentActivity);
        localFragmentActivity.finish();
      }
      else
      {
        Intent localIntent = new Intent(localFragmentActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localFragmentActivity.startActivity(localIntent);
        localFragmentActivity.finish();
      }
    }
  }
  
  public boolean isFragmentDestroyed()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
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
    String str = getParameters().getString("framework");
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
        this.mHippyQQEngine = HippyAccessHelper.getPreloadedHippyQQEngine((String)localObject1);
      }
      if ((QLog.isDebugVersion()) && (this.mHippyQQEngine != null)) {
        QLog.i("BaseHippyFragment", 4, "loadHippy use preloadEngine isPredraw:" + this.mHippyQQEngine.isPredraw());
      }
      if (this.mHippyQQEngine == null)
      {
        this.mHippyQQEngine = new HippyQQPreloadEngine(this, (String)localObject1, this.mUrl);
        this.mHippyQQEngine.setBundleUrl((String)localObject4);
        if ((!TextUtils.isEmpty(str)) && ((str.contains("react")) || (str.contains("vue"))))
        {
          localObject4 = this.mHippyQQEngine;
          if (!str.contains("react")) {
            break label354;
          }
          localObject3 = "react";
          label267:
          ((HippyQQPreloadEngine)localObject4).setJsBundleType((String)localObject3);
        }
        localObject3 = getActivity();
        if (localObject3 != null)
        {
          localObject1 = getJSInitData(((FragmentActivity)localObject3).getAppRuntime(), (String)localObject1, this.mUrl);
          localObject3 = doBussinessInitData((JSONObject)localObject1);
          if (localObject3 == null) {
            break label361;
          }
          this.mHippyQQEngine.setInitData((JSONObject)localObject3, (JSONObject)localObject3);
        }
      }
      for (;;)
      {
        initHippy(getParameters(), paramViewGroup);
        return;
        this.mHippyQQEngine.setFragment(this);
        this.mHippyQQEngine.setHippyActivityLifecycleOwner(this);
        this.mHippyQQEngine.setPageUrl(this.mUrl);
        break;
        label354:
        localObject3 = "vue";
        break label267;
        label361:
        this.mHippyQQEngine.setInitData((JSONObject)localObject1, (JSONObject)localObject1);
      }
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
    QLog.i("BaseHippyFragment", 1, "onActivityCreated this:" + this);
    this.mDispatcher.onActivityCreated(getActivity(), paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mDispatcher.onActivityResult(getActivity(), paramInt1, paramInt2, paramIntent);
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
    QLog.i("BaseHippyFragment", 1, "onCreateView this:" + this);
    this.mCreateViewStartTime = System.currentTimeMillis();
    this.mIsDisablePreload = getParameters().getBoolean("isDisablePreload");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.mDispatcher.onActivityDestroyed(getActivity());
    this.mDispatcher.clearAllListener();
    if (this.mHippyQQEngine != null)
    {
      this.mHippyQQEngine.onDestroy();
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
    boolean bool2 = false;
    HashMap localHashMap1 = generateStepCosts();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("ret", Integer.valueOf(paramInt));
    localHashMap2.put("errMsg", paramString);
    if (this.mHippyQQEngine != null) {}
    for (boolean bool1 = this.mHippyQQEngine.isPreloaded();; bool1 = false)
    {
      localHashMap2.put("isPreload", Boolean.valueOf(bool1));
      bool1 = bool2;
      if (this.mHippyQQEngine != null) {
        bool1 = this.mHippyQQEngine.isPredraw();
      }
      localHashMap2.put("isPredraw", Boolean.valueOf(bool1));
      localHashMap2.put("from", getParameters().getString("from"));
      HippyReporter.getInstance().reportHippyLoadResult(3, this.mModuleName, getModuleVersion(), localHashMap2, localHashMap1);
      if (QLog.isColorLevel()) {
        printPerformanceData(localHashMap1);
      }
      HippyErrorManager.getInstance().endAllOperation();
      return;
    }
  }
  
  protected void onLoadHippySuccess() {}
  
  public void onPause()
  {
    super.onPause();
    if (this.mIsPageAppeared)
    {
      this.mDispatcher.onActivityPaused(getActivity());
      if (this.mHippyQQEngine != null) {
        this.mHippyQQEngine.onPause();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mIsPageAppeared)
    {
      this.mDispatcher.onActivityResumed(getActivity());
      if (this.mHippyQQEngine != null) {
        this.mHippyQQEngine.onResume();
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mDispatcher.onActivitySaveInstanceState(getActivity(), paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.mDispatcher.onActivityStarted(getActivity());
  }
  
  public void onStop()
  {
    super.onStop();
    this.mDispatcher.onActivityStopped(getActivity());
  }
  
  protected void preloadEngine()
  {
    boolean bool3 = true;
    boolean bool2;
    label59:
    HippyAccessHelper.OpenHippyInfo localOpenHippyInfo;
    if (this.mHippyQQEngine != null)
    {
      if ((!this.mHippyQQEngine.isPreloaded()) && (!getParameters().getBoolean("isPreloadWhenClosed"))) {
        break label171;
      }
      bool1 = true;
      if ((!this.mHippyQQEngine.isPredraw()) && (!getParameters().getBoolean("isPredrawWhenClosed"))) {
        break label176;
      }
      bool2 = true;
      if (QLog.isColorLevel()) {
        QLog.d("BaseHippyFragment", 2, "preloadEngine isPreload:" + bool1 + " isPredraw:" + bool2);
      }
      if ((bool1) || (bool2))
      {
        localOpenHippyInfo = new HippyAccessHelper.OpenHippyInfo();
        localOpenHippyInfo.bundleName = this.mModuleName;
        localOpenHippyInfo.url = this.mUrl;
        localOpenHippyInfo.isPreload = bool1;
        localOpenHippyInfo.isPredraw = bool2;
        if (BaseApplicationImpl.sProcessId != 7) {
          break label181;
        }
      }
    }
    label171:
    label176:
    label181:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localOpenHippyInfo.isInToolProcess = bool1;
      HippyAccessHelper.checkAndPreloadHippyPage(localOpenHippyInfo);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label59;
    }
  }
  
  public void sendHippyNativeEvent(String paramString, HippyMap paramHippyMap)
  {
    try
    {
      if ((this.mHippyQQEngine != null) && (paramHippyMap != null) && (!TextUtils.isEmpty(paramString))) {
        ((EventDispatcher)this.mHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramHippyMap);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("BaseHippyFragment", 1, "sendHippyNativeEvent fail:" + paramString.getMessage());
    }
  }
  
  public void setPageAppeared(boolean paramBoolean)
  {
    this.mIsPageAppeared = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.BaseHippyFragment
 * JD-Core Version:    0.7.0.1
 */