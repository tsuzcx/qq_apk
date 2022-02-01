package com.tencent.biz.pubaccount.ecshopassit;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.net.URLDecoder;

public class BusinessBrowser$BusinessBrowserFragment
  extends WebViewFragment
  implements Animation.AnimationListener
{
  TextView a;
  TextView b;
  ImageView c;
  View d;
  RelativeLayout e;
  String f;
  String g;
  boolean h;
  boolean i = false;
  View j;
  View k;
  int l = -1;
  String m;
  int n = 0;
  boolean o = true;
  Animation p;
  Animation q;
  int r;
  IPublicAccountObserver s;
  BroadcastReceiver t = new BusinessBrowser.BusinessBrowserFragment.4(this);
  
  void a()
  {
    Intent localIntent = new Intent("action_follow_status");
    localIntent.putExtra("puin", this.f);
    super.getActivity().sendBroadcast(localIntent);
  }
  
  protected void a(Bundle paramBundle)
  {
    if (!this.i) {
      return;
    }
    this.e = ((RelativeLayout)super.getActivity().findViewById(2131450099));
    this.j = super.getActivity().findViewById(2131450088);
    if ((this.e != null) && (this.j != null))
    {
      this.d = View.inflate(super.getActivity(), 2131628314, null);
      this.k = this.d.findViewById(2131437976);
      if (this.k != null) {
        if (ThemeUtil.isInNightMode(getAppRuntime())) {
          this.k.setVisibility(0);
        } else {
          this.k.setVisibility(8);
        }
      }
      this.d.setOnClickListener(this);
      ((SingleLineTextView)this.d.findViewById(2131439121)).setText(String.valueOf(this.g));
      this.c = ((ImageView)this.d.findViewById(2131435219));
      this.a = ((TextView)this.d.findViewById(2131433513));
      this.a.setOnClickListener(this);
      this.b = ((TextView)this.d.findViewById(2131437622));
      paramBundle = new RelativeLayout.LayoutParams(-1, AIOUtils.b(44.0F, super.getResources()));
      paramBundle.addRule(10);
      this.e.addView(this.d, paramBundle);
      a(this.j, this.r);
      this.webView.setOnScrollChangedListener(new BusinessBrowser.BusinessBrowserFragment.3(this));
      paramBundle = new Intent("action_get_PA_head");
      paramBundle.putExtra("uin", this.f);
      super.getActivity().sendBroadcast(paramBundle);
      a();
    }
  }
  
  void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.l = this.intent.getIntExtra("jump_from", -1);
    this.m = this.intent.getStringExtra("msg_id");
    this.r = AIOUtils.b(44.0F, super.getResources());
    localObject = Uri.parse(super.getUrlFromIntent());
    if (((Uri)localObject).isHierarchical())
    {
      this.f = ((Uri)localObject).getQueryParameter("shopPuin");
      this.i = (TextUtils.isEmpty(this.f) ^ true);
      this.g = ((Uri)localObject).getQueryParameter("shopNick");
      localObject = this.g;
      if (localObject == null) {}
    }
    try
    {
      this.g = URLDecoder.decode((String)localObject, "UTF-8");
    }
    catch (Exception localException1)
    {
      try
      {
        BaseApplicationImpl.getApplication().registerReceiver(this.t, (IntentFilter)localObject);
        this.p = new TranslateAnimation(0.0F, 0.0F, -this.r, 0.0F);
        this.p.setDuration(100L);
        this.p.setAnimationListener(this);
        this.q = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.r);
        this.q.setDuration(100L);
        this.q.setAnimationListener(this);
        this.s = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
        this.s.setOnCallback(new BusinessBrowser.BusinessBrowserFragment.1(this));
        return super.doOnCreate(paramBundle);
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label225;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msg_id:");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(",p_uin:");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(",nick:");
      ((StringBuilder)localObject).append(this.g);
      QLog.i("WebLog_WebViewFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.i)
    {
      localObject = new IntentFilter("action_decode_finish");
      ((IntentFilter)localObject).addAction("action_follow_status_finish");
    }
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new BusinessBrowser.BusinessBrowserFragment.2(this, this.webViewSurface);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.p)
    {
      paramAnimation = this.d;
      if (paramAnimation != null) {
        paramAnimation.setVisibility(0);
      }
      a(this.j, this.r);
      return;
    }
    if (paramAnimation == this.q)
    {
      paramAnimation = this.d;
      if (paramAnimation != null) {
        paramAnimation.setVisibility(4);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i1 = paramView.getId();
    Object localObject;
    if (i1 == 2131433513)
    {
      localObject = (EcshopReportHandler)((AppInterface)getAppRuntime()).getBusinessHandler(BrowserAppInterface.m);
      if (localObject != null)
      {
        i1 = this.l;
        if (i1 == 1) {
          ((EcshopReportHandler)localObject).a(134249256, this.f, this.m, null, null, 0L, false);
        } else if (i1 == 2) {
          ((EcshopReportHandler)localObject).a(134249251, this.f, null, null, null, 0L, false);
        }
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)getAppRuntime(), super.getActivity(), this.f, this.s);
    }
    else if (i1 == 2131430424)
    {
      i1 = this.l;
      if (i1 == 1) {
        i1 = 134249257;
      } else if (i1 == 2) {
        i1 = 134249252;
      } else {
        i1 = -1;
      }
      localObject = new ActivityURIRequest(super.getActivity(), "/pubaccount/detail");
      ((ActivityURIRequest)localObject).extra().putString("uin", this.f);
      ((ActivityURIRequest)localObject).extra().putString("report_src_param_type", "");
      ((ActivityURIRequest)localObject).extra().putString("report_src_param_name", "");
      if (i1 != -1) {
        ((ActivityURIRequest)localObject).extra().putInt("report_business_tvalue", i1);
      }
      if (this.m != null) {
        ((ActivityURIRequest)localObject).extra().putString("strp1", this.m);
      }
      ((ActivityURIRequest)localObject).setFlags(67108864);
      QRoute.startUri((URIRequest)localObject, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.s = null;
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.t);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment
 * JD-Core Version:    0.7.0.1
 */