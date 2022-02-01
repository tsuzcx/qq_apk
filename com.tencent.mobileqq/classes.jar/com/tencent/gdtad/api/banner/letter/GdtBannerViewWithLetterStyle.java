package com.tencent.gdtad.api.banner.letter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;

public final class GdtBannerViewWithLetterStyle
  extends FrameLayout
  implements GdtBannerView
{
  private AdAntiSpamForClick jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick = new AdAntiSpamForClick();
  private GdtBannerView jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
  
  public GdtBannerViewWithLetterStyle(Context paramContext, GdtAd paramGdtAd)
  {
    super(paramContext);
    if ((paramContext == null) || (paramGdtAd == null) || (!paramGdtAd.isValid()))
    {
      GdtLog.d("GdtBannerViewWithLetterStyle", "constructor");
      return;
    }
    setBackgroundResource(2130840382);
    int i = -2147483648;
    int j = -2147483648;
    if ((paramGdtAd.getCreativeSize() == 65) || (paramGdtAd.getCreativeSize() == 184) || (paramGdtAd.getCreativeSize() == 194)) {
      if ((paramGdtAd.getImageData() == null) || (!paramGdtAd.getImageData().a()))
      {
        paramContext = new ImageView(getContext());
        if ((paramGdtAd.getProductType() != 12) && (paramGdtAd.getProductType() != 38)) {
          break label454;
        }
        paramContext.setImageResource(2130840383);
      }
    }
    for (;;)
    {
      addView(paramContext, -1, -1);
      return;
      i = paramGdtAd.getImageData().jdField_a_of_type_Int;
      j = paramGdtAd.getImageData().b;
      for (;;)
      {
        if ((i > 0) && (j > 0)) {
          break label267;
        }
        GdtLog.d("GdtBannerViewWithLetterStyle", "createBannerViewWithLetterStyle error, image width or image height is zero");
        break;
        if (paramGdtAd.getCreativeSize() == 285)
        {
          if ((paramGdtAd.getImageData(0) == null) || (paramGdtAd.getImageData(1) == null) || (paramGdtAd.getImageData(2) == null) || (!paramGdtAd.getImageData(0).a()) || (!paramGdtAd.getImageData(1).a()) || (!paramGdtAd.getImageData(2).a())) {
            break;
          }
          i = paramGdtAd.getImageData(0).jdField_a_of_type_Int;
          j = paramGdtAd.getImageData(0).b;
        }
      }
      label267:
      if ((paramGdtAd.getCreativeSize() == 65) || (paramGdtAd.getCreativeSize() == 184)) {
        this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView = new GdtBannerViewWithOnePicturePlusOneText(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText());
      }
      for (;;)
      {
        addView(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a());
        break;
        if (paramGdtAd.getCreativeSize() == 194)
        {
          this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView = new GdtBannerViewWithOnePicturePlusTwoTexts(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText(), paramGdtAd.getDescription());
        }
        else
        {
          if (paramGdtAd.getCreativeSize() != 285) {
            break label427;
          }
          this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView = new GdtBannerViewWithThreePicturesPlusOneText(paramContext, paramGdtAd.getImageData(0).jdField_a_of_type_JavaLangString, paramGdtAd.getImageData(1).jdField_a_of_type_JavaLangString, paramGdtAd.getImageData(2).jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText());
        }
      }
      label427:
      GdtLog.d("GdtBannerViewWithLetterStyle", String.format("createBannerView error, creative size is %d", new Object[] { Integer.valueOf(paramGdtAd.getCreativeSize()) }));
      break;
      label454:
      paramContext.setImageResource(2130840384);
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
    GdtLog.b("GdtBannerViewWithLetterStyle", "pause");
    if (this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick != null) {
      this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick.setHasBeenPaused();
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a(paramContext);
  }
  
  public View b()
  {
    return null;
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithLetterStyle", "resume");
    if (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.b(paramContext);
  }
  
  public void c(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithLetterStyle", "destroy");
    if (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.c(paramContext);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView == null) || (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a() == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      GdtLog.d("GdtBannerViewWithLetterStyle", "setSize error");
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
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a().setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.setSize(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle
 * JD-Core Version:    0.7.0.1
 */