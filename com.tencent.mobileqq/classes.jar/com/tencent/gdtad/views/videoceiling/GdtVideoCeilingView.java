package com.tencent.gdtad.views.videoceiling;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.statistics.GdtTraceReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.VideoFullScreenListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.WebViewDirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GdtVideoCeilingView
  extends FrameLayout
  implements GdtVideoCommonView.VideoFullScreenListener, GdtVideoCeilingListener, GdtVideoCeilingTitleBar.OnBtnClickListener
{
  private GdtVideoCeilingData a;
  private GdtVideoCommonView b;
  private View c;
  private int d = 607;
  private int e = 1920;
  private TouchWebView f;
  private GdtWebViewBuilder g;
  private GdtVideoCeilingLandView h;
  private FrameLayout i;
  private int j = 1;
  private GdtVideoCeilingTitleBar k;
  
  public GdtVideoCeilingView(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public GdtVideoCeilingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  public GdtVideoCeilingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
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
    if (bool) {
      paramInt1 = b(paramInt1, paramInt2);
    } else {
      paramInt1 = paramInt2;
    }
    if (paramInt1 <= 0) {
      paramInt1 = 607;
    }
    this.d = paramInt1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("videoView height ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("GdtVideoCeilingView", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.d;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.d;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramInt2 <= 0) {
      paramInt2 = 1920;
    }
    this.e = paramInt2;
    localObject = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    paramInt1 = this.d;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = (this.e - paramInt1);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, GdtVideoCeilingLandView paramGdtVideoCeilingLandView, boolean paramBoolean)
  {
    if (paramGdtVideoCeilingLandView == null) {
      return;
    }
    if (paramGdtVideoCeilingLandView.a == 0) {
      paramLayoutParams.height = (this.e - this.d);
    } else {
      paramLayoutParams.height = this.e;
    }
    paramGdtVideoCeilingLandView.c = false;
    paramGdtVideoCeilingLandView.setLayoutParams(paramLayoutParams);
    if (paramBoolean)
    {
      paramLayoutParams = this.b;
      if ((paramLayoutParams != null) && (paramLayoutParams.a)) {
        this.b.b();
      }
    }
    paramLayoutParams = this.c;
    if (paramLayoutParams != null) {
      paramLayoutParams.setVisibility(4);
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    String[] arrayOfString = this.a.getWidthHeightRatio().split(":");
    double d1;
    if (arrayOfString.length == 0)
    {
      d1 = paramInt1;
      Double.isNaN(d1);
    }
    double d2;
    for (d1 *= 0.5625D;; d1 = Math.min(d1, d2 * 0.85D))
    {
      return (int)d1;
      int m = Integer.parseInt(arrayOfString[0]);
      float f1 = Float.parseFloat(arrayOfString[1]);
      d1 = paramInt1 * (f1 / m);
      d2 = paramInt2;
      Double.isNaN(d2);
    }
  }
  
  private void e(int paramInt)
  {
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext(getContext(), new InitGdtContextParams());
    String str = getIntent().getStringExtra("GdtWebReportQQ_TRACE_ID");
    if (TextUtils.isEmpty(str))
    {
      GdtLog.a("GdtVideoCeilingView", "traceId is null, report is failed ");
      return;
    }
    long l = getIntent().getLongExtra("GdtWebReportQQ_CLICK_TIME", System.currentTimeMillis());
    link_report.LinkReport.ReportBiz localReportBiz = new link_report.LinkReport.ReportBiz();
    localReportBiz.cost_time = ((int)(System.currentTimeMillis() - l));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report eventId is ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("costTime is");
    localStringBuilder.append(localReportBiz.cost_time);
    QLog.d("GdtVideoCeilingView", 0, localStringBuilder.toString());
    localReportBiz.aid = getIntent().getStringExtra("GdtWebReportQQ_AD_ID");
    localReportBiz.pid = getIntent().getStringExtra("GdtWebReportQQ_POS_ID");
    localReportBiz.traceid = str;
    AdReporterForLinkEvent.reportAsync(getActivity(), paramInt, null, localReportBiz, null);
  }
  
  private void g()
  {
    h();
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
  
  private void h()
  {
    inflate(getContext(), 2131624954, this);
    j();
    i();
  }
  
  private void i()
  {
    this.c = findViewById(2131449635);
    this.h = ((GdtVideoCeilingLandView)findViewById(2131434066));
    this.h.setGdtVideoCeilingListeners(this, this.f);
  }
  
  private void j()
  {
    e(4003027);
    this.b = ((GdtVideoCommonView)findViewById(2131449438));
    this.b.setOnVideoFullScreen(this);
    this.b.a(new GdtVideoCeilingView.1(this));
    this.b.getViewTreeObserver().addOnGlobalLayoutListener(new GdtVideoCeilingView.2(this));
  }
  
  private void k()
  {
    this.k = ((GdtVideoCeilingTitleBar)findViewById(2131450083));
    this.k.setOnBtnClickListener(this);
    this.k.b();
  }
  
  private void l()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.i = ((FrameLayout)findViewById(2131450086));
    this.f = new TouchWebView(getContext());
    this.i.addView(this.f);
    this.g = new GdtVideoCeilingView.3(this, getContext(), getActivity(), getIntent(), localAppInterface);
    this.g.a(this.f);
    new WebViewDirector(this.g).a(null, localAppInterface, getIntent());
  }
  
  private void m()
  {
    GdtVideoCeilingData localGdtVideoCeilingData = this.a;
    if (localGdtVideoCeilingData == null)
    {
      GdtLog.d("GdtVideoCeilingView", "doAppOpen data==null");
      return;
    }
    int m = localGdtVideoCeilingData.getStyle();
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3) {
          return;
        }
        o();
        return;
      }
      n();
      return;
    }
    GdtLog.d("GdtVideoCeilingView", "doAppOpen should not go here");
  }
  
  private void n()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_ads");
    localObject = AdAppUtil.launch(getContext(), this.a.getAd().getAppPackageName(), (Bundle)localObject);
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
  
  private void o()
  {
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("big_brother_source_key", "biz_src_ads");
    AdAppDeeplinkLauncher.Params localParams = new AdAppDeeplinkLauncher.Params();
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((GdtVideoCeilingData)localObject1).getAd() != null)) {
      localObject1 = this.a.getAd().getAppDeeplink();
    } else {
      localObject1 = null;
    }
    localParams.deeplink = ((String)localObject1);
    localParams.addflags = 268435456;
    localParams.extrasForIntent = ((Bundle)localObject2);
    localObject1 = AdAppDeeplinkLauncher.launch(getActivity(), localParams);
    if ((localObject1 != null) && (((AdAppDeeplinkLauncher.Result)localObject1).isSuccess()))
    {
      localObject2 = this.a;
      if (localObject2 != null)
      {
        GdtTraceReporter.a(((GdtVideoCeilingData)localObject2).getAd(), 246);
        GdtTraceReporter.a(this.a.getAd(), 290);
        localObject2 = new link_report.LinkReport.ReportBiz();
        ((link_report.LinkReport.ReportBiz)localObject2).deeplink_scene = 1;
        ((link_report.LinkReport.ReportBiz)localObject2).deeplink_type = 1;
        AdReporterForLinkEvent.reportAsync(getContext(), 4002011, this.a.getAd(), (link_report.LinkReport.ReportBiz)localObject2, null);
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
  
  public void a()
  {
    this.b.setisFullScreen(false, 0);
  }
  
  public void a(int paramInt)
  {
    if (this.b.i()) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    this.j = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    GdtWebViewBuilder localGdtWebViewBuilder = this.g;
    if (localGdtWebViewBuilder != null) {
      localGdtWebViewBuilder.a(paramBundle);
    }
  }
  
  public void a(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131429208)
    {
      if (m != 2131439593) {
        return;
      }
      m();
      return;
    }
    f();
  }
  
  public void a(GdtVideoCeilingLandView paramGdtVideoCeilingLandView, int paramInt, boolean paramBoolean)
  {
    if (paramGdtVideoCeilingLandView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramGdtVideoCeilingLandView.getLayoutParams();
    localValueAnimator.addUpdateListener(new GdtVideoCeilingView.4(this, localLayoutParams, localLayoutParams.topMargin, paramInt, paramGdtVideoCeilingLandView, paramBoolean));
    localValueAnimator.setDuration(300L);
    paramGdtVideoCeilingLandView.c = true;
    localValueAnimator.start();
  }
  
  public void b()
  {
    GdtVideoCommonView localGdtVideoCommonView = this.b;
    if ((localGdtVideoCommonView != null) && (!localGdtVideoCommonView.j())) {
      this.b.setisFullScreen(true, 0);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.h != null)
    {
      if (this.c == null) {
        return;
      }
      Object localObject = this.b;
      if (localObject != null) {
        ((GdtVideoCommonView)localObject).e();
      }
      d(this.h.a);
      paramInt = (int)(paramInt + 0.5F);
      paramInt = this.h.getTop() + paramInt;
      int m = this.d;
      if (paramInt > m) {
        paramInt = m;
      } else if (paramInt < 0) {
        paramInt = 0;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDrag newTop ");
      ((StringBuilder)localObject).append(paramInt);
      GdtLog.b("GdtVideoCeilingView", ((StringBuilder)localObject).toString());
      localObject = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      try
      {
        if (this.d == 0) {
          this.d = 607;
        }
        if (this.c.getVisibility() == 4) {
          this.c.setVisibility(0);
        }
        float f1 = paramInt * 1.0F / this.d;
        this.c.setAlpha(1.0F - f1);
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
    Object localObject = this.b;
    if (localObject != null) {
      ((GdtVideoCommonView)localObject).h();
    }
    localObject = this.g;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).c();
    }
    localObject = this.h;
    if (localObject != null) {
      ((GdtVideoCeilingLandView)localObject).c();
    }
    localObject = this.f;
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
    Object localObject = this.h;
    if (localObject == null)
    {
      GdtLog.d("GdtVideoCeilingView", "onEnd  view null ");
      return;
    }
    int m = this.d;
    int n = (int)(m * 0.2F);
    localObject = (RelativeLayout.LayoutParams)((GdtVideoCeilingLandView)localObject).getLayoutParams();
    int i1 = ((RelativeLayout.LayoutParams)localObject).topMargin;
    boolean bool = true;
    if (paramInt == 0)
    {
      if (i1 <= m - n)
      {
        this.h.a = 2;
      }
      else
      {
        m = this.d - i1;
        paramInt = m;
        if (this.j != 1) {
          break label128;
        }
        paramInt = m;
        break label131;
      }
    }
    else if (i1 >= n)
    {
      this.h.a = 0;
      paramInt = this.d - i1;
      break label131;
    }
    paramInt = -i1;
    label128:
    bool = false;
    label131:
    if (Math.abs(paramInt) > 0)
    {
      a(this.h, paramInt, bool);
      return;
    }
    a((RelativeLayout.LayoutParams)localObject, this.h, bool);
  }
  
  public void d()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((GdtVideoCommonView)localObject).f();
    }
    localObject = this.g;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).a();
    }
    localObject = this.h;
    if (localObject != null) {
      ((GdtVideoCeilingLandView)localObject).a();
    }
  }
  
  protected void d(int paramInt)
  {
    Object localObject = this.h;
    if ((localObject != null) && (this.b != null) && (paramInt == 0))
    {
      localObject = (RelativeLayout.LayoutParams)((GdtVideoCeilingLandView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.d;
      paramInt = ((RelativeLayout.LayoutParams)localObject).height;
      int m = this.e;
      if (paramInt != m)
      {
        ((RelativeLayout.LayoutParams)localObject).height = m;
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void e()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((GdtVideoCommonView)localObject).d();
    }
    localObject = this.g;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).b();
    }
    localObject = this.h;
    if (localObject != null) {
      ((GdtVideoCeilingLandView)localObject).b();
    }
  }
  
  public boolean f()
  {
    GdtLog.a("GdtVideoCeilingView", "----back click");
    boolean bool2 = this.b.j();
    boolean bool1 = true;
    Object localObject;
    if (bool2)
    {
      a();
      localObject = " videoView.isFullScreen() result = true";
    }
    else
    {
      localObject = this.f;
      if ((localObject != null) && (((TouchWebView)localObject).canGoBack()))
      {
        this.f.goBack();
        localObject = " webView.goBack() result = true";
      }
      else if (getActivity() != null)
      {
        getActivity().finish();
        getActivity().overridePendingTransition(17432576, 17432577);
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
  
  public long getCurrentPosition()
  {
    GdtVideoCommonView localGdtVideoCommonView = this.b;
    if (localGdtVideoCommonView != null) {
      return localGdtVideoCommonView.getCurrentPosition();
    }
    return 0L;
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
      Object localObject = this.b;
      if (localObject == null) {
        return;
      }
      this.a = paramGdtVideoCeilingData;
      ((GdtVideoCommonView)localObject).setData(this.a.getVideoData());
      localObject = (AdCanvasView)findViewById(2131439139);
      if (this.a.getStyle() == 4)
      {
        paramGdtVideoCeilingData = this.k;
        if (paramGdtVideoCeilingData != null) {
          paramGdtVideoCeilingData.setVisibility(8);
        }
        findViewById(2131445645).setVisibility(8);
        paramGdtVideoCeilingData = this.i;
        if (paramGdtVideoCeilingData != null) {
          paramGdtVideoCeilingData.setVisibility(8);
        }
        ((AdCanvasView)localObject).setVisibility(0);
        GdtUIUtils.a((FrameLayout)localObject);
        ((AdCanvasView)localObject).setData(this.a.getCanvasData());
        this.h.setGdtVideoCeilingNativeListeners(this, (AdCanvasView)localObject);
        return;
      }
      k();
      l();
      this.k.setVisibility(0);
      findViewById(2131445645).setVisibility(0);
      this.i.setVisibility(0);
      ((AdCanvasView)localObject).setVisibility(8);
      this.f.loadUrl(this.a.getWebUrl());
      this.k.setAppName(paramGdtVideoCeilingData.getAd().getAppName());
      this.k.setStyle(paramGdtVideoCeilingData.getStyle());
      this.k.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView
 * JD-Core Version:    0.7.0.1
 */