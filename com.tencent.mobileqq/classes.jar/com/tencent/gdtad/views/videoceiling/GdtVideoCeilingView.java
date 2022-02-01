package com.tencent.gdtad.views.videoceiling;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtTraceReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.VideoFullScreenListener;
import com.tencent.mobileqq.webview.WebViewDirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GdtVideoCeilingView
  extends FrameLayout
  implements GdtVideoCommonView.VideoFullScreenListener, GdtVideoCeilingListener, GdtVideoCeilingTitleBar.OnBtnClickListener
{
  private int jdField_a_of_type_Int = 607;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private GdtVideoCeilingData jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData;
  private GdtVideoCeilingLandView jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
  private GdtVideoCeilingTitleBar jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar;
  private GdtWebViewBuilder jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
  private int b = 1920;
  private int c = 1;
  
  public GdtVideoCeilingView(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public GdtVideoCeilingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public GdtVideoCeilingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
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
    boolean bool;
    if (paramInt1 < paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLayout width ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" height ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" Portrait ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("GdtVideoCeilingView", 0, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      double d = paramInt1;
      Double.isNaN(d);
      paramInt1 = (int)(d * 0.5625D);
    }
    else
    {
      paramInt1 = paramInt2;
    }
    if (paramInt1 <= 0) {
      paramInt1 = 607;
    }
    this.jdField_a_of_type_Int = paramInt1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("videoView height ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("GdtVideoCeilingView", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramInt2 <= 0) {
      paramInt2 = 1920;
    }
    this.b = paramInt2;
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    paramInt1 = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = (this.b - paramInt1);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, GdtVideoCeilingLandView paramGdtVideoCeilingLandView, boolean paramBoolean)
  {
    if (paramGdtVideoCeilingLandView == null) {
      return;
    }
    if (paramGdtVideoCeilingLandView.jdField_a_of_type_Int == 0) {
      paramLayoutParams.height = (this.b - this.jdField_a_of_type_Int);
    } else {
      paramLayoutParams.height = this.b;
    }
    paramGdtVideoCeilingLandView.jdField_a_of_type_Boolean = false;
    paramGdtVideoCeilingLandView.setLayoutParams(paramLayoutParams);
    if (paramBoolean)
    {
      paramLayoutParams = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
      if ((paramLayoutParams != null) && (paramLayoutParams.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b();
      }
    }
    paramLayoutParams = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutParams != null) {
      paramLayoutParams.setVisibility(4);
    }
  }
  
  private void f()
  {
    g();
  }
  
  private void g()
  {
    inflate(getContext(), 2131559198, this);
    i();
    h();
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380675);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView = ((GdtVideoCeilingLandView)findViewById(2131367524));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setGdtVideoCeilingListeners(this, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = ((GdtVideoCommonView)findViewById(2131380485));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setOnVideoFullScreen(this);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar = ((GdtVideoCeilingTitleBar)findViewById(2131381070));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setOnBtnClickListener(this);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.b();
  }
  
  private void k()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131381073));
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = new GdtVideoCeilingView.1(this, getContext(), a(), a(), localAppInterface);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new WebViewDirector(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder).a(null, localAppInterface, a());
  }
  
  private void l()
  {
    GdtVideoCeilingData localGdtVideoCeilingData = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData;
    if (localGdtVideoCeilingData == null)
    {
      GdtLog.d("GdtVideoCeilingView", "doAppOpen data==null");
      return;
    }
    int i = localGdtVideoCeilingData.getStyle();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        n();
        return;
      }
      m();
      return;
    }
    GdtLog.d("GdtVideoCeilingView", "doAppOpen should not go here");
  }
  
  private void m()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_ads");
    localObject = AdAppUtil.launch(getContext(), this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd().getAppPackageName(), (Bundle)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOpenMain result ");
    boolean bool;
    if (localObject != null) {
      bool = ((AdError)localObject).isSuccess();
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    GdtLog.a("GdtVideoCeilingView", localStringBuilder.toString());
  }
  
  private void n()
  {
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("big_brother_source_key", "biz_src_ads");
    AdAppDeeplinkLauncher.Params localParams = new AdAppDeeplinkLauncher.Params();
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData;
    if ((localObject1 != null) && (((GdtVideoCeilingData)localObject1).getAd() != null)) {
      localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd().getAppDeeplink();
    } else {
      localObject1 = null;
    }
    localParams.deeplink = ((String)localObject1);
    localParams.addflags = 268435456;
    localParams.extrasForIntent = ((Bundle)localObject2);
    localObject1 = AdAppDeeplinkLauncher.launch(a(), localParams);
    if ((localObject1 != null) && (((AdAppDeeplinkLauncher.Result)localObject1).isSuccess()))
    {
      localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData;
      if (localObject2 != null)
      {
        GdtTraceReporter.a(((GdtVideoCeilingData)localObject2).getAd(), 246);
        GdtTraceReporter.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd(), 290);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doOpenDeepLink result ");
    boolean bool;
    if (localObject1 != null) {
      bool = ((AdAppDeeplinkLauncher.Result)localObject1).isSuccess();
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    GdtLog.a("GdtVideoCeilingView", ((StringBuilder)localObject2).toString());
  }
  
  public long a()
  {
    GdtVideoCommonView localGdtVideoCommonView = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
    if (localGdtVideoCommonView != null) {
      return localGdtVideoCommonView.a();
    }
    return 0L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(false, 0);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a()) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    this.c = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    GdtWebViewBuilder localGdtWebViewBuilder = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
    if (localGdtWebViewBuilder != null) {
      localGdtWebViewBuilder.a(paramBundle);
    }
  }
  
  public void a(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363334)
    {
      if (i != 2131372123) {
        return;
      }
      l();
      return;
    }
    a();
  }
  
  public void a(GdtVideoCeilingLandView paramGdtVideoCeilingLandView, int paramInt, boolean paramBoolean)
  {
    if (paramGdtVideoCeilingLandView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramGdtVideoCeilingLandView.getLayoutParams();
    localValueAnimator.addUpdateListener(new GdtVideoCeilingView.2(this, localLayoutParams, localLayoutParams.topMargin, paramInt, paramGdtVideoCeilingLandView, paramBoolean));
    localValueAnimator.setDuration(300L);
    paramGdtVideoCeilingLandView.jdField_a_of_type_Boolean = true;
    localValueAnimator.start();
  }
  
  public boolean a()
  {
    GdtLog.a("GdtVideoCeilingView", "----back click");
    boolean bool2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b();
    boolean bool1 = true;
    Object localObject;
    if (bool2)
    {
      a();
      localObject = " videoView.isFullScreen() result = true";
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if ((localObject != null) && (((TouchWebView)localObject).canGoBack()))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
        localObject = " webView.goBack() result = true";
      }
      else if (a() != null)
      {
        a().finish();
        a().overridePendingTransition(17432576, 17432577);
        localObject = " getActivity().finish() result = true";
      }
      else
      {
        bool1 = false;
        localObject = "";
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("----back return ");
    localStringBuilder.append(bool1);
    localStringBuilder.append((String)localObject);
    GdtLog.a("GdtVideoCeilingView", localStringBuilder.toString());
    return bool1;
  }
  
  public void b()
  {
    GdtVideoCommonView localGdtVideoCommonView = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
    if ((localGdtVideoCommonView != null) && (!localGdtVideoCommonView.b())) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(true, 0);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
      if (localObject != null) {
        ((GdtVideoCommonView)localObject).e();
      }
      d(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int);
      paramInt = (int)(paramInt + 0.5F);
      paramInt = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getTop() + paramInt;
      int i = this.jdField_a_of_type_Int;
      if (paramInt > i) {
        paramInt = i;
      } else if (paramInt < 0) {
        paramInt = 0;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDrag newTop ");
      ((StringBuilder)localObject).append(paramInt);
      GdtLog.b("GdtVideoCeilingView", ((StringBuilder)localObject).toString());
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      try
      {
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_Int = 607;
        }
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        float f = paramInt * 1.0F / this.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - f);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
    if (localObject != null) {
      ((GdtVideoCommonView)localObject).h();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
    if (localObject != null) {
      ((GdtVideoCeilingLandView)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeAllViewsInLayout();
      }
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
    if (localObject == null)
    {
      GdtLog.d("GdtVideoCeilingView", "onEnd  view null ");
      return;
    }
    int i = this.jdField_a_of_type_Int;
    int j = (int)(i * 0.2F);
    localObject = (RelativeLayout.LayoutParams)((GdtVideoCeilingLandView)localObject).getLayoutParams();
    int k = ((RelativeLayout.LayoutParams)localObject).topMargin;
    boolean bool = true;
    if (paramInt == 0)
    {
      if (k <= i - j)
      {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 2;
      }
      else
      {
        i = this.jdField_a_of_type_Int - k;
        paramInt = i;
        if (this.c != 1) {
          break label128;
        }
        paramInt = i;
        break label131;
      }
    }
    else if (k >= j)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 0;
      paramInt = this.jdField_a_of_type_Int - k;
      break label131;
    }
    paramInt = -k;
    label128:
    bool = false;
    label131:
    if (Math.abs(paramInt) > 0)
    {
      a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView, paramInt, bool);
      return;
    }
    a((RelativeLayout.LayoutParams)localObject, this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView, bool);
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
    if (localObject != null) {
      ((GdtVideoCommonView)localObject).f();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
    if (localObject != null) {
      ((GdtVideoCeilingLandView)localObject).a();
    }
  }
  
  protected void d(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (paramInt == 0))
    {
      localObject = (RelativeLayout.LayoutParams)((GdtVideoCeilingLandView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_Int;
      paramInt = ((RelativeLayout.LayoutParams)localObject).height;
      int i = this.b;
      if (paramInt != i)
      {
        ((RelativeLayout.LayoutParams)localObject).height = i;
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
    if (localObject != null) {
      ((GdtVideoCommonView)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
    if (localObject != null) {
      ((GdtVideoCeilingLandView)localObject).b();
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
    if ((paramGdtVideoCeilingData != null) && (paramGdtVideoCeilingData.isValid()))
    {
      Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
      if (localObject == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData = paramGdtVideoCeilingData;
      ((GdtVideoCommonView)localObject).setData(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getVideoData());
      localObject = (AdCanvasView)findViewById(2131371712);
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getStyle() == 4)
      {
        paramGdtVideoCeilingData = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar;
        if (paramGdtVideoCeilingData != null) {
          paramGdtVideoCeilingData.setVisibility(8);
        }
        findViewById(2131377258).setVisibility(8);
        paramGdtVideoCeilingData = this.jdField_a_of_type_AndroidWidgetFrameLayout;
        if (paramGdtVideoCeilingData != null) {
          paramGdtVideoCeilingData.setVisibility(8);
        }
        ((AdCanvasView)localObject).setVisibility(0);
        GdtUIUtils.a((FrameLayout)localObject);
        ((AdCanvasView)localObject).setData(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getCanvasData());
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setGdtVideoCeilingNativeListeners(this, (AdCanvasView)localObject);
        return;
      }
      j();
      k();
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setVisibility(0);
      findViewById(2131377258).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      ((AdCanvasView)localObject).setVisibility(8);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getWebUrl());
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setAppName(paramGdtVideoCeilingData.getAd().getAppName());
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setStyle(paramGdtVideoCeilingData.getStyle());
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView
 * JD-Core Version:    0.7.0.1
 */