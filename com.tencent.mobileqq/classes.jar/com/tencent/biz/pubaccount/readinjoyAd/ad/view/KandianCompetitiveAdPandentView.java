package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class KandianCompetitiveAdPandentView
  extends RelativeLayout
  implements View.OnClickListener, KandianAdPandent
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new KandianCompetitiveAdPandentView.1(this));
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int = 20;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private final String jdField_b_of_type_JavaLangString = "https://img.nfa.qq.com/gmaster_prod/16169760/gmaster_3r6lkqbdi4w0_competitive_ad_close.png";
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_b_of_type_Boolean = false;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private final String jdField_c_of_type_JavaLangString = "https://img.nfa.qq.com/gmaster_prod/16171488/gmaster_36ds3mpdggs0_competitive_ad_close1.png";
  
  public KandianCompetitiveAdPandentView(Activity paramActivity, @Nullable ListView paramListView, String paramString)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramActivity.getWindow().getDecorView());
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    c();
  }
  
  public static void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3, Activity paramActivity)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = AIOUtils.b(paramInt2, paramActivity.getResources());
      localURLDrawableOptions.mRequestHeight = AIOUtils.b(paramInt3, paramActivity.getResources());
      paramActivity = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramActivity.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
      paramActivity.setDecodeHandler(URLDrawableDecodeHandler.i);
      paramURLImageView.setImageDrawable(paramActivity);
      return;
    }
    catch (Exception paramURLImageView)
    {
      label85:
      break label85;
    }
    if (QLog.isColorLevel())
    {
      paramURLImageView = new StringBuilder();
      paramURLImageView.append("后台下发的url格式有问题：");
      paramURLImageView.append(paramString);
      QLog.d("ReadInJoySuperMaskAd", 2, paramURLImageView.toString());
    }
  }
  
  private boolean a()
  {
    String str = Aladdin.getConfig(465).getString("mask_competitive_ad_btn_switch", "0");
    return (str == null) || (!str.equals("1"));
  }
  
  private void b(int paramInt)
  {
    if (!a())
    {
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = this.jdField_c_of_type_ComTencentImageURLImageView;
      float f = this.jdField_a_of_type_Float;
      a((URLImageView)localObject, "https://img.nfa.qq.com/gmaster_prod/16171488/gmaster_36ds3mpdggs0_competitive_ad_close1.png", 0, (int)(f * 45.0F), (int)(f * 45.0F), this.jdField_a_of_type_AndroidAppActivity);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(((ViewGroup.MarginLayoutParams)localObject).leftMargin, AIOUtils.b(99.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), ((ViewGroup.MarginLayoutParams)localObject).rightMargin, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      a(this.jdField_b_of_type_ComTencentImageURLImageView, "https://img.nfa.qq.com/gmaster_prod/16169760/gmaster_3r6lkqbdi4w0_competitive_ad_close.png", 0, 40, 40, this.jdField_a_of_type_AndroidAppActivity);
    }
    this.jdField_a_of_type_Int = ReadInJoyAdUtils.b((AdvertisementInfo)SuperMaskDataMgr.a.a());
    h();
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("s后消失");
    ((TextView)localObject).setText(localStringBuilder.toString());
    b();
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131560224, this, true);
    setId(2131369607);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365269));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131362129));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131362083));
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131362084));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365575));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376828);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376878));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376879);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(14.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.argb(102, 0, 0, 0));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void d()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(267L);
    localValueAnimator.addUpdateListener(new KandianCompetitiveAdPandentView.3(this));
    localValueAnimator.addListener(new KandianCompetitiveAdPandentView.4(this));
    localValueAnimator.start();
  }
  
  private void e()
  {
    Object localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(167L);
    ((ValueAnimator)localObject).addUpdateListener(new KandianCompetitiveAdPandentView.5(this));
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator1.setDuration(133L);
    localValueAnimator1.addUpdateListener(new KandianCompetitiveAdPandentView.6(this));
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator2.setDuration(133L);
    localValueAnimator2.addUpdateListener(new KandianCompetitiveAdPandentView.7(this));
    ((ValueAnimator)localObject).addListener(new KandianCompetitiveAdPandentView.8(this, localValueAnimator1));
    localValueAnimator1.addListener(new KandianCompetitiveAdPandentView.9(this, localValueAnimator2));
    ((ValueAnimator)localObject).start();
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (!a())
    {
      localObject = new GradientDrawable();
      localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator1.addUpdateListener(new KandianCompetitiveAdPandentView.10(this, (GradientDrawable)localObject, AIOUtils.b(22.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
      localValueAnimator1.setDuration(433L);
      localValueAnimator1.start();
    }
  }
  
  private void f()
  {
    a();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    Object localObject1 = SuperMaskDataMgr.a.a();
    if (!(localObject1 instanceof AdvertisementInfo)) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject1;
    localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("click data is : ");
    ((StringBuilder)localObject2).append(localAdvertisementInfo.hashCode());
    ((IRIJAdLogService)localObject1).d("ReadInJoySuperMaskAd", ((StringBuilder)localObject2).toString());
    localObject1 = localAdvertisementInfo.clone();
    if ((localObject1 instanceof AdvertisementInfo))
    {
      localObject1 = (AdvertisementInfo)localObject1;
      if (((AdvertisementInfo)localObject1).mAdAid == localAdvertisementInfo.mAdAid)
      {
        localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clone data is : ");
        localStringBuilder.append(localObject1.hashCode());
        ((IRIJAdLogService)localObject2).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
        break label169;
      }
    }
    localObject1 = localAdvertisementInfo;
    label169:
    SuperMaskReportMgr.a.b(1, localObject1);
    if (SuperMaskReportMgr.a.a()) {
      localObject2 = "clickMask";
    } else {
      localObject2 = "clickMaskNoExpose";
    }
    SuperMaskReportMgr.a.a((String)localObject2, ((AdvertisementInfo)localObject1).mAdTraceId);
    localAdvertisementInfo.clickPos = 11;
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 0, false, false, null);
    com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ((int)(AIOUtils.b(284.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) * this.jdField_a_of_type_Float));
      localURLDrawableOptions.mRequestHeight = ((int)(AIOUtils.b(504.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) * this.jdField_a_of_type_Float));
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      URLDrawable localURLDrawable = URLDrawable.getFileDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
      if (localURLDrawable == null) {
        return;
      }
      localURLDrawable.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
      localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.i);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new KandianCompetitiveAdPandentView.11(this));
      return;
    }
    catch (Exception localException)
    {
      label137:
      break label137;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "竞价蒙层加载失败");
    }
  }
  
  private void i()
  {
    long l1 = DeviceInfoUtil.j();
    long l2 = DeviceInfoUtil.i();
    if (l1 > 0L)
    {
      if (l2 <= 0L) {
        return;
      }
      int i;
      if (!a())
      {
        l1 -= AIOUtils.b(99.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        i = AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      }
      else
      {
        l1 -= AIOUtils.b(120.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        i = AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      }
      l1 -= i;
      l2 = AIOUtils.b(629.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      if (l2 < l1) {
        return;
      }
      this.jdField_a_of_type_Float = ((float)l1 * 1.0F / (float)l2);
    }
  }
  
  private void j()
  {
    i();
    Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = ((int)(AIOUtils.b(284.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) * this.jdField_a_of_type_Float));
    ((RelativeLayout.LayoutParams)localObject1).height = ((int)(AIOUtils.b(504.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).setMargins(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, (int)(AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) * this.jdField_a_of_type_Float), ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_AndroidWidgetTextView.setScaleX(this.jdField_a_of_type_Float);
    Object localObject2 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = -1;
    ((ViewGroup.LayoutParams)localObject2).height = ((int)(AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).setMargins(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, (int)(AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) * this.jdField_a_of_type_Float), ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
    this.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
  }
  
  public void a()
  {
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowing(false);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(5);
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = SuperMaskConfigMgr.a.a(((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getChannelID());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentTime = ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" lastShowMaskTime = ");
    localStringBuilder.append(l2);
    QLog.d("ReadInJoySuperMaskAd", 1, localStringBuilder.toString());
    if (SuperMaskReportMgr.a.a())
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        SuperMaskReportMgr.a.a(1, SuperMaskDataMgr.a.a());
      }
    }
    else {
      QLog.d("ReadInJoySuperMaskAd", 1, "exposure time is less than one second, do not report strict");
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(5);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    SuperMaskReportMgr.a.a("showMaskEnd", "");
    SuperMaskDataMgr.a.a();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).resetUIMgr();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369607) == null)
    {
      b(paramInt);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this);
    }
    j();
    e();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowing(true);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      SuperMaskReportMgr.a.a(2, SuperMaskDataMgr.a.a());
    }
    ThreadManager.getUIHandler().postDelayed(new KandianCompetitiveAdPandentView.2(this), 1000L);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365575: 
      g();
      return;
    case 2131362129: 
      if (!a()) {
        return;
      }
      g();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    d();
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)SuperMaskDataMgr.a.a();
    SuperMaskReportMgr.a.b(26, localAdvertisementInfo);
    if (SuperMaskReportMgr.a.a()) {
      paramView = "skipMask";
    } else {
      paramView = "skipMaskNoExpose";
    }
    SuperMaskReportMgr.a.a(paramView, localAdvertisementInfo.mAdTraceId);
  }
  
  public void setViewVisibility(int paramInt)
  {
    setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView
 * JD-Core Version:    0.7.0.1
 */