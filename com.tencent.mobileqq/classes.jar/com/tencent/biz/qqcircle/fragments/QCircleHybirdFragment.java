package com.tencent.biz.qqcircle.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import anxn;
import bdee;
import beey;
import befb;
import besa;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import tra;
import twg;
import yjq;
import yvu;

public class QCircleHybirdFragment
  extends WebViewFragment
{
  private static final String jdField_a_of_type_JavaLangString = QCircleHybirdFragment.class.getSimpleName();
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected anxn a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private CommentBottomBar jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private twg jdField_a_of_type_Twg;
  private yjq jdField_a_of_type_Yjq;
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = new StatusView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
    this.jdField_a_of_type_Beey.c.addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
  }
  
  private void j()
  {
    if (a() != null)
    {
      long l = a().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l != 0L) {
        yvu.a("subscribe_open_h5_page_time", yvu.a(0L, System.currentTimeMillis() - l));
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
    if (bdee.g(getActivity())) {
      getWebView().getSettings().setCacheMode(2);
    }
    if ((this.jdField_a_of_type_Beey != null) && (this.jdField_a_of_type_Beey.jdField_a_of_type_Besa != null)) {
      this.jdField_a_of_type_Beey.jdField_a_of_type_Besa.a(false);
    }
    if (!this.jdField_a_of_type_Befb.m) {
      tra.a(getActivity());
    }
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Twg = new twg(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_update_web_user_follow_state");
      paramBundle.addAction("action_update_web_tag_follow_state");
      getActivity().registerReceiver(this.jdField_a_of_type_Twg, paramBundle);
    }
    i();
    return i;
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_clear_message_red_poiont");
    localIntent.putExtra("createTime", paramInt);
    if (a() != null) {
      a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_auth_info");
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("status", paramInt2);
    localIntent.putExtra("tagName", paramString);
    if (a() != null) {
      a().sendBroadcast(localIntent);
    }
  }
  
  public void a(WebView paramWebView, int paramInt)
  {
    super.a(paramWebView, paramInt);
    if ((paramInt > 25) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (a() != null) {
      a().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_user_follow_state");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("type", paramInt);
    if (a() != null) {
      a().sendBroadcast(localIntent);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    paramString = new Intent();
    paramString.setAction("action_update_native_tag_follow_state");
    if (a() != null) {
      a().sendBroadcast(paramString);
    }
  }
  
  public int c(Bundle paramBundle)
  {
    this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.D = false;
    this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.f = true;
    this.jdField_a_of_type_Beey.b = tra.b(false);
    this.jdField_a_of_type_Yjq = new yjq(a());
    j();
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
      yvu.a(this.e, str, "clk_return", 0, 0, new String[] { "", "" });
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
    if (this.jdField_a_of_type_Anxn != null) {
      this.jdField_a_of_type_Anxn.c();
    }
    if (this.jdField_a_of_type_Yjq != null) {
      this.jdField_a_of_type_Yjq.b();
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_Twg != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Twg);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Anxn != null) {
      this.jdField_a_of_type_Anxn.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Anxn != null) {
      this.jdField_a_of_type_Anxn.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleHybirdFragment
 * JD-Core Version:    0.7.0.1
 */