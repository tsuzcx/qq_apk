package com.tencent.gdtad.api.motivevideo;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingListener;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.URLUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GdtMVCellingStyleController
  implements View.OnClickListener, GdtVideoCeilingListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public FrameLayout a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public TouchWebView a;
  private final GdtMotiveVideoClickCoordinateReportHelper jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper = new GdtMotiveVideoClickCoordinateReportHelper();
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel;
  private final GdtMvElementsHelper jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsHelper = new GdtMvElementsHelper();
  private GdtMvMiniAppReportHelper jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper;
  private GdtMvTitleHelper jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper;
  private GdtMvViewController jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController;
  private GdtVideoCeilingLandView jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
  public GdtWebViewBuilder a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = -2147483648;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View d;
  
  public GdtMVCellingStyleController(GdtMvViewController paramGdtMvViewController, View paramView, GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController = paramGdtMvViewController;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel = paramGdtMotiveVideoModel;
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private boolean a(WebView paramWebView, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.startsWith("gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/"))
      {
        QLog.i("GdtMVCellingStyleController", 1, "handleSchema error");
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().getUrlForClick())))
      {
        QLog.i("GdtMVCellingStyleController", 1, "handleSchema urlForClick is Empty");
        return false;
      }
      String str = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().getUrlForClick();
      GdtC2SReporter.a(1, 0, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a());
      GdtReporter.doCgiReport(str);
      QLog.i("GdtMVCellingStyleController", 1, "handleSchema url= " + paramString);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsHelper.a(paramWebView, paramString);
      return true;
    }
    catch (Exception paramWebView)
    {
      QLog.e("GdtMVCellingStyleController", 1, "fitSpecialScreen", paramWebView);
    }
    return false;
  }
  
  private void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null)
    {
      QLog.i("GdtMVCellingStyleController", 1, "initWebTitle mModel == null");
      return;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsHelper.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a(), paramActivity);
    QLog.i("GdtMVCellingStyleController", 1, "initWebTitle action= " + this.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Int == 4) || (this.jdField_c_of_type_Int == 5))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      String str2;
      if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null)
      {
        paramActivity = "";
        String str1 = HardCodeUtil.a(2131705246) + paramActivity;
        str2 = HardCodeUtil.a(2131692895);
        if ((TextUtils.isEmpty(paramActivity)) || (str1.length() > str2.length())) {
          break label190;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(this.jdField_c_of_type_AndroidWidgetTextView);
        return;
        paramActivity = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().getAppName();
        break;
        label190:
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void e(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    localValueAnimator.addUpdateListener(new GdtMVCellingStyleController.1(this, localLayoutParams, localLayoutParams.topMargin, paramInt));
    localValueAnimator.setDuration(300L);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Boolean = true;
    localValueAnimator.start();
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setGdtVideoCeilingListeners(this, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
  }
  
  private void k()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int == 0)
    {
      localLayoutParams.topMargin = this.jdField_a_of_type_Int;
      a(1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Boolean = false;
      return;
      localLayoutParams.topMargin = this.jdField_b_of_type_Int;
      a(0.0F);
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().getUrlForClick())))
    {
      QLog.i("GdtMVCellingStyleController", 1, "reportBarBtnClick reportBarBtnClick is Empty");
      return;
    }
    QLog.i("GdtMVCellingStyleController", 1, "reportBarBtnClick");
    String str = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().getUrlForClick();
    GdtReporter.doCgiReport(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(str, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a(), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a(), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.b(), null));
    m();
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper != null)) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a(), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper);
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370599));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366371));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366372));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366370));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381861));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381430));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362127));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362128);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381389));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381431);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView = ((GdtVideoCeilingLandView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381856));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131381845).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381857));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372538));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131379652);
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new GdtMVCellingStyleController.2(this, paramDouble));
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a(paramFloat);
    }
    this.jdField_c_of_type_AndroidViewView.setAlpha(1.0F - paramFloat);
  }
  
  public void a(int paramInt)
  {
    QLog.i("GdtMVCellingStyleController", 1, "drag onStart");
  }
  
  protected void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsHelper.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a()));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsHelper.a(paramActivity, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a()));
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsHelper.a(paramActivity, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel));
  }
  
  public void a(Activity paramActivity, GdtMvTitleHelper paramGdtMvTitleHelper)
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper = paramGdtMvTitleHelper;
    this.jdField_b_of_type_Int = ViewUtils.b(63.0F);
    this.jdField_a_of_type_Int = ViewUtils.b(211.0F);
    a();
    b(paramActivity);
    f();
    j();
    c(paramActivity);
    a(paramActivity);
    QLog.i("GdtMVCellingStyleController", 1, "init");
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.d == null)
      {
        QLog.i("GdtMVCellingStyleController", 1, "fitSpecialScreen mTopBar == null");
        return;
      }
      if (!paramBoolean)
      {
        QLog.i("GdtMVCellingStyleController", 1, "fitSpecialScreen !isPortait");
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.e("GdtMVCellingStyleController", 1, "fitSpecialScreen", paramActivity);
      return;
    }
    LiuHaiUtils.a(paramActivity);
    if (LiuHaiUtils.b())
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.height = LiuHaiUtils.b(paramActivity);
      this.d.setLayoutParams(localLayoutParams);
      QLog.i("GdtMVCellingStyleController", 1, "fitSpecialScreen addHeight = " + localLayoutParams.height);
    }
  }
  
  public void a(GdtMvMiniAppReportHelper paramGdtMvMiniAppReportHelper)
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper = paramGdtMvMiniAppReportHelper;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
        bool1 = true;
      }
    }
    QLog.i("GdtMVCellingStyleController", 1, "onBackEvent return " + bool1);
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void b(int paramInt)
  {
    paramInt = (int)(paramInt + 0.5F) + this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getTop();
    if (paramInt > this.jdField_a_of_type_Int) {
      paramInt = this.jdField_a_of_type_Int;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      a((paramInt - this.jdField_b_of_type_Int) * 1.0F / (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int));
      return;
      if (paramInt < this.jdField_b_of_type_Int) {
        paramInt = this.jdField_b_of_type_Int;
      }
    }
  }
  
  protected void b(Activity paramActivity)
  {
    try
    {
      Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = new GdtMVCellingStyleController.3(this, paramActivity, paramActivity, null, (AppInterface)localObject);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a(null);
      new WebViewDirector(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder).a(null, (AppInterface)localObject, null);
      localObject = "";
      paramActivity = (Activity)localObject;
      if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel != null)
      {
        paramActivity = (Activity)localObject;
        if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() != null) {
          paramActivity = URLUtil.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().getUrlForLandingPage(), "xj_scene", "3");
        }
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramActivity);
      QLog.i("GdtMVCellingStyleController", 1, "initWeb url = " + paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("GdtMVCellingStyleController", 1, "initWebView", paramActivity);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    e(this.jdField_b_of_type_Int - localLayoutParams.topMargin);
  }
  
  public void c(int paramInt)
  {
    paramInt = this.jdField_b_of_type_Int;
    int i = (int)((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) * 0.5F);
    int j = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams()).topMargin;
    if (j <= i + paramInt)
    {
      paramInt = this.jdField_b_of_type_Int - j;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 2;
      if (Math.abs(paramInt) <= 0) {
        break label120;
      }
      e(paramInt);
    }
    for (;;)
    {
      QLog.i("GdtMVCellingStyleController", 1, "drag onEnd state=" + this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int);
      return;
      paramInt = this.jdField_a_of_type_Int - j;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 0;
      break;
      label120:
      k();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null)
    {
      QLog.i("GdtMVCellingStyleController", 1, "onClickOpenApp mModel == null");
      return;
    }
    Activity localActivity = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a().a();
    if (localActivity == null)
    {
      QLog.i("GdtMVCellingStyleController", 1, "onClickOpenApp activity == null");
      return;
    }
    l();
    if (this.jdField_c_of_type_Int == 5)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsHelper.a(localActivity, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a());
      return;
    }
    if (this.jdField_c_of_type_Int == 4)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsHelper.b(localActivity, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a());
      return;
    }
    QLog.i("GdtMVCellingStyleController", 1, "onClickOpenApp mModel == null");
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    localLayoutParams.topMargin = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
  }
  
  public void e()
  {
    QLog.i("GdtMVCellingStyleController", 1, "onClickBack");
    IMotiveVideoView localIMotiveVideoView;
    if (!this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.c())
    {
      localIMotiveVideoView = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a();
      if (localIMotiveVideoView == null) {
        QLog.i("GdtMVCellingStyleController", 1, "iMotiveVideoView == null");
      }
    }
    else
    {
      return;
    }
    QLog.i("GdtMVCellingStyleController", 1, "iMotiveVideoView.finish()");
    localIMotiveVideoView.a();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().vSize;
    int i;
    double d1;
    if (j == 585)
    {
      i = ViewUtils.b(375.0F);
      d1 = 1.0D;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      QLog.i("GdtMVCellingStyleController", 1, "initVideoStyle style = " + j + ",height=" + i);
      d(i);
      a(d1);
      return;
      i = ViewUtils.b(211.0F);
      d1 = 0.5625D;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.b();
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.b(true);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder != null)
      {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.c();
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = null;
      }
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeAllViewsInLayout();
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
      }
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GdtMVCellingStyleController", 1, "onDestroy", localException);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
      continue;
      e();
      continue;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMVCellingStyleController
 * JD-Core Version:    0.7.0.1
 */