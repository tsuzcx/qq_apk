package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInJoyAdMiniGuide
  extends RelativeLayout
{
  private View a;
  private TextView b;
  private RelativeLayout c;
  private DiniFlyAnimationView d;
  private DiniFlyAnimationView e;
  private TextView f;
  private TextView g;
  private boolean h;
  
  public ReadInJoyAdMiniGuide(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoyAdMiniGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoyAdMiniGuide(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    inflate(paramContext, 2131626110, this);
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.d = ((DiniFlyAnimationView)findViewById(2131445747));
    this.b = ((TextView)findViewById(2131438585));
    this.c = ((RelativeLayout)findViewById(2131438584));
    this.a = findViewById(2131437976);
    this.e = ((DiniFlyAnimationView)findViewById(2131437754));
    this.f = ((TextView)findViewById(2131430436));
    this.g = ((TextView)findViewById(2131430442));
    b();
  }
  
  private void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramView.setVisibility(0);
    if (paramBoolean)
    {
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(paramInt1);
      localAlphaAnimation.setAnimationListener(new ReadInJoyAdMiniGuide.1(this, paramInt2));
      paramView.startAnimation(localAlphaAnimation);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt1);
    localAlphaAnimation.setAnimationListener(new ReadInJoyAdMiniGuide.2(this, paramView, paramInt2));
    paramView.startAnimation(localAlphaAnimation);
  }
  
  private void f()
  {
    this.a.clearAnimation();
    this.a.setVisibility(8);
    this.e.setVisibility(8);
    this.f.clearAnimation();
    this.f.setVisibility(8);
    this.g.clearAnimation();
    this.g.setVisibility(8);
    this.d.clearAnimation();
    this.d.setVisibility(0);
    this.b.clearAnimation();
    this.b.setVisibility(0);
    this.c.clearAnimation();
    this.c.setVisibility(0);
  }
  
  private void g()
  {
    a(this.d, false, 250, -1);
    a(this.b, false, 250, -1);
    a(this.c, false, 250, 0);
  }
  
  private void h()
  {
    a(this.a, true, 250, -1);
    a(this.e, true, 250, -1);
    a(this.f, true, 250, -1);
    a(this.g, true, 250, 1);
  }
  
  private void i()
  {
    a(this.a, false, 250, -1);
    a(this.e, false, 250, -1);
    a(this.f, false, 250, -1);
    a(this.g, false, 250, 2);
  }
  
  private void j()
  {
    a(this.d, true, 250, -1);
    a(this.b, true, 250, -1);
    a(this.c, true, 250, 3);
  }
  
  public void a()
  {
    this.e.setAnimation("qb_public_account_readinjoy_ad_shake/data.json");
    this.e.setImageAssetsFolder("qb_public_account_readinjoy_ad_shake/images");
    this.e.setRepeatCount(-1);
    this.e.playAnimation();
    ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).reportBigGuideShow();
    new Handler(Looper.getMainLooper()).postDelayed(new ReadInJoyAdMiniGuide.3(this), 2000L);
  }
  
  public void b()
  {
    if (this.d.isAnimating()) {
      return;
    }
    this.d.setAnimation("qb_public_account_readinjoy_ad_shake/data.json");
    this.d.setImageAssetsFolder("qb_public_account_readinjoy_ad_shake/images");
    this.d.setRepeatCount(-1);
    this.d.playAnimation();
  }
  
  public void c()
  {
    this.h = false;
    f();
  }
  
  public void d()
  {
    c();
    setVisibility(8);
  }
  
  public void e()
  {
    this.h = true;
    ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).setGuideView(this);
    f();
    g();
  }
  
  public void setAdShakeInfo(VideoPlayParam paramVideoPlayParam)
  {
    Object localObject = (AdvertisementInfo)paramVideoPlayParam.D;
    paramVideoPlayParam = ((AdvertisementInfo)localObject).shakeTitle;
    localObject = ((AdvertisementInfo)localObject).shakeDiscription;
    this.f.setText("摇动手机");
    if (!TextUtils.isEmpty(paramVideoPlayParam)) {
      this.f.setText(paramVideoPlayParam);
    } else {
      paramVideoPlayParam = "摇动手机";
    }
    this.g.setText("");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.g.setText((CharSequence)localObject);
    }
    if (TextUtils.isEmpty(paramVideoPlayParam)) {
      this.b.setText("摇动手机");
    } else {
      this.b.setText(paramVideoPlayParam);
    }
    b();
    ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).reportMiniGuideShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdMiniGuide
 * JD-Core Version:    0.7.0.1
 */