package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class ReadInJoyAdExpandCardPic
  extends ViewBase
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private AdvertisementInfo c;
  private IReadInJoyModel d;
  private URLImageView e;
  private URLImageView f;
  private URLImageView g;
  private TextView h;
  private volatile boolean i = false;
  
  public ReadInJoyAdExpandCardPic(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = paramVafContext.getContext();
    a(this.a);
  }
  
  private URLDrawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = ViewUtils.dip2px(paramInt1);
    localURLDrawableOptions.mRequestHeight = ViewUtils.dip2px(paramInt2);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramInt3 != 0)
    {
      paramString.setTag(new int[] { 0, 0, paramInt3, 0 });
      paramString.setDecodeHandler(URLDrawableDecodeHandler.k);
    }
    return paramString;
  }
  
  private void a()
  {
    if ((this.f != null) && (this.e != null))
    {
      Object localObject1 = this.c;
      if ((localObject1 != null) && (((AdvertisementInfo)localObject1).mSinglePicture != null))
      {
        if (this.c.mSinglePicture.getPath() == null) {
          return;
        }
        Object localObject2 = this.c.mSinglePicture.getPath();
        localObject1 = a(this.c.mAdvertisementExtInfo.H, 351, 60, 16);
        localObject2 = a((String)localObject2, 351, 351, 0);
        this.f.setImageDrawable((Drawable)localObject1);
        this.e.setImageDrawable((Drawable)localObject2);
        this.g.setImageDrawable(a("https://img.nfa.qq.com/gmaster_prod/16104096/gmaster_b5gbv9fgqyg_adtagclose.png", 45, 20, 0));
        localObject1 = this.c.mAdvertisementExtInfo.J;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.b(4.0F, this.a.getResources()));
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#4D000000"));
          this.h.setBackgroundDrawable((Drawable)localObject2);
          this.h.setText((CharSequence)localObject1);
        }
      }
    }
  }
  
  private void a(Context paramContext)
  {
    paramContext = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    if (paramContext != null) {
      this.b = paramContext.inflate(2131626106, null);
    }
    paramContext = this.b;
    if (paramContext != null)
    {
      this.e = ((URLImageView)paramContext.findViewById(2131432661));
      this.f = ((URLImageView)this.b.findViewById(2131432664));
      this.g = ((URLImageView)this.b.findViewById(2131427660));
      this.h = ((TextView)this.b.findViewById(2131427743));
      this.g.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.h.setOnClickListener(this);
    }
  }
  
  private void a(View paramView1, View paramView2, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!this.i) && (paramView1 != null))
    {
      if (paramView2 == null) {
        return;
      }
      this.i = true;
      Object localObject = new AlphaAnimation(1.0F, 0.0F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(1000L);
      localAlphaAnimation.setDuration(1000L);
      paramView1.startAnimation((Animation)localObject);
      paramView2.startAnimation(localAlphaAnimation);
      paramView1.setAlpha(1.0F);
      paramView2.setAlpha(1.0F);
      paramView1.setVisibility(0);
      paramView2.setVisibility(0);
      localObject = ValueAnimator.ofFloat(new float[] { paramInt1, paramInt2 });
      ((ValueAnimator)localObject).setDuration(paramLong);
      ((ValueAnimator)localObject).addListener(new ReadInJoyAdExpandCardPic.1(this, paramView1, paramView2));
      ((ValueAnimator)localObject).addUpdateListener(new ReadInJoyAdExpandCardPic.2(this));
      ((ValueAnimator)localObject).start();
    }
  }
  
  private void b()
  {
    if ((this.e != null) && (this.f != null) && (this.b != null))
    {
      if (this.c == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetViewisClose:");
      ((StringBuilder)localObject).append(this.c.isClickClose);
      ((StringBuilder)localObject).append("isSmallCard");
      ((StringBuilder)localObject).append(this.c.isSmallCard);
      ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", ((StringBuilder)localObject).toString());
      localObject = this.c;
      if ((localObject != null) && (!((AdvertisementInfo)localObject).isClickClose))
      {
        this.f.setAlpha(1.0F);
        this.e.setAlpha(1.0F);
        if (!this.c.isSmallCard)
        {
          this.e.setVisibility(0);
          this.f.setVisibility(8);
          this.h.setVisibility(0);
          ReadInJoyAdUtils.a(this.b, ViewUtils.dip2px(351.0F));
          ReadInJoyAdUtils.a(this.e, ViewUtils.dip2px(351.0F));
          return;
        }
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        this.h.setVisibility(8);
        ReadInJoyAdUtils.a(this.b, ViewUtils.dip2px(60.0F));
      }
    }
  }
  
  private void c()
  {
    if (this.c == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("click close");
    ((StringBuilder)localObject).append(this.c.isSmallCard);
    ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", ((StringBuilder)localObject).toString());
    if (!this.c.isSmallCard)
    {
      a(this.e, this.f, 1000L, ViewUtils.dip2px(351.0F), ViewUtils.dip2px(60.0F));
      RIJAdReportManager.a(new AdReportData().a(this.d.u().a()).a(1).b(3).a(this.c).c(40));
    }
    else
    {
      RIJAdReportManager.a(new AdReportData().a(this.d.u().a()).a(1).b(3).a(this.c).c(39));
      this.c.isClickClose = true;
      setVisibility(8);
      try
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.d.k());
        this.d.u().a(0, (ArrayList)localObject, new ArrayList(), null, false, true);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("click close error");
        localStringBuilder.append(localException.getMessage());
        ReadInJoyAdLog.b("ReadInJoyAdExpandCardPic", localStringBuilder.toString());
      }
    }
    this.c.isSmallCard = true;
  }
  
  public void a(int paramInt)
  {
    if ((!this.i) && (!this.c.isSmallCard) && (this.f != null))
    {
      if (this.e == null) {
        return;
      }
      paramInt = ViewUtils.dip2px(351.0F) - paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("alphaCard");
      localStringBuilder.append(paramInt);
      ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", localStringBuilder.toString());
      if (paramInt <= 0) {
        return;
      }
      float f1 = paramInt / ViewUtils.dip2px(351.0F);
      this.f.setVisibility(0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("alphaCard showPer  ");
      localStringBuilder.append(f1);
      ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", localStringBuilder.toString());
      if (f1 < 1.0F) {
        this.e.setAlpha(f1);
      }
      this.f.setAlpha(1.0F - f1);
      this.h.setAlpha(f1);
      if (f1 < 0.25D)
      {
        this.e.setAlpha(0.0F);
        this.h.setAlpha(0.0F);
        this.f.setAlpha(1.0F);
      }
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.d = paramIReadInJoyModel;
    try
    {
      this.c = ((AdvertisementInfo)paramIReadInJoyModel.k());
      a();
      b();
      return;
    }
    catch (Exception paramIReadInJoyModel)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setModel error");
      localStringBuilder.append(paramIReadInJoyModel.getMessage());
      ReadInJoyAdLog.b("ReadInJoyAdExpandCardPic", localStringBuilder.toString());
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.b.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.b.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131427660)
    {
      c();
      return;
    }
    if (j == 2131432661)
    {
      ReadinJoyActionUtil.a(null, this.d.u().a(), this.c, this.d.u(), 0, 5);
      return;
    }
    if (j == 2131432664) {
      ReadinJoyActionUtil.a(null, this.d.u().a(), this.c, this.d.u(), 0, 1000);
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.b.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1042) {
      return super.setAttribute(paramInt, paramObject);
    }
    if (paramObject != null) {
      try
      {
        if ((paramObject instanceof AdvertisementInfo))
        {
          this.c = ((AdvertisementInfo)paramObject);
          return true;
        }
      }
      catch (Exception paramObject)
      {
        this.c = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute STR_ID_SET_AD_BANNER exception ");
        localStringBuilder.append(paramObject.toString());
        QLog.d("ReadInJoyAdExpandCardPic", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdExpandCardPic
 * JD-Core Version:    0.7.0.1
 */