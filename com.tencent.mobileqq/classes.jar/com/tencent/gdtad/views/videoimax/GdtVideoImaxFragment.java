package com.tencent.gdtad.views.videoimax;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.statistics.GdtActionReporter.Params;
import com.tencent.gdtad.statistics.GdtTraceReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.VideoListener;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.util.SystemUtil;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class GdtVideoImaxFragment
  extends PublicBaseFragment
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GdtVideoImaxFragment.3(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected AdTimeStatistics a;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtDanmakuPresenter jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter;
  private GdtVideoCommonView.VideoListener jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoListener = new GdtVideoImaxFragment.1(this);
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private GdtVideoCeilingLandView jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
  private GdtVideoCeilingTitleBar jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar;
  private GdtWebViewBuilder jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
  private GdtImaxData jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtVideoImaxFragment.2(this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private AdTimeStatistics jdField_b_of_type_ComTencentAdTangramStatisticsCanvasAdTimeStatistics = new AdTimeStatistics();
  private boolean jdField_b_of_type_Boolean = false;
  
  public GdtVideoImaxFragment()
  {
    this.jdField_a_of_type_ComTencentAdTangramStatisticsCanvasAdTimeStatistics = new AdTimeStatistics();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showWebView() called with: total = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramFloat1);
    ((StringBuilder)localObject).append("], to = [");
    ((StringBuilder)localObject).append(paramFloat2);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("GdtVideoImaxFragment", ((StringBuilder)localObject).toString());
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).addUpdateListener(new GdtVideoImaxFragment.4(this, paramFloat1, paramFloat2, paramInt));
    ((ValueAnimator)localObject).start();
    ((ViewGroup)getBaseActivity().getWindow().getDecorView()).setSystemUiVisibility(7942);
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportLoadTimeForAction() called with: time = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], success = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("GdtVideoImaxFragment", ((StringBuilder)localObject).toString());
    localObject = new GdtActionReporter.Params();
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_ComTencentAdTangramAd = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd();
    PBUInt32Field localPBUInt32Field = ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type;
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 4;
    }
    localPBUInt32Field.set(i);
    ((GdtActionReporter.Params)localObject).jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
    GdtActionReporter.a((GdtActionReporter.Params)localObject);
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131369277).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376647));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368655));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379505));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362273));
    paramView = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
    if ((paramView != null) && (paramView.getAd() != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_logo()))
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = ImageUtil.e();
        paramView.mLoadingDrawable = localDrawable;
        paramView.mFailedDrawable = localDrawable;
        paramView = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_logo(), paramView);
        paramView.setDecodeHandler(URLDrawableDecodeHandler.a);
        paramView.setFadeInImage(true);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_image_name());
      e();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void a(GdtVideoCommonView paramGdtVideoCommonView, GdtVideoData paramGdtVideoData)
  {
    paramGdtVideoCommonView.setData(paramGdtVideoData);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramGdtVideoCommonView.getLayoutParams();
    paramGdtVideoData = GdtUIUtils.a(getBaseActivity());
    localMarginLayoutParams.height = paramGdtVideoData[1];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindVideo() called with: width = [");
    localStringBuilder.append(localMarginLayoutParams.width);
    localStringBuilder.append("], height = [");
    localStringBuilder.append(localMarginLayoutParams.height);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
    localMarginLayoutParams.leftMargin = (getResources().getDisplayMetrics().widthPixels - 1);
    paramGdtVideoCommonView.setLayoutParams(localMarginLayoutParams);
    this.jdField_b_of_type_AndroidViewView = getView().findViewById(2131366948);
    localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localMarginLayoutParams.height = paramGdtVideoData[1];
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localMarginLayoutParams);
    paramGdtVideoData = (RelativeLayout.LayoutParams)((RelativeLayout)paramGdtVideoCommonView.findViewById(2131364703)).getLayoutParams();
    paramGdtVideoData.addRule(9, 0);
    paramGdtVideoData.addRule(11);
    paramGdtVideoData = (ImageView)paramGdtVideoCommonView.findViewById(2131369321);
    paramGdtVideoData.setImageResource(2130840235);
    paramGdtVideoData = (RelativeLayout.LayoutParams)paramGdtVideoData.getLayoutParams();
    paramGdtVideoData.addRule(11);
    paramGdtVideoData.width = -2;
    paramGdtVideoData.leftMargin = 0;
    paramGdtVideoData.rightMargin = GdtUIUtils.a(15.0F, getResources());
    paramGdtVideoCommonView.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoListener);
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWebViewLoadFinish() called with: success = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAdTangramStatisticsCanvasAdTimeStatistics.stop();
      a(this.jdField_a_of_type_ComTencentAdTangramStatisticsCanvasAdTimeStatistics.getTime(), paramBoolean);
    }
  }
  
  private void b()
  {
    GdtLog.a("GdtVideoImaxFragment", "startPlay() called");
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b();
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
    if ((localObject1 != null) && (((GdtImaxData)localObject1).getAd() != null))
    {
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().info == null) {
        return;
      }
      try
      {
        Object localObject2 = getBaseActivity();
        localObject1 = localObject2;
        if ((localObject2 instanceof BasePluginActivity)) {
          localObject1 = ((BasePluginActivity)localObject2).getOutActivity();
        }
        localObject2 = new GdtHandler.Params();
        ((GdtHandler.Params)localObject2).c = 7;
        ((GdtHandler.Params)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)localObject1);
        ((GdtHandler.Params)localObject2).jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().info);
        ((GdtHandler.Params)localObject2).jdField_a_of_type_Boolean = false;
        ((GdtHandler.Params)localObject2).jdField_b_of_type_Boolean = paramBoolean;
        ((GdtHandler.Params)localObject2).e = false;
        ((GdtHandler.Params)localObject2).jdField_a_of_type_AndroidOsBundle = new Bundle();
        ((GdtHandler.Params)localObject2).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(new GdtAppReceiver());
        ((GdtHandler.Params)localObject2).jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_jc_qzone");
        GdtHandler.a((GdtHandler.Params)localObject2);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter;
    if (localObject == null) {
      return false;
    }
    if (((GdtDanmakuPresenter)localObject).b())
    {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter.setVisibility(0);
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getDanmakuContents();
    if ((localObject != null) && (localObject.length != 0))
    {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter.a(AdUIUtils.getScreenWidth(getContext()), (String[])localObject);
      if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter.a())
      {
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter.setVisibility(0);
        return true;
      }
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter.setVisibility(8);
      QLog.i("GdtVideoImaxFragment", 4, "mDanmakuPresenter cannot start");
      return true;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter.setVisibility(8);
    return false;
  }
  
  private void c()
  {
    GdtLog.a("GdtVideoImaxFragment", "setPreviewImageVisible() called");
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
    localMarginLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams(localMarginLayoutParams);
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height > 0;
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
    if ((localObject != null) && (((GdtImaxData)localObject).getAd() != null))
    {
      if (!this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().isValid()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd();
      GdtPreLoader.a().a((GdtAd)localObject);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == null) {
      return;
    }
    GdtImaxData localGdtImaxData = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
    if ((localGdtImaxData != null) && (localGdtImaxData.getAd() != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getProductType() == 12))
    {
      if (AdAppUtil.isInstalled(getBaseActivity(), this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAppPackageName()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705332));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705331));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131705326));
  }
  
  private void f()
  {
    GdtImaxData localGdtImaxData = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
    if (localGdtImaxData != null)
    {
      if (localGdtImaxData.getAd() == null) {
        return;
      }
      GdtTraceReporter.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd(), 280);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setIgnoreInterceptTouchEvent(true);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setIgnoreTouchEvent(true);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.b();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setAppName(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAppName());
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setStyle(1);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.a();
    if (SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity()) > 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.height = SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setOnBtnClickListener(new GdtVideoImaxFragment.5(this));
  }
  
  private void i()
  {
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    BaseActivity localBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(localBaseActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = new GdtVideoImaxFragment.6(this, localBaseActivity, localBaseActivity, localBaseActivity.getIntent(), (AppInterface)localObject);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new WebViewDirector(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder).a(null, (AppRuntime)localObject, getBaseActivity().getIntent());
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = 0;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getWebUrl();
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl((String)localObject);
    this.jdField_a_of_type_ComTencentAdTangramStatisticsCanvasAdTimeStatistics.start();
  }
  
  private void j()
  {
    GdtLog.a("GdtVideoImaxFragment", "reportStayTimeForAction() called");
    GdtActionReporter.Params localParams = new GdtActionReporter.Params();
    localParams.jdField_a_of_type_ComTencentAdTangramAd = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd();
    localParams.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(7);
    localParams.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(this.jdField_b_of_type_ComTencentAdTangramStatisticsCanvasAdTimeStatistics.getTime());
    GdtActionReporter.a(localParams);
  }
  
  private void k()
  {
    GdtLog.a("GdtVideoImaxFragment", "onAnimationEnd() called");
    this.jdField_a_of_type_Boolean = true;
    b();
    c();
    a();
  }
  
  public boolean a()
  {
    GdtLog.a("GdtVideoImaxFragment", "----back click");
    int i = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle();
    boolean bool = true;
    if ((i == 1) && (getBaseActivity() != null))
    {
      getBaseActivity().finish();
      return true;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      str = " mWebView.goBack() result = true";
    }
    else if (c())
    {
      a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height, this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height, 0.0F);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b();
      str = " webViewIsShowing result = true";
    }
    else if (getBaseActivity() != null)
    {
      getBaseActivity().finish();
      str = " getActivity().finish() result = true";
    }
    else
    {
      str = "";
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("----back return ");
    localStringBuilder.append(bool);
    localStringBuilder.append(str);
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
    return bool;
  }
  
  public boolean a(View paramView)
  {
    boolean bool = false;
    if (paramView == null)
    {
      QLog.i("GdtVideoImaxFragment", 1, "appAutoDownload() view is null");
      return false;
    }
    int i = paramView.getId();
    if ((i == 2131368655) || (i == 2131379505) || (i == 2131362273)) {
      bool = true;
    }
    paramView = new StringBuilder();
    paramView.append("appAutoDownload:");
    paramView.append(bool);
    QLog.i("GdtVideoImaxFragment", 1, paramView.toString());
    return bool;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    Window localWindow = paramActivity.getWindow();
    localWindow.addFlags(1024);
    ((ViewGroup)localWindow.getDecorView()).setSystemUiVisibility(7942);
    if (GdtUIUtils.a(paramActivity)) {
      GdtUIUtils.a(paramActivity);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity = paramActivity.getIntent();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData = ((GdtImaxData)paramActivity.getSerializableExtra("data"));
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramActivity.getParcelableExtra("callback"));
    paramActivity = new Bundle();
    GdtVideoImaxFragment.MyResultReceiver localMyResultReceiver = new GdtVideoImaxFragment.MyResultReceiver(new Handler(Looper.getMainLooper()));
    localMyResultReceiver.a(this);
    ClassLoader localClassLoader = localMyResultReceiver.getClass().getClassLoader();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAttach() classLoader = [");
    localStringBuilder.append(localClassLoader);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
    paramActivity.setClassLoader(localClassLoader);
    paramActivity.putParcelable("callback", localMyResultReceiver);
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramActivity);
  }
  
  public boolean onBackEvent()
  {
    return a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559199, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.h();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 0)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.c();
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeAllViewsInLayout();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter;
    if ((localObject != null) && (((GdtDanmakuPresenter)localObject).b()))
    {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter.a();
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter = null;
    }
  }
  
  public void onDetach()
  {
    GdtImaxData localGdtImaxData = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
    if ((localGdtImaxData != null) && (localGdtImaxData.getVideoSplicePageStyle() == 0)) {
      j();
    }
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.d();
    this.jdField_b_of_type_ComTencentAdTangramStatisticsCanvasAdTimeStatistics.stop();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.f();
    this.jdField_b_of_type_ComTencentAdTangramStatisticsCanvasAdTimeStatistics.start();
    e();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    d();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = ((GdtVideoCommonView)paramView.findViewById(2131380485));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131381073));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar = ((GdtVideoCeilingTitleBar)paramView.findViewById(2131381070));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371958);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView = ((GdtVideoCeilingLandView)paramView.findViewById(2131367524));
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter = ((GdtDanmakuPresenter)paramView.findViewById(2131368585));
    a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView, this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoData());
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 1)
    {
      a(paramView);
    }
    else if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 0)
    {
      h();
      i();
    }
    g();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.isDanmakuAdv()) {
      b();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment
 * JD-Core Version:    0.7.0.1
 */