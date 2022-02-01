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
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CertifiedAccountMeta.StShare jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private CommentBottomBar jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
  private SubscribeHybirdFragment.SubscribeHybirdBroadcastReceiver jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$SubscribeHybirdBroadcastReceiver;
  private GestureToLaunchPageHelper jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private SubscribeShareHelper jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper;
  protected IColorNoteController a;
  
  private View.OnClickListener a(ShareInfoBean paramShareInfoBean)
  {
    return new SubscribeHybirdFragment.5(this, paramShareInfoBean);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if ((localObject != null) && (!StringUtil.a(((CertifiedAccountMeta.StFeed)localObject).poster.id.get())))
    {
      localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exp_");
      localStringBuilder.append(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo));
      VSReporter.a((String)localObject, "auth_share", localStringBuilder.toString(), paramInt, 0, new String[0]);
    }
  }
  
  private void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, long paramLong, String paramString)
  {
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if (a(paramLong, paramString)) {
      return;
    }
    if (a(localStFeed)) {
      return;
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = ((CertifiedAccountMeta.StShare)paramStGetFeedDetailRsp.share.get());
    b(localStFeed);
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8001)
    {
      WebSoService.a().a();
      VSReporter.a(getUin(), "auth_image", "exp", 0, 0, new String[] { "", "", localStFeed.poster.nick.get(), localStFeed.title.get() });
    }
    if (!StringUtil.a(paramStGetFeedDetailRsp.detailUrl.get()))
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
      StatusView localStatusView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
      if (localStatusView != null) {
        localStatusView.a(paramString);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (!SubscribeUtils.a(paramStFeed.status.get()))
    {
      if (SubscribeUtils.a(paramStFeed.poster.attr.get()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getQBaseActivity()).inflate(2131558777, null, false);
          this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, ImmersiveUtils.dpToPx(44.0F)));
          getUIStyleHandler().c.addView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return false;
      }
      paramStFeed = this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
      if ((paramStFeed != null) && (paramStFeed.getVisibility() == 8))
      {
        paramStFeed = this.jdField_a_of_type_AndroidViewView;
        if ((paramStFeed != null) && (paramStFeed.getVisibility() == 0)) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(null);
      }
      return true;
    }
    paramStFeed = this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
    if (paramStFeed != null) {
      paramStFeed.c();
    }
    paramStFeed = this.jdField_a_of_type_AndroidViewView;
    if ((paramStFeed != null) && (paramStFeed.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    return false;
  }
  
  private void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if (localObject != null) {
      ((CommentBottomBar)localObject).setCurrentFeed(paramStFeed);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper;
    if (localObject != null) {
      ((GestureToLaunchPageHelper)localObject).a(paramStFeed.poster);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = new StatusView(getQBaseActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
    getUIStyleHandler().c.addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
  }
  
  private void d()
  {
    String str = SubscribeUtils.a();
    if (new File(str).exists())
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getQBaseActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      try
      {
        ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
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
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      if ((getUIStyleHandler() != null) && (getUIStyleHandler().c != null)) {
        getUIStyleHandler().c.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      }
    }
  }
  
  private void e()
  {
    ExtraTypeInfo localExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
    if ((localExtraTypeInfo != null) && (localExtraTypeInfo.pageType != 8001)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(getQBaseActivity(), false, true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(getQBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(new SubscribeHybirdFragment.2(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new SubscribeHybirdFragment.3(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteCurdListener(new SubscribeHybirdFragment.4(this));
  }
  
  private void f()
  {
    getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
    getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840348);
    getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840342);
    getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void g()
  {
    if (getIntent() != null)
    {
      long l = getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l != 0L) {
        VSReporter.a("subscribe_open_h5_page_time", VSReporter.a(0L, System.currentTimeMillis() - l));
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
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 7000) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 8001)) {
      return;
    }
    Object localObject1 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(getQBaseActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(getHostActivity(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new SubscribeHybirdFragment.6(this));
    Object localObject2 = new ShareInfoBean();
    ((ShareInfoBean)localObject2).jdField_a_of_type_Boolean = false;
    ((ShareInfoBean)localObject2).jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(a((ShareInfoBean)localObject2));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    getUIStyleHandler().jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    localObject1 = new ViewStub(getHostActivity());
    localObject2 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject2).gravity = 80;
    ((ViewStub)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    getUIStyleHandler().jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1);
    getUIStyleHandler().c.setPadding(0, 0, 0, ImmersiveUtils.dpToPx(50.0F));
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().b((ViewStub)localObject1);
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
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(paramStFeed);
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
    if ((getUIStyleHandler() != null) && (getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null)) {
      getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(false);
    }
    switch (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    default: 
      break;
    case 8001: 
      f();
      d();
      break;
    case 8000: 
    case 8002: 
      if ((getQBaseActivity().getIntent() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8002)) {
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      break;
    }
    if ((SimpleUIUtil.a()) && (Build.VERSION.SDK_INT >= 23))
    {
      if (getWebTitleBarInterface().a() != null) {
        getWebTitleBarInterface().a().setBackgroundColor(-1);
      }
      this.jdField_a_of_type_Int = (getQBaseActivity().getWindow().getDecorView().getSystemUiVisibility() | 0x400 | 0x2000);
      getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8002)
    {
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    else
    {
      paramBundle = new ShareInfoBean();
      paramBundle.jdField_a_of_type_Boolean = true;
      paramBundle.jdField_a_of_type_Int = 1;
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(a(paramBundle));
    }
    h();
    c();
    e();
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8001) {
      this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper = new GestureToLaunchPageHelper(getQBaseActivity());
    }
    if (getQBaseActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$SubscribeHybirdBroadcastReceiver = new SubscribeHybirdFragment.SubscribeHybirdBroadcastReceiver(this, null);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_update_follow_state");
      paramBundle.addAction("action_get_lbs_location");
      getQBaseActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$SubscribeHybirdBroadcastReceiver, paramBundle);
    }
  }
  
  protected void a(ShareInfoBean paramShareInfoBean)
  {
    ShareInfoBean localShareInfoBean = paramShareInfoBean;
    if (paramShareInfoBean == null) {
      localShareInfoBean = new ShareInfoBean();
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper != null)
    {
      a(localShareInfoBean.jdField_a_of_type_Int);
      localShareInfoBean.jdField_a_of_type_JavaLangString = getCurrentUrl();
      localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
      localShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper.a(localShareInfoBean, this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    CertifiedAccountMeta.StFeed localStFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if (localStFeed != null)
    {
      localStFeed.poster.id.set(paramString1);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.set(paramString2);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.set(paramString3);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.desc.set(paramString4);
      paramString2 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type;
      int i;
      if (StringUtil.a(paramString5)) {
        i = 0;
      } else {
        i = Integer.parseInt(paramString5);
      }
      paramString2.set(i);
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
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if ((localObject != null) && (((CommentBottomBar)localObject).b())) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
    if (localObject != null)
    {
      int i = ((ExtraTypeInfo)localObject).pageType;
      if (i != 7000)
      {
        if (i != 7002)
        {
          if (i != 8001) {
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
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if (localObject != null) {
      ((CommentBottomBar)localObject).c();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject != null) {
      ((IColorNoteController)localObject).onDestroy();
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper;
    if (localObject != null) {
      ((SubscribeShareHelper)localObject).a();
    }
    if ((getQBaseActivity() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$SubscribeHybirdBroadcastReceiver != null)) {
      getQBaseActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$SubscribeHybirdBroadcastReceiver);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment
 * JD-Core Version:    0.7.0.1
 */