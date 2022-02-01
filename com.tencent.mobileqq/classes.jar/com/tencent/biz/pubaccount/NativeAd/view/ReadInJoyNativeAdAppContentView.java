package com.tencent.biz.pubaccount.NativeAd.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.NativeAd.data.NativeAdVideoSetting;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo.AdAppInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.WebViewDirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReadInJoyNativeAdAppContentView
  extends FrameLayout
{
  private ReadInJoyNativeAdAppVideoView a;
  private TouchWebView b;
  private GdtWebViewBuilder c;
  private Context d;
  
  public ReadInJoyNativeAdAppContentView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoyNativeAdAppContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoyNativeAdAppContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = paramContext;
    inflate(paramContext, 2131626098, this);
    d();
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.b = ((TouchWebView)findViewById(2131428513));
    this.c = new ReadInJoyNativeAdAppContentView.1(this, paramContext, getActivity(), getIntent(), localAppInterface);
    this.c.a(this.b);
    new WebViewDirector(this.c).a(null, localAppInterface, getIntent());
  }
  
  private void d()
  {
    this.a = ((ReadInJoyNativeAdAppVideoView)findViewById(2131428512));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.height = ((int)(getResources().getDisplayMetrics().widthPixels * 0.5626F));
    this.a.setLayoutParams(localLayoutParams);
  }
  
  private Activity getActivity()
  {
    if ((getContext() instanceof Activity)) {
      return (Activity)getContext();
    }
    return null;
  }
  
  private Intent getIntent()
  {
    if (getActivity() == null) {
      return null;
    }
    return getActivity().getIntent();
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ReadInJoyNativeAdAppVideoView)localObject).a();
    }
    localObject = this.c;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).c();
    }
  }
  
  public void b()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.a;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.b();
    }
  }
  
  public void c()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.a;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.b(getContext());
    }
  }
  
  public void setData(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, QQAppInterface paramQQAppInterface)
  {
    NativeAdVideoSetting localNativeAdVideoSetting = new NativeAdVideoSetting();
    localNativeAdVideoSetting.a = true;
    this.a.setAdSetting(localNativeAdVideoSetting);
    this.a.setVideoData(paramAdModuleVideo, paramAdvertisementInfo, paramQQAppInterface);
    this.a.a(this.d);
    if (paramAdModuleVideo.s == 0)
    {
      this.b.loadUrl(paramAdModuleVideo.t);
      return;
    }
    this.b.loadUrl(paramAdModuleVideo.u.d);
  }
  
  public void setVideoPlayPositon(long paramLong)
  {
    this.a.setVideoPlayPositon(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppContentView
 * JD-Core Version:    0.7.0.1
 */