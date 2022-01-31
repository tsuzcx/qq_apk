package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.view.View;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;
import yto;
import ytr;
import yts;
import ytt;
import yxp;
import yya;

public final class GdtBannerAd
  extends com.tencent.gdtad.api.GdtAd
{
  private ytr params;
  private boolean rendered;
  
  public GdtBannerAd(ytr paramytr)
  {
    super(paramytr);
    this.params = paramytr;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()))
    {
      yxp.d("GdtBannerAd", "getErrorCode error");
      return 1;
    }
    paramInt1 = paramGdtAd.getCreativeSize();
    if ((getParams().jdField_a_of_type_Int == 0) && ((paramInt1 == 65) || (paramInt1 == 184) || (paramInt1 == 193) || (paramInt1 == 194) || (paramInt1 == 210) || (paramInt1 == 285))) {
      return 0;
    }
    return 7;
  }
  
  protected ytr getParams()
  {
    return this.params;
  }
  
  public yts render(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext == null) || (paramInt1 < 0) || (paramInt2 < 0) || (!isLoaded()) || (this.rendered))
    {
      yxp.d("GdtBannerAd", "render error");
      return null;
    }
    paramContext = new ytr();
    paramContext.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = this.params.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
    paramContext.jdField_a_of_type_Int = this.params.jdField_a_of_type_Int;
    paramContext.b = paramInt1;
    paramContext.c = paramInt2;
    paramContext = ytt.a(paramContext);
    if ((paramContext == null) || (paramContext.a() == null) || (yts.a == null))
    {
      yxp.d("GdtBannerAd", "render error");
      return null;
    }
    this.params.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick = new GdtDwellTimeStatisticsAfterClick(getAd(), new WeakReference(paramContext.a()));
    paramContext.a().setOnClickListener(new yto(this, paramContext));
    yya.a(getAd().getUrlForImpression());
    notifyImpression();
    this.rendered = true;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd
 * JD-Core Version:    0.7.0.1
 */