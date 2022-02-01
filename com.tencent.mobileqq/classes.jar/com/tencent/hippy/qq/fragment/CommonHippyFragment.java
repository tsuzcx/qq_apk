package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.qwallet.utils.FlymeOSStatusBarFontUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
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
  
  private void reportTimeOut()
  {
    boolean bool = false;
    if (this.mHippyQQEngine == null) {
      return;
    }
    HashMap localHashMap1 = generateStepCosts();
    HashMap localHashMap2 = new HashMap();
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
    try
    {
      Object localObject2 = getParameters();
      Object localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject2 = (SerializableMap)((Bundle)localObject2).getSerializable("js_param_map");
        localObject1 = paramJSONObject;
        if (localObject2 != null)
        {
          localObject2 = HippyAccessHelper.wrapHashMap(paramJSONObject, ((SerializableMap)localObject2).getMap());
          localObject1 = paramJSONObject;
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseHippyFragment", 1, "doBussinessInitData:" + localThrowable);
    }
    return paramJSONObject;
  }
  
  protected int getLayoutResId()
  {
    return 2131558452;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      QLog.d("BaseHippyFragment", 1, "Hippy: load timeout");
      if (!isFragmentDestroyed()) {
        gotoErrorUrl();
      }
    } while (this.mHippyQQEngine == null);
    reportTimeOut();
    return true;
  }
  
  protected void initNetworkErrorView(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131366416);
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
    this.mHippyContainer = ((ViewGroup)this.mRootView.findViewById(2131368438));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (Build.VERSION.SDK_INT >= 11) {
      setWindowFlag(getActivity(), 16777216);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (SubscribeUtils.a()) {
      SubscribeUtils.a(getActivity());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        setWindowFlag(getActivity(), 16777216);
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
      paramLayoutInflater = this.mRootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Throwable paramViewGroup)
    {
      for (;;)
      {
        QLog.e("BaseHippyFragment", 1, "onCreateView setWindowFlag e:" + paramViewGroup);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1);
    }
    this.mProgressBarWrapper.hideProgressBar();
    initNetworkErrorView(this.mRootView, new CommonHippyFragment.1(this));
  }
  
  protected void onLoadHippySuccess()
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1);
    }
    this.mProgressBarWrapper.hideProgressBar();
  }
  
  public void onResume()
  {
    super.onResume();
    if (getUserVisibleHint())
    {
      boolean bool = getParameters().getBoolean("isStatusBarDarkFont");
      FlymeOSStatusBarFontUtils.a(getActivity(), bool);
    }
  }
  
  protected void setStatusBarImmersive()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (getActivity().mSystemBarComp == null) {
        getActivity().setImmersiveStatus(0);
      }
    }
    else {
      return;
    }
    getActivity().mSystemBarComp.setStatusBarDrawable(null);
    getActivity().mSystemBarComp.setStatusBarColor(0);
    getActivity().mSystemBarComp.setStatusColor(0);
  }
  
  protected void setWindowFlag(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(paramInt, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.CommonHippyFragment
 * JD-Core Version:    0.7.0.1
 */