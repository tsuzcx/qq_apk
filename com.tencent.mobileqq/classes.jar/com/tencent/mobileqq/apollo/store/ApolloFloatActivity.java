package com.tencent.mobileqq.apollo.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;

@RoutePage(desc="厘米秀商店FloatActivity", path="/cmshow/store/floatActivity")
public class ApolloFloatActivity
  extends ApolloBaseActivity
{
  private static final String TAG = "[cmshow]ApolloFloatActivity";
  private int mDelayTime = 1500;
  private boolean mFullScreen;
  private int mGameId;
  TextView rightView;
  
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
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.mWebView = super.getWebView(null);
    this.mWebView.setBackgroundColor(0);
    Intent localIntent = super.getIntent();
    int i;
    if (localIntent != null)
    {
      this.mGameId = localIntent.getIntExtra("extra_key_gameid", -1);
      Object localObject2 = CmGameUtil.a(this.mGameId);
      i = localIntent.getIntExtra("extra_key_taskid", 0);
      if (localObject2 != null)
      {
        ((CmGameLauncher)localObject2).a(this, i);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doOnCreate] can not found for id ");
        ((StringBuilder)localObject2).append(this.mGameId);
        QLog.d("[cmshow]ApolloFloatActivity", 2, ((StringBuilder)localObject2).toString());
      }
      setRequestedOrientation(1);
      paramBundle.addView(this.mWebView, (ViewGroup.LayoutParams)localObject1);
    }
    else
    {
      QLog.e("[cmshow]ApolloFloatActivity", 1, "[doOnCreate] intent is null background trans");
    }
    if (this.mWebView.getBackground() != null) {
      this.mWebView.getBackground().setAlpha(0);
    }
    if (localIntent != null)
    {
      localObject1 = localIntent.getStringExtra("extra_key_weburl");
      this.mCurrentUrl = ((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.mTimeBeforeLoadUrl = System.currentTimeMillis();
        this.mWebView.loadUrl((String)localObject1);
      }
      else if (QLog.isColorLevel())
      {
        QQToast.makeText(this, "透明浮层url为空", 0).show();
        QLog.e("[cmshow]ApolloFloatActivity", 2, "ApolloFloat WebUrl is empty!");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QQToast.makeText(this, "透明浮层url为空", 0).show();
      }
      QLog.e("[cmshow]ApolloFloatActivity", 2, "[doOnCreate] intent is null url null");
    }
    localObject1 = super.getResources();
    if (this.mSystemBarComp != null)
    {
      i = ((Resources)localObject1).getColor(2131168376);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
    if (super.getIntent().getBooleanExtra("extra_key_close_btn", false)) {
      paramBundle.postDelayed(new ApolloFloatActivity.1(this, (Resources)localObject1, paramBundle), this.mDelayTime);
    }
    super.setContentView(paramBundle);
    if (!this.mFullScreen) {
      super.hideTitleBar();
    }
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(paramBundle.getContext().getApplicationContext());
    }
    this.onCreateTime = (System.currentTimeMillis() - this.mOnCreateMilliTimeStamp);
    return false;
  }
  
  protected boolean isWrapContent()
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
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    this.mFullScreen = paramIntent.getBooleanExtra("extra_key_fullscreen", false);
    if (this.mFullScreen) {
      getWindow().setFlags(1024, 1024);
    }
    super.requestWindowFeature(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloFloatActivity
 * JD-Core Version:    0.7.0.1
 */