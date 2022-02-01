package com.tencent.biz.pubaccount;

import Override;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import anni;
import aqcb;
import bgln;
import bgnt;
import bmqa;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import nys;
import nyt;
import nyu;
import nyv;
import nyw;
import nyx;
import nyy;
import nza;
import nzd;
import oat;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pha;
import phi;
import pmk;
import pmn;
import rbo;
import tzo;

public class PublicAccountBrowser
  extends QQBrowserActivity
{
  private static final String jdField_a_of_type_JavaLangString = anni.a(2131707544);
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RIJRedPacketPopupView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView;
  @Nullable
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private TouchWebView.OnScrollChangedListener jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener;
  private FadeIconImageView jdField_a_of_type_ComTencentWidgetFadeIconImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public final Pattern a;
  private pmn jdField_a_of_type_Pmn = new nyt(this);
  public boolean a;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RIJRedPacketPopupView jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  private boolean c;
  private String d;
  private int e;
  
  public PublicAccountBrowser()
  {
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangClass = PublicAccountBrowser.PublicAccountBrowserFragment.class;
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString).getQueryParameter("redpackid");
    }
    return "";
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131368961));
      if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibilityHandler(new nyv(this));
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368966));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new nyw(this));
      }
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || ((paramBoolean) && (paramView.getVisibility() == 0)) || ((!paramBoolean) && (paramView.getVisibility() != 0))) {
      return;
    }
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new nys(this, paramBoolean, paramView));
      paramView.startAnimation(localAlphaAnimation);
      return;
    }
  }
  
  private void a(RIJRedPacketPopupView paramRIJRedPacketPopupView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, int paramInt3)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramRIJRedPacketPopupView.getLayoutParams();
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.topMargin = paramInt2;
    paramRIJRedPacketPopupView.setLayoutParams(localLayoutParams);
    paramRIJRedPacketPopupView.setText(paramCharSequence);
    paramRIJRedPacketPopupView.a(paramBoolean2);
    if (paramBoolean2) {
      paramRIJRedPacketPopupView.setOnCloseIconClickListener(new nzd(this, paramRIJRedPacketPopupView));
    }
    paramRIJRedPacketPopupView.b(paramBoolean1);
    a(paramRIJRedPacketPopupView, true);
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountBrowser.10(this, paramRIJRedPacketPopupView), paramInt3);
  }
  
  private void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication();
    if (paramString != null)
    {
      paramString = bmqa.a(paramString.getRuntime(), false, true);
      if (paramString != null)
      {
        paramString = paramString.edit();
        paramString.putString("mLoadingUrl", str);
        paramString.commit();
        Log.d("KandianVideoUpload", "正在添加url" + str);
      }
    }
  }
  
  private void b()
  {
    if (!bmqa.n()) {
      return;
    }
    bmqa.e();
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.postDelayed(new PublicAccountBrowser.8(this), 200L);
  }
  
  private void b(String paramString)
  {
    int j = 1;
    phi localphi = new phi();
    paramString = localphi.a("uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())).a("rowkey", paramString).a("os", Integer.valueOf(1)).a("imsi", bgln.b()).a("imei", pha.h());
    if (bgnt.h(BaseApplicationImpl.getContext()))
    {
      i = 2;
      paramString = paramString.a("network_type", Integer.valueOf(i));
      if (!this.jdField_c_of_type_Boolean) {
        break label175;
      }
      i = 1;
      label99:
      paramString = paramString.a("is_redpack", Integer.valueOf(i)).a("redpack_style", Integer.valueOf(this.e));
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label180;
      }
    }
    label175:
    label180:
    for (int i = j;; i = 0)
    {
      paramString.a("is_tips", Integer.valueOf(i)).a("page_type", Integer.valueOf(2));
      oat.a("0X800AD2F", localphi.a());
      return;
      i = 1;
      break;
      i = 0;
      break label99;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.c();
      QLog.i("PublicAccountBrowser", 1, "report timinggggggg");
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://post.mp.qq.com/kan/article/")))
    {
      String str = Uri.parse(paramString).getQueryParameter("rowkey");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_c_of_type_JavaLangString = str;
        if ((rbo.a().a()) && (rbo.a().d()) && (rbo.a().b()))
        {
          RIJRedPacketManager.a().a(str, new nyx(this));
          rbo.a().a(new nyy(this, str));
        }
        this.d = a(paramString);
        if ((!TextUtils.isEmpty(this.d)) && (rbo.a().b())) {
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new PublicAccountBrowser.6(this, str), 500L);
        }
      }
    }
  }
  
  private void d(String paramString)
  {
    RIJRedPacketManager.a().a(paramString, this.d, 5, new nza(this, paramString));
  }
  
  private void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    QLog.i("PublicAccountBrowser", 1, "resume timing:  task time has gone: " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaLangRunnable = new PublicAccountBrowser.12(this, paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public String a()
  {
    return getIntent().getExtras().getString("puin");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    a(str);
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.openQQBrowserActivity(this, str, 16L, localIntent, false, -1);
      super.finish();
      return false;
    }
    super.g();
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_SLIDE_RIGHT_BACK_ENABLE", true))
    {
      super.f();
      a(new PublicAccountCompactSwipeBackLayout(this));
      paramBundle = super.a();
      if (paramBundle != null) {
        paramBundle.g();
      }
    }
    pmk.a().a(this.jdField_a_of_type_Pmn);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    pmk.a().b(this.jdField_a_of_type_Pmn);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      b(this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) && (rbo.a().a()) && (rbo.a().d()) && (rbo.a().b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getVisibility() == 0)) {
      c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    String str = getIntent().getStringExtra("url");
    a();
    new Handler().postDelayed(new PublicAccountBrowser.1(this, str), 200L);
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("public_account_finish_animation_out_to_bottom", false)) {
      overridePendingTransition(0, 2130771978);
    }
  }
  
  public ColorNote getColorNote()
  {
    ColorNote localColorNote = super.getColorNote();
    if (tzo.c(getIntent().getStringExtra("url"))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(new String(localColorNote.getReserve()));
      localJSONObject.put("h5_type_read_in_joy", true);
      localColorNote.mReserve = localJSONObject.toString().getBytes();
      return localColorNote;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PublicAccountBrowser", 1, localJSONException, new Object[0]);
    }
    return localColorNote;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TouchWebView localTouchWebView = (TouchWebView)findViewById(2131381152);
    if (localTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener = new nyu(this);
      localTouchWebView.addScrollChangedListener(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TouchWebView localTouchWebView = (TouchWebView)findViewById(2131381152);
    if ((localTouchWebView != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener != null)) {
      localTouchWebView.removeScrollChangedListener(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */