package com.tencent.biz.pubaccount.NativeAd.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import bcbu;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nlb;
import nlq;
import nlr;
import nml;
import zbr;

public class ReadInJoyNativeAdAppContentView
  extends FrameLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyNativeAdAppVideoView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private zbr jdField_a_of_type_Zbr;
  
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
    inflate(paramContext, 2131559786, this);
    d();
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)findViewById(2131362658));
    this.jdField_a_of_type_Zbr = new nml(this, paramContext, a(), a(), localAppInterface);
    this.jdField_a_of_type_Zbr.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new bcbu(this.jdField_a_of_type_Zbr).a(null, localAppInterface, a());
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView = ((ReadInJoyNativeAdAppVideoView)findViewById(2131362657));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.getLayoutParams();
    localLayoutParams.height = ((int)(getResources().getDisplayMetrics().widthPixels * 0.5626F));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setLayoutParams(localLayoutParams);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a();
    }
    if (this.jdField_a_of_type_Zbr != null) {
      this.jdField_a_of_type_Zbr.c();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.b(getContext());
    }
  }
  
  public void setData(nlq paramnlq, AdvertisementInfo paramAdvertisementInfo, QQAppInterface paramQQAppInterface)
  {
    nlb localnlb = new nlb();
    localnlb.a = true;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setAdSetting(localnlb);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setVideoData(paramnlq, paramAdvertisementInfo, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a(this.jdField_a_of_type_AndroidContentContext);
    if (paramnlq.d == 0)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramnlq.f);
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramnlq.a.d);
  }
  
  public void setVideoPlayPositon(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setVideoPlayPositon(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppContentView
 * JD-Core Version:    0.7.0.1
 */