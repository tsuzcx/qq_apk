package com.tencent.gdtad.api.banner;

import android.content.Context;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

public final class GdtBannerViewBuilder
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    GdtLog.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static GdtBannerView a(GdtBannerParams paramGdtBannerParams)
  {
    if ((paramGdtBannerParams == null) || (!paramGdtBannerParams.a()) || (!paramGdtBannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()))
    {
      GdtLog.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    if (paramGdtBannerParams.jdField_a_of_type_Int == 0) {}
    for (GdtBannerViewWithLetterStyle localGdtBannerViewWithLetterStyle = new GdtBannerViewWithLetterStyle((Context)paramGdtBannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramGdtBannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);; localGdtBannerViewWithLetterStyle = null)
    {
      if (localGdtBannerViewWithLetterStyle != null) {
        localGdtBannerViewWithLetterStyle.setSize(paramGdtBannerParams.b, paramGdtBannerParams.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramGdtBannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramGdtBannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localGdtBannerViewWithLetterStyle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerViewBuilder
 * JD-Core Version:    0.7.0.1
 */