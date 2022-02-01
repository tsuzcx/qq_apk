package com.tencent.gdtad.api.banner.letter;

import acal;
import acbl;
import acbq;
import acbr;
import acho;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtAd;

public final class GdtBannerViewWithLetterStyle
  extends FrameLayout
  implements acbl
{
  private acbl jdField_a_of_type_Acbl;
  private AdAntiSpamForClick jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick = new AdAntiSpamForClick();
  
  public GdtBannerViewWithLetterStyle(Context paramContext, GdtAd paramGdtAd)
  {
    super(paramContext);
    if ((paramContext == null) || (paramGdtAd == null) || (!paramGdtAd.isValid()))
    {
      acho.d("GdtBannerViewWithLetterStyle", "constructor");
      return;
    }
    setBackgroundResource(2130840278);
    label102:
    int i;
    if ((paramGdtAd.getImageData() == null) || (!paramGdtAd.getImageData().a()))
    {
      paramContext = new ImageView(getContext());
      if ((paramGdtAd.getProductType() == 12) || (paramGdtAd.getProductType() == 38))
      {
        paramContext.setImageResource(2130840279);
        addView(paramContext, -1, -1);
      }
    }
    else
    {
      if (paramGdtAd.getImageData() == null) {
        break label293;
      }
      i = paramGdtAd.getImageData().jdField_a_of_type_Int;
      j = paramGdtAd.getImageData().b;
    }
    for (;;)
    {
      if ((i <= 0) || (j <= 0))
      {
        acho.d("GdtBannerViewWithLetterStyle", "createBannerViewWithLetterStyle error, image width or image height is zero");
        break;
      }
      if ((paramGdtAd.getCreativeSize() == 65) || (paramGdtAd.getCreativeSize() == 184)) {}
      for (this.jdField_a_of_type_Acbl = new acbq(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText());; this.jdField_a_of_type_Acbl = new acbr(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText(), paramGdtAd.getDescription()))
      {
        addView(this.jdField_a_of_type_Acbl.a());
        break;
        if (paramGdtAd.getCreativeSize() != 194) {
          break label257;
        }
      }
      label257:
      acho.d("GdtBannerViewWithLetterStyle", String.format("createBannerView error, creative size is %d", new Object[] { Integer.valueOf(paramGdtAd.getCreativeSize()) }));
      break;
      paramContext.setImageResource(2130840280);
      break label102;
      label293:
      i = -2147483648;
    }
  }
  
  public View a()
  {
    return this;
  }
  
  public AdAntiSpamForClick a()
  {
    return this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick;
  }
  
  public void a(Context paramContext)
  {
    acho.b("GdtBannerViewWithLetterStyle", "pause");
    if (this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick != null) {
      this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick.setHasBeenPaused();
    }
    if (this.jdField_a_of_type_Acbl == null) {
      return;
    }
    this.jdField_a_of_type_Acbl.a(paramContext);
  }
  
  public View b()
  {
    return null;
  }
  
  public void b(Context paramContext)
  {
    acho.b("GdtBannerViewWithLetterStyle", "resume");
    if (this.jdField_a_of_type_Acbl == null) {
      return;
    }
    this.jdField_a_of_type_Acbl.b(paramContext);
  }
  
  public void c(Context paramContext)
  {
    acho.b("GdtBannerViewWithLetterStyle", "destroy");
    if (this.jdField_a_of_type_Acbl == null) {
      return;
    }
    this.jdField_a_of_type_Acbl.c(paramContext);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Acbl == null) || (this.jdField_a_of_type_Acbl.a() == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      acho.d("GdtBannerViewWithLetterStyle", "setSize error");
      return;
    }
    int i = Double.valueOf(0.7076023391812866D * paramInt1).intValue();
    int j = Double.valueOf(0.9036144578313253D * paramInt2).intValue();
    paramInt1 = Double.valueOf((paramInt1 - i) * 1.0D / 2.0D).intValue();
    paramInt2 = Double.valueOf((paramInt2 - j) * 1.0D / 2.0D).intValue();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = paramInt2;
    localLayoutParams.bottomMargin = paramInt2;
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = paramInt1;
    this.jdField_a_of_type_Acbl.a().setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Acbl.setSize(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle
 * JD-Core Version:    0.7.0.1
 */