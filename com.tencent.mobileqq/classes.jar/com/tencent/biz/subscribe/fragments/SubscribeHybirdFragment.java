package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.comment.CommentPresenter;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.utils.GestureToLaunchPageHelper;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;

public class SubscribeHybirdFragment
  extends WebViewFragment
{
  protected IColorNoteController a;
  private CommentBottomBar b;
  private CertifiedAccountMeta.StFeed c;
  private ExtraTypeInfo d;
  private ImageView e;
  private SubscribeShareHelper f;
  private CertifiedAccountMeta.StShare g;
  private int h;
  private StatusView i;
  private View j;
  private GestureToLaunchPageHelper k;
  private SubscribeHybirdFragment.SubscribeHybirdBroadcastReceiver l;
  
  private void a(int paramInt)
  {
    Object localObject = this.c;
    if ((localObject != null) && (!StringUtil.isEmpty(((CertifiedAccountMeta.StFeed)localObject).poster.id.get())))
    {
      localObject = this.c.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exp_");
      localStringBuilder.append(SubscribeShareHelper.a(this.d));
      VSReporter.a((String)localObject, "auth_share", localStringBuilder.toString(), paramInt, 0, new String[0]);
    }
  }
  
  private void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, long paramLong, String paramString)
  {
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if (a(paramLong, paramString)) {
      return;
    }
    if (b(localStFeed)) {
      return;
    }
    this.g = ((CertifiedAccountMeta.StShare)paramStGetFeedDetailRsp.share.get());
    c(localStFeed);
    if (this.d.pageType == 8001)
    {
      WebSoService.a().b();
      VSReporter.a(getUin(), "auth_image", "exp", 0, 0, new String[] { "", "", localStFeed.poster.nick.get(), localStFeed.title.get() });
    }
    if (!StringUtil.isEmpty(paramStGetFeedDetailRsp.detailUrl.get()))
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
    if (paramContext != null)
    {
      if (paramFollowUpdateEvent == null) {
        return;
      }
      Intent localIntent = new Intent("action_update_follow_state");
      localIntent.putExtra("uin", paramFollowUpdateEvent.useId);
      localIntent.putExtra("followState", paramFollowUpdateEvent.followStatus);
      paramContext.sendBroadcast(localIntent);
    }
  }
  
  private boolean a(long paramLong, String paramString)
  {
    if (paramLong != 0L)
    {
      StatusView localStatusView = this.i;
      if (localStatusView != null) {
        localStatusView.a(paramString);
      }
      return true;
    }
    return false;
  }
  
  private View.OnClickListener b(ShareInfoBean paramShareInfoBean)
  {
    return new SubscribeHybirdFragment.5(this, paramShareInfoBean);
  }
  
  private boolean b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (!SubscribeUtils.a(paramStFeed.status.get()))
    {
      if (SubscribeUtils.a(paramStFeed.poster.attr.get()))
      {
        if (this.j == null)
        {
          this.j = LayoutInflater.from(getQBaseActivity()).inflate(2131624397, null, false);
          this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, ImmersiveUtils.dpToPx(44.0F)));
          getUIStyleHandler().u.addView(this.j);
        }
        this.j.setVisibility(0);
        return false;
      }
      paramStFeed = this.i;
      if ((paramStFeed != null) && (paramStFeed.getVisibility() == 8))
      {
        paramStFeed = this.j;
        if ((paramStFeed != null) && (paramStFeed.getVisibility() == 0)) {
          this.j.setVisibility(8);
        }
        this.i.a(null);
      }
      return true;
    }
    paramStFeed = this.i;
    if (paramStFeed != null) {
      paramStFeed.b();
    }
    paramStFeed = this.j;
    if ((paramStFeed != null) && (paramStFeed.getVisibility() == 0)) {
      this.j.setVisibility(8);
    }
    return false;
  }
  
  private void c()
  {
    this.i = new StatusView(getQBaseActivity());
    this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.i.setVisibility(8);
    getUIStyleHandler().u.addView(this.i);
  }
  
  private void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.c = paramStFeed;
    Object localObject = this.b;
    if (localObject != null) {
      ((CommentBottomBar)localObject).setCurrentFeed(paramStFeed);
    }
    localObject = this.k;
    if (localObject != null) {
      ((GestureToLaunchPageHelper)localObject).a(paramStFeed.poster);
    }
  }
  
  private void d()
  {
    String str = SubscribeUtils.b();
    if (new File(str).exists())
    {
      this.e = new ImageView(getQBaseActivity());
      this.e.setBackgroundColor(-1);
      this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
      try
      {
        ImageView localImageView = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/certified_account_preload_pic.png");
        localImageView.setImageURI(Uri.fromFile(new File(localStringBuilder.toString())));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.e.setLayoutParams(localLayoutParams);
      if ((getUIStyleHandler() != null) && (getUIStyleHandler().u != null)) {
        getUIStyleHandler().u.addView(this.e);
      }
    }
  }
  
  private void e()
  {
    ExtraTypeInfo localExtraTypeInfo = this.d;
    if ((localExtraTypeInfo != null) && (localExtraTypeInfo.pageType != 8001)) {
      return;
    }
    if (this.a != null) {
      return;
    }
    this.a = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.a.init(getQBaseActivity(), false, true);
    this.a.attachToActivity(getQBaseActivity());
    this.a.setServiceInfo(new SubscribeHybirdFragment.2(this));
    this.a.setOnColorNoteAnimFinishListener(new SubscribeHybirdFragment.3(this));
    this.a.setOnColorNoteCurdListener(new SubscribeHybirdFragment.4(this));
  }
  
  private void f()
  {
    getSwiftTitleUI().o.setBackgroundColor(-1);
    getSwiftTitleUI().h.setImageResource(2130841088);
    getSwiftTitleUI().d.setBackgroundResource(2130841082);
    getSwiftTitleUI().h.setVisibility(0);
  }
  
  private void g()
  {
    if (getIntent() != null)
    {
      long l1 = getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l1 != 0L) {
        VSReporter.a("subscribe_open_h5_page_time", VSReporter.a(0L, System.currentTimeMillis() - l1));
      }
      this.d = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    }
    if (this.d == null) {
      this.d = new ExtraTypeInfo();
    }
    this.c = new CertifiedAccountMeta.StFeed();
    try
    {
      this.c = ((CertifiedAccountMeta.StFeed)this.c.mergeFrom(this.intent.getByteArrayExtra("bundle_key_subscribe_feed_bytes_array")));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void h()
  {
    if ((this.d.pageType != 7000) && (this.d.pageType != 8001)) {
      return;
    }
    Object localObject1 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    this.b = new CommentBottomBar(getQBaseActivity());
    this.b.a(getHostActivity(), this.c, new SubscribeHybirdFragment.6(this));
    Object localObject2 = new ShareInfoBean();
    ((ShareInfoBean)localObject2).f = false;
    ((ShareInfoBean)localObject2).a = 2;
    this.b.setShareClickListener(b((ShareInfoBean)localObject2));
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    getUIStyleHandler().y.addView(this.b);
    localObject1 = new ViewStub(getHostActivity());
    localObject2 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject2).gravity = 80;
    ((ViewStub)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    getUIStyleHandler().y.addView((View)localObject1);
    getUIStyleHandler().u.setPadding(0, 0, 0, ImmersiveUtils.dpToPx(50.0F));
    if (this.b.getCommentPresenter() != null) {
      this.b.getCommentPresenter().b((ViewStub)localObject1);
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (SubscribeLaucher.c(paramStFeed.type.get()))
    {
      ImageView localImageView = this.e;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
      this.c = paramStFeed;
      this.b.a(paramStFeed);
      if (getWebView() != null) {
        getWebView().pageUp(true);
      }
    }
    else
    {
      SubscribeLaucher.a(getQBaseActivity(), paramStFeed);
      if (getQBaseActivity() != null) {
        getQBaseActivity().finish();
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (getQBaseActivity().getRequestedOrientation() != 1) {
      getQBaseActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    getWebView().getSettings().setDefaultTextEncodingName("utf-8");
    paramBundle = getWebView().getSettings();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getWebView().getSettings().getUserAgentString());
    localStringBuilder.append(" QQ_APP_Subscribe");
    paramBundle.setUserAgentString(localStringBuilder.toString());
    if (NetworkUtil.isNetworkAvailable(getQBaseActivity())) {
      getWebView().getSettings().setCacheMode(2);
    }
    if ((getUIStyleHandler() != null) && (getUIStyleHandler().w != null)) {
      getUIStyleHandler().w.a(false);
    }
    switch (this.d.pageType)
    {
    default: 
      break;
    case 8001: 
      f();
      d();
      break;
    case 8000: 
    case 8002: 
      if ((getQBaseActivity().getIntent() != null) && (this.d.pageType == 8002)) {
        getSwiftTitleUI().h.setVisibility(0);
      } else {
        getSwiftTitleUI().h.setVisibility(8);
      }
      break;
    }
    if ((SimpleUIUtil.e()) && (Build.VERSION.SDK_INT >= 23))
    {
      if (getWebTitleBarInterface().l() != null) {
        getWebTitleBarInterface().l().setBackgroundColor(-1);
      }
      this.h = (getQBaseActivity().getWindow().getDecorView().getSystemUiVisibility() | 0x400 | 0x2000);
      getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(this.h);
    }
    if (this.d.pageType == 8002)
    {
      getSwiftTitleUI().h.setOnClickListener(this);
    }
    else
    {
      paramBundle = new ShareInfoBean();
      paramBundle.f = true;
      paramBundle.a = 1;
      getSwiftTitleUI().h.setOnClickListener(b(paramBundle));
    }
    h();
    c();
    e();
    if (this.d.pageType == 8001) {
      this.k = new GestureToLaunchPageHelper(getQBaseActivity());
    }
    if (getQBaseActivity() != null)
    {
      this.l = new SubscribeHybirdFragment.SubscribeHybirdBroadcastReceiver(this, null);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_update_follow_state");
      paramBundle.addAction("action_get_lbs_location");
      getQBaseActivity().registerReceiver(this.l, paramBundle);
    }
  }
  
  protected void a(ShareInfoBean paramShareInfoBean)
  {
    ShareInfoBean localShareInfoBean = paramShareInfoBean;
    if (paramShareInfoBean == null) {
      localShareInfoBean = new ShareInfoBean();
    }
    if (this.f != null)
    {
      a(localShareInfoBean.a);
      localShareInfoBean.c = getCurrentUrl();
      localShareInfoBean.b = this.c;
      localShareInfoBean.d = this.g;
      localShareInfoBean.e = this.d;
      this.f.a(localShareInfoBean, this.a);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    CertifiedAccountMeta.StFeed localStFeed = this.c;
    if (localStFeed != null)
    {
      localStFeed.poster.id.set(paramString1);
      this.c.poster.nick.set(paramString2);
      this.c.poster.icon.set(paramString3);
      this.c.poster.desc.set(paramString4);
      paramString2 = this.c.poster.type;
      int m;
      if (StringUtil.isEmpty(paramString5)) {
        m = 0;
      } else {
        m = Integer.parseInt(paramString5);
      }
      paramString2.set(m);
      VSReporter.a(paramString1, "auth_person", "exp", 0, 0, new String[0]);
    }
  }
  
  public void a(ArrayList<CommodityBean> paramArrayList)
  {
    if (getHostActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("attach_goods", paramArrayList);
      localIntent.setAction("action_attach_goods");
      if (getHostActivity() != null) {
        getHostActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void b()
  {
    if (getHostActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_refresh_return_page");
      if (getHostActivity() != null) {
        getHostActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void doOnBackEvent()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((CommentBottomBar)localObject).e())) {
      return;
    }
    localObject = this.d;
    if (localObject != null)
    {
      int m = ((ExtraTypeInfo)localObject).pageType;
      if (m != 7000)
      {
        if (m != 7002)
        {
          if (m != 8001) {
            localObject = "";
          } else {
            localObject = "auth_image";
          }
        }
        else {
          localObject = "auth_person";
        }
      }
      else {
        localObject = "auth_video";
      }
      VSReporter.a(getUin(), (String)localObject, "clk_return", 0, 0, new String[] { "", "" });
    }
    super.doOnBackEvent();
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new SubscribeHybirdFragment.1(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.b;
    if (localObject != null) {
      ((CommentBottomBar)localObject).d();
    }
    localObject = this.e;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(null);
    }
    localObject = this.a;
    if (localObject != null) {
      ((IColorNoteController)localObject).onDestroy();
    }
    localObject = this.f;
    if (localObject != null) {
      ((SubscribeShareHelper)localObject).a();
    }
    if ((getQBaseActivity() != null) && (this.l != null)) {
      getQBaseActivity().unregisterReceiver(this.l);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    IColorNoteController localIColorNoteController = this.a;
    if (localIColorNoteController != null) {
      localIColorNoteController.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    IColorNoteController localIColorNoteController = this.a;
    if (localIColorNoteController != null) {
      localIColorNoteController.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment
 * JD-Core Version:    0.7.0.1
 */