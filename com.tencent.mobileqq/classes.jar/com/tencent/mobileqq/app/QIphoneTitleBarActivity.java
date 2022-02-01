package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QIphoneTitleBarActivity
  extends QBaseActivity
{
  public static final String HIDE_TITLE_LEFT_ARROW = "hide_title_left_arrow";
  public static final String INDIVIDUATION_URL_SOURCE_TYPE = "individuation_url_type";
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int REPORT_FROM_AIO = 40300;
  public static final int REPORT_FROM_AIO_EMOTICON_MANAGER = 40313;
  protected static final String TAG = "IphoneTitleBarActivity";
  private Drawable ad;
  @Deprecated
  public TextView centerView;
  private boolean isRightHighlightButton;
  @Deprecated
  public TextView leftView;
  @Deprecated
  public TextView leftViewNotBack;
  protected View mContentView;
  protected int mContentViewID = -1;
  protected float mDensity;
  @Deprecated
  protected ImageView mLeftBackIcon;
  @Deprecated
  protected TextView mLeftBackText;
  private RelativeLayout mLoadingParent;
  private ImageView mLoadingView;
  public boolean mNeedTitleBarTrans = false;
  private boolean mNotShowLeftText = true;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  @Deprecated
  public View mTitleContainer = null;
  protected boolean mUseOptimizMode = false;
  protected View.OnClickListener onBackListeger = new QIphoneTitleBarActivity.1(this);
  @Deprecated
  public TextView rightHighLView;
  @Deprecated
  public ImageView rightViewImg;
  @Deprecated
  public TextView rightViewText;
  @Deprecated
  public RelativeLayout titleRoot;
  protected ViewGroup vg;
  
  private void printWindowFeatures()
  {
    Window localWindow = getWindow();
    try
    {
      if (localWindow.hasFeature(0)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_OPTIONS_PANEL");
      }
      if (localWindow.hasFeature(1)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_NO_TITLE");
      }
      if (localWindow.hasFeature(2)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_PROGRESS");
      }
      if (localWindow.hasFeature(3)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_LEFT_ICON");
      }
      if (localWindow.hasFeature(4)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_RIGHT_ICON");
      }
      if (localWindow.hasFeature(5)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_INDETERMINATE_PROGRESS");
      }
      if (localWindow.hasFeature(6)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_CONTEXT_MENU");
      }
      if (localWindow.hasFeature(7)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_CUSTOM_TITLE");
      }
      if (localWindow.hasFeature(8)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_ACTION_BAR");
      }
      if (localWindow.hasFeature(9)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_ACTION_BAR_OVERLAY");
      }
      if (localWindow.hasFeature(10)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_ACTION_MODE_OVERLAY");
      }
      if (localWindow.hasFeature(11)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_SWIPE_TO_DISMISS");
      }
      if (localWindow.hasFeature(12)) {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_CONTENT_TRANSITIONS");
      }
      if (localWindow.hasFeature(13))
      {
        QLog.i("IphoneTitleBarActivity", 1, "printWindowFeatures: FEATURE_ACTIVITY_TRANSITIONS");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IphoneTitleBarActivity", 1, "printWindowFeatures: ", localThrowable);
    }
  }
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void enableLeftBtn(boolean paramBoolean)
  {
    TextView localTextView = this.leftViewNotBack;
    if (localTextView != null) {
      localTextView.setEnabled(paramBoolean);
    }
  }
  
  protected void enableRightHighlight(boolean paramBoolean)
  {
    if (this.rightHighLView != null)
    {
      if (!this.isRightHighlightButton) {
        return;
      }
      if (paramBoolean)
      {
        this.rightViewText.setVisibility(8);
        this.rightHighLView.setVisibility(0);
        return;
      }
      this.rightViewText.setVisibility(0);
      this.rightHighLView.setVisibility(8);
    }
  }
  
  public View getRightTextView()
  {
    this.rightViewText = ((TextView)findViewById(2131436211));
    setLayerType(this.rightViewText);
    return this.rightViewText;
  }
  
  public String getTextTitle()
  {
    Object localObject = this.centerView;
    if ((localObject != null) && ((localObject instanceof TextView)))
    {
      localObject = ((TextView)localObject).getText();
      if (localObject != null) {
        return ((CharSequence)localObject).toString();
      }
    }
    return null;
  }
  
  public View getTitleBarView()
  {
    return findViewById(2131444897);
  }
  
  public void hideTitleBar()
  {
    try
    {
      this.mTitleContainer = findViewById(2131444897);
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void init(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130852235));
    if (this.leftView == null)
    {
      this.vg = ((ViewGroup)findViewById(2131444897));
      onCreateLeftView();
      try
      {
        if ((paramIntent.getBooleanExtra("hide_title_left_arrow", false)) && (this.leftView != null)) {
          this.leftView.setBackgroundDrawable(null);
        }
        onCreateCenterView();
        onCreateRightView();
        setLeftViewName(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.d("IphoneTitleBarActivity", 1, "", paramIntent);
      }
    }
  }
  
  public boolean isTitleProgressShowing()
  {
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      ImageView localImageView = this.mLoadingView;
      if ((localImageView != null) && (localImageView.getVisibility() != 8)) {
        return true;
      }
    }
    else if (this.ad != null)
    {
      return true;
    }
    return false;
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected View onCreateCenterView()
  {
    this.centerView = ((TextView)findViewById(2131436227));
    return this.centerView;
  }
  
  protected View onCreateLeftView()
  {
    this.leftView = ((TextView)findViewById(2131436180));
    this.leftView.setOnClickListener(this.onBackListeger);
    this.mLeftBackText = ((TextView)findViewById(2131448219));
    this.mLeftBackIcon = ((ImageView)findViewById(2131436666));
    TextView localTextView = this.mLeftBackText;
    if ((localTextView != null) && (this.mLeftBackIcon != null))
    {
      localTextView.setOnClickListener(this.onBackListeger);
      this.mLeftBackIcon.setOnClickListener(this.onBackListeger);
    }
    return this.leftView;
  }
  
  protected View onCreateRightView()
  {
    this.rightViewText = ((TextView)findViewById(2131436211));
    this.rightViewImg = ((ImageView)findViewById(2131436194));
    return this.rightViewText;
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.vg.setLayerType(0, null);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  public void setClickableTitle(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    setTitle(paramCharSequence);
    paramCharSequence = this.centerView;
    if ((paramCharSequence != null) && ((paramCharSequence instanceof TextView)))
    {
      boolean bool;
      if (paramOnClickListener != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramCharSequence.setClickable(bool);
      this.centerView.setOnClickListener(paramOnClickListener);
    }
  }
  
  @TargetApi(14)
  public void setContentView(int paramInt)
  {
    if (!this.mNeedStatusTrans)
    {
      printWindowFeatures();
      super.setContentView(paramInt);
      this.mContentViewID = paramInt;
      getWindow().setFeatureInt(7, 2131624579);
    }
    else
    {
      Object localObject3 = LayoutInflater.from(this);
      Object localObject1 = ((LayoutInflater)localObject3).inflate(2131624581, null);
      int i = 1;
      try
      {
        localObject3 = ((LayoutInflater)localObject3).inflate(paramInt, (ViewGroup)localObject1, false);
        this.titleRoot = ((RelativeLayout)((View)localObject1).findViewById(2131447595));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.titleRoot.setFitsSystemWindows(true);
          this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131444897);
        this.titleRoot.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        this.mContentView = ((View)localObject3);
        printWindowFeatures();
        super.setContentView(this.titleRoot);
        i = 0;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
      }
      catch (InflateException localInflateException)
      {
        localInflateException.printStackTrace();
      }
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("layout with merge ,use framelayout to immersive");
          ((StringBuilder)localObject2).append(getComponentName());
          QLog.e("IphoneTitleBarActivity", 2, ((StringBuilder)localObject2).toString());
        }
        printWindowFeatures();
        super.setContentView(paramInt);
        this.mContentViewID = paramInt;
        getWindow().setFeatureInt(7, 2131624579);
        localObject2 = this.mTitleContainer;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        this.mDensity = getResources().getDisplayMetrics().density;
        init(getIntent());
        return;
      }
    }
    Object localObject2 = this.mTitleContainer;
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
    }
    this.mDensity = getResources().getDisplayMetrics().density;
    init(getIntent());
  }
  
  @TargetApi(14)
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
    this.mDensity = getResources().getDisplayMetrics().density;
    if (!this.mNeedStatusTrans)
    {
      printWindowFeatures();
      super.setContentView(paramView);
      getWindow().setFeatureInt(7, 2131624579);
    }
    else
    {
      this.titleRoot = ((RelativeLayout)LayoutInflater.from(this).inflate(2131624581, null).findViewById(2131447595));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.titleRoot.setFitsSystemWindows(true);
        this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131444897);
      this.titleRoot.addView(paramView, localLayoutParams);
      printWindowFeatures();
      super.setContentView(this.titleRoot);
    }
    paramView = this.mTitleContainer;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    init(getIntent());
  }
  
  public View setContentViewB(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2131624339, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  public void setContentViewC(int paramInt)
  {
    this.mContentViewID = paramInt;
    printWindowFeatures();
    super.setContentView(paramInt);
  }
  
  @TargetApi(14)
  public void setContentViewNoTitle(int paramInt)
  {
    this.mContentViewID = paramInt;
    this.mDensity = getResources().getDisplayMetrics().density;
    View localView = LayoutInflater.from(this).inflate(paramInt, null, false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    printWindowFeatures();
    super.setContentView(localView);
    getWindow().setFeatureInt(7, 2131624631);
    try
    {
      this.mTitleContainer = ((View)findViewById(2131433232).getParent());
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void setContentViewNoTitle(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.mDensity = getResources().getDisplayMetrics().density;
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      ImmersiveUtils.setFitsSystemWindows(paramView, true);
    }
    printWindowFeatures();
    super.setContentView(paramView);
    getWindow().setFeatureInt(7, 2131624631);
    try
    {
      this.mTitleContainer = ((View)findViewById(2131433232).getParent());
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable paramView) {}
  }
  
  protected String setLastActivityName()
  {
    TextView localTextView = this.centerView;
    if ((localTextView != null) && (localTextView.getText() != null) && (this.centerView.getText().length() != 0)) {
      return this.centerView.getText().toString();
    }
    return getString(2131887625);
  }
  
  public void setLeftButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131436182));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.leftViewNotBack.setOnClickListener(this.onBackListeger);
      return;
    }
    this.leftViewNotBack.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftButton(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLeftButton() called with: text = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], l = [");
      localStringBuilder.append(paramOnClickListener);
      localStringBuilder.append("]");
      QLog.d("IphoneTitleBarActivity", 2, localStringBuilder.toString());
    }
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131436182));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramString);
    if (paramOnClickListener == null)
    {
      this.leftViewNotBack.setOnClickListener(this.onBackListeger);
      return;
    }
    this.leftViewNotBack.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftViewName(int paramInt)
  {
    Object localObject1 = this.leftView;
    if ((localObject1 != null) && ((localObject1 instanceof TextView)))
    {
      localObject1 = this.leftViewNotBack;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      Object localObject2 = getString(paramInt);
      TextView localTextView = this.leftView;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!"".equals(localObject2)) {}
      }
      else
      {
        localObject1 = getString(2131887625);
      }
      if (this.mNotShowLeftText) {
        localTextView.setText("  ");
      } else {
        localTextView.setText((CharSequence)localObject1);
      }
      localTextView.setVisibility(0);
      if (AppSetting.e)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).contains(getString(2131887625)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getString(2131887625));
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        this.leftView.setContentDescription((CharSequence)localObject2);
      }
    }
  }
  
  public void setLeftViewName(Intent paramIntent)
  {
    Object localObject = this.leftView;
    if ((localObject != null) && ((localObject instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localObject = this.leftViewNotBack;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.leftView;
      String str = paramIntent.getExtras().getString("leftViewText");
      int i = paramIntent.getExtras().getInt("individuation_url_type");
      localObject = str;
      if (i >= 40300)
      {
        localObject = str;
        if (i <= 40313)
        {
          localObject = str;
          if (!TextUtils.isEmpty(str))
          {
            localObject = str;
            if (str.contains(HardCodeUtil.a(2131903788))) {
              localObject = getString(2131887625);
            }
          }
        }
      }
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = getString(2131887625);
      }
      if (this.mNotShowLeftText) {
        localTextView.setText("  ");
      } else {
        localTextView.setText(paramIntent);
      }
      localTextView.setVisibility(0);
      if (AppSetting.e)
      {
        localObject = paramIntent;
        if (!paramIntent.contains(getString(2131887625)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(getString(2131887625));
          ((StringBuilder)localObject).append(paramIntent);
          localObject = ((StringBuilder)localObject).toString();
        }
        this.leftView.setContentDescription((CharSequence)localObject);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void setRightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = false;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramInt);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
    if (AppSetting.e)
    {
      paramOnClickListener = this.rightViewText;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.rightViewText.getText());
      localStringBuilder.append(HardCodeUtil.a(2131903789));
      paramOnClickListener.setContentDescription(localStringBuilder.toString());
    }
  }
  
  protected void setRightHighlightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = true;
    Object localObject = this.rightViewText;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.rightViewText.setText(paramInt);
      this.rightViewText.setEnabled(false);
      this.rightHighLView = ((TextView)getLayoutInflater().inflate(2131624584, null));
      setLayerType(this.rightHighLView);
      this.rightHighLView.setText(paramInt);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(this.mDensity * 8.0F));
      this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
      this.rightHighLView.setVisibility(8);
      if (paramOnClickListener != null) {
        this.rightHighLView.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  @TargetApi(11)
  public void setRightViewTextDisable(int paramInt)
  {
    if (paramInt == 0)
    {
      this.rightViewText.setEnabled(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.rightViewText.setAlpha(0.5F);
      }
    }
    else
    {
      this.rightViewText.setEnabled(true);
      if (Build.VERSION.SDK_INT >= 11) {
        this.rightViewText.setAlpha(1.0F);
      }
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    TextView localTextView = this.centerView;
    if ((localTextView != null) && ((localTextView instanceof TextView)))
    {
      localTextView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    TextView localTextView = this.centerView;
    if ((localTextView != null) && ((localTextView instanceof TextView)))
    {
      localTextView.setText(paramCharSequence);
      if (AppSetting.e) {
        localTextView.setContentDescription(paramString);
      }
      super.setTitle(paramString);
    }
  }
  
  public void showContentViewTitle(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        View localView = (View)findViewById(2131444897).getParent();
        if (paramBoolean)
        {
          i = 0;
          localView.setVisibility(i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      int i = 8;
    }
  }
  
  public boolean startTitleProgress()
  {
    if (this.centerView == null) {
      return false;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.mUseOptimizMode)
    {
      localObject1 = (RelativeLayout)findViewById(2131447534);
      if (this.centerView.getVisibility() == 0)
      {
        localObject1 = this.centerView;
        localObject2 = ((TextView)localObject1).getParent();
      }
      else if ((localObject1 != null) && (((RelativeLayout)localObject1).getVisibility() == 0))
      {
        localObject2 = ((RelativeLayout)localObject1).getParent();
      }
      else
      {
        localObject1 = null;
        localObject2 = localObject1;
      }
      localObject3 = this.mLoadingParent;
      if ((localObject3 != null) && (localObject3 != localObject2))
      {
        localObject3 = this.mLoadingView;
        if (localObject3 != null)
        {
          localObject3 = ((ImageView)localObject3).getParent();
          RelativeLayout localRelativeLayout = this.mLoadingParent;
          if (localObject3 == localRelativeLayout)
          {
            localRelativeLayout.removeView(this.mLoadingView);
            this.mLoadingView = null;
          }
        }
        this.mLoadingParent = null;
      }
      if ((this.mLoadingParent == null) && ((localObject2 instanceof RelativeLayout))) {
        this.mLoadingParent = ((RelativeLayout)localObject2);
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (this.mLoadingView != null)
        {
          int i = ((View)localObject1).getId();
          localObject3 = (RelativeLayout.LayoutParams)this.mLoadingView.getLayoutParams();
          localObject2 = localObject1;
          if (localObject3.getRules()[0] != i)
          {
            localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(0, i);
            this.mLoadingView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            localObject2 = localObject1;
          }
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      localObject1 = this.mLoadingView;
      if ((localObject1 == null) || (((ImageView)localObject1).getVisibility() != 0))
      {
        if (this.mLoadingView == null)
        {
          localObject1 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.mLoadingView = new ImageView(this);
          this.mLoadingView.setId(2131437631);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, ((View)localObject2).getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(15);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(DeviceInfoUtil.A() * 7.0F));
          this.mLoadingParent.addView(this.mLoadingView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = getActivity().getResources().getDrawable(2130839588);
          this.mLoadingView.setImageDrawable((Drawable)localObject1);
          if ((localObject1 instanceof Animatable)) {
            ((Animatable)localObject1).start();
          }
        }
        if (this.mLoadingView.getVisibility() != 0) {
          this.mLoadingView.setVisibility(0);
        }
        return true;
      }
    }
    else if (this.ad == null)
    {
      this.ad = getResources().getDrawable(2130839588);
      this.mOldDrawables = this.centerView.getCompoundDrawables();
      this.mOldPadding = this.centerView.getCompoundDrawablePadding();
      this.centerView.setCompoundDrawablePadding(10);
      localObject1 = this.centerView;
      localObject2 = this.ad;
      localObject3 = this.mOldDrawables;
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, localObject3[1], localObject3[2], localObject3[3]);
      ((Animatable)this.ad).start();
      return true;
    }
    return false;
  }
  
  public boolean stopTitleProgress()
  {
    Object localObject;
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      localObject = this.mLoadingView;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() != 8))
      {
        this.mLoadingView.setVisibility(8);
        return true;
      }
    }
    else
    {
      localObject = this.ad;
      if (localObject != null)
      {
        ((Animatable)localObject).stop();
        this.ad = null;
        this.centerView.setCompoundDrawablePadding(this.mOldPadding);
        localObject = this.centerView;
        Drawable[] arrayOfDrawable = this.mOldDrawables;
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */