package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle;
import com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleNewStyle;
import com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

public final class GdtBannerAd
  extends com.tencent.gdtad.api.GdtAd
  implements IGdtBannerAd
{
  private GdtBannerParams params;
  private boolean rendered = false;
  private float touchUpX;
  private float touchUpY;
  
  public GdtBannerAd(GdtBannerParams paramGdtBannerParams)
  {
    super(paramGdtBannerParams);
    this.params = paramGdtBannerParams;
    init();
  }
  
  private GdtBannerView a(GdtBannerParams paramGdtBannerParams)
  {
    Object localObject = null;
    if ((paramGdtBannerParams != null) && (paramGdtBannerParams.a()) && (paramGdtBannerParams.b.a()))
    {
      if (paramGdtBannerParams.c == 0) {
        if (paramGdtBannerParams.b.a.isBannerWithRectangleStyle()) {
          localObject = new GdtBannerViewWithRectangleStyle((Context)paramGdtBannerParams.b.r.get(), paramGdtBannerParams.b);
        } else if (paramGdtBannerParams.b.a.isBannerWithRectangleNewStyle()) {
          localObject = new GdtBannerViewWithRectangleNewStyle((Context)paramGdtBannerParams.b.r.get(), paramGdtBannerParams.b);
        } else {
          localObject = new GdtBannerViewWithLetterStyle((Context)paramGdtBannerParams.b.r.get(), paramGdtBannerParams.b.a);
        }
      }
      if (localObject != null) {
        ((GdtBannerView)localObject).setSize(paramGdtBannerParams.d, paramGdtBannerParams.e);
      }
      AdAnalysisHelperForUtil.reportForBanner((Context)paramGdtBannerParams.b.r.get(), paramGdtBannerParams.b.a);
      return localObject;
    }
    GdtLog.d("GdtBannerAd", "build error");
    return null;
  }
  
  private boolean a()
  {
    long l = this.params.b.a.getMinIntervalMillisBetweenExposureAndClick();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getView().onClick exp time :");
    localStringBuilder.append(l);
    GdtLog.b("GdtBannerAd", localStringBuilder.toString());
    l = Math.min(Math.max(l, 0L), 1000L);
    if (l > System.currentTimeMillis() - this.params.f)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getView().onClick return cause click unless than exp time :");
      localStringBuilder.append(l);
      GdtLog.d("GdtBannerAd", localStringBuilder.toString());
      return false;
    }
    int i = this.params.b.a.getBannerInvalidClickXPercent();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getView().onClick exp leftRightPercent :");
    localStringBuilder.append(i);
    GdtLog.b("GdtBannerAd", localStringBuilder.toString());
    i = Math.min(Math.max(i, 0), 100);
    double d1 = this.touchUpX;
    double d2 = this.params.d * i;
    Double.isNaN(d2);
    if (d1 >= d2 * 1.0D / 100.0D)
    {
      d1 = this.touchUpX;
      d2 = this.params.d * (100 - i);
      Double.isNaN(d2);
      if (d1 > d2 * 1.0D / 100.0D) {
        return false;
      }
      i = this.params.b.a.getBannerInvalidClickYPercent();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getView().onClick exp upDownPercent :");
      localStringBuilder.append(i);
      GdtLog.b("GdtBannerAd", localStringBuilder.toString());
      i = Math.min(Math.max(i, 0), 100);
      d1 = this.touchUpY;
      d2 = this.params.e * i;
      Double.isNaN(d2);
      if (d1 >= d2 * 1.0D / 100.0D)
      {
        d1 = this.touchUpY;
        d2 = this.params.e * (100 - i);
        Double.isNaN(d2);
        return d1 <= d2 * 1.0D / 100.0D;
      }
    }
    return false;
  }
  
  protected int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd != null) && (isValid()) && (getParams().a != null))
    {
      paramInt1 = paramGdtAd.getCreativeSize();
      if ((getParams().c == 0) && ((paramInt1 == 65) || (paramInt1 == 184) || (paramInt1 == 194) || (paramInt1 == 285))) {
        return 0;
      }
      return 7;
    }
    GdtLog.d("GdtBannerAd", "getErrorCode error");
    return 1;
  }
  
  protected GdtBannerParams getParams()
  {
    return this.params;
  }
  
  public void onDisplay()
  {
    GdtBannerParams localGdtBannerParams = this.params;
    if ((localGdtBannerParams != null) && (localGdtBannerParams.f == -2147483648L)) {
      this.params.f = System.currentTimeMillis();
    }
  }
  
  public GdtBannerView render(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext != null) && (paramInt1 >= 0) && (paramInt2 >= 0) && (isLoaded()) && (!this.rendered))
    {
      paramContext = this.params;
      paramContext.d = paramInt1;
      paramContext.e = paramInt2;
      paramContext = a(paramContext);
      if ((paramContext != null) && (paramContext.getView() != null) && (paramContext.getAntiSpamForClick() != null))
      {
        paramContext.getView().setOnTouchListener(new GdtBannerAd.1(this, paramContext));
        paramContext.getView().setOnClickListener(new GdtBannerAd.2(this, paramContext));
        if (paramContext.getCloseView() != null) {
          paramContext.getCloseView().setOnClickListener(new GdtBannerAd.3(this, paramContext));
        }
        this.rendered = true;
        return paramContext;
      }
      GdtLog.d("GdtBannerAd", "render error");
      return null;
    }
    GdtLog.d("GdtBannerAd", "render error");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd
 * JD-Core Version:    0.7.0.1
 */