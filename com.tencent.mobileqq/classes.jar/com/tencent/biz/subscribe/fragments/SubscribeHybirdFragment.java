package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import amgo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axmt;
import bbev;
import bbjw;
import bcbv;
import bcfj;
import bcsc;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import wiv;
import wiw;
import wkp;
import wnl;
import wqe;
import wqf;
import wqg;
import wqh;
import wqi;
import wqj;
import wsr;
import wva;
import xhe;

public class SubscribeHybirdFragment
  extends WebViewFragment
{
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CertifiedAccountMeta.StShare jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  protected amgo a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private CommentBottomBar jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private wqj jdField_a_of_type_Wqj;
  private wsr jdField_a_of_type_Wsr;
  private wva jdField_a_of_type_Wva;
  
  private View.OnClickListener a(wkp paramwkp)
  {
    return new wqh(this, paramwkp);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (!bbjw.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()))) {
      xhe.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_" + wva.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo), paramInt, 0, new String[0]);
    }
  }
  
  private void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, long paramLong, String paramString)
  {
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if (a(paramLong, paramString)) {}
    while (a(localStFeed)) {
      return;
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = ((CertifiedAccountMeta.StShare)paramStGetFeedDetailRsp.share.get());
    b(localStFeed);
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8001)
    {
      WebSoService.a().a();
      xhe.a(this.f, "auth_image", "exp", 0, 0, new String[] { "", "", localStFeed.poster.nick.get(), localStFeed.title.get() });
    }
    if (!bbjw.a(paramStGetFeedDetailRsp.detailUrl.get()))
    {
      if (getWebView() != null)
      {
        getWebView().loadUrl(paramStGetFeedDetailRsp.detailUrl.get());
        return;
      }
      QLog.e("SubscribeHybirdFragment", 2, "webview init exception it's null");
      return;
    }
    QLog.e("SubscribeHybirdFragment", 2, "detailUrl is null");
  }
  
  public static void a(Context paramContext, FollowUpdateEvent paramFollowUpdateEvent)
  {
    if ((paramContext == null) || (paramFollowUpdateEvent == null)) {
      return;
    }
    Intent localIntent = new Intent("action_update_follow_state");
    localIntent.putExtra("uin", paramFollowUpdateEvent.useId);
    localIntent.putExtra("followState", paramFollowUpdateEvent.followStatus);
    paramContext.sendBroadcast(localIntent);
  }
  
  private boolean a(long paramLong, String paramString)
  {
    if (paramLong != 0L)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(paramString);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (!wiw.a(paramStFeed.status.get())) {
      if (wiw.a(paramStFeed.poster.attr.get()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558707, null, false);
          this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, ImmersiveUtils.a(44.0F)));
          this.jdField_a_of_type_Bcfj.c.addView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.getVisibility() == 8))
      {
        if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(null);
      }
      return true;
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b();
      }
    } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return false;
  }
  
  private void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setCurrentFeed(paramStFeed);
    }
    if (this.jdField_a_of_type_Wsr != null) {
      this.jdField_a_of_type_Wsr.a(paramStFeed.poster);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = new StatusView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
    this.jdField_a_of_type_Bcfj.c.addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
  }
  
  private void k()
  {
    Object localObject = wiw.a();
    if (new File((String)localObject).exists())
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageURI(Uri.fromFile(new File((String)localObject + "/certified_account_preload_pic.png")));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((this.jdField_a_of_type_Bcfj != null) && (this.jdField_a_of_type_Bcfj.c != null)) {
        this.jdField_a_of_type_Bcfj.c.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 8001)) {}
    while (this.jdField_a_of_type_Amgo != null) {
      return;
    }
    this.jdField_a_of_type_Amgo = new amgo(getActivity(), false, true);
    this.jdField_a_of_type_Amgo.a(getActivity());
    this.jdField_a_of_type_Amgo.a(new wqe(this));
    this.jdField_a_of_type_Amgo.a(new wqf(this));
    this.jdField_a_of_type_Amgo.a(new wqg(this));
  }
  
  private void m()
  {
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839754);
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130839748);
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void n()
  {
    if (a() != null)
    {
      long l = a().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l != 0L) {
        xhe.a("subscribe_open_h5_page_time", xhe.a(0L, System.currentTimeMillis() - l));
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)a().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo();
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("bundle_key_subscribe_feed_bytes_array")));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 7000) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 8001)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject1).gravity = 80;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(getActivity());
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(a(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new wqi(this));
      Object localObject2 = new wkp();
      ((wkp)localObject2).jdField_a_of_type_Boolean = false;
      ((wkp)localObject2).jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(a((wkp)localObject2));
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
      localObject1 = new ViewStub(a());
      localObject2 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject2).gravity = 80;
      ((ViewStub)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1);
      this.jdField_a_of_type_Bcfj.c.setPadding(0, 0, 0, ImmersiveUtils.a(50.0F));
    } while (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() == null);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().b((ViewStub)localObject1);
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    getWebView().getSettings().setDefaultTextEncodingName("utf-8");
    getWebView().getSettings().setUserAgentString(getWebView().getSettings().getUserAgentString() + " QQ_APP_Subscribe");
    if (bbev.g(getActivity())) {
      getWebView().getSettings().setCacheMode(2);
    }
    if ((this.jdField_a_of_type_Bcfj != null) && (this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcsc != null)) {
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcsc.a(false);
    }
    switch (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    default: 
      if ((axmt.b()) && (Build.VERSION.SDK_INT >= 23))
      {
        if (this.d != null) {
          this.d.setBackgroundColor(-1);
        }
        this.jdField_a_of_type_Int = (getActivity().getWindow().getDecorView().getSystemUiVisibility() | 0x400 | 0x2000);
        getActivity().getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8002) {
        this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      break;
    }
    for (;;)
    {
      o();
      j();
      l();
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8001) {
        this.jdField_a_of_type_Wsr = new wsr(getActivity());
      }
      if (getActivity() != null)
      {
        this.jdField_a_of_type_Wqj = new wqj(this, null);
        paramBundle = new IntentFilter();
        paramBundle.addAction("action_update_follow_state");
        paramBundle.addAction("action_get_lbs_location");
        getActivity().registerReceiver(this.jdField_a_of_type_Wqj, paramBundle);
      }
      return i;
      m();
      k();
      break;
      if ((getActivity().getIntent() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8002))
      {
        this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      paramBundle = new wkp();
      paramBundle.jdField_a_of_type_Boolean = true;
      paramBundle.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(a(paramBundle));
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (wiv.c(paramStFeed.type.get()))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(paramStFeed);
      if (getWebView() != null) {
        getWebView().pageUp(true);
      }
    }
    do
    {
      return;
      wiv.a(getActivity(), paramStFeed);
    } while (getActivity() == null);
    getActivity().finish();
  }
  
  public void a(WebView paramWebView, int paramInt)
  {
    super.a(paramWebView, paramInt);
    if ((paramInt > 25) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.set(paramString1);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.set(paramString2);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.set(paramString3);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.desc.set(paramString4);
      paramString2 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type;
      if (!bbjw.a(paramString5)) {
        break label108;
      }
    }
    label108:
    for (int i = 0;; i = Integer.parseInt(paramString5))
    {
      paramString2.set(i);
      xhe.a(paramString1, "auth_person", "exp", 0, 0, new String[0]);
      return;
    }
  }
  
  public void a(ArrayList<CommodityBean> paramArrayList)
  {
    if (a() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("attach_goods", paramArrayList);
      localIntent.setAction("action_attach_goods");
      if (a() != null) {
        a().sendBroadcast(localIntent);
      }
    }
  }
  
  public void a(wkp paramwkp)
  {
    wkp localwkp = paramwkp;
    if (paramwkp == null) {
      localwkp = new wkp();
    }
    if (this.jdField_a_of_type_Wva != null)
    {
      a(localwkp.jdField_a_of_type_Int);
      localwkp.jdField_a_of_type_JavaLangString = b();
      localwkp.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      localwkp.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
      localwkp.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      this.jdField_a_of_type_Wva.a(localwkp, this.jdField_a_of_type_Amgo);
    }
  }
  
  public void aa_()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    if (a() != null) {
      a().sendBroadcast(localIntent);
    }
  }
  
  public int c(Bundle paramBundle)
  {
    this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.B = false;
    this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.f = true;
    this.jdField_a_of_type_Wva = new wva(a());
    n();
    return super.c(paramBundle);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.b())) {
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)
    {
      str = "";
      switch (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      }
    }
    for (;;)
    {
      xhe.a(this.f, str, "clk_return", 0, 0, new String[] { "", "" });
      super.f();
      return;
      str = "auth_image";
      continue;
      str = "auth_video";
      continue;
      str = "auth_person";
    }
  }
  
  public void i()
  {
    if (a() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_refresh_return_page");
      if (a() != null) {
        a().sendBroadcast(localIntent);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.c();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (this.jdField_a_of_type_Amgo != null) {
      this.jdField_a_of_type_Amgo.c();
    }
    if (this.jdField_a_of_type_Wva != null) {
      this.jdField_a_of_type_Wva.b();
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_Wqj != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Wqj);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Amgo != null) {
      this.jdField_a_of_type_Amgo.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Amgo != null) {
      this.jdField_a_of_type_Amgo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment
 * JD-Core Version:    0.7.0.1
 */