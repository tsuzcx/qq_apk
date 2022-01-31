package com.tencent.gdtad.views.videoceiling;

import aase;
import aass;
import aatp;
import aauv;
import aauy;
import aavb;
import aavc;
import aavd;
import aave;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import befe;
import com.tencent.TMG.utils.QLog;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GdtVideoCeilingView
  extends FrameLayout
  implements aauv, aauy, aavb
{
  private int jdField_a_of_type_Int = 607;
  private aave jdField_a_of_type_Aave;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private GdtVideoCeilingData jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData;
  private GdtVideoCeilingLandView jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
  private GdtVideoCeilingTitleBar jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar;
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
    label76:
    label80:
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt1 < paramInt2)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCeilingView", 0, "updateLayout width " + paramInt1 + " height " + paramInt2 + " Portrait " + bool);
      }
      if (!bool) {
        break label238;
      }
      paramInt1 = (int)(paramInt1 * 0.5625D);
      if (paramInt1 <= 0) {
        break label243;
      }
      this.jdField_a_of_type_Int = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCeilingView", 0, "videoView height " + this.jdField_a_of_type_Int);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
      localLayoutParams.height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      if (paramInt2 <= 0) {
        break label250;
      }
    }
    for (;;)
    {
      this.b = paramInt2;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      localLayoutParams.topMargin = this.jdField_a_of_type_Int;
      localLayoutParams.height = (this.b - this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      return;
      bool = false;
      break;
      label238:
      paramInt1 = paramInt2;
      break label76;
      label243:
      paramInt1 = 607;
      break label80;
      label250:
      paramInt2 = 1920;
    }
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, GdtVideoCeilingLandView paramGdtVideoCeilingLandView, boolean paramBoolean)
  {
    if (paramGdtVideoCeilingLandView == null) {
      return;
    }
    if (paramGdtVideoCeilingLandView.jdField_a_of_type_Int == 0) {}
    for (paramLayoutParams.height = (this.b - this.jdField_a_of_type_Int);; paramLayoutParams.height = this.b)
    {
      paramGdtVideoCeilingLandView.jdField_a_of_type_Boolean = false;
      paramGdtVideoCeilingLandView.setLayoutParams(paramLayoutParams);
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.d();
      }
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      return;
    }
  }
  
  private void f()
  {
    g();
  }
  
  private void g()
  {
    inflate(getContext(), 2131559154, this);
    i();
    j();
    k();
    h();
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379755);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView = ((GdtVideoCeilingLandView)findViewById(2131367075));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setGdtVideoCeilingListeners(this, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = ((GdtVideoCommonView)findViewById(2131379586));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setOnVideoFullScreen(this);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar = ((GdtVideoCeilingTitleBar)findViewById(2131380171));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setOnBtnClickListener(this);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.b();
  }
  
  private void k()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131380173));
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Aave = new aavc(this, getContext(), a(), a(), localAppInterface);
    this.jdField_a_of_type_Aave.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new befe(this.jdField_a_of_type_Aave).a(null, localAppInterface, a());
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData == null)
    {
      aase.d("GdtVideoCeilingView", "doAppOpen data==null");
      return;
    }
    switch (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getStyle())
    {
    default: 
      return;
    case 1: 
      aase.d("GdtVideoCeilingView", "doAppOpen should not go here");
      return;
    case 2: 
      m();
      return;
    }
    n();
  }
  
  private void m()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_ads");
    localObject = AdAppUtil.launch(getContext(), this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd().getAppPackageName(), (Bundle)localObject);
    StringBuilder localStringBuilder = new StringBuilder().append("doOpenMain result ");
    if (localObject != null) {}
    for (boolean bool = ((AdError)localObject).isSuccess();; bool = false)
    {
      aase.a("GdtVideoCeilingView", bool);
      return;
    }
  }
  
  private void n()
  {
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("big_brother_source_key", "biz_src_ads");
    AdAppDeeplinkLauncher.Params localParams = new AdAppDeeplinkLauncher.Params();
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd() != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd().getAppDeeplink();
      localParams.deeplink = ((String)localObject1);
      localParams.addflags = 268435456;
      localParams.extrasForIntent = ((Bundle)localObject2);
      localObject1 = AdAppDeeplinkLauncher.launch(a(), localParams);
      if ((localObject1 != null) && (((AdAppDeeplinkLauncher.Result)localObject1).isSuccess())) {
        aass.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd(), 246);
      }
      localObject2 = new StringBuilder().append("doOpenDeepLink result ");
      if (localObject1 == null) {
        break label151;
      }
    }
    label151:
    for (boolean bool = ((AdAppDeeplinkLauncher.Result)localObject1).isSuccess();; bool = false)
    {
      aase.a("GdtVideoCeilingView", bool);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      return this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a();
    }
    return 0L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(false, 0);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a()) {}
    for (paramInt = 1;; paramInt = 2)
    {
      this.c = paramInt;
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aave != null) {
      this.jdField_a_of_type_Aave.a(paramBundle);
    }
  }
  
  public void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363020: 
      a();
      return;
    }
    l();
  }
  
  public void a(GdtVideoCeilingLandView paramGdtVideoCeilingLandView, int paramInt, boolean paramBoolean)
  {
    if (paramGdtVideoCeilingLandView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramGdtVideoCeilingLandView.getLayoutParams();
    localValueAnimator.addUpdateListener(new aavd(this, localLayoutParams, localLayoutParams.topMargin, paramInt, paramGdtVideoCeilingLandView, paramBoolean));
    localValueAnimator.setDuration(300L);
    paramGdtVideoCeilingLandView.jdField_a_of_type_Boolean = true;
    localValueAnimator.start();
  }
  
  public boolean a()
  {
    boolean bool = true;
    aase.a("GdtVideoCeilingView", "----back click");
    String str = "";
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b())
    {
      a();
      str = " videoView.isFullScreen() result = true";
    }
    for (;;)
    {
      aase.a("GdtVideoCeilingView", "----back return " + bool + str);
      return bool;
      if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
        str = " webView.goBack() result = true";
      }
      else if (a() != null)
      {
        a().finish();
        a().overridePendingTransition(17432576, 17432577);
        str = " getActivity().finish() result = true";
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b())) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(true, 0);
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.g();
    }
    d(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int);
    int i = (int)(paramInt + 0.5F) + this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getTop();
    if (i > this.jdField_a_of_type_Int) {
      paramInt = this.jdField_a_of_type_Int;
    }
    for (;;)
    {
      aase.b("GdtVideoCeilingView", "onDrag newTop " + paramInt);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
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
        return;
      }
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.j();
    }
    if (this.jdField_a_of_type_Aave != null) {
      this.jdField_a_of_type_Aave.c();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.c();
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeAllViewsInLayout();
      }
    }
  }
  
  public void c(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView == null)
    {
      aase.d("GdtVideoCeilingView", "onEnd  view null ");
      return;
    }
    int j = (int)(this.jdField_a_of_type_Int * 0.2F);
    int k = this.jdField_a_of_type_Int;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    if (paramInt == 0) {
      if (i <= k - j)
      {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 2;
        paramInt = -i;
        bool1 = bool2;
      }
    }
    while (Math.abs(paramInt) > 0)
    {
      a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView, paramInt, bool1);
      return;
      paramInt = this.jdField_a_of_type_Int;
      if (this.c == 1) {}
      for (;;)
      {
        paramInt -= i;
        break;
        bool1 = false;
      }
      if (i >= j)
      {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 0;
        paramInt = this.jdField_a_of_type_Int - i;
        bool1 = true;
      }
      else
      {
        paramInt = -i;
        bool1 = bool2;
      }
    }
    a(localLayoutParams, this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView, bool1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.h();
    }
    if (this.jdField_a_of_type_Aave != null) {
      this.jdField_a_of_type_Aave.a();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.a();
    }
  }
  
  protected void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (paramInt == 0))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      localLayoutParams.topMargin = this.jdField_a_of_type_Int;
      if (localLayoutParams.height != this.b)
      {
        localLayoutParams.height = this.b;
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.f();
    }
    if (this.jdField_a_of_type_Aave != null) {
      this.jdField_a_of_type_Aave.b();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.b();
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
    AdCanvasView localAdCanvasView = (AdCanvasView)findViewById(2131370994);
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getStyle() == 4)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setVisibility(8);
      findViewById(2131376443).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      localAdCanvasView.setVisibility(0);
      aatp.a(localAdCanvasView);
      localAdCanvasView.setData(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getCanvasData());
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setGdtVideoCeilingNativeListeners(this, localAdCanvasView);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setVisibility(0);
    findViewById(2131376443).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    localAdCanvasView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getWebUrl());
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setAppName(paramGdtVideoCeilingData.getAd().getAppName());
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setStyle(paramGdtVideoCeilingData.getStyle());
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView
 * JD-Core Version:    0.7.0.1
 */