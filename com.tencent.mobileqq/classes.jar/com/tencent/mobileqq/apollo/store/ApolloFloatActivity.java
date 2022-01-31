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
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import yzk;

public class ApolloFloatActivity
  extends ApolloBaseActivity
{
  public TextView a;
  private boolean a;
  private int b;
  private int c;
  private int d = 1500;
  private int e;
  
  private void d()
  {
    if (this.c == 1)
    {
      if (this.jdField_b_of_type_Int == 2) {
        ApolloUtil.a(this, 0, 0);
      }
    }
    else {
      return;
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      ApolloUtil.a(this, 4, 4);
      return;
    }
    ApolloUtil.a(this, 1, 1);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    overridePendingTransition(0, 0);
  }
  
  @SuppressLint({"NewApi"})
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.mNeedStatusTrans = false;
    }
    super.doOnCreate(paramBundle);
    paramBundle = new RelativeLayout(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_ComTencentBizUiTouchWebView = super.b(null);
    this.jdField_b_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
    Intent localIntent = super.getIntent();
    int i;
    if (localIntent != null)
    {
      this.e = localIntent.getIntExtra("extra_key_gameid", -1);
      CmGameLauncher localCmGameLauncher = CmGameUtil.b(this.e);
      i = localIntent.getIntExtra("extra_key_taskid", 0);
      if (localCmGameLauncher != null)
      {
        localCmGameLauncher.a(this, i);
        this.c = localIntent.getIntExtra("extra_key_from", -1);
        if (this.c != 1) {
          break label478;
        }
        getWindow().getDecorView().setSystemUiVisibility(5894);
        i = CmGameUtil.a(localIntent.getIntExtra("extra_key_entratation", 1));
        setRequestedOrientation(i);
        localIntent.getIntExtra("extra_key_transparent", 1);
        this.d = 0;
        this.jdField_b_of_type_Int = localIntent.getIntExtra("extra_key_entratation", 1);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloFloatActivity", 2, ((RelativeLayout.LayoutParams)localObject).width + "#" + ((RelativeLayout.LayoutParams)localObject).height + "#" + ((RelativeLayout.LayoutParams)localObject).leftMargin);
        }
        paramBundle.addView(this.jdField_b_of_type_ComTencentBizUiTouchWebView, (ViewGroup.LayoutParams)localObject);
        setRequestedOrientation(i);
        label256:
        if (this.jdField_b_of_type_ComTencentBizUiTouchWebView.getBackground() != null) {
          this.jdField_b_of_type_ComTencentBizUiTouchWebView.getBackground().setAlpha(0);
        }
        if (localIntent == null) {
          break label537;
        }
        localObject = localIntent.getStringExtra("extra_key_weburl");
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label507;
        }
        this.i = System.currentTimeMillis();
        this.jdField_b_of_type_ComTencentBizUiTouchWebView.loadUrl((String)localObject);
      }
    }
    label537:
    for (;;)
    {
      localObject = super.getResources();
      if (this.mSystemBarComp != null)
      {
        i = ((Resources)localObject).getColor(2131492924);
        this.mSystemBarComp.setStatusColor(i);
        this.mSystemBarComp.setStatusBarColor(i);
      }
      if (super.getIntent().getBooleanExtra("extra_key_close_btn", false)) {
        paramBundle.postDelayed(new yzk(this, (Resources)localObject, paramBundle), this.d);
      }
      super.setContentView(paramBundle);
      if (!this.jdField_a_of_type_Boolean) {
        super.hideTitleBar();
      }
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(paramBundle.getContext().getApplicationContext());
      }
      this.h = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloFloatActivity", 2, "[doOnCreate] can not found for id " + this.e);
      break;
      label478:
      setRequestedOrientation(1);
      paramBundle.addView(this.jdField_b_of_type_ComTencentBizUiTouchWebView, (ViewGroup.LayoutParams)localObject);
      break label256;
      QLog.e("ApolloFloatActivity", 1, "[doOnCreate] intent is null background trans");
      break label256;
      label507:
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
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if (this.c == 1) {
      ApolloGameTool.a(this);
    }
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      super.onBackEvent();
      finish();
      d();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("extra_key_fullscreen", false);
    if (this.jdField_a_of_type_Boolean) {
      getWindow().setFlags(1024, 1024);
    }
    super.requestWindowFeature(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloFloatActivity
 * JD-Core Version:    0.7.0.1
 */