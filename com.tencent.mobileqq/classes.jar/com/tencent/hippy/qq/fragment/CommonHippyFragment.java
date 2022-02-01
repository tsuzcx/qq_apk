package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class CommonHippyFragment
  extends BaseHippyFragment
  implements Handler.Callback
{
  private static final int LOAD_HIPPY_TIME_OUT_TIME = 9000;
  private static final int MSG_TIME_OUT = 1;
  private HippyErrorViewWrapper mErrorViewWrapper = new HippyErrorViewWrapper();
  private Handler mHandler;
  private ViewGroup mHippyContainer;
  private LayoutInflater mLayoutInflater;
  private HippyProgressBarWrapper mProgressBarWrapper = new HippyProgressBarWrapper();
  protected ViewGroup mRootView;
  
  public static void addNightModeMask(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    View localView = new View(paramActivity);
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  public static boolean isInNightMode()
  {
    if (MobileQQ.sMobileQQ.waitAppRuntime(null) != null) {
      return QQTheme.a();
    }
    return false;
  }
  
  private void prepareForDTReport()
  {
    ThreadManager.getUIHandler().post(new CommonHippyFragment.1(this));
  }
  
  private void reportTimeOut()
  {
    if (this.mHippyQQEngine == null) {
      return;
    }
    HashMap localHashMap1 = generateStepCosts();
    HashMap localHashMap2 = new HashMap();
    boolean bool = false;
    localHashMap2.put("ret", Integer.valueOf(0));
    localHashMap2.put("errMsg", getLastStepName());
    if (this.mHippyQQEngine != null) {
      bool = this.mHippyQQEngine.isPreloaded();
    }
    localHashMap2.put("isPreload", Boolean.valueOf(bool));
    localHashMap2.put("from", getParameters().getString("from"));
    HippyReporter.getInstance().reportHippyLoadResult(6, this.mHippyQQEngine.getModuleName(), this.mHippyQQEngine.getModuleVersion(), localHashMap2, localHashMap1);
  }
  
  protected JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    try
    {
      paramJSONObject = ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).checkWrapSSOData(paramJSONObject, getModuleName());
      localJSONObject = paramJSONObject;
      localObject = getParameters();
      localJSONObject = paramJSONObject;
      if (localObject != null)
      {
        localJSONObject = paramJSONObject;
        localObject = (SerializableMap)((Bundle)localObject).getSerializable("js_param_map");
        localJSONObject = paramJSONObject;
        if (localObject != null)
        {
          localJSONObject = paramJSONObject;
          localObject = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).wrapHashMap(paramJSONObject, ((SerializableMap)localObject).getMap());
          if (localObject != null) {
            paramJSONObject = (JSONObject)localObject;
          }
          return paramJSONObject;
        }
      }
    }
    catch (Throwable paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doBussinessInitData:");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.e("BaseHippyFragment", 1, ((StringBuilder)localObject).toString());
    }
    return localJSONObject;
  }
  
  protected int getLayoutResId()
  {
    return 2131558481;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    QLog.d("BaseHippyFragment", 1, "Hippy: load timeout");
    if (!isFragmentDestroyed()) {
      gotoErrorUrl();
    }
    if (this.mHippyQQEngine != null) {
      reportTimeOut();
    }
    return true;
  }
  
  protected void initNetworkErrorView(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131366297);
    if (paramViewGroup.getVisibility() != 0) {
      paramViewGroup.setVisibility(0);
    }
    this.mErrorViewWrapper.initNetworkErrorView(paramViewGroup, paramOnClickListener);
  }
  
  protected void initProgressBar(ViewGroup paramViewGroup)
  {
    if ((this.mHippyQQEngine != null) && (!this.mHippyQQEngine.isNeedShowLoading())) {
      return;
    }
    this.mProgressBarWrapper.initProgressBar(paramViewGroup);
    this.mProgressBarWrapper.startProgressBar();
  }
  
  protected void initViews()
  {
    if (getParameters().getBoolean("isTransparent")) {
      this.mRootView.setBackgroundColor(0);
    }
    this.mHippyContainer = ((ViewGroup)this.mRootView.findViewById(2131368190));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (Build.VERSION.SDK_INT >= 11) {
      setWindowFlag(getQBaseActivity(), 16777216);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (isInNightMode()) {
      addNightModeMask(getQBaseActivity());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        setWindowFlag(getQBaseActivity(), 16777216);
      }
    }
    catch (Throwable paramViewGroup)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreateView setWindowFlag e:");
      paramBundle.append(paramViewGroup);
      QLog.e("BaseHippyFragment", 1, paramBundle.toString());
    }
    this.mHandler = new Handler(this);
    this.mLayoutInflater = paramLayoutInflater;
    this.mRootView = ((ViewGroup)this.mLayoutInflater.inflate(getLayoutResId(), null, false));
    initViews();
    loadHippy(this.mHippyContainer);
    setStatusBarImmersive();
    initProgressBar(this.mRootView);
    if ((this.mHippyQQEngine != null) && (!this.mHippyQQEngine.isPredraw())) {
      this.mHandler.sendEmptyMessageDelayed(1, 9000L);
    }
    prepareForDTReport();
    paramLayoutInflater = this.mRootView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    VideoReport.registerEventDynamicParams(null);
    super.onDestroy();
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    paramString = this.mHandler;
    if (paramString != null) {
      paramString.removeMessages(1);
    }
    this.mProgressBarWrapper.hideProgressBar();
    initNetworkErrorView(this.mRootView, new CommonHippyFragment.2(this));
  }
  
  protected void onLoadHippySuccess()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeMessages(1);
    }
    this.mProgressBarWrapper.hideProgressBar();
  }
  
  public void onResume()
  {
    super.onResume();
    if (getUserVisibleHint())
    {
      boolean bool = getParameters().getBoolean("isStatusBarDarkFont");
      FlymeOSStatusBarFontUtils.a(getQBaseActivity(), bool);
    }
  }
  
  protected void setStatusBarImmersive()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (getQBaseActivity().mSystemBarComp == null)
      {
        getQBaseActivity().setImmersiveStatus(0);
        return;
      }
      getQBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
      getQBaseActivity().mSystemBarComp.setStatusBarColor(0);
      getQBaseActivity().mSystemBarComp.setStatusColor(0);
    }
  }
  
  protected void setWindowFlag(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(paramInt, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.CommonHippyFragment
 * JD-Core Version:    0.7.0.1
 */