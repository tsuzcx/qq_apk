package com.tencent.gdtad.api.banner.letter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;

final class GdtBannerViewWithOnePicture
  extends FrameLayout
  implements GdtBannerView
{
  private int jdField_a_of_type_Int;
  private GdtBannerImageView jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView;
  private int b;
  
  public View a()
  {
    return this;
  }
  
  public AdAntiSpamForClick a()
  {
    return null;
  }
  
  public void a(Context paramContext) {}
  
  public View b()
  {
    return null;
  }
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0) && (this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      Object localObject = new GdtBannerViewWithLetterStyle.Params(getContext(), paramInt1, paramInt2);
      double d1 = paramInt1 - ((GdtBannerViewWithLetterStyle.Params)localObject).b * 2;
      Double.isNaN(d1);
      double d2 = this.jdField_a_of_type_Int;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      d2 = this.b;
      Double.isNaN(d2);
      double d3 = ((GdtBannerViewWithLetterStyle.Params)localObject).b * 2;
      Double.isNaN(d3);
      paramInt2 = Double.valueOf(d1 * d2 + d3).intValue();
      this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setPadding(((GdtBannerViewWithLetterStyle.Params)localObject).b, ((GdtBannerViewWithLetterStyle.Params)localObject).b, ((GdtBannerViewWithLetterStyle.Params)localObject).b, ((GdtBannerViewWithLetterStyle.Params)localObject).b);
      localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    GdtLog.d("GdtBannerViewForCreativeSize193", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithOnePicture
 * JD-Core Version:    0.7.0.1
 */