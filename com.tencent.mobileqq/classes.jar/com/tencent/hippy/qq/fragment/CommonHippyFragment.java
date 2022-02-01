package com.tencent.hippy.qq.fragment;

import akfw;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bhkb;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import zbi;

public class CommonHippyFragment
  extends BaseHippyFragment
  implements Handler.Callback
{
  private static final int LOAD_HIPPY_TIME_OUT_TIME = 5000;
  private static final int MSG_TIME_OUT = 1;
  private FrameLayout mErrorOrLoadingFrameLayout;
  private int mErrorViewColor = -1;
  private Handler mHandler = new Handler();
  private ViewGroup mHippyContainer;
  private LayoutInflater mLayoutInflater;
  private ImageView mNetworkErrorIcon;
  private TextView mNetworkErrorText;
  private View mNetworkErrorView;
  private WebViewProgressBar mProgressBar;
  private bhkb mProgressBarController;
  private ViewGroup mRootView;
  
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
    HippyReporter.getInstance().reportOper(this.mHippyQQEngine.getModuleName(), this.mHippyQQEngine.getModuleVersion(), 6);
    return true;
  }
  
  protected void hideNetworkErrorView()
  {
    if (this.mNetworkErrorView != null) {
      this.mNetworkErrorView.setVisibility(8);
    }
  }
  
  public void hideProgressBar()
  {
    if ((this.mProgressBarController != null) && (this.mProgressBarController.b() != 2)) {
      this.mProgressBarController.a((byte)2);
    }
  }
  
  protected void initNetworkErrorView(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    this.mErrorOrLoadingFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131380866));
    if (this.mErrorOrLoadingFrameLayout.getVisibility() != 0) {
      this.mErrorOrLoadingFrameLayout.setVisibility(0);
    }
    if (this.mNetworkErrorView == null)
    {
      this.mNetworkErrorView = ((ViewStub)paramViewGroup.findViewById(2131380867)).inflate();
      if (this.mErrorViewColor != -1) {
        this.mNetworkErrorView.setBackgroundColor(this.mErrorViewColor);
      }
      this.mNetworkErrorText = ((TextView)this.mNetworkErrorView.findViewById(2131375916));
      this.mNetworkErrorIcon = ((ImageView)this.mNetworkErrorView.findViewById(2131375915));
    }
    this.mNetworkErrorText.setText(paramViewGroup.getResources().getString(2131717478));
    this.mNetworkErrorView.setOnClickListener(paramOnClickListener);
    this.mNetworkErrorView.setVisibility(0);
    if (this.mErrorViewColor == -1) {
      this.mNetworkErrorIcon.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839320));
    }
    for (;;)
    {
      this.mNetworkErrorText.setTextColor(paramViewGroup.getResources().getColor(2131166892));
      paramOnClickListener = (LinearLayout.LayoutParams)this.mNetworkErrorText.getLayoutParams();
      paramOnClickListener.topMargin = AIOUtils.dp2px(10.0F, paramViewGroup.getResources());
      this.mNetworkErrorText.setLayoutParams(paramOnClickListener);
      return;
      this.mNetworkErrorIcon.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839523));
    }
  }
  
  public void initProgressBar(ViewGroup paramViewGroup)
  {
    if ((this.mHippyQQEngine != null) && (this.mHippyQQEngine.isReady())) {
      return;
    }
    this.mProgressBar = new WebViewProgressBar(paramViewGroup.getContext());
    this.mProgressBar.setId(2131373019);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(3.0F, paramViewGroup.getContext().getResources()));
    localLayoutParams.addRule(10, -1);
    this.mProgressBar.setLayoutParams(localLayoutParams);
    paramViewGroup.addView(this.mProgressBar);
    this.mProgressBarController = new bhkb();
    this.mProgressBarController.a(this.mProgressBar);
    this.mProgressBar.setController(this.mProgressBarController);
    startProgressBar();
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
    if (zbi.a()) {
      zbi.a(getActivity());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      setWindowFlag(getActivity(), 16777216);
    }
    this.mLayoutInflater = paramLayoutInflater;
    this.mRootView = ((ViewGroup)this.mLayoutInflater.inflate(2131558450, null, false));
    this.mHippyContainer = ((ViewGroup)this.mRootView.findViewById(2131368079));
    loadHippy(this.mHippyContainer);
    setStatusBarImmersive();
    initProgressBar(this.mRootView);
    this.mHandler.sendEmptyMessageDelayed(1, 5000L);
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    this.mHandler.removeMessages(1);
    hideProgressBar();
    initNetworkErrorView(this.mRootView, new CommonHippyFragment.1(this));
  }
  
  protected void onLoadHippySuccess()
  {
    this.mHandler.removeMessages(1);
    hideProgressBar();
  }
  
  public void onResume()
  {
    super.onResume();
    if (getUserVisibleHint())
    {
      boolean bool = getParameters().getBoolean("isStatusBarDarkFont");
      akfw.a(getActivity(), bool);
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
  
  public void startProgressBar()
  {
    if ((this.mProgressBarController != null) && (this.mProgressBarController.b() != 0)) {
      this.mProgressBarController.a((byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.CommonHippyFragment
 * JD-Core Version:    0.7.0.1
 */