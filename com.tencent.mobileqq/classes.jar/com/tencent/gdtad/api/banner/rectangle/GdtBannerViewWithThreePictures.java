package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.GdtBannerViewBuilder;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.image.URLImageView;

final class GdtBannerViewWithThreePictures
  extends RelativeLayout
  implements GdtBannerView
{
  private GdtHandler.Params a;
  private int b = -2147483648;
  private int c = -2147483648;
  private URLImageView d;
  private URLImageView e;
  private URLImageView f;
  private ImageView g;
  
  public GdtBannerViewWithThreePictures(Context paramContext, GdtHandler.Params paramParams, int paramInt1, int paramInt2)
  {
    super(paramContext);
    if ((paramContext != null) && (paramParams != null) && (paramParams.a()) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      this.a = paramParams;
      Object localObject = new RelativeLayout.LayoutParams(-1, -2);
      paramParams = new LinearLayout(paramContext);
      paramParams.setOrientation(0);
      addView(paramParams, (ViewGroup.LayoutParams)localObject);
      this.b = paramInt1;
      this.c = paramInt2;
      localObject = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      String str1 = a().getImageData(0).a;
      String str2 = a().getImageData(1).a;
      String str3 = a().getImageData(2).a;
      this.d = new URLImageView(paramContext);
      this.d.setId(2131434091);
      this.d.setImageURL(str1);
      paramParams.addView(this.d, (ViewGroup.LayoutParams)localObject);
      this.e = new URLImageView(paramContext);
      this.e.setId(2131434092);
      this.e.setImageURL(str2);
      paramParams.addView(this.e, (ViewGroup.LayoutParams)localObject);
      this.f = new URLImageView(paramContext);
      this.f.setId(2131434093);
      this.f.setImageURL(str3);
      paramParams.addView(this.f, (ViewGroup.LayoutParams)localObject);
      paramParams = new RelativeLayout.LayoutParams(-2, -2);
      this.g = new ImageView(paramContext);
      this.g.setImageResource(2130840544);
      addView(this.g, paramParams);
      this.g.bringToFront();
      return;
    }
    GdtLog.d("GdtBannerViewWithThreePictures", "constructor");
  }
  
  private GdtAd a()
  {
    GdtHandler.Params localParams = this.a;
    if ((localParams != null) && (localParams.a())) {
      return this.a.a;
    }
    return null;
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
  
  public AdAntiSpamForClick getAntiSpamForClick()
  {
    return null;
  }
  
  public View getCloseView()
  {
    return null;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.b > 0) && (this.c > 0) && (this.d != null) && (this.e != null) && (this.f != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      int i = (GdtBannerViewBuilder.a(0, paramInt2) - GdtUIUtils.a(4.0F, getResources()) * 2) / 3;
      Object localObject = new LinearLayout.LayoutParams(i, paramInt2);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(i, paramInt2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(4.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).rightMargin = GdtUIUtils.a(4.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(i, paramInt2);
      ((LinearLayout.LayoutParams)localObject).rightMargin = -1;
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramInt1 = Double.valueOf(paramInt1 * 70 / 684).intValue();
      paramInt2 = Double.valueOf(paramInt1 * 3 / 7).intValue();
      localObject = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
        ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(6.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(6.0F, getResources());
      }
      return;
    }
    GdtLog.d("GdtBannerViewWithThreePictures", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithThreePictures
 * JD-Core Version:    0.7.0.1
 */