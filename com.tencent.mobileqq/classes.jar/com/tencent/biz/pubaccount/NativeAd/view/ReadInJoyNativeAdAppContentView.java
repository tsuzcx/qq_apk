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
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyNativeAdAppVideoView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtWebViewBuilder jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
  
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
  
  private Activity a()
  {
    if ((getContext() instanceof Activity)) {
      return (Activity)getContext();
    }
    return null;
  }
  
  private Intent a()
  {
    if (a() == null) {
      return null;
    }
    return a().getIntent();
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(paramContext, 2131560053, this);
    d();
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)findViewById(2131362826));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = new ReadInJoyNativeAdAppContentView.1(this, paramContext, a(), a(), localAppInterface);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new WebViewDirector(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder).a(null, localAppInterface, a());
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView = ((ReadInJoyNativeAdAppVideoView)findViewById(2131362825));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.getLayoutParams();
    localLayoutParams.height = ((int)(getResources().getDisplayMetrics().widthPixels * 0.5626F));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setLayoutParams(localLayoutParams);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if (localObject != null) {
      ((ReadInJoyNativeAdAppVideoView)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).c();
    }
  }
  
  public void b()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.b();
    }
  }
  
  public void c()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.b(getContext());
    }
  }
  
  public void setData(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, QQAppInterface paramQQAppInterface)
  {
    NativeAdVideoSetting localNativeAdVideoSetting = new NativeAdVideoSetting();
    localNativeAdVideoSetting.a = true;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setAdSetting(localNativeAdVideoSetting);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setVideoData(paramAdModuleVideo, paramAdvertisementInfo, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a(this.jdField_a_of_type_AndroidContentContext);
    if (paramAdModuleVideo.d == 0)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramAdModuleVideo.f);
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramAdModuleVideo.a.d);
  }
  
  public void setVideoPlayPositon(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setVideoPlayPositon(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppContentView
 * JD-Core Version:    0.7.0.1
 */