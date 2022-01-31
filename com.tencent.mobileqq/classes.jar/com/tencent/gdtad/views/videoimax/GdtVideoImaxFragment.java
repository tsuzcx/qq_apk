package com.tencent.gdtad.views.videoimax;

import aanp;
import aant;
import aanu;
import aaod;
import aapa;
import aaqh;
import aaqp;
import aaqs;
import aaqt;
import aaqu;
import aaqv;
import aaqw;
import alpo;
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
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcuq;
import bdda;
import beav;
import bjri;
import com.tencent.ad.tangram.canvas.statistics.AdTimeStatistics;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class GdtVideoImaxFragment
  extends PublicBaseFragment
{
  private aaqh jdField_a_of_type_Aaqh = new aaqs(this);
  private aaqp jdField_a_of_type_Aaqp;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aaqt(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected AdTimeStatistics a;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private GdtVideoCeilingLandView jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
  private GdtVideoCeilingTitleBar jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar;
  private GdtImaxData jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtVideoImaxFragment.2(this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private AdTimeStatistics jdField_b_of_type_ComTencentAdTangramCanvasStatisticsAdTimeStatistics = new AdTimeStatistics();
  private boolean jdField_b_of_type_Boolean;
  
  public GdtVideoImaxFragment()
  {
    this.jdField_a_of_type_ComTencentAdTangramCanvasStatisticsAdTimeStatistics = new AdTimeStatistics();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    aanp.a("GdtVideoImaxFragment", "showWebView() called with: total = [" + paramInt + "], from = [" + paramFloat1 + "], to = [" + paramFloat2 + "]");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new aaqu(this, paramFloat1, paramFloat2, paramInt));
    localValueAnimator.start();
    ((ViewGroup)getActivity().getWindow().getDecorView()).setSystemUiVisibility(7942);
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    aanp.a("GdtVideoImaxFragment", "reportLoadTimeForAction() called with: time = [" + paramLong + "], success = [" + paramBoolean + "]");
    aanu localaanu = new aanu();
    localaanu.jdField_a_of_type_ComTencentAdTangramAd = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd();
    PBUInt32Field localPBUInt32Field = localaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type;
    if (paramBoolean) {}
    for (int i = 3;; i = 4)
    {
      localPBUInt32Field.set(i);
      localaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
      aant.a(localaanu);
      return;
    }
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131368685).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131375826));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368110));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378593));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362147));
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd() != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_logo()))
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = bdda.b();
        paramView.mLoadingDrawable = localDrawable;
        paramView.mFailedDrawable = localDrawable;
        paramView = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_logo(), paramView);
        paramView.setDecodeHandler(bcuq.a);
        paramView.setFadeInImage(true);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_image_name());
      d();
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void a(GdtVideoCommonView paramGdtVideoCommonView, GdtVideoData paramGdtVideoData)
  {
    paramGdtVideoCommonView.setData(paramGdtVideoData, null);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramGdtVideoCommonView.getLayoutParams();
    paramGdtVideoData = aapa.a(getActivity());
    localMarginLayoutParams.height = paramGdtVideoData[1];
    aanp.a("GdtVideoImaxFragment", "bindVideo() called with: width = [" + localMarginLayoutParams.width + "], height = [" + localMarginLayoutParams.height + "]");
    localMarginLayoutParams.leftMargin = (getResources().getDisplayMetrics().widthPixels - 1);
    paramGdtVideoCommonView.setLayoutParams(localMarginLayoutParams);
    this.jdField_b_of_type_AndroidViewView = getView().findViewById(2131366457);
    localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localMarginLayoutParams.height = paramGdtVideoData[1];
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localMarginLayoutParams);
    paramGdtVideoData = (RelativeLayout.LayoutParams)((RelativeLayout)paramGdtVideoCommonView.findViewById(2131364325)).getLayoutParams();
    paramGdtVideoData.addRule(9, 0);
    paramGdtVideoData.addRule(11);
    paramGdtVideoData = (ImageView)paramGdtVideoCommonView.findViewById(2131368730);
    paramGdtVideoData.setImageResource(2130839772);
    paramGdtVideoData = (RelativeLayout.LayoutParams)paramGdtVideoData.getLayoutParams();
    paramGdtVideoData.addRule(11);
    paramGdtVideoData.width = -2;
    paramGdtVideoData.leftMargin = 0;
    paramGdtVideoData.rightMargin = aapa.a(15.0F, getResources());
    paramGdtVideoCommonView.a(this.jdField_a_of_type_Aaqh);
  }
  
  private void a(boolean paramBoolean)
  {
    aanp.a("GdtVideoImaxFragment", "onWebViewLoadFinish() called with: success = [" + paramBoolean + "]");
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAdTangramCanvasStatisticsAdTimeStatistics.stop();
      a(this.jdField_a_of_type_ComTencentAdTangramCanvasStatisticsAdTimeStatistics.getTime(), paramBoolean);
    }
  }
  
  private void b()
  {
    aanp.a("GdtVideoImaxFragment", "startPlay() called");
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.d();
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height > 0;
  }
  
  private void c()
  {
    aanp.a("GdtVideoImaxFragment", "setPreviewImageVisible() called");
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
    localMarginLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams(localMarginLayoutParams);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd() != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getProductType() == 12))
    {
      if (AdAppUtil.isInstalled(getActivity(), this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAppPackageName()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131705617));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131705616));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131705611));
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData == null) || (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd() == null)) {
      return;
    }
    aaod.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd(), 280);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setIgnoreInterceptTouchEvent(true);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setIgnoreTouchEvent(true);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.b();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setAppName(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAppName());
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setStyle(1);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.a();
    if (bjri.a(getActivity(), getActivity()) > 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.height = bjri.a(getActivity(), getActivity());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setOnBtnClickListener(new aaqv(this));
  }
  
  private void h()
  {
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    FragmentActivity localFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(localFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Aaqp = new aaqw(this, localFragmentActivity, localFragmentActivity, localFragmentActivity.getIntent(), (AppInterface)localObject);
    this.jdField_a_of_type_Aaqp.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new beav(this.jdField_a_of_type_Aaqp).a(null, (AppInterface)localObject, getActivity().getIntent());
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = 0;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getWebUrl();
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl((String)localObject);
    this.jdField_a_of_type_ComTencentAdTangramCanvasStatisticsAdTimeStatistics.start();
  }
  
  private void i()
  {
    aanp.a("GdtVideoImaxFragment", "reportStayTimeForAction() called");
    aanu localaanu = new aanu();
    localaanu.jdField_a_of_type_ComTencentAdTangramAd = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd();
    localaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(7);
    localaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(this.jdField_b_of_type_ComTencentAdTangramCanvasStatisticsAdTimeStatistics.getTime());
    aant.a(localaanu);
  }
  
  private void j()
  {
    aanp.a("GdtVideoImaxFragment", "onAnimationEnd() called");
    this.jdField_a_of_type_Boolean = true;
    b();
    c();
    a();
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData == null) || (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd() == null) || (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().info == null)) {
      return;
    }
    try
    {
      Object localObject2 = getActivity();
      Object localObject1 = localObject2;
      if ((localObject2 instanceof BasePluginActivity)) {
        localObject1 = ((BasePluginActivity)localObject2).getOutActivity();
      }
      localObject2 = new GdtHandler.Params();
      ((GdtHandler.Params)localObject2).c = 7;
      ((GdtHandler.Params)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)localObject1);
      ((GdtHandler.Params)localObject2).jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().info);
      ((GdtHandler.Params)localObject2).jdField_a_of_type_Boolean = false;
      ((GdtHandler.Params)localObject2).jdField_b_of_type_Boolean = true;
      ((GdtHandler.Params)localObject2).jdField_a_of_type_JavaLangClass = null;
      ((GdtHandler.Params)localObject2).jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForArk.class;
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
  
  public boolean a()
  {
    boolean bool = true;
    aanp.a("GdtVideoImaxFragment", "----back click");
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 1) && (getActivity() != null))
    {
      getActivity().finish();
      return true;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      str = " mWebView.goBack() result = true";
    }
    for (;;)
    {
      aanp.a("GdtVideoImaxFragment", "----back return " + bool + str);
      return bool;
      if (b())
      {
        a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height, this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height, 0.0F);
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.d();
        str = " webViewIsShowing result = true";
      }
      else if (getActivity() != null)
      {
        getActivity().finish();
        str = " getActivity().finish() result = true";
      }
      else
      {
        bool = false;
        str = "";
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {}
    do
    {
      return;
      paramActivity.setRequestedOrientation(1);
      Window localWindow = paramActivity.getWindow();
      localWindow.addFlags(1024);
      ((ViewGroup)localWindow.getDecorView()).setSystemUiVisibility(7942);
    } while (!aapa.a(paramActivity));
    aapa.a(paramActivity);
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
    aanp.a("GdtVideoImaxFragment", "onAttach() classLoader = [" + localClassLoader + "]");
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
    return paramLayoutInflater.inflate(2131559156, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.j();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 0)
    {
      this.jdField_a_of_type_Aaqp.c();
      ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeAllViewsInLayout();
      }
    }
  }
  
  public void onDetach()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 0)) {
      i();
    }
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.f();
    this.jdField_b_of_type_ComTencentAdTangramCanvasStatisticsAdTimeStatistics.stop();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.h();
    this.jdField_b_of_type_ComTencentAdTangramCanvasStatisticsAdTimeStatistics.start();
    d();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = ((GdtVideoCommonView)paramView.findViewById(2131379528));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131380115));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar = ((GdtVideoCeilingTitleBar)paramView.findViewById(2131380113));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371226);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView = ((GdtVideoCeilingLandView)paramView.findViewById(2131367065));
    a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView, this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoData());
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 1) {
      a(paramView);
    }
    for (;;)
    {
      f();
      return;
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 0)
      {
        g();
        h();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment
 * JD-Core Version:    0.7.0.1
 */