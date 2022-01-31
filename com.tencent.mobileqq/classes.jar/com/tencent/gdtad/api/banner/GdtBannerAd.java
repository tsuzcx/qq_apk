package com.tencent.gdtad.api.banner;

import aanu;
import aanx;
import aany;
import aanz;
import aase;
import aasp;
import android.content.Context;
import android.view.View;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;

public final class GdtBannerAd
  extends com.tencent.gdtad.api.GdtAd
{
  private aanx params;
  private boolean rendered;
  
  public GdtBannerAd(aanx paramaanx)
  {
    super(paramaanx);
    this.params = paramaanx;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()))
    {
      aase.d("GdtBannerAd", "getErrorCode error");
      return 1;
    }
    paramInt1 = paramGdtAd.getCreativeSize();
    if ((getParams().jdField_a_of_type_Int == 0) && ((paramInt1 == 65) || (paramInt1 == 184) || (paramInt1 == 193) || (paramInt1 == 194) || (paramInt1 == 210) || (paramInt1 == 285))) {
      return 0;
    }
    return 7;
  }
  
  protected aanx getParams()
  {
    return this.params;
  }
  
  public aany render(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext == null) || (paramInt1 < 0) || (paramInt2 < 0) || (!isLoaded()) || (this.rendered))
    {
      aase.d("GdtBannerAd", "render error");
      return null;
    }
    paramContext = new aanx();
    paramContext.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = this.params.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
    paramContext.jdField_a_of_type_Int = this.params.jdField_a_of_type_Int;
    paramContext.b = paramInt1;
    paramContext.c = paramInt2;
    paramContext = aanz.a(paramContext);
    if ((paramContext == null) || (paramContext.a() == null) || (aany.a == null))
    {
      aase.d("GdtBannerAd", "render error");
      return null;
    }
    this.params.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick = new GdtDwellTimeStatisticsAfterClick(getAd(), new WeakReference(paramContext.a()));
    paramContext.a().setOnClickListener(new aanu(this, paramContext));
    aasp.a(getAd().getUrlForImpression());
    notifyImpression();
    this.rendered = true;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd
 * JD-Core Version:    0.7.0.1
 */