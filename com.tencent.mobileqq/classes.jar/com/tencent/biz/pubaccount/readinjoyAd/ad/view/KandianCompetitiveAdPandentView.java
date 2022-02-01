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
  private Activity a;
  private TextView b;
  private URLImageView c;
  private URLImageView d;
  private URLImageView e;
  private TextView f;
  private LinearLayout g;
  private View h;
  private View i;
  private int j;
  private ViewGroup k;
  private boolean l = false;
  private ListView m;
  private String n;
  private float o = 1.0F;
  private boolean p = false;
  private final String q = "https://img.nfa.qq.com/gmaster_prod/16169760/gmaster_3r6lkqbdi4w0_competitive_ad_close.png";
  private final String r = "https://img.nfa.qq.com/gmaster_prod/16171488/gmaster_36ds3mpdggs0_competitive_ad_close1.png";
  private final int s = 20;
  private Handler t = new Handler(new KandianCompetitiveAdPandentView.1(this));
  private AtomicBoolean u = new AtomicBoolean(false);
  private AtomicBoolean v = new AtomicBoolean(false);
  
  public KandianCompetitiveAdPandentView(Activity paramActivity, @Nullable ListView paramListView, String paramString)
  {
    super(paramActivity);
    this.a = paramActivity;
    this.k = ((ViewGroup)paramActivity.getWindow().getDecorView());
    this.n = paramString;
    this.m = paramListView;
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
      paramActivity.setDecodeHandler(URLDrawableDecodeHandler.j);
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
  
  private void b(int paramInt)
  {
    if (!d())
    {
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      localObject = this.e;
      float f1 = this.o;
      a((URLImageView)localObject, "https://img.nfa.qq.com/gmaster_prod/16171488/gmaster_36ds3mpdggs0_competitive_ad_close1.png", 0, (int)(f1 * 45.0F), (int)(f1 * 45.0F), this.a);
      localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(((ViewGroup.MarginLayoutParams)localObject).leftMargin, AIOUtils.b(99.0F, this.a.getResources()), ((ViewGroup.MarginLayoutParams)localObject).rightMargin, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      a(this.d, "https://img.nfa.qq.com/gmaster_prod/16169760/gmaster_3r6lkqbdi4w0_competitive_ad_close.png", 0, 40, 40, this.a);
    }
    this.j = ReadInJoyAdUtils.o((AdvertisementInfo)SuperMaskDataMgr.a.a());
    i();
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append("s后消失");
    ((TextView)localObject).setText(localStringBuilder.toString());
    b();
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131626271, this, true);
    setId(2131436715);
    this.b = ((TextView)findViewById(2131431442));
    this.c = ((URLImageView)findViewById(2131427708));
    this.d = ((URLImageView)findViewById(2131427661));
    this.e = ((URLImageView)findViewById(2131427662));
    this.f = ((TextView)findViewById(2131431802));
    this.i = findViewById(2131445159);
    this.g = ((LinearLayout)findViewById(2131445220));
    this.h = findViewById(2131445221);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(14.0F, this.a.getResources()));
    localGradientDrawable.setColor(Color.argb(102, 0, 0, 0));
    this.b.setBackgroundDrawable(localGradientDrawable);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  private boolean d()
  {
    String str = Aladdin.getConfig(465).getString("mask_competitive_ad_btn_switch", "0");
    return (str == null) || (!str.equals("1"));
  }
  
  private void e()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(267L);
    localValueAnimator.addUpdateListener(new KandianCompetitiveAdPandentView.3(this));
    localValueAnimator.addListener(new KandianCompetitiveAdPandentView.4(this));
    localValueAnimator.start();
  }
  
  private void f()
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
    this.c.setVisibility(0);
    if (!d())
    {
      localObject = new GradientDrawable();
      localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator1.addUpdateListener(new KandianCompetitiveAdPandentView.10(this, (GradientDrawable)localObject, AIOUtils.b(22.0F, this.a.getResources())));
      localValueAnimator1.setDuration(433L);
      localValueAnimator1.start();
    }
  }
  
  private void g()
  {
    a();
  }
  
  private void getScaleRatio()
  {
    long l1 = DeviceInfoUtil.E();
    long l2 = DeviceInfoUtil.D();
    if (l1 > 0L)
    {
      if (l2 <= 0L) {
        return;
      }
      int i1;
      if (!d())
      {
        l1 -= AIOUtils.b(99.0F, this.a.getResources());
        i1 = AIOUtils.b(20.0F, this.a.getResources());
      }
      else
      {
        l1 -= AIOUtils.b(120.0F, this.a.getResources());
        i1 = AIOUtils.b(20.0F, this.a.getResources());
      }
      l1 -= i1;
      l2 = AIOUtils.b(629.0F, this.a.getResources());
      if (l2 < l1) {
        return;
      }
      this.o = ((float)l1 * 1.0F / (float)l2);
    }
  }
  
  private void h()
  {
    this.t.removeMessages(1);
    this.t.sendEmptyMessage(2);
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
    if (SuperMaskReportMgr.a.b()) {
      localObject2 = "clickMask";
    } else {
      localObject2 = "clickMaskNoExpose";
    }
    SuperMaskReportMgr.a.a((String)localObject2, ((AdvertisementInfo)localObject1).mAdTraceId);
    localAdvertisementInfo.clickPos = 11;
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport(this.a, localAdvertisementInfo, null, 0, false, false, null);
    com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil.a = false;
  }
  
  private void i()
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ((int)(AIOUtils.b(284.0F, this.a.getResources()) * this.o));
      localURLDrawableOptions.mRequestHeight = ((int)(AIOUtils.b(504.0F, this.a.getResources()) * this.o));
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      URLDrawable localURLDrawable = URLDrawable.getFileDrawable(this.n, localURLDrawableOptions);
      if (localURLDrawable == null) {
        return;
      }
      localURLDrawable.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, AIOUtils.b(30.0F, this.a.getResources())));
      localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
      this.c.setImageDrawable(localURLDrawable);
      this.c.setURLDrawableDownListener(new KandianCompetitiveAdPandentView.11(this));
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
  
  private void j()
  {
    getScaleRatio();
    Object localObject1 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = ((int)(AIOUtils.b(284.0F, this.a.getResources()) * this.o));
    ((RelativeLayout.LayoutParams)localObject1).height = ((int)(AIOUtils.b(504.0F, this.a.getResources()) * this.o));
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).setMargins(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, (int)(AIOUtils.b(20.0F, this.a.getResources()) * this.o), ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.f.setScaleX(this.o);
    Object localObject2 = this.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = -1;
    ((ViewGroup.LayoutParams)localObject2).height = ((int)(AIOUtils.b(16.0F, this.a.getResources()) * this.o));
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).setMargins(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, (int)(AIOUtils.b(30.0F, this.a.getResources()) * this.o), ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject2);
  }
  
  public void a()
  {
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowing(false);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(5);
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = SuperMaskConfigMgr.a.c(((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getChannelID());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentTime = ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" lastShowMaskTime = ");
    localStringBuilder.append(l2);
    QLog.d("ReadInJoySuperMaskAd", 1, localStringBuilder.toString());
    if (SuperMaskReportMgr.a.b())
    {
      if (this.v.compareAndSet(false, true)) {
        SuperMaskReportMgr.a.a(1, SuperMaskDataMgr.a.a());
      }
    }
    else {
      QLog.d("ReadInJoySuperMaskAd", 1, "exposure time is less than one second, do not report strict");
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(5);
    if (this.t != null) {
      this.t = null;
    }
    SuperMaskReportMgr.a.a("showMaskEnd", "");
    SuperMaskDataMgr.a.f();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).resetUIMgr();
  }
  
  public void a(int paramInt)
  {
    if (this.k.findViewById(2131436715) == null)
    {
      b(paramInt);
      this.k.addView(this);
    }
    j();
    f();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowing(true);
    if (this.u.compareAndSet(false, true)) {
      SuperMaskReportMgr.a.a(2, SuperMaskDataMgr.a.a());
    }
    ThreadManager.getUIHandler().postDelayed(new KandianCompetitiveAdPandentView.2(this), 1000L);
  }
  
  public void b()
  {
    this.t.sendEmptyMessageDelayed(1, 1000L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131431802: 
      h();
      return;
    case 2131427708: 
      if (!d()) {
        return;
      }
      h();
      return;
    }
    this.t.removeMessages(1);
    e();
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)SuperMaskDataMgr.a.a();
    SuperMaskReportMgr.a.b(26, localAdvertisementInfo);
    if (SuperMaskReportMgr.a.b()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView
 * JD-Core Version:    0.7.0.1
 */