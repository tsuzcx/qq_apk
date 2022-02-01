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
  private int jdField_a_of_type_Int = -2147483648;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private GdtHandler.Params jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int jdField_b_of_type_Int = -2147483648;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private URLImageView c;
  
  public GdtBannerViewWithThreePictures(Context paramContext, GdtHandler.Params paramParams, int paramInt1, int paramInt2)
  {
    super(paramContext);
    if ((paramContext != null) && (paramParams != null) && (paramParams.a()) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
      Object localObject = new RelativeLayout.LayoutParams(-1, -2);
      paramParams = new LinearLayout(paramContext);
      paramParams.setOrientation(0);
      addView(paramParams, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      localObject = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      String str1 = a().getImageData(0).a;
      String str2 = a().getImageData(1).a;
      String str3 = a().getImageData(2).a;
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131367549);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL(str1);
      paramParams.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
      this.jdField_b_of_type_ComTencentImageURLImageView.setId(2131367550);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageURL(str2);
      paramParams.addView(this.jdField_b_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
      this.c = new URLImageView(paramContext);
      this.c.setId(2131367551);
      this.c.setImageURL(str3);
      paramParams.addView(this.c, (ViewGroup.LayoutParams)localObject);
      paramParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840226);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, paramParams);
      this.jdField_a_of_type_AndroidWidgetImageView.bringToFront();
      return;
    }
    GdtLog.d("GdtBannerViewWithThreePictures", "constructor");
  }
  
  private GdtAd a()
  {
    GdtHandler.Params localParams = this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
    if ((localParams != null) && (localParams.a())) {
      return this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a;
    }
    return null;
  }
  
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
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_b_of_type_ComTencentImageURLImageView != null) && (this.c != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      int i = (GdtBannerViewBuilder.a(0, paramInt2) - GdtUIUtils.a(4.0F, getResources()) * 2) / 3;
      Object localObject = new LinearLayout.LayoutParams(i, paramInt2);
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(i, paramInt2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(4.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).rightMargin = GdtUIUtils.a(4.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(i, paramInt2);
      ((LinearLayout.LayoutParams)localObject).rightMargin = -1;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramInt1 = Double.valueOf(paramInt1 * 70 / 684).intValue();
      paramInt2 = Double.valueOf(paramInt1 * 3 / 7).intValue();
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithThreePictures
 * JD-Core Version:    0.7.0.1
 */