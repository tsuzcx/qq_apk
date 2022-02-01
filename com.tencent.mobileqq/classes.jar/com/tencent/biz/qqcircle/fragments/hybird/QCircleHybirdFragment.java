package com.tencent.biz.qqcircle.fragments.hybird;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import aakz;
import aaxb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import aqcb;
import bgnt;
import bhql;
import bhqo;
import bidh;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import uxc;
import uxx;
import vlu;

public class QCircleHybirdFragment
  extends WebViewFragment
{
  private static final String jdField_a_of_type_JavaLangString = QCircleHybirdFragment.class.getSimpleName();
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private aakz jdField_a_of_type_Aakz;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected aqcb a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private CommentBottomBar jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private vlu jdField_a_of_type_Vlu;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = new StatusView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
    this.mUIStyleHandler.c.addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
  }
  
  private void b()
  {
    if (((this.mUIStyle.a & 0x80000) == 0L) || (getWebView().getX5WebViewExtension() != null)) {}
    for (;;)
    {
      try
      {
        getWebView().getView().setBackgroundColor(0);
        getWebView().setBackgroundColor(0);
        if (this.contentView != null) {
          this.contentView.setBackgroundColor(0);
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      getWebView().setBackgroundColor(0);
    }
  }
  
  private void c()
  {
    if (getIntent() != null)
    {
      long l = getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l != 0L) {
        aaxb.a("subscribe_open_h5_page_time", aaxb.a(0L, System.currentTimeMillis() - l));
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo();
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(this.intent.getByteArrayExtra("bundle_key_subscribe_feed_bytes_array")));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_clear_message_red_poiont");
    localIntent.putExtra("createTime", paramInt);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_auth_info");
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("status", paramInt2);
    localIntent.putExtra("tagName", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new Intent();
    paramString.setAction("action_update_native_tag_follow_state");
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(paramString);
    }
    a(uxc.a());
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_user_follow_state");
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("nick", paramString2);
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("isDoubly", paramInt2);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void b(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_refresh_feed_list");
    localIntent.putExtra("pageType", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    getWebView().getSettings().setDefaultTextEncodingName("utf-8");
    getWebView().getSettings().setUserAgentString(getWebView().getSettings().getUserAgentString() + " QQ_APP_Subscribe");
    if (bgnt.g(getActivity())) {
      getWebView().getSettings().setCacheMode(2);
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.jdField_a_of_type_Bidh != null)) {
      this.mUIStyleHandler.jdField_a_of_type_Bidh.a(false);
    }
    if (!this.mUIStyle.m) {
      uxx.a(getActivity());
    }
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Vlu = new vlu(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_update_web_user_follow_state");
      paramBundle.addAction("action_update_web_tag_follow_state");
      getActivity().registerReceiver(this.jdField_a_of_type_Vlu, paramBundle);
    }
    a();
    return i;
  }
  
  public int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    this.mUIStyleHandler.jdField_a_of_type_Bhqo.D = false;
    this.mUIStyleHandler.jdField_a_of_type_Bhqo.f = true;
    this.mUIStyleHandler.b = uxx.b(false);
    this.jdField_a_of_type_Aakz = new aakz(getHostActivity());
    c();
    return super.doCreateLoopStep_InitData(paramBundle);
  }
  
  @TargetApi(11)
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    b();
    return super.doCreateLoopStep_InitUIContent(paramBundle);
  }
  
  public void doOnBackEvent()
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
      aaxb.a(this.uin, str, "clk_return", 0, 0, new String[] { "", "" });
      super.doOnBackEvent();
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
    if (this.jdField_a_of_type_Aqcb != null) {
      this.jdField_a_of_type_Aqcb.c();
    }
    if (this.jdField_a_of_type_Aakz != null) {
      this.jdField_a_of_type_Aakz.a();
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_Vlu != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Vlu);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aqcb != null) {
      this.jdField_a_of_type_Aqcb.b();
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if ((paramInt > 25) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aqcb != null) {
      this.jdField_a_of_type_Aqcb.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.hybird.QCircleHybirdFragment
 * JD-Core Version:    0.7.0.1
 */