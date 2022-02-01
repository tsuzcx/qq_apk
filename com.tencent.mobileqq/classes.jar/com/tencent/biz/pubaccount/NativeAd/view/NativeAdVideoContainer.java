package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.data.NativeAdVideoSetting;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class NativeAdVideoContainer
  extends RelativeLayout
  implements View.OnClickListener, ReadInJoyNativeAdAppVideoView.VideoFullScreenListener
{
  private Context a;
  private AdModuleVideo b;
  private ReadInJoyNativeAdAppVideoView c;
  private AdvertisementInfo d;
  private RelativeLayout e;
  private ReadInJoyHeadImageView f;
  private LinearLayout g;
  private LinearLayout h;
  private TextView i;
  private TextView j;
  private AdRatingBar k;
  private ImageView l;
  private RelativeLayout m;
  private ReadInJoyHeadImageView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private SeekBar r;
  private NativeAdVideoContainer.VideoFullScreenListener s;
  private TextView t;
  
  public NativeAdVideoContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NativeAdVideoContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NativeAdVideoContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    inflate(getContext(), 2131626118, this);
    this.c = ((ReadInJoyNativeAdAppVideoView)findViewById(2131427761));
    paramContext = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    paramContext.height = ((int)(getResources().getDisplayMetrics().widthPixels * 0.5626F));
    this.c.setLayoutParams(paramContext);
    this.c.setOnVideoFullScreen(this);
    g();
    h();
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt, Integer paramInteger)
  {
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(1).b(17).b(paramInteger).a(paramAdvertisementInfo).c(paramInt));
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView.getId();
    Object localObject = new AdJumpParams();
    ((AdJumpParams)localObject).b = true;
    localObject = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(this.a, this.d, null, 4, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickBtn(paramInt), (AdJumpParams)localObject);
    localObject = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(localObject, this.a, this.d);
    int i1 = paramView.getId();
    if ((i1 != 2131427753) && (i1 != 2131427712))
    {
      if ((i1 != 2131427757) && (i1 != 2131427714))
      {
        if (i1 == 2131427718) {
          paramInt = 4;
        } else if ((i1 == 2131427755) || (i1 == 2131427691) || (i1 == 2131437795)) {
          paramInt = 8;
        }
      }
      else {
        paramInt = 3;
      }
    }
    else {
      paramInt = 2;
    }
    a(this.a, this.d, paramInt, (Integer)localObject);
  }
  
  private void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
    try
    {
      localObject = URLDrawable.getDrawable(new URL(this.d.mAdCorporateLogo), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
      paramReadInJoyHeadImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramReadInJoyHeadImageView)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resetHeadImage() ERROR e = ");
        ((StringBuilder)localObject).append(paramReadInJoyHeadImageView.getMessage());
        QLog.d("NativeAdVideoContainer", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void g()
  {
    this.e = ((RelativeLayout)findViewById(2131427719));
    this.f = ((ReadInJoyHeadImageView)findViewById(2131427753));
    this.i = ((TextView)findViewById(2131427757));
    this.j = ((TextView)findViewById(2131427755));
    this.h = ((LinearLayout)findViewById(2131437795));
    this.l = ((ImageView)findViewById(2131427756));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.l.getLayoutParams();
    localLayoutParams.leftMargin = AIOUtils.b(3.0F, this.a.getResources());
    this.l.setLayoutParams(localLayoutParams);
    this.h.setOnClickListener(this);
    this.k = ((AdRatingBar)findViewById(2131444173));
    this.g = ((LinearLayout)findViewById(2131437803));
    this.t = ((TextView)findViewById(2131427717));
    this.f.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  private void h()
  {
    this.m = ((RelativeLayout)findViewById(2131427721));
    this.n = ((ReadInJoyHeadImageView)findViewById(2131427712));
    this.o = ((TextView)findViewById(2131427714));
    this.p = ((TextView)findViewById(2131427718));
    this.r = ((SeekBar)findViewById(2131435795));
    this.q = ((TextView)findViewById(2131427691));
    this.r.setProgress(0);
    this.r.setEnabled(false);
    this.r.setVisibility(0);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.m.setOnClickListener(this);
  }
  
  private void i()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((AdvertisementInfo)localObject).mAdCorporateLogo))
      {
        a(this.f);
        a(this.n);
      }
      else
      {
        this.n.setVisibility(8);
        this.f.setVisibility(8);
      }
      if (!TextUtils.isEmpty(this.d.mAdCorporateImageName))
      {
        this.o.setText(this.d.mAdCorporateImageName);
        this.i.setText(this.d.mAdCorporateImageName);
      }
      if (!TextUtils.isEmpty(this.d.mAdTxt))
      {
        this.p.setVisibility(0);
        this.p.setText(this.d.mAdTxt);
      }
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(this.d)) && (this.d.mAdScoreNum >= 8))
      {
        this.k.setVisibility(0);
        this.k.setStar(this.d.mAdScoreNum / 2.0F);
      }
      else
      {
        this.k.setVisibility(8);
      }
      localObject = ReadInJoyAdUtils.g(this.d);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.t.setText((CharSequence)localObject);
        this.t.setVisibility(0);
        return;
      }
      this.t.setVisibility(8);
    }
  }
  
  public void a()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.c;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.b();
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    a(paramView, 9);
  }
  
  public void a(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, AppInterface paramAppInterface)
  {
    this.b = paramAdModuleVideo;
    this.d = paramAdvertisementInfo;
    NativeAdVideoSetting localNativeAdVideoSetting = new NativeAdVideoSetting();
    localNativeAdVideoSetting.a = false;
    localNativeAdVideoSetting.b = true;
    localNativeAdVideoSetting.c = true;
    localNativeAdVideoSetting.d = false;
    this.c.setAdSetting(localNativeAdVideoSetting);
    this.c.setVideoData(paramAdModuleVideo, paramAdvertisementInfo, paramAppInterface);
    this.c.a(this.a);
    this.k.setVisibility(8);
    i();
  }
  
  public void b()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.c;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.b(getContext());
    }
  }
  
  public void c()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.c;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.a();
    }
  }
  
  public void d()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((ReadInJoyNativeAdAppVideoView)localObject).c()))
    {
      this.e.setVisibility(0);
      this.m.setVisibility(0);
      this.c.setisFullScreen(false, 8);
      localObject = this.s;
      if (localObject != null) {
        ((NativeAdVideoContainer.VideoFullScreenListener)localObject).a();
      }
    }
  }
  
  public void e()
  {
    Object localObject = this.c;
    if ((localObject != null) && (!((ReadInJoyNativeAdAppVideoView)localObject).c()))
    {
      this.e.setVisibility(4);
      this.m.setVisibility(4);
      this.c.setisFullScreen(true, 8);
      localObject = this.s;
      if (localObject != null) {
        ((NativeAdVideoContainer.VideoFullScreenListener)localObject).b();
      }
    }
  }
  
  public boolean f()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.c;
    if (localReadInJoyNativeAdAppVideoView != null) {
      return localReadInJoyNativeAdAppVideoView.c();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    a(paramView, 1000);
  }
  
  public void setOnVideoFullScreen(NativeAdVideoContainer.VideoFullScreenListener paramVideoFullScreenListener)
  {
    this.s = paramVideoFullScreenListener;
  }
  
  public void setVideoPlayPositon(long paramLong)
  {
    this.c.setVideoPlayPositon(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdVideoContainer
 * JD-Core Version:    0.7.0.1
 */