package com.tencent.gdtad.views.videoceiling;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.VideoFullScreenListener;
import com.tencent.mobileqq.webview.WebViewDirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qni;
import qnj;

public class GdtVideoCeilingView
  extends FrameLayout
  implements GdtVideoCommonView.VideoFullScreenListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private GdtVideoCeilingData jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData;
  private GdtWebViewBuilder jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
  
  public GdtVideoCeilingView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public GdtVideoCeilingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public GdtVideoCeilingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
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
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView == null) {
      return;
    }
    paramInt1 = (int)(paramInt1 * 0.5625D);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
    localLayoutParams.height = paramInt1;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams(localLayoutParams);
  }
  
  private void d()
  {
    e();
  }
  
  private void e()
  {
    inflate(getContext(), 2130969007, this);
    f();
    g();
    j();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = ((GdtVideoCommonView)findViewById(2131364684));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setOnVideoFullScreen(this);
  }
  
  private void g()
  {
    findViewById(2131364686).setOnClickListener(new qni(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363378));
  }
  
  private void j()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131364690);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(getContext());
    localFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = new qnj(this, getContext(), a(), a(), localAppInterface);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new WebViewDirector(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder).a(null, localAppInterface, a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.h();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.d();
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeAllViewsInLayout();
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a(paramBundle);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a())
    {
      h();
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()))
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      return true;
    }
    if (a() != null)
    {
      a().finish();
      a().overridePendingTransition(17432576, 17432577);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.f();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.e();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.c();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(false, 0);
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a())) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(true, 0);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public void setData(GdtVideoCeilingData paramGdtVideoCeilingData)
  {
    if ((paramGdtVideoCeilingData == null) || (!paramGdtVideoCeilingData.isValid()) || (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView == null) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData = paramGdtVideoCeilingData;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setData(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getVideoData(), null);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getWebUrl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView
 * JD-Core Version:    0.7.0.1
 */