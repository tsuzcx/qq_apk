package com.tencent.biz.pubaccount.readinjoy.viola.view;

import akfw;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import rwv;
import tpc;
import tpd;

public abstract class ViolaLazyFragment
  extends PublicBaseFragment
{
  public static final String LEFT_VIEW_BACK_DRAWABLE_BLACK = "drawable_black";
  public static final String LEFT_VIEW_BACK_DRAWABLE_WHITE = "drawable_white";
  public static final String STATUS_BAR_NORMAL_COLOR = "status_bar_color_style";
  private static final String TAG = "ViolaLazyFragment";
  private boolean fullScreenAlways;
  private ViewGroup mContainer;
  private ViewGroup mContentView;
  private boolean mIsContentInit;
  private boolean mIsStart;
  private boolean mIsStatusImmersive;
  private boolean mIsStatusViewTransparent;
  private LayoutInflater mLayoutInflater;
  private View.OnClickListener mOnBackListener = new tpc(this);
  private int mOriginalTitleVisibility = 0;
  private View mRootView;
  private String mStatusBarColor = "status_bar_color_style";
  private Boolean mStatusBarFontColorWhite = Boolean.valueOf(true);
  private SystemBarCompact mSystemBarComp;
  private TextView mTitleCenterView;
  private NavBarCommon mTitleContainer;
  private ImageView mTitleLeftBackIcon;
  private TextView mTitleLeftBackText;
  private TextView mTitleLeftView;
  private TextView mTitleLeftViewNotBack;
  private TextView mTitleRightHightView;
  private ImageView mTitleRightViewIcon;
  private TextView mTitleRightViewText;
  private RelativeLayout mTitleRootView;
  private int originUIFlags = -1;
  
  private void initTitleView(NavBarCommon paramNavBarCommon)
  {
    this.mTitleLeftView = ((TextView)paramNavBarCommon.findViewById(2131369068));
    this.mTitleLeftView.setOnClickListener(this.mOnBackListener);
    this.mTitleLeftBackText = ((TextView)paramNavBarCommon.findViewById(2131379417));
    this.mTitleLeftBackIcon = ((ImageView)paramNavBarCommon.findViewById(2131369436));
    if ((this.mTitleLeftBackText != null) && (this.mTitleLeftBackIcon != null))
    {
      this.mTitleLeftBackText.setOnClickListener(this.mOnBackListener);
      this.mTitleLeftBackIcon.setOnClickListener(this.mOnBackListener);
    }
    this.mTitleCenterView = ((TextView)paramNavBarCommon.findViewById(2131369115));
    this.mTitleRightViewText = ((TextView)paramNavBarCommon.findViewById(2131369099));
    this.mTitleRightViewIcon = ((ImageView)paramNavBarCommon.findViewById(2131369082));
  }
  
  private void setStatusBarTrans()
  {
    if ((!this.mIsStatusViewTransparent) && (needImmersive()) && (needStatusTrans()) && (getActivity().findViewById(16908310) != null))
    {
      ViewParent localViewParent = getActivity().findViewById(16908310).getParent();
      if ((localViewParent != null) && ((localViewParent instanceof FrameLayout))) {
        ((FrameLayout)localViewParent).setVisibility(8);
      }
    }
  }
  
  public static void setWindowFlag(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(paramInt, paramInt);
    }
  }
  
  public abstract void doOnBackPressed();
  
  public void exitFullScreen()
  {
    getActivity().getWindow().getDecorView().setSystemUiVisibility(this.originUIFlags);
    this.originUIFlags = -1;
  }
  
  public ViewGroup getContentView()
  {
    return this.mContentView;
  }
  
  public abstract int getContentViewId();
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public String getStatusBarColor()
  {
    return this.mStatusBarColor;
  }
  
  public Boolean getStatusBarFontColorWhite()
  {
    return this.mStatusBarFontColorWhite;
  }
  
  public ViewGroup getTitleRootView()
  {
    return this.mTitleRootView;
  }
  
  public void hideLeftBackView()
  {
    this.mTitleLeftView.setVisibility(8);
  }
  
  public void hideNavBar()
  {
    getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new tpd(this));
    int i = getActivity().getWindow().getDecorView().getSystemUiVisibility();
    getActivity().getWindow().getDecorView().setSystemUiVisibility(i | 0x2 | 0x400);
  }
  
  public void hideStatusBar()
  {
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setStatusBarVisible(2, 0);
    }
  }
  
  public void hideStatusBarByParams()
  {
    if (((getActivity() instanceof BaseActivity)) && (getActivity().mSystemBarComp != null))
    {
      Window localWindow = getActivity().getWindow();
      if (localWindow != null) {
        localWindow.setFlags(1024, 1024);
      }
      this.mSystemBarComp = getActivity().mSystemBarComp;
      this.mSystemBarComp.init();
      hideStatusBar();
    }
  }
  
  public void hideTitleBar()
  {
    try
    {
      if (getRootView() != null)
      {
        this.mTitleContainer = ((NavBarCommon)getRootView().findViewById(2131376501));
        this.mOriginalTitleVisibility = this.mTitleContainer.getVisibility();
        if (this.mTitleContainer.getVisibility() == 0) {
          this.mTitleContainer.setVisibility(8);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaLazyFragment", 2, localThrowable, new Object[0]);
    }
  }
  
  public abstract void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup);
  
  public abstract void initBeforeVisible(Bundle paramBundle);
  
  protected void initFragmentLazy(ViewGroup paramViewGroup)
  {
    setContentView(getContentViewId(), paramViewGroup);
    setTitleView();
    initAfterVisible(getArguments(), this.mContentView);
  }
  
  public void initStatusBarColor(String paramString)
  {
    if ((!this.mIsStatusImmersive) && (ImmersiveUtils.isSupporImmersive() == 1) && (!"status_bar_color_style".equals(paramString)) && ((getActivity() instanceof BaseActivity)) && (getActivity().mSystemBarComp != null))
    {
      this.mSystemBarComp = getActivity().mSystemBarComp;
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(Color.parseColor(paramString));
    }
  }
  
  public void initViewAfterVisible()
  {
    if ((!this.mIsContentInit) && (getRootView() != null))
    {
      this.mIsContentInit = true;
      initFragmentLazy(this.mContainer);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (Build.VERSION.SDK_INT >= 11) {
      setWindowFlag(getActivity(), 16777216);
    }
  }
  
  public boolean isTransparent()
  {
    return this.mIsStatusViewTransparent;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onAttach:" + System.currentTimeMillis());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onCreate:" + System.currentTimeMillis());
  }
  
  protected void onCreateFragment(ViewGroup paramViewGroup)
  {
    if ((getUserVisibleHint()) && (!this.mIsContentInit))
    {
      this.mIsContentInit = true;
      initFragmentLazy(paramViewGroup);
      return;
    }
    setLazyEmptyLayout();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onCreateView:" + System.currentTimeMillis());
    this.mLayoutInflater = paramLayoutInflater;
    this.mContainer = paramViewGroup;
    if (Build.VERSION.SDK_INT >= 11) {
      setWindowFlag(getActivity(), 16777216);
    }
    onCreateFragment(paramViewGroup);
    if (this.mRootView == null) {}
    for (paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);; paramLayoutInflater = this.mRootView)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.mContentView = null;
    this.mLayoutInflater = null;
    if (this.mIsContentInit) {
      onDestroyViewLazy();
    }
    this.mIsContentInit = false;
  }
  
  protected void onDestroyViewLazy() {}
  
  protected void onFragmentStartLazy() {}
  
  protected void onFragmentStopLazy() {}
  
  public void onPause()
  {
    super.onPause();
    if (this.mIsContentInit) {
      onPauseLazy();
    }
  }
  
  protected void onPauseLazy() {}
  
  public void onResume()
  {
    super.onResume();
    initStatusBarColor(this.mStatusBarColor);
    FragmentActivity localFragmentActivity;
    if (getUserVisibleHint())
    {
      localFragmentActivity = getActivity();
      if (this.mStatusBarFontColorWhite.booleanValue()) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      akfw.a(localFragmentActivity, bool);
      if (this.mIsContentInit) {
        onResumeLazy();
      }
      return;
    }
  }
  
  protected void onResumeLazy()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (!this.mStatusBarFontColorWhite.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      akfw.a(localFragmentActivity, bool);
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    VideoReport.addToDetectionWhitelist(getActivity());
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onStart:" + System.currentTimeMillis());
    if ((this.mIsContentInit) && (!this.mIsStart) && (getUserVisibleHint()))
    {
      this.mIsStart = true;
      onFragmentStartLazy();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.mIsContentInit) && (this.mIsStart) && (getUserVisibleHint()))
    {
      this.mIsStart = false;
      onFragmentStopLazy();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.fullScreenAlways) {
      setFullScreen();
    }
  }
  
  public void recoverStatusBar()
  {
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setStatusBarVisible(0, 0);
    }
  }
  
  public void setCenterTextColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mTitleCenterView.getVisibility() != 0) {
        this.mTitleCenterView.setVisibility(0);
      }
      this.mTitleCenterView.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void setContentFullScreen()
  {
    setWindowFlag(getActivity(), 1024);
    LiuHaiUtils.a(getActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getActivity());
    }
    VideoFeedsPlayActivity.a(getActivity());
  }
  
  public void setContentView(int paramInt, ViewGroup paramViewGroup)
  {
    if ((getRootView() == null) || (getRootView().getParent() == null)) {
      this.mRootView = this.mLayoutInflater.inflate(2131558986, paramViewGroup, false);
    }
    try
    {
      this.mTitleRootView = ((RelativeLayout)this.mRootView.findViewById(2131378819));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.mTitleRootView.setFitsSystemWindows(true);
        this.mTitleRootView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
      }
      paramViewGroup = (ViewGroup)this.mLayoutInflater.inflate(paramInt, (ViewGroup)this.mRootView, false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131376501);
      this.mTitleRootView.addView(paramViewGroup, localLayoutParams);
      this.mContentView = paramViewGroup;
      return;
    }
    catch (Exception paramViewGroup)
    {
      QLog.e("ViolaLazyFragment", 1, paramViewGroup.getMessage());
    }
  }
  
  public void setContentViewColor(String paramString)
  {
    this.mContentView.setBackgroundColor(Color.parseColor(paramString));
  }
  
  public void setFullScreen()
  {
    if (this.originUIFlags < 0) {
      this.originUIFlags = getActivity().getWindow().getDecorView().getSystemUiVisibility();
    }
    rwv.a(getActivity());
  }
  
  public void setFullScreenAlways(boolean paramBoolean)
  {
    this.fullScreenAlways = paramBoolean;
    if (this.fullScreenAlways)
    {
      setFullScreen();
      return;
    }
    exitFullScreen();
  }
  
  protected void setLazyEmptyLayout()
  {
    this.mRootView = this.mLayoutInflater.inflate(2131558986, this.mContainer, false);
    initBeforeVisible(getArguments());
  }
  
  public void setLeftButtonText(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.mTitleLeftView.setVisibility(0);
    this.mTitleLeftView.setText(paramString);
    this.mTitleLeftView.setEnabled(true);
    if (paramOnClickListener != null) {
      this.mTitleLeftView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setLeftTextBackDrawable(String paramString)
  {
    if (getActivity() != null)
    {
      if (!"drawable_black".equals(paramString)) {
        break label45;
      }
      this.mTitleLeftView.setVisibility(0);
      this.mTitleLeftView.setBackgroundDrawable(getActivity().getResources().getDrawable(2130849445));
    }
    label45:
    while (!"drawable_white".equals(paramString)) {
      return;
    }
    this.mTitleLeftView.setVisibility(0);
    this.mTitleLeftView.setBackgroundDrawable(getActivity().getResources().getDrawable(2130850593));
  }
  
  public void setLeftTextColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mTitleLeftView.getVisibility() != 0) {
        this.mTitleLeftView.setVisibility(0);
      }
      this.mTitleLeftView.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void setNoPadding()
  {
    this.mTitleRootView.setPadding(0, 0, 0, 0);
  }
  
  public void setReadInjoyTitleStyle()
  {
    if (!this.mIsStatusImmersive) {
      setStatusBarColor("#ffffff");
    }
    setTitleContainerBackgroundColor("#ffffff");
    setCenterTextColor("#000000");
    setLeftTextColor("#000000");
    setLeftTextBackDrawable("drawable_black");
    setRightTextColor("#000000");
  }
  
  public void setRightButtonText(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.mTitleRightViewText.setVisibility(0);
    this.mTitleRightViewText.setText(paramString);
    this.mTitleRightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.mTitleRightViewText.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRightTextColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.mTitleRightViewText.getVisibility() != 0) && (!TextUtils.isEmpty(this.mTitleRightViewText.getText()))) {
        this.mTitleRightViewText.setVisibility(0);
      }
      this.mTitleRightViewText.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void setStatusBarColor(String paramString)
  {
    setStatusBarColor(paramString, false);
  }
  
  public void setStatusBarColor(String paramString, boolean paramBoolean)
  {
    if (("status_bar_color_style".equals(this.mStatusBarColor)) || (paramBoolean)) {
      this.mStatusBarColor = paramString;
    }
  }
  
  public void setStatusBarFontColor(Boolean paramBoolean)
  {
    this.mStatusBarFontColorWhite = paramBoolean;
  }
  
  public void setStatusBarFontColor(Boolean paramBoolean, boolean paramBoolean1)
  {
    FragmentActivity localFragmentActivity;
    if ((paramBoolean1) && (paramBoolean != this.mStatusBarFontColorWhite))
    {
      localFragmentActivity = getActivity();
      if (paramBoolean.booleanValue()) {
        break label37;
      }
    }
    label37:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      akfw.a(localFragmentActivity, paramBoolean1);
      this.mStatusBarFontColorWhite = paramBoolean;
      return;
    }
  }
  
  public void setStatusBarImmersive()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mIsStatusImmersive = true;
      this.mTitleRootView.setFitsSystemWindows(false);
      setNoPadding();
      if (getActivity().mSystemBarComp != null) {
        break label128;
      }
      getActivity().setImmersiveStatus(0);
    }
    for (;;)
    {
      if (this.mTitleRootView.indexOfChild(this.mTitleContainer) != -1)
      {
        this.mTitleRootView.removeView(this.mTitleContainer);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTitleContainer.getLayoutParams();
        localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
        this.mTitleContainer.setLayoutParams(localLayoutParams);
        this.mTitleRootView.addView(this.mTitleContainer);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.mContentView.setLayoutParams(localLayoutParams);
      }
      return;
      label128:
      getActivity().mSystemBarComp.setStatusBarDrawable(null);
      getActivity().mSystemBarComp.setStatusBarColor(0);
      getActivity().mSystemBarComp.setStatusColor(0);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitleContainer.setTitle(paramCharSequence);
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    this.mTitleContainer.setTitle(paramCharSequence, paramString);
  }
  
  public void setTitleAlpha(float paramFloat)
  {
    this.mTitleContainer.setAlpha(paramFloat);
  }
  
  public void setTitleContainerBackgroundColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mTitleContainer.getVisibility() != 0) {
        this.mTitleContainer.setVisibility(0);
      }
      this.mTitleContainer.setBackgroundColor(Color.parseColor(paramString));
    }
  }
  
  public void setTitleContainerClick(View.OnClickListener paramOnClickListener)
  {
    if (this.mTitleContainer != null) {
      this.mTitleContainer.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitleTransparent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTitleContainer.setBackgroundColor(0);
      return;
    }
    this.mTitleContainer.setBackgroundColor(-1);
  }
  
  public void setTitleView()
  {
    if (getActivity() == null) {
      return;
    }
    this.mTitleContainer = ((NavBarCommon)this.mTitleRootView.findViewById(2131376501));
    initTitleView(this.mTitleContainer);
  }
  
  public void setTransparent(boolean paramBoolean)
  {
    this.mIsStatusViewTransparent = paramBoolean;
    setStatusBarTrans();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (!this.mIsContentInit)) {
      initViewAfterVisible();
    }
    if ((this.mIsContentInit) && (getRootView() != null))
    {
      if (paramBoolean)
      {
        this.mIsStart = true;
        onFragmentStartLazy();
        onResumeLazy();
      }
    }
    else {
      return;
    }
    this.mIsStart = false;
    onPauseLazy();
    onFragmentStopLazy();
  }
  
  public void showLeftBackView()
  {
    this.mTitleLeftView.setVisibility(0);
  }
  
  public void showTitleBar()
  {
    try
    {
      this.mTitleContainer = ((NavBarCommon)this.mTitleRootView.findViewById(2131376501));
      if ((this.mTitleContainer.getVisibility() != 0) && (this.mOriginalTitleVisibility == 0)) {
        this.mTitleContainer.setVisibility(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaLazyFragment", 2, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment
 * JD-Core Version:    0.7.0.1
 */