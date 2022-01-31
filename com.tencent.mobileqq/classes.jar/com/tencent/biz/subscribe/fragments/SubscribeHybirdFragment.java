package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import alrv;
import android.app.Activity;
import android.content.Intent;
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
import awnu;
import badq;
import baip;
import bazb;
import bbcj;
import bbpa;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
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
import vvy;
import vvz;
import vxn;
import vzz;
import wcr;
import wcs;
import wct;
import wcu;
import wcv;
import wfz;
import wye;

public class SubscribeHybirdFragment
  extends WebViewFragment
{
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CertifiedAccountMeta.StShare jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  protected alrv a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private CommentBottomBar jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private wfz jdField_a_of_type_Wfz;
  
  private View.OnClickListener a(vxn paramvxn)
  {
    return new wcu(this, paramvxn);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (!baip.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()))) {
      wye.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_" + wfz.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo), paramInt, 0, new String[0]);
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
      wye.a(this.f, "auth_image", "exp", 0, 0, new String[] { "", "", localStFeed.poster.nick.get(), localStFeed.title.get() });
    }
    if (!baip.a(paramStGetFeedDetailRsp.detailUrl.get()))
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
    if (!vvz.a(paramStFeed.status.get())) {
      if (vvz.a(paramStFeed.poster.attr.get()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131493151, null, false);
          this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, ImmersiveUtils.a(44.0F)));
          this.jdField_a_of_type_Bbcj.c.addView(this.jdField_a_of_type_AndroidViewView);
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
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = new StatusView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
    this.jdField_a_of_type_Bbcj.c.addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
  }
  
  private void j()
  {
    Object localObject = vvz.a();
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
      if ((this.jdField_a_of_type_Bbcj != null) && (this.jdField_a_of_type_Bbcj.c != null)) {
        this.jdField_a_of_type_Bbcj.c.addView(this.jdField_a_of_type_AndroidWidgetImageView);
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
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 8001)) {}
    while (this.jdField_a_of_type_Alrv != null) {
      return;
    }
    this.jdField_a_of_type_Alrv = new alrv(getActivity(), false, true);
    this.jdField_a_of_type_Alrv.a(getActivity());
    this.jdField_a_of_type_Alrv.a(new wcr(this));
    this.jdField_a_of_type_Alrv.a(new wcs(this));
    this.jdField_a_of_type_Alrv.a(new wct(this));
  }
  
  private void l()
  {
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839705);
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130839699);
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void m()
  {
    if (a() != null)
    {
      long l = a().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l != 0L) {
        wye.a("subscribe_open_h5_page_time", wye.a(0L, System.currentTimeMillis() - l));
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
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 7000) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 8001)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject1).gravity = 80;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(getActivity());
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(a(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new wcv(this));
      Object localObject2 = new vxn();
      ((vxn)localObject2).jdField_a_of_type_Boolean = false;
      ((vxn)localObject2).jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(a((vxn)localObject2));
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_Bbcj.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
      localObject1 = new ViewStub(a());
      localObject2 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject2).gravity = 80;
      ((ViewStub)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_Bbcj.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1);
      this.jdField_a_of_type_Bbcj.c.setPadding(0, 0, 0, ImmersiveUtils.a(50.0F));
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
    if (badq.g(getActivity())) {
      getWebView().getSettings().setCacheMode(2);
    }
    if ((this.jdField_a_of_type_Bbcj != null) && (this.jdField_a_of_type_Bbcj.jdField_a_of_type_Bbpa != null)) {
      this.jdField_a_of_type_Bbcj.jdField_a_of_type_Bbpa.a(false);
    }
    switch (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    default: 
      if ((awnu.b()) && (Build.VERSION.SDK_INT >= 23))
      {
        if (this.d != null) {
          this.d.setBackgroundColor(-1);
        }
        this.jdField_a_of_type_Int = (getActivity().getWindow().getDecorView().getSystemUiVisibility() | 0x400 | 0x2000);
        getActivity().getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8002) {
        this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      break;
    }
    for (;;)
    {
      n();
      i();
      k();
      return i;
      l();
      j();
      break;
      if ((getActivity().getIntent() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8002))
      {
        this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      paramBundle = new vxn();
      paramBundle.jdField_a_of_type_Boolean = true;
      paramBundle.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(a(paramBundle));
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (vvy.c(paramStFeed.type.get()))
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
      vvy.a(getActivity(), paramStFeed);
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
      if (!baip.a(paramString5)) {
        break label108;
      }
    }
    label108:
    for (int i = 0;; i = Integer.parseInt(paramString5))
    {
      paramString2.set(i);
      wye.a(paramString1, "auth_person", "exp", 0, 0, new String[0]);
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
  
  public void a(vxn paramvxn)
  {
    vxn localvxn = paramvxn;
    if (paramvxn == null) {
      localvxn = new vxn();
    }
    if (this.jdField_a_of_type_Wfz != null)
    {
      a(localvxn.jdField_a_of_type_Int);
      localvxn.jdField_a_of_type_JavaLangString = b();
      localvxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      localvxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
      localvxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      this.jdField_a_of_type_Wfz.a(localvxn, this.jdField_a_of_type_Alrv);
    }
  }
  
  public void ac_()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    if (a() != null) {
      a().sendBroadcast(localIntent);
    }
  }
  
  public int c(Bundle paramBundle)
  {
    this.jdField_a_of_type_Bbcj.jdField_a_of_type_Bbcm.B = false;
    this.jdField_a_of_type_Bbcj.jdField_a_of_type_Bbcm.f = true;
    this.jdField_a_of_type_Wfz = new wfz(a());
    m();
    return super.c(paramBundle);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
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
      wye.a(this.f, str, "clk_return", 0, 0, new String[] { "", "" });
      super.f();
      return;
      str = "auth_image";
      continue;
      str = "auth_video";
      continue;
      str = "auth_person";
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
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.c();
    }
    if (this.jdField_a_of_type_Wfz != null) {
      this.jdField_a_of_type_Wfz.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment
 * JD-Core Version:    0.7.0.1
 */