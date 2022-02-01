package com.tencent.mobileqq.apollo.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;

@RoutePage(desc="厘米秀商店FloatActivity", path="/cmshow/store/floatActivity")
public class ApolloFloatActivity
  extends ApolloBaseActivity
{
  private static final String TAG = "ApolloFloatActivity";
  private int mDelayTime = 1500;
  private int mFrom;
  private boolean mFullScreen;
  private int mGameId;
  private int mOrientation;
  TextView rightView;
  
  private void setFade()
  {
    if (this.mFrom == 1)
    {
      if (this.mOrientation == 2) {
        ApolloUtilImpl.setActivityFadeIn(this, 0, 0);
      }
    }
    else {
      return;
    }
    if (this.mOrientation == 3)
    {
      ApolloUtilImpl.setActivityFadeIn(this, 4, 4);
      return;
    }
    ApolloUtilImpl.setActivityFadeIn(this, 1, 1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    overridePendingTransition(0, 0);
  }
  
  @SuppressLint({"NewApi"})
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (this.mFullScreen) {
      this.mNeedStatusTrans = false;
    }
    super.doOnCreate(paramBundle);
    paramBundle = new RelativeLayout(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.mWebView = super.getWebView(null);
    this.mWebView.setBackgroundColor(0);
    Intent localIntent = super.getIntent();
    int i;
    if (localIntent != null)
    {
      this.mGameId = localIntent.getIntExtra("extra_key_gameid", -1);
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.mGameId);
      i = localIntent.getIntExtra("extra_key_taskid", 0);
      if (localCmGameLauncher != null)
      {
        localCmGameLauncher.a(this, i);
        this.mFrom = localIntent.getIntExtra("extra_key_from", -1);
        if (this.mFrom != 1) {
          break label479;
        }
        getWindow().getDecorView().setSystemUiVisibility(5894);
        i = CmGameUtil.a(localIntent.getIntExtra("extra_key_entratation", 1));
        setRequestedOrientation(i);
        localIntent.getIntExtra("extra_key_transparent", 1);
        this.mDelayTime = 0;
        this.mOrientation = localIntent.getIntExtra("extra_key_entratation", 1);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloFloatActivity", 2, ((RelativeLayout.LayoutParams)localObject).width + "#" + ((RelativeLayout.LayoutParams)localObject).height + "#" + ((RelativeLayout.LayoutParams)localObject).leftMargin);
        }
        paramBundle.addView(this.mWebView, (ViewGroup.LayoutParams)localObject);
        setRequestedOrientation(i);
        label256:
        if (this.mWebView.getBackground() != null) {
          this.mWebView.getBackground().setAlpha(0);
        }
        if (localIntent == null) {
          break label538;
        }
        localObject = localIntent.getStringExtra("extra_key_weburl");
        this.mCurrentUrl = ((String)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label508;
        }
        this.mTimeBeforeLoadUrl = System.currentTimeMillis();
        this.mWebView.loadUrl((String)localObject);
      }
    }
    label538:
    for (;;)
    {
      localObject = super.getResources();
      if (this.mSystemBarComp != null)
      {
        i = ((Resources)localObject).getColor(2131167305);
        this.mSystemBarComp.setStatusColor(i);
        this.mSystemBarComp.setStatusBarColor(i);
      }
      if (super.getIntent().getBooleanExtra("extra_key_close_btn", false)) {
        paramBundle.postDelayed(new ApolloFloatActivity.1(this, (Resources)localObject, paramBundle), this.mDelayTime);
      }
      super.setContentView(paramBundle);
      if (!this.mFullScreen) {
        super.hideTitleBar();
      }
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(paramBundle.getContext().getApplicationContext());
      }
      this.onCreateTime = (System.currentTimeMillis() - this.mOnCreateMilliTimeStamp);
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloFloatActivity", 2, "[doOnCreate] can not found for id " + this.mGameId);
      break;
      label479:
      setRequestedOrientation(1);
      paramBundle.addView(this.mWebView, (ViewGroup.LayoutParams)localObject);
      break label256;
      QLog.e("ApolloFloatActivity", 1, "[doOnCreate] intent is null background trans");
      break label256;
      label508:
      if (QLog.isColorLevel())
      {
        QQToast.a(this, "透明浮层url为空", 0).a();
        QLog.e("ApolloFloatActivity", 2, "ApolloFloat WebUrl is empty!");
        continue;
        if (QLog.isColorLevel()) {
          QQToast.a(this, "透明浮层url为空", 0).a();
        }
        QLog.e("ApolloFloatActivity", 2, "[doOnCreate] intent is null url null");
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if (this.mFrom == 1) {
      ApolloGameTool.a(this);
    }
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView == this.rightView)
    {
      super.onBackEvent();
      finish();
      setFade();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    this.mFullScreen = paramIntent.getBooleanExtra("extra_key_fullscreen", false);
    if (this.mFullScreen) {
      getWindow().setFlags(1024, 1024);
    }
    super.requestWindowFeature(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloFloatActivity
 * JD-Core Version:    0.7.0.1
 */